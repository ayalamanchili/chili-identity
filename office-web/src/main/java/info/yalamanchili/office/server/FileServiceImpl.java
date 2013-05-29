/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.server;

import info.chili.http.HttpHelper;
import info.yalamanchili.office.config.OfficeWebConfiguration;
import info.yalamanchili.office.server.config.OfficeWebSpringContext;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author yphanikumar
 *
 */
/**
 * This servlet acts a proxy router to fileService to add authentication header
 */
@RequestMapping("/**/fileService")
@Scope("session")
public class FileServiceImpl extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final static Logger logger = Logger.getLogger(FileServiceImpl.class.getName());
    protected final static String PORTAL_AUTH_HEADER_ATTR = "portal-auth-header";
    protected OfficeWebConfiguration officeWebConfiguration;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.log(Level.INFO, "in FileService Post");
        //prepare request
        HttpPost post = new HttpPost(getOfficeWebConfiguration().getOfficeServicesUrl() + "file/upload");
        HttpHelper.copyHeaders(request, post, "Content-Length", "Host");
        HttpHelper.copyBody(request, post);
        addAuthenticationHeader(post, request);
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
        HttpGet get = new HttpGet(getOfficeWebConfiguration().getOfficeServicesUrl() + "file/download?" + request.getQueryString());
        HttpHelper.copyHeaders(request, get, "Content-Length", "Host");
        addAuthenticationHeader(get, request);
        //TODO change to false
        //Make call
        HttpResponse resp = HttpHelper.getHttpClient(true).execute(get);
        //process and map response back
        HttpHelper.copyStatusAndHeaders(response, resp);
        HttpHelper.copyBody(response, resp);
    }

    protected void addAuthenticationHeader(HttpRequestBase body, HttpServletRequest request) {
        if (request.getSession(false).getAttribute(PORTAL_AUTH_HEADER_ATTR) != null) {
            body.addHeader("Authorization", (String) request.getSession().getAttribute(PORTAL_AUTH_HEADER_ATTR));
        }
    }

    protected OfficeWebConfiguration getOfficeWebConfiguration() {
        if (officeWebConfiguration == null) {
            officeWebConfiguration = OfficeWebSpringContext.getBean(OfficeWebConfiguration.class);
        }
        return officeWebConfiguration;
    }
}
