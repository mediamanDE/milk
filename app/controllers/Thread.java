package controllers;

import play.mvc.Controller;
import play.mvc.With;

@With(Authentication.class)
public class Thread extends Controller {
	
	public static void conversation() {
		render();
	}

}
