package org.ngr.restlet.proto3.rest.resource;

import org.restlet.resource.Get;

public interface IRootResource {

		@Get("txt")
		public String represent();
}
