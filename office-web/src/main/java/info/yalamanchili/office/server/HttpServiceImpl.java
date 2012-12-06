package info.yalamanchili.office.server;

import info.chili.http.SyncHttp;
import info.yalamanchili.office.client.rpc.HttpService;
import info.yalamanchili.office.config.OfficeWebConfiguration;
import java.util.HashMap;

import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/**/httpService")
public class HttpServiceImpl extends BaseRemoteService implements HttpService {

    
    private static final long serialVersionUID = 1L;
    private final static Logger logger = Logger.getLogger(HttpServiceImpl.class.getName());
    private String username;
    private String password;
    @Autowired
    OfficeWebConfiguration officeWebConfiguration;

    @Override
    public String login(String username, String password) throws Exception {
        this.username = username;
        this.password = password;
        JSONObject user = new JSONObject();
        user.put("username", username);
        user.put("passwordHash", password);
        return doPut("office/resources/admin/login", user.toString(), addHeaders(), true);
    }

    @Override
    public String doPut(String url, String body, Map<String, String> headers, boolean newClient) {
        return SyncHttp.httpPut(officeWebConfiguration.getOfficeServicesRootURL() + url, body,
                addHeaders(), newClient);
    }

    @Override
    public String doGet(String url, Map<String, String> headers, boolean newClient) {
        return SyncHttp.httpGet(officeWebConfiguration.getOfficeServicesRootURL() + url,
                addHeaders(), newClient);
    }

    @Override
    public void logout() throws Exception {
        this.username = null;
        this.password = null;
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

    protected Map<String, String> addHeaders() {
        if (username == null || password == null) {
            throw new RuntimeException("username and/or password null may not be in session");
        }
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization",
                "Basic " + new String(Base64.encodeBase64((username + ":" + password).getBytes())));
        return headers;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
