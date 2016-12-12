/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.hr;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.IndiaStatesFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.fields.LongField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.FormatUtils;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.gwt.MultiSelectSuggestBox;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class UpdateProspectPanel extends UpdateComposite implements ClickHandler, ChangeHandler, OpenHandler, CloseHandler, BlurHandler {

    private Logger logger = Logger.getLogger(UpdateProspectPanel.class.getName());
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "assignedTo", "Employee", false, true, Alignment.HORIZONTAL);
    SuggestBox caseManagerSB = new SuggestBox(OfficeWelcome.constants, "caseManager", "Employee", false, false, Alignment.HORIZONTAL);
    SuggestBox screenedBySB = new SuggestBox(OfficeWelcome.constants, "screenedBy", "Prospect", false, false, Alignment.HORIZONTAL);
    protected SelectCompanyWidget selectCompnayWidget = new SelectCompanyWidget(false, true, Alignment.HORIZONTAL);
    DisclosurePanel notifyOtherL = new DisclosurePanel("Notify Employees");
    FlowPanel panel = new FlowPanel();
    LongField phoneField = new LongField(OfficeWelcome.constants, "phoneNumber", "Prospect", false, true, Alignment.HORIZONTAL);
    FileuploadField resumeUploadPanel = new FileuploadField(OfficeWelcome.constants, "Prospect", "resumeURL", "Prospect/resumeURL", false, true) {
        @Override
        public void onUploadComplete(String res) {
            postUpdateSuccess(null);
        }
    };
    JSONArray resumeURL = new JSONArray();

    protected static UpdateProspectPanel instance;

    public static UpdateProspectPanel instance() {
        return instance;
    }

    public UpdateProspectPanel(JSONObject entity) {
        instance = this;
        initUpdateComposite(entity, "Prospect", OfficeWelcome.constants2);
    }

    public UpdateProspectPanel(String id) {
        instance = this;
        initUpdateComposite(id, "Prospect", OfficeWelcome.constants2);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        logger.info(response);
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        if (entity.get("id") != null) {
                            entityFieldsPanel.add(getLineSeperatorTag("Status Information"));
                            addEnumField("status", false, false, ProspectStatus.validStatusFor(ProspectStatus.valueOf(entity.get("status").isString().stringValue())), Alignment.HORIZONTAL);
                            statusField = (EnumField) fields.get("status");
                            statusField.listBox.addChangeHandler(instance);
                            alignFields();
                            if (ProspectStatus.CLOSED_WON.name().equals(JSONUtils.toString(getEntity(), "status"))) {
                                addProspectWonFields();
                            }
                        }
                        populateFieldsFromEntity(entity);
                        populateComments();
                    }
                }
        );
    }

    protected void populateComments() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PROSPECTS_MANAGER)) {
            entityActionsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.hr.Prospect"));
        }
    }

    protected String getReadURI() {
        return OfficeWelcome.constants.root_url() + "prospect/" + entityId;
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject address = new JSONObject();
        if (employeeSB.getSelectedObject() != null) {
            entity.put("assignedTo", employeeSB.getSelectedObject());
        }
        if (caseManagerSB.getSelectedObject() != null) {
            entity.put("caseManager", caseManagerSB.getSelectedObject());
        }
        assignEntityValueFromField("street1", address);
        assignEntityValueFromField("street2", address);
        assignEntityValueFromField("city", address);
        assignEntityValueFromField("state", address);
        assignEntityValueFromField("country", address);
        assignEntityValueFromField("zip", address);
        if (address.size() > 0) {
            StringField street1F = (StringField) fields.get("street1");
            if (street1F.getValue() == null || street1F.getValue().isEmpty()) {
                street1F.setValue("TBD");
                assignEntityValueFromField("street1", address);
            }
            StringField cityF = (StringField) fields.get("city");
            if (cityF.getValue() == null || cityF.getValue().isEmpty()) {
                cityF.setValue("TBD");
                assignEntityValueFromField("city", address);
            }
            EnumField countryF = (EnumField) fields.get("country");
            if (countryF.getValue() == null || countryF.getValue().isEmpty()) {
                countriesF.selectValue("USA");
                assignEntityValueFromField("country", address);
            }
            EnumField stateF = (EnumField) fields.get("state");
            if (stateF.getValue() == null || stateF.getValue().isEmpty()) {
                statesF.selectValue("FL");
                assignEntityValueFromField("state", address);
            }
            entity.put("address", address);
        }
        assignEntityValueFromField("firstName", entity);
        assignEntityValueFromField("middleInitial", entity);
        assignEntityValueFromField("lastName", entity);
        assignEntityValueFromField("email", entity);
        assignEntityValueFromField("countryCode", entity);
        String phoneNumber1 = phoneField.getValue();
        String phoneNumber = phoneNumber1.replaceAll("-", "");
        phoneField.setValue(phoneNumber);
        entity.put("phoneNumber", new JSONString(phoneField.getValue()));
        assignEntityValueFromField("dateOfBirth", entity);
        assignEntityValueFromField("referredBy", entity);
        if (screenedBySB.getSelectedObject() != null) {
            entity.put("screenedBy", new JSONString(screenedBySB.getSuggestBox().getValue()));
        } else {
            entity.put("screenedBy", null);
        }
        assignEntityValueFromField("processDocSentDate", entity);
        assignEntityValueFromField("status", entity);
        assignEntityValueFromField("comment", entity);
        if (fields.containsKey("petitionFiledFor")) {
            assignEntityValueFromField("petitionFiledFor", entity);
        }
        if (fields.containsKey("trfEmpType")) {
            assignEntityValueFromField("trfEmpType", entity);
        }
        if (fields.containsKey("placedBy")) {
            assignEntityValueFromField("placedBy", entity);
        }
        if (fields.containsKey("dateOfJoining")) {
            assignEntityValueFromField("dateOfJoining", entity);
        }
        if (fields.containsKey("company") && selectCompnayWidget.getSelectedObject() != null) {
            JSONObject company = selectCompnayWidget.getSelectedObject();
            company.put("name", company.get("value"));
            entity.put("company", company);
        }
        if (employeesSB.getValues().size() > 0) {
            List<String> emps = new ArrayList();
            JSONArray employees = employeesSB.getValues();
            for (int i = 0; i < employees.size(); i++) {
                JSONObject obj = employees.get(i).isObject();
                emps.add(obj.get("id").isString().stringValue());
            }
            JSONArray finalemps = new JSONArray();
            for (int i = 0; i < emps.size(); i++) {
                finalemps.set(i, new JSONString(emps.get(i)));
            }
            entity.put("employees", finalemps);
        }
        int j = resumeURL.size();
        for (JSONString fileName : resumeUploadPanel.getFileNames()) {
            if (fileName != null && !fileName.stringValue().trim().isEmpty()) {
                JSONObject resume = new JSONObject();
                resume.put("fileURL", fileName);
                resume.put("name", new JSONString("File Name"));
                resumeURL.set(j, resume);
                j++;
            }
        }
        if (resumeURL.size() > 0) {
            entity.put("resumeURL", resumeURL);
        }
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        uploadResume(arg0);
                    }
                });
    }

    protected void uploadResume(String entityStr) {
        JSONObject post = (JSONObject) JSONParser.parseLenient(entityStr);
        JSONArray resumeURL = JSONUtils.toJSONArray(post.get("resumeURL"));
        resumeUploadPanel.upload(resumeURL, "fileURL");
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        JSONObject emp = (JSONObject) entity.get("assignedTo");
        if (emp != null) {
            employeeSB.setValue(emp.get("firstName").isString().stringValue());
        }
        JSONObject employee = (JSONObject) entity.get("caseManager");
        if (employee != null) {
            caseManagerSB.setValue(employee.get("firstName").isString().stringValue());
        }

        if (entity.get("address") != null) {
            JSONObject address = entity.get("address").isObject();
            assignFieldValueFromEntity("street1", address, DataType.STRING_FIELD);
            assignFieldValueFromEntity("street2", address, DataType.STRING_FIELD);
            assignFieldValueFromEntity("city", address, DataType.STRING_FIELD);
            assignFieldValueFromEntity("country", address, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("state", address, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("zip", address, DataType.LONG_FIELD);
        }
        assignFieldValueFromEntity("firstName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("middleInitial", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lastName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("email", entity, DataType.STRING_FIELD);
        String phoneNumber = FormatUtils.formatPhoneNumber(entity.get("phoneNumber").isString().stringValue());
        entity.put("phoneNumber", new JSONString(phoneNumber));
        phoneField.setValue(phoneNumber);
        assignFieldValueFromEntity("countryCode", entity, DataType.LONG_FIELD);
        assignFieldValueFromEntity("dateOfBirth", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("referredBy", entity, DataType.STRING_FIELD);
        if (entity.get("screenedBy") != null) {
            screenedBySB.setValue(entity.get("screenedBy").isString().stringValue());
        }
        assignFieldValueFromEntity("processDocSentDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("comment", entity, DataType.TEXT_AREA_FIELD);
        if (entity.get("id") != null) {
            assignFieldValueFromEntity("status", entity, DataType.ENUM_FIELD);
        }
        if (ProspectStatus.CLOSED_WON.name().equals(JSONUtils.toString(getEntity(), "status"))) {
            assignFieldValueFromEntity("petitionFiledFor", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("trfEmpType", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("placedBy", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("dateOfJoining", entity, DataType.DATE_FIELD);
            assignFieldValueFromEntity("company", entity, null);
        }
        resumeURL = JSONUtils.toJSONArray(entity.get("resumeURL"));
        if (resumeURL.size() > 0) {
            populateResumes(resumeURL);
        }
        phoneField.setValue(entity.get("phoneNumber").isString().stringValue());
    }

    protected void populateResumes(JSONArray items) {
        entityFieldsPanel.insert(new ReadAllResumePanel(items), entityFieldsPanel.getWidgetIndex(resumeUploadPanel) + 1);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Prospect Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateProspectPanel(getEntityId()));
    }

    EnumField statesF;
    EnumField countriesF;

    @Override
    protected void addListeners() {
        phoneField.getTextbox().addBlurHandler(this);
        statesF.listBox.addChangeHandler(this);
        notifyOtherL.addOpenHandler(this);
        notifyOtherL.addCloseHandler(this);
    }

    @Override
    protected void configure() {
        countriesF.listBox.addChangeHandler(this);
        formatTextAreaFields();
        notifyOtherL.setOpen(true);
        panel.clear();
        panel.add(employeesSB);
        entityFieldsPanel.insert(panel, entityFieldsPanel.getWidgetIndex(caseManagerSB));
        employeeSB.getLabel().getElement().getStyle().setWidth(197, Style.Unit.PX);
        HttpService.HttpServiceAsync.instance().doGet(getEmployeeIdsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    employeeSB.loadData(values);
                    caseManagerSB.loadData(values);
                    screenedBySB.loadData(values);
                }
            }
        });
    }

    private String getEmployeeIdsDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/employees-by-role/dropdown/" + Auth.ROLE.ROLE_CORPORATE_EMPLOYEE + "/0/10000";
    }

    protected String getNotifyEmployeesDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/employees-by-type/dropdown/0/10000?column=id&column=firstName&column=lastName&employee-type=Corporate Employee";
    }

    protected void formatTextAreaFields() {
        for (Map.Entry entry : fields.entrySet()) {
            if (entry.getValue() instanceof TextAreaField) {
                TextAreaField textAreaField = (TextAreaField) entry.getValue();
                textAreaField.getTextbox().setCharacterWidth(75);
                textAreaField.getTextbox().setVisibleLines(6);
            }
        }
    }

    EnumField statusField;

    @Override
    protected void addWidgets() {
        addField("firstName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("middleInitial", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lastName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("email", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("countryCode", false, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(phoneField);
        addField("dateOfBirth", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("street1", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("street2", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("city", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("country", false, false, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addEnumField("state", false, false, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("zip", false, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addField("referredBy", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(employeeSB);
        entityFieldsPanel.add(notifyOtherL);
        entityFieldsPanel.add(caseManagerSB);
        entityFieldsPanel.add(screenedBySB);
        addField("processDocSentDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("comment", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Upload Resume"));
        entityFieldsPanel.add(resumeUploadPanel);
        statesF = (EnumField) fields.get("state");
        countriesF = (EnumField) fields.get("country");
        alignFields();
    }

    protected void addProspectWonFields() {
        if (!fields.containsKey("petitionFiledFor")) {
            addDropDown("company", selectCompnayWidget);
            addEnumField("petitionFiledFor", false, false, PetitionFor.names(), Alignment.HORIZONTAL);
            addEnumField("trfEmpType", false, false, TransferEmployeeType.names(), Alignment.HORIZONTAL);
            addEnumField("placedBy", false, false, PlacedBy.names(), Alignment.HORIZONTAL);
            addField("dateOfJoining", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
            alignFields();
        }
    }

    protected void removeProspectWonFields() {
        if (fields.containsKey("petitionFiledFor")) {
            fields.get("petitionFiledFor").removeFromParent();
            fields.remove("petitionFiledFor");
        }
        if (fields.containsKey("trfEmpType")) {
            fields.get("trfEmpType").removeFromParent();
            fields.remove("trfEmpType");
        }
        if (fields.containsKey("placedBy")) {
            fields.get("placedBy").removeFromParent();
            fields.remove("placedBy");
        }
        if (fields.containsKey("dateOfJoining")) {
            fields.get("dateOfJoining").removeFromParent();
            fields.remove("dateOfJoining");
        }
        if (fields.containsKey("company")) {
            fields.get("company").removeFromParent();
            fields.remove("company");
        }
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        if (!getEntityId().isEmpty()) {
            if (screenedBySB.getKey() != null) {
                return OfficeWelcome.constants.root_url() + "prospect/update?screenedById=" + screenedBySB.getKey();
            } else {
                return OfficeWelcome.constants.root_url() + "prospect/update";
            }
        } else {
            return OfficeWelcome.constants.root_url() + "prospect/save";
        }
    }

    @Override
    public void onChange(ChangeEvent event) {
        if (event.getSource().equals(countriesF.listBox)) {
            switch (countriesF.getValue()) {
                case "USA":
                    statesF.setValues(USAStatesFactory.getStates().toArray(new String[0]));
                    break;
                case "INDIA":
                    statesF.setValues(IndiaStatesFactory.getStates().toArray(new String[0]));
                    break;
            }
        } else if (event.getSource().equals(statusField.listBox)) {
            if (statusField.getValue().equals(ProspectStatus.CLOSED_WON.name())) {
                addProspectWonFields();
            } else {
                removeProspectWonFields();
            }
        }
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        if (entity.get("comment") == null) {
            fields.get("comment").setMessage("Comment Can not be null");
            return false;
        }

        if (entity.get("status").isString().stringValue().equals(ProspectStatus.IN_PROGRESS.name()) && entity.get("assignedTo") != null) {
            JSONObject assignedTo = entity.get("assignedTo").isObject();
            if (ProspectStatus.RECRUITING.name().equals(entity.get("status").isString().stringValue()) && (assignedTo.containsKey("firstName") && (assignedTo.get("firstName") == null))) {
                employeeSB.setMessage("Assigned To Can not be null");
                return false;
            }
        } else if (entity.get("status").isString().stringValue().equals(ProspectStatus.IN_PROGRESS.name()) && employeeSB.getSelectedObject() == null) {
            return true;
        } else if ((!entity.get("status").isString().stringValue().equals(ProspectStatus.IN_PROGRESS.name())) && entity.containsKey("assignedTo") == false) {
            logger.info("no assigned to");
            employeeSB.setMessage("Assigned To Can not be null");
            return false;
        }
//
//        if (entity.get("caseManager") != null) {
//            JSONObject caseManager = entity.get("caseManager").isObject();
//            if (caseManager.containsKey("firstName") && (caseManager.get("firstName") == null)) {
//                caseManagerSB.setMessage("Case Manager Can not be null");
//                return false;
//            }
//        } else if (caseManagerSB.getSelectedObject() == null) {
//            caseManagerSB.setMessage("Case Manager Can not be null");
//            return false;
//        }

        if (ProspectStatus.CLOSED_WON.name().equals(entity.get("status").isString().stringValue()) && selectCompnayWidget.getSelectedObject() == null) {
            selectCompnayWidget.setMessage("Company Can not be null");
            return false;
        }
        return true;
    }

    MultiSelectSuggestBox employeesSB = new MultiSelectSuggestBox() {
        @Override
        public void initTosSuggesBox() {
            HttpService.HttpServiceAsync.instance().doGet(getNotifyEmployeesDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                @Override
                public void onResponse(String entityString) {
                    Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                    if (values != null) {
                        suggestionsBox.loadData(values);
                    }
                }
            });
        }
    };

    @Override
    public void onOpen(OpenEvent event) {
        if (event.getSource().equals(notifyOtherL)) {
            panel.add(employeesSB);
            entityFieldsPanel.insert(panel, entityFieldsPanel.getWidgetIndex(caseManagerSB));
        }
    }

    @Override
    public void onClose(CloseEvent event) {
        if (event.getSource().equals(notifyOtherL)) {
            panel.clear();
        }
    }

    @Override
    public void onBlur(BlurEvent event) {
        String input = phoneField.getValue();
        String output = input.replaceAll("(\\d{3})(\\d{3})(\\d{4})", "$1-$2-$3");
        phoneField.setValue(output);
        String newPhone = input.replaceAll("-", "");
        if (newPhone.length() != 10 && input.matches("[0-9\\-]*")) {
            phoneField.setMessage("Phone Number Length Should be 10");
        } else if (!input.matches("[0-9\\-]*")) {
            phoneField.setMessage("Invalid Value");
        }
    }
}
