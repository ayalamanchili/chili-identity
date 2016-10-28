/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.server;

import info.chili.gwt.server.AbstractHttpService;
import java.io.Serializable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/**/httpService")
@Component
@Scope("session")
public class HttpServiceImpl extends AbstractHttpService implements Serializable {

    private static final long serialVersionUID = 1L;
    @Autowired
    OfficeWebConfiguration officeWebConfiguration;

    @Autowired
    protected RestTemplate restTemplate;

    @Override
    protected String getServicesRootURL() {
        return officeWebConfiguration.getOfficeServicesRootURL();
    }

    @Override
    protected String getLoginPath() {
        return officeWebConfiguration.getOfficeServicesContextRootBase() + "admin/login";
    }

    @Override
    protected String getPublicUrlPath() {
        return "/public/";
    }

    @Override
    public String doPut(String url, String body, Map<String, String> headers, boolean newClient) {
        HttpEntity<String> entity = new HttpEntity<>(body, convertToMultiMap(addHeaders(headers, url)));
        ResponseEntity<String> response = restTemplate.exchange(getServicesRootURL() + url, HttpMethod.PUT, entity, String.class);
        return response.getBody();
    }

    @Override
    public String doGet(String url, Map<String, String> headers, boolean newClient) {
        HttpEntity<String> entity = new HttpEntity<>(convertToMultiMap(addHeaders(headers, url)));
        ResponseEntity<String> response = restTemplate.exchange(getServicesRootURL() + url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }

    protected MultiValueMap<String, String> convertToMultiMap(Map<String, String> headers) {
        MultiValueMap<String, String> mmap = new LinkedMultiValueMap();
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            mmap.add(entry.getKey(), entry.getValue());
        }
        return mmap;
    }
}
