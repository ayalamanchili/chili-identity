/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.statusreport;

import com.axeiya.gwtckeditor.client.CKConfig;
import com.axeiya.gwtckeditor.client.CKEditor;
import com.google.gwt.dom.client.Style;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.fields.DateField;
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
    CKEditor statusReportsF = new CKEditor(CKConfig.basic);

    public ReadCorporateStatusReportPanel(JSONObject entity) {
        init(basePanel);
        populateEntityFromFields(entity);
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
        panel.add(statusReportsF);
    }

    public final void populateEntityFromFields(JSONObject entity) {
        logger.info("ddddddddddddddd" + entity);
        startDateField.setValue(JSONUtils.toString(entity, "reportStartDate"));
        endDateField.setValue(JSONUtils.toString(entity, "reportEndDate"));
        statusReportsF.setHTML(JSONUtils.toString(entity, "report"));
    }

}
