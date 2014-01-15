package org.ngr.restlet.proto2.client;

import org.ngr.restlet.proto2.IRootResource;
import org.restlet.resource.ClientResource;

public class MailClient {

	public static void main(String[] args) throws Exception {
		IRootResource mailRoot = ClientResource.create("http://localhost:8111/",IRootResource.class);
		String result = mailRoot.describe();
		System.out.println(result);
	}

}
