/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.statusreport;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadStatusReportPanel extends ReadComposite {

    private static ReadStatusReportPanel instance;
    private static Logger logger = Logger.getLogger(ReadStatusReportPanel.class.getName());

    public static ReadStatusReportPanel instance() {
        return instance;
    }

    public ReadStatusReportPanel(String id) {
        initReadComposite(id, "StatusReport", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    protected void populateComments() {
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.client.StatusReport"));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("projectDescription", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("reportStartDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("reportEndDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("status", entity, DataType.ENUM_FIELD);

        assignFieldValueFromEntity("projectPhase1Name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("projectPhase1Deliverable", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("projectPhase1EndDate", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("projectPhase1Status", entity, DataType.STRING_FIELD);

        assignFieldValueFromEntity("projectPhase2Name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("projectPhase2Deliverable", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("projectPhase2EndDate", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("projectPhase2Status", entity, DataType.STRING_FIELD);

        assignFieldValueFromEntity("projectPhase3Name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("projectPhase3Deliverable", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("projectPhase3EndDate", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("projectPhase3Status", entity, DataType.STRING_FIELD);

        assignFieldValueFromEntity("projectPhase4Name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("projectPhase4Deliverable", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("projectPhase4EndDate", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("projectPhase4Status", entity, DataType.STRING_FIELD);

        assignFieldValueFromEntity("statusDescription", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("accomplishments", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("scheduledActivities", entity, DataType.TEXT_AREA_FIELD);

        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_RELATIONSHIP)) {
            assignFieldValueFromEntity("preparedBy", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("approvedBy", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("submittedDate", entity, DataType.DATE_FIELD);
            assignFieldValueFromEntity("approvedDate", entity, DataType.DATE_FIELD);
        }
        populateComments();
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        formatTextAreaFields();
    }

    protected void formatTextAreaFields() {
        for (Map.Entry entry : fields.entrySet()) {
            if (entry.getValue() instanceof TextAreaField) {
                TextAreaField textAreaField = (TextAreaField) entry.getValue();
                textAreaField.getTextbox().setCharacterWidth(75);
                textAreaField.getTextbox().setVisibleLines(4);
            }
        }
    }

    @Override
    protected void addWidgets() {
        addField("projectDescription", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("reportStartDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("reportEndDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("status", false, true, ProjectStatus.names(), Alignment.HORIZONTAL);

        entityFieldsPanel.add(getLineSeperatorTag("Project Phase 1"));
        addField("projectPhase1Name", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase1Deliverable", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase1EndDate", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase1Status", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Project Phase 2"));
        addField("projectPhase2Name", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase2Deliverable", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase2EndDate", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase2Status", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Project Phase 3"));
        addField("projectPhase3Name", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase3Deliverable", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase3EndDate", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase3Status", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Project Phase 4"));
        addField("projectPhase4Name", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase4Deliverable", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase4EndDate", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase4Status", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);

        addField("statusDescription", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("accomplishments", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("scheduledActivities", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_RELATIONSHIP)) {
            addField("preparedBy", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("approvedBy", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("submittedDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
            addField("approvedDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        }
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "statusreport/" + entityId;
    }
}
