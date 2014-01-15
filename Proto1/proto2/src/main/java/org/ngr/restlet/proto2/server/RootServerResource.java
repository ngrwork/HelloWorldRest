package org.ngr.restlet.proto2.server;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class RootServerResource extends ServerResource {

	public RootServerResource() {
		super();
		setNegotiated(false);
		setExisting(false);
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
	
	@Override
	protected Representation get() throws ResourceException {
		getLogger().fine("The GET method of root resource was invoked");
		return new StringRepresentation("This is the root repource");
	}
	
	@Override
	protected Representation options() throws ResourceException {
		getLogger().fine("The OPTIONS method of root resource was invoked");
		throw new RuntimeException("This is the root repource");
	}
}
