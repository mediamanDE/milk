package persistence.dao.impl;

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
//		mongoUser.put(FIELD_USER_EXTERNALLINKS, user.get);
		mongoUser.put(FIELD_USER_FULLNAME, user.getFullname());
		mongoUser.put(FIELD_USER_NICKNAME, user.getNickname());
		mongoUser.put(FIELD_USER_OPENID, user.getOpenId());
		mongoUser.put(FIELD_USER_POSTCOUNT, user.getPostCount());
		mongoUser.put(FIELD_USER_TIMEZONE, user.getTimezone());

        coll.insert(mongoUser);
		
	}

	public User getByOpenId(String openId) {
		DB db = getDatabase();
		DBCollection coll = db.getCollection(COLLECTION_USERS);
		DBObject result;
		
		BasicDBObject query = new BasicDBObject();
		query.put(FIELD_USER_OPENID, openId);
		result = coll.findOne(query);
		
		User returnUser = new User();
		returnUser.setAvatarUrl(result.get(FIELD_USER_AVATARURL).toString());
		returnUser.setDisplayname(result.get(FIELD_USER_DISPLAYNAME).toString());
//TODO implement subobject
//		returnUser.setExternalLinks(result.get(FIELD_USER_EXTERNALLINKS).toString());
		returnUser.setFullname(result.get(FIELD_USER_FULLNAME).toString());
		returnUser.setNickname(result.get(FIELD_USER_NICKNAME).toString());
		returnUser.setOpenId(result.get(FIELD_USER_OPENID).toString());
		try{
			returnUser.setPostCount(Integer.parseInt((result.get(FIELD_USER_POSTCOUNT).toString())));
		}catch(NumberFormatException nfe){
			returnUser.setPostCount(0);
		}
		returnUser.setTimezone(result.get(FIELD_USER_TIMEZONE).toString());

		return returnUser;
	}

	
}
