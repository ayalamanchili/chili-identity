/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.selfservice;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.RichTextField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author raghu.l
 */
public class CreateServiceTicketPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateServiceTicketPanel.class.getName());
    RichTextField descriptionF;

    public CreateServiceTicketPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("SelfService", OfficeWelcome.constants);
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
        descriptionF = (RichTextField) fields.get("description");
        descriptionF.setWidth("100%");
    }

    @Override
    protected void addWidgets() {
        addField("subject", false, true, DataType.STRING_FIELD);
        addField("description", false, false, DataType.RICH_TEXT_AREA);
        addEnumField("type", false, true, TicketType.names());
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
