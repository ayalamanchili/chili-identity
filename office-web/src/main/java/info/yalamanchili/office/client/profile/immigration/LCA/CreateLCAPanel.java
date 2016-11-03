/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.LCA;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.profile.address.CreateAddressPanel;
import info.yalamanchili.office.client.profile.address.CreateAddressWidget;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWithRoleWidget;
import info.yalamanchili.office.client.profile.immigration.Passport.CreatePassportPanel;
import info.yalamanchili.office.client.profile.immigration.Polar;
import info.yalamanchili.office.client.profile.immigration.SOCCodesAndOccupations;
import info.yalamanchili.office.client.profile.immigration.VisaClassificationType;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class CreateLCAPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreatePassportPanel.class.getName());

    FlowPanel lcapanel = new FlowPanel();
    protected BooleanField addAddress = new BooleanField(OfficeWelcome.constants, "Add LCA Secondary Address", "LCA", false, false, Alignment.HORIZONTAL);
    CreateAddressWidget createAddressWidget1 = new CreateAddressWidget(CreateAddressPanel.CreateAddressPanelType.MIN);
    CreateAddressWidget createAddressWidget2 = new CreateAddressWidget(CreateAddressPanel.CreateAddressPanelType.MIN);
    protected SelectCompanyWidget selectCompanyWidget = new SelectCompanyWidget(false, false, Alignment.HORIZONTAL);
    HTML wagesInfo = new HTML("<h4 style=\"color:#427fed\">" + "Wages Information</h4>");
    HTML addInfo = new HTML("<h4 style=\"color:#427fed\">" + "Additional Information</h4>");
    HTML lcaAddress1 = new HTML("<h4 style=\"color:#427fed\">" + "LCA Primary Address </h4>");
    HTML lcaAddress2 = new HTML("<h4 style=\"color:#427fed\">" + "LCA Secondary Address</h4>");
    boolean isLCASecAddAvail = false;

    public CreateLCAPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("LCA", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject lca = new JSONObject();
        lca.put("workedByEmployees", selectImgW.getSelectedObjects());
        assignEntityValueFromField("lcaNumber", lca);
        assignEntityValueFromField("candidateNames", lca);
        assignEntityValueFromField("lcaFiledDate", lca);
        assignEntityValueFromField("lcaValidFromDate", lca);
        assignEntityValueFromField("lcaValidToDate", lca);
        assignEntityValueFromField("totalWorkingPositions", lca);
        assignEntityValueFromField("visaClassification", lca);
        assignEntityValueFromField("socCodesAndOccupations", lca);
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
        if (fields.containsKey("company") && selectCompanyWidget.getSelectedObject() != null) {
            JSONObject company = selectCompanyWidget.getSelectedObject();
            lca.put("company", company);
        }
        assignEntityValueFromField("lcaCurrWageLvl", lca);
        assignEntityValueFromField("lcaCurrMinWage", lca);
        assignEntityValueFromField("lcaCurrMaxWage", lca);
        assignEntityValueFromField("clientName", lca);
        assignEntityValueFromField("vendorName", lca);
        assignEntityValueFromField("nonDisplacement", lca);
        assignEntityValueFromField("lcaPostingSentToVendor", lca);
        assignEntityValueFromField("responseOnLcaPosting", lca);
        assignEntityValueFromField("reminderEmail", lca);
        assignEntityValueFromField("certifiedLcaSentConsultant", lca);
        assignEntityValueFromField("lcaPostingSSTLocation", lca);
        assignEntityValueFromField("lcaFiledInPIF", lca);
        assignEntityValueFromField("comment", lca);
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
        TabPanel.instance().immigrationPanel.entityPanel.clear();
        TabPanel.instance().immigrationPanel.entityPanel.add(new LcaMenu());
        TabPanel.instance().immigrationPanel.entityPanel.add(new ReadAllLCAPanel());
    }

    @Override
    protected void addListeners() {
        addAddress.getBox().addClickHandler(this);
    }

    @Override
    protected void configure() {
        setButtonText("Submit");
    }

    SelectEmployeeWithRoleWidget selectImgW = new SelectEmployeeWithRoleWidget("WorkedBy", Auth.ROLE.ROLE_H1B_IMMIGRATION, false, false, Alignment.HORIZONTAL) {
        @Override
        public boolean enableMultiSelect() {
            return true;
        }
    };

    @Override
    protected void addWidgets() {
        addField("lcaNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("candidateNames", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("totalWorkingPositions", false, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addEnumField("visaClassification", false, true, VisaClassificationType.names(), Alignment.HORIZONTAL);
        addDropDown("company", selectCompanyWidget);
        addField("jobTitle", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("socCodesAndOccupations", false, false, SOCCodesAndOccupations.names(), Alignment.HORIZONTAL);
        addField("lcaValidFromDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("lcaValidToDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addDropDown("workedByEmployees", selectImgW);
        entityFieldsPanel.add(lcapanel);
        entityFieldsPanel.add(wagesInfo);
        addEnumField("lcaCurrWageLvl", false, true, LCAWageLevels.names(), Alignment.HORIZONTAL);
        addField("lcaCurrMinWage", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("lcaCurrMaxWage", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(addInfo);
        addField("clientName", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("vendorName", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("nonDisplacement", false, false, Polar.names(), Alignment.HORIZONTAL);
        addField("lcaPostingSentToVendor", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("responseOnLcaPosting", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("reminderEmail", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("certifiedLcaSentConsultant", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("lcaPostingSSTLocation", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("lcaFiledDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("lcaFiledInPIF", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("withdrawnLCANumber", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("comment", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
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
