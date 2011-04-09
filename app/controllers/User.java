package controllers;

import play.mvc.Controller;
import play.mvc.With;
import service.UserService;


@With(Authentication.class)
public class User extends Controller {
	
	public static void profile(String username) {
		
		
		models.User personalUser =  UserService.getUserByOpenId(session.get("user"));
		
		render(username, personalUser);
	
	}
	
	public static void edit(String username) {
		render(username);
	}
	

}
