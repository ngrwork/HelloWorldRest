package org.ngr.restlet.proto3.server.component;

import java.util.logging.Level;

import org.ngr.restlet.proto3.application.MailServerApplication;
import org.restlet.Component;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.engine.Engine;
import org.restlet.routing.VirtualHost;

public class MailserverComponent extends Component {

	public MailserverComponent() {
	   	setName("RESTful Web server Component");
    	setDescription("Exemple for 'Restlet in action' book");
    	setOwner("MY FIRM");
    	setAuthor("ME");
    	Engine.setLogLevel(Level.FINEST);
    	Server server =getServers().add(Protocol.HTTP, 8111);
    	server.getContext().getParameters().set("tracing", "true");
    	
    	// Configure default virtual host
    	VirtualHost host = getDefaultHost();
    	host.setHostDomain("www\\.rmep\\.com|www\\.rmep\\.org|www\\.rmep\\.net");
    	host.setServerAddress("1\\.2\\.3\\.10|1\\.2\\.3\\.20");
    	host.setServerPort("80");
    	
    	host.attachDefault(new MailServerApplication());
    	
    	getClients().add(Protocol.CLAP);
    	getLogService().setLoggerName("MailServer.AccessLog");
    	getLogService().setLogPropertiesRef("clap://system/log.properties");
    	
	}


	

	public static void main(String[] args) throws Exception {
		new MailserverComponent().start();

	}

}
