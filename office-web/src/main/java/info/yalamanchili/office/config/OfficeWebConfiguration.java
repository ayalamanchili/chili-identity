package info.yalamanchili.office.config;

public class OfficeWebConfiguration {

    protected String officeServicesRootURL = "http://localhost:9080/";
    protected String officeServicesContextRootBase = "office/resources/";

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
