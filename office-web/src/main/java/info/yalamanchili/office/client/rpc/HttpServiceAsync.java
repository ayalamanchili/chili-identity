package info.yalamanchili.office.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HttpServiceAsync {
	public void doPut(String url, String body, AsyncCallback<String> response);
}
