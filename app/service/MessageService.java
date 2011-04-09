package service;

import persistence.dao.api.IMessageDao;
import persistence.dao.impl.MessageDaoImpl;
import models.Message;

public class MessageService{
	
	private IMessageDao messageDao;
	
	public MessageService() {
		messageDao = new MessageDaoImpl();
	}
	
	public Message getMessageById(final String messageId){
		return messageDao.getMessageById(messageId);
	}
	
	public void deleteMessage(Message message){
		if(null != message){
			message.setMessagetext("");
			if( getMessageById(message.get_id()) != null ){
				messageDao.store(message);
			} else {
				//TODO throw new exception (message does not exist)
			}
		}
	}
	
	public void storeMessage (Message message){
		messageDao.store(message);
	}
}
