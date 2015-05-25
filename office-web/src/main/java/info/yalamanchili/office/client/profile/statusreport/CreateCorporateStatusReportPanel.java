/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.statusreport;

import com.axeiya.gwtckeditor.client.CKConfig;
import com.axeiya.gwtckeditor.client.CKEditor;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;

/**
 *
 * @author ayalamanchili
 */
public class CreateCorporateStatusReportPanel extends ALComposite implements ClickHandler {

    protected CaptionPanel basePanel = new CaptionPanel();
    protected FlowPanel panel = new FlowPanel();
    DateField startDateField = new DateField(OfficeWelcome.constants, "startDate", "StatusReport", false, false, Alignment.HORIZONTAL);
    DateField endDateField = new DateField(OfficeWelcome.constants, "endDate", "StatusReport", false, false, Alignment.HORIZONTAL);
    CKEditor statusReportsF = new CKEditor(CKConfig.basic);
    Button createB = new Button("Submit");
    JSONObject entity;

    protected CreateCorporateStatusReportPanel() {
        init(basePanel);
    }

    protected CreateCorporateStatusReportPanel(JSONObject entity) {
        init(basePanel);
        this.entity = entity;
        populateEntityFromFields(entity);
    }

    public final void populateEntityFromFields(JSONObject entity) {
        startDateField.setValue(JSONUtils.toString(entity, "reportStartDate"));
        endDateField.setValue(JSONUtils.toString(entity, "reportEndDate"));
        statusReportsF.setHTML(JSONUtils.toString(entity, "report"));
    }

    @Override
    protected void addListeners() {
        createB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        basePanel.setCaptionHTML("Status Report");
        startDateField.getLabel().getElement().getStyle().setWidth(90, Style.Unit.PX);
        endDateField.getLabel().getElement().getStyle().setWidth(90, Style.Unit.PX);
    }

    @Override
    protected void addWidgets() {
        basePanel.setContentWidget(panel);
        panel.add(startDateField);
        panel.add(endDateField);
        panel.add(statusReportsF);
        panel.add(createB);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createB)) {
            saveStatusReport();
        }
    }

    protected void saveStatusReport() {
        if (entity == null) {
            entity = new JSONObject();
        }
        entity.put("reportStartDate", new JSONString(DateUtils.toDateString(startDateField.getDate())));
        entity.put("reportEndDate", new JSONString(DateUtils.toDateString(endDateField.getDate())));
        entity.put("report", new JSONString(statusReportsF.getHTML()));
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        new ResponseStatusWidget().show("Successfully submited status report");
                        TabPanel.instance().homePanel.entityPanel.clear();
                        TabPanel.instance().homePanel.entityPanel.add(new ReadAllCorporateStatusReportsPanel());
                    }
                });
    }

    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "corporate-statusreport";
    }
}
