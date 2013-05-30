package info.yalamanchili.office.server;

import info.chili.gwt.server.AbstractHttpService;
import info.yalamanchili.office.config.OfficeWebConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/**/httpService")
public class HttpServiceImpl extends AbstractHttpService {

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
}
