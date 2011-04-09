import play.Logger;
import play.Play;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.mvc.Router;


@OnApplicationStart
public class Bootstrap extends Job {

	public void doJob() {
		String appMode = Play.configuration.getProperty("application.mode", "dev");
		if ( "prod".equals(appMode) ) {
			Play.ctxPath = Play.configuration.getProperty("context.path", "/milk");
			Router.load(Play.ctxPath);
			Logger.debug("Set ContextPath to %s", Play.ctxPath);
		}
	}
}
