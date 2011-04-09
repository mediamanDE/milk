package solr;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import models.*;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;

public class Add {

	//public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

	public static void addMessage(Message message) {
		SolrInputDocument docMessage = new SolrInputDocument();
		
		docMessage.addField("id",message.get_id(),1.0f);
		docMessage.addField("description",message.getMessagetext());
		//docMessage.addField("text",message.getMessagetext());
		//docMessage.addField("keywords",message.getAncestors());
		//docMessage.addField("popularity",0);
			
		docMessage.addField("author",message.getFrom().getFullname());
		//docMessage.addField("author",message.getFrom().getDisplayname());
		//docMessage.addField("author",message.getFrom().getNickname());
		//docMessage.addField("author",message.getFrom().getTimezone());
		
		String categoryNameTemp = new String();
		for (Group groupTemp : message.getGroups()) {
			categoryNameTemp += groupTemp.getName() + " ";
		}
		docMessage.addField("category",categoryNameTemp);
		
		// Date Formater
		//SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		//docMessage.addField("last_modified",sdf.format(message.getPostdate()));
		docMessage.addField("last_modified",message.getPostdate());
		
		addToServer(docMessage);
	}
	
	public static void addGroup(Group group) {
		SolrInputDocument docGroup = new SolrInputDocument();
		docGroup.addField("id",group.get_id(),1.0f);
		docGroup.addField("name",group.getName());
		docGroup.addField("description",group.getDescription());
		
		addToServer(docGroup);
	}
	
	public static void addUser(User user) {
		SolrInputDocument docUser = new SolrInputDocument();
		
		docUser.addField("id",user.get_id(),1.0f);
		docUser.addField("name",user.getFullname());
		//docUser("id",user.getAvatarUrl());
		//docUser("author",user.getDisplayname());
		//docUser.addField("author",message.getFrom().getNickname());
		
		addToServer(docUser);
	}
		
	private static void addToServer(SolrInputDocument docSolr){
		try {
			Server.getServer().add(docSolr);
    	Server.getServer().commit();
    } catch (SolrServerException e) {
			// TODO 
		} catch (IOException e) {
			// TODO 
		}
	}
	
}
