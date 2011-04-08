package controllers;

import play.mvc.Controller;
import play.mvc.With;

@With(Authentication.class)
public class User extends Controller {
	
	public static void profile(String username) {
		render(username);
	}
	
	public static void edit(String username) {
		render(username);
	}
	

}
