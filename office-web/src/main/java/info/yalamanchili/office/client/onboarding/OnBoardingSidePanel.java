/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.onboarding;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author hemalatha.duggirala
 */
public class OnBoardingSidePanel extends ALComposite implements ClickHandler, OpenHandler {

    private static Logger logger = Logger.getLogger(OnBoardingSidePanel.class.getName());
    public FlowPanel onboardingsidepanel = new FlowPanel();
    protected Button reportsB = new Button("Reports");

    public OnBoardingSidePanel() {
        init(onboardingsidepanel);
    }

    protected void addWidgets() {
        onboardingsidepanel.add(new SearchEmployeeOnBoardingPanel());
    }

    @Override
    protected void addListeners() {
        reportsB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        TabPanel.instance().myOfficePanel.sidePanelTop.setHeight("100%");
    }

    @Override
    public void onOpen(OpenEvent event) {
    }

    @Override
    public void onClick(ClickEvent event) {
    }

}
