package persistence.dao;

import models.User;
import persistence.dao.api.IUserDao;
import persistence.dao.impl.UserDaoImpl;

public class DaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String openId = "345";
		IUserDao userDao = new UserDaoImpl();
		User user = userDao.getByOpenId(openId);
		if (user == null) {
			System.out.println("Didn't find user by openid=" + openId + ". Creating user ...");
		
			User userNew = new User();
			userNew.setOpenId(openId);
			userNew.setAvatarUrl("www.mediaman.de");
			userNew.setDisplayname("Harry");
			userNew.setFullname("Harry Hirsch");
			userNew.setNickname("Otto");
			userNew.setPostCount(0);
			userNew.setTimezone("+1");
			
			userDao.store(userNew);
		} else {
			System.out.println("User found.");
		}
	}

}
