package org.ngr.restlet.proto2.server;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class HelloServerResource extends ServerResource {
	@Get
	public String represent() {
		return "HEllo World!";
	}

}
