/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.company;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;

/**
 *
 * @author chaitanya.k
 */
public class UpdateCompanyPanel extends UpdateComposite {

    public UpdateCompanyPanel(JSONObject entity) {
        initUpdateComposite(entity, "Company", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("employees", entity);
        assignEntityValueFromField("name", entity);
        assignEntityValueFromField("establishedDate", entity);
        assignEntityValueFromField("logoURL", entity);
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
        assignFieldValueFromEntity("employees", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("esatablished date", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("logoURL", entity, DataType.IMAGE_FIELD);

    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Company");
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
        addField("employees", false, true, DataType.STRING_FIELD);
        addField("name", false, true, DataType.STRING_FIELD);
        addField("establishedDate", false, true, DataType.DATE_FIELD);
        addField("logoURL", false, true, DataType.IMAGE_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "company";
    }
}
