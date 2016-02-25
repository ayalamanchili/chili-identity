/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expensecategory;

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
 * @author Prashanthi
 */
public class ExpenseCategorySidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ExpenseCategorySidePanel.class.getName());
    public FlowPanel expenseCategorySidePanel = new FlowPanel();

    public ExpenseCategorySidePanel() {
        init(expenseCategorySidePanel);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.isHR()) {
        }
    }

    @Override
    public void onClick(ClickEvent clickEvent) {
    }
}