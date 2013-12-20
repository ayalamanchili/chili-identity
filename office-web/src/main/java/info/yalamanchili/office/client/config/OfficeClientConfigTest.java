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
public class OfficeClientConfigTest implements OfficeClientConfig {

    @Override
    public String getFileUploadUrl() {
        return "http://yalamanchili.info/office-web/office/rpc/fileService";
    }

    @Override
    public String getFileDownloadUrl() {
        return "http://yalamanchili.info/office-web/office/rpc/fileService?path=";
    }

    @Override
    public String getPortalDocumentationSiteUrl() {
        return "http://yalamanchili.info/site/office/";
    }
}
