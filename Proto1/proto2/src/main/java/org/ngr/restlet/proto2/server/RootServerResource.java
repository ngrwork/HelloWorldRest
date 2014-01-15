package org.ngr.restlet.proto2.server;

import org.restlet.resource.Get;
import org.restlet.resource.Options;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class RootServerResource extends ServerResource {

	public RootServerResource() {
		super();
		setNegotiated(false);
		//setExisting(false);
	}
	
	@Override
	protected void doInit() throws ResourceException {
		getLogger().fine("The root resource was initiliazed");
	}
	
	@Override
	protected void doCatch(Throwable throwable) {
		getLogger().fine("An exception was thrown in the root resource");
	}
	
	@Override
	protected void doRelease() throws ResourceException {
		getLogger().fine("The root resource was release");
	}

	
	@Get("txt")
	public String represent() {
		getLogger().fine("The GET method2 of root resource was invoked");
		return "This is the root resource";
	}
	
	@Options("txt")
	public String describe() {
		getLogger().fine("The OPTIONS method of root resource was invoked");
		throw new RuntimeException("This is the root repource");
	}
	
}
