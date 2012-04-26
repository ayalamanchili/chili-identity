package info.yalamanchili.office.server;

import info.yalamanchili.http.SyncHttp;
import info.yalamanchili.office.client.rpc.HttpService;

import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.codec.binary.Base64;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

//TODO this should extends from spring aware servlet
public class HttpServiceImpl extends RemoteServiceServlet implements
		HttpService {
	private final static Logger logger = Logger.getLogger(HttpServiceImpl.class
			.getName());

	@Override
	public String doPut(String url, String body, Map<String, String> headers) {
		return SyncHttp.httpPut(url, body, processBasicAuthHeader(headers));
	}

	@Override
	public String doGet(String url, Map<String, String> headers) {
		return SyncHttp.httpGet(url, processBasicAuthHeader(headers));
	}

	protected Map<String, String> processBasicAuthHeader(
			Map<String, String> headers) {
		if (headers != null && headers.keySet().contains("username")
				&& headers.keySet().contains("password")) {
			String username = headers.get("username");
			String password = headers.get("password");
			if (username != null && password != null) {
				headers.remove("username");
				headers.remove("password");
				headers.put(
						"Authorization",
						"Basic "
								+ new String(Base64.encodeBase64((username
										+ ":" + password).getBytes())));
			}
		}
		return headers;
	}
}
