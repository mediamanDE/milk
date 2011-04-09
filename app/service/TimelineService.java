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
     * @return
     */
    public static List<Message> getAllMessages() {
        return getAllMessages("DESC");
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
