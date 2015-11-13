/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expensereports;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author Prasanthi.p
 */
public class ExpenseReportsSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ExpenseReportsSidePanel.class.getName());
    public FlowPanel expenseCategoryReportsSidePanel = new FlowPanel();
    ClickableLink createExpenseReportsLink = new ClickableLink("Submit Expense Report");

    public ExpenseReportsSidePanel() {
        init(expenseCategoryReportsSidePanel);
    }

    @Override
    protected void addListeners() {
        createExpenseReportsLink.addClickHandler(this);
    }
    @Override
    protected void configure() {
    }

    protected void loadEmployeeSuggestions() {
    }

    @Override
    protected void addWidgets() {
        expenseCategoryReportsSidePanel.add(createExpenseReportsLink);
        expenseCategoryReportsSidePanel.add(new SearchExpenseReportsPanel());
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createExpenseReportsLink)) {
            TabPanel.instance().expensePanel.entityPanel.clear();
            TabPanel.instance().expensePanel.entityPanel.add(new CreateExpenseReportPanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
}
