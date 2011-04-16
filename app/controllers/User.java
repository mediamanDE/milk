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

	/**
	 * 
	 * @param nickname
	 */
	public static void profile(String nickname) {
		models.User currentUser = UserService.getUserByOpenId(session.get(Authentication.USER_ID));
		List<Message> currentMessages = UserService.getMessagesByUser(currentUser);
		render(currentUser, currentMessages );
	}

	/**
	 * 
	 * @param nickname
	 */
	public static void edit(String nickname) {
		models.User currentUser = UserService.getUserByOpenId(session.get(Authentication.USER_ID));
		render(currentUser);
	}
	
	/**
	 * 
	 * @param avatarURL
	 * @param displayname
	 * @param fullname
	 * @param nickname
	 */
	public static void saveChanges(String avatarURL,String displayname,String fullname, String nickname){
		
		models.User currentUser = UserService.getUserByOpenId(session.get(Authentication.USER_ID));
		
		if(currentUser != null){
			currentUser.setAvatarUrl(avatarURL);
			currentUser.setDisplayname(displayname);
			currentUser.setFullname(fullname);
			currentUser.setNickname(nickname);
			
			UserService.storeUser(currentUser);
			
			Map<String, Object> args = new HashMap<String, Object>();
			args.put("nickname", currentUser.getNickname());
			Redirect.in_app("User.edit", args);
		}else{
			throw new NotFound("User does not exist");
		}
		
	}

}
