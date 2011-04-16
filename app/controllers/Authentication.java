package controllers;

import play.Logger;
import play.Play;
import play.libs.OpenID;
import play.libs.OpenID.UserInfo;
import play.mvc.Before;
import play.mvc.Controller;
import service.UserService;
import utils.Redirect;

public class Authentication extends Controller {

	public static final String USER_ID = "UserID";
	public static final String USER_NICKNAME = "UserNickname";

	@Before(unless = { "login", "authenticateOpenID", "Register.register", "Register.saveUser" })
	public static void checkAuthenticated() {
		if ( !session.contains(USER_ID) ) {
			login();
		}
	}

	public static void login() {
		if ( !session.contains(USER_ID) ) {
			render();
		} else {
			Redirect.in_app("GlobalTimeline.timeline");
		}
	}

	public static void logout() {
		session.clear();
		Redirect.in_app("GlobalTimeline.timeline");
	}

	public static void authenticateOpenID(String openId) {
		if ( OpenID.isAuthenticationResponse() ) {
			UserInfo verifiedUser = OpenID.getVerifiedID();
			if ( verifiedUser == null ) {
				flash.error("Oops. Authentication has failed");
				login();
			}
			if ( UserService.getUserByOpenId(verifiedUser.id) == null ) {
				session.put(USER_ID + "_temp", verifiedUser.id);
				Redirect.in_app("Register.register");
			} else {
				models.User user = UserService.getUserByOpenId(verifiedUser.id);
				session.put(USER_ID, verifiedUser.id);
				session.put(USER_NICKNAME, user.getNickname());
				Redirect.in_app("GlobalTimeline.timeline");
			}
		} else {
			String openIdPrefix = Play.configuration.getProperty("milk.openid.prefix", "");
			if ( !"".equals(openIdPrefix) ) {
				openId = openIdPrefix + openId;
			}
			Logger.info("Redirecting User to verify his openid '%s'", openId);
			if ( !OpenID.id(openId).verify() ) { // will redirect the user
				flash.error("Cannot verify your OpenID");
				login();
			}
		}
	}
}
