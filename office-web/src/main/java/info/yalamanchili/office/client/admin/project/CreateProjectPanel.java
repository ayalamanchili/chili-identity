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
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.admin.client.SelectClientWidget;
import info.yalamanchili.office.client.admin.client.TreeClientPanel;
import info.yalamanchili.office.client.admin.vendor.SelectVendorWidget;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class CreateProjectPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateProjectPanel.class.getName());
    protected boolean showClient;
    SelectClientWidget clientT = new SelectClientWidget(showClient, false);
    SelectVendorWidget selectVendor = new SelectVendorWidget(false, true);
    SelectVendorWidget selectMiddleVendor = new SelectVendorWidget(false, true);
    String clntId = null;
    String vendorID = null;
    String midVendorID = null;

    public CreateProjectPanel(CreateComposite.CreateCompositeType type, boolean showClient) {
        super(type);
        this.showClient = showClient;
        initCreateComposite("Project", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        entity = new JSONObject();

        assignEntityValueFromField("name", entity);
        assignEntityValueFromField("description", entity);
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("purchaseOrderNo", entity);
        assignEntityValueFromField("subContractorWorkOrderNo", entity);
        logger.info("Entity :" + entity.toString());
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        addButtonClicked();
    }

    @Override
    protected void addButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        logger.info(arg0.getMessage());
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postCreateSuccess(arg0);
                    }
                });
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Project Successfully Created");
        String id = JSONUtils.toString(JSONParser.parseLenient(result), "id");
        TabPanel.instance().adminPanel.entityPanel.clear();
        if (!showClient) {
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllProjectsPanel(clntId));
            TabPanel.instance().adminPanel.entityPanel.add(new ProjectOptionsPanel());
        } else {
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllProjectsPanel());
        }
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
        addField("description", false, false, DataType.RICH_TEXT_AREA);
        addField("startDate", false, true, DataType.DATE_FIELD);
        addField("endDate", false, true, DataType.DATE_FIELD);
        addDropDown("vendor", selectVendor);
        addField("purchaseOrderNo", false, true, DataType.STRING_FIELD);
        addField("subContractorWorkOrderNo", false, true, DataType.STRING_FIELD);
        addDropDown("middleVendor", selectMiddleVendor);
        if (showClient) {
            addDropDown("client", new SelectClientWidget(false, true));
        }
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        if (showClient) {
            SelectClientWidget clientT = (SelectClientWidget) fields.get("client");
            clntId = JSONUtils.toString(clientT.getSelectedObject(), "id");
        } else {
            clntId = TreeClientPanel.instance().getEntityId();
        }
        vendorID = JSONUtils.toString(selectVendor.getSelectedObject(), "id");
        midVendorID = JSONUtils.toString(selectMiddleVendor.getSelectedObject(), "id");
        return OfficeWelcome.constants.root_url() + "client/project/" + clntId  + "/" +  vendorID  + "/" +  midVendorID;
    }
}
