package org.ngr.restlet.proto3.server.resource;

import org.ngr.restlet.proto3.rest.resource.IRootResource;
import org.restlet.resource.ServerResource;

public class RootServerResource extends ServerResource implements IRootResource {


	

	public String represent() {
		getLogger().fine("The GET method2 of root resource was invoked");
		return "This is the root resource";
	}

	
}
