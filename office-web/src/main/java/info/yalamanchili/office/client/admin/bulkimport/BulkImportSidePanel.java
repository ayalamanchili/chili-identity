/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.bulkimport;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class BulkImportSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(BulkImportSidePanel.class.getName());
    public FlowPanel panel = new FlowPanel();

    public BulkImportSidePanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
    }

    @Override
    public void onClick(ClickEvent event) {

    }
}
