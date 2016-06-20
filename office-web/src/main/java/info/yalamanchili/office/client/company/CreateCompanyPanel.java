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
 * @author benerji.v
 */
public class CreateCompanyPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateCompanyPanel.class.getName());

    FileuploadField logoURLUploadPanel = new FileuploadField(OfficeWelcome.constants, "Company", "logoURL", "Company/logoURL", false) {
        @Override
        public void onUploadComplete(String res) {
            postCreateSuccess(null);
        }
    };
    protected static HTML generalInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Image should not exceed more than 2mb </strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");

    public CreateCompanyPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("Company", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("name", entity);
        assignEntityValueFromField("establishedDate", entity);
        assignEntityValueFromField("abbreviation", entity);
        entity.put("logoURL", logoURLUploadPanel.getFileName());
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        logger.info(arg0.getMessage());
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        uploadImage(arg0);
                    }
                });
    }

    protected void uploadImage(String entityId) {
        logoURLUploadPanel.upload(entityId.trim());
    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Company Created Information");
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
        entityFieldsPanel.add((logoURLUploadPanel));
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "company/save";
    }
}
