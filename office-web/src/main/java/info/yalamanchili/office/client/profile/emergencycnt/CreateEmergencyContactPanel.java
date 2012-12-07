package info.yalamanchili.office.client.profile.emergencycnt;

import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class CreateEmergencyContactPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateEmergencyContactPanel.class.getName());

    public CreateEmergencyContactPanel(CreateCompositeType type) {
        super(type);
        initCreateComposite("EmergencyContact", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject emergencyCnt = new JSONObject();
        assignEntityValueFromField("firstName", emergencyCnt);
        assignEntityValueFromField("middleInitial", emergencyCnt);
        assignEntityValueFromField("lastName", emergencyCnt);
        assignEntityValueFromField("sex", emergencyCnt);
        assignEntityValueFromField("relation", emergencyCnt);
        assignEntityValueFromField("ecPrimary", emergencyCnt);
        assignEntityValueFromField("email", emergencyCnt);
        assignEntityValueFromField("countryCode", emergencyCnt);
        assignEntityValueFromField("phoneNumber", emergencyCnt);
        assignEntityValueFromField("extension", emergencyCnt);
        logger.info(emergencyCnt.toString());
        return emergencyCnt;
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
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("successfully added Emergency Contact");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmergencyContactsPanel(
                TreeEmployeePanel.instance().getEntityId()));
        TabPanel.instance().myOfficePanel.entityPanel.add(new EmergencyContactOptionsPanel());

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
        addField("firstName", false, true, DataType.STRING_FIELD);
        addField("middleInitial", false, false, DataType.STRING_FIELD);
        addField("lastName", false, true, DataType.STRING_FIELD);
        String[] strs = {"MALE", "FEMALE"};
        addEnumField("sex", false, false, strs);
        addField("relation", false, true, DataType.STRING_FIELD);
        addField("ecPrimary", false, false, DataType.BOOLEAN_FIELD);
        addField("email", false, false, DataType.STRING_FIELD);
        addField("countryCode", false, true, DataType.STRING_FIELD);
        addField("phoneNumber", false, true, DataType.LONG_FIELD);
        addField("extension", false, true, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/emergencycontact/"
                + TreeEmployeePanel.instance().getEntityId();
    }
}
