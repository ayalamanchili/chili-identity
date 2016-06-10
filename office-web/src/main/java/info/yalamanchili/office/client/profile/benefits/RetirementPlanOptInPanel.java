/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.benefits;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.ProfileHome;

/**
 *
 * @author ayalamanchili
 */
public class RetirementPlanOptInPanel extends ALComposite implements ClickHandler {

    protected FlowPanel panel = new FlowPanel();

    HTML optInHTML = new HTML("<h4>I am interested in 401k plan</h4>");
    TextAreaField optInCommentsF = new TextAreaField(OfficeWelcome.constants, "optInComment", "RetirementPlan", false, false, Alignment.VERTICAL);
    Button optInB = new Button("Opt Me In");

    public RetirementPlanOptInPanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        optInB.addClickHandler(this);
    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        panel.add(optInHTML);
        panel.add(optInCommentsF);
        panel.add(optInB);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(optInB)) {
            processOptIn();
        }
    }

    protected void processOptIn() {
        JSONObject entity = new JSONObject();
        if (optInCommentsF.getValue() != null && !optInCommentsF.getValue().isEmpty()) {
            entity.put("comment", new JSONString(optInCommentsF.getValue()));
        }
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {

                    @Override
                    public void onResponse(String arg0) {
                        new ResponseStatusWidget().show("Thank you. You will soon be notified via email on the next steps.");
                        //ProfileHome.instance().refreshBenifitsPanel();
                        TabPanel.instance().profilePanel.entityPanel.clear();
                        TabPanel.instance().profilePanel.entityPanel.add(new RetirementPlanReadPanel());
                    }
                });
    }

    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "retirement-plan/opt-in";
    }
}
