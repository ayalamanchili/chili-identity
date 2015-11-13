/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.statusreport;

import com.axeiya.gwtckeditor.client.CKEditor;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class CreateCorporateStatusReportPanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(CreateCorporateStatusReportPanel.class.getName());
    protected CaptionPanel basePanel = new CaptionPanel();
    protected FlowPanel panel = new FlowPanel();
    ClickableLink uploadFromFile = new ClickableLink("Import from Word or Excel");
    SelectTimePeriodWidget statusReportPeriodF;
    CKEditor reportF;
    BooleanField submitForApprovalF = new BooleanField(OfficeWelcome.constants, "Submit", "CorporateStatusReport", false, false, Alignment.HORIZONTAL);
    Button createB = new Button("Save");
    JSONObject entity;
    String entityId;
    boolean isUpdate = false;
    private static CreateCorporateStatusReportPanel instance;

    public static CreateCorporateStatusReportPanel instance() {
        return instance;
    }

    protected CreateCorporateStatusReportPanel() {
        instance = this;
        statusReportPeriodF = new SelectUserTimePeriod(false, true);
        init(basePanel);
    }

    protected CreateCorporateStatusReportPanel(JSONObject entity) {
        instance = this;
        statusReportPeriodF = new SelectUserTimePeriod(false, true);
        init(basePanel);
        this.entity = entity;
        populateFieldsFromEntity(entity);
    }

    protected CreateCorporateStatusReportPanel(String id) {
        instance = this;
        statusReportPeriodF = new SelectTimePeriodWidget(false, true);
        this.isUpdate = true;
        init(basePanel);
        this.entityId = id;
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        logger.info(arg0);
                        entity = JSONParser.parseLenient(arg0).isObject();
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    protected final String getReadURI() {
        return OfficeWelcome.constants.root_url() + "corporate-statusreport/" + entityId;
    }

    public final void populateFieldsFromEntity(final JSONObject entity) {
        logger.info(entity.toString());
        if (entity.get("statusReportPeriod") != null) {
            statusReportPeriodF.setSelectedValue(entity.get("statusReportPeriod").isObject());
        }
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                populateReport(entity);
            }
        });
    }

    protected final void populateReport(final JSONObject entity) {
        reportF.setHTML(JSONUtils.toString(entity, "report"));
    }

    @Override
    protected void addListeners() {
        createB.addClickHandler(this);
        submitForApprovalF.getBox().addClickHandler(this);
        uploadFromFile.addClickHandler(this);
    }

    @Override
    protected void configure() {
        basePanel.setCaptionHTML("StatusReports");
        statusReportPeriodF.setReadOnly(isUpdate);
    }

    @Override
    protected void addWidgets() {
        basePanel.setContentWidget(panel);
        panel.add(statusReportPeriodF);
        panel.add(uploadFromFile);
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                addReportField();
            }
        });

        panel.add(submitForApprovalF);
        panel.add(createB);
    }

    protected final void addReportField() {
        reportF = Editor.getEditor(false);
        panel.insert(reportF, panel.getWidgetIndex(submitForApprovalF));
    }

    public void setHtml(String html) {
        reportF.setData(html);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createB)) {
            saveStatusReport();
        }
        if (event.getSource().equals(submitForApprovalF.getBox())) {
            if (submitForApprovalF.getValue()) {
                createB.setText("Submit");
            } else {
                createB.setText("Save");
            }
        }
        if (event.getSource().equals(uploadFromFile)) {
            new GenericPopup(new UploadCorporateStatusReportPanel()).show();
        }
    }

    protected void saveStatusReport() {
        if (statusReportPeriodF.getSelectedObject() == null) {
            statusReportPeriodF.setMessage("Please select a Time Period");
            return;
        }
        if (entity == null) {
            entity = new JSONObject();
        }
        entity.put("statusReportPeriod", statusReportPeriodF.getSelectedObject());
        entity.put("reportStartDate", new JSONString(DateUtils.toDateString(new Date())));
        entity.put("reportEndDate", new JSONString(DateUtils.toDateString(new Date())));
        entity.put("report", new JSONString(reportF.getData()));
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        new ResponseStatusWidget().show("Successfully submited status report");
                        if (TabPanel.instance().myOfficePanel.isVisible()) {
                            TabPanel.instance().myOfficePanel.entityPanel.clear();
                            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllCorporateStatusReportsPanel());
                        }
                        if (TabPanel.instance().homePanel.isVisible()) {
                            TabPanel.instance().homePanel.entityPanel.clear();
                            TabPanel.instance().homePanel.entityPanel.add(new ReadAllCorporateStatusReportsPanel());
                        }
                    }
                });
    }

    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "corporate-statusreport?submitForApproval=" + submitForApprovalF.getValue();
    }
}
