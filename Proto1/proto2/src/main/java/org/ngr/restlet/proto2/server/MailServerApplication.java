package org.ngr.restlet.proto2.server;

import org.ngr.restlet.proto2.server.filter.BlockerIP;
import org.ngr.restlet.proto2.server.restlet.Tracer;
import org.restlet.Application;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.Server;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;

/**
 * Hello world!
 *
 */
public class MailServerApplication extends Application
{
    public static void main( String[] args ) throws Exception
    {
        Server mailServer = new Server(Protocol.HTTP, 8111);
        mailServer.setNext(new MailServerApplication());
        mailServer.start();
    }
    
    public MailServerApplication() {
    	setName("RESTful Web server");
    	setDescription("Exemple for 'Restlet in action' book");
    	setOwner("MY FIRM");
    	setAuthor("ME");
    }
    @Override
    public Restlet createInboundRoot() {
    	BlockerIP restlet = new BlockerIP(getContext());
    	//restlet.getBlockAddress().add("127.0.0.1");
    	//restlet.getBlockAddress().add("localhost");
    	restlet.setNext(new Tracer(getContext()));
    	return restlet;
    	
 
    }
}
