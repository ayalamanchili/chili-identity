/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.empdoc.ReadAllEmpDocsPopupPanel;

/**
 *
 * @author radhika.mukkala
 */
public class EmployeeFormsAndDocsWidget extends ALComposite implements ClickHandler {

    protected ScrollPanel panels = new ScrollPanel();
    protected FlowPanel mainPanel1 = new FlowPanel();
    protected ClickableLink documentsL = new ClickableLink("Documents");
    protected ClickableLink ACH_NODE_L = new ClickableLink("ACH Form");

    public EmployeeFormsAndDocsWidget() {
        init(panels);
    }

    @Override
    protected void addListeners() {
        documentsL.addClickHandler(this);
        ACH_NODE_L.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        mainPanel1.add(documentsL);
        mainPanel1.add(ACH_NODE_L);
        panels.add(mainPanel1);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(documentsL)) {
            TabPanel.instance().getProfilePanel().entityPanel.clear();
            TabPanel.instance().getProfilePanel().entityPanel.add(new ReadAllEmpDocsPopupPanel(OfficeWelcome.instance().employeeId));
        }
        if (event.getSource().equals(ACH_NODE_L)) {
            TabPanel.instance().getProfilePanel().entityPanel.clear();
            TabPanel.instance().getProfilePanel().entityPanel.add(new ReadAllBankAccountPopupPanel(OfficeWelcome.instance().employeeId));
        }
    }
}

