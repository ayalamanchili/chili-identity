/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.Feedback;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class AccountResetPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(FeedbackPanel.class.getName());

    public AccountResetPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("AccountReset", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject account = new JSONObject();
        assignEntityValueFromField("firstName", account);
        assignEntityValueFromField("lastName", account);
        assignEntityValueFromField("email", account);
        assignEntityValueFromField("phoneNumber", account);
        assignEntityValueFromField("dateOfBirth", account);
        assignEntityValueFromField("startDate", account);
        logger.info(account.toString());
        return account;
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
        new ResponseStatusWidget().show("Request Submited, please wait for email with further instructions");
        GenericPopup.instance().hide();
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        setButtonText("Submit");
    }

    @Override
    protected void addWidgets() {
        addField("firstName", false, true, DataType.STRING_FIELD);
        addField("lastName", false, true, DataType.STRING_FIELD);
        addField("email", false, true, DataType.STRING_FIELD);
        addField("phoneNumber", false, false, DataType.LONG_FIELD);
        addField("dateOfBirth", false, true, DataType.DATE_FIELD);
        addField("startDate", false, true, DataType.DATE_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        boolean valid = true;
        StringField firstNameF = (StringField) fields.get("firstName");
        StringField lastNameF = (StringField) fields.get("lastName");
        StringField emailF = (StringField) fields.get("email");
        DateField dateOfBirthF = (DateField) fields.get("dateOfBirth");
        DateField startDateF = (DateField) fields.get("startDate");

        if (firstNameF.getValue() == null || firstNameF.getValue().isEmpty()) {
            firstNameF.setMessage("value is required");
            valid = false;
        }
        if (lastNameF.getValue() == null || lastNameF.getValue().isEmpty()) {
            lastNameF.setMessage("value is required");
            valid = false;
        }
        if (emailF.getValue() == null || emailF.getValue().isEmpty()) {
            emailF.setMessage("value is required");
            valid = false;
        }
        if (dateOfBirthF.getDate() == null) {
            dateOfBirthF.setMessage("value is required");
            valid = false;
        }
        if (startDateF.getDate() == null) {
            startDateF.setMessage("value is required");
            valid = false;
        }
        return valid;
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.public_url() + "admin/account_reset";
    }

    @Override
    protected boolean showDocumentationLink() {
        return true;
    }

    @Override
    protected String getDocumentationLink() {
        return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "accountresettask.html";
    }
}
