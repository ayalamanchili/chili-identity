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
        return "http://localhost:9080/office/resources/file/upload";
    }

    public String getFileDownloadUrl() {
        return "http://localhost:9080/office/resources/file/download?path=";
    }
}
