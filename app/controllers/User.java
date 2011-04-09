package controllers;

import java.util.*;
import models.Message;
import play.mvc.Controller;
import play.mvc.With;
import service.MessageService;
import service.TimelineService;
import service.UserService;

@With(Authentication.class)
public class User extends Controller {

	public static void profile(String username) {
		
		models.User personalUser = UserService.getUserByOpenId(session.get(Authentication.));
		List<Message> currentMessages = UserService.getMessagesByUser(personalUser);
		render(username, personalUser, currentMessages );
		
	}

	public static void edit(String username) {
		render(username);

	}

	public static void sendMessage(String messageText, String messageGroups) {

		validation.required(messageText);
		if (validation.hasErrors()) {
			for (play.data.validation.Error error : validation.errors()) {
				flash.error(error.message());
			}
			render();
		} else {

			Message actualMessage = new Message();

			actualMessage.setMessagetext(messageText);
			actualMessage.setFrom(UserService.getUserByOpenId(session.get("user")));

			MessageService.storeMessage(actualMessage);

			render();
		}
	}

}
