package info.yalamanchili.office.client.rpc;

import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("rpc/httpService")
public interface HttpService extends RemoteService {

	public String doPut(String url, String body, Map<String, String> headers, boolean newClient) throws Exception;

	public String doGet(String url, Map<String, String> headers, boolean newClient) throws Exception;

	/** proxy */
	public static class HttpServiceAsync {
		private static info.yalamanchili.office.client.rpc.HttpServiceAsync service;

		public static synchronized info.yalamanchili.office.client.rpc.HttpServiceAsync instance() {
			if (service == null) {
				service = (info.yalamanchili.office.client.rpc.HttpServiceAsync) GWT.create(HttpService.class);
			}
			return service;
		}
	}
}
