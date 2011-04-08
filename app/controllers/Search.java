package controllers;

import play.mvc.Controller;
import play.mvc.With;

@With(Authentication.class)
public class Search extends Controller {
	
	public static void search() {
		render();
	}

}
