/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.advancerequisition;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.GenericPopup;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class AdvanceRequisitionSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(AdvanceRequisitionSidePanel.class.getName());
    public FlowPanel advanceRequisitionSidePanel = new FlowPanel();
    ClickableLink createAdvanceRequisitionLink = new ClickableLink("Submit Advance Requisition");

    public AdvanceRequisitionSidePanel() {
        init(advanceRequisitionSidePanel);
    }

    @Override
    protected void addListeners() {
        createAdvanceRequisitionLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        advanceRequisitionSidePanel.add(createAdvanceRequisitionLink);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createAdvanceRequisitionLink)) {
            new GenericPopup(new AdvanceRequisitionRequestPanel()).show();
        }
    }
}
