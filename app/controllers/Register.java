package controllers;

import play.mvc.Controller;
import play.mvc.With;
import play.libs.OpenID;
import play.libs.OpenID.UserInfo;
import service.UserService;
import models.User;

@With(Authentication.class)
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
			User user = new User();
			String nickname = session.get(Authentication.USER_ID).substring(33);
			user.setDisplayname(displayname);
			user.setFullname(fullname);
			user.setNickname(nickname);
			user.setOpenId(session.get("user"));
			UserService.storeUser(user);
			redirect("/");
		}
	}
}
