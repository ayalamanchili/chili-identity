/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.statusreport;

import com.axeiya.gwtckeditor.client.CKConfig;
import com.axeiya.gwtckeditor.client.CKEditor;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
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
import info.yalamanchili.office.client.admin.project.SelectProjectWidget;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.profile.cllientinfo.SelectClientInfoWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class UpdateStatusReportPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateStatusReportPanel.class.getName());

    protected CKEditor reportEditor = new CKEditor(CKConfig.full);

    public UpdateStatusReportPanel(JSONObject entity) {
        initUpdateComposite(entity, "StatusReport", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("project", entity);
        assignEntityValueFromField("clientInformation", entity);
        assignEntityValueFromField("reportStartDate", entity);
        assignEntityValueFromField("reportEndDate", entity);
        assignEntityValueFromField("status", entity);
        assignEntityValueFromField("preparedBy", entity);
        assignEntityValueFromField("approvedBy", entity);
        entity.put("report", new JSONString(reportEditor.getHTML()));
        assignEntityValueFromField("submittedDate", entity);
        assignEntityValueFromField("project", entity);
        logger.info(entity.toString());
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
        if (TabPanel.instance().homePanel.isVisible()) {
            assignFieldValueFromEntity("clientInformation", entity, null);
        }
        assignFieldValueFromEntity("project", entity, null);
        assignFieldValueFromEntity("reportStartDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("reportEndDate", entity, DataType.DATE_FIELD);
        reportEditor.setHTML(entity.get("report").isString().stringValue());
        assignFieldValueFromEntity("status", entity, DataType.ENUM_FIELD);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_RELATIONSHIP)) {
            assignFieldValueFromEntity("preparedBy", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("approvedBy", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("submittedDate", entity, DataType.DATE_FIELD);
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
        reportEditor.setHeight("350px");
        reportEditor.setWidth("100%");
        submitForApprovalF = (BooleanField) fields.get("submitForApproval");
    }

    @Override
    protected void addWidgets() {
        if (TabPanel.instance().homePanel.isVisible()) {
            addDropDown("clientInformation", new SelectClientInfoWidget(false, true));
        }
        addDropDown("project", new SelectProjectWidget(getEntityId(), false, true));
        addField("reportStartDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("reportEndDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("status", false, true, ProjectStatus.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(reportEditor);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_RELATIONSHIP)) {
            addField("preparedBy", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("approvedBy", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("submittedDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
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
