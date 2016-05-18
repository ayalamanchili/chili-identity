/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.time.corp.CorporateTimeSummarySidePanel;
import java.util.logging.Logger;

/**
 *
 * @author Ramana.Lukalapu
 */
public class OutOfOfficeSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(CorporateTimeSummarySidePanel.class.getName());
    public FlowPanel workFormHomeSidePanel = new FlowPanel();
    ClickableLink submitRequest = new ClickableLink("Submit request for OutOf Office Work Type ");

    public OutOfOfficeSidePanel() {
        init(workFormHomeSidePanel);
    }

    @Override
    protected void addListeners() {
        submitRequest.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        workFormHomeSidePanel.add(submitRequest);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(submitRequest)) {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            TabPanel.instance().getTimePanel().entityPanel.add(new CreateOutOffOfficeRequestPanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
}
