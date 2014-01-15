package org.ngr.restlet.proto2.server;

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

    }
    @Override
    public Restlet createInboundRoot() {
    	return new Restlet() {
    		@Override
    		public void handle(Request request, Response response) {
    			String entity = "Method :"+request.getMethod()
    					+ "\nResource URI : " + request.getResourceRef()
    					+ "\nIP address :" + request.getClientInfo().getAddress()
    					+ "\nAgent Name : "+ request.getClientInfo().getAgentName()
    					+ "\nAgent Version :"+ request.getClientInfo().getAgentVersion();
    			response.setEntity(entity,MediaType.TEXT_PLAIN);
     		}
		};
 
    }
}
