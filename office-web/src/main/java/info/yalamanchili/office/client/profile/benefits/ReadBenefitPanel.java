/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.benefits;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author Hemanth
 */
public class ReadBenefitPanel extends ReadComposite {
   
    private static ReadBenefitPanel instance;

    private static Logger logger = Logger.getLogger(ReadBenefitPanel.class.getName());

    public static ReadBenefitPanel instance() {
        return instance;
    }

    public ReadBenefitPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Benefit", OfficeWelcome.constants2);
    }

    public ReadBenefitPanel(String id) {
        initReadComposite(id, "Benefit", OfficeWelcome.constants2);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        logger.info("read ec6 response" + response);
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("benefitType", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("year", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("enrolled", entity, DataType.BOOLEAN_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("benefitType", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("year", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("enrolled", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);      
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllBenefitsPanel.instance;
    }    
    
    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "benefit/" + entityId;
    } 
}
