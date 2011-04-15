package service;

import java.util.ArrayList;
import java.util.List;

import models.Message;
import models.User;
import persistence.dao.api.IUserDao;
import persistence.dao.impl.UserDaoImpl;

public class UserService {

    private static IUserDao userDao = new UserDaoImpl();

    public static User getUserByOpenId(final String openId) {
        return userDao.getByOpenId(openId);
    }

    public static void storeUser(User user) {
        userDao.store(user);
        solr.Add.addUser(user);
    }

    public static List<Message> getMessagesByUser(User user) {
        List<Message> messagesArray = new ArrayList<Message>();
        messagesArray = TimelineService.getMessagesByOpenId(user.getOpenId());
        return messagesArray;
    }
}
