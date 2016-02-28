/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.config;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.TimeZone;
import com.google.gwt.i18n.client.constants.TimeZoneConstants;

/**
 *
 * @author ayalamanchili
 */
public class OfficeClientConfigGCETest implements OfficeClientConfig {

    TimeZoneConstants tzConstants;

    public OfficeClientConfigGCETest() {
        tzConstants = (TimeZoneConstants) GWT.create(TimeZoneConstants.class);
    }

    @Override
    public String getFileUploadUrl() {
        return "http://107.178.211.215:9080/office-web/office/rpc/fileService";
    }

    @Override
    public String getFileDownloadUrl() {
        return "http://107.178.211.215:9080/office-web/office/rpc/fileService?path=";
    }

    @Override
    public String getPortalDocumentationSiteUrl() {
        return "http://107.178.211.215/site/office/";
    }

    @Override
    public String getFileConverterUrl() {
        return "http://107.178.211.215:9080/office-web/office/rpc/fileConverterService";
    }

    @Override
    public TimeZone getTimeZone() {
        return TimeZone.createTimeZone(tzConstants.asiaCalcutta());
    }
}
