/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.config;

import info.yalamanchili.office.client.config.OfficeClientConfig;

/**
 *
 * @author ayalamanchili
 */
public class OfficeClientConfigDev implements OfficeClientConfig {

    public String getFileUploadUrl() {
        return "http://localhost:9090/office-web/office/rpc/fileService";
    }
//TODO make this commom url  and remove the path and let the fileservice servlet handle the logic

    public String getFileDownloadUrl() {
        return "http://localhost:9090/office-web/office/rpc/fileService?path=";
    }
}
