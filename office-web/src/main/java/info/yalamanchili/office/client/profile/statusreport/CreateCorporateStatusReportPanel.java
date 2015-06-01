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
import com.axeiya.gwtckeditor.client.CKConfig.PRESET_TOOLBAR;
import com.axeiya.gwtckeditor.client.CKConfig.TOOLBAR_OPTIONS;
import com.axeiya.gwtckeditor.client.CKEditor;
import com.axeiya.gwtckeditor.client.Toolbar;
import com.axeiya.gwtckeditor.client.ToolbarLine;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.Date;

/**
 *
 * @author ayalamanchili
 */
public class CreateCorporateStatusReportPanel extends ALComposite implements ClickHandler {

    protected CaptionPanel basePanel = new CaptionPanel();
    protected FlowPanel panel = new FlowPanel();
    SelectTimePeriodWidget statusReportPeriodF = new SelectTimePeriodWidget(false, true);
    CKEditor statusReportsF = getEditor();
    BooleanField submitForApprovalF = new BooleanField(OfficeWelcome.constants, "submitForApproval", "CorporateStatusReport", false, false, Alignment.HORIZONTAL);
    Button createB = new Button("Save");
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
        statusReportsF.setHTML(JSONUtils.toString(entity, "report"));
    }

    @Override
    protected void addListeners() {
        createB.addClickHandler(this);
        submitForApprovalF.getBox().addClickHandler(this);
    }

    @Override
    protected void configure() {
        basePanel.setCaptionHTML("StatusReports");
    }

    @Override
    protected void addWidgets() {
        basePanel.setContentWidget(panel);
        panel.add(statusReportPeriodF);
        panel.add(statusReportsF);
        panel.add(submitForApprovalF);
        panel.add(createB);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createB)) {
            saveStatusReport();
        }
        if (event.getSource().equals(submitForApprovalF.getBox())) {
            if (submitForApprovalF.getValue()) {
                createB.setText("Save and Submit");
            } else {
                createB.setText("Save");
            }
        }
    }

    protected void saveStatusReport() {
        if (entity == null) {
            entity = new JSONObject();
        }
        entity.put("statusReportPeriod", statusReportPeriodF.getSelectedObject());
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

    protected CKEditor getEditor() {
        CKConfig ckf = new CKConfig(PRESET_TOOLBAR.FULL);
        //Setting size
        ckf.setHeight("400px");
        //Creating personalized toolbar
        ToolbarLine line0 = new ToolbarLine();
        line0.add(TOOLBAR_OPTIONS.BulletedList);
        line0.add(TOOLBAR_OPTIONS.NumberedList);
        line0.add(TOOLBAR_OPTIONS.Indent);
        line0.add(TOOLBAR_OPTIONS.Outdent);
        line0.add(TOOLBAR_OPTIONS.JustifyBlock);
        line0.add(TOOLBAR_OPTIONS.JustifyCenter);
        line0.add(TOOLBAR_OPTIONS.JustifyLeft);
        line0.add(TOOLBAR_OPTIONS.JustifyRight);
        line0.add(TOOLBAR_OPTIONS.Styles);
        line0.addBlockSeparator();
        line0.add(TOOLBAR_OPTIONS.Bold);
        line0.add(TOOLBAR_OPTIONS.Underline);
        line0.add(TOOLBAR_OPTIONS.Italic);
        line0.add(TOOLBAR_OPTIONS.FontSize);
        line0.add(TOOLBAR_OPTIONS.Font);
        line0.add(TOOLBAR_OPTIONS.TextColor);
        line0.add(TOOLBAR_OPTIONS.BGColor);
        line0.add(TOOLBAR_OPTIONS.Table);
        line0.addBlockSeparator();
        line0.add(TOOLBAR_OPTIONS.PasteFromWord);
        line0.add(TOOLBAR_OPTIONS.Preview);
        line0.add(TOOLBAR_OPTIONS.Templates);
        line0.add(TOOLBAR_OPTIONS.Maximize);

        //Creates the toolbar
        Toolbar t = new Toolbar();
        t.add(line0);

        //Set the toolbar to the config (replace the FULL preset toolbar)
        ckf.setToolbar(t);

        //Creates the editor with this config
        return new CKEditor(true, ckf);
    }

    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "corporate-statusreport?submitForApproval=" + submitForApprovalF.getValue();
    }
}
