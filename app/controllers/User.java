package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Message;
import play.mvc.Controller;
import play.mvc.With;
import play.mvc.results.NotFound;
import service.MessageService;
import service.UserService;
import utils.Redirect;

@With(Authentication.class)
public class User extends Controller {

	public static void profile(String username) {
		
		models.User currentUser = UserService.getUserByOpenId(session.get(Authentication.USER_ID));
		List<Message> currentMessages = UserService.getMessagesByUser(currentUser);
		render(username, currentUser, currentMessages );
		
	}

	public static void edit(String username) {
		models.User currentUser = UserService.getUserByOpenId(session.get(Authentication.USER_ID));
		render(username,currentUser);
	}
	
	public static void saveChanges(String avatarURL,String displayname,String fullname, String nickname){
		
		models.User currentUser = UserService.getUserByOpenId(session.get(Authentication.USER_ID));
		
		if(currentUser != null){
			currentUser.setAvatarUrl(avatarURL);
			currentUser.setDisplayname(displayname);
			currentUser.setFullname(fullname);
			currentUser.setNickname(nickname);
			
			UserService.storeUser(currentUser);
			
			Map<String, Object> args = new HashMap<String, Object>();
			args.put("username", currentUser.getDisplayname());
			Redirect.in_app("User.edit", args);
		}else{
			throw new NotFound("User does not exist");
		}
		
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
			actualMessage.setFrom(UserService.getUserByOpenId(session.get(Authentication.USER_ID)));

			MessageService.storeMessage(actualMessage);

			render();
		}
	}

}
