/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.config;

import info.chili.gwt.config.ClientConfig;

/**
 *
 * @author ayalamanchili
 */
public class OfficeClientConfigDev implements OfficeClientConfig {

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
}
