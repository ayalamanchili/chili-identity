/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.FloatField;
import info.chili.gwt.fields.IntegerField;
import info.chili.gwt.fields.LongField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.admin.clientcontact.CreateClientContactPanel;
import info.yalamanchili.office.client.profile.address.CreateAddressPanel;
import info.yalamanchili.office.client.profile.address.CreateAddressWidget;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceDeliveryMethod;
import info.yalamanchili.office.client.profile.contact.CreateContactWidget;
import info.yalamanchili.office.client.profile.phone.CreatePhonePanel;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class CreateClientPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateClientPanel.class.getName());

    CreateAddressWidget createAddressWidget = new CreateAddressWidget(CreateAddressPanel.CreateAddressPanelType.MIN);
    protected BooleanField addRecruiterContact = new BooleanField(OfficeWelcome.constants, "Add Recruiter Contact", "Client", false, false, Alignment.HORIZONTAL);
    CreateContactWidget createContactWidget1 = new CreateContactWidget(CreateClientContactPanel.CreateCompositeType.ADD);
    protected BooleanField addAcntPybleContact = new BooleanField(OfficeWelcome.constants, "Add Account Payable Contact", "Client", false, false, Alignment.HORIZONTAL);
    CreateContactWidget createContactWidget2 = new CreateContactWidget(CreateClientContactPanel.CreateCompositeType.ADD);
    HTML directClientNote = new HTML("<h4 style=\"color:#427fed\">" + "For a  Direct "
            + "Client: Payment Terms, Invoice Frequency, Invoice Delivery Method"
            + "</br>MSA Validity Period From & To and "
            + "Termination Notice Period are also required!</h4>");
    HTML primaryLocation = new HTML("<h4 style=\"color:#427fed\">" + "Client Primary Address </h4>");
    HTML recruiterContact = new HTML("<h4 style=\"color:#427fed\">" + "Recruiter Contact Information </h4>");
    HTML acntPybleContact = new HTML("<h4 style=\"color:#427fed\">" + "Account Payable Contact Information </h4>");
    protected BooleanField isDirectClient;

    public CreateClientPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("Client", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject clnt = new JSONObject();

        assignEntityValueFromField("name", clnt);
//        assignEntityValueFromField("description", clnt);
        assignEntityValueFromField("website", clnt);
        assignEntityValueFromField("directClient", clnt);
        assignEntityValueFromField("paymentTerms", clnt);
        assignEntityValueFromField("clientinvFrequency", clnt);
        assignEntityValueFromField("clientFee", clnt);
        //assignEntityValueFromField("maxClientFee", clnt);
        //assignEntityValueFromField("minClientFee", clnt);
        assignEntityValueFromField("msaValDate", clnt);
        assignEntityValueFromField("msaExpDate", clnt);
        assignEntityValueFromField("clientInvDeliveryMethod", clnt);
        assignEntityValueFromField("terminationNoticePeriod", clnt);
        if (createAddressWidget != null) {
            clnt.put("location", createAddressWidget.populateEntityFromFields());
        }
        if (addRecruiterContact.getValue()) {
            clnt.put("contact", createContactWidget1.populateEntityFromFields());
        }
        if (addAcntPybleContact.getValue()) {
            clnt.put("clientAcctPayContact", createContactWidget2.populateEntityFromFields());
        }
        if (isDirectClient.getValue()) {
            clnt.put("contact", createContactWidget1.populateEntityFromFields());
            clnt.put("clientAcctPayContact", createContactWidget2.populateEntityFromFields());
        }
        logger.info(clnt.toString());
        return clnt;
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
        if (GenericPopup.instance() != null) {
            GenericPopup.instance().hide();
        }
        if (SelectClientWidget.instance() != null) {
            SelectClientWidget.instance().fetchDropDownData();
        }
        new ResponseStatusWidget().show("Successfully created Client");
        String id = JSONUtils.toString(JSONParser.parseLenient(result), "id");
        TabPanel.instance().adminPanel.sidePanelTop.clear();
        TabPanel.instance().adminPanel.sidePanelTop.add(new ClientSidePanel());
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllClientsPanel(id));;
    }

    @Override
    protected void addListeners() {
        isDirectClient.getBox().addClickHandler(this);
        addRecruiterContact.getBox().addClickHandler(this);
        addAcntPybleContact.getBox().addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("name", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
//        addField("description", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("website", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("directClient", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        isDirectClient = (BooleanField) fields.get("directClient");
        entityFieldsPanel.add(directClientNote);
        directClientNote.setVisible(false);
        addField("paymentTerms", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("clientinvFrequency", false, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
        addEnumField("clientInvDeliveryMethod", false, false, InvoiceDeliveryMethod.names(), Alignment.HORIZONTAL);
        addField("clientFee", false, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        //addField("maxClientFee", false, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        //addField("minClientFee", false, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        addField("msaValDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("msaExpDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("terminationNoticePeriod", false, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(primaryLocation);
        entityFieldsPanel.add(createAddressWidget);
        entityFieldsPanel.add(addRecruiterContact);
        entityFieldsPanel.add(recruiterContact);
        entityFieldsPanel.add(createContactWidget1);
        hideRecruiterContact();
        entityFieldsPanel.add(addAcntPybleContact);
        entityFieldsPanel.add(acntPybleContact);
        entityFieldsPanel.add(createContactWidget2);
        hideAcctPayableContact();
        alignFields();
    }

    @Override
    public void onClick(ClickEvent event) {
        if (isDirectClient.getValue()) {
            directClientNote.setVisible(true);
            showRecruiterContact();
            showAcctPayableContact();
            addRecruiterContact.setVisible(false);
            addAcntPybleContact.setVisible(false);
        } else {
            directClientNote.setVisible(false);
            hideRecruiterContact();
            hideAcctPayableContact();
            addRecruiterContact.setVisible(true);
            addAcntPybleContact.setVisible(true);
            if (addRecruiterContact.getValue()) {
                showRecruiterContact();
            } else {
                hideRecruiterContact();
            }
            if (addAcntPybleContact.getValue()) {
                showAcctPayableContact();
            } else {
                hideAcctPayableContact();
            }
        }
        super.onClick(event);
    }

    private void showRecruiterContact() {
        recruiterContact.setVisible(true);
        createContactWidget1.setVisible(true);
    }

    private void hideRecruiterContact() {
        recruiterContact.setVisible(false);
        createContactWidget1.setVisible(false);
    }

    private void showAcctPayableContact() {
        acntPybleContact.setVisible(true);
        createContactWidget2.setVisible(true);
    }

    private void hideAcctPayableContact() {
        acntPybleContact.setVisible(false);
        createContactWidget2.setVisible(false);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "client/create";
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        boolean valid = true;
        valid = isMsaToDateAfterMsaFrom(valid);
        valid = checkLocationValidations(valid);
        if (addRecruiterContact.getValue()) {
            valid = checkRecruiterContactValidations(valid);
        }
        if (addAcntPybleContact.getValue()) {
            valid = checkAcctPayableValidations(valid);
        }
        if (isDirectClient.getValue()) {
            valid = checkDirectClientValidations(valid);
        }
        return valid;
    }

    private boolean isMsaToDateAfterMsaFrom(boolean valid) {
        DateField msaValDate = (DateField) fields.get("msaValDate");
        DateField msaExpDate = (DateField) fields.get("msaExpDate");
        if (msaValDate.getDate() != null && msaExpDate.getDate() != null && msaValDate.getDate().after(msaExpDate.getDate())) {
            msaExpDate.setMessage("To Date must be after From Date");
            valid = false;
        }
        return valid;
    }

    private boolean checkLocationValidations(boolean valid) {
        StringField clientNameF = (StringField) fields.get("name");
        if (clientNameF.getValue() == null || "".equals(clientNameF.getValue())) {
            clientNameF.setMessage("Please enter the client name");
            valid = false;
        }
        StringField street1F = (StringField) createAddressWidget.fields.get("street1");
        if (street1F.getValue() == null || "".equals(street1F.getValue())) {
            street1F.setMessage("Please enter the street");
            valid = false;
        }
        StringField cityF = (StringField) createAddressWidget.fields.get("city");
        if (cityF.getValue() == null || "".equals(cityF.getValue())) {
            cityF.setMessage("Please enter the city");
            valid = false;
        }
        StringField zipF = (StringField) createAddressWidget.fields.get("zip");
        if (zipF.getValue() == null || "".equals(zipF.getValue())) {
            zipF.setMessage("Please enter the Zip");
            valid = false;
        }
        EnumField stateF = (EnumField) createAddressWidget.fields.get("state");
        if (stateF.getValue() == null || "".equals(stateF.getValue())) {
            stateF.setMessage("Please select the state");
            valid = false;
        }
        EnumField countryF = (EnumField) createAddressWidget.fields.get("country");
        if (countryF.getValue() == null || "".equals(countryF.getValue())) {
            countryF.setMessage("Please select the country");
            valid = false;
        }
        return valid;
    }

    private boolean checkDirectClientValidations(boolean valid) {
        StringField paymentTerms = (StringField) fields.get("paymentTerms");
        if (paymentTerms.getValue() == null || "".equals(paymentTerms.getValue())) {
            paymentTerms.setMessage("Please enter the Payment Terms");
            valid = false;
        }
        EnumField invoiceFrequency = (EnumField) fields.get("clientinvFrequency");
        if (invoiceFrequency.getValue() == null || "".equals(invoiceFrequency.getValue())) {
            invoiceFrequency.setMessage("Please select Invoice Frequency");
            valid = false;
        }
        EnumField invoiceDeliveryMentod = (EnumField) fields.get("clientInvDeliveryMethod");
        if (invoiceDeliveryMentod.getValue() == null || "".equals(invoiceDeliveryMentod.getValue())) {
            invoiceDeliveryMentod.setMessage("Please select Invoice Delivery Method");
            valid = false;
        }
//        FloatField clientFee = (FloatField) fields.get("clientFee");
//        if (clientFee.getValue() == null || "".equals(clientFee.getValue())) {
//            clientFee.setMessage("Please enter the Client Fee");
//            valid = false;
//        }
        DateField msaValDate = (DateField) fields.get("msaValDate");
        if (msaValDate.getDate() == null || "".equals(msaValDate.getDate())) {
            msaValDate.setMessage("MSA Period From cannot be Empty");
            valid = false;
        }
        DateField msaExpDate = (DateField) fields.get("msaExpDate");
        if (msaExpDate.getDate() == null || "".equals(msaExpDate.getDate())) {
            msaExpDate.setMessage("MSA Period To cannot be Empty");
            valid = false;
        }
        IntegerField termNoticePeriod = (IntegerField) fields.get("terminationNoticePeriod");
        if (termNoticePeriod.getValue() == null || "".equals(termNoticePeriod.getValue())) {
            termNoticePeriod.setMessage("Please enter the Termination Notice Period");
            valid = false;
        }
        valid = checkRecruiterContactValidations(valid);
        valid = checkAcctPayableValidations(valid);

        return valid;
    }

    private boolean checkRecruiterContactValidations(boolean valid) {
        StringField contactFirstNameF = (StringField) createContactWidget1.fields.get("firstName");
        if (contactFirstNameF.getValue() == null || "".equals(contactFirstNameF.getValue())) {
            contactFirstNameF.setMessage("Please enter the first name");
            valid = false;
        }
        StringField contactLastNameF = (StringField) createContactWidget1.fields.get("lastName");
        if (contactLastNameF.getValue() == null || "".equals(contactLastNameF.getValue())) {
            contactLastNameF.setMessage("Please enter the last name");
            valid = false;
        }
        StringField recruiterEmail = (StringField) createContactWidget1.fields.get("email");
        if (recruiterEmail.getValue() == null || "".equals(recruiterEmail.getValue())) {
            recruiterEmail.setMessage("Please enter email");
            valid = false;
        }
        for (CreatePhonePanel createPhoneWidget : createContactWidget1.getChildWidgets()) {
            LongField phoneNumberF = (LongField) createPhoneWidget.fields.get("phoneNumber");
            if (createPhoneWidget.phoneTypeF.getSelectedObject() == null) {
                createPhoneWidget.phoneTypeF.setMessage("Please select Phone Type");
                valid = false;
            }
            if (phoneNumberF.getValue() == null || "".equals(phoneNumberF.getValue())) {
                phoneNumberF.setMessage("Please enter a phone number");
                valid = false;
            } else if (phoneNumberF.getValue() != null) {
                String number = phoneNumberF.getValue();
                if (!number.matches("[0-9]*")) {
                    phoneNumberF.setMessage("Invalid Phone Number");
                    valid = false;
                } else if (number.length() != 10) {
                    phoneNumberF.setMessage("PhoneNumber must be 10 characters long");
                    valid = false;
                }
            }
        }
        return valid;
    }

    private boolean checkAcctPayableValidations(boolean valid) {
        StringField contactFirstNameF = (StringField) createContactWidget2.fields.get("firstName");
        if (contactFirstNameF.getValue() == null || "".equals(contactFirstNameF.getValue())) {
            contactFirstNameF.setMessage("Please enter the first name");
            valid = false;
        }
        StringField contactLastNameF = (StringField) createContactWidget2.fields.get("lastName");
        if (contactLastNameF.getValue() == null || "".equals(contactLastNameF.getValue())) {
            contactLastNameF.setMessage("Please enter the last name");
            valid = false;
        }
        StringField accountPayableEmail = (StringField) createContactWidget2.fields.get("email");
        if (accountPayableEmail.getValue() == null || "".equals(accountPayableEmail.getValue())) {
            accountPayableEmail.setMessage("Please enter email");
            valid = false;
        }
        for (CreatePhonePanel createPhoneWidget : createContactWidget2.getChildWidgets()) {
            LongField phoneNumberF = (LongField) createPhoneWidget.fields.get("phoneNumber");
            if (createPhoneWidget.phoneTypeF.getSelectedObject() == null) {
                createPhoneWidget.phoneTypeF.setMessage("Please select Phone Type");
                valid = false;
            }
            if (phoneNumberF.getValue() == null || "".equals(phoneNumberF.getValue())) {
                phoneNumberF.setMessage("Please enter a phone number");
                valid = false;
            } else if (phoneNumberF.getValue() != null) {
                String number = phoneNumberF.getValue();
                if (!number.matches("[0-9]*")) {
                    phoneNumberF.setMessage("Invalid Phone Number");
                    valid = false;
                } else if (number.length() != 10) {
                    phoneNumberF.setMessage("PhoneNumber must be 10 characters long");
                    valid = false;
                }
            }
        }
        return valid;
    }
}
