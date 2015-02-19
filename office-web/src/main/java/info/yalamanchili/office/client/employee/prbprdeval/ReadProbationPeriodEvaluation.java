/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prbprdeval;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadProbationPeriodEvaluation extends ReadComposite {

    private static ReadProbationPeriodEvaluation instance;
    private static Logger logger = Logger.getLogger(ReadProbationPeriodEvaluation.class.getName());
    SelectEmployeeWidget selectEmployeeWidgetF = new SelectEmployeeWidget("Employee", false, true);

    public static ReadProbationPeriodEvaluation instance() {
        return instance;
    }

    public ReadProbationPeriodEvaluation(String id) {
        initReadComposite(id, "ProbationPeriodEvaluation", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String response) {
                logger.info(response);
                entity = (JSONObject) JSONParser.parseLenient(response);
                populateFieldsFromEntity(entity);
            }
        });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        logger.info("eeee" + entity);

        assignFieldValueFromEntity("stage", entity, DataType.ENUM_FIELD);

    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        formatTextAreaFields();
    }

    @Override
    protected void addWidgets() {

        addEnumField("stage", true, true, ProbationPeriodEvaluationStage.names(), Alignment.HORIZONTAL);

    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.instance().constants.root_url() + "probation-period-evaluation/delete/" + entityId;
    }

    private void formatTextAreaFields() {
        for (Map.Entry entry : fields.entrySet()) {
            if (entry.getValue() instanceof TextAreaField) {
                TextAreaField textAreaField = (TextAreaField) entry.getValue();
                textAreaField.getTextbox().setCharacterWidth(75);
                textAreaField.getTextbox().setVisibleLines(4);
            }
        }
    }
}
