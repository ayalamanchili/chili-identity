/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import com.google.gwt.event.dom.client.ClickEvent;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.CreateComposite;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.chili.gwt.rpc.HttpService.HttpServiceAsync;
import info.yalamanchili.office.client.admin.client.SelectClientWidget;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.clientcontact.SelectClientContactWidget;
import info.yalamanchili.office.client.admin.clientlocation.SelectClientLocationWidget;
import info.yalamanchili.office.client.admin.vendor.SelectVendorWidget;
import info.yalamanchili.office.client.admin.vendorcontact.SelectVendorContactWidget;
import info.yalamanchili.office.client.admin.vendorlocation.SelectVendorLocationsWidget;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.admin.subcntrcontact.SelectSubcontractorContactWidget;
import info.yalamanchili.office.client.admin.subcntrlocation.SelectSubcontractorLocationWidget;
import info.yalamanchili.office.client.admin.subcontractor.SelectSubcontractorWidget;
import info.yalamanchili.office.client.home.tasks.GenericBPMStartFormPanel;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWithRoleWidget;

public class CreateClientInfoPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateClientInfoPanel.class.getName());
    protected Anchor addClientL = new Anchor("Client not present? submit request");
    protected Anchor addVendorL = new Anchor("Vendor not present? submit request");
    SelectEmployeeWithRoleWidget selectRecruiterWidget = new SelectEmployeeWithRoleWidget("Recruiter", Auth.ROLE.ROLE_RECRUITER.name(), false, false);

    public CreateClientInfoPanel(CreateCompositeType type) {
        super(type);
        initCreateComposite("ClientInfo", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject clientInfo = new JSONObject();
        assignEntityValueFromField("consultantJobTitle", clientInfo);
        assignEntityValueFromField("client", clientInfo);
        assignEntityValueFromField("clientContact", clientInfo);
        assignEntityValueFromField("clientLocation", clientInfo);
        assignEntityValueFromField("vendor", clientInfo);
        assignEntityValueFromField("vendorContact", clientInfo);
        assignEntityValueFromField("vendorLocation", clientInfo);
        assignEntityValueFromField("startDate", clientInfo);
        assignEntityValueFromField("endDate", clientInfo);
        assignEntityValueFromField("payRate", clientInfo);
        assignEntityValueFromField("billingRate", clientInfo);
        assignEntityValueFromField("billingRateDuration", clientInfo);
        assignEntityValueFromField("overTimePayRate", clientInfo);
        assignEntityValueFromField("overTimeBillingRate", clientInfo);
        assignEntityValueFromField("overTimeDuration", clientInfo);
        assignEntityValueFromField("invoiceFrequency", clientInfo);
        assignEntityValueFromField("invoiceDeliveryMethod", clientInfo);
        assignEntityValueFromField("recruiter", clientInfo);
        assignEntityValueFromField("visaStatus", clientInfo);
        if (Auth.isSubContractor(TreeEmployeePanel.instance().getEntity())) {
            assignEntityValueFromField("subcontractor", clientInfo);
            assignEntityValueFromField("subcontractorContact", clientInfo);
            assignEntityValueFromField("subcontractorAddress", clientInfo);
            assignEntityValueFromField("subcontractorPayRate", clientInfo);
            assignEntityValueFromField("subcontractorOvertimePayRate", clientInfo);
        }
        assignEntityValueFromField("notes", clientInfo);


        return clientInfo;
    }

    @Override
    protected void createButtonClicked() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addButtonClicked() {
        HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
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
        new ResponseStatusWidget().show("Successfully Added Client Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllClientInfoPanel(TreeEmployeePanel.instance().getEntityId()));
        TabPanel.instance().myOfficePanel.entityPanel.add(new ClientInfoOptionsPanel());
    }

    @Override
    protected void addListeners() {
        addClientL.addClickHandler(this);
        addVendorL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
        //Basic
        addField("consultantJobTitle", false, true, DataType.STRING_FIELD);
        //client
        entityFieldsPanel.add(getLineSeperatorTag("Client & Vendor Information"));
        addDropDown("client", new SelectClientWidget(false, true));
        entityFieldsPanel.add(addClientL);
        addDropDown("clientContact", new SelectClientContactWidget(false, false));
        addDropDown("clientLocation", new SelectClientLocationWidget(false, false));
        //Vendor
        addDropDown("vendor", new SelectVendorWidget(false, false));
        entityFieldsPanel.add(addVendorL);
        addDropDown("vendorContact", new SelectVendorContactWidget(false, false));
        addDropDown("vendorLocation", new SelectVendorLocationsWidget(false, false));
        //Contract basic
        addField("startDate", false, true, DataType.DATE_FIELD);
        addField("endDate", false, false, DataType.DATE_FIELD);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_TIME, ROLE.ROLE_RECRUITER, ROLE.ROLE_RELATIONSHIP)) {
            addDropDown("recruiter", selectRecruiterWidget);
            //Billing Information
            entityFieldsPanel.add(getLineSeperatorTag("Billing Information"));
            addField("payRate", false, false, DataType.CURRENCY_FIELD);
            addField("billingRate", false, false, DataType.CURRENCY_FIELD);
            String[] billingDuration = {"HOUR", "DAY", "MONTH"};
            addEnumField("billingRateDuration", false, false, billingDuration);
            addField("overTimePayRate", false, false, DataType.CURRENCY_FIELD);
            addField("overTimeBillingRate", false, false, DataType.CURRENCY_FIELD);
            addEnumField("overTimeDuration", false, false, billingDuration);
            String[] invoiceFrequencies = {"WEEKLY", "BI_WEEKLY", "MONTHLY", "SEMI_MONTHLY", "NOT_REQUIRED"};
            addEnumField("invoiceFrequency", false, false, invoiceFrequencies);
            String[] invoiceDeliveryMethods = {"MANUAL", "EMAIL", "FAX"};
            addEnumField("invoiceDeliveryMethod", false, false, invoiceDeliveryMethods);
            if (Auth.isSubContractor(TreeEmployeePanel.instance().getEntity())) {
                entityFieldsPanel.add(getLineSeperatorTag("Subcontractor Information"));
                addDropDown("subcontractor", new SelectSubcontractorWidget(false, false));
                addDropDown("subcontractorContact", new SelectSubcontractorContactWidget(false, false));
                addDropDown("subcontractorAddress", new SelectSubcontractorLocationWidget(false, false));
                addField("subcontractorPayRate", false, false, DataType.CURRENCY_FIELD);
                addField("subcontractorOvertimePayRate", false, false, DataType.CURRENCY_FIELD);
            }
            entityFieldsPanel.add(getLineSeperatorTag("Other Information"));
            addField("visaStatus", false, false, DataType.STRING_FIELD);
            addField("notes", false, false, DataType.RICH_TEXT_AREA);
        }
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addClientL)) {
            new GenericPopup(new GenericBPMStartFormPanel("Add New Client Request", "add_new_client_request_1")).show();
        }
        if (event.getSource().equals(addVendorL)) {
            new GenericPopup(new GenericBPMStartFormPanel("Add New Vendor Request", "add_new_vendor_request_1")).show();
        }
        super.onClick(event);
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/clientinformation/" + TreeEmployeePanel.instance().getEntityId();
    }
}
