/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.integration;

import info.chili.spring.SpringContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class ExternalServiceConfiguration {

    @Value("#{officeExternalServicesProperties['bis.endpoint']}")
    protected String bisEndPoint;

    @Value("#{officeExternalServicesProperties['bis.address.service.path']}")
    protected String bisAddressServicePath;

    @Value("#{officeExternalServicesProperties['bis.address.publish.enable']}")
    protected boolean enableBISAddressPublish;

    @ManagedAttribute
    public String getBisEndPoint() {
        return bisEndPoint;
    }

    public void setBisEndPoint(String bisEndPoint) {
        this.bisEndPoint = bisEndPoint;
    }

    @ManagedAttribute
    public String getBisAddressServicePath() {
        return bisAddressServicePath;
    }

    public void setBisAddressServicePath(String bisAddressServicePath) {
        this.bisAddressServicePath = bisAddressServicePath;
    }

    @ManagedAttribute
    public boolean isEnableBISAddressPublish() {
        return enableBISAddressPublish;
    }

    public void setEnableBISAddressPublish(boolean enableBISAddressPublish) {
        this.enableBISAddressPublish = enableBISAddressPublish;
    }

    public static ExternalServiceConfiguration instance() {
        return SpringContext.getBean(ExternalServiceConfiguration.class);
    }

}
