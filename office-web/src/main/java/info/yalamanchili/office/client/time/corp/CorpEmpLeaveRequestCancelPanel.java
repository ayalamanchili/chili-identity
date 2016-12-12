/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time.corp;

import com.google.common.base.Strings;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;

/**
 *
 * @author ayalamanchili
 */
public class CorpEmpLeaveRequestCancelPanel extends ALComposite implements ClickHandler {

    protected String timeSheetId;
    protected FlowPanel panel = new FlowPanel();
    TextAreaField cancelReasonF = new TextAreaField(OfficeWelcome.constants, "cancel", "CorpEmpLeaveRequest", false, true   );
    Button cancelB = new Button("Cancel");

    public CorpEmpLeaveRequestCancelPanel(String timeSheetId) {
        this.timeSheetId = timeSheetId;
        init(panel);
    }

    @Override
    protected void addListeners() {
        cancelB.addClickHandler(this);
    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        panel.add(cancelReasonF);
        panel.add(cancelB);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (Strings.isNullOrEmpty(cancelReasonF.getValue())) {
            cancelReasonF.setMessage("Reason is required");
            return;
        }
        if (Window.confirm("Your request will be submitted for approval. Are you sure? You want to cancel the Leave Request")) {
            GenericPopup.instance().hide();
            HttpService.HttpServiceAsync.instance().doGet(getCancelLeaveRequestUrl(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String result) {
                            new ResponseStatusWidget().show("Cancel request has been submitted");
                            TabPanel.instance().getTimePanel().entityPanel.clear();
                            TabPanel.instance().getTimePanel().sidePanelTop.clear();
                            TabPanel.instance().getTimePanel().sidePanelTop.add(new CorporateTimeSummarySidePanel());
                            TabPanel.instance().getTimePanel().entityPanel.add(new CorporateTimeSummaryPanel());
                            TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllCorporateTimeSheetPanel());
                        }
                    });
        }

    }

    protected String getCancelLeaveRequestUrl() {
        return OfficeWelcome.instance().constants.root_url() + "corporate-timesheet/cancel-leave-request/" + timeSheetId + "?cancelReason="
                + cancelReasonF.getValue();
    }
}
