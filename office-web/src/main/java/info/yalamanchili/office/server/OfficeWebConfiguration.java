/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.server;

import org.springframework.stereotype.Component;

@Component
public class OfficeWebConfiguration {

    protected String officeServicesRootURL = "http://localhost:9080/";
    protected String officeServicesContextRootBase = "office/resources/secured/";

    public String getOfficeServicesRootURL() {
        return officeServicesRootURL;
    }

    public void setOfficeServicesRootURL(String officeServicesRootURL) {
        this.officeServicesRootURL = officeServicesRootURL;
    }

    public String getOfficeServicesContextRootBase() {
        return officeServicesContextRootBase;
    }

    public void setOfficeServicesContextRootBase(String officeServicesContextRootBase) {
        this.officeServicesContextRootBase = officeServicesContextRootBase;
    }

    public String getOfficeServicesUrl() {
        return getOfficeServicesRootURL() + getOfficeServicesContextRootBase();
    }
}
