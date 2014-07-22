/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadPerformanceEvaluationPanel extends ReadComposite {

    private static ReadPerformanceEvaluationPanel instance;
    private static Logger logger = Logger.getLogger(ReadPerformanceEvaluationPanel.class.getName());
    SelectEmployeeWidget selectEmployeeWidgetF = new SelectEmployeeWidget("Employee", false, true);

    public static ReadPerformanceEvaluationPanel instance() {
        return instance;
    }

    public ReadPerformanceEvaluationPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "PerformanceEvaluation", OfficeWelcome.constants);
    }

    public ReadPerformanceEvaluationPanel(String id) {
        initReadComposite(id, "PerformanceEvaluation", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String response) {
                logger.info("read ec6 response" + response);
                entity = (JSONObject) JSONParser.parseLenient(response);
                populateFieldsFromEntity(entity);
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
        assignFieldValueFromEntity("keyAccomplishments", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("areasNeedImprovement", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("managersComments", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("employeeComments", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("ceoComments", entity, DataType.STRING_FIELD);
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
        addField("keyAccomplishments", false, false, DataType.STRING_FIELD);
        addField("areasNeedImprovement", false, false, DataType.STRING_FIELD);
        addField("managersComments", false, false, DataType.STRING_FIELD);
        addField("employeeComments", false, false, DataType.STRING_FIELD);
        addField("ceoComments", false, false, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "performance-evaluation";
    }
}
