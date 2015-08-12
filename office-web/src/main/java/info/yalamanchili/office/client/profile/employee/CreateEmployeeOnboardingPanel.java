/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.profile.contact.Branch;
import info.yalamanchili.office.client.profile.contact.Sex;
import info.yalamanchili.office.client.profile.contact.WorkStatus;
import info.yalamanchili.office.client.profile.employeetype.SelectEmployeeTypeWidget;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class CreateEmployeeOnboardingPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateEmployeePanel.class.getName());
    protected SelectCompanyWidget selectCompnayWidget = new SelectCompanyWidget(false, true, Alignment.HORIZONTAL);
    FileuploadField empImageUploadPanel = new FileuploadField(OfficeWelcome.constants, "Employee", "imageUrl", "Employee/imageURL", false) {
        @Override
        public void onUploadComplete(String res) {
            postCreateSuccess(null);
        }
    };
    
    HTML emptyLine = new HTML("<br/>");

    public CreateEmployeeOnboardingPanel(CreateCompositeType type) {
        super(type);
        initCreateComposite("Employee", OfficeWelcome.constants);
    }

    @Override
    public JSONObject populateEntityFromFields() {
        JSONObject employee = new JSONObject();
        JSONObject address = new JSONObject();
        employee.put("passwordHash", new JSONString("123456"));
        assignEntityValueFromField("firstName", employee);
        assignEntityValueFromField("middleInitial", employee);
        assignEntityValueFromField("lastName", employee);
        assignEntityValueFromField("dateOfBirth", employee);
        assignEntityValueFromField("email", employee);
        assignEntityValueFromField("sex", employee);
        assignEntityValueFromField("startDate", employee);
        assignEntityValueFromField("employeeType", employee);
        assignEntityValueFromField("jobTitle", employee);
        assignEntityValueFromField("branch", employee);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            assignEntityValueFromField("workStatus", employee);
        }
        if (fields.containsKey("company") && selectCompnayWidget.getSelectedObject() != null) {
            JSONObject company = selectCompnayWidget.getSelectedObject();
            company.put("name", company.get("value"));
            employee.put("company", company);
        }
        if (Auth.isAdmin()) {
            assignEntityValueFromField("ssn", employee);
        }
        employee.put("imageURL", empImageUploadPanel.getFileName());
        
        assignEntityValueFromField("street1", address);
        assignEntityValueFromField("street2", address);
        assignEntityValueFromField("city", address);
        assignEntityValueFromField("state", address);
        assignEntityValueFromField("country", address);
        assignEntityValueFromField("zip", address);
        employee.put("address", address);
        logger.info("employee" + employee.toString());
        return employee;
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
        addDropDown("employeeType", new SelectEmployeeTypeWidget(false, true));
        addField("firstName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("middleInitial", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lastName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("email", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dateOfBirth", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("sex", false, true, Sex.names(), Alignment.HORIZONTAL);
        addField("startDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("jobTitle", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("branch", false, true, Branch.names(), Alignment.HORIZONTAL);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            addEnumField("workStatus", false, true, WorkStatus.names(), Alignment.HORIZONTAL);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR_ADMINSTRATION, Auth.ROLE.ROLE_RELATIONSHIP, Auth.ROLE.ROLE_HR)) {
            addDropDown("company", selectCompnayWidget);
        }
        if (Auth.isAdmin()) {
            addField("ssn", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        }
        addField("street1", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("street2", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("city", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("state", false, true, DataType.ENUM_FIELD, Alignment.HORIZONTAL);
        addEnumField("country", false, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addEnumField("state", false, true, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("zip", false, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(emptyLine);
        entityFieldsPanel.add(empImageUploadPanel);
        entityFieldsPanel.add(emptyLine);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    public void createButtonClicked() {
        logger.info("entity details:" + entity.toString());
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        uploadImage(arg0);
                    }
                });
    }

    protected void uploadImage(String entityId) {
        empImageUploadPanel.upload(entityId.trim());
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Created Employee");
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
    protected boolean showDocumentationLink() {
        return true;
    }

    @Override
    protected String getDocumentationLink() {
        return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "employee.html";
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "admin/onBoardEmployee";
    }

}
