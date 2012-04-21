package info.yalamanchili.office.client.rpc;

import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface HttpService extends RemoteService {

	public String doPut(String url, String body);

	public String doGet(String url, Map<String, String> headers);

	/** proxy */
	public static class HttpServiceAsync {
		private static info.yalamanchili.office.client.rpc.HttpServiceAsync service;

		public static synchronized info.yalamanchili.office.client.rpc.HttpServiceAsync instance() {
			if (service == null) {
				service = (info.yalamanchili.office.client.rpc.HttpServiceAsync) GWT
						.create(HttpService.class);
				ServiceDefTarget endpoint = (ServiceDefTarget) service;
				String moduleRelativeURL = GWT.getModuleBaseURL()
						+ "office-web";
				endpoint.setServiceEntryPoint(moduleRelativeURL);
			}
			return service;
		}
	}
}
