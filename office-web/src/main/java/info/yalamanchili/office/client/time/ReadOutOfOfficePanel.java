/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time;

import com.google.gwt.dom.client.Style;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author Ramana.Lukalapu
 */
public class ReadOutOfOfficePanel extends ReadComposite{
    
    private static ReadOutOfOfficePanel instance;
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employee", "Employee", true, true, Alignment.HORIZONTAL);
    public static ReadOutOfOfficePanel instance() {
        return instance;
    }

    public ReadOutOfOfficePanel(String id) {
        instance = this;
        initReadComposite(id, "OutOfOffice", OfficeWelcome.constants);
    }
    
    @Override
    public void loadEntity(String entityId) {
         HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        JSONObject emp = (JSONObject) entity.get("employee");
        if (emp != null) {
            employeeSB.setValue(emp.get("firstName").isString().stringValue());
        }
        assignFieldValueFromEntity("workType", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("reason", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("contactNo", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("time", entity, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        employeeSB.getLabel().getElement().getStyle().setWidth(145, Style.Unit.PX);
    }

    @Override
    protected void addWidgets() {
        entityFieldsPanel.add(employeeSB);
        addEnumField("workType", true, true, OutOfOfficeType.names(), Alignment.HORIZONTAL);
        addField("startDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("endDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("reason", true, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("contactNo", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("time", true, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "out-of-office/" + getEntityId();
    }
    
}
