/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.project;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.admin.client.SelectClientWidget;
import info.yalamanchili.office.client.admin.client.TreeClientPanel;
import info.yalamanchili.office.client.admin.vendor.SelectMiddleVendorWidget;
import info.yalamanchili.office.client.admin.vendor.SelectVendorWidget;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class CreateProjectPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateProjectPanel.class.getName());
    protected boolean showClient;
    SelectClientWidget clientT = new SelectClientWidget(showClient, false, Alignment.HORIZONTAL);
    SelectVendorWidget selectVendor = new SelectVendorWidget(false, true, Alignment.HORIZONTAL);
    SelectMiddleVendorWidget selectMiddleVendor = new SelectMiddleVendorWidget(false, true, Alignment.HORIZONTAL);
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
        JSONObject project = new JSONObject();
        assignEntityValueFromField("name", project);
        assignEntityValueFromField("description", project);
        assignEntityValueFromField("startDate", project);
        assignEntityValueFromField("endDate", project);
        assignEntityValueFromField("purchaseOrderNo", project);
        assignEntityValueFromField("subContractorWorkOrderNo", project);
        logger.info(project.toString());
        return project;
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
                        logger.info("success logged");
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
        addField("name", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("description", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("startDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("endDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addDropDown("vendor", selectVendor);
        addField("purchaseOrderNo", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("subContractorWorkOrderNo", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addDropDown("middleVendor", selectMiddleVendor);
        if (showClient) {
            addDropDown("client", new SelectClientWidget(false, true, Alignment.HORIZONTAL));
        }
        alignFields();
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
        return OfficeWelcome.constants.root_url() + "client/project/" + clntId + "/" + vendorID + "/" + midVendorID;
    }
}
