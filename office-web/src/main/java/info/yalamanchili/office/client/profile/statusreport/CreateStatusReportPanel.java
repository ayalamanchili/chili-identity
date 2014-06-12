/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.statusreport;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.project.SelectProjectWidget;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class CreateStatusReportPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(info.yalamanchili.office.client.profile.statusreport.CreateStatusReportPanel.class.getName());

    public CreateStatusReportPanel(CreateComposite.CreateCompositeType type) {
        super(type);
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
        assignEntityValueFromField("report", status);
        assignEntityValueFromField("submittedDate", status);
        assignEntityValueFromField("project", status);
        assignEntityValueFromField("clientInformation", status);
        logger.info(status.toString());
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
        new ResponseStatusWidget().show("Successfully Status Report Created");
        TabPanel.instance().myOfficePanel.sidePanelTop.clear();
        TabPanel.instance().myOfficePanel.sidePanelTop.add(new StatusReportSidePanel());
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllStatusReportPanel());
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
        addField("status", false, false, DataType.STRING_FIELD);
        addField("preparedBy", false, true, DataType.STRING_FIELD);
        addField("approvedBy", false, true, DataType.STRING_FIELD);
        addField("report", false, false, DataType.STRING_FIELD);
        addField("submittedDate", false, true, DataType.DATE_FIELD);
        addDropDown("project", new SelectProjectWidget(false, true));
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        String projectId = null;
        SelectProjectWidget projectT = (SelectProjectWidget) fields.get("project");
        projectId = JSONUtils.toString(projectT.getSelectedObject(), "id");
        return OfficeWelcome.constants.root_url() + "project/statusreport/" + projectId;
    }
}
