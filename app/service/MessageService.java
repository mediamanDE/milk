package service;

import java.util.ArrayList;
import java.util.List;

import models.Message;
import persistence.dao.api.IMessageDao;
import persistence.dao.impl.MessageDaoImpl;

public class MessageService{
	
	private static IMessageDao messageDao = new MessageDaoImpl();
	
	/**
	 * 
	 * @param messageId
	 * @return a Message object that's specified by the given messageId,
	 * 		maybe null	
	 */
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
		storeMessage(message, null);
	}
	
	public static void storeMessage(Message message, Message parentMessage){
		if(message != null){
			if(parentMessage != null){
				try{
					List<String> parentAncestors = parentMessage.getAncestors();
					List<String> ancestores = new ArrayList();
					if(parentAncestors != null){
						ancestores.addAll(parentAncestors);
					}
					ancestores.add(parentMessage.getId());
					message.setAncestors(ancestores);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			messageDao.store(message);
//			solr.Add.addMessage(message);
		}
	}
}
