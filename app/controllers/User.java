package controllers;

import java.util.List;

import play.mvc.Controller;
import play.mvc.With;
import service.MessageService;
import service.UserService;
import models.Message;

@With(Authentication.class)
public class User extends Controller {

	public static void profile(String username) {
		
		models.User personalUser = UserService.getUserByOpenId(session.get(Authentication.USER_ID));
		List<Message> currentMessages = UserService.getMessagesByUser(personalUser);
		render(username, personalUser, currentMessages );
		
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
			
			redirect("/"+currentUser.getDisplayname()+"/edit");
		}else{
			
			//ToDo
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
