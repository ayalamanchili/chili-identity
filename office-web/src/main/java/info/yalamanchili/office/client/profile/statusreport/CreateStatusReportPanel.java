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
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.project.SelectProjectWidget;
import info.yalamanchili.office.client.gwt.InformationWidget;
import info.yalamanchili.office.client.profile.cllientinfo.SelectClientInfoWidget;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class CreateStatusReportPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(info.yalamanchili.office.client.profile.statusreport.CreateStatusReportPanel.class.getName());

    protected Anchor missingInfoL = new Anchor("Client or Project not present?");
    protected CKEditor reportEditor = new CKEditor(CKConfig.full);

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
        JSONObject status = new JSONObject();
        assignEntityValueFromField("reportStartDate", status);
        assignEntityValueFromField("reportEndDate", status);
        assignEntityValueFromField("status", status);
        assignEntityValueFromField("preparedBy", status);
        assignEntityValueFromField("approvedBy", status);
        status.put("report", new JSONString(reportEditor.getHTML()));
        assignEntityValueFromField("submittedDate", status);
        assignEntityValueFromField("project", status);
        assignEntityValueFromField("clientInformation", status);
        return status;
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
            TabPanel.instance().homePanel.entityPanel.add(new ReadAllStatusReportPanel());
        }

    }

    @Override
    protected void addListeners() {
        missingInfoL.addClickHandler(this);
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
        if (employeeId != null) {
            addDropDown("clientInformation", new SelectClientInfoWidget(employeeId, false, true));
        } else {
            addDropDown("clientInformation", new SelectClientInfoWidget(false, true));
        }
        addDropDown("project", new SelectProjectWidget(false, true));
        entityFieldsPanel.add(missingInfoL);
        addField("reportStartDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("reportEndDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("status", false, true, ProjectStatus.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(reportEditor);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR, ROLE.ROLE_RELATIONSHIP)) {
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
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(missingInfoL)) {
            new GenericPopup(new InformationWidget("Please submit a <b>Service Ticket</b> under </br><b>Home-->Self Service-->Open Ticket with Type='Other'</b> and </br>enter the details of missing information. </br>eg: I am trying to submit my project status report and dont see my client and project inforation available. </br>You will get a email notification once the information is ready so you can go back to submit the status report.")).show();
        }
        super.onClick(event);
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "statusreport/save?submitForApproval=" + submitForApprovalF.getValue();
    }
}
