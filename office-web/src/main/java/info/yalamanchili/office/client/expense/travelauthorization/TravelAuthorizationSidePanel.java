/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.travelauthorization;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.utils.Utils;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class TravelAuthorizationSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(TravelAuthorizationSidePanel.class.getName());
    public FlowPanel travelExpenseSidePanel = new FlowPanel();
    ClickableLink createtravelExpenseLink = new ClickableLink("Submit Travel Authorization Request");

    public TravelAuthorizationSidePanel() {
        init(travelExpenseSidePanel);
    }

    @Override
    protected void addListeners() {
        createtravelExpenseLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    protected void loadEmployeeSuggestions() {
    }

    @Override
    protected void addWidgets() {
        travelExpenseSidePanel.add(createtravelExpenseLink);
        travelExpenseSidePanel.add(new SearchTravelAuthPanel());
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createtravelExpenseLink)) {
            TabPanel.instance().expensePanel.entityPanel.clear();
            TabPanel.instance().expensePanel.entityPanel.add(new CreateTravelAuthorizationPanel());
        }
    }
}
