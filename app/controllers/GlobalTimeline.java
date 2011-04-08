package controllers;

import play.mvc.Controller;
import java.util.*;

import models.Message;

public class GlobalTimeline extends Controller {
	
	public static void timeline(){
		
		List<Message> currentMessages = null;
		
		render(currentMessages);
		
	}

}
