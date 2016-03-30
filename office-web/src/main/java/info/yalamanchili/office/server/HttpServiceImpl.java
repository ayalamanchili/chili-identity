/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.server;

import info.chili.gwt.server.AbstractHttpService;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/**/httpService")
@Component
@Scope("session")
public class HttpServiceImpl extends AbstractHttpService implements Serializable {

    private static final long serialVersionUID = 1L;
    @Autowired
    OfficeWebConfiguration officeWebConfiguration;

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
}
