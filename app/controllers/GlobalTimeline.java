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
		render(currentMessages);
		
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
			
			MessageService.storeMessage(actualMessage);
			
			timeline();
		}
	}

}
