package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.gwt.fields.StringField;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.FileUploadPanel;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.yalamanchili.gwt.utils.JSONUtils;

public class CreateEmployeePanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateEmployeePanel.class.getName());
    FileUploadPanel empImageUploadPanel = new FileUploadPanel("Profile Picture", "Employee/imageURL");

    public CreateEmployeePanel(CreateCompositeType type) {
        super(type);
        initCreateComposite("Employee", OfficeWelcome.constants);
    }

    @Override
    public JSONObject populateEntityFromFields() {
        JSONObject user = new JSONObject();
        assignEntityValueFromField("username", user);
        assignEntityValueFromField("passwordHash", user);

        JSONObject employee = new JSONObject();
        assignEntityValueFromField("firstName", employee);
        assignEntityValueFromField("middleInitial", employee);
        assignEntityValueFromField("lastName", employee);
        assignEntityValueFromField("dateOfBirth", employee);
        assignEntityValueFromField("sex", employee);
        assignEntityValueFromField("startDate", employee);
        employee.put("imageURL", empImageUploadPanel.getFileName());
        user.put("employee", employee);
        return user;
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
        addField("username", false, true, DataType.STRING_FIELD);
        addField("passwordHash", false, true, DataType.PASSWORD_FIELD);
        addField("firstName", false, true, DataType.STRING_FIELD);
        addField("middleInitial", false, false, DataType.STRING_FIELD);
        addField("lastName", false, true, DataType.STRING_FIELD);
        addField("dateOfBirth", false, false, DataType.DATE_FIELD);
        String[] strs = {"MALE", "FEMALE"};
        addEnumField("sex", false, true, strs);
        addField("startDate", false, false, DataType.DATE_FIELD);
        entityDisplayWidget.add(empImageUploadPanel);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    public void createButtonClicked() {
        HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postCreateSuccess(arg0);
                        uploadImage(arg0);
                    }
                });

    }

    protected void uploadImage(String entityId) {
        empImageUploadPanel.upload(entityId.trim());
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("successfully created employee");
        TabPanel.instance().myOfficePanel.sidePanelTop.clear();
        TabPanel.instance().myOfficePanel.sidePanelTop.add(new EmployeeSidePanel());
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmployeesPanel());

    }

    @Override
    protected void addButtonClicked() {
        // TODO Auto-generated method stub
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "admin/createuser";
    }
}
