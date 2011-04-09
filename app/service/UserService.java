package service;

import models.User;
import persistence.dao.api.IUserDao;
import persistence.dao.impl.UserDaoImpl;

public class UserService {
	
	private static IUserDao userDao = new UserDaoImpl();

	public static User getUserByOpenId(final String openId) {
		return userDao.getByOpenId(openId);
	}

	public static void storeUser(User user){
		userDao.store(user);
	}
}
