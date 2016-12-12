/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.transaction;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.TabPanel;

/**
 *
 * @author ayalamanchili
 */
public class TransactionOptionsWidget extends ALComposite implements ClickHandler {

    protected HorizontalPanel panel = new HorizontalPanel();

    protected ClickableLink addTransactionLink = new ClickableLink("Add Transaction");
    protected String path;

    public TransactionOptionsWidget(String path) {
        this.path = path;
        init(panel);
    }

    @Override
    protected void addListeners() {
        addTransactionLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        // TODO move this to common css
        panel.setSpacing(5);

    }

    @Override
    protected void addWidgets() {
        panel.add(addTransactionLink);
    }

    @Override
    public void onClick(ClickEvent clickEvent) {
        if (clickEvent.getSource().equals(addTransactionLink)) {
            TabPanel.instance().expensePanel.entityPanel.clear();
            TabPanel.instance().expensePanel.entityPanel.add(new AddTransactionPanel(path));
        }
    }
}
