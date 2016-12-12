/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.company;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author chaitanya.k
 */
public class UpdateCompanyPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateCompanyPanel.class.getName());

    FileuploadField logoURLUploadPanel = new FileuploadField(OfficeWelcome.constants, "Company", "logoURL", "Company/logoURL", false) {
        @Override
        public void onUploadComplete(String res) {
            postUpdateSuccess(null);
        }
    };
    protected static HTML generalInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Image should not exceed more than 2mb </strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");

    public UpdateCompanyPanel(JSONObject entity) {
        initUpdateComposite(entity, "Company", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("name", entity);
        assignEntityValueFromField("establishedDate", entity);
        assignEntityValueFromField("abbreviation", entity);
        entity.put("logoURL", logoURLUploadPanel.getFileName());
        return entity;

    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        uploadImage(JSONUtils.toString(entity, "id"));
                    }
                });

    }

    protected void uploadImage(String entityId) {
        logoURLUploadPanel.upload(entityId.trim());
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("establishedDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("abbreviation", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Company Information");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllCompanyPanel());

    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("name", false, true, DataType.STRING_FIELD);
        addField("establishedDate", false, true, DataType.DATE_FIELD);
        addField("abbreviation", false, false, DataType.STRING_FIELD);
        entityFieldsPanel.add(generalInfo);
        entityFieldsPanel.add(logoURLUploadPanel);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "company/save";
    }
}
