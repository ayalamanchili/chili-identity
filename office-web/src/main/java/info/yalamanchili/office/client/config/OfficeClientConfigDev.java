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
        return "https://apps.sstech.us/site/office/";
    }

    @Override
    public TimeZone getTimeZone() {
        return TimeZone.createTimeZone(0);
    }

    @Override
    public String getFileConverterUrl() {
        return "http://localhost:9090/office-web/office/rpc/fileConverterService";
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
