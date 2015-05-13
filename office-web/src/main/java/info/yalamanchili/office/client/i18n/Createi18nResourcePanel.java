/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.i18n;

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
 * @author ayalamanchili
 */
public class Createi18nResourcePanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(Createi18nResourcePanel.class.getName());

    public Createi18nResourcePanel() {
        super(CreateComposite.CreateCompositeType.CREATE);
        initCreateComposite("Resources", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("key", entity);
        assignEntityValueFromField("value", entity);
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
        new ResponseStatusWidget().show("Successfully Created Resource");
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
        TabPanel.instance().chiliAdminPanel.entityPanel.add(new ReadAllC18nResourcesPanel(Ci18nBundleTreePanel.instance().getEntityId()));
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
        addField("key", false, true, DataType.STRING_FIELD);
        addField("value", false, true, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "i18n/bundle/resource/" + Ci18nBundleTreePanel.instance().getEntityId();
    }
}
