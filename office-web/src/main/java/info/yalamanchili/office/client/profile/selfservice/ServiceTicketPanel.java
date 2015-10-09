/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.selfservice;

import com.axeiya.gwtckeditor.client.CKEditor;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.profile.statusreport.Editor;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class ServiceTicketPanel extends ALComposite implements ChangeHandler{
    private static Logger logger = Logger.getLogger(ServiceTicketPanel.class.getName());
    protected FlowPanel panel = new FlowPanel();
    CKEditor descriptionF;
    boolean readyOnly;
    JSONObject entity;
    TicketType type;
    
    public ServiceTicketPanel(boolean readOnly) {
        this.readyOnly = readOnly;
        init(panel);
    }

    public ServiceTicketPanel(JSONObject entity, boolean readOnly) {
        this.readyOnly = readOnly;
        this.entity = entity;
        init(panel);
        populateFields();
    }
    @Override
    protected void addListeners() {
    }
    @Override
    protected void configure() {
    }
    @Override
    protected void addWidgets() {
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                addReportField();
            }
        });
    }
    protected final void addReportField() {
        descriptionF = Editor.getEditor(false);
        panel.add(descriptionF);
    }
    public void setHtml(String html) {
        descriptionF.setData(html);
    }
    protected final void populateFields() {
        logger.info(entity.toString());
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                populateReport(entity);
            }
        });
      }
    protected final void populateReport(final JSONObject entity) {
        descriptionF.setHTML(JSONUtils.toString(entity, "description"));
    }

    @Override
    public void onChange(ChangeEvent event) {
    }
     public JSONObject getObject() {
        entity = new JSONObject();
        if(descriptionF.getHTML()!=null){
            entity.put("description", new JSONString(descriptionF.getHTML()));
        }
        return entity;
     }
     
}
