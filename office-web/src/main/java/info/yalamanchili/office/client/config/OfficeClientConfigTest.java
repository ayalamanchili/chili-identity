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
public class OfficeClientConfigTest implements OfficeClientConfig {

    public String getFileUploadUrl() {
        return "http://yalamanchili.info:8080/office-web/office/rpc/fileService";
    }

    public String getFileDownloadUrl() {
        return "http://yalamanchili.info:8080/office-web/office/rpc/fileService?path=";
    }
}
