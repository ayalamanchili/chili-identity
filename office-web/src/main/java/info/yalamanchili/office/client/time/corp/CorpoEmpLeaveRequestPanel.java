/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time.corp;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.FloatField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class CorpoEmpLeaveRequestPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CorpoEmpLeaveRequestPanel.class.getName());

    public CorpoEmpLeaveRequestPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("CorpEmpLeaveRequest", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject submitLeave = new JSONObject();
        assignEntityValueFromField("startDate", submitLeave);
        assignEntityValueFromField("endDate", submitLeave);
        assignEntityValueFromField("hours", submitLeave);
        assignEntityValueFromField("category", submitLeave);
        assignEntityValueFromField("leaveRequestNotes", submitLeave);
        logger.info(submitLeave.toString());
        return submitLeave;
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
        addField("startDate", false, true, DataType.DATE_FIELD);
        addField("endDate", false, true, DataType.DATE_FIELD);
        addField("hours", false, true, DataType.FLOAT_FIELD);
        addEnumField("category", false, true, TimeSheetCategory.names());
        addField("leaveRequestNotes", false, false, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        boolean valid = true;
        DateField startDateF = (DateField) fields.get("startDate");
        DateField endDateF = (DateField) fields.get("endDate");
        FloatField hoursF = (FloatField) fields.get("hours");
        EnumField categiryF = (EnumField) fields.get("category");


        if (hoursF.getValue() == null || hoursF.getValue().isEmpty()) {
            hoursF.setMessage("value is required");
            valid = false;
        }
        if (categiryF.getValue() == null) {
            categiryF.setMessage("value is required");
            valid = false;
        }

        if (endDateF.getDate() == null) {
            endDateF.setMessage("value is required");
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
        return OfficeWelcome.constants.public_url() + "corporate-timesheet/submit-leave-request";
    }
}
