/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.i94Record;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class UpdateI94RecordPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateI94RecordPanel.class.getName());

    public UpdateI94RecordPanel(JSONObject entity) {
        initUpdateComposite(entity, "i94Record", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("i94RecordNumber", entity);
        assignEntityValueFromField("dateofEntry", entity);
        assignEntityValueFromField("admitUntilDate", entity);
        assignEntityValueFromField("portOfEntry", entity);
        assignEntityValueFromField("classOfAdmission", entity);
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
        assignFieldValueFromEntity("i94RecordNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("dateofEntry", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("admitUntilDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("portOfEntry", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("classOfAdmission", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated I94Record");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllI94RecordPanel(TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("i94RecordNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dateofEntry", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("admitUntilDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("portOfEntry", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("classOfAdmission", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "i94record/save/" + TreeEmployeePanel.instance().getEntityId();
    }

}
