package controllers;

import play.libs.OpenID;
import play.libs.OpenID.UserInfo;
import play.mvc.Before;
import play.mvc.Controller;
import service.UserService;
import utils.Redirect;

public class Authentication extends Controller {
	
	public static final String USER_ID = "UserID";
	
	@Before(unless={"login", "authenticateOpenID","register"})
	public static void checkAuthenticated() {
	    if(!session.contains(USER_ID)) {
	        login();
	    }
	}
	     
	public static void login() {
		if(!session.contains(USER_ID)) {
			render();
		}else{
			Redirect.in_app("GlobalTimeline.timeline");
		}
	}
	
	public static void logout(){
		session.clear();
		Redirect.in_app("GlobalTimeline.timeline");
	}
	
	public static void authenticateOpenID(String openID) {
		if(OpenID.isAuthenticationResponse()) {
	        UserInfo verifiedUser = OpenID.getVerifiedID();
	        if(verifiedUser == null) {
	            flash.error("Oops. Authentication has failed");
	            login();
	        }
	        if(UserService.getUserByOpenId(verifiedUser.id) == null){
	        	session.put(USER_ID + "_temp", verifiedUser.id);
				Redirect.in_app("Register.register");
	        }else{
	        	session.put(USER_ID, verifiedUser.id);
				Redirect.in_app("GlobalTimeline.timeline");
	        }
	    } else {
	        if(!OpenID.id(openID).verify()) { // will redirect the user
	            flash.error("Cannot verify your OpenID");
	            login();
	        } 
	    }
	}
}
