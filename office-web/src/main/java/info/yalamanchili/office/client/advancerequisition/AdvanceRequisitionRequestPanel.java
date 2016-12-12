/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.advancerequisition;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RadioButton;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.IntegerField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.expense.bnkacct.CreateBankAcctWidget;
import info.yalamanchili.office.client.expense.check.CreateCheckWidget;
import info.yalamanchili.office.client.expense.check.CreateCheckWidget.CreateCheckWidgetType;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class AdvanceRequisitionRequestPanel extends CreateComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(AdvanceRequisitionRequestPanel.class.getName());
    CreateCheckWidget createCheckWidget = new CreateCheckWidget(CreateCheckWidgetType.CHECK_MAILING_INFO);
    CreateBankAcctWidget createBankAccountWidget = new CreateBankAcctWidget();
    RadioButton passCheckInfo = new RadioButton("payment", "Add Check Information");
    RadioButton passBankAcctInfo = new RadioButton("payment", "Add Bank Account Information");
    RadioButton useCurrentPayrollInfo = new RadioButton("payment", "Use Current Payroll Information");
    HTML tac = new HTML("<h6> I " + OfficeWelcome.instance().getCurrentUserName() + " hereby certify that I am solely responsible \n"
            + "for repayment of the above requested advance amount, to System Soft Technologies,as \n"
            + "per agreed terms & conditions or on-demand. </h6>");

    public AdvanceRequisitionRequestPanel() {
        super(CreateCompositeType.CREATE);
        initCreateComposite("AdvanceRequisition", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("purpose", entity);
        assignEntityValueFromField("amount", entity);
        assignEntityValueFromField("neededBy", entity);
        entity.put("employee", new JSONObject());
        entity.put("status", new JSONString("Open"));
        assignEntityValueFromField("repaymentMonths", entity);
        assignEntityValueFromField("repaymentNotes", entity);
        if (passCheckInfo.getValue()) {
            entity.put("check", createCheckWidget.populateEntityFromFields());
        }
        if (passBankAcctInfo.getValue()) {
            entity.put("bankAccount", createBankAccountWidget.populateEntityFromFields());
        }
        return entity;
    }

    @Override
    protected void createButtonClicked() {
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
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Request Submited, please wait for email notification within 48 hours for Email confirmation");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllAdvanceRequisitionPanel());
        
    }

    @Override
    protected void addListeners() {
        passBankAcctInfo.addClickHandler(this);
        passCheckInfo.addClickHandler(this);
        useCurrentPayrollInfo.addClickHandler(this);
    }

    @Override
    protected void configure() {
        setButtonText("Submit");
    }

    @Override
    protected void addWidgets() {
        entityFieldsPanel.add(getLineSeperatorTag("Advance Requisition Information"));
        addField("purpose", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("amount", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("neededBy", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Repayment Information"));
        addField("repaymentMonths", false, true, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("repaymentNotes", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Receive Payment Information"));
        entityFieldsPanel.add(passBankAcctInfo);
        entityFieldsPanel.add(passCheckInfo);
        entityFieldsPanel.add(useCurrentPayrollInfo);
        entityFieldsPanel.add(tac);
        alignFields();
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        boolean flag = true;
        IntegerField repaymentMonths = (IntegerField) fields.get("repaymentMonths");
        if (repaymentMonths.getInteger() == null) {
            repaymentMonths.setMessage("Value is required");
            flag = false;
        }
        if (!passBankAcctInfo.getValue() && !passCheckInfo.getValue() && !useCurrentPayrollInfo.getValue()) {
            Window.alert("choose a Receive Payment Information");
            flag = false;
        }
        return flag;
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "advancerequisition/submit-advance-requisition-request";
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(passBankAcctInfo)) {
            addBankAcctInformationWidget();
        } else if (event.getSource().equals(passCheckInfo)) {
            addCheckInformationWidget();
        } else {
            super.onClick(event);
        }
    }

    protected void addPayCurrentPaymentInfo() {

    }

    protected void addCheckInformationWidget() {
        if (createBankAccountWidget.isAttached()) {
            entityFieldsPanel.remove(createBankAccountWidget);
        }
        if (!createCheckWidget.isAttached()) {
            createCheckWidget = new CreateCheckWidget(CreateCheckWidgetType.CHECK_MAILING_INFO);
            entityFieldsPanel.add(createCheckWidget);
        }
    }

    protected void addBankAcctInformationWidget() {
        if (createCheckWidget.isAttached()) {
            entityFieldsPanel.remove(createCheckWidget);
        }
        if (!createBankAccountWidget.isAttached()) {
            createBankAccountWidget = new CreateBankAcctWidget();
            entityFieldsPanel.add(createBankAccountWidget);
        }
    }

    @Override
    protected boolean showDocumentationLink() {
        return true;
    }

    @Override
    protected String getDocumentationLink() {
        return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "expense/advance.html";
    }
}
