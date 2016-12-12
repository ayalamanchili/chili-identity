/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.statusreport;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Frame;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.home.tasks.ReadAllTasks;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class UpdateStatusReportPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateStatusReportPanel.class.getName());
    protected boolean showPreview;

    public UpdateStatusReportPanel(String id, Boolean preview) {
        showPreview = preview;
        initUpdateComposite(id, "StatusReport", OfficeWelcome.constants);
    }

    public UpdateStatusReportPanel(String id) {
        initUpdateComposite(id, "StatusReport", OfficeWelcome.constants);
    }

    public UpdateStatusReportPanel(JSONObject entity) {
        initUpdateComposite(entity, "StatusReport", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        logger.info(response);
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);

                    }
                });
        if (showPreview) {
            showPreview();
        }
    }

    protected void showPreview() {
        Frame f = new Frame(ChiliClientConfig.instance().getFileDownloadUrl() + "statusreport/report" + "&passthrough=true" + "&id=" + entityId);
        f.setHeight("35em");
        f.setWidth("50em");
        new GenericPopup(f).show();
    }

    protected String getReadURI() {
        return OfficeWelcome.constants.root_url() + "statusreport/" + entityId;
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject report = new JSONObject();
        assignEntityValueFromField("projectDescription", report);
        assignEntityValueFromField("reportStartDate", entity);
        assignEntityValueFromField("reportEndDate", entity);
        assignEntityValueFromField("status", entity);

        assignEntityValueFromField("projectPhase1Name", report);
        assignEntityValueFromField("projectPhase1Deliverable", report);
        assignEntityValueFromField("projectPhase1EndDate", report);
        assignEntityValueFromField("projectPhase1Status", report);

        assignEntityValueFromField("projectPhase2Name", report);
        assignEntityValueFromField("projectPhase2Deliverable", report);
        assignEntityValueFromField("projectPhase2EndDate", report);
        assignEntityValueFromField("projectPhase2Status", report);

        assignEntityValueFromField("projectPhase3Name", report);
        assignEntityValueFromField("projectPhase3Deliverable", report);
        assignEntityValueFromField("projectPhase3EndDate", report);
        assignEntityValueFromField("projectPhase3Status", report);

        assignEntityValueFromField("projectPhase4Name", report);
        assignEntityValueFromField("projectPhase4Deliverable", report);
        assignEntityValueFromField("projectPhase4EndDate", report);
        assignEntityValueFromField("projectPhase4Status", report);

        assignEntityValueFromField("statusDescription", report);
        assignEntityValueFromField("accomplishments", report);
        assignEntityValueFromField("scheduledActivities", report);

        assignEntityValueFromField("preparedBy", entity);
        assignEntityValueFromField("approvedBy", entity);
        assignEntityValueFromField("submittedDate", entity);
        assignEntityValueFromField("approvedDate", entity);
        entity.put("reportDocument", report);
        logger.info("Dddddd" + entity);
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

    protected void populateComments() {
        if (getEntityId() != null && !getEntityId().isEmpty()) {
            entityActionsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.employee.statusreport.StatusReport"));
        }
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        if (entity.get("reportDocument") != null) {
            JSONObject reportDocument = entity.get("reportDocument").isObject();
            if (entity.get("employee") != null) {
                assignFieldValueFromEntity("jobTitle", entity.get("employee").isObject(), DataType.STRING_FIELD);
            }
            assignFieldValueFromEntity("projectDescription", reportDocument, DataType.TEXT_AREA_FIELD);
            assignFieldValueFromEntity("reportStartDate", entity, DataType.DATE_FIELD);
            assignFieldValueFromEntity("reportEndDate", entity, DataType.DATE_FIELD);
            assignFieldValueFromEntity("status", entity, DataType.ENUM_FIELD);

            assignFieldValueFromEntity("projectPhase1Name", reportDocument, DataType.STRING_FIELD);
            assignFieldValueFromEntity("projectPhase1Deliverable", reportDocument, DataType.STRING_FIELD);
            assignFieldValueFromEntity("projectPhase1EndDate", reportDocument, DataType.STRING_FIELD);
            assignFieldValueFromEntity("projectPhase1Status", reportDocument, DataType.STRING_FIELD);

            assignFieldValueFromEntity("projectPhase2Name", reportDocument, DataType.STRING_FIELD);
            assignFieldValueFromEntity("projectPhase2Deliverable", reportDocument, DataType.STRING_FIELD);
            assignFieldValueFromEntity("projectPhase2EndDate", reportDocument, DataType.STRING_FIELD);
            assignFieldValueFromEntity("projectPhase2Status", reportDocument, DataType.STRING_FIELD);

            assignFieldValueFromEntity("projectPhase3Name", reportDocument, DataType.STRING_FIELD);
            assignFieldValueFromEntity("projectPhase3Deliverable", reportDocument, DataType.STRING_FIELD);
            assignFieldValueFromEntity("projectPhase3EndDate", reportDocument, DataType.STRING_FIELD);
            assignFieldValueFromEntity("projectPhase3Status", reportDocument, DataType.STRING_FIELD);

            assignFieldValueFromEntity("projectPhase4Name", reportDocument, DataType.STRING_FIELD);
            assignFieldValueFromEntity("projectPhase4Deliverable", reportDocument, DataType.STRING_FIELD);
            assignFieldValueFromEntity("projectPhase4EndDate", reportDocument, DataType.STRING_FIELD);
            assignFieldValueFromEntity("projectPhase4Status", reportDocument, DataType.STRING_FIELD);

            assignFieldValueFromEntity("statusDescription", reportDocument, DataType.TEXT_AREA_FIELD);
            assignFieldValueFromEntity("accomplishments", reportDocument, DataType.TEXT_AREA_FIELD);
            assignFieldValueFromEntity("scheduledActivities", reportDocument, DataType.TEXT_AREA_FIELD);

            if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_RELATIONSHIP)) {
                assignFieldValueFromEntity("preparedBy", entity, DataType.STRING_FIELD);
                assignFieldValueFromEntity("approvedBy", entity, DataType.STRING_FIELD);
                assignFieldValueFromEntity("submittedDate", entity, DataType.DATE_FIELD);
                assignFieldValueFromEntity("approvedDate", entity, DataType.DATE_FIELD);
            }
            populateComments();
        }
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Status Report Information");
        if (TabPanel.instance().homePanel.isVisible()) {
            TabPanel.instance().homePanel.entityPanel.clear();
            if (previewF.getValue()) {
                TabPanel.instance().homePanel.entityPanel.add(new UpdateStatusReportPanel(result.trim(), true));
            } else {
                TabPanel.instance().homePanel.entityPanel.add(new ReadAllStatusReportPanel());
            }
        }
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllStatusReportPanel(TreeEmployeePanel.instance().getEntityId()));
        }

    }

    @Override
    protected void addListeners() {
        submitForApprovalF.getBox().addClickHandler(this);
        previewF.getBox().addClickHandler(this);
    }

    BooleanField submitForApprovalF;
    BooleanField previewF;

    @Override
    protected void configure() {
        formatTextAreaFields();
        formatStringFields();
        submitForApprovalF = (BooleanField) fields.get("submitForApproval");
        previewF = (BooleanField) fields.get("preview");
        StringField p1 = (StringField) fields.get("projectPhase1Deliverable");
        p1.getTextbox().setVisibleLength(90);
        StringField p2 = (StringField) fields.get("projectPhase2Deliverable");
        p2.getTextbox().setVisibleLength(90);
        StringField p3 = (StringField) fields.get("projectPhase3Deliverable");
        p3.getTextbox().setVisibleLength(90);
        StringField p4 = (StringField) fields.get("projectPhase4Deliverable");
        p4.getTextbox().setVisibleLength(90);
        if (getEntityId().isEmpty()) {
            update.setText("Create");
        }
    }

    protected void formatStringFields() {
        for (Map.Entry entry : fields.entrySet()) {
            if (entry.getValue() instanceof StringField) {
                StringField textAreaField = (StringField) entry.getValue();
            }
        }
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
        addField("projectDescription", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("reportStartDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("reportEndDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("status", false, true, ProjectStatus.names(), Alignment.HORIZONTAL);

        entityFieldsPanel.add(getLineSeperatorTag("Project Phase 1"));
        addField("projectPhase1Name", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase1Deliverable", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase1EndDate", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase1Status", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Project Phase 2"));
        addField("projectPhase2Name", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase2Deliverable", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase2EndDate", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase2Status", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Project Phase 3"));
        addField("projectPhase3Name", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase3Deliverable", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase3EndDate", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase3Status", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Project Phase 4"));
        addField("projectPhase4Name", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase4Deliverable", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase4EndDate", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("projectPhase4Status", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);

        addField("statusDescription", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("accomplishments", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("scheduledActivities", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_RELATIONSHIP)) {
            if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONSULTANT_TIME_ADMIN)) {
                addField("preparedBy", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
                addField("approvedBy", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            } else {
                addField("preparedBy", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
                addField("approvedBy", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            }
            addField("submittedDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
            addField("approvedDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        }
        entityFieldsPanel.add(getLineSeperatorTag("Select this option if you are ready to submit this for HR approval."));
        addField("preview", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("submitForApproval", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        boolean valid = true;
        boolean focus = true;
        TextAreaField projectDescriptionF = (TextAreaField) fields.get("projectDescription");
        if (numberOfLines(projectDescriptionF) > 5) {
            projectDescriptionF.setMessage("Cannot exceed more than 5 lines");
            valid = false;
            if (focus) {
                projectDescriptionF.focus(focus);
            }
            focus = false;
        }
        TextAreaField statusDescriptionF = (TextAreaField) fields.get("statusDescription");
        if (numberOfLines(statusDescriptionF) > 5) {
            statusDescriptionF.setMessage("Cannot exceed more than 5 lines");
            valid = false;
            if (focus) {
                statusDescriptionF.focus(focus);
            }
            focus = false;
        }
        TextAreaField accomplishmentsF = (TextAreaField) fields.get("accomplishments");
        if (numberOfLines(accomplishmentsF) > 5) {
            accomplishmentsF.setMessage("Cannot exceed more than 5 lines");
            valid = false;
            if (focus) {
                accomplishmentsF.focus(focus);
            }
            focus = false;
        }

        TextAreaField scheduledActivitiesF = (TextAreaField) fields.get("scheduledActivities");
        if (numberOfLines(scheduledActivitiesF) > 5) {
            scheduledActivitiesF.setMessage("Cannot exceed more than 5 lines");
            valid = false;
            if (focus) {
                scheduledActivitiesF.focus(focus);
            }
        }
        return valid;
    }

    protected int numberOfLines(TextAreaField textArea) {
        String[] lines = textArea.getTextbox().getText().split("\r\n|\r|\n");
        return lines.length;

    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "statusreport/save?submitForApproval=" + submitForApprovalF.getValue();
    }

    @Override
    public void onClick(ClickEvent event) {
        if (previewF.getValue() && submitForApprovalF.getValue()) {
            setButtonText("Submit and Preview");
        } else if (previewF.getValue()) {
            setButtonText("Save and Preview");
        } else if (submitForApprovalF.getValue()) {
            setButtonText("Save and Submit");
        } else {
            setButtonText("Save");
        }
        super.onClick(event);
    }

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_RELATIONSHIP);
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.employee.statusreport.StatusReport" + "/" + getEntityId();
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
}
