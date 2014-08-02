/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prefeval;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.employee.EvaluationFrequencyType;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class CreatePerformanceEvaluationPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreatePerformanceEvaluationPanel.class.getName());
    SelectEmployeeWidget selectEmployeeWidgetF = new SelectEmployeeWidget("Employee", false, true);
    protected String employeeId;

    public enum CreatePerformanceEvaluationPanelType {

        Start, End
    }
    protected CreatePerformanceEvaluationPanelType type;

    public CreatePerformanceEvaluationPanel(String employeeId, CreatePerformanceEvaluationPanelType type) {
        super(CreateCompositeType.CREATE);
        this.employeeId = employeeId;
        this.type = type;
        initCreateComposite("PerformanceEvaluation", OfficeWelcome.constants);
    }

    @Override
    public JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        entity.put("employeeId", new JSONString(""));
        if (CreatePerformanceEvaluationPanelType.Start.equals(type)) {
            assignEntityValueFromField("evaluationDate", entity);
            assignEntityValueFromField("evaluationPeriodStartDate", entity);
            assignEntityValueFromField("evaluationPeriodEndDate", entity);
            assignEntityValueFromField("type", entity);
            assignEntityValueFromField("rating", entity);
        }
        if (CreatePerformanceEvaluationPanelType.End.equals(type)) {
            assignEntityValueFromField("keyAccomplishments", entity);
            assignEntityValueFromField("areasNeedImprovement", entity);
            assignEntityValueFromField("managersComments", entity);
            assignEntityValueFromField("employeeComments", entity);
            assignEntityValueFromField("ceoComments", entity);
        }
        logger.info("ddd" + entity);
        return entity;
    }

    @Override
    protected void createButtonClicked() {

    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        create.setVisible(false);
    }

    @Override
    protected void addWidgets() {
        if (CreatePerformanceEvaluationPanelType.Start.equals(type)) {
            addField("evaluationPeriodStartDate", false, true, DataType.DATE_FIELD);
            addField("evaluationPeriodEndDate", false, true, DataType.DATE_FIELD);
            addEnumField("type", false, true, EvaluationFrequencyType.names());
            addField("rating", false, true, DataType.INTEGER_FIELD);
        }
        if (CreatePerformanceEvaluationPanelType.End.equals(type)) {
            addField("keyAccomplishments", false, false, DataType.RICH_TEXT_AREA);
            addField("areasNeedImprovement", false, false, DataType.RICH_TEXT_AREA);
            addField("managersComments", false, false, DataType.RICH_TEXT_AREA);
        }
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "performance-evaluation";
    }
}
