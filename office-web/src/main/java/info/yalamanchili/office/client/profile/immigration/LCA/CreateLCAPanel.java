/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.LCA;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.TextArea;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.SuggestBox;
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
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class CreateLCAPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreatePassportPanel.class.getName());

    Button addLca = new Button("Add Employee");
    Button removeLca = new Button("Remove Employee");
    TextArea lcaTa = new TextArea();
    FlowPanel lcapanel = new FlowPanel();
    protected BooleanField addAddress = new BooleanField(OfficeWelcome.constants, "Add LCA Secondary Address", "LCA", false, false, Alignment.HORIZONTAL);
    CreateAddressWidget createAddressWidget1 = new CreateAddressWidget(CreateAddressPanel.CreateAddressPanelType.MIN);
    CreateAddressWidget createAddressWidget2 = new CreateAddressWidget(CreateAddressPanel.CreateAddressPanelType.MIN);
    protected SelectCompanyWidget selectCompanyWidget = new SelectCompanyWidget(false, false, Alignment.HORIZONTAL);
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employees", "Employee", false, true, Alignment.VERTICAL);
    HTML wagesInfo = new HTML("<h4 style=\"color:#427fed\">" + "Wages Information</h4>");
    HTML empInfo = new HTML("<h4 style=\"color:#427fed\">" + "Select Consultants</h4>");
    HTML addInfo = new HTML("<h4 style=\"color:#427fed\">" + "Additional Information</h4>");
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
        String[] split = lcaTa.getValue().split(",");
        JSONArray employees = new JSONArray();
        for (int j = 0; j < split.length; j++) {
            String name = split[j];
            logger.info(" JSONArray employees  " + name);
            if (employeeSB.getValue().equals(name)) {
                employees.set(j, employeeSB.getSelectedObject());
            } else {
                employees.set(j, new JSONString(split[j]));
            }
        }
        lca.put("workedByEmployees", selectRecruiterW.getSelectedObjects());
        assignEntityValueFromField("lcaNumber", lca);
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
        logger.info("entity : " + lca);
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
        TabPanel.instance().immigrationPanel.entityPanel.add(new ReadAllLCAPanel());
    }

    @Override
    protected void addListeners() {
        addAddress.getBox().addClickHandler(this);
        addLca.addClickHandler(this);
        removeLca.addClickHandler(this);
        employeeSB.getSuggestBox().addKeyPressHandler(new KeyPressHandler() {
            @Override
            public void onKeyPress(KeyPressEvent event) {
                if (event.getCharCode() == KeyCodes.KEY_ENTER) {
                    addLcaClicked();
                }
            }
        });
    }

    protected void addLcaClicked() {
        if (employeeSB.getValue() == null && employeeSB.getValue().isEmpty()) {
            return;
        }
        String concat = lcaTa.getValue().concat(employeeSB.getValue() + " , ");
        lcaTa.setValue(concat);
        employeeSB.clearText();
    }

    protected void removeLcaClicked() {
        if (employeeSB.getValue() == null && employeeSB.getValue().isEmpty()) {
            return;
        }
        String concat = lcaTa.getValue();
        String replaceAll = concat.replaceAll(employeeSB.getValue() + " , ", " ");
        lcaTa.setValue(replaceAll);
        employeeSB.clearText();
    }

    @Override
    protected void configure() {
        lcaTa.setEnabled(false);
        lcaTa.setVisibleLines(3);
        lcaTa.setWidth("100%");
        employeeSB.getLabel().getElement().getStyle().setWidth(145, Style.Unit.PX);
        employeeSB.getLabel().getElement().getStyle().setWidth(145, Style.Unit.PX);
        setButtonText("Submit");
        HttpService.HttpServiceAsync.instance().doGet(getEmployeeIdsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                logger.info(entityString);
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    employeeSB.loadData(values);
                }
            }
        });
    }

    private String getEmployeeIdsDropDownUrl() {
        return URL.encode(OfficeWelcome.constants.root_url() + "employee/employees-by-role/dropdown/" + Auth.ROLE.ROLE_USER.name() + "/0/10000");
    }
    SelectEmployeeWithRoleWidget selectRecruiterW = new SelectEmployeeWithRoleWidget("WorkedBy", Auth.ROLE.ROLE_RECRUITER, false, false, Alignment.HORIZONTAL) {
        @Override
        public boolean enableMultiSelect() {
            return true;
        }
    };

    @Override
    protected void addWidgets() {
        addField("lcaNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("totalWorkingPositions", false, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addEnumField("visaClassification", false, true, VisaClassificationType.names(), Alignment.HORIZONTAL);
        addDropDown("company", selectCompanyWidget);
        addField("jobTitle", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("socCodesAndOccupations", false, false, SOCCodesAndOccupations.names(), Alignment.HORIZONTAL);
        addField("lcaValidFromDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("lcaValidToDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addDropDown("workedByEmployees", selectRecruiterW);
        entityFieldsPanel.add(empInfo);
        entityFieldsPanel.add(employeeSB);
        lcapanel.add(addLca);
        lcapanel.add(removeLca);
        entityFieldsPanel.add(lcapanel);
        entityFieldsPanel.add(lcaTa);
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
        if (event.getSource().equals(removeLca)) {
            removeLcaClicked();
        }
        if (event.getSource().equals(addLca)) {
            addLcaClicked();
        }
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
