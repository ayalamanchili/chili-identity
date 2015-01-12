/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.audit;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;

/**
 *
 * @author anuyalamanchili
 */
public class AuditStackPanelWidget extends ALComposite implements ClickHandler {

    protected ScrollPanel panel = new ScrollPanel();
    protected FlowPanel mainPanel = new FlowPanel();
    protected ClickableLink loginActivityL = new ClickableLink("Login Activity");

    public AuditStackPanelWidget() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        loginActivityL.addClickHandler(this);

    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        mainPanel.add(loginActivityL);

        panel.add(mainPanel);
    }

    @Override
    public void onClick(ClickEvent event) {
    }
}
