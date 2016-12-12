/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.project;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.client.SelectClientWidget;
import info.yalamanchili.office.client.admin.client.TreeClientPanel;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.admin.vendor.SelectVendorWidget;
import java.util.logging.Logger;

/**
 *
 * @author Yogi
 */
public class UpdateProjectPanel extends UpdateComposite {
    
    private static Logger logger = Logger.getLogger(UpdateProjectPanel.class.getName());

    SelectClientWidget selectClientWidget = new SelectClientWidget(true, false);
    SelectVendorWidget selectVendor = new SelectVendorWidget(false, true, Alignment.HORIZONTAL);
    SelectVendorWidget selectMiddleVendor = new SelectVendorWidget(false, true, Alignment.HORIZONTAL);

    public UpdateProjectPanel(JSONObject entity) {
        initUpdateComposite(entity, "Project", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("name", entity);
        assignEntityValueFromField("description", entity);
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("vendor", entity);
        assignEntityValueFromField("purchaseOrderNo", entity);
        assignEntityValueFromField("subContractorWorkOrderNo", entity);
        assignEntityValueFromField("middleVendor", entity);
        assignEntityValueFromField("client", entity);
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
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("description", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("vendor", entity, null);
        assignFieldValueFromEntity("purchaseOrderNo", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("subContractorWorkOrderNo", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("middleVendor", entity, null);
        assignFieldValueFromEntity("client", entity, null);
        selectClientWidget.setReadOnly(true);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Project");
        TabPanel.instance().adminPanel.sidePanelTop.clear();
        TabPanel.instance().adminPanel.sidePanelTop.add(new TreeClientPanel(entityId));
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllProjectsPanel());
        TabPanel.instance().adminPanel.entityPanel.add(new ProjectOptionsPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("name", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("description", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("startDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("endDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addDropDown("vendor", selectVendor);
        addField("purchaseOrderNo", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("subContractorWorkOrderNo", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addDropDown("middleVendor", selectMiddleVendor);
        addDropDown("client", new SelectClientWidget(false, true, Alignment.HORIZONTAL));
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "project";
    }
}
