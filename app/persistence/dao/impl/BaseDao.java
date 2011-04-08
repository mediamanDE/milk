package persistence.dao.impl;

import java.net.UnknownHostException;

import com.mongodb.Mongo;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoException;

public class BaseDao {

	protected static Mongo mongo = null;

	public BaseDao() {
		init();
	}
	
	protected synchronized void init() {
		if (mongo == null) {
			try {
				mongo = new Mongo( "localhost" , 27017 );
				
			} catch (UnknownHostException uhe) {
				uhe.printStackTrace();
			} catch (MongoException me) {
				me.printStackTrace();
			}
		}
	}

	protected DB getDatabase(final String dbName) {
		DB db = mongo.getDB("milk");
		return db;
	}
	
	public void testInsert() {
		
		DB db = getDatabase("");
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
		
		DB db = getDatabase("");
		DBCollection coll = db.getCollection("testCollection");
		
		DBObject myDoc = coll.findOne();
		System.out.println(myDoc);
	}

}
