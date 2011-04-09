package solr;

import java.util.ArrayList;
import java.util.List;

import models.Group;
import models.Message;
import models.User;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

public class Search {

	public static List<Message> QueryMessage(SolrQuery query){
		QueryResponse queryRsp = queryFromServer(query);
		if(queryRsp != null){
			SolrDocumentList solrDocs = queryFromServer(query).getResults();
			List<Message> listMessage = new ArrayList<Message>(); 
			for (SolrDocument solrDocument : solrDocs) {
				listMessage.add(getCleanMessage(solrDocument));
			}
			return listMessage;
		}
		return null;
	}
	
	public static List<Message> SearchMessageAll(String search,boolean lazy){
		SolrQuery query = new SolrQuery();
		
		if(lazy){
			query.setQuery("description:*" + search + "*");
		}else{
			query.setQuery("*:" + search);
		}
    
    query.addSortField("last_modified", SolrQuery.ORDER.asc);
    
//    SolrQuery solrQuery = new  SolrQuery().
//	    setQuery("ipod").
//	    setFacet(true).
//	    setFacetMinCount(1).
//	    setFacetLimit(8).
//	    addFacetField("category").
//	    addFacetField("inStock");
    
    //.setHighlight(true).setHighlightSnippets(1); //set other params as needed
    //.setParam("hl.fl", "content");
    
    QueryResponse queryRsp = queryFromServer(query);
    if(queryRsp != null){
    	SolrDocumentList solrDocs = queryFromServer(query).getResults();
      
  		List<Message> listMessage = new ArrayList<Message>(); 
  		for (SolrDocument solrDocument : solrDocs) {
  			listMessage.add(getCleanMessage(solrDocument));
  		}
  			
  		// GET Highlight
  		/*Iterator<SolrDocument> iterResult = queryRsp.getResults().iterator();
      while (iterResult.hasNext()) {
        SolrDocument resultDoc = iter.next();

        String content = (String) resultDoc.getFieldValue("content");
        String id = (String) resultDoc.getFieldValue("id"); //id is the uniqueKey field

        if (queryRsp.getHighlighting().get(id) != null) {
          List<String> highlightSnippets = queryRsp.getHighlighting().get(id).get("content");
        }
      }*/
  		
  		return listMessage;
    }
    return null;
	}
	
	public static List<Message> SearchMessageByAuthor(String search){
SolrQuery query = new SolrQuery();
		
		//????
    //query.setQuery("*:" + search);
		// Lazy
    query.setQuery("author:*" + search + "*");
    query.addSortField("last_modified", SolrQuery.ORDER.asc);
    
    QueryResponse queryRsp = queryFromServer(query);
    if(queryRsp != null){
    	SolrDocumentList solrDocs = queryFromServer(query).getResults();
      
  		List<Message> listMessage = new ArrayList<Message>(); 
  		for (SolrDocument solrDocument : solrDocs) {
  			listMessage.add(getCleanMessage(solrDocument));
  		}
  		return listMessage;
    }
    return null;
	}

	public static void SearchMessage(Message message){
		
	}
	
	public static Message SearchMessageByID(String ID){
		SolrQuery query = new SolrQuery();
		query.setQuery("id:" + ID);
		QueryResponse queryRsp = queryFromServer(query);
		if(queryRsp != null){
			SolrDocumentList solrDocs = queryFromServer(query).getResults();
			Message message = null;
			if(solrDocs != null){
				message = getCleanMessage(solrDocs.get(0));
			}
			return message;
		}
		return null;
	}
	
	public static void SearchMessageText(){
		
	}
	
	public static void SearchDate(){
		
	}
	
	public static void SearchUser(User user){
		
	}
	
	public static List<User> SearchUserAll(String search){
		SolrQuery query = new SolrQuery();
		query.setQuery("name:*" + search + "*");
    query.addSortField("last_modified", SolrQuery.ORDER.asc);
    
    QueryResponse queryRsp = queryFromServer(query);
    if(queryRsp != null){
    	SolrDocumentList solrDocs = queryFromServer(query).getResults();
      
  		List<User> listUser = new ArrayList<User>(); 
  		for (SolrDocument solrDocument : solrDocs) {
  			listUser.add(getCleanUser(solrDocument));
  		}
  			  		
  		return listUser;
    }
    return null;
	}
	
	public static void SearchGroup(Group group){
		
	}
	
	public static void SearchMessageGroups(){
		
	}
	
	private static Message getCleanMessage(SolrDocument solrDocument){
		Message message = new Message();
		message.setId((String)solrDocument.getFieldValue("id"));
		message.setMessagetext((String)solrDocument.getFieldValue("description"));
		// FIX
		//message.setPostdate(new Date((String)solrDocument.getFieldValue("last_modified")));
		return message;
	}
	
	private static User getCleanUser(SolrDocument solrDocument){
		User user = new User();
		user.setFullname((String)solrDocument.getFieldValue("name"));
		return user;
	}
	
	private static QueryResponse queryFromServer(SolrQuery query){
		QueryResponse queryRsp = null;
		try {
			//return Server.getServer().query(query);
			queryRsp = Server.getServer().query(query);
		} catch (SolrServerException e) {
			// TODO
		}
		return queryRsp;
	}
}
