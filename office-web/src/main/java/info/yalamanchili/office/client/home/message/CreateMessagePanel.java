/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.message;

import com.google.common.base.Splitter;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.MultiSelectSuggestBox;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class CreateMessagePanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateMessagePanel.class.getName());
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
            HttpService.HttpServiceAsync.instance().doGet(getNotoficationGroupDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                @Override
                public void onResponse(String entityString) {
                    Map<Integer, String> values = JSONUtils.convertKeyValuePairs(entityString);
                    if (values != null) {
                        suggestionsBox.loadData(values.values());
                    }
                }
            });
        }
    };

    public CreateMessagePanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("Message", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject msg = new JSONObject();
        assignEntityValueFromField("subject", msg);
        assignEntityValueFromField("message", msg);
        JSONArray tos = employeesSB.getValues();
        if (tos.size() > 0) {
            msg.put("tos", tos);
        }
        logger.info(msg.toString());
        return msg;
    }

    public static Iterable<String> splitString(String str) {
        return Splitter.on(" ").split(str);
    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
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
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Message Sent");
        TabPanel.instance().homePanel.entityPanel.clear();
        TabPanel.instance().homePanel.entityPanel.add(new MyMessagesPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        setButtonText("Send Message");
    }

    @Override
    protected void addWidgets() {
        entityFieldsPanel.add(employeesSB);
        addField("subject", false, true, DataType.STRING_FIELD);
        addField("message", false, false, DataType.RICH_TEXT_AREA);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "message";
    }

    protected String getEmployeeIdsDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/dropdown/0/10000?column=employeeId&column=firstName&column=lastName";
    }

    protected String getNotoficationGroupDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "notification/dropdown/0/10000?column=id&column=name";
    }
}
