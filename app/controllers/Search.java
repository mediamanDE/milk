package controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import models.Message;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.apache.solr.common.SolrInputDocument;

import play.mvc.Controller;
import play.mvc.With;

@With(Authentication.class)
public class Search extends Controller {
	
	public static void search() {
		
		//solr.Delete.deleteAll();
		
		
		List<Message> currentMessages = solr.Search.SearchMessageAll("is", false);
		render(currentMessages);
		
		//render();
	}

	
}
