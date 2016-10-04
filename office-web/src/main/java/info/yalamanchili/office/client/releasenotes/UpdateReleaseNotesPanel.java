/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.releasenotes;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author Rohith.Vallabhaneni
 */
class UpdateReleaseNotesPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateReleaseNotesPanel.class.getName());

    public UpdateReleaseNotesPanel(JSONObject entity) {
        initUpdateComposite(entity, "ReleaseNotes", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("summary", entity);
        assignEntityValueFromField("details", entity);
        assignEntityValueFromField("effectiveDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("userIds", entity);
        assignEntityValueFromField("roles", entity);
        assignEntityValueFromField("moreInformationLink", entity);
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
                postUpdateSuccess(arg0);
            }
        });

    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("summary", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("details", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("effectiveDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("userIds", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("roles", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("moreInformationLink", entity, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully  Updated Release Notes");
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
        TabPanel.instance().chiliAdminPanel.entityPanel.add(new ReadAllReleaseNotesPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("summary", false, true, DataType.TEXT_AREA_FIELD);
        addField("details", false, true, DataType.RICH_TEXT_AREA);
        addField("effectiveDate", false, true, DataType.DATE_FIELD);
        addField("endDate", false, true, DataType.DATE_FIELD);
        addField("userIds", false, false, DataType.TEXT_AREA_FIELD);
        addField("roles", false, false, DataType.TEXT_AREA_FIELD);
        addField("moreInformationLink", false, false, DataType.TEXT_AREA_FIELD);

    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "releaseNotes/save";
    }

}
