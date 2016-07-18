/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.immigrationcase;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.crud.TReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.expense.chkreq.ImmigrationCaseType;
import info.yalamanchili.office.client.expense.chkreq.SponsorType;
import info.yalamanchili.office.client.profile.emergencycnt.ReadAllDependentsPanel;

/**
 *
 * @author Sandeep Sunchu <sandeep.sunchu@sstech.us>
 */
public class ReadImmigrationCasePanel extends TReadComposite {
    
    private static ReadImmigrationCasePanel instance;
    
    public static ReadImmigrationCasePanel instance() {
        return instance;
    }

    public ReadImmigrationCasePanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "ImmigrationCase", OfficeWelcome.constants2);
        populateDependents();
    }
    
    protected final void populateDependents() {
        entityFieldsPanel.setWidget(4, 1, new ReadAllDependentsPanel(getEntityId(), "ImmigrationCase"));
        entityFieldsPanel.getFlexCellFormatter().setColSpan(4, 1, 2);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String response) {
                entity = (JSONObject) JSONParser.parseLenient(response);
                populateFieldsFromEntity(entity);
            }
        });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("sponsorType", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("immigrationCaseType", entity, DataType.ENUM_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addEnumField("sponsorType", true, true, SponsorType.names(), Alignment.HORIZONTAL,1,1);
        addEnumField("immigrationCaseType", true, true, ImmigrationCaseType.names(), Alignment.HORIZONTAL,2,1);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "immigrationcase/" + entityId;
    }

   
    
}
