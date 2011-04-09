package persistence.dao.api;

import java.util.List;

import models.Group;
import models.Message;

public interface IMessageDao {

    /**
     * store Message
     * @param message
     */
    public void store(Message message);

    /**
     * Delete Message
     */
    public void delete();

    /**
     * Get one Message by ID
     * @param messageId
     * @return Message
     */
    public Message getMessageById(String messageId);
    
    /**
     * Get a thread
     * @param messageId
     * @return
     */
    public List<Message> getThread(String messageId);

    /**
     * Get All Messages
     * @return
     */
    public List<Message> getAllMessages(String orderBy);

    /**
     * Get All Messages by Group
     * @param group
     * @return
     */
    public List<Message> getAllMessagesByGroup(Group group);

}
