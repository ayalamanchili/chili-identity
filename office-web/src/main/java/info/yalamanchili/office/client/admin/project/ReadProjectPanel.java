/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.project;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.admin.client.SelectClientWidget;
import info.yalamanchili.office.client.admin.vendor.SelectVendorWidget;

/**
 *
 * @author Madhu.Badiginchala
 */
public class ReadProjectPanel extends ReadComposite {

    private static ReadProjectPanel instance;
    SelectClientWidget selectClientWidget = new SelectClientWidget(true, false,Alignment.HORIZONTAL);
    SelectVendorWidget selectVendor = new SelectVendorWidget(false, true,Alignment.HORIZONTAL);

    public static ReadProjectPanel instance() {
        return instance;
    }

    public ReadProjectPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Project", OfficeWelcome.constants);
    }

    public ReadProjectPanel(String id) {
        initReadComposite(id, "Project", OfficeWelcome.constants);
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
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("description", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("vendor", entity, null);
        selectVendor.setReadOnly(true);
        assignFieldValueFromEntity("purchaseOrderNo", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("subContractorWorkOrderNo", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("client", entity, null);
        selectClientWidget.setReadOnly(true);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("name", false, true, DataType.STRING_FIELD,Alignment.HORIZONTAL);
        addField("description", false, false, DataType.TEXT_AREA_FIELD,Alignment.HORIZONTAL);
        addField("startDate", false, true, DataType.DATE_FIELD,Alignment.HORIZONTAL);
        addField("endDate", false, true, DataType.DATE_FIELD,Alignment.HORIZONTAL);
        addDropDown("vendor", selectVendor);
        addField("purchaseOrderNo", false, true, DataType.STRING_FIELD,Alignment.HORIZONTAL);
        addField("subContractorWorkOrderNo", false, true, DataType.STRING_FIELD,Alignment.HORIZONTAL);
        addDropDown("client", selectClientWidget);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "project/" + entityId;
    }

}
