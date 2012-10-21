package info.yalamanchili.office.client.profile.cllientinfo;

import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.yalamanchili.office.client.TabPanel;

public class CreateClientInfoPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateClientInfoPanel.class.getName());

    public CreateClientInfoPanel(CreateCompositeType type) {
        super(type);
        initCreateComposite("ClientInfo", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject clientInfo = new JSONObject();
        assignEntityValueFromField("consultantJobTitle", clientInfo);
        assignEntityValueFromField("reportsToRole", clientInfo);
        assignEntityValueFromField("rtPrimary", clientInfo);
        assignEntityValueFromField("firstName", clientInfo);
        assignEntityValueFromField("middleInitial", clientInfo);
        assignEntityValueFromField("lastName", clientInfo);
        assignEntityValueFromField("phoneNumber", clientInfo);
        assignEntityValueFromField("email", clientInfo);
        return clientInfo;
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
        new ResponseStatusWidget().show("successfully added Reports To");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllClientInfoPanel(TreeEmployeePanel.instance().getEntityId()));
        TabPanel.instance().myOfficePanel.entityPanel.add(new ClientInfoOptionsPanel());
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
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/clientinformation/" + TreeEmployeePanel.instance().getEntityId();
    }
}
