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
import info.yalamanchili.office.client.profile.contact.Salutation;
import info.yalamanchili.office.client.profile.contact.Sex;
import info.yalamanchili.office.client.profile.emergencycnt.ReadAllDependentsPanel;
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
    protected String targetClassName;
    protected String parentId;
    protected boolean isShowAllRelationships = false;

    public CreateDependentsPanel(EmployeeOnboardingPanel parent, int idx) {
        super(CreateComposite.CreateCompositeType.CREATE);
        initCreateComposite("Dependent", OfficeWelcome.constants2);
        this.index = idx;
        this.parentPanel = parent;
    }

    public CreateDependentsPanel(EmployeeOnboardingPanel parent, int idx, boolean isShowAllRelationships) {
        super(CreateComposite.CreateCompositeType.CREATE);
        initCreateComposite("Dependent", OfficeWelcome.constants2);
        this.index = idx;
        this.parentPanel = parent;
        this.isShowAllRelationships = isShowAllRelationships;
    }

    public CreateDependentsPanel(CreateCompositeType type) {
        super(type);
        initCreateComposite("Dependent", OfficeWelcome.constants2);
        this.isShowAllRelationships = isShowAllRelationships;
    }

    public CreateDependentsPanel(CreateCompositeType type, String parentId, String targetClassName) {
        super(type);
        this.targetClassName = targetClassName;
        this.parentId = parentId;
        this.isShowAllRelationships = isShowAllRelationships;
        initCreateComposite("Dependent", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        if (deleteB.isVisible() == false) {
            create.setVisible(true);
            entityActionsPanel.remove(deleteB);
        } else {
            create.setVisible(false);
            entityActionsPanel.add(deleteB);
        }
        entity = new JSONObject();
        assignEntityValueFromField("salutation", entity);
        assignEntityValueFromField("dfirstName", entity);
        assignEntityValueFromField("dmiddleName", entity);
        assignEntityValueFromField("dlastName", entity);
        assignEntityValueFromField("ddateOfBirth", entity);
        assignEntityValueFromField("relationship", entity);
        assignEntityValueFromField("gender", entity);
        assignEntityValueFromField("email", entity);
        assignEntityValueFromField("phoneNumber", entity);
        entity.put("targetEntityName", new JSONString("targetEntityName"));
        entity.put("targetEntityId", new JSONString("0"));
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        deleteB.setVisible(false);
        create.setVisible(true);
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
        new ResponseStatusWidget().show("Successfully Added Dependent");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllDependentsPanel(
                TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    protected void addListeners() {
        deleteB.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addEnumField("salutation", false, false, Salutation.names(), Alignment.HORIZONTAL);
        addField("dfirstName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dmiddleName", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dlastName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("ddateOfBirth", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        if (isShowAllRelationships == false) {
            addEnumField("relationship", false, true, Relationship.getRelationsForDepenents(), Alignment.HORIZONTAL);
        } else {
            addEnumField("relationship", false, true, Relationship.names(), Alignment.HORIZONTAL);
        }
        addEnumField("gender", false, false, Sex.names(), Alignment.HORIZONTAL);
        addField("email", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("phoneNumber", false, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        alignFields();
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
