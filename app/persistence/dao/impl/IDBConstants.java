package persistence.dao.impl;

public interface IDBConstants {

	public static final String CFG_KEY_DATABASE_HOST = "database.host";
	public static final String CFG_KEY_DATABASE_PORT = "database.port";
	public static final String CFG_KEY_DATABASE_USERNAME = "database.host";
	public static final String CFG_KEY_DATABASE_PASSWORD = "database.port";

	public static final String DEFAULT_DATABASE_HOST = "localhost";
	public static final int DEFAULT_DATABASE_PORT = 27017;
	public static final String DEFAULT_DATABASE_NAME = "milk";

	public static final String COLLECTION_USERS = "users";
	public static final String FIELD_USER_OPENID = "openid";
	public static final String FIELD_USER_NICKNAME = "nickname";
	public static final String FIELD_USER_FULLNAME = "fullname";
	public static final String FIELD_USER_DISPLAYNAME = "displayname";
	public static final String FIELD_USER_AVATARURL = "avatarurl";
	public static final String FIELD_USER_POSTCOUNT = "postcount";
	public static final String FIELD_USER_TIMEZONE = "timezone";
	public static final String FIELD_USER_EXTERNALLINKS = "externallinks";
	public static final String FIELD_USER_EXTERNALLINKS_NAME = "name";
	public static final String FIELD_USER_EXTERNALLINKS_URL = "url";

	public static final String COLLECTION_MESSAGES = "messages";
	public static final String FIELD_MESSAGE_ID = "_id";
	public static final String FIELD_MESSAGE_POSTDATE = "postdate";
	public static final String FIELD_MESSAGE_GROUPS = "groups";
	public static final String FIELD_MESSAGE_ANCESTORS = "ancestors";
	public static final String FIELD_MESSAGE_MESSAGETEXT = "messagetext";
	public static final String FIELD_MESSAGE_FROM = "from";

	public static final String COLLECTION_GROUPS = "groups";
}