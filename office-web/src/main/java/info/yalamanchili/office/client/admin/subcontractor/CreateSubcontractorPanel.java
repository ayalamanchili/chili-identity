/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.subcontractor;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.LongField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.subcntrcontact.CreateSubcontractorContactPanel;
import info.yalamanchili.office.client.profile.address.CreateAddressPanel;
import info.yalamanchili.office.client.profile.address.CreateAddressWidget;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceDeliveryMethod;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceFrequency;
import info.yalamanchili.office.client.profile.contact.CreateContactWidget;
import info.yalamanchili.office.client.profile.phone.CreatePhonePanel;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class CreateSubcontractorPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateSubcontractorPanel.class.getName());

    CreateAddressWidget createAddressWidget = new CreateAddressWidget(CreateAddressPanel.CreateAddressPanelType.MIN);
    CreateContactWidget createContactWidget = new CreateContactWidget(CreateSubcontractorContactPanel.CreateCompositeType.ADD);
    HTML primaryLocation = new HTML("<h4 style=\"color:#427fed\">" + "Subcontractor Location </h4>");
    HTML contact = new HTML("<h4 style=\"color:#427fed\">" + "Subcontractor Recruiter Contact </h4>");

    public CreateSubcontractorPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("Subcontractor", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("name", entity);
        // assignEntityValueFromField("description", entity);
        assignEntityValueFromField("website", entity);
        assignEntityValueFromField("paymentTerms", entity);
        assignEntityValueFromField("invoiceFrequency", entity);
        EnumField field = (EnumField) fields.get("invoiceDeliveryMethod");
        if (field.getValue() != null && !field.getValue().trim().isEmpty()) {
            entity.put("invoiceDeliveryMethod", new JSONString(field.getValue()));
        } else {
            entity.put("invoiceDeliveryMethod", null);
        }
        //assignEntityValueFromField("invoiceDeliveryMethod", entity);
        assignEntityValueFromField("coiEndDate", entity);
        assignEntityValueFromField("msaValDate", entity);
        assignEntityValueFromField("msaExpDate", entity);
        assignEntityValueFromField("terminationNoticePeriod", entity);
        if (createAddressWidget != null) {
            entity.put("location", createAddressWidget.populateEntityFromFields());
        }
        if (createContactWidget != null) {
            entity.put("contact", createContactWidget.populateEntityFromFields());
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
        new ResponseStatusWidget().show("Successfully Created Subcontractor");
        String id = JSONUtils.toString(JSONParser.parseLenient(result), "id");
        TabPanel.instance().adminPanel.sidePanelTop.clear();
        TabPanel.instance().adminPanel.sidePanelTop.add(new SubcontractorSidePanel());
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllSubcontractorsPanel(id));
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
        //addField("description", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("website", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("paymentTerms", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("invoiceFrequency", false, true, InvoiceFrequency.names(), Alignment.HORIZONTAL);
        addEnumField("invoiceDeliveryMethod", false, true, InvoiceDeliveryMethod.names(), Alignment.HORIZONTAL);
        addField("coiEndDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("msaValDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("msaExpDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("terminationNoticePeriod", false, true, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(primaryLocation);
        entityFieldsPanel.add(createAddressWidget);
        entityFieldsPanel.add(contact);
        entityFieldsPanel.add(createContactWidget);

    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "subcontractor/create";
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        boolean valid = true;
        StringField paymentTermsF = (StringField) fields.get("paymentTerms");
        if (paymentTermsF.getValue() == null || "".equals(paymentTermsF.getValue())) {
            paymentTermsF.setMessage("Please enter  Payment Terms");
            valid = false;
        }
        DateField msaValDate = (DateField) fields.get("msaValDate");
        DateField msaExpDate = (DateField) fields.get("msaExpDate");
        if (msaValDate.getDate() != null && msaExpDate.getDate() != null && msaValDate.getDate().after(msaExpDate.getDate())) {
            msaExpDate.setMessage("To Date must be after From Date");
            return false;
        }
        EnumField invoiceFrequencyF = (EnumField) fields.get("invoiceFrequency");
        if (invoiceFrequencyF.getValue() == null || "".equals(invoiceFrequencyF.getValue())) {
            invoiceFrequencyF.setMessage("Please enter Invoice Frequency");
            valid = false;
        }
        EnumField invoiceDeliveryMethodF = (EnumField) fields.get("invoiceDeliveryMethod");
        if (invoiceDeliveryMethodF.getValue() == null || "".equals(invoiceDeliveryMethodF.getValue())) {
            invoiceDeliveryMethodF.setMessage("Please enter Invoice Delivery Method");
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
            zipF.setMessage("Please enter the zip code");
            valid = false;
        }
        EnumField stateF = (EnumField) createAddressWidget.fields.get("state");
        if (stateF.getValue() == null || "".equals(stateF.getValue())) {
            stateF.setMessage("Please enter the state");
            valid = false;
        }
        EnumField countryF = (EnumField) createAddressWidget.fields.get("country");
        if (countryF.getValue() == null || "".equals(countryF.getValue())) {
            countryF.setMessage("Please enter the country");
            valid = false;
        }

        StringField firstName = (StringField) createContactWidget.fields.get("firstName");
        if (firstName.getValue() == null || "".equals(firstName.getValue())) {
            firstName.setMessage("Please enter the first name");
            valid = false;
        }
        StringField lastName = (StringField) createContactWidget.fields.get("lastName");
        if (lastName.getValue() == null || "".equals(lastName.getValue())) {
            lastName.setMessage("Please enter the last name");
            valid = false;
        }
        for (CreatePhonePanel createPhoneWidget : createContactWidget.getChildWidgets()) {
            LongField phoneNumberF = (LongField) createPhoneWidget.fields.get("phoneNumber");
            if (createPhoneWidget.phoneTypeF.getSelectedObject() == null) {
                createPhoneWidget.phoneTypeF.setMessage("Please enter a Phone Type");
                valid = false;
            } else {
                String phoneTypeF = createPhoneWidget.phoneTypeF.getSelectedObject().get("value").isString().stringValue();
                if (phoneTypeF == null || "".equals(phoneTypeF)) {
                    createPhoneWidget.phoneTypeF.setMessage("Please enter a Phone Type");
                    valid = false;
                }
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
                    phoneNumberF.setMessage("Phone Number must be 10 characters long");
                    valid = false;
                }
            }
        }

        StringField emailF = (StringField) createContactWidget.fields.get("email");
        if (emailF.getValue() == null || "".equals(emailF.getValue())) {
            emailF.setMessage("Please enter email");
            valid = false;
        }

        return valid;
    }
}
