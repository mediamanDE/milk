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
		User user = userDao.getByOpenId("123");
		if (user == null) System.out.println("User does not exist");
		
		User userNew = new User();
		userNew.setOpenId("123");
		userDao.store(userNew);
	}

}
