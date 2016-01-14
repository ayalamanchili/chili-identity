/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.hr;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.Utils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class ProspectsSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ProspectsSidePanel.class.getName());
    public FlowPanel sidepanel = new FlowPanel();
    Button prospectsReportB = new Button("Reports");
    EnumField statusF = new EnumField(OfficeWelcome.constants, "status", "Prospect", false, false, ProspectStatus.names(), Alignment.VERTICAL);
    DateField startDateF = new DateField(OfficeWelcome.constants, "joiningDateTo", "Prospect", false, false, Alignment.VERTICAL);
    DateField endDateF = new DateField(OfficeWelcome.constants, "joiningDateFrom", "Prospect", false, false, Alignment.VERTICAL);

    public ProspectsSidePanel() {
        init(sidepanel);
    }

    @Override
    protected void addListeners() {
        prospectsReportB.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        sidepanel.add(new SearchProspectsPanel());
        sidepanel.add(Utils.getLineSeperatorTag("Report"));
        sidepanel.add(statusF);
        sidepanel.add(startDateF);
        sidepanel.add(endDateF);
        sidepanel.add(prospectsReportB);
    }

    public JSONObject getObject() {
        JSONObject obj = new JSONObject();
        if (statusF.getValue() == null) {
            statusF.setMessage("Required");
        }
        if (statusF.listBox.getSelectedValue() != null) {
            obj.put("status", new JSONString(statusF.getValue()));
        }
        if (startDateF.getDate() != null) {
            obj.put("joiningDateFrom", new JSONString(DateUtils.toDateString(startDateF.getDate())));
        }
        if (endDateF.getDate() != null) {
            obj.put("joiningDateTo", new JSONString(DateUtils.toDateString(endDateF.getDate())));
        }
        return obj;
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(prospectsReportB)) {
            JSONObject obj = getObject();
            if (obj.containsKey("status")) {
                String reportUrl = OfficeWelcome.instance().constants.root_url() + "prospect/report";
                HttpService.HttpServiceAsync.instance().doPut(reportUrl, obj.toString(), OfficeWelcome.instance().getHeaders(), true,
                        new ALAsyncCallback<String>() {
                            @Override
                            public void onResponse(String result) {
                                new ResponseStatusWidget().show("Report Will Be Emailed To Your Primary Email");
                            }
                        });
            }
        }
    }
}
