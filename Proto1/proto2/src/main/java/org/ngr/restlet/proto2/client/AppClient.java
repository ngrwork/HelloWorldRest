package org.ngr.restlet.proto2.client;

import org.restlet.resource.ClientResource;

public class AppClient {

	public static void main(String[] args) throws Exception {
		ClientResource hellClientResource = new ClientResource("http://localhost:8111/");
		hellClientResource.get().write(System.out);

	}

}
