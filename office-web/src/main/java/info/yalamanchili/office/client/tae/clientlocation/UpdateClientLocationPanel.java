/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.clientlocation;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.UpdateComposite;
import info.yalamanchili.office.client.rpc.HttpService;

/**
 *
 * @author Prashanthi
 */
public class UpdateClientLocationPanel extends UpdateComposite {

    public UpdateClientLocationPanel(JSONObject entity) {
        initUpdateComposite(entity, "ClientLocation", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
       
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable arg0) {
                handleErrorResponse(arg0);
            }

            @Override
            public void onSuccess(String arg0) {
                postUpdateSuccess(arg0);
            }
        });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
       
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("successfully updated clientlocation");
        TabPanel.instance().timeandExpensePanel.sidePanelTop.clear();
        TabPanel.instance().timeandExpensePanel.sidePanelTop.add(new ClientLocationOptionsPanel());
        TabPanel.instance().timeandExpensePanel.entityPanel.clear();
        TabPanel.instance().timeandExpensePanel.entityPanel.add(new ReadAllClientLocationsPanel());
    }

    @Override
    protected void addListeners() {
       
    }

    @Override
    protected void configure() {
       
    }

    @Override
    protected void addWidgets() {
       
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "clientlocation";
    }
}
