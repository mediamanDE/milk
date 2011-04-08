package controllers;

import java.util.List;

import models.Message;

import play.mvc.Controller;
import play.mvc.With;


@With(Authentication.class)
public class GlobalTimeline extends Controller {
	
	public static void timeline(){
		
		List<Message> currentMessages = null;
		
		render(currentMessages);
		
	}
	
	public static void sendMessage(String messageText, String messageGroups){
		
		validation.required(messageText);
		
		
		if(validation.hasErrors()) {
	        for(play.data.validation.Error error : validation.errors()) {
	             flash.error(error.message());
	        }
			
	    }
		
		timeline();
		
		
	}

}
