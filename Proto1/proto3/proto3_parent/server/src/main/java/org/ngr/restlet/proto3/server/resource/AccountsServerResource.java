package org.ngr.restlet.proto3.server.resource;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.ngr.restlet.proto3.rest.resource.IAccountsResource;
import org.restlet.resource.ServerResource;

public class AccountsServerResource extends ServerResource implements IAccountsResource {
	private static final List<String> accounts = new CopyOnWriteArrayList<String>();

	public String represent() {
		
		StringBuilder result = new StringBuilder();
		for (String account : getAccounts()) {
			result.append((account==null)?"":account).append('\n');
			
		}
		return result.toString();
	}

	public String add(String account) {
		getAccounts().add(account);
		return Integer.toString(getAccounts().indexOf(account));
	}

	public static List<String> getAccounts() {
		return accounts;
	}
	

}
