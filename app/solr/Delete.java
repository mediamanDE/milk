package solr;

import java.io.IOException;

import models.Group;
import models.Message;
import models.User;

import org.apache.solr.client.solrj.SolrServerException;

public class Delete {

	public static void deleteAll(){
		deleteByQuery("*:*");
	}
	
	public static void deleteMessage(Message message){
		deleteByID(Integer.toString(message.get_id()));
	}
	
	public static void deleteGroup(Group group){
		deleteByID(Integer.toString(group.get_id()));
	}
	
	public static void deleteUser(User user){
		deleteByID(Integer.toString(user.get_id()));
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
		try {
			Server.getServer().deleteByQuery(Query);
			Server.getServer().commit();
		} catch (SolrServerException e) {
			// TODO
		} catch (IOException e) {
			// TODO
		}
	}
	
	
}
