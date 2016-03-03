/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prefeval;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.employee.prefeval.PerformanceEvaluationWizard.PerformanceEvaluationWizardType;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class CreatePerformanceEvaluationPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreatePerformanceEvaluationPanel.class.getName());

    public enum CreatePerformanceEvaluationPanelType {

        Start, End
    }
    protected CreatePerformanceEvaluationPanelType type;
    protected BooleanField submitForApprovalF = new BooleanField(OfficeWelcome.constants, "Submit For Approval", "PerformanceEvaluation", false, false, Alignment.HORIZONTAL);

    public CreatePerformanceEvaluationPanel(CreatePerformanceEvaluationPanelType type) {
        super(CreateCompositeType.CREATE);
        this.type = type;
        initCreateComposite("PerformanceEvaluation", OfficeWelcome.constants);
    }

    protected void loadData() {
        if (CreatePerformanceEvaluationPanelType.Start.equals(type) && PerformanceEvaluationWizard.instance().year != null) {
            HttpService.HttpServiceAsync.instance().doGet(getDataUrl(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String arg0) {
                            logger.info("read=resp" + arg0);
                            if (arg0 != null) {
                                populateFieldsFromEntity(JSONParser.parseLenient(arg0).isObject());
                            }
                        }
                    });
        }
    }

    protected void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("evaluationPeriodStartDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("evaluationPeriodEndDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("type", entity, DataType.ENUM_FIELD);
        if (fields.containsKey("evaluationFYYear")) {
            assignFieldValueFromEntity("evaluationFYYear", entity, null);
        }
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
            if (fields.containsKey("evaluationFYYear")) {
                SelectComposite yearF = (SelectComposite) fields.get("evaluationFYYear");
                entity.put("evaluationFYYear", yearF.getSelectedObject().get("id").isString());
            }
        }
        if (CreatePerformanceEvaluationPanelType.End.equals(type)) {
            assignEntityValueFromField("keyAccomplishments", entity);
            assignEntityValueFromField("areasNeedImprovement", entity);
//            assignEntityValueFromField("nextYearObjectives", entity);
            assignEntityValueFromField("managerComments", entity);
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
        formatTextAreaFields();
    }

    protected void formatTextAreaFields() {
        for (Map.Entry entry : fields.entrySet()) {
            if (entry.getValue() instanceof TextAreaField) {
                TextAreaField textAreaField = (TextAreaField) entry.getValue();
                textAreaField.setBackgroundText();
                textAreaField.getTextbox().setCharacterWidth(75);
                textAreaField.getTextbox().setVisibleLines(4);
            }
        }
    }

    public SelectComposite getYearField() {
        if (fields.containsKey("evaluationFYYear")) {
            return ((SelectComposite) fields.get("evaluationFYYear"));
        } else {
            return null;
        }
    }

    public String getSubmitForApproval() {
        return submitForApprovalF.getValue().toString();
    }

    protected static HTML managerReviewStartInstructions = new HTML("<!doctype html>\n"
            + "<html>\n"
            + "<head>\n"
            + "	<title></title>\n"
            + "</head>\n"
            + "<body>\n"
            + "<h3 style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\"><strong>Instructions:</strong></h3>\n"
            + "\n"
            + "<ul>\n"
            + "	<li>\n"
            + "	<p><strong>Manager Review consists of 4 steps</strong></p>\n"
            + "\n"
            + "	<ul>\n"
            + "		<li>Skill and Aptitude Questions</li>\n"
            + "		<li>Attitude Questions</li>\n"
            + "		<li>Management Questions ( if applicable)</li>\n"
            + "		<li>Feedback Comments</li>\n"
            + "	</ul>\n"
            + "	</li>\n"
            + "	<li><strong>Tips</strong>:\n"
            + "	<ul>\n"
            + "		<li><span line-height:=\"\" style=\"\\font-size:\">In case you want to save a partial review to be able to update it later. </span>\n"
            + "		<ul>\n"
            + "			<li>Naviagate to the last step of the review by just entering the required ratings (step -1-2) and click&nbsp;<strong>Save&nbsp;</strong>on the last step.</li>\n"
            + "			<li>When ready to complete you can click update and make changes to save them</li>\n"
            + "		</ul>\n"
            + "		</li>\n"
            + "		<li>You can view the self reivew comments by clicking on the view icon of the performance evalauation and exand the self evaluation section.</li>\n"
            + "		<li>The final rating is automatically calcluated for you and is the average of all the ratings rounded to the nearest number.</li>\n"
            + "	</ul>\n"
            + "	</li>\n"
            + "	<li>\n"
            + "	<p><strong>Once the review is complete. Navigate to Home--&gt; My Tasks--&gt; View Task--&gt; Complete Manager Review Task with comments</strong>.</p>\n"
            + "	</li>\n"
            + "	<li><a href=\"\\\\\\https://apps.sstech.us/site/office/perf-eval/corp-approval-process.html\\\\\\\">Detailed Instructions.</a>\n"
            + "	<hr /></li>\n"
            + "</ul>\n"
            + "</body>\n"
            + "</html>");

    protected static HTML managerReviewEndInstructions = new HTML("<hr />\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\"><strong>Please do not forget to complete the Manager Review Task under Home --&gt;&nbsp;My Tasks once the review is complete to notify the employee about completion.</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");

    @Override
    protected void addWidgets() {
        if (CreatePerformanceEvaluationPanelType.Start.equals(type)) {
            if (PerformanceEvaluationWizard.instance().year != null) {
                //Manager review
                entityFieldsPanel.add(managerReviewStartInstructions);
                addField("evaluationPeriodStartDate", true, true, DataType.DATE_FIELD);
                addField("evaluationPeriodEndDate", true, true, DataType.DATE_FIELD);
                addEnumField("type", true, false, EvaluationFrequencyType.names());
            } else {
                //Create new review
                addDropDown("evaluationFYYear", new SelectYearWidget(null, false, true));
            }
        }
        if (CreatePerformanceEvaluationPanelType.End.equals(type)) {
            new ResponseStatusWidget().show("Estimated Final Rating: " + PerformanceEvaluationWizard.instance().getRating().toString());
            addField("keyAccomplishments", false, false, DataType.TEXT_AREA_FIELD);
            addField("areasNeedImprovement", false, false, DataType.TEXT_AREA_FIELD);
//            addField("nextYearObjectives", false, false, DataType.TEXT_AREA_FIELD);
            if (PerformanceEvaluationWizard.instance().type.equals(PerformanceEvaluationWizardType.SELF_MANAGER)) {
                addField("managerComments", false, false, DataType.TEXT_AREA_FIELD);
                addField("employeeComments", false, false, DataType.TEXT_AREA_FIELD);
            }
            if (PerformanceEvaluationWizard.instance().type.equals(PerformanceEvaluationWizardType.SELF_MANAGER)) {
                entityActionsPanel.add(submitForApprovalF);
                submitForApprovalF.setValue(true);
            }
            if (PerformanceEvaluationWizard.instance().type.equals(PerformanceEvaluationWizardType.MANAGER)) {
                entityFieldsPanel.add(managerReviewEndInstructions);
            }
        }
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "performance-evaluation";
    }

    protected String getDataUrl() {
        return OfficeWelcome.constants.root_url() + "performance-evaluation/read/" + PerformanceEvaluationWizard.instance().employeeId + "/" + PerformanceEvaluationWizard.instance().year;
    }

    protected String getValidateUrl() {
        return OfficeWelcome.constants.root_url() + "performance-evaluation/validate";
    }
}
