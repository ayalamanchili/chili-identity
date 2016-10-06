/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendor;

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
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.FloatField;
import info.chili.gwt.fields.LongField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.admin.vendorcontact.CreateVendorContactPanel;
import info.yalamanchili.office.client.profile.address.CreateAddressPanel;
import info.yalamanchili.office.client.profile.address.CreateAddressWidget;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceDeliveryMethod;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceFrequency;
import info.yalamanchili.office.client.profile.contact.CreateContactWidget;
import info.yalamanchili.office.client.profile.phone.CreatePhonePanel;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class CreateVendorPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateVendorPanel.class.getName());

    CreateAddressWidget createAddressWidget = new CreateAddressWidget(CreateAddressPanel.CreateAddressPanelType.MIN);
    CreateContactWidget createContactWidget1 = new CreateContactWidget(CreateVendorContactPanel.CreateCompositeType.ADD);
    CreateContactWidget createContactWidget2 = new CreateContactWidget(CreateVendorContactPanel.CreateCompositeType.ADD);
    HTML primaryLocation = new HTML("<h4 style=\"color:#427fed\">" + "Vendor Location </h4>");
    HTML recruiterContact = new HTML("<h4 style=\"color:#427fed\">" + "Vendor Recruiter Contact </h4>");
    HTML acntPybleContact = new HTML("<h4 style=\"color:#427fed\">" + "Vendor Account Payable Contact </h4>");

    public CreateVendorPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("Vendors", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject vendor = new JSONObject();
        assignEntityValueFromField("name", vendor);
        assignEntityValueFromField("website", vendor);
        assignEntityValueFromField("paymentTerms", vendor);
        assignEntityValueFromField("vendorinvFrequency", vendor);
        assignEntityValueFromField("vendorinvDeliveryMethod", vendor);
        assignEntityValueFromField("vendorFees", vendor);
        assignEntityValueFromField("maxFees", vendor);
        assignEntityValueFromField("minFees", vendor);
        assignEntityValueFromField("msaValDate", vendor);
        assignEntityValueFromField("msaExpDate", vendor);
        assignEntityValueFromField("terminationNotice", vendor);
        assignEntityValueFromField("vendorType", vendor);
        assignEntityValueFromField("coiEndDate", vendor);

        if (createAddressWidget != null) {
            vendor.put("location", createAddressWidget.populateEntityFromFields());
        }
        if (createContactWidget1 != null) {
            vendor.put("contact", createContactWidget1.populateEntityFromFields());
        }
        if (createContactWidget2 != null) {
            vendor.put("vendorAcctPayContact", createContactWidget2.populateEntityFromFields());
        }
        return vendor;
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
    }

    @Override
    protected void postCreateSuccess(String result) {
        if (GenericPopup.instance() != null) {
            GenericPopup.instance().hide();
        }
        if (SelectVendorWidget.instance() != null) {
            SelectVendorWidget.instance().fetchDropDownData();
        }
        new ResponseStatusWidget().show("Successfully Vendor Created");
        String id = JSONUtils.toString(JSONParser.parseLenient(result), "id");
        TabPanel.instance().adminPanel.sidePanelTop.clear();
        TabPanel.instance().adminPanel.sidePanelTop.add(new VendorsSidePanel());
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllVendorsPanel(id));
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
        addField("website", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("vendorType", false, true, VendorType.names(), Alignment.HORIZONTAL);
        addField("paymentTerms", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("vendorinvFrequency", false, true, InvoiceFrequency.names(), Alignment.HORIZONTAL);
        addEnumField("vendorinvDeliveryMethod", false, true, InvoiceDeliveryMethod.names(), Alignment.HORIZONTAL);
        addField("vendorFees", false, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        addField("maxFees", false, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        addField("minFees", false, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        addField("msaValDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("msaExpDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("terminationNotice", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("coiEndDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(primaryLocation);
        entityFieldsPanel.add(createAddressWidget);
        entityFieldsPanel.add(recruiterContact);
        entityFieldsPanel.add(createContactWidget1);
        entityFieldsPanel.add(acntPybleContact);
        entityFieldsPanel.add(createContactWidget2);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "vendor/create";
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        boolean valid = true;
        DateField msaValDate = (DateField) fields.get("msaValDate");
        DateField msaExpDate = (DateField) fields.get("msaExpDate");
        StringField vendorNameF = (StringField) fields.get("name");
        if (vendorNameF.getValue() == null || "".equals(vendorNameF.getValue())) {
            vendorNameF.setMessage("Please enter a name for the Vendor");
            valid = false;
        }
        EnumField vendorTypeF = (EnumField) fields.get("vendorType");
        if (vendorTypeF.getValue() == null || "".equals(vendorTypeF.getValue())) {
            vendorTypeF.setMessage("Please enter Vendor Type ");
            valid = false;
        }
        StringField paymentTermsF = (StringField) fields.get("paymentTerms");
        if (paymentTermsF.getValue() == null || "".equals(paymentTermsF.getValue())) {
            paymentTermsF.setMessage("Please enter the Payment Terms");
            valid = false;
        }
        EnumField vendorinvFrequencyF = (EnumField) fields.get("vendorinvFrequency");
        if (vendorinvFrequencyF.getValue() == null || "".equals(vendorinvFrequencyF.getValue())) {
            vendorinvFrequencyF.setMessage("Please enter Invoice Frequency ");
            valid = false;
        }
        EnumField vendorinvDeliveryMethodF = (EnumField) fields.get("vendorinvDeliveryMethod");
        if (vendorinvDeliveryMethodF.getValue() == null || "".equals(vendorinvDeliveryMethodF.getValue())) {
            vendorinvDeliveryMethodF.setMessage("Please enter Invoice Delivery Method ");
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

        StringField recruiterFirstName = (StringField) createContactWidget1.fields.get("firstName");
        if (recruiterFirstName.getValue() == null || "".equals(recruiterFirstName.getValue())) {
            recruiterFirstName.setMessage("Please enter the first name");
            valid = false;
        }
        StringField recruiterLastName = (StringField) createContactWidget1.fields.get("lastName");
        if (recruiterLastName.getValue() == null || "".equals(recruiterLastName.getValue())) {
            recruiterLastName.setMessage("Please enter the last name");
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

        StringField accountPayableFirstName = (StringField) createContactWidget2.fields.get("firstName");
        if (accountPayableFirstName.getValue() == null || "".equals(accountPayableFirstName.getValue())) {
            accountPayableFirstName.setMessage("Please enter the first name");
            valid = false;
        }
        StringField accountPayableLastName = (StringField) createContactWidget2.fields.get("lastName");
        if (accountPayableLastName.getValue() == null || "".equals(accountPayableLastName.getValue())) {
            accountPayableLastName.setMessage("Please enter the last name");
            valid = false;
        }
        for (CreatePhonePanel createPhoneWidget : createContactWidget2.getChildWidgets()) {
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
                    phoneNumberF.setMessage("PhoneNumber must be 10 characters long");
                    valid = false;
                }
            }
        }
        StringField accountPayableEmail = (StringField) createContactWidget2.fields.get("email");
        if (accountPayableEmail.getValue() == null || "".equals(accountPayableEmail.getValue())) {
            accountPayableEmail.setMessage("Please enter email");
            valid = false;
        }
         if (msaValDate.getDate() != null && msaExpDate.getDate() != null && msaValDate.getDate().after(msaExpDate.getDate())) {
            msaExpDate.setMessage("To Date must be after From Date");
            return false;
        }
        return valid;
    }
}
