package org.ngr.restlet.proto3.server.component;

import static org.junit.Assert.fail;

import java.util.logging.Level;

import org.junit.Assert;
import org.junit.Test;
import org.ngr.restlet.proto3.server.filter.BlockerIP;
import org.ngr.restlet.proto3.server.resource.AccountServerResource;
import org.ngr.restlet.proto3.server.resource.AccountsServerResource;
import org.ngr.restlet.proto3.server.resource.RootServerResource;
import org.ngr.restlet.proto3.server.restlet.Tracer;
import org.restlet.Application;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.Server;
import org.restlet.data.Method;
import org.restlet.data.Protocol;
import org.restlet.engine.Engine;
import org.restlet.routing.Router;

/**
 * Hello world!
 *
 */
public class MailServerComponentTest extends Application
{
	@Test
	public void testVirtualHost() {
		MailserverComponent component = new MailserverComponent();
		Request request = new Request();
		request.setMethod(Method.GET);
		request.setResourceRef("http://www.cfvxcrmep.org/accounts/");
		request.setHostRef("http://www.rmep.org");
		Response response = new Response(request);
		response.getServerInfo().setAddress("1.2.3.10");
		response.getServerInfo().setPort(80);
		component.handle(request,response);
		Assert.assertTrue(response.getStatus().isSuccess());

	}
}
