/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.releasenotes;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author sudharani.b
 */
public class CreateReleaseNotesPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateReleaseNotesPanel.class.getName());

    public CreateReleaseNotesPanel() {
        super(CreateCompositeType.CREATE);
        initCreateComposite("ReleaseNotes", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("summary", entity);
        assignEntityValueFromField("details", entity);
        assignEntityValueFromField("effectiveDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("userIds", entity);
        assignEntityValueFromField("roles", entity);
        assignEntityValueFromField("moreInformationLink", entity);

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
        new ResponseStatusWidget().show("Successfully Created ReleaseNotes");
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
        TabPanel.instance().chiliAdminPanel.entityPanel.add(new ReadAllReleaseNotesPanel());
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
        addField("summary", false, true, DataType.TEXT_AREA_FIELD);
        addField("details", false, true, DataType.RICH_TEXT_AREA);
        addField("effectiveDate", false, true, DataType.DATE_FIELD);
        addField("endDate", false, true, DataType.DATE_FIELD);
        addField("userIds", false, false, DataType.TEXT_AREA_FIELD);
        addField("roles", false, false, DataType.TEXT_AREA_FIELD);
        addField("moreInformationLink", false, false, DataType.TEXT_AREA_FIELD);

    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub  
    }

    @Override
    protected String getURI() {
        logger.info(OfficeWelcome.constants.root_url());
        return OfficeWelcome.constants.root_url() + "releaseNotes/save";
    }
}
