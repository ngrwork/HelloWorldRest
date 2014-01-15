package org.ngr.restlet.proto2.server;

import org.ngr.restlet.proto2.IRootResource;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class RootServerResource extends ServerResource implements IRootResource {

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

	
	/* (non-Javadoc)
	 * @see org.ngr.restlet.proto2.server.IRootResource#represent()
	 */
	public String represent() {
		getLogger().fine("The GET method2 of root resource was invoked");
		return "This is the root resource";
	}
	
	/* (non-Javadoc)
	 * @see org.ngr.restlet.proto2.server.IRootResource#describe()
	 */
	public String describe() {
		getLogger().fine("The OPTIONS method of root resource was invoked");
		throw new RuntimeException("This is the root repource");
	}
	
}
