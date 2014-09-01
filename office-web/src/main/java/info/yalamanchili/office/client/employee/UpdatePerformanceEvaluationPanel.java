/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class UpdatePerformanceEvaluationPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdatePerformanceEvaluationPanel.class.getName());
    SelectEmployeeWidget selectEmployeeWidgetF = new SelectEmployeeWidget("Employee", false, true);

    public UpdatePerformanceEvaluationPanel(JSONObject entity) {
        initUpdateComposite(entity, "PerformanceEvaluation", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("employee", entity);
        assignEntityValueFromField("evaluationDate", entity);
        assignEntityValueFromField("evaluationPeriodStartDate", entity);
        assignEntityValueFromField("evaluationPeriodEndDate", entity);
        assignEntityValueFromField("type", entity);
        assignEntityValueFromField("rating", entity);
        assignEntityValueFromField("keyAccomplishments", entity);
        assignEntityValueFromField("areasNeedImprovement", entity);
        assignEntityValueFromField("managersComments", entity);
        assignEntityValueFromField("employeeComments", entity);
        assignEntityValueFromField("ceoComments", entity);
        logger.info("ddd" + entity);
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
        assignFieldValueFromEntity("employee", entity, null);
        assignFieldValueFromEntity("evaluationDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("evaluationPeriodStartDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("evaluationPeriodEndDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("type", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("rating", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("keyAccomplishments", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("areasNeedImprovement", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("managersComments", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("employeeComments", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("ceoComments", entity, DataType.RICH_TEXT_AREA);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully  Updated PerformanceEvaluation Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllPerformanceEvaluationPanel(getEntityId()));
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addDropDown("employee", selectEmployeeWidgetF);
        addField("evaluationDate", false, false, DataType.DATE_FIELD);
        addField("evaluationPeriodStartDate", false, true, DataType.DATE_FIELD);
        addField("evaluationPeriodEndDate", false, true, DataType.DATE_FIELD);
        addEnumField("type", false, true, EvaluationFrequencyType.names());
        addField("rating", false, true, DataType.INTEGER_FIELD);
        addField("keyAccomplishments", false, false, DataType.RICH_TEXT_AREA);
        addField("areasNeedImprovement", false, false, DataType.RICH_TEXT_AREA);
        addField("managersComments", false, false, DataType.RICH_TEXT_AREA);
        addField("employeeComments", false, false, DataType.RICH_TEXT_AREA);
        addField("ceoComments", false, false, DataType.RICH_TEXT_AREA);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "performance-evaluation";
    }
}
