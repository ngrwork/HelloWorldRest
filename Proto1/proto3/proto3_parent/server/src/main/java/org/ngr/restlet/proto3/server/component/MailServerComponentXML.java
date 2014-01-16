package org.ngr.restlet.proto3.server.component;

import org.restlet.Component;

public class MailServerComponentXML {

	public MailServerComponentXML() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		Component.main(new String[]{MailserverComponent.class.getResource("/component-simple.xml").toURI().toString()});
	}

}
