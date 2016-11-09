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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        return "http://104.197.194.6:9080/office-web/office/rpc/fileService";
    }

    @Override
    public String getFileDownloadUrl() {
        return "http://104.197.194.6:9080/office-web/office/rpc/fileService?path=";
    }

    @Override
    public String getPortalDocumentationSiteUrl() {
        return "http://104.197.194.6/site/office/";
    }

    @Override
    public String getFileConverterUrl() {
        return "http://104.197.194.6:9080/office-web/office/rpc/fileConverterService";
    }

    @Override
    public TimeZone getTimeZone() {
        return TimeZone.createTimeZone(tzConstants.asiaCalcutta());
    }

     /**
     * Max image Size 2MB
     */
    @Override
    public long getImageSizeLimit() {
        return 2000000;
    }

    /**
     * Max file size 20 MB
     */
    @Override
    public long getFileSizeLimit() {
        return 20000000;
    }

    @Override
    public List<String> getAllowedFileExtensionsAsList() {
        String[] exts = "doc,docx,rtf,txt,ppt,pptx,xls,xlsx,pdf,png,jpg,jpeg,bmp,gif,htm,html,csv,zip".split(",");
        return new ArrayList<>(Arrays.asList(exts));
    }
}
