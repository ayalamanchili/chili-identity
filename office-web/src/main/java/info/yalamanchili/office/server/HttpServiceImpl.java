package info.yalamanchili.office.server;

import info.yalamanchili.http.SyncHttp;
import info.yalamanchili.office.client.rpc.HttpService;
import info.yalamanchili.office.config.OfficeWebConfiguration;

import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/**/httpService")
public class HttpServiceImpl extends BaseRemoteService implements HttpService {

	private static final long serialVersionUID = 1L;
	private final static Logger logger = Logger.getLogger(HttpServiceImpl.class.getName());

	@Autowired
	OfficeWebConfiguration officeWebConfiguration;

	@Override
	public String doPut(String url, String body, Map<String, String> headers, boolean newClient) {
		return SyncHttp.httpPut(officeWebConfiguration.getOfficeServicesRootURL() + url, body,
				processBasicAuthHeader(headers), newClient);
	}

	@Override
	public String doGet(String url, Map<String, String> headers, boolean newClient) {
		return SyncHttp.httpGet(officeWebConfiguration.getOfficeServicesRootURL() + url,
				processBasicAuthHeader(headers), newClient);
	}

	protected Map<String, String> processBasicAuthHeader(Map<String, String> headers) {
		if (headers != null && headers.keySet().contains("username") && headers.keySet().contains("password")) {
			String username = headers.get("username");
			String password = headers.get("password");
			if (username != null && password != null) {
				headers.remove("username");
				headers.remove("password");
				headers.put("Authorization",
						"Basic " + new String(Base64.encodeBase64((username + ":" + password).getBytes())));
			}
		}
		return headers;
	}
}
