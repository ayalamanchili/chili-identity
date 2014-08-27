/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class ExpensesSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ExpensesSidePanel.class.getName());
    public FlowPanel expensesSidePanel = new FlowPanel();
    ClickableLink createExpensesLink = new ClickableLink("Create Expense");

    public ExpensesSidePanel() {
        init(expensesSidePanel);
    }

    @Override
    protected void addListeners() {
        createExpensesLink.addClickHandler(this);
    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.isHR()) {
            expensesSidePanel.add(createExpensesLink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createExpensesLink)) {
            TabPanel.instance().getExpensePanel().entityPanel.clear();
            TabPanel.instance().getExpensePanel().entityPanel.add(new CreateExpensesPanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }

}
