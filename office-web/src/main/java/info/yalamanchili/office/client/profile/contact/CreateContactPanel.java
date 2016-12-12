/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.contact;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.crud.CRUDComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.LongField;
import info.chili.gwt.fields.StringField;
import info.yalamanchili.office.client.profile.phone.CreatePhonePanel;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public abstract class CreateContactPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateContactPanel.class.getName());
    protected List<CreatePhonePanel> createPhoneWidgets = new ArrayList<CreatePhonePanel>();
    protected ClickableLink addPhoneL = new ClickableLink("add Phone");

    public CreateContactPanel(CreateCompositeType type) {
        super(type);
        initCreateComposite("Contact", OfficeWelcome.constants);
    }

    @Override
    protected Map<String, BaseField> getChildWidget(int childIndexWidget) {
        return ((CRUDComposite) createPhoneWidgets.get(childIndexWidget)).fields;
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        entity = new JSONObject();
        assignEntityValueFromField("firstName", entity);
        assignEntityValueFromField("middleInitial", entity);
        assignEntityValueFromField("lastName", entity);
        assignEntityValueFromField("sex", entity);
        assignEntityValueFromField("email", entity);
        //populate phones
        JSONArray phones = new JSONArray();
        int i = 0;
        for (CreatePhonePanel createPhoneWidget : createPhoneWidgets) {
            if (createPhoneWidget.getPopulatedEntity().keySet().size() > 0) {
                phones.set(i, createPhoneWidget.getPopulatedEntity());
                i++;
            }
        }
        if (phones.size() > 0) {
            entity.put("phones", phones);
        }
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void createButtonClicked() {
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
    protected abstract void postCreateSuccess(String result);

    @Override
    protected void addListeners() {
        addPhoneL.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("firstName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("middleInitial", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lastName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("sex", false, false, Sex.names(), Alignment.HORIZONTAL);
        addField("email", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addCreatePhonePanel();
        entityFieldsPanel.add(addPhoneL);
        alignFields();
    }

    protected void addCreatePhonePanel() {
        CreatePhonePanel createPhonePanel = new CreatePhonePanel(CreateCompositeType.ADD);
        createPhonePanel.add.setVisible(false);
        entityFieldsPanel.add(createPhonePanel);
        createPhoneWidgets.add(createPhonePanel);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addPhoneL)) {
            addCreatePhonePanel();
        } else {
            super.onClick(event);
        }
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected abstract String getURI();
    
    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        boolean valid = true;
        StringField firstName = (StringField) fields.get("firstName");
        if (firstName.getValue() == null || "".equals(firstName.getValue())) {
            firstName.setMessage("Please enter the first name");
            valid = false;
        }
        StringField lastName = (StringField) fields.get("lastName");
        if (lastName.getValue() == null || "".equals(lastName.getValue())) {
            lastName.setMessage("Please enter the last name");
            valid = false;
        }
        StringField emailF = (StringField) fields.get("email");
        if (emailF.getValue() == null || "".equals(emailF.getValue())) {
            emailF.setMessage("Please enter email");
            valid = false;
        }
        for (CreatePhonePanel createPhoneWidget : createPhoneWidgets) {
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
        return valid;
    }
}
