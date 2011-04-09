package controllers;

import play.mvc.Controller;
import play.mvc.With;

import java.util.*;

import models.Message;
import service.*;

@With(Authentication.class)
public class GlobalTimeline extends Controller {
	
	public static void timeline(){
		
		List<Message> currentMessages = TimelineService.getAllMessages();
		String username = UserService.getUserByOpenId(session.get(Authentication.USER_ID)).getDisplayname(); 
		render(currentMessages,username);
		
	}
	
	public static void sendMessage(String messageText, String messageGroups){
		
		validation.required(messageText);
		if(validation.hasErrors()){
			for (play.data.validation.Error error : validation.errors()) {
				flash.error(error.message());
			}
			timeline();
		}else{
			
			Message actualMessage = new Message();
			
			actualMessage.setMessagetext(messageText);
			actualMessage.setFrom(UserService.getUserByOpenId(session.get(Authentication.USER_ID)));
			actualMessage.setPostdate(Calendar.getInstance().getTime());
			
			
			MessageService.storeMessage(actualMessage);
			
			timeline();
		}
	}

}
