/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.advancerequisition;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.time.consultant.ConsultantEmpLeaveRequestPanel;
import info.yalamanchili.office.client.time.consultant.ConsultantTimeSummarySidePanel;
import info.yalamanchili.office.client.time.consultant.ReadAllConsultantTimeSheetsPanel;
import info.yalamanchili.office.client.time.consultant.ReadCurrentConsultantLeavesPanel;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class AdvanceRequisitionRequestPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(ConsultantEmpLeaveRequestPanel.class.getName());

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
        entity.put("status", new JSONString("Open"));
        entity.put("employee", new JSONObject());
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
        new ResponseStatusWidget().show("Request Submited, please wait for email notification within 48 hours");
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
        addField("purpose", false, true, DataType.STRING_FIELD);
        addField("amount", false, true, DataType.CURRENCY_FIELD);
        addField("neededBy", false, true, DataType.DATE_FIELD);
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        return true;
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "advancerequisition/submit-advance-requisition-request";
    }
}
