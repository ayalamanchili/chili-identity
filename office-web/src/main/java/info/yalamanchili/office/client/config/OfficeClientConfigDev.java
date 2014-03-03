/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.config;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.TimeZone;
import com.google.gwt.i18n.client.constants.TimeZoneConstants;
import java.util.Date;

/**
 *
 * @author ayalamanchili
 */
public class OfficeClientConfigDev implements OfficeClientConfig {

    TimeZoneConstants tzConstants;

    public OfficeClientConfigDev() {
        tzConstants = (TimeZoneConstants) GWT.create(TimeZoneConstants.class);
    }

    @Override
    public String getFileUploadUrl() {
        return "http://localhost:9090/office-web/office/rpc/fileService";
    }
//TODO make this commom url  and remove the path and let the fileservice servlet handle the logic

    @Override
    public String getFileDownloadUrl() {
        return "http://localhost:9090/office-web/office/rpc/fileService?path=";
    }

    @Override
    public String getPortalDocumentationSiteUrl() {
        return "http://localhost/site/office/";
    }

    @Override
    public TimeZone getTimeZone() {
        return TimeZone.createTimeZone(0);
    }
}
