package controllers;

import play.mvc.Controller;
import play.mvc.With;

@With(Authentication.class)
public class Application extends Controller {

    public static void index() {
        render();
    }

}