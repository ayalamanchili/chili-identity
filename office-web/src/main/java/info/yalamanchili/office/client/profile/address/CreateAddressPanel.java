package info.yalamanchili.office.client.profile.address;

import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.profile.addresstype.SelectAddressTypeWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;

public class CreateAddressPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateAddressPanel.class.getName());

    public CreateAddressPanel(CreateCompositeType type) {
        super(type);
        initCreateComposite("Address", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        //TODO is thid needed
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
        // TODO Auto-generated method stub
    }

    @Override
    protected void addButtonClicked() {
        HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
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
        new ResponseStatusWidget().show("successfully added employee address");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllAddressesPanel(TreeEmployeePanel.instance().getEntityId()));
        TabPanel.instance().myOfficePanel.entityPanel.add(new AddressOptionsPanel());

    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
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
    protected void configure() {
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
        // TODO Auto-generated method stub
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/address/" + TreeEmployeePanel.instance().getEntityId();
    }
}
