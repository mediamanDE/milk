package controllers;

import play.mvc.Controller;
import play.mvc.With;

@With(Authentication.class)
public class Group extends Controller {

	public static void overview() {
		render();
	}
	
	public static void timeline(String groupname){
		render();
	}
	
	public static void edit(String groupname){
		render();
	}
	
	public static void create(){
		render();
	}
	
}
