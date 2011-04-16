package persistence.dao.impl;

import java.net.UnknownHostException;

import play.Logger;
import play.Play;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mysql.jdbc.log.Log;

public class BaseDao implements IDBConstants {
	
	protected static Mongo mongo = null;

	public BaseDao() {
		init();
	}
	
	protected synchronized void init() {
		if (mongo == null) {
			
			String databaseHost = DEFAULT_DATABASE_HOST;
			String databasePort = String.valueOf(DEFAULT_DATABASE_PORT);
			try {
				databaseHost = Play.configuration.getProperty(CFG_KEY_DATABASE_HOST, DEFAULT_DATABASE_HOST);
				databasePort = Play.configuration.getProperty(CFG_KEY_DATABASE_PORT, String.valueOf(DEFAULT_DATABASE_PORT));
				
			} catch (Exception e) {
				System.err.println("WARNING: Retrieving properties \"" + CFG_KEY_DATABASE_HOST + "\", \"" + CFG_KEY_DATABASE_PORT + "\" failed");
			}

			try {
				mongo = new Mongo(databaseHost, Integer.parseInt(databasePort));

			} catch (NumberFormatException nfe) {
				Logger.error("ERROR: Setting database port " + databasePort + "failed", nfe);
			} catch (UnknownHostException uhe) {
				Logger.error("ERROR: Unknown host " + databaseHost, uhe);
			} catch (MongoException me) {
				Logger.error("ERROR: Connecting to database (" + databaseHost + ":" + databasePort + " failed.", me);
			}
		}
	}

	protected DB getDatabase() {
		return mongo.getDB(DEFAULT_DATABASE_NAME);
	}

}
