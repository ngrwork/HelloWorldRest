package org.ngr.restlet.proto3.rest.resource;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

public interface IAccountResource {

		@Get("txt")
		public String represent();
		
		@Put("txt")
		public void store (String account);
		
		@Delete("txt")
		public void remove();
}
