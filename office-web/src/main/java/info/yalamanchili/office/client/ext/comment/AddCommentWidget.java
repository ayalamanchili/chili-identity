/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.ext.comment;

import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.MultiSelectSuggestBox;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class AddCommentWidget extends CreateComposite {

    private static Logger logger = Logger.getLogger(AddCommentWidget.class.getName());
    protected String targetClassName;
    protected String parentId;

    MultiSelectSuggestBox employeesSB = new MultiSelectSuggestBox() {
        @Override
        public void initTosSuggesBox() {
            HttpService.HttpServiceAsync.instance().doGet(getEmployeeIdsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                @Override
                public void onResponse(String entityString) {
                    logger.info(entityString);
                    Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                    if (values != null) {
                        suggestionsBox.loadData(values);
                    }
                }
            });
        }
    };

    protected String getEmployeeIdsDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/employees-by-type/dropdown/0/10000?column=employeeId&column=firstName&column=lastName&employee-type=Employee&employee-type=Corporate Employee";
    }

    public AddCommentWidget(String parentId, String targetClassName) {
        super(CreateCompositeType.ADD);
        this.parentId = parentId;
        this.targetClassName = targetClassName;
        initCreateComposite("Comment", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("comment", entity);
        entity.put("targetEntityName", new JSONString("targetEntityName"));
        entity.put("targetEntityId", new JSONString("0"));
        JSONArray notifyEmployeesList = employeesSB.getValues();
        if (notifyEmployeesList.size() > 0) {
            entity.put("notifyEmployees", notifyEmployeesList);
        }
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        // TODO Auto-generated method stub
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
        new ResponseStatusWidget().show("Successfully Added Comment");
        GenericPopup.instance().hide();
        if (ReadAllCommentsPanel.instance() != null) {
            ReadAllCommentsPanel.instance().preFetchTable(0);
        }
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void configure() {
        setButtonText("Save Comment and Send Notification");
        TextAreaField textAreaField = (TextAreaField) fields.get("comment");
        textAreaField.getTextbox().setCharacterWidth(75);
        textAreaField.getTextbox().setVisibleLines(4);
    }

    @Override
    protected void addWidgets() {
        addField("comment", false, true, DataType.TEXT_AREA_FIELD);
        entityFieldsPanel.add(getLineSeperatorTag("Add team members to be notified"));
        entityFieldsPanel.add(employeesSB);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "comment/" + targetClassName + "/" + parentId;
    }
    
    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        if (entity.get("comment") == null) {
            fields.get("comment").setMessage("Comments Can not be null");
            return false;
        }
        return true;
    }
}
