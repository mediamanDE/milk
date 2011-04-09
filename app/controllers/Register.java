package controllers;

import models.User;
import play.mvc.Controller;
import play.mvc.With;
import service.UserService;
import utils.Redirect;

@With(Authentication.class)
public class Register extends Controller {

	public static void register() {
		render();
	}

	public static void saveUser(String fullname, String displayname) {

		validation.required(fullname);
		validation.required(displayname);
		
		if (validation.hasErrors()) {
			for (play.data.validation.Error error : validation.errors()) {
				flash.error(error.message());
			}
			register();
		} else {
			session.put(Authentication.USER_ID, session.get(Authentication.USER_ID + "_temp"));
			session.remove(Authentication.USER_ID + "_temp");
			
			User user = new User();
			user.setOpenId(session.get(Authentication.USER_ID));
			user.setDisplayname(displayname);
			user.setFullname(fullname);
			user.setNickname(session.get(Authentication.USER_ID).substring(33));
			UserService.storeUser(user);
			Redirect.in_app("GlobalTimeline.timeline");
		}
	}
}
