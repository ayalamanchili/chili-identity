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
public class OfficeClientConfigProd implements OfficeClientConfig {

    public String getFileUploadUrl() {
        return "https://apps.sstech.us/office/resources/file/upload";
    }

    public String getFileDownloadUrl() {
        return "https://apps.sstech.us/office/resources/file/download?path=";
    }
}
