package org.ngr.restlet.proto2.client;

import org.restlet.resource.ClientResource;

public class MailClient {

	public static void main(String[] args) throws Exception {
		ClientResource mailRoot = new ClientResource("http://localhost:8111/");
		mailRoot.get().write(System.out);
		mailRoot.delete().write(System.out);
		mailRoot.options().write(System.out);
	}

}
