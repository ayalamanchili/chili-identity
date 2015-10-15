/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.project.offboarding;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.cllientinfo.ClientInfoOptionsPanel;
import info.yalamanchili.office.client.profile.cllientinfo.ReadAllClientInfoPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class CreateProjectOffBoardingPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateProjectOffBoardingPanel.class.getName());

    public CreateProjectOffBoardingPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("ProjectEndDetails", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("clientName", entity);
        assignEntityValueFromField("vendorName", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("notes", entity);
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            entity.put("employeeId", new JSONString(TreeEmployeePanel.instance().getEntityId()));
        } else if (TabPanel.instance().profilePanel.isVisible()) {
            entity.put("employeeId", new JSONString(OfficeWelcome.instance().employeeId));
        }
        return entity;
    }

    @Override
    protected void createButtonClicked() {

    }

    @Override
    protected void addButtonClicked() {
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
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added Project End Details");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllClientInfoPanel(TreeEmployeePanel.instance().getEntityId()));
        TabPanel.instance().myOfficePanel.entityPanel.add(new ClientInfoOptionsPanel());

    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        addField("clientName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("vendorName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("endDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("notes", false, false, DataType.RICH_TEXT_AREA);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "clientinformation/project-off-boarding";
    }
}
