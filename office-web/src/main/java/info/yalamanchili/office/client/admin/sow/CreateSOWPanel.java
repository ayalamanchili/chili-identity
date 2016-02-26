/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.sow;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.admin.project.SelectProjectWidget;
import java.util.logging.Logger;

/**
 *
 * @author Yogi
 */
public class CreateSOWPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(info.yalamanchili.office.client.admin.sow.CreateSOWPanel.class.getName());

    public CreateSOWPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("StatementOfWork", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject sow = new JSONObject();
        assignEntityValueFromField("name", sow);
        assignEntityValueFromField("description", sow);
        assignEntityValueFromField("startDate", sow);
        assignEntityValueFromField("endDate", sow);
        assignEntityValueFromField("billRate", sow);
        assignEntityValueFromField("project", sow);
        logger.info(sow.toString());
        return sow;
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
        new ResponseStatusWidget().show("Successfully SOW Created");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllSOWPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("name", false, true, DataType.STRING_FIELD);
        addField("description", false, false, DataType.STRING_FIELD);
        addField("startDate", false, true, DataType.DATE_FIELD);
        addField("endDate", false, true, DataType.DATE_FIELD);
        addField("billRate", false, false, DataType.CURRENCY_FIELD);
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

        return OfficeWelcome.constants.root_url() + "project/sow/" + projectId;
    }
}
