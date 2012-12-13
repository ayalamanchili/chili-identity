/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.ReadComposite;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class ReadClientInfoPanel extends ReadComposite {

    private static ReadClientInfoPanel instance;
    private static Logger logger = Logger.getLogger(ReadClientInfoPanel.class.getName());

    public static ReadClientInfoPanel instance() {
        return instance;
    }

    public ReadClientInfoPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "ClientInfoPanel", OfficeWelcome.constants);
    }

    public ReadClientInfoPanel(String id) {
        initReadComposite(id, "ClientInfoPanel", OfficeWelcome.constants);
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
        assignEntityValueFromField("consultantJobTitle", entity);
        assignEntityValueFromField("reportsToRole", entity);
        assignEntityValueFromField("rtPrimary", entity);
        assignEntityValueFromField("firstName", entity);
        assignEntityValueFromField("middleInitial", entity);
        assignEntityValueFromField("lastName", entity);
        assignEntityValueFromField("phoneNumber", entity);
        assignEntityValueFromField("email", entity);
        assignEntityValueFromField("extension", entity);
        assignEntityValueFromField("countryCode", entity);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("consultantJobTitle", false, true, DataType.STRING_FIELD);
        addField("reportsToRole", false, true, DataType.STRING_FIELD);
        addField("firstName", false, true, DataType.STRING_FIELD);
        addField("middleInitial", false, false, DataType.STRING_FIELD);
        addField("lastName", false, true, DataType.STRING_FIELD);
        String[] strs = {"MALE", "FEMALE"};
        addEnumField("sex", false, true, strs);
        addField("rtPrimary", false, false, DataType.BOOLEAN_FIELD);
        addField("phoneNumber", false, true, DataType.LONG_FIELD);
        addField("email", false, true, DataType.STRING_FIELD);
        addField("extension", false, true, DataType.LONG_FIELD);
        addField("countryCode", false, true, DataType.LONG_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "clientinformation/" + entityId;
    }
}
