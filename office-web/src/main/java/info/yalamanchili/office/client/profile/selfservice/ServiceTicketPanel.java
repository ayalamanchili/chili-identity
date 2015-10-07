/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.selfservice;

import com.axeiya.gwtckeditor.client.CKEditor;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import static info.yalamanchili.office.client.expense.travelauthorization.TravelAuthConstants.DEFAULT_FIELD_WIDTH;
import static info.yalamanchili.office.client.expense.travelauthorization.TravelAuthConstants.TOTAL_MILES;
import static info.yalamanchili.office.client.expense.travelauthorization.TravelAuthConstants.TRAVEL_TRANSPORTATION_TYPE;
import info.yalamanchili.office.client.expense.travelauthorization.TravelTransportationType;
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
    EnumField typeF;
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
        typeF.listBox.addChangeHandler(this);
    }
    @Override
    protected void configure() {
        typeF.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
    }
    @Override
    protected void addWidgets() {
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                addReportField();
            }
        });
        typeF = new EnumField(OfficeWelcome.constants,
                "type", "TicketType", readyOnly, false, TicketType.names(), Alignment.HORIZONTAL);
        panel.add(typeF);
    }
    protected final void addReportField() {
        descriptionF = Editor.getEditor(false);
        panel.insert(descriptionF, panel.getWidgetIndex(typeF));
    }
    public void setHtml(String html) {
        descriptionF.setData(html);
    }
    protected final void populateFields() {
        logger.info(entity.toString());
        if (entity.get("type") != null) {
            typeF.selectValue(entity.get("type").isString().stringValue());
        }
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
        if (typeF.getValue() != null) {
            entity.put("type", new JSONString(typeF.getValue()));
        }
        if(descriptionF.getHTML()!=null){
            entity.put("description", new JSONString(descriptionF.getHTML()));
        }
        return entity;
     }
     
}
