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
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.home.tasks.ReadAllTasks;
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
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.employee.statusreport.StatusReport"));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        JSONObject reportDocument = entity.get("reportDocument").isObject();
        assignFieldValueFromEntity("jobTitle", entity.get("employee").isObject(), DataType.STRING_FIELD);
        assignFieldValueFromEntity("projectDescription", reportDocument, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("reportStartDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("reportEndDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("status", entity, DataType.ENUM_FIELD);

        assignFieldValueFromEntity("projectPhase1Name", reportDocument, DataType.STRING_FIELD);
        assignFieldValueFromEntity("projectPhase1Deliverable", reportDocument, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("projectPhase1EndDate", reportDocument, DataType.STRING_FIELD);
        assignFieldValueFromEntity("projectPhase1Status", reportDocument, DataType.STRING_FIELD);

        assignFieldValueFromEntity("projectPhase2Name", reportDocument, DataType.STRING_FIELD);
        assignFieldValueFromEntity("projectPhase2Deliverable", reportDocument, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("projectPhase2EndDate", reportDocument, DataType.STRING_FIELD);
        assignFieldValueFromEntity("projectPhase2Status", reportDocument, DataType.STRING_FIELD);

        assignFieldValueFromEntity("projectPhase3Name", reportDocument, DataType.STRING_FIELD);
        assignFieldValueFromEntity("projectPhase3Deliverable", reportDocument, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("projectPhase3EndDate", reportDocument, DataType.STRING_FIELD);
        assignFieldValueFromEntity("projectPhase3Status", reportDocument, DataType.STRING_FIELD);

        assignFieldValueFromEntity("projectPhase4Name", reportDocument, DataType.STRING_FIELD);
        assignFieldValueFromEntity("projectPhase4Deliverable", reportDocument, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("projectPhase4EndDate", reportDocument, DataType.STRING_FIELD);
        assignFieldValueFromEntity("projectPhase4Status", reportDocument, DataType.STRING_FIELD);

        assignFieldValueFromEntity("statusDescription", reportDocument, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("accomplishments", reportDocument, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("scheduledActivities", reportDocument, DataType.TEXT_AREA_FIELD);

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
        addField("jobTitle", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectDescription", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("reportStartDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("reportEndDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("status", true, false, ProjectStatus.names(), Alignment.HORIZONTAL);

        entityFieldsPanel.add(getLineSeperatorTag("Project Phase 1"));
        addField("projectPhase1Name", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase1Deliverable", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase1EndDate", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase1Status", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Project Phase 2"));
        addField("projectPhase2Name", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase2Deliverable", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase2EndDate", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase2Status", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Project Phase 3"));
        addField("projectPhase3Name", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase3Deliverable", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase3EndDate", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase3Status", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Project Phase 4"));
        addField("projectPhase4Name", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase4Deliverable", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase4EndDate", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase4Status", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);

        addField("statusDescription", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("accomplishments", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("scheduledActivities", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_RELATIONSHIP)) {
            addField("preparedBy", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("approvedBy", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("submittedDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
            addField("approvedDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
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

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_RELATIONSHIP);
    }

    @Override
    protected boolean enableViewTasks() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION, Auth.ROLE.ROLE_HR);
    }

    @Override
    protected void displayTasks() {
        String tasksUrl = OfficeWelcome.constants.root_url() + "bpm/tasks/process/";
        tasksDP.setContent(new ReadAllTasks(tasksUrl + JSONUtils.toString(getEntity(), "bpmProcessId") + "/", true));
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.employee.statusreport.StatusReport" + "/" + getEntityId();
    }

    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllStatusReportPanel.instance;
    }    
    
    @Override
    protected boolean enableClone() {
        return true;
    }

    @Override
    protected void cloneClicked() {
        HttpService.HttpServiceAsync.instance().doGet(OfficeWelcome.constants.root_url() + "statusreport/clone/" + getEntityId(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {

                    @Override
                    public void onResponse(String arg0) {
                        logger.info(arg0);
                        TabPanel.instance().homePanel.entityPanel.clear();
                        TabPanel.instance().homePanel.entityPanel.add(new UpdateStatusReportPanel(JSONParser.parseLenient(arg0).isObject()));
                    }
                });
    }
}
