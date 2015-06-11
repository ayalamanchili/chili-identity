/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.statusreport;

import com.axeiya.gwtckeditor.client.CKConfig;
import com.axeiya.gwtckeditor.client.CKEditor;

/**
 *
 * @author ayalamanchili
 */
public class Editor {
    
    public static CKEditor getEditor() {
        
        CKConfig config = new CKConfig(CKConfig.PRESET_TOOLBAR.BASIC);
        config.setBaseFloatZIndex(1000);
        config.setUseFormPanel(false);
        config.setHeight("400px");
        CKEditor ckeEditor = new CKEditor(config);
        //Creates the editor with this config
        return ckeEditor;
    }
    
}
