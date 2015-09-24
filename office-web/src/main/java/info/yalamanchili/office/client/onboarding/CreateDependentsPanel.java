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
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.OfficeWelcome;
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

    }

    @Override
    protected void postCreateSuccess(String result) {

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
        addField("dlastName", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
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
        return "";
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(deleteB)) {
            parentPanel.removePanel(index);
        }
        super.onClick(event);
    }
}
