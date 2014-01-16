package org.ngr.restlet.proto3.application;

import java.util.logging.Level;

import org.ngr.restlet.proto3.server.filter.BlockerIP;
import org.ngr.restlet.proto3.server.resource.AccountServerResource;
import org.ngr.restlet.proto3.server.resource.AccountsServerResource;
import org.ngr.restlet.proto3.server.resource.RootServerResource;
import org.ngr.restlet.proto3.server.restlet.Tracer;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.engine.Engine;
import org.restlet.routing.Router;

/**
 * Hello world!
 *
 */
public class MailServerApplication extends Application
{
    public static void main( String[] args ) throws Exception
    {
    	System.setProperty("java.net.preferIPv4Stack", "true");
        Server mailServer = new Server(Protocol.HTTP, 8111);
        mailServer.setNext(new MailServerApplication());
        mailServer.start();
    }
    
    public MailServerApplication() {
    	setName("RESTful Web server");
    	setDescription("Exemple for 'Restlet in action' book");
    	setOwner("MY FIRM");
    	setAuthor("ME");
    	Engine.setLogLevel(Level.FINEST);
    	
    }
    @Override
    public Restlet createInboundRoot() {
    	Tracer tracer = new Tracer(getContext());
    	BlockerIP blocker = new BlockerIP(getContext());
    	blocker.getBlockAddress().add("127.0.0.1");
    	//blocker.getBlockAddress().add("localhost");
		blocker.setNext(tracer);
    	Router router = new Router(getContext());
    	router.attach("/", RootServerResource.class);
    	router.attach("/accounts/", AccountsServerResource.class);
    	router.attach("/accounts/{accountID}", AccountServerResource.class);
    	return router;
    	
 
    }
}
