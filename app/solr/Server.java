package solr;

import java.net.MalformedURLException;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;

import play.Logger;
import play.Play;

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
	
	private String url = "http://10.15.20.65:8983/solr";
	
	private SolrServer server;
	
	public static SolrServer getServer() {
		return getServerInstance().server;
	}
	
	private static Server getServerInstance() {
		Boolean enabled = Boolean.valueOf(Play.configuration.getProperty("milk.solr.enabled", "false"));
		if ( !enabled ) {
			Logger.info("Tried to access Solr server, while it's disabled");
			return null;
		}
		
		if (!created) {
			synchronized(Server.class) {
				if(!created) {
					serverInstance = new Server();
					if(serverInstance.server == null){
						try {
							serverInstance.server = new CommonsHttpSolrServer(serverInstance.url);
						} catch (MalformedURLException e) {
							Logger.error(e, "URL for Solr server is invalid");
						}
					}
					created = true;
				}
			}
		}
		return serverInstance;
	}
	
	private Server() {
		String url = Play.configuration.getProperty("milk.solr.url");
		if ( url != null && "".equals(url) ) {
			this.url = url;
		}
	}
	
}
