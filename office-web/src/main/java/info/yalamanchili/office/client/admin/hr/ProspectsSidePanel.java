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
import com.google.gwt.json.client.JSONParser;
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
import info.chili.gwt.widgets.GenericPopup;
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
    Button reportB = new Button("Reports");
    Button graphsB = new Button("Graphs");
    EnumField statusF = new EnumField(OfficeWelcome.constants, "status", "Prospect", false, false, ProspectStatus.names(), Alignment.VERTICAL);
    DateField startDateF = new DateField(OfficeWelcome.constants, "joiningDateTo", "Prospect", false, false, Alignment.VERTICAL);
    DateField endDateF = new DateField(OfficeWelcome.constants, "joiningDateFrom", "Prospect", false, false, Alignment.VERTICAL);

    public ProspectsSidePanel() {
        init(sidepanel);
    }

    @Override
    protected void addListeners() {
        reportB.addClickHandler(this);
        graphsB.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        sidepanel.add(new SearchProspectsPanel());
        sidepanel.add(Utils.getLineSeperatorTag("Reports and Graphs"));
        sidepanel.add(statusF);
        sidepanel.add(startDateF);
        sidepanel.add(endDateF);
        sidepanel.add(reportB);
        sidepanel.add(graphsB);
    }

    public JSONObject getObject() {
        JSONObject obj = new JSONObject();
        if ((statusF.getValue() == null) && (startDateF.getDate() == null) && (endDateF.getDate() == null)) {
            statusF.setMessage("Required");
            startDateF.clearMessage();
            endDateF.clearMessage();
        } else if (startDateF.getDate() != null && endDateF.getDate() == null) {
            endDateF.setMessage("Required");
            statusF.clearMessage();
        } else if (endDateF.getDate() != null && startDateF.getDate() == null) {
            startDateF.setMessage("Required");
            statusF.clearMessage();
        }
        if (statusF.getValue() != null) {
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
        if (event.getSource().equals(reportB)) {
            JSONObject obj = getObject();
            if ((obj.containsKey("status") == true) || (obj.containsKey("joiningDateFrom") == true && obj.containsKey("joiningDateTo") == true)) {
                String reportUrl = OfficeWelcome.instance().constants.root_url() + "prospect/report";
                HttpService.HttpServiceAsync.instance().doPut(reportUrl, obj.toString(), OfficeWelcome.instance().getHeaders(), true,
                        new ALAsyncCallback<String>() {
                            @Override
                            public void onResponse(String result) {
                                new ResponseStatusWidget().show("Report Will Be Emailed To Your Primary Email");
                            }
                        });
                statusF.clearMessage();
                startDateF.clearMessage();
                endDateF.clearMessage();
            }
        }
        if (event.getSource().equals(graphsB)) {
            JSONObject obj = getObject();
            if (obj.containsKey("status")) {
                String graphUrl = OfficeWelcome.instance().constants.root_url() + "prospect/graph";
                HttpService.HttpServiceAsync.instance().doPut(graphUrl, obj.toString(), OfficeWelcome.instance().getHeaders(), true,
                        new ALAsyncCallback<String>() {
                            @Override
                            public void onResponse(String result) {
                                logger.info(result);
                                JSONObject graphObj = JSONParser.parseLenient(result).isObject();
                                GenericPopup popup = new GenericPopup(new ProspectsGraphsPanel(graphObj));
                                popup.setPixelSize(510, 600);
                                popup.show();
                            }
                        });
            }
        }
    }
}
