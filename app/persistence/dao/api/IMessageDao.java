package persistence.dao.api;

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
    public Message[] getThread(String messageId);

    /**
     * Get All Messages
     * @return
     */
    public Message[] getAllMessages();

    /**
     * Get All Messages by Group
     * @param group
     * @return
     */
    public Message[] getAllMessagesByGroup(Group group);

}
