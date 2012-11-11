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
 *
 */
/**
 * This servlet acts a proxy routher to fileService to add authentication header
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
        //prepare request
        HttpPost post = new HttpPost(officeWebConfiguration.getOfficeServicesUrl() + "file/upload");
        HttpHelper.copyHeaders(request, post, "Content-Length", "Host");
        HttpHelper.copyBody(request, post);
        addAuthenticationHeader(post);
        //Make call
        HttpResponse resp = HttpHelper.getHttpClient(true).execute(post);
        //process and map response back
        HttpHelper.copyStatusAndHeaders(response, resp);
        HttpHelper.copyBody(response, resp);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.log(Level.INFO, "in FileService Get");
        //prepare request
        HttpGet get = new HttpGet(officeWebConfiguration.getOfficeServicesUrl() + "file/download?" + request.getQueryString());
        HttpHelper.copyHeaders(request, get, "Content-Length", "Host");
        addAuthenticationHeader(get);
        //TODO change to false
        //Make call
        HttpResponse resp = HttpHelper.getHttpClient(true).execute(get);
        //process and map response back
        HttpHelper.copyStatusAndHeaders(response, resp);
        HttpHelper.copyBody(response, resp);
    }

    protected void addAuthenticationHeader(HttpRequestBase request) {
        request.addHeader("Authorization", "Basic " + new String(Base64.encodeBase64((username + ":" + password).getBytes())));
    }
}
