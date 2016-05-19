/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.travelhistroy;

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
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class CreateTravelHistoryPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateTravelHistoryPanel.class.getName());

    public CreateTravelHistoryPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("TravelHistoryFrom", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject travelHistroy = new JSONObject();
        assignEntityValueFromField("typeOfVisa", travelHistroy);
        assignEntityValueFromField("arrivalDate", travelHistroy);
        assignEntityValueFromField("departureDate", travelHistroy);
        travelHistroy.put("targetEntityName", new JSONString("targetEntityName"));
        travelHistroy.put("targetEntityId", new JSONString("0"));
        return travelHistroy;
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
        new ResponseStatusWidget().show("Successfully Added TravelHistory");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllTravelHistoryPanel(TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        addField("typeOfVisa", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("arrivalDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("departureDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {

    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "travelhistory/save/" + TreeEmployeePanel.instance().getEntityId();
    }

}
