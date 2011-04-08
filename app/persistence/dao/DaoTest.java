package persistence.dao;

import persistence.dao.impl.BaseDao;

public class DaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BaseDao baseDao = new BaseDao();
		baseDao.testInsert();
		baseDao.testFind();
	}

}
