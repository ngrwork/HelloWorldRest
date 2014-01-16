package org.ngr.restlet.proto3.client;


import org.ngr.restlet.proto3.rest.resource.IAccountResource;
import org.ngr.restlet.proto3.rest.resource.IAccountsResource;
import org.ngr.restlet.proto3.rest.resource.IRootResource;
import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.Protocol;
import org.restlet.resource.ClientResource;

public class MailClient {

	public static void main(String[] args) throws Exception {
		sysOutLn("1) Set up the service client resource");
		
		Client client = new Client(new Context(), Protocol.HTTP);
		ClientResource service = new ClientResource("http://localhost:8111");
		service.setNext(client);

		sysOutLn("2) Display the root resource");
		IRootResource mailRoot = service.getChild("/",IRootResource.class);
		System.out.println(mailRoot.represent());
		
		sysOutLn("3) Display the initail list of accounts");
		IAccountsResource mailAccounts = service.getChild("/accounts/", IAccountsResource.class);
		String list = mailAccounts.represent();
		System.out.println((list==null)?"<empty>":list);
		
		sysOutLn("4) Add new accounts");
		mailAccounts.add("Homer simpson");
		mailAccounts.add("Marjorie simpson");
		mailAccounts.add("BArt simpson");
		System.out.println("3 comptes ajoutés");
		
		sysOutLn("5) Display the updated list of accounts");
		System.out.println(mailAccounts.represent());
		
		sysOutLn("6) Display the second account");
		IAccountResource mailAccount = service.getChild("/accounts/1", IAccountResource.class);
		System.out.println(mailAccount.represent());
		
		sysOutLn("7) Update the indivudual account and display it again");
		mailAccount.store("Homer Jay Simpson");
		System.out.println(mailAccount.represent());

		
		sysOutLn("8) Delete the first account and display the list again");
		mailAccount = service.getChild("/accounts/0", IAccountResource.class);
		mailAccount.remove();
		System.out.println(mailAccounts.represent());
	}

	private static void sysOutLn(String msg) {
		System.out.println();
		System.out.println(msg);
		System.out.println();
	}

}
