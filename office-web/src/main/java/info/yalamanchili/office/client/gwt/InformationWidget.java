/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.gwt;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.composite.ALComposite;

/**
 *
 * @author ayalamanchili
 */
public class InformationWidget extends ALComposite {

    protected FlowPanel panel = new FlowPanel();
    protected HTML html = new HTML();
    protected String information;

    public InformationWidget(String information) {
        this.information = information;
        init(panel);
        html.setHTML(information);
    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        panel.add(html);
    }

}
