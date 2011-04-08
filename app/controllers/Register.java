package controllers;

import play.mvc.Controller;
import play.mvc.With;
import play.libs.OpenID;
import play.libs.OpenID.UserInfo;
import models.User;

public class Register extends Controller {
	public void register(){
		
	}
	
	public void currentFields(){
		
	} 
	public void saveFileds(String fullname, String displayname){
		
		validation.required(fullname);
		validation.required(displayname);
		
		if(validation.hasErrors()){
			for(play.data.validation.Error error : validation.errors()) {
	             flash.error(error.message());
	        }
			register();
		}else{
			if(fullname != "" && displayname != ""){
				User newuser = new User();
				UserInfo verifiedUser = OpenID.getVerifiedID();
				String Nickname = verifiedUser.id;
				Nickname.substring(33);
				newuser.setDisplayname(displayname);
				newuser.setFullname(fullname);
				newuser.setNickname(Nickname);
				newuser.setOpenId(verifiedUser.id);
			}
		}
	}
}
