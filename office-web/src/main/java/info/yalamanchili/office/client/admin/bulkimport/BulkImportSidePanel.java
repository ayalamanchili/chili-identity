/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
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
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class BulkImportSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(BulkImportSidePanel.class.getName());
    public FlowPanel panel = new FlowPanel();
    ClickableLink createBulkImportL = new ClickableLink("Create BulkImport");

    public BulkImportSidePanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        createBulkImportL.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.isPayroll()) {
            panel.add(createBulkImportL);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createBulkImportL)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new CreateBulkImportPanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
}
