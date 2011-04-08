package service;

import models.User;
import persistence.dao.api.IUserDao;
import persistence.dao.impl.UserDaoImpl;

public class UserService {
	
	private IUserDao userDao;

	public UserService() {
		userDao = new UserDaoImpl();
	}
	
	public User getUserByOpenId(final String openId) {
		//User user = userDao.getUserByOpenId(openId);
		
		User user = new User();
		user.setOpenId(openId);
		//TODO 
		user.setDisplayname("Hans Peter");
		return user;
	}
	
	public void storeUser(User user){
		//userDao.store(user);
	}
}
