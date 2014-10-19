/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.statusreport;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class UpdateStatusReportPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateStatusReportPanel.class.getName());

    public UpdateStatusReportPanel(JSONObject entity) {
        initUpdateComposite(entity, "StatusReport", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("projectDescription", entity);
        assignEntityValueFromField("reportStartDate", entity);
        assignEntityValueFromField("reportEndDate", entity);
        assignEntityValueFromField("status", entity);

        assignEntityValueFromField("projectPhase1Name", entity);
        assignEntityValueFromField("projectPhase1Deliverable", entity);
        assignEntityValueFromField("projectPhase1EndDate", entity);
        assignEntityValueFromField("projectPhase1Status", entity);

        assignEntityValueFromField("projectPhase2Name", entity);
        assignEntityValueFromField("projectPhase2Deliverable", entity);
        assignEntityValueFromField("projectPhase2EndDate", entity);
        assignEntityValueFromField("projectPhase2Status", entity);

        assignEntityValueFromField("projectPhase3Name", entity);
        assignEntityValueFromField("projectPhase3Deliverable", entity);
        assignEntityValueFromField("projectPhase3EndDate", entity);
        assignEntityValueFromField("projectPhase3Status", entity);

        assignEntityValueFromField("projectPhase4Name", entity);
        assignEntityValueFromField("projectPhase4Deliverable", entity);
        assignEntityValueFromField("projectPhase4EndDate", entity);
        assignEntityValueFromField("projectPhase4Status", entity);

        assignEntityValueFromField("statusDescription", entity);
        assignEntityValueFromField("accomplishments", entity);
        assignEntityValueFromField("scheduledActivities", entity);

        assignEntityValueFromField("preparedBy", entity);
        assignEntityValueFromField("approvedBy", entity);
        assignEntityValueFromField("submittedDate", entity);
        assignEntityValueFromField("approvedDate", entity);
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
        entityActionsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.client.StatusReport"));
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
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Status Report Information");
        if (TabPanel.instance().homePanel.isVisible()) {
            TabPanel.instance().homePanel.entityPanel.clear();
            TabPanel.instance().homePanel.entityPanel.add(new ReadAllStatusReportPanel());
        }
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllStatusReportPanel(TreeEmployeePanel.instance().getEntityId()));
        }

    }

    @Override
    protected void addListeners() {
    }

    BooleanField submitForApprovalF;

    @Override
    protected void configure() {
        submitForApprovalF = (BooleanField) fields.get("submitForApproval");
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
        entityFieldsPanel.add(getLineSeperatorTag("Select this option if you are ready to submit this for approval Engagement Manager."));
        addField("submitForApproval", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "statusreport/save?submitForApproval=" + submitForApprovalF.getValue();
    }
}
