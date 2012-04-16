package info.yalamanchili.office.server;

import info.yalamanchili.http.SyncHttp;
import info.yalamanchili.office.client.rpc.HttpService;

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

}
