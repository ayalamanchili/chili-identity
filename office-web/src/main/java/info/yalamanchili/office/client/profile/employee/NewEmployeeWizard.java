/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.employee;

import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.crud.CreateComposite.CreateCompositeType;
import info.yalamanchili.office.client.profile.address.CreateAddressPanel;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class NewEmployeeWizard extends ALComposite implements ClickHandler {

    FlowPanel panel = new FlowPanel();

    FlowPanel entityPanel = new FlowPanel();
    HorizontalPanel optionsPanel = new HorizontalPanel();

    /* Wizard Panels */
    CreateEmployeePanel createEmployeePanel;

    CreateAddressPanel createAddressPanel;

    // Options
    Button saveAndExitB = new Button("Save & Exit");

    Button skipB = new Button("Skip & Continue");

    Button saveAndContinueB = new Button("Save & Continue");

    public NewEmployeeWizard() {
        init(panel);
        stepCreateEmployee();
    }

    protected void stepCreateEmployee() {
        skipB.setVisible(false);
        createEmployeePanel = new CreateEmployeePanel(CreateCompositeType.CREATE);
        entityPanel.add(createEmployeePanel);
        createEmployeePanel.create.setVisible(false);
    }

    @Override
    protected void addListeners() {
        saveAndExitB.addClickHandler(this);
        skipB.addClickHandler(this);
        saveAndContinueB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        panel.add(entityPanel);
        panel.add(optionsPanel);
    }

    @Override
    protected void addWidgets() {
        optionsPanel.add(saveAndExitB);
        optionsPanel.add(skipB);
        optionsPanel.add(saveAndContinueB);
    }

    @Override
    public void onClick(ClickEvent clickEvent) {
        if (clickEvent.getSource().equals(saveAndContinueB)) {
            createEmployeePanel.createButtonClicked();
        }
    }

}
