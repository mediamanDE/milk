package controllers;

import play.mvc.Controller;

public class User extends Controller {
	
	public static void profile(String username) {
		render(username);
	}
	
	public static void edit() {
		render();
	}
	

}
