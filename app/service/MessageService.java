package service;

import models.Message;
import persistence.dao.api.IMessageDao;
import persistence.dao.impl.MessageDaoImpl;

public class MessageService{
	
	private static IMessageDao messageDao = new MessageDaoImpl();
	
	public static Message getMessageById(final String messageId){
		return messageDao.getMessageById(messageId);
	}
	
	public static void deleteMessage(Message message){
		if(null != message){
			message.setMessagetext("");
			if( getMessageById(message.getId()) != null ){
				messageDao.store(message);
                                solr.Delete.deleteMessage(message);
			} else {
				//TODO throw new exception (message does not exist)
			}
		}
	}
	
	public static void storeMessage (Message message){
		messageDao.store(message);
                solr.Add.addMessage(message);
	}
}
