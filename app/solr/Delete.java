package solr;

import java.io.IOException;

import models.Group;
import models.Message;
import models.User;

import org.apache.solr.client.solrj.SolrServerException;

import play.Logger;
import play.Play;

public class Delete {

	public static void deleteAll(){
		deleteByQuery("*:*");
	}
	
	public static void deleteMessage(Message message){
		deleteByID(message.getId());
	}
	
	public static void deleteGroup(Group group){
		deleteByID(Integer.toString(group.getId()));
	}
	
	public static void deleteUser(User user){
		//deleteByID(Integer.toString(user.get_id()));
		deleteByID(user.getOpenId());
	}
	
	public static void deleteByID(String ID){
		try {
			Server.getServer().deleteById(ID);
			Server.getServer().commit();
		} catch (SolrServerException e) {
			// TODO
		} catch (IOException e) {
			// TODO
		}
	}
	
	public static void deleteByQuery(String Query){
		Boolean enabled = Boolean.valueOf(Play.configuration.getProperty("milk.solr.enabled", "false"));
		if ( !enabled ) {
			Logger.info("Tried to delete document from Solr, while it's disabled");
			return;
		}
		
		try {
			Server.getServer().deleteByQuery(Query);
			Server.getServer().commit();
		} catch (SolrServerException e) {
			Logger.warn("Exception while deleting documents from Solr", e);
		} catch (IOException e) {
			Logger.warn("Exception while deleting documents from Solr", e);
		}
	}
	
	
}
