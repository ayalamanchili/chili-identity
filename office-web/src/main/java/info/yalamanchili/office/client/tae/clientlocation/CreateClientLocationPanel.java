/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.clientlocation;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.profile.addresstype.SelectAddressTypeWidget;
import info.yalamanchili.office.client.rpc.HttpService;
import info.yalamanchili.office.client.tae.client.TreeClientPanel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class CreateClientLocationPanel extends CreateComposite{

      private static Logger logger = Logger.getLogger(CreateClientLocationPanel.class.getName());

    public CreateClientLocationPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("ClientLocation", OfficeWelcome.constants);
    }
    
    @Override
    protected JSONObject populateEntityFromFields() {
       JSONObject entity = new JSONObject();
        assignEntityValueFromField("street1", entity);
        assignEntityValueFromField("street2", entity);
        assignEntityValueFromField("city", entity);
        assignEntityValueFromField("state", entity);
        assignEntityValueFromField("country", entity);
        assignEntityValueFromField("zip", entity);
        assignEntityValueFromField("addressType", entity);
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        
    }

    @Override
    protected void addButtonClicked() {
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
    protected void postCreateSuccess(String result) {
        
    }

    @Override
    protected void addListeners() {
        
    }

    @Override
    protected void configure() {
        
    }
 protected static List<String> getCountries() {
        List<String> countries = new ArrayList<String>();
        countries.add("USA");
        countries.add("INDIA");
        return countries;
    }

//TODO externalize this
    protected static List<String> getStates() {
        List<String> states = new ArrayList<String>();
        states.add("AL");
        states.add("AK");
        states.add("AS");
        states.add("AZ");
        states.add("AR");
        states.add("CA");
        states.add("CO");
        states.add("CT");
        states.add("DE");
        states.add("DC");
        states.add("FL");
        states.add("GA");
        states.add("GU");
        states.add("HI");
        states.add("ID");
        states.add("IL");
        states.add("IN");
        states.add("IA");
        states.add("KS");
        states.add("KY");
        states.add("LA");
        states.add("ME");
        states.add("MD");
        states.add("MH");
        states.add("MA");
        states.add("MI");
        states.add("FM");
        states.add("MN");
        states.add("MS");
        states.add("MO");
        states.add("MT");
        states.add("NE");
        states.add("NV");
        states.add("NH");
        states.add("NJ");
        states.add("NM");
        states.add("NY");
        states.add("NC");
        states.add("ND");
        states.add("MP");
        states.add("OH");
        states.add("OK");
        states.add("OR");
        states.add("PW");
        states.add("PA");
        states.add("PR");
        states.add("RI");
        states.add("SC");
        states.add("SD");
        states.add("TN");
        states.add("TX");
        states.add("UT");
        states.add("VT");
        states.add("VA");
        states.add("VI");
        states.add("WA");
        states.add("WV");
        states.add("WI");
        states.add("WY");
        return states;
    }
    @Override
    protected void addWidgets() {
         addField("street1", false, true, DataType.STRING_FIELD);
        addField("street2", false, false, DataType.STRING_FIELD);
        addField("city", false, true, DataType.STRING_FIELD);
        addField("state", false, true, DataType.ENUM_FIELD);
        addEnumField("state", false, true, getStates().toArray(new String[0]));
        addEnumField("country", false, true, getCountries().toArray(new String[0]));
        addField("zip", false, false, DataType.LONG_FIELD);
        addDropDown("addressType", new SelectAddressTypeWidget(false, false));
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
       
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "client/clientlocation/" + TreeClientPanel.instance().getEntityId();
    }
    
}
