package persistence.dao.impl;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class BaseDao implements IDBConstants {
	
	protected static Mongo mongo = null;

	public BaseDao() {
		init();
	}
	
	protected synchronized void init() {
		if (mongo == null) {
			try {
				mongo = new Mongo( DATABASE_HOST , DATABASE_PORT );
				
			} catch (UnknownHostException uhe) {
				uhe.printStackTrace();
			} catch (MongoException me) {
				me.printStackTrace();
			}
		}
	}

	protected DB getDatabase() {
		DB db = mongo.getDB(DATABASE_NAME);
		return db;
	}
	
	public void testInsert() {
		
		DB db = getDatabase();
		DBCollection coll = db.getCollection("testCollection");
		
		BasicDBObject doc = new BasicDBObject();

        doc.put("name", "MongoDB");
        doc.put("type", "database");
        doc.put("count", 1);

        BasicDBObject info = new BasicDBObject();

        info.put("x", 203);
        info.put("y", 102);

        doc.put("info", info);

        coll.insert(doc);
	}

	public void testFind() {
		
		DB db = getDatabase();
		DBCollection coll = db.getCollection("testCollection");
		
		DBObject myDoc = coll.findOne();
		System.out.println(myDoc);
	}

}
