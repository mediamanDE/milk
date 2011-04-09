package solr;

import java.net.MalformedURLException;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;

import com.sun.xml.internal.ws.wsdl.writer.UsingAddressing;

/*
CommonsHttpSolrServer is thread-safe and if you are using the following constructor,
you *MUST* re-use the same instance for all requests.  If instances are created on
the fly, it can cause a connection leak. The recommended practice is to keep a
static instance of CommonsHttpSolrServer per solr server url and share it for all requests.
See https://issues.apache.org/jira/browse/SOLR-861 for more details
*/

public class Server {
	
	/*
	 * SINGLETONE - PATTERN
	 * UMSTÄNDLICHERER CODE (created) WEGEN SolrServer Konstruktor
	 * URL setzten wäre nur mir getServerInstance/getServer Parameter möglich
	 */
	
	private static Server serverInstance = null;
	private static Boolean created = false;
	
	//private String url = "http://ws202-1.mediaman.local:8983/solr";
	private String url = "http://10.15.20.65:8983/solr";
	
	private SolrServer server;
	
	public static SolrServer getServer() {
		return getServerInstance().server;
	}
	
	private static Server getServerInstance() {
		if (!created) {
			synchronized(Server.class) {
				if(!created) {
					serverInstance = new Server();
					if(serverInstance.server == null){
						try {
							serverInstance.server = new CommonsHttpSolrServer(serverInstance.url);
						} catch (MalformedURLException e) {
							// TODO 
						}
					}
					created = true;
				}
			}
		}
		return serverInstance;
	}
	
	
	
	/* STATIC - VERSION	
	 * URL Kann vorher gesetzt werden...

 	private static String url = "http://ws202-1.mediaman.local:8983/solr";
	private static SolrServer server;
	
	*//**
	 * @param solr url to set
	 *//*
	public static void setUrl(String url) {
	 Server.url = url;
	 }
	*//**
	 * @return solr url
	 *//*
	public static String getUrl() {
		return Server.url;
	}
	
	*//**
	 * @return solr Server
	 *//*
	public static SolrServer getServer() {
		if(server == null){
			try {
				server = new CommonsHttpSolrServer(url);
	
				CommonsHttpSolrServer server = new CommonsHttpSolrServer(url);
				server.setSoTimeout(1000);  // socket read timeout
				server.setConnectionTimeout(100);
				server.setDefaultMaxConnectionsPerHost(100);
				server.setMaxTotalConnections(100);
				server.setFollowRedirects(false);  // defaults to false
				// allowCompression defaults to false.
				// Server side must support gzip or deflate for this to have any effect.
				server.setAllowCompression(true);
				server.setMaxRetries(1); // defaults to 0.  > 1 not recommended.
				server.setParser(new XMLResponseParser()); // binary parser is used by default
			} catch (MalformedURLException e) {
				// TODO 
			}
		}
		return Server.server;
	}
	*/
	
	
	private Server(){}
	
}
