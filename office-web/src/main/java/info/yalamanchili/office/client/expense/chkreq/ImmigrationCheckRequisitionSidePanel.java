/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.chkreq;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.expense.travelauthorization.TravelAuthorizationSidePanel;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ImmigrationCheckRequisitionSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(TravelAuthorizationSidePanel.class.getName());
    public FlowPanel checkRequisitionSidePanel = new FlowPanel();

    public ImmigrationCheckRequisitionSidePanel() {
        init(checkRequisitionSidePanel);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    protected void loadEmployeeSuggestions() {
    }

    @Override
    protected void addWidgets() {
        checkRequisitionSidePanel.add(new SearchCheckRequisitionpanel());
    }

    @Override
    public void onClick(ClickEvent event) {
    }
}
