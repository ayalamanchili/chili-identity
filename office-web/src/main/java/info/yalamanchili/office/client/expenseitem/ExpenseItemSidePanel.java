/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expenseitem;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author Prasanthi.p
 */
public class ExpenseItemSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ExpenseItemSidePanel.class.getName());
    public FlowPanel expenseCategoryItemSidePanel = new FlowPanel();
    ClickableLink createExpenseItemLink = new ClickableLink("Create Expense Item");

    public ExpenseItemSidePanel() {
        init(expenseCategoryItemSidePanel);
    }

    @Override
    protected void addListeners() {
        createExpenseItemLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.isHR()) {
            expenseCategoryItemSidePanel.add(createExpenseItemLink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createExpenseItemLink)) {
            TabPanel.instance().getExpensePanel().entityPanel.clear();
            TabPanel.instance().getExpensePanel().entityPanel.add(new CreateExpenseItemPanel());
        }
    }
}
