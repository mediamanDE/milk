package persistence.dao;

import persistence.dao.impl.MessageDaoImpl;

public class DaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MessageDaoImpl messageDao = new MessageDaoImpl();
		messageDao.testInsert();
		messageDao.testFind();
	}

}
