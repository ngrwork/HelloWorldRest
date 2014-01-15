package org.ngr.restlet.proto2;

import org.restlet.resource.Get;
import org.restlet.resource.Options;

public interface IRootResource {

	@Get("txt")
	public String represent();

	@Options("txt")
	public String describe();

}