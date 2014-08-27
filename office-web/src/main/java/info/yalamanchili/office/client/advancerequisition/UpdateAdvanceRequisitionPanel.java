/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.advancerequisition;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.advancetranscation.AdvanceRequisitionStatus;
import info.yalamanchili.office.client.expense.bnkacct.UpdateBankAcctWidget;
import info.yalamanchili.office.client.expense.check.UpdateCheckWidget;
import info.yalamanchili.office.client.expense.check.UpdateCheckWidget.UpdateCheckWidgetType;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class UpdateAdvanceRequisitionPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateAdvanceRequisitionPanel.class.getName());
    UpdateCheckWidget updateCheckWidget;
    UpdateBankAcctWidget updateBankAcctWidget;

    public UpdateAdvanceRequisitionPanel(String entityId) {
        initUpdateComposite(entityId, "AdvanceRequisition", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("purpose", entity);
        assignEntityValueFromField("amount", entity);
        assignEntityValueFromField("neededBy", entity);
        assignEntityValueFromField("status", entity);
        if (updateCheckWidget != null) {
            entity.put("check", updateCheckWidget.populateEntityFromFields());
        }
        if (updateBankAcctWidget != null) {
            entity.put("bankAccount", updateBankAcctWidget.populateEntityFromFields());
        }
        logger.info("asdf" + entity);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postUpdateSuccess(arg0);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("purpose", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("amount", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("neededBy", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("status", entity, DataType.ENUM_FIELD);
        if (entity.containsKey("check")) {
            updateCheckWidget = new UpdateCheckWidget(UpdateCheckWidgetType.CHECK_MAILING_INFO,entity.get("check").isObject());
            entityFieldsPanel.add(updateCheckWidget);
        }
        if (entity.containsKey("bankAccount")) {
            updateBankAcctWidget = new UpdateBankAcctWidget(entity.get("bankAccount").isObject());
            entityFieldsPanel.add(updateBankAcctWidget);
        }
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully  Updated AdvanceRequisition Information");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllAdvanceRequisitionPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("purpose", false, true, DataType.STRING_FIELD);
        addField("amount", false, true, DataType.CURRENCY_FIELD);
        addField("neededBy", false, true, DataType.DATE_FIELD);
        addEnumField("status", false, false, AdvanceRequisitionStatus.names());
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "advancerequisition";
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                    }
                });

    }

    protected String getReadURI() {
        return OfficeWelcome.constants.root_url() + "advancerequisition/" + getEntityId();
    }
}
