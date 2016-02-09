/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.address.CreateAddressPanel;
import info.yalamanchili.office.client.profile.address.CreateAddressWidget;
import info.yalamanchili.office.client.profile.address.UpdateAddressPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class UpdateLCAPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateLCAPanel.class.getName());
    protected BooleanField addAddress = new BooleanField(OfficeWelcome.constants, "Add LCA Secondary Address", "LCA", false, false, Alignment.HORIZONTAL);
    HTML wagesInfo = new HTML("<h4 style=\"color:#427fed\">" + "Wages Information</h4>");
    HTML lcaAddress1 = new HTML("<h4 style=\"color:#427fed\">" + "LCA Primary Address </h4>");
    HTML lcaAddress2 = new HTML("<h4 style=\"color:#427fed\">" + "LCA Secondary Address</h4>");
    UpdateLCAAddressWidget updateAddressWidget1;
    UpdateLCAAddressWidget updateAddressWidget2;
    CreateAddressWidget createAddressWidget2 = new CreateAddressWidget(CreateAddressPanel.CreateAddressPanelType.MIN);
    boolean isLCASecAddAvail = false;

    public UpdateLCAPanel(JSONObject entity) {
        initUpdateComposite(entity, "LCA", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("lcaNumber", entity);
        assignEntityValueFromField("lcaFiledDate", entity);
        assignEntityValueFromField("lcaValidFromDate", entity);
        assignEntityValueFromField("lcaValidToDate", entity);
        assignEntityValueFromField("jobTitle", entity);
        assignEntityValueFromField("withdrawnLCANumber", entity);
        // Address Information 1
        if (entity.containsKey("lcaAddress1")) {
            entity.put("lcaAddress1", updateAddressWidget1.populateEntityFromFields());
        }
        // Address Information 2
        if (entity.containsKey("lcaAddress2")) {
            entity.put("lcaAddress2", updateAddressWidget2.populateEntityFromFields());
        }
        if (isLCASecAddAvail) {
            entity.put("lcaAddress2", createAddressWidget2.populateEntityFromFields());
        }
        // Other Information
        assignEntityValueFromField("lcaCurrWageLvl", entity);
        assignEntityValueFromField("lcaCurrMinWage", entity);
        assignEntityValueFromField("lcaCurrMaxWage", entity);
        assignEntityValueFromField("lcaPrevWageLvl", entity);
        assignEntityValueFromField("lcaPrevMinWage", entity);
        assignEntityValueFromField("lcaPrevMaxWage", entity);
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
        assignFieldValueFromEntity("lcaNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lcaFiledDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("lcaValidFromDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("lcaValidToDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("jobTitle", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("withdrawnLCANumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lcaCurrWageLvl", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("lcaCurrMinWage", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("lcaCurrMaxWage", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("lcaPrevWageLvl", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("lcaPrevMinWage", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("lcaPrevMaxWage", entity, DataType.CURRENCY_FIELD);
        if (entity.containsKey("lcaAddress1")) {
            entityFieldsPanel.add(lcaAddress1);
            updateAddressWidget1 = new UpdateLCAAddressWidget(entity.get("lcaAddress1").isObject(), UpdateAddressPanel.UpdateAddressPanelType.MIN);
            entityFieldsPanel.add(updateAddressWidget1);
        }
        if (entity.containsKey("lcaAddress2")) {
            entityFieldsPanel.add(lcaAddress2);
            updateAddressWidget2 = new UpdateLCAAddressWidget(entity.get("lcaAddress2").isObject(), UpdateAddressPanel.UpdateAddressPanelType.MIN);
            entityFieldsPanel.add(updateAddressWidget2);
            entityActionsPanel.remove(addAddress);
        } 
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated LCA");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllLCAPanel(TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    protected void addListeners() {
        addAddress.getBox().addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("lcaNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lcaFiledDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("lcaValidFromDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("lcaValidToDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("jobTitle", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("withdrawnLCANumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(wagesInfo);
        addEnumField("lcaCurrWageLvl", false, true, LCAWageLevels.names(), Alignment.HORIZONTAL);
        addField("lcaCurrMinWage", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("lcaCurrMaxWage", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addEnumField("lcaPrevWageLvl", false, true, LCAWageLevels.names(), Alignment.HORIZONTAL);
        addField("lcaPrevMinWage", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("lcaPrevMaxWage", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        entityActionsPanel.add(addAddress);
        addAddress.setValue(false);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "lca/save/" + TreeEmployeePanel.instance().getEntityId();
    }
    
    @Override
    public void onClick(ClickEvent event) {
        if (addAddress.getValue()) {
            entityFieldsPanel.add(lcaAddress2);
            entityFieldsPanel.add(createAddressWidget2);
            isLCASecAddAvail = true;
        } else {
            entityFieldsPanel.remove(lcaAddress2);
            entityFieldsPanel.remove(createAddressWidget2);
            isLCASecAddAvail = false;
        }
        if (event.getSource().equals(update)) {
            super.onClick(event);
        }
    }

}
