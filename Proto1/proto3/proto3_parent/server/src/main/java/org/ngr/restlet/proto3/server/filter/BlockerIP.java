package org.ngr.restlet.proto3.server.filter;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Status;
import org.restlet.routing.Filter;

public class BlockerIP extends Filter {

	private  final Set<String> blockAddress;

	public BlockerIP(Context context) {
		super(context);
		this.blockAddress = new CopyOnWriteArraySet<String>();
	}

	@Override
	protected int beforeHandle(Request request, Response response) {
		int result = STOP;
		String address = request.getClientInfo().getAddress();
		if (getBlockAddress().contains(address)) {
			response.setStatus(Status.CLIENT_ERROR_FORBIDDEN, "Ton IP est bloque");
			
		} else {
			getLogger().fine("IP passante :"+
					address);
			result = CONTINUE;
		}
		return result;
	}

	public Set<String> getBlockAddress() {
		return blockAddress;
	}
	
}
