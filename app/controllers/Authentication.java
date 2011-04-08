package controllers;

import play.Logger;
import play.libs.OpenID;
import play.libs.OpenID.*;
import play.mvc.Before;
import play.mvc.Controller;

public class Authentication extends Controller {

	@Before(unless = { "login", "authenticate" })
	public static void checkAuthenticated() {
		if (!session.contains("user")) {
			login();
		}
	}

	public static void login() {
		render();
	}

	public static void logout() {
		session.clear();
		redirect("/");
	}

	public static void authenticate(String user) {
		if (OpenID.isAuthenticationResponse()) {
			UserInfo verifiedUser = OpenID.getVerifiedID();
			if (verifiedUser == null) {
				flash.error("Oops. Authentication has failed");
				login();
			}
			session.put("user", verifiedUser.id);

			int x, y;
			//temporary while app is not connected to db
			x = 5;
			y = 6;
			// if db is connected to app, change the condition. the condition will decide, if a user has the required fields filled in
			if(y == x){
				redirect("/register/");
			}
			redirect("/");
		} else {
			if (!OpenID.id(user).verify()) { // will redirect the user
				flash.error("Cannot verify your OpenID");
				login();
			}
		}
	}
}
