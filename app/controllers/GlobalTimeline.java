package controllers;

import play.mvc.Controller;
import play.mvc.With;
import play.mvc.results.NotFound;

import java.util.*;

import models.Message;
import service.*;
import utils.Redirect;

@With(Authentication.class)
public class GlobalTimeline extends Controller {

	public static void timeline() {
		List<Message> currentMessages = TimelineService.getAllMessages();
		String username = UserService.getUserByOpenId(
				session.get(Authentication.USER_ID)).getDisplayname();
		render(currentMessages, username);
	}

	public static void sendMessage(String messageText, String messageGroups) {
		validation.required(messageText);
		if (validation.hasErrors()) {
			for (play.data.validation.Error error : validation.errors()) {
				flash.error(error.message());
			}
			// don't redirect as there are errors
			timeline();

		} else {

			Message actualMessage = new Message();

			actualMessage.setMessagetext(messageText);
			actualMessage.setFrom(UserService.getUserByOpenId(session
					.get(Authentication.USER_ID)));
			actualMessage.setPostdate(Calendar.getInstance().getTime());

			MessageService.storeMessage(actualMessage);

			// redirect after POST
			Redirect.in_app("GlobalTimeLine.timeline");
		}
	}

	public static void viewMessage(String messageId) {
		Message message = MessageService.getMessageById(messageId);
		if ( message == null ) {
			throw new NotFound("No message found for given Id");
		} else {
			render(message);
		}
	}
}
