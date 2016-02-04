/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.onboarding;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.emergencycnt.ReadAllDependentsPanel;
import info.yalamanchili.office.client.profile.employee.DependentOptionsPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class CreateDependentsPanel extends CreateComposite implements ClickHandler {

    private Logger logger = Logger.getLogger(CreateDependentsPanel.class.getName());
    ClickableLink deleteB = new ClickableLink("Remove Dependent");
    EmployeeOnboardingPanel parentPanel;
    private int index;

    public CreateDependentsPanel(EmployeeOnboardingPanel parent, int idx) {
        super(CreateComposite.CreateCompositeType.CREATE);
        initCreateComposite("Dependent", OfficeWelcome.constants);
        this.index = idx;
        this.parentPanel = parent;
    }

    public CreateDependentsPanel(CreateCompositeType type) {
        super(type);
        initCreateComposite("Dependent", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        entity = new JSONObject();
        assignEntityValueFromField("dfirstName", entity);
        assignEntityValueFromField("dlastName", entity);
        assignEntityValueFromField("ddateOfBirth", entity);
        assignEntityValueFromField("relationship", entity);
        entity.put("targetEntityName", new JSONString("targetEntityName"));
        entity.put("targetEntityId", new JSONString("0"));
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
        new ResponseStatusWidget().show("Successfully Added Dependent");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllDependentsPanel(
                TreeEmployeePanel.instance().getEntityId()));
        TabPanel.instance().myOfficePanel.entityPanel.add(new DependentOptionsPanel());
    }

    @Override
    protected void addListeners() {
        deleteB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        create.setVisible(false);
    }

    @Override
    protected void addWidgets() {
        addField("dfirstName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dlastName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("ddateOfBirth", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("relationship", false, true, Relationship.names(), Alignment.HORIZONTAL);
        alignFields();
        entityActionsPanel.add(deleteB);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {

    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/dependent/"
                + TreeEmployeePanel.instance().getEntityId();
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(deleteB)) {
            parentPanel.removePanel(index);
        }
        super.onClick(event);
    }
}
