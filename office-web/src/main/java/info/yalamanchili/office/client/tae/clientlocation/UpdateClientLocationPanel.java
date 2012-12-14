/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.clientlocation;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.UpdateComposite;
import info.yalamanchili.office.client.rpc.HttpService;

/**
 *
 * @author Prashanthi
 */
public class UpdateClientLocationPanel extends UpdateComposite {

    public UpdateClientLocationPanel(JSONObject entity) {
        initUpdateComposite(entity, "ClientLocation", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("firstName", entity);
        assignEntityValueFromField("middleInitial", entity);
        assignEntityValueFromField("lastName", entity);
        assignEntityValueFromField("sex", entity);
        assignEntityValueFromField("relation", entity);
        assignEntityValueFromField("ecPrimary", entity);
        assignEntityValueFromField("email", entity);
        assignEntityValueFromField("countryCode", entity);
        assignEntityValueFromField("phoneNumber", entity);
        assignEntityValueFromField("extension", entity);
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
        assignFieldValueFromEntity("relation", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("ecPrimary", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("firstName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("middleInitial", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lastName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("sex", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("email", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("countryCode", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("phoneNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("extension", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("successfully updated clientlocation");
        TabPanel.instance().timeandExpensePanel.sidePanelTop.clear();
        TabPanel.instance().timeandExpensePanel.sidePanelTop.add(new ClientLocationOptionsPanel());
        TabPanel.instance().timeandExpensePanel.entityPanel.clear();
        TabPanel.instance().timeandExpensePanel.entityPanel.add(new ReadAllClientLocationsPanel());
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
        addField("middleInitial", false, false, DataType.STRING_FIELD);
        addField("lastName", false, true, DataType.STRING_FIELD);
        String[] strs = {"MALE", "FEMALE"};
        addEnumField("sex", false, false, strs);
        addField("relation", false, true, DataType.STRING_FIELD);
        addField("ecPrimary", false, false, DataType.BOOLEAN_FIELD);
        addField("email", false, false, DataType.STRING_FIELD);
        addField("countryCode", false, true, DataType.STRING_FIELD);
        addField("phoneNumber", false, true, DataType.STRING_FIELD);
        addField("extension", false, true, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "clientlocation";
    }
}
