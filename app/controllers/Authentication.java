package controllers;

import play.libs.OpenID;
import play.libs.OpenID.UserInfo;
import play.mvc.Before;
import play.mvc.Controller;
import service.UserService;

public class Authentication extends Controller {
	
	public static final String USER_ID = "UserID";
	
	@Before(unless={"login", "authenticateOpenID"})
	public static void checkAuthenticated() {
	    if(!session.contains("user")) {
	        login();
	    }
	}
	     
	public static void login() {
		if(!session.contains("user")) {
			render();
		}else{
			GlobalTimeline.timeline();
		}
	}
	
	public static void logout(){
		session.clear();
		redirect("/");
	}
	
	public static void authenticateOpenID(String openID) {
		if(OpenID.isAuthenticationResponse()) {
	        UserInfo verifiedUser = OpenID.getVerifiedID();
	        if(verifiedUser == null) {
	            flash.error("Oops. Authentication has failed");
	            login();
	        } 
	        if(UserService.getUserByOpenId(verifiedUser.id) == null){
	        	redirect("/register/");
	        }else{
	        	session.put(USER_ID, verifiedUser.id);
		        redirect("/");
	        }
	    } else {
	        if(!OpenID.id(openID).verify()) { // will redirect the user
	            flash.error("Cannot verify your OpenID");
	            login();
	        } 
	    }
	}
}
