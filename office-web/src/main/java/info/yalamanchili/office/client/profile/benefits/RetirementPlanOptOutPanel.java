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
public class RetirementPlanOptOutPanel extends ALComposite implements ClickHandler {

    protected FlowPanel panel = new FlowPanel();
    HTML futureHTML = new HTML("<html>\n"
            + "<head>\n"
            + "	<title></title>\n"
            + "</head>\n"
            + "<body>\n"
            + "<hr />\n"
            + "<p>Thank you for your interest in 401k Plan.</p>\n"
            + "\n"
            + "<div style=\"page-break-after: always\"><span style=\"display: none;\">&nbsp;</span></div>\n"
            + "\n"
            + "<p>Coming Soon...&nbsp;Manage&nbsp;your 401k Plan</p>\n"
            + "\n"
            + "<hr />\n"
            + "<p>&nbsp;</p>\n"
            + "</body>\n"
            + "</html>");

    HTML optOutHTML = new HTML("<h4>I am not interested 401k </h4>");
    TextAreaField optOutCommentsF = new TextAreaField(OfficeWelcome.constants, "optOutComment", "RetirementPlan", false, false, Alignment.VERTICAL);
    Button optOutB = new Button("Opt Me Out");

    public RetirementPlanOptOutPanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        optOutB.addClickHandler(this);
    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        panel.add(futureHTML);
        panel.add(optOutHTML);
        panel.add(optOutCommentsF);
        panel.add(optOutB);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(optOutB)) {
            processOptOut();
        }
    }

    protected void processOptOut() {
        JSONObject entity = new JSONObject();
        if (optOutCommentsF.getValue() != null && !optOutCommentsF.getValue().isEmpty()) {
            entity.put("comment", new JSONString(optOutCommentsF.getValue()));
        }
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {

                    @Override
                    public void onResponse(String arg0) {
                        new ResponseStatusWidget().show("Thank you. You are now Opted Out of Retirement Plan");
                        // ProfileHome.instance().refreshBenifitsPanel();
                        TabPanel.instance().profilePanel.entityPanel.clear();
                        TabPanel.instance().profilePanel.entityPanel.add(new RetirementPlanReadPanel());

                    }
                });
    }

    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "retirement-plan/opt-out";
    }
}
