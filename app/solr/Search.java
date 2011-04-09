package solr;

import java.util.ArrayList;
import java.util.Date;

import models.Group;
import models.Message;
import models.User;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

public class Search {

	public static ArrayList<Message> QueryMessage(SolrQuery query){
		SolrDocumentList solrDocs = queryFromServer(query).getResults();
		ArrayList<Message> listMessage = new ArrayList<Message>(); 
		for (SolrDocument solrDocument : solrDocs) {
			listMessage.add(getCleanMessage(solrDocument));
		}
		return listMessage;
	}
	
	public static ArrayList<Message> SearchMessageAll(String search,boolean LazySearch){
		SolrQuery query = new SolrQuery();
		
		//????
    //query.setQuery("*:" + search);
		
		// Lazy
    query.setQuery("description:*" + search+"*");
    
    
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
    
    SolrDocumentList solrDocs = queryFromServer(query).getResults();
    
		ArrayList<Message> listMessage = new ArrayList<Message>(); 
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

	public static void SearchMessage(Message message){
		
	}
	
	public static Message SearchMessageByID(int ID){
		SolrQuery query = new SolrQuery();
		query.setQuery("id:" + ID);
		SolrDocumentList solrDocs = queryFromServer(query).getResults();
		Message message = null;
		if(solrDocs != null){
			message = getCleanMessage(solrDocs.get(0));
		}
		return message;
	}
	
	public static void SearchMessageText(){
		
	}
	
	public static void SearchDate(){
		
	}
	
	public static void SearchUser(User user){
		
	}
	
	public static void SearchGroup(Group group){
		
	}
	
	public static void SearchMessageGroups(){
		
	}
	
	
	private static Message getCleanMessage(SolrDocument solrDocument){
		Message message = new Message();
		message.set_id(Integer.parseInt((String)solrDocument.getFieldValue("id")));
		message.setMessagetext((String)solrDocument.getFieldValue("description"));
		// FIX
		//message.setPostdate(new Date((String)solrDocument.getFieldValue("last_modified")));
		return message;
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
