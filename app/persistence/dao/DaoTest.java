package persistence.dao;

import models.User;
import persistence.dao.api.IUserDao;
import persistence.dao.impl.UserDaoImpl;

public class DaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IUserDao userDao = new UserDaoImpl();
		User user = userDao.getByOpenId("345");
		if (user == null) {
			System.out.println("User does not exist");
		
			User userNew = new User();
			userNew.setOpenId("345");
			userNew.setAvatarUrl("www.mediaman.de");
			userNew.setDisplayname("Harry");
			userNew.setFullname("Harry Hirsch");
			userNew.setNickname("Otto");
			userNew.setPostCount(0);
			userNew.setTimezone("+1");
			
			userDao.store(userNew);
		} else {
			System.out.println("User exists.");
		}
	}

}
