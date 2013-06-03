/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.config;

/**
 *
 * @author ayalamanchili
 */
public class OfficeClientConfigTest implements OfficeClientConfig {

    @Override
    public String getFileUploadUrl() {
        return "http://yalamanchili.info:8080/office-web/office/rpc/fileService";
    }

    @Override
    public String getFileDownloadUrl() {
        return "http://yalamanchili.info:8080/office-web/office/rpc/fileService?path=";
    }
}
