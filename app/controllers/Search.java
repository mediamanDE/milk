package controllers;

import java.util.List;

import models.Message;
import play.db.jpa.Model;
import play.mvc.Controller;
import play.mvc.With;

@With(Authentication.class)
public class Search extends Controller {
	
	public static void search(String searchMessage,String searchAuthor, String searchUser) {
		//solr.Delete.deleteAll();
		flash.error("");
		
		if(searchMessage != null){
			List<Message> currentMessages = null; 
			validation.required(searchMessage);
			if (validation.hasErrors()) {
				flash.error("Please enter Message-Text");
			}else{
				currentMessages = solr.Search.SearchMessageAll(searchMessage, true);
			}
			render(currentMessages);
		}
		
		if(searchAuthor != null){
			List<Message> currentMessages = null; 
			validation.required(searchAuthor);
			if (validation.hasErrors()) {
				flash.error("Please enter Author");
			}else{
				currentMessages = solr.Search.SearchMessageByAuthor(searchAuthor);
			}
			render(currentMessages);
		}
		
		if(searchUser != null){
			List<models.User> currentUsers = null;
			
			validation.required(searchUser);
			if (validation.hasErrors()) {
				flash.error("Please enter User");
			}else{
				currentUsers = solr.Search.SearchUserAll(searchUser);
			}
			render(currentUsers);
		}
		
		render();
		
	}
	

}
