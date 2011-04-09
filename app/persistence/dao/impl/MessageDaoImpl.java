package persistence.dao.impl;

import models.Group;
import models.Message;
import persistence.dao.api.IMessageDao;

public class MessageDaoImpl extends BaseDao implements IMessageDao {

	@Override
	public void store(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Message getMessageById(String messageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message[] getThread(String messageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message[] getAllMessages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message[] getAllMessagesByGroup(Group group) {
		// TODO Auto-generated method stub
		return null;
	}

}
