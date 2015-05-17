/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.config;

import info.chili.spring.SpringContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class OfficeFeatureFlipper {

    @Value("#{officeFeatureFlipperProperties['enableNewHomeAddressChangeProcess']}")
    protected String enableNewHomeAddressChangeProcess;

    public Boolean getEnableNewHomeAddressChangeProcess() {
        return Boolean.valueOf(enableNewHomeAddressChangeProcess);
    }

    public void setEnableNewHomeAddressChangeProcess(String enableNewHomeAddressChangeProcess) {
        this.enableNewHomeAddressChangeProcess = enableNewHomeAddressChangeProcess;
    }

    @Value("#{officeFeatureFlipperProperties['enablePersistedResourceBundles']}")
    protected Boolean enablePersistedResourceBundles;

    public Boolean getEnablePersistedResourceBundles() {
        return enablePersistedResourceBundles;
    }

    public void setEnablePersistedResourceBundles(Boolean enablePersistedResourceBundles) {
        this.enablePersistedResourceBundles = enablePersistedResourceBundles;
    }

    public static OfficeFeatureFlipper instance() {
        return SpringContext.getBean(OfficeFeatureFlipper.class);
    }

}
