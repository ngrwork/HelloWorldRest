package org.ngr.restlet.proto1.server;

import org.restlet.Server;
import org.restlet.data.Protocol;

/**
 * Hello world!
 *
 */
public class AppServer 
{
    public static void main( String[] args ) throws Exception
    {
        Server helloServer = new Server(Protocol.HTTP, 8111, HelloServerResource.class);
        helloServer.start();
    }
}
