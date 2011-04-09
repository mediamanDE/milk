package persistence.dao.impl;

import java.util.Iterator;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import models.User;
import persistence.dao.api.IUserDao;

public class UserDaoImpl extends BaseDao implements IUserDao {

	public void store(User user) {
		
		DB db = getDatabase();
		DBCollection coll = db.getCollection(COLLECTION_USERS);
		
		BasicDBObject mongoUser = new BasicDBObject();

		mongoUser.put(FIELD_USER_AVATARURL, user.getAvatarUrl());
		mongoUser.put(FIELD_USER_DISPLAYNAME, user.getDisplayname());
		//TODO implement subobject
		//	mongoUser.put(FIELD_USER_EXTERNALLINKS, user.get);
		mongoUser.put(FIELD_USER_FULLNAME, user.getFullname());
		mongoUser.put(FIELD_USER_NICKNAME, user.getNickname());
		mongoUser.put(FIELD_USER_OPENID, user.getOpenId());
		mongoUser.put(FIELD_USER_POSTCOUNT, user.getPostCount());
		mongoUser.put(FIELD_USER_TIMEZONE, user.getTimezone());

        coll.insert(mongoUser);
	}

	public User getByOpenId(String openId) {
		User returnUser = null;

		DB db = getDatabase();
		DBCollection coll = db.getCollection(COLLECTION_USERS);
		DBObject result;
		
		BasicDBObject query = new BasicDBObject();
		query.put(FIELD_USER_OPENID, openId);
		result = coll.findOne(query);
		if (result != null) {
			Map resultMap = result.toMap();
//			Iterator it = resultMap.entrySet().iterator();
//		    while (it.hasNext()) {
//		        Map.Entry pairs = (Map.Entry)it.next();
//		        System.out.println(pairs.getKey() + " = " + pairs.getValue());
//		    }

			returnUser = new User();
			returnUser.setAvatarUrl((String) resultMap.get(FIELD_USER_AVATARURL));
			returnUser.setDisplayname((String) resultMap.get(FIELD_USER_DISPLAYNAME));
			//TODO implement subobject
			//returnUser.setExternalLinks(result.get(FIELD_USER_EXTERNALLINKS).toString());
			returnUser.setFullname((String) resultMap.get(FIELD_USER_FULLNAME));
			returnUser.setNickname((String) resultMap.get(FIELD_USER_NICKNAME));
			returnUser.setOpenId((String) resultMap.get(FIELD_USER_OPENID));
			returnUser.setPostCount((Integer) resultMap.get(FIELD_USER_POSTCOUNT));
			returnUser.setTimezone((String) resultMap.get(FIELD_USER_TIMEZONE));

			returnUser.debug();
		}
		return returnUser;
	}

	
}
