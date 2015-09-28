/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.hr;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.FileuploadField;
import info.yalamanchili.office.client.OfficeWelcome;
import org.apache.log4j.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class CreateProspectPanel extends CreateComposite {
    private static Logger logger = Logger.getLogger(CreateProspectPanel.class.getName());
     FileuploadField resumeUploadPanel = new FileuploadField(OfficeWelcome.constants, "Prospect", "fileUrl", "Prospect/fileUrl", true) {
        @Override
        public void onUploadComplete(String res) {
            postCreateSuccess(null);
        }
    };
     
     public CreateProspectPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("Prospect", OfficeWelcome.constants);
    }
     
     @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("Conversation Date", entity);
        assignEntityValueFromField("ScreenedBy", entity);
        
        entity.put("fileUrl", resumeUploadPanel.getFileName());
        logger.info("ddd" + entity);
        return entity;
    }
}
