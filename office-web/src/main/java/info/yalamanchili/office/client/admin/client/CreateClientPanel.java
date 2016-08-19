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
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.LongField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.admin.clientcontact.CreateClientContactPanel;
import info.yalamanchili.office.client.profile.address.CreateAddressPanel;
import info.yalamanchili.office.client.profile.address.CreateAddressWidget;
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
    HTML primaryLocation = new HTML("<h4 style=\"color:#427fed\">" + "Client Primary Address </h4>");
    HTML recruiterContact = new HTML("<h4 style=\"color:#427fed\">" + "Recruiter Contact Information </h4>");
    HTML acntPybleContact = new HTML("<h4 style=\"color:#427fed\">" + "Account Payable Contact Information </h4>");

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
        assignEntityValueFromField("paymentTerms", clnt);
        assignEntityValueFromField("clientinvFrequency", clnt);
        assignEntityValueFromField("clientFee", clnt);
//        assignEntityValueFromField("maxClientFee", clnt);
//        assignEntityValueFromField("minClientFee", clnt);
        assignEntityValueFromField("msaValDate", clnt);
        assignEntityValueFromField("msaExpDate", clnt);

        if (createAddressWidget != null) {
            clnt.put("location", createAddressWidget.populateEntityFromFields());
        }
        if (addRecruiterContact.getValue()) {
            clnt.put("contact", createContactWidget1.populateEntityFromFields());
        }
        if (addAcntPybleContact.getValue()) {
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
        new ResponseStatusWidget().show("Successfully created Client");
        String id = JSONUtils.toString(JSONParser.parseLenient(result), "id");
        TabPanel.instance().adminPanel.sidePanelTop.clear();
        TabPanel.instance().adminPanel.sidePanelTop.add(new ClientSidePanel());
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllClientsPanel(id));;
    }

    @Override
    protected void addListeners() {
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
        addField("paymentTerms", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("clientinvFrequency", false, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
        addField("clientFee", false, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
//        addField("maxClientFee", false, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
//        addField("minClientFee", false, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        addField("msaValDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("msaExpDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);

        entityFieldsPanel.add(primaryLocation);
        entityFieldsPanel.add(createAddressWidget);

        entityFieldsPanel.add(addRecruiterContact);
        entityFieldsPanel.add(addAcntPybleContact);
        alignFields();
    }

    @Override
    public void onClick(ClickEvent event) {
        if (addRecruiterContact.getValue()) {
            entityFieldsPanel.insert(recruiterContact, entityFieldsPanel.getWidgetIndex(addRecruiterContact)+1);
            entityFieldsPanel.insert(createContactWidget1, entityFieldsPanel.getWidgetIndex(recruiterContact)+1);
            
        } else {
            entityFieldsPanel.remove(recruiterContact);
            entityFieldsPanel.remove(createContactWidget1);
        }
        if (addAcntPybleContact.getValue()) {
            entityFieldsPanel.add(acntPybleContact);
            entityFieldsPanel.add(createContactWidget2);
        } else {
            entityFieldsPanel.remove(acntPybleContact);
            entityFieldsPanel.remove(createContactWidget2);
        }

        super.onClick(event);
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

        StringField clientNameF = (StringField) fields.get("name");
        if (clientNameF.getValue() == null || "".equals(clientNameF.getValue())) {
            clientNameF.setMessage("client name can not be empty");
            valid = false;
        }
        StringField street1F = (StringField) createAddressWidget.fields.get("street1");
        if (street1F.getValue() == null || "".equals(street1F.getValue())) {
            street1F.setMessage("street1 can not be empty");
            valid = false;
        }
        StringField cityF = (StringField) createAddressWidget.fields.get("city");
        if (cityF.getValue() == null || "".equals(cityF.getValue())) {
            cityF.setMessage("city can not be empty");
            valid = false;
        }
        StringField zipF = (StringField) createAddressWidget.fields.get("zip");
        if (zipF.getValue() == null || "".equals(zipF.getValue())) {
            zipF.setMessage("Zip can not be empty");
            valid = false;
        }
        EnumField stateF = (EnumField) createAddressWidget.fields.get("state");
        if (stateF.getValue() == null || "".equals(stateF.getValue())) {
            stateF.setMessage("state name can not be empty");
            valid = false;
        }
        EnumField countryF = (EnumField) createAddressWidget.fields.get("country");
        if (countryF.getValue() == null || "".equals(countryF.getValue())) {
            countryF.setMessage("country name can not be empty");
            valid = false;
        }
        if (addRecruiterContact.getValue()) {

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
            for (CreatePhonePanel createPhoneWidget : createContactWidget1.getChildWidgets()) {
                LongField phoneNumberF = (LongField) createPhoneWidget.fields.get("phoneNumber");

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
        }

        if (addAcntPybleContact.getValue()) {
            StringField contactFirstNameF = (StringField) createContactWidget2.fields.get("firstName");
            if (contactFirstNameF.getValue() == null || "".equals(contactFirstNameF.getValue())) {
                contactFirstNameF.setMessage("Please enter the first name");
                valid = false;
            }
            StringField contactLastNameF = (StringField) createContactWidget2.fields.get("lastName");
            if (contactLastNameF.getValue() == null || "".equals(contactLastNameF.getValue())) {
                contactLastNameF.setMessage("Please enter a phone number");
                valid = false;
            }
            for (CreatePhonePanel createPhoneWidget : createContactWidget2.getChildWidgets()) {
                LongField phoneNumberF = (LongField) createPhoneWidget.fields.get("phoneNumber");

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
        }
        return valid;
    }
}
