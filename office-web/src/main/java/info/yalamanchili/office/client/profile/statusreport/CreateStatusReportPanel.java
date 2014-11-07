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
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.Map.Entry;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class CreateStatusReportPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(info.yalamanchili.office.client.profile.statusreport.CreateStatusReportPanel.class.getName());

    protected String employeeId;

    public CreateStatusReportPanel() {
        super(CreateCompositeType.CREATE);
        initCreateComposite("StatusReport", OfficeWelcome.constants);
    }

    public CreateStatusReportPanel(String employeeId) {
        super(CreateCompositeType.CREATE);
        this.employeeId = employeeId;
        initCreateComposite("StatusReport", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
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
        entity.put("reportDocument", report);
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        logger.info(arg0.getMessage());
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postCreateSuccess(arg0);
                    }
                });
    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllStatusReportPanel(employeeId));
        }
        if (TabPanel.instance().homePanel.isVisible()) {
            TabPanel.instance().homePanel.entityPanel.clear();
            if (previewF.getValue()) {
                TabPanel.instance().homePanel.entityPanel.add(new UpdateStatusReportPanel(result.trim(), true));
            } else {
                TabPanel.instance().homePanel.entityPanel.add(new ReadAllStatusReportPanel());
            }
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
    }

    protected void formatStringFields() {
        for (Entry entry : fields.entrySet()) {
            if (entry.getValue() instanceof StringField) {
                StringField textAreaField = (StringField) entry.getValue();
                textAreaField.setBackgroundText();
            }
        }
    }

    protected void formatTextAreaFields() {
        for (Entry entry : fields.entrySet()) {
            if (entry.getValue() instanceof TextAreaField) {
                TextAreaField textAreaField = (TextAreaField) entry.getValue();
                textAreaField.setBackgroundText();
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
        entityFieldsPanel.add(getLineSeperatorTag("Status, Accomplishments and Scheduled Activities"));

        addField("statusDescription", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("accomplishments", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("scheduledActivities", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR, ROLE.ROLE_RELATIONSHIP)) {
            addField("preparedBy", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("approvedBy", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("submittedDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        }
        entityFieldsPanel.add(getLineSeperatorTag("Select this option if you are ready to submit this for HR Approval."));
        addField("preview", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("submitForApproval", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {

    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        return true;
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
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "statusreport/save?submitForApproval=" + submitForApprovalF.getValue();
    }
}
