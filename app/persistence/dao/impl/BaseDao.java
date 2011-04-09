package persistence.dao.impl;

import java.net.UnknownHostException;

import play.Play;

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
				System.err.println("ERROR: Setting database port " + databasePort + "failed");
				nfe.printStackTrace();
			} catch (UnknownHostException uhe) {
				System.err.println("ERROR: Unknown host " + databaseHost);
				uhe.printStackTrace();
			} catch (MongoException me) {
				System.err.println("ERROR: Connecting to database (" + databaseHost + ":" + databasePort + " failed.");
				me.printStackTrace();
			}
		}
	}

	protected DB getDatabase() {
		DB db = mongo.getDB(DEFAULT_DATABASE_NAME);
		return db;
	}

}
