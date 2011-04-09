package utils;

import java.util.HashMap;
import java.util.Map;

import play.Logger;
import play.mvc.Router;


public class Redirect {
	
	/**
	 * This is more intelligent that Play's built-in redirect 
	 * functionality, because it respects the application's 
	 * context path (or rather <code>Play.ctx</code>).
	 * 
	 * Uses <code>Controller.redirect(String)</code> behind the
	 * scenes, so it issues a 301.
	 * 
	 * @param actionName. 
	 */
	public static void in_app(String actionName, Map<String, Object> args) {
		if ( actionName == null && "".equals(actionName) ) {
			throw new IllegalArgumentException("Argument actionName must not be null");
		}
		String url = Router.reverse(actionName, args).toString();
		Logger.debug("Making in_app redirect for actionName %s to %s", actionName, url);
		throw new play.mvc.results.Redirect(url, false);
	}
	
	public static void in_app(String actionName) {
		in_app(actionName, new HashMap<String, Object>(16));
	}
	

}
