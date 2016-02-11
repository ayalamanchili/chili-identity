/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.address.CreateAddressPanel;
import info.yalamanchili.office.client.profile.address.CreateAddressWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class CreateLCAPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreatePassportPanel.class.getName());

    protected BooleanField addAddress = new BooleanField(OfficeWelcome.constants, "Add LCA Secondary Address", "LCA", false, false, Alignment.HORIZONTAL);
    CreateAddressWidget createAddressWidget1 = new CreateAddressWidget(CreateAddressPanel.CreateAddressPanelType.MIN);
    CreateAddressWidget createAddressWidget2 = new CreateAddressWidget(CreateAddressPanel.CreateAddressPanelType.MIN);
    HTML wagesInfo = new HTML("<h4 style=\"color:#427fed\">" + "Wages Information</h4>");
    HTML lcaAddress1 = new HTML("<h4 style=\"color:#427fed\">" + "LCA Primary Address </h4>");
    HTML lcaAddress2 = new HTML("<h4 style=\"color:#427fed\">" + "LCA Secondary Address</h4>");
    boolean isLCASecAddAvail = false;

    public CreateLCAPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("LCA", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject lca = new JSONObject();
        JSONObject lcaAddress1 = new JSONObject();
        JSONObject lcaAddress2 = new JSONObject();
        assignEntityValueFromField("lcaNumber", lca);
        assignEntityValueFromField("lcaFiledDate", lca);
        assignEntityValueFromField("lcaValidFromDate", lca);
        assignEntityValueFromField("lcaValidToDate", lca);
        assignEntityValueFromField("jobTitle", lca);
        assignEntityValueFromField("withdrawnLCANumber", lca);
        // Address Information 1
        if (createAddressWidget1 != null) {
            lca.put("lcaAddress1", createAddressWidget1.populateEntityFromFields());
        }
        // Address Information 2
        if (isLCASecAddAvail) {
            lca.put("lcaAddress2", createAddressWidget2.populateEntityFromFields());
        }
        // Other Information
        assignEntityValueFromField("lcaCurrWageLvl", lca);
        assignEntityValueFromField("lcaCurrMinWage", lca);
        assignEntityValueFromField("lcaCurrMaxWage", lca);
        assignEntityValueFromField("lcaPrevWageLvl", lca);
        assignEntityValueFromField("lcaPrevMinWage", lca);
        assignEntityValueFromField("lcaPrevMaxWage", lca);
        logger.info("entity: " + lca);
        return lca;
    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable arg0) {
                handleErrorResponse(arg0);
            }

            @Override
            public void onSuccess(String arg0) {
                postCreateSuccess(arg0);
            }
        });
    }

    @Override
    protected void addButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable arg0) {
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
        new ResponseStatusWidget().show("Successfully Added LCA");
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
        entityFieldsPanel.add(lcaAddress1);
        entityFieldsPanel.add(createAddressWidget1);
        entityActionsPanel.add(addAddress);
        addAddress.setValue(false);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {

    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "lca/save";
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
        super.onClick(event);
    }

}
