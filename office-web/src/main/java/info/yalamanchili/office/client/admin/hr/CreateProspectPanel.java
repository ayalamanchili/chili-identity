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
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class CreateProspectPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateProspectPanel.class.getName());
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "screenedBy", "Employee", false, true);

    FileuploadField resumeUploadPanel = new FileuploadField(OfficeWelcome.constants, "Prospect", "resumeURL", "Prospect/resumeURL", true) {
        @Override
        public void onUploadComplete(String res) {
            postCreateSuccess(null);
        }
    };

    public CreateProspectPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("Prospect", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("firstName", entity);
        assignEntityValueFromField("lastName", entity);
        assignEntityValueFromField("referredBy", entity);
        assignEntityValueFromField("email", entity);
        assignEntityValueFromField("phoneNumber", entity);
        assignEntityValueFromField("screenedBy", entity);
        assignEntityValueFromField("processDocSentDate", entity);
        entity.put("resumeURL", resumeUploadPanel.getFileName());
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
                        postCreateSuccess(arg0);
                    }
                });
    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Prospect Created");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllProspectsPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        employeeSB.getLabel().getElement().getStyle().setWidth(145, Style.Unit.PX);
        HttpService.HttpServiceAsync.instance().doGet(getEmployeeIdsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                logger.info(entityString);
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    employeeSB.loadData(values);
                }
            }
        });
    }

    private String getEmployeeIdsDropDownUrl() {
        return URL.encode(OfficeWelcome.constants.root_url() + "employee/employees-by-type/dropdown/0/10000?column=id&column=firstName&column=lastName&employee-type=Corporate Employee&employee-type=Employee");
    }

    @Override
    protected void addWidgets() {
        addField("firstName", false, true, DataType.STRING_FIELD);
        addField("lastName", false, true, DataType.STRING_FIELD);
        addField("referredBy", false, true, DataType.STRING_FIELD);
        addField("email", false, false, DataType.STRING_FIELD);
        addField("phoneNumber", false, false, DataType.STRING_FIELD);
        addField("screenedBy", false, true, DataType.STRING_FIELD);
        addField("processDocSentDate", false, true, DataType.DATE_FIELD);
        entityFieldsPanel.add(resumeUploadPanel);

    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "prospect/save";
    }
    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
//        if (entity.get("screenedBy") == null) {
//            employeeSB.setMessage("Please choose a employee");
//            return false;
//        }
        if (resumeUploadPanel.isEmpty()) {
            resumeUploadPanel.setMessage("Please select a file");
            return false;
        }
        return true;
    }
}
