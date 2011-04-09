package persistence.dao.impl;

import java.util.List;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import models.Group;
import models.Message;
import models.User;
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
		Message returnMessage = null;

		DB db = getDatabase();
		DBCollection coll = db.getCollection(COLLECTION_MESSAGES);
		DBObject result;
		
		BasicDBObject query = new BasicDBObject();
		query.put(FIELD_MESSAGE_ID, messageId);
		result = coll.findOne(query);
		if (result != null) {
			Map resultMap = result.toMap();

			returnMessage = new Message();
			returnMessage.set_id((String) resultMap.get(FIELD_MESSAGE_ID));
//			returnMessage.setAncestors((String) resultMap.get(FIELD_MESSAGE_ANCESTORS));
//			returnMessage.setFrom((String) resultMap.get(FIELD_MESSAGE_FROM));
//			returnMessage.setGroups((String) resultMap.get(FIELD_MESSAGE_GROUPS));
			returnMessage.setMessagetext((String) resultMap.get(FIELD_MESSAGE_MESSAGETEXT));
//			returnMessage.setPostdate((String) resultMap.get(FIELD_MESSAGE_POSTDATE));
		}
		return returnMessage;
	}

	@Override
	public List<Message> getThread(String messageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getAllMessages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getAllMessagesByGroup(Group group) {
		// TODO Auto-generated method stub
		return null;
	}

}
