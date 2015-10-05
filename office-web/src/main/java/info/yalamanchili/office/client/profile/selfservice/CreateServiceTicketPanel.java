/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.selfservice;

import com.axeiya.gwtckeditor.client.CKEditor;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.statusreport.Editor;
import java.util.logging.Logger;

/**
 *
 * @author raghu.l
 */
public class CreateServiceTicketPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateServiceTicketPanel.class.getName());
    CKEditor descriptionF;
    FlowPanel panel=new FlowPanel();
    EnumField typeF=new EnumField(OfficeWelcome.constants, "type", "TicketStatus", false, false, TicketStatus.names(), Alignment.HORIZONTAL);
    

    public CreateServiceTicketPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("SelfService", OfficeWelcome.constants);
    }
    
    
    public final void populateFieldsFromEntity(final JSONObject entity) {
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
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("subject", entity);
        assignEntityValueFromField("description", entity);
        assignEntityValueFromField("type", entity);
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postCreateSuccess(arg0);
                    }
                });
    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Submitted Service Ticket");
        TabPanel.instance().homePanel.entityPanel.clear();
        TabPanel.instance().homePanel.entityPanel.add(new ReadAllServiceTicketsPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
       
    }

    @Override
    protected void addWidgets() {
        addField("subject", false, true, DataType.STRING_FIELD);
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                addReportField();
            }
        });
         addEnumField("type", false, false, TicketStatus.names());
    }
    protected final void addReportField() {
        descriptionF = Editor.getEditor(false);
    }

    public void setHtml(String html) {
        descriptionF.setData(html);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "selfservice/create-ticket/currentuser";
    }

    @Override
    protected boolean showDocumentationLink() {
        return true;
    }

    @Override
    protected String getDocumentationLink() {
        return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "selfservice/open-ticket.html";
    }
}
