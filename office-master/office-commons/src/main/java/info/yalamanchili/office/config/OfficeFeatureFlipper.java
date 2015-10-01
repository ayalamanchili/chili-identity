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

    @Value("#{officeFeatureFlipperProperties['enableIPFiltering']}")
    protected Boolean enableIPFiltering;

    public Boolean getEnableIPFiltering() {
        return enableIPFiltering;
    }

    public void setEnableIPFiltering(Boolean enableIPFiltering) {
        this.enableIPFiltering = enableIPFiltering;
    }
    
    @Value("#{officeFeatureFlipperProperties['enableEmailTaskCompletion']}")
    protected Boolean enableEmailTaskCompletion;

    public Boolean getEnableEmailTaskCompletion() {
        return enableEmailTaskCompletion;
    }

    public void setEnableEmailTaskCompletion(Boolean enableEmailTaskCompletion) {
        this.enableEmailTaskCompletion = enableEmailTaskCompletion;
    }

    public static OfficeFeatureFlipper instance() {
        return SpringContext.getBean(OfficeFeatureFlipper.class);
    }

}
