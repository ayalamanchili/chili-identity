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
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.IndiaStatesFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.MultiSelectSuggestBox;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class CreateProspectPanel extends CreateComposite implements ChangeHandler, OpenHandler {

    private static Logger logger = Logger.getLogger(CreateProspectPanel.class.getName());
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "assignedTo", "Employee", false, false, Alignment.HORIZONTAL);
    SuggestBox caseManagerSB = new SuggestBox(OfficeWelcome.constants, "caseManager", "Employee", false, true, Alignment.HORIZONTAL);
    DisclosurePanel notifyOtherL = new DisclosurePanel("Notify Employees");
    FileuploadField resumeUploadPanel = new FileuploadField(OfficeWelcome.constants, "Prospect", "resumeURL", "Prospect/resumeURL", false, true) {
        @Override
        public void onUploadComplete(String res) {
            postCreateSuccess(res);
        }
    };

    public CreateProspectPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("Prospect", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        JSONObject address = new JSONObject();
        assignEntityValueFromField("firstName", entity);
        assignEntityValueFromField("middleInitial", entity);
        assignEntityValueFromField("lastName", entity);
        assignEntityValueFromField("referredBy", entity);
        assignEntityValueFromField("email", entity);
        assignEntityValueFromField("countryCode", entity);
        assignEntityValueFromField("phoneNumber", entity);
        assignEntityValueFromField("dateOfBirth", entity);
        assignEntityValueFromField("street1", address);
        assignEntityValueFromField("street2", address);
        assignEntityValueFromField("city", address);
        assignEntityValueFromField("country", address);
        assignEntityValueFromField("state", address);
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
        if (employeeSB.getSelectedObject() != null) {
            entity.put("assignedTo", employeeSB.getSelectedObject());
        }
        if (caseManagerSB.getSelectedObject() != null) {
            entity.put("caseManager", caseManagerSB.getSelectedObject());
        }
        assignEntityValueFromField("screenedBy", entity);
        assignEntityValueFromField("processDocSentDate", entity);
        assignEntityValueFromField("comment", entity);
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
        JSONArray resumeURL = new JSONArray();
        if (!resumeUploadPanel.isEmpty()) {
            int i = 0;
            for (FileUpload upload : resumeUploadPanel.getFileUploads()) {
                if (upload.getFilename() != null && !upload.getFilename().trim().isEmpty()) {
                    JSONObject resume = new JSONObject();
                    resume.put("fileURL", resumeUploadPanel.getFileName(upload));
                    resume.put("name", new JSONString("File Name"));
                    resumeURL.set(i, resume);
                    i++;
                }
            }
        }
        if (resumeURL.size() > 0) {
            entity.put("resumeURL", resumeURL);
        }
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        logger.info(getURI());
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
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
        entity = JSONParser.parseLenient(entityStr).isObject();
        if (!resumeUploadPanel.isEmpty()) {
            JSONObject post = (JSONObject) JSONParser.parseLenient(entityStr);
            JSONArray resumeURL = JSONUtils.toJSONArray(post.get("resumeURL"));
            resumeUploadPanel.upload(resumeURL, "fileURL");
        } else {
            postCreateSuccess(null);
        }
    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Prospect Created");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateProspectPanel(getEntityId()));
    }

    EnumField statesF;
    EnumField countriesF;

    @Override
    protected void addListeners() {
        if (countriesF != null) {
            countriesF.listBox.addChangeHandler(this);
        }
        notifyOtherL.addOpenHandler(this);
    }

    @Override
    protected void configure() {
        formatTextAreaFields();
        employeeSB.getLabel().getElement().getStyle().setWidth(193, Style.Unit.PX);
        HttpService.HttpServiceAsync.instance().doGet(getEmployeeIdsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    employeeSB.loadData(values);
                }
            }
        });
        caseManagerSB.getLabel().getElement().getStyle().setWidth(193, Style.Unit.PX);
        HttpService.HttpServiceAsync.instance().doGet(getcaseManagnerIdsDropDownUrl1(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    caseManagerSB.loadData(values);
                }
            }
        });
        HttpService.HttpServiceAsync.instance().doGet(getcaseManagnerIdsDropDownUrl2(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    caseManagerSB.loadData(values);
                }
            }
        });
    }

    protected void formatTextAreaFields() {
        for (Map.Entry entry : fields.entrySet()) {
            if (entry.getValue() instanceof TextAreaField) {
                TextAreaField textAreaField = (TextAreaField) entry.getValue();
                textAreaField.getTextbox().setCharacterWidth(75);
                textAreaField.getTextbox().setVisibleLines(4);
            }
        }
    }

    private String getcaseManagnerIdsDropDownUrl1() {
        return URL.encode(OfficeWelcome.constants.root_url() + "employee/employees-by-role/dropdown/" + Auth.ROLE.ROLE_H1B_IMMIGRATION + "/0/10000");
    }

    private String getcaseManagnerIdsDropDownUrl2() {
        return URL.encode(OfficeWelcome.constants.root_url() + "employee/employees-by-role/dropdown/" + Auth.ROLE.ROLE_GC_IMMIGRATION + "/0/10000");
    }

    private String getEmployeeIdsDropDownUrl() {
        return URL.encode(OfficeWelcome.constants.root_url() + "employee/employees-by-role/dropdown/" + Auth.ROLE.ROLE_RECRUITER + "/0/10000");
    }

    @Override
    protected void addWidgets() {
        addField("firstName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("middleInitial", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lastName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("referredBy", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("email", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("countryCode", false, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addField("phoneNumber", false, true, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addField("dateOfBirth", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("street1", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("street2", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("city", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("state", false, false, DataType.ENUM_FIELD, Alignment.HORIZONTAL);
        addEnumField("country", false, false, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addEnumField("state", false, false, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("zip", false, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addField("screenedBy", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(employeeSB);
        entityFieldsPanel.add(notifyOtherL);
        entityFieldsPanel.add(caseManagerSB);
        addField("processDocSentDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("comment", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Upload Resume"));
        entityFieldsPanel.add(resumeUploadPanel);
        statesF = (EnumField) fields.get("state");
        countriesF = (EnumField) fields.get("country");
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "prospect/save";
    }

    @Override
    public void onChange(ChangeEvent event) {
        switch (countriesF.getValue()) {
            case "USA":
                statesF.setValues(USAStatesFactory.getStates().toArray(new String[0]));
                break;
            case "INDIA":
                statesF.setValues(IndiaStatesFactory.getStates().toArray(new String[0]));
                break;
        }
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
       
        return true;
    }

    MultiSelectSuggestBox employeesSB = new MultiSelectSuggestBox() {
        @Override
        public void initTosSuggesBox() {
            HttpService.HttpServiceAsync.instance().doGet(getEmployeeIdsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
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
            FlowPanel panel = new FlowPanel();
            panel.add(employeesSB);
            entityFieldsPanel.insert(panel, entityFieldsPanel.getWidgetIndex(caseManagerSB));
        }
    }
}
