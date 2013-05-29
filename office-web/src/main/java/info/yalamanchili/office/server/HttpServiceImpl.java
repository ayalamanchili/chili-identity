package info.yalamanchili.office.server;

import info.chili.http.SyncHttp;
import info.yalamanchili.office.client.rpc.HttpService;
import info.yalamanchili.office.config.OfficeWebConfiguration;
import static info.yalamanchili.office.server.FileServiceImpl.PORTAL_AUTH_HEADER_ATTR;
import info.yalamanchili.office.server.config.OfficeWebSpringContext;
import java.util.HashMap;

import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.methods.HttpRequestBase;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/**/httpService")
public class HttpServiceImpl extends BaseRemoteService implements HttpService {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = Logger.getLogger(HttpServiceImpl.class.getName());
    @Autowired
    OfficeWebConfiguration officeWebConfiguration;

    @Override
    public String login(String username, String password) throws Exception {
        populateAuthorizationHeader(username, password);
        JSONObject user = new JSONObject();
        user.put("username", username);
        user.put("passwordHash", password);
        return doPut("office/resources/secured/admin/login", user.toString(), addHeaders(), true);
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
        this.getThreadLocalRequest().getSession().invalidate();
    }

    protected Map<String, String> addHeaders() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        if (this.getThreadLocalRequest().getSession().getAttribute(FileServiceImpl.PORTAL_AUTH_HEADER_ATTR) != null) {
            headers.put("Authorization", (String) this.getThreadLocalRequest().getSession().getAttribute(FileServiceImpl.PORTAL_AUTH_HEADER_ATTR));
        }
        return headers;
    }

    protected void populateAuthorizationHeader(String username, String password) {
        this.getThreadLocalRequest().getSession().removeAttribute(FileServiceImpl.PORTAL_AUTH_HEADER_ATTR);
        this.getThreadLocalRequest().getSession().setAttribute(FileServiceImpl.PORTAL_AUTH_HEADER_ATTR, "Basic " + new String(Base64.encodeBase64((username + ":" + password).getBytes())));
    }
}
