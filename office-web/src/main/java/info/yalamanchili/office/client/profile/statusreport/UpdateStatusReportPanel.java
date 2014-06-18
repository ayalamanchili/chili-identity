/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.statusreport;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.project.SelectProjectWidget;
import info.yalamanchili.office.client.profile.cllientinfo.SelectClientInfoWidget;
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
        JSONObject status = new JSONObject();
        assignEntityValueFromField("reportStartDate", status);
        assignEntityValueFromField("reportEndDate", status);
        assignEntityValueFromField("status", status);
        assignEntityValueFromField("preparedBy", status);
        assignEntityValueFromField("approvedBy", status);
        assignEntityValueFromField("report", status);
        assignEntityValueFromField("submittedDate", status);
        assignEntityValueFromField("project", status);
//        assignEntityValueFromField("clientInformation", status);
        logger.info(status.toString());
        return status;
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

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("reportStartDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("reportEndDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("status", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("preparedBy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("approvedBy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("report", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("submittedDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("project", entity, null);
//        assignFieldValueFromEntity("clientInformation", entity, null);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Status Report Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllStatusReportPanel(TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("reportStartDate", false, true, DataType.DATE_FIELD);
        addField("reportEndDate", false, true, DataType.DATE_FIELD);
        addEnumField("status", false, true, ProjectStatus.names());
        addField("preparedBy", false, false, DataType.STRING_FIELD);
        addField("approvedBy", false, false, DataType.STRING_FIELD);
        addField("report", false, true, DataType.RICH_TEXT_AREA);
        addField("submittedDate", false, false, DataType.DATE_FIELD);
        addDropDown("project", new SelectProjectWidget(false, true));
//        addDropDown("clientInformation", new SelectClientInfoWidget(false, true));
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "statusreport";
    }
}
