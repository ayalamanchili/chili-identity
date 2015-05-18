/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.benefits;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author ayalamanchili
 */
public final class RetirementPlanReadPanel extends ALComposite {
    
    protected FlowPanel panel = new FlowPanel();
    
    protected CaptionPanel mainPanel = new CaptionPanel();
    
    public RetirementPlanReadPanel() {
        init(mainPanel);
        loadContent();
    }
    
    protected void loadContent() {
        HttpService.HttpServiceAsync.instance().doGet(getBenifitsURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        if (arg0 == null || arg0.equals("null")) {
                            panel.add(new RetirementPlanOptInPanel());
                        } else {
                            JSONObject retirementPlan = (JSONObject) JSONParser.parseLenient(arg0);
                            if (JSONUtils.toString(retirementPlan, "optIn").equals("true")) {
                                panel.add(new RetirementPlanOptOutPanel());
                            } else {
                                panel.add(new RetirementPlanOptInPanel());
                            }
                        }
                    }
                });
    }
    
    protected String getBenifitsURI() {
        return OfficeWelcome.constants.root_url() + "retirement-plan";
    }
    
    @Override
    protected void addListeners() {
        
    }
    
    @Override
    protected void configure() {
        mainPanel.setCaptionHTML("Retirement Plan");
    }
    
    @Override
    protected void addWidgets() {
        mainPanel.setContentWidget(panel);
    }
    
}
