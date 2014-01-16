package org.ngr.restlet.proto3.client;


import org.ngr.restlet.proto3.rest.resource.IRootResource;
import org.restlet.resource.ClientResource;

public class MailClient {

	public static void main(String[] args) throws Exception {
		IRootResource mailRoot = ClientResource.create("http://localhost:8111/",IRootResource.class);
		String result = mailRoot.represent();
		System.out.println(result);
	}

}
