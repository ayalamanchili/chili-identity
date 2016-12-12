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
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.utils.Utils;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Ramana.Lukalapu
 */
public class OutOfOfficeSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(OutOfOfficeSidePanel.class.getName());
    public FlowPanel outOfOfficeSidePanel = new FlowPanel();
    
    public OutOfOfficeSidePanel() {
        init(outOfOfficeSidePanel);
    }

    @Override
    protected void addListeners() {}

    @Override
    protected void configure() {}

    @Override
    protected void addWidgets() {
        outOfOfficeSidePanel.add(new SearchOutOfOfficePanel());
    }

    @Override
    public void onClick(ClickEvent event) {}
}
