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
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
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

    public CreateServiceTicketPanel() {
        super(CreateCompositeType.CREATE);
        initCreateComposite("SelfService", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        entity = new JSONObject();
        assignEntityValueFromField("subject", entity);
        assignEntityValueFromField("type", entity);
        entity.put("description", new JSONString(descriptionF.getHTML()));
        logger.info(entity.toString());
        return entity;

    }

    @Override
    protected void addWidgets() {
        addField("subject", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("type", false, true, TicketType.names(), Alignment.HORIZONTAL);
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                addReportField();
            }
        });
        alignFields();
    }

    protected final void addReportField() {
        descriptionF = Editor.getEditor(false);
        entityFieldsPanel.add(descriptionF);
    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable arg0) {
                logger.info(arg0.getMessage());
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
        setButtonText("Submit");
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "selfservice/create-ticket/currentuser";
    }
}
