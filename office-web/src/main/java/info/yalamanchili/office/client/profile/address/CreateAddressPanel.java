/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.address;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;
import info.yalamanchili.office.client.profile.addresstype.SelectAddressTypeWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.chili.gwt.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.data.CanadaStatesFactory;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.IndiaStatesFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;

public class CreateAddressPanel extends CreateComposite implements ChangeHandler {

    private static Logger logger = Logger.getLogger(CreateAddressPanel.class.getName());
    protected static HTML notifyChangeInstructions = new HTML("<h5>Please choose <strong>Notify Change</strong> check box if you are changing to a new address</span><span style=\\\"line-height: 20.7999992370605px;\\\"> that needs to communicated to other departments (Payroll, HR and Health Insurance)</h5>");
    protected static HTML notifyChangeInstructions2 = new HTML("<h5>If <strong>Notify Change</strong> is selected Payroll and HR Department will be notified by default</h5>");

    public enum CreateAddressPanelType {

        ALL, MIN, CHANGE_WITH_TYPE_NOTIFY
    }
    CreateAddressPanelType type;

    public CreateAddressPanel(CreateAddressPanelType type) {
        super(CreateCompositeType.CREATE);
        this.type = type;
        initCreateComposite("Address", OfficeWelcome.constants);
    }

    BooleanField notifyChangeF;
    BooleanField notifyHealthInsuranceF;
    TextAreaField changeNotesF;
    protected EnumField statesF;
    protected EnumField countriesF;
    protected StringField zipField;
    protected StringField cityField;

    @Override
    protected JSONObject populateEntityFromFields() {
        //TODO is thid needed
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("street1", entity);
        assignEntityValueFromField("street2", entity);
        assignEntityValueFromField("zip", entity);
        assignEntityValueFromField("city", entity);
        assignEntityValueFromField("state", entity);
        assignEntityValueFromField("country", entity);
        if (CreateAddressPanelType.ALL.equals(type)) {
            assignEntityValueFromField("addressType", entity);
        }
        if (CreateAddressPanelType.CHANGE_WITH_TYPE_NOTIFY.equals(type)) {
            assignEntityValueFromField("notifyChange", entity);
            assignEntityValueFromField("notifyHealthInsurance", entity);
            assignEntityValueFromField("changeNotes", entity);
        }
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        addButtonClicked();
    }

    @Override
    protected void addButtonClicked() {
        HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
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
        new ResponseStatusWidget().show("Successfully Added Employee Address");
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllAddressesPanel(TreeEmployeePanel.instance().getEntityId()));
            TabPanel.instance().myOfficePanel.entityPanel.add(new AddressOptionsPanel());
        } else if (TabPanel.instance().profilePanel.isVisible()) {
            //ProfileHome.instance().refreshAddresses();
            GenericPopup.instance().hide();
            TabPanel.instance().profilePanel.entityPanel.clear();
            TabPanel.instance().profilePanel.entityPanel.add(new ReadAllAddressesPopupPanel((OfficeWelcome.instance().employeeId)));
        }
    }

    @Override
    protected void addListeners() {
        if (notifyChangeF != null) {
            notifyChangeF.getBox().addClickHandler(this);
        }
        if (countriesF != null) {
            countriesF.listBox.addChangeHandler(this);
        }
        zipField.getTextbox().addChangeHandler(this);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (notifyChangeF != null && event.getSource().equals(notifyChangeF.getBox())) {
            if (notifyChangeF.getValue()) {
                renderChangeAddressFields(true);
            } else {
                renderChangeAddressFields(false);
            }
        } else {
            super.onClick(event);
        }
    }

    protected void renderChangeAddressFields(boolean show) {
        notifyHealthInsuranceF.setVisible(show);
        changeNotesF.setVisible(show);
        notifyChangeInstructions2.setVisible(show);
        if (show) {
            alignFields(180);
        }
    }

    @Override
    protected void configure() {
        if (CreateAddressPanelType.CHANGE_WITH_TYPE_NOTIFY.equals(type)) {
            notifyChangeF = (BooleanField) fields.get("notifyChange");
            notifyChangeF.setValue(true);
            notifyHealthInsuranceF = (BooleanField) fields.get("notifyHealthInsurance");
            changeNotesF = (TextAreaField) fields.get("changeNotes");
            notifyHealthInsuranceF.setVisible(true);
            changeNotesF.setVisible(true);
            notifyChangeInstructions2.setVisible(true);
        }
    }

    @Override
    protected void addWidgets() {
        addField("street1", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("street2", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("zip", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("city", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("state", false, true, DataType.ENUM_FIELD, Alignment.HORIZONTAL);
        addEnumField("country", false, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addEnumField("state", false, true, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);

        if (CreateAddressPanelType.ALL.equals(type)) {
            addDropDown("addressType", new SelectAddressTypeWidget(false, false));
        }
        if (CreateAddressPanelType.CHANGE_WITH_TYPE_NOTIFY.equals(type)) {
            addField("notifyChange", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            entityFieldsPanel.add(notifyChangeInstructions);
            entityFieldsPanel.add(notifyChangeInstructions2);
            addField("notifyHealthInsurance", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("changeNotes", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        }
        statesF = (EnumField) fields.get("state");
        countriesF = (EnumField) fields.get("country");
        zipField = (StringField) fields.get("zip");
        cityField = (StringField) fields.get("city");
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    protected String getURI() {
        if (TreeEmployeePanel.instance() == null) {
            return OfficeWelcome.constants.root_url() + "employee/address/" + OfficeWelcome.instance().employeeId;
        } else {
            return OfficeWelcome.constants.root_url() + "employee/address/" + TreeEmployeePanel.instance().getEntityId();
        }
    }

    @Override
    public void onChange(ChangeEvent event) {

        switch (countriesF.getValue()) {
            case "USA":
                statesF.setValues(USAStatesFactory.getStates().toArray(new String[0]));
                break;
            case "INDIA":
                statesF.setValues(IndiaStatesFactory.getStates().toArray(new String[0]));
                break;
            case "CANADA":
                statesF.setValues(CanadaStatesFactory.getStates().toArray(new String[0]));
                break;
        }

        if (event.getSource().equals(zipField.getTextbox())) {
            AddressByZipService.getZipInformationService(zipField.getValue(), cityField, statesF, countriesF);
        }
    }

}
