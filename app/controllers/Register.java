package controllers;

import play.mvc.Controller;
import play.mvc.With;
import play.libs.OpenID;
import play.libs.OpenID.UserInfo;
import service.UserService;
import models.User;

public class Register extends Controller {

	public static void register() {
		render();
	}

	public void currentFields() {

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
			redirect("/");
		}
	}
}
