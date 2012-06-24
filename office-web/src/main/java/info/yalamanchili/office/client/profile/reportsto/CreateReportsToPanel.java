package info.yalamanchili.office.client.profile.reportsto;

import com.google.gwt.json.client.JSONArray;
import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class CreateReportsToPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateReportsToPanel.class.getName());

    public CreateReportsToPanel(CreateCompositeType type) {
        super(type);
        initCreateComposite("ReportsTo", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONArray phones = new JSONArray();
        JSONObject phone = new JSONObject();
        assignEntityValueFromField("phoneNumber", phone);
        phones.set(0, phone);
        JSONObject contact = new JSONObject();
        assignEntityValueFromField("firstName", contact);
        assignEntityValueFromField("middleInitial", contact);
        assignEntityValueFromField("lastName", contact);
        assignEntityValueFromField("sex", contact);
        contact.put("phones", phones);

        JSONObject reportsTo = new JSONObject();
        assignEntityValueFromField("reportsToRole", reportsTo);
        assignEntityValueFromField("rtPrimary", reportsTo);

        reportsTo.put("contact", contact);

        logger.info(reportsTo.toString());
        return reportsTo;
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
//        TabPanel.instance().myOfficePanel.clear();
//        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllReportsToPanel(TreeEmployeePanel.instance().getEntityId()));

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
        addField("reportsToRole", false, true, DataType.STRING_FIELD);
        addField("firstName", false, true, DataType.STRING_FIELD);
        addField("middleInitial", false, true, DataType.STRING_FIELD);
        addField("lastName", false, true, DataType.STRING_FIELD);
        String[] strs = {"MALE", "FEMALE"};
        addEnumField("sex", false, true, strs);
        addField("rtPrimary", false, true, DataType.BOOLEAN_FIELD);
        addField("phoneNumber", false, true, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/reportsto/" + TreeEmployeePanel.instance().getEntityId();
    }
}
