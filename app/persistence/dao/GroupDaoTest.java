package persistence.dao;

import java.util.ArrayList;
import java.util.List;

import models.ExternalLink;
import models.Group;
import models.Message;
import models.User;
import persistence.dao.api.IGroupDao;
import persistence.dao.api.IUserDao;
import persistence.dao.impl.GroupDaoImpl;
import persistence.dao.impl.UserDaoImpl;

public class GroupDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        IGroupDao groupDao = new GroupDaoImpl();

        Group group1 = new Group();
        group1.setId(0);
        group1.setName("Milk");
        group1.setDescription("Discussion about Milk.");

        Group group2 = new Group();
        group2.setId(0);
        group2.setName("Coffee");
        group2.setDescription("Discussion about coffee.");

        groupDao.store(group1);
        groupDao.store(group2);

        List<Group> groups = groupDao.getAllGroups("ASC");
        if (groups != null) {
            for (Group currGroup : groups) {
                if (currGroup != null) {
                    currGroup.debug();
                } else {
                    System.out.println("group empty");
                }
            }
        } else {
            System.out.println("no groups");
        }

        Group foundGroup = groupDao.getGroupByName("Coffee");
        if (foundGroup != null) {
            System.out.println("Found group:");
            foundGroup.debug();
        }
    }
}
