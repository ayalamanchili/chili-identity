/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.gwt;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import info.chili.gwt.composite.ALComposite;

/**
 *
 * @author ayalamanchili
 */
public class ReportsWidget extends ALComposite {

    protected DisclosurePanel reportsDP = new DisclosurePanel("Reports");
    protected FlowPanel reportsPanel = new FlowPanel();
    protected Button generateRepB = new Button("Generate");
    protected Label formatL = new Label("Format");
    protected ListBox formatLB = new ListBox();

    protected ClickHandler parent;

    public ReportsWidget(ClickHandler parent) {
        this.parent = parent;
        init(reportsDP);
    }

    @Override
    protected void addListeners() {
        generateRepB.addClickHandler(parent);
    }

    @Override
    protected void configure() {
        generateRepB.addClickHandler(parent);
        reportsDP.setVisible(false);
    }

    @Override
    protected void addWidgets() {
        reportsPanel.add(formatL);
        formatLB.addItem("PDF", "pdf");
        formatLB.addItem("HTML", "html");
        formatLB.addItem("XML", "xml");
        formatLB.addItem("EXCEL", "xls");
        reportsPanel.add(formatLB);
        reportsPanel.add(generateRepB);
        reportsDP.setContent(reportsPanel);
    }

    public void setVisible(boolean visible) {
        reportsDP.setVisible(visible);
    }

    public String getReportFormat() {
        return formatLB.getValue(formatLB.getSelectedIndex());
    }

    public Button getGenerateReportButton() {
        return generateRepB;
    }
}
