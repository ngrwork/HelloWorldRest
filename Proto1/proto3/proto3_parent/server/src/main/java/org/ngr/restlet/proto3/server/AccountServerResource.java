package org.ngr.restlet.proto3.server;

import org.ngr.restlet.proto3.rest.resource.IAccountResource;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class AccountServerResource extends ServerResource implements IAccountResource {

	private int accountId;
	
	@Override
	protected void doInit() throws ResourceException {
		super.doInit();
		this.accountId = Integer.parseInt(getAttribute("accouniId"));
	}
	
	public String represent() {
		return AccountsServerResource.getAccounts().get(this.accountId);
	}

	public void store(String account) {
		AccountsServerResource.getAccounts().set(accountId, account);
	}

	public void remove() {
		AccountsServerResource.getAccounts().remove(accountId);	
	}
	

}
