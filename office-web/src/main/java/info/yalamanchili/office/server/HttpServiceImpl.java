package info.yalamanchili.office.server;

import info.yalamanchili.http.SyncHttp;
import info.yalamanchili.office.client.rpc.HttpService;

import java.util.Map;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

//TODO this should extends from spring aware servlet
public class HttpServiceImpl extends RemoteServiceServlet implements
		HttpService {

	@Override
	public String doPut(String url, String body) {
		System.out.println(url);
		System.out.println(body);
		return SyncHttp.httpPut(url, body, "application/json");
	}

	@Override
	public String doGet(String url, Map<String, String> headers) {
		System.out.println(url);
		return SyncHttp.httpGet(url);
	}

}
