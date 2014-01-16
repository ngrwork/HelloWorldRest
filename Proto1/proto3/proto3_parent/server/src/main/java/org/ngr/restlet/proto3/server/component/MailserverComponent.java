package org.ngr.restlet.proto3.server.component;

import java.util.logging.Level;

import org.ngr.restlet.proto3.application.MailServerApplication;
import org.restlet.Component;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.engine.Engine;

public class MailserverComponent extends Component {

	public MailserverComponent() {
	   	setName("RESTful Web server Component");
    	setDescription("Exemple for 'Restlet in action' book");
    	setOwner("MY FIRM");
    	setAuthor("ME");
    	Engine.setLogLevel(Level.FINEST);
    	Server server =getServers().add(Protocol.HTTP, 8111);
    	server.getContext().getParameters().set("tracing", "true");
    	
    	
    	
    	getDefaultHost().attachDefault(new MailServerApplication());
    	
	}


	

	public static void main(String[] args) throws Exception {
		new MailserverComponent().start();

	}

}
