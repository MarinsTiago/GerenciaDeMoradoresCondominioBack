package webService;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;


@ApplicationPath("api")
public class WSConfig extends ResourceConfig {

	public WSConfig() {
		packages("control");
		packages("webService");	
        register(WSJsonProviderConfig.class);	
        property(ServerProperties.TRACING, "ALL");
	}

}
