/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.hr;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class CreateProspectPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateProspectPanel.class.getName());

    FileuploadField resumeUploadPanel = new FileuploadField(OfficeWelcome.constants, "Prospect", "resumeURL", "Prospect/resumeURL", true) {
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
        assignEntityValueFromField("firstName", entity);
        assignEntityValueFromField("lastName", entity);
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("referredBy", entity);
        assignEntityValueFromField("email", entity);
        assignEntityValueFromField("phone", entity);
        assignEntityValueFromField("screenedBy", entity);
        assignEntityValueFromField("status", entity);
        entity.put("resumeURL", resumeUploadPanel.getFileName());
        logger.info("ddd" + entity);

        return entity;
    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postCreateSuccess(arg0);
                    }
                });
    }

  
    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Prospect Created");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllProspectsPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("firstName", false, true, DataType.STRING_FIELD);
        addField("lastName", false, true, DataType.STRING_FIELD);
        addField("startDate", false, true, DataType.DATE_FIELD);
        addField("referredBy", false, true, DataType.STRING_FIELD);
        addField("email", false, true, DataType.STRING_FIELD);
        addField("phone", false, true, DataType.STRING_FIELD);
        addField("screenedBy", false, false, DataType.STRING_FIELD);
        addEnumField("status", false, true, ProspectStatus.names());
        entityFieldsPanel.add(resumeUploadPanel);
        
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "prospect/save";
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        if (resumeUploadPanel.isEmpty()) {
            resumeUploadPanel.setMessage("Please select a file");
            return false;
        }
        return true;
    }
}
