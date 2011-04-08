package service;

import models.User;

public class UserService {
	
	public User getUserByOpenId(final String openId){
		User user = new User();
		user.setOpenId(openId);
		//TODO 
		user.setDisplayname("Hans Peter");
		return user;
	}
	
	public void storeUser(User user){
		
	}
}
