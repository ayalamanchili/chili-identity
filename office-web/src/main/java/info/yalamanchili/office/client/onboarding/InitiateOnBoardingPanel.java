/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.onboarding;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.practice.CreatePracticePanel;
import info.yalamanchili.office.client.profile.contact.Branch;
import info.yalamanchili.office.client.profile.contact.WorkStatus;
import info.yalamanchili.office.client.profile.employeetype.SelectEmployeeTypeWidget;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class InitiateOnBoardingPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreatePracticePanel.class.getName());

    public InitiateOnBoardingPanel() {
        super(CreateCompositeType.CREATE);
        initCreateComposite("InitiateOnBoarding", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("email", entity);
        assignEntityValueFromField("employeeType", entity);
        assignEntityValueFromField("company", entity);
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("branch", entity);
        assignEntityValueFromField("workStatus", entity);
        logger.info(entity.toString());
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
        new ResponseStatusWidget().show("On boarding invite sent");
        TabPanel.instance().getMyOfficePanel().entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllEmployeeOnBoardingPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("email", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addDropDown("employeeType", new SelectEmployeeTypeWidget(false, true));
        addDropDown("company", new SelectCompanyWidget(false, true, Alignment.HORIZONTAL));
        addField("startDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("branch", false, false, Branch.names(), Alignment.HORIZONTAL);
        addEnumField("workStatus", false, false, WorkStatus.names(), Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "on-board-employee/initiate-onboarding";
    }
}
