package org.ngr.restlet.proto3.rest.resource;

import org.restlet.resource.Get;
import org.restlet.resource.Post;

public interface IAccountsResource {

		@Get("txt")
		public String represent();
		
		@Post("txt")
		public String add (String account);
}
