/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.technologyGroup;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;
import info.yalamanchili.office.client.profile.employee.SelectCorpEmployeeWidget;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class CreateTechnologyGroupPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateTechnologyGroupPanel.class.getName());
    SelectTechnologyGroupWidget contactTypeF = new SelectTechnologyGroupWidget(false, false);
    SelectCorpEmployeeWidget employeeF = new SelectCorpEmployeeWidget(false, false);

    public CreateTechnologyGroupPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("TechnologyGroup", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject techGroup = new JSONObject();
        assignEntityValueFromField("name", techGroup);
        assignEntityValueFromField("description", techGroup);
        logger.info(techGroup.toString());
        return techGroup;
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
        new ResponseStatusWidget().show("Successfully created technology group data");
        TabPanel.instance().recruitingPanel.sidePanelTop.clear();
        TabPanel.instance().recruitingPanel.entityPanel.clear();
        TabPanel.instance().recruitingPanel.entityPanel.add(new ReadAllTechnologyGroupPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("name", false, true, DataType.STRING_FIELD);
        addField("description", false, false, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "technologyGroup";
    }
}
