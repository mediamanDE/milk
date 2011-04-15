package service;

import java.util.ArrayList;
import java.util.List;

import models.Group;
import models.Message;
import persistence.dao.api.IMessageDao;
import persistence.dao.impl.MessageDaoImpl;

public class TimelineService {

    private static IMessageDao messageDao = new MessageDaoImpl();

    /**
     *
     * @param orderBy ASC, DESC
     * @return
     */
    public static List<Message> getAllMessages(String orderBy) {

        List<Message> messagesArray = new ArrayList<Message>();
        messagesArray = messageDao.getAllMessages(orderBy);
            
        return messagesArray;

    }

    /**
     * 
     * @param orderBy
     * @return
     */
    public static List<Message> getAllMessages(int limit, int offset, String orderBy) {

        List<Message> messagesArray = new ArrayList<Message>();
        messagesArray = messageDao.getLimitedMessages(limit, offset, orderBy);
            
        return messagesArray;

    }
    /**
     *
     * @return
     */
    public static List<Message> getAllMessages() {
        return getAllMessages("DESC");
    }

    /**
     * Get a limited list of messages posted by a user specified by his openID
     * 
     * @param openId
     * @param limit
     * @param offset
     * @param orderBy
     * @return
     */
    public static List<Message> getMessagesByOpenId(String openId, int limit, int offset, String orderBy) {

        List<Message> messagesArray = new ArrayList<Message>();
        messagesArray = messageDao.getMessagesByOpenId(openId, limit, offset, orderBy);

        return messagesArray;

    }

    public static List<Message> getMessagesByOpenId(String openId) {

        List<Message> messagesArray = new ArrayList<Message>();
        messagesArray = messageDao.getMessagesByOpenId(openId, 0, 0, "DESC");

        return messagesArray;

    }

    /**
     * Retrieve all Messages according a specified Group
     * 
     * @param group
     * @return
     */
    public static List<Message> getAllMessagesByGroup(Group group) {

        // Todo: Implement group functionalities
        return getAllMessages("DESC");

    }
}
