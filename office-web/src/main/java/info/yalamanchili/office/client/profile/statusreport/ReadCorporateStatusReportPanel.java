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
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.crud.ReadAllAuditDataPanel;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadCorporateStatusReportPanel extends ALComposite {

    private static Logger logger = Logger.getLogger(ReadCorporateStatusReportPanel.class.getName());
    protected CaptionPanel basePanel = new CaptionPanel();
    protected FlowPanel panel = new FlowPanel();
    DateField startDateField = new DateField(OfficeWelcome.constants, "startDate", "StatusReport", true, false, Alignment.HORIZONTAL);
    DateField endDateField = new DateField(OfficeWelcome.constants, "endDate", "StatusReport", true, false, Alignment.HORIZONTAL);
    CKEditor statusReportsF;
    JSONObject entity;
    String entityId;

    public ReadCorporateStatusReportPanel(String entityId) {
        init(basePanel);
        this.entityId = entityId;
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

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {
        basePanel.setCaptionHTML("StatusReports");
        startDateField.getLabel().getElement().getStyle().setWidth(90, Style.Unit.PX);
        endDateField.getLabel().getElement().getStyle().setWidth(90, Style.Unit.PX);
    }

    @Override
    protected void addWidgets() {
        basePanel.setContentWidget(panel);
        panel.add(startDateField);
        panel.add(endDateField);
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                addReportField();
            }
        });
        final DisclosurePanel auditDP = new DisclosurePanel("Audit");
        auditDP.addOpenHandler(new OpenHandler<DisclosurePanel>() {
            @Override
            public void onOpen(OpenEvent<DisclosurePanel> event) {
                auditDP.setContent(new ReadAllAuditDataPanel("", getAuditUrl(), OfficeWelcome.constants));
            }
        });
        panel.add(auditDP);
    }

    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.employee.statusreport.CorporateStatusReport" + "/" + entityId;
    }

    public final void populateFieldsFromEntity(final JSONObject entity) {
        startDateField.setValue(JSONUtils.toString(entity, "reportStartDate"));
        endDateField.setValue(JSONUtils.toString(entity, "reportEndDate"));
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                populateReport(entity);
            }
        });

    }

    protected final void addReportField() {
        statusReportsF = Editor.getEditor(true);
        panel.add(statusReportsF);
    }

    protected final void populateReport(final JSONObject entity) {

        statusReportsF.setHTML(JSONUtils.toString(entity, "report"));
    }
    
}
