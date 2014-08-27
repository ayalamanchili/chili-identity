/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.transaction;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class TransactionSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(TransactionSidePanel.class.getName());
    public FlowPanel transactionSidePanel = new FlowPanel();
    ClickableLink createTransactionLink = new ClickableLink("Create Transaction");

    public TransactionSidePanel() {
        init(transactionSidePanel);
    }

    @Override
    protected void addListeners() {
        createTransactionLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.isHR()) {
            transactionSidePanel.add(createTransactionLink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createTransactionLink)) {
            TabPanel.instance().getExpensePanel().entityPanel.clear();
//            TabPanel.instance().getExpensePanel().entityPanel.add(new CreateTransactionPanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
}
