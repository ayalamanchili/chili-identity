/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.server;

import info.chili.http.HttpHelper;
import info.chili.http.SyncHttp;
import info.yalamanchili.office.config.OfficeWebConfiguration;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.InputStreamEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author yphanikumar
 */
@RequestMapping("/**/fileService")
@Scope("session")
public class FileServiceImpl extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = Logger.getLogger(FileServiceImpl.class.getName());
    private static final String username = "adminadmin";
    private static final String password = "adminadmin";
    //TODO injection not working
    @Autowired
    OfficeWebConfiguration officeWebConfiguration = new OfficeWebConfiguration();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.log(Level.INFO, "in FileService Post");
        swapPostUrlAndHeaders(request, officeWebConfiguration.getOfficeServicesUrl() + "file/upload", true);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.log(Level.INFO, "in FileService Get");
        logger.log(Level.INFO, request.getQueryString());
        HttpGet get = new HttpGet(officeWebConfiguration.getOfficeServicesUrl() + "file/download?" + request.getQueryString());
        //transfer headers
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String headerName = headers.nextElement();
            String headerValue = request.getHeader(headerName);
            // Skip Content-Length and Host
            String lowerHeader = headerName.toLowerCase();
            if (lowerHeader.equals("content-length") == false && lowerHeader.equals("host") == false) {
                get.addHeader(headerName, headerValue);
            }
        }
        addAuthenticationHeader(get);
        //TODO change to false
        HttpResponse resp = HttpHelper.getHttpClient(true).execute(get);

        // Transfer status code to the response
        StatusLine status = resp.getStatusLine();
        response.setStatus(status.getStatusCode());
        // resp.setStatus(status.getStatusCode(), status.getReasonPhrase()); // This seems to be deprecated. Yes status message is "ambigous", but I don't approve

        // Transfer headers to the response
        Header[] responseHeaders = resp.getAllHeaders();
        for (int i = 0; i < responseHeaders.length; i++) {
            Header header = responseHeaders[i];
            response.addHeader(header.getName(), header.getValue());
        }

        // Transfer proxy response entity to the servlet response
        HttpEntity entity = resp.getEntity();
        InputStream input = entity.getContent();
        OutputStream output = response.getOutputStream();
        int b = input.read();
        while (b != -1) {
            output.write(b);
            b = input.read();
        }

        // Clean up
        input.close();
        output.close();
    }

    /**
     * this method will change the request url with one provided and add any
     * additional headers provided
     */
    public String swapPostUrlAndHeaders(HttpServletRequest request, String url, boolean newClient) throws IOException {
        HttpPost post = new HttpPost(url);
        int contentLength = request.getContentLength();
        InputStreamEntity entity = new InputStreamEntity(request.getInputStream(), contentLength);
        post.setEntity(entity);
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String headerName = headers.nextElement();
            String headerValue = request.getHeader(headerName);
            // Skip Content-Length and Host
            String lowerHeader = headerName.toLowerCase();
            if (lowerHeader.equals("content-length") == false && lowerHeader.equals("host") == false) {
                post.addHeader(headerName, headerValue);
            }
        }
        logger.log(Level.INFO, "post url{0}", post.getURI().getPath());
        return SyncHttp.executeHttpCall(post, null,
                getAuthenticationHeaders(), newClient);
    }

    protected Map<String, String> getAuthenticationHeaders() {
        Map<String, String> headers = new HashMap<String, String>();
        //TODO get user and password from sessiona and add they
        headers.put("Authorization",
                "Basic " + new String(Base64.encodeBase64((username + ":" + password).getBytes())));
        return headers;
    }

    protected void addAuthenticationHeader(HttpRequestBase request) {
        request.addHeader("Authorization", "Basic " + new String(Base64.encodeBase64((username + ":" + password).getBytes())));
    }
}