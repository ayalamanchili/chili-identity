/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time.corp;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.fields.FloatField;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;

/**
 *
 * @author ayalamanchili
 */
public class PTOAccruedHoursAdjustmentPanel extends ALComposite implements ClickHandler {

    protected CaptionPanel mainPanel = new CaptionPanel();
    protected FlowPanel panel = new FlowPanel();
    protected JSONObject entity;
    protected String parentId;
    FloatField adjustmentHours = new FloatField(OfficeWelcome.constants, "adjustmentHours", "PTOAccruedHoursAdjustment", false, true, Alignment.HORIZONTAL);
    TextAreaField adjustmentReason = new TextAreaField(OfficeWelcome.constants, "adjustmentReason", "PTOAccruedHoursAdjustment", false, true, Alignment.HORIZONTAL);
    Button updateHoursB = new Button("Adjust Hours");

    public PTOAccruedHoursAdjustmentPanel(String parentId, JSONObject entity) {
        this.entity = entity;
        this.parentId = parentId;
        init(mainPanel);
    }

    @Override
    protected void addListeners() {
        updateHoursB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        mainPanel.setCaptionHTML("PTO Accrued Hours Adjustment");
        adjustmentHours.setBackgroundText();
        adjustmentHours.getTextbox().setVisibleLength(80);
        adjustmentReason.setBackgroundText();
        adjustmentReason.getTextbox().setCharacterWidth(40);
        adjustmentReason.getTextbox().setVisibleLines(3);
    }

    @Override
    protected void addWidgets() {
        mainPanel.setContentWidget(panel);
        panel.add(adjustmentHours);
        panel.add(adjustmentReason);
        panel.add(updateHoursB);

    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(updateHoursB)) {
            adjustHours();
        }
    }

    protected void adjustHours() {
        if (adjustmentHours.getValue() == null || adjustmentHours.getValue().isEmpty() || adjustmentReason.getValue() == null || adjustmentReason.getValue().isEmpty()) {
            Window.alert("Please enter Adjustment Hours and Reason");
        } else {
            HttpService.HttpServiceAsync.instance().doPut(adjustHoursURL(), entity.toString(),
                    OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String result) {
                            new ResponseStatusWidget().show("Successfully updated Adjustment Hours");
                            GenericPopup.instance().hide();
                            TabPanel.instance().timePanel.entityPanel.clear();
                            TabPanel.instance().timePanel.entityPanel.add(new ReadAllCorporateTimeSheetPanel(parentId));
                        }
                    });
        }
    }

    protected String adjustHoursURL() {
        return OfficeWelcome.constants.root_url() + "corporate-timesheet/adjust-hours?adjustmentHours=" + adjustmentHours.getValue() + "&adjustmentReason=" + adjustmentReason.getValue();
    }
}
