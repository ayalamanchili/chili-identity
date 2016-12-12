/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.contacttype;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class CreateCompanyContactTypePanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateCompanyContactTypePanel.class.getName());

    public CreateCompanyContactTypePanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("CompanyContactType", OfficeWelcome.constants);
    }

    @Override
    public JSONObject populateEntityFromFields() {
        JSONObject companyContactType = new JSONObject();
        assignEntityValueFromField("name", companyContactType);
        assignEntityValueFromField("description", companyContactType);
        logger.info(companyContactType.toString());
        return companyContactType;
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
        new ResponseStatusWidget().show("Successfully created Company Contact Type");
        TabPanel.instance().myOfficePanel.sidePanelTop.clear();
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllCompanyContactTypePanel());
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
        return OfficeWelcome.constants.root_url() + "companycontacttype";
    }
}
