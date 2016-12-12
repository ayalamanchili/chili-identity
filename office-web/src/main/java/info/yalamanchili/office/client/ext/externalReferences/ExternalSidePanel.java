/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.ext.externalReferences;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import java.util.logging.Logger;

/**
 *
 * @author Ramana.Lukalapu
 */
public class ExternalSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ExternalSidePanel.class.getName());
    public FlowPanel refsidepanel = new FlowPanel();

    public ExternalSidePanel() {
        init(refsidepanel);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        refsidepanel.add(new SearchExternalRefPanel());
    }

    @Override
    public void onClick(ClickEvent event) {
    }
}
