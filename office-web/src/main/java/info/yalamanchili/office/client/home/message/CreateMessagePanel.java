/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.message;

import com.google.common.base.Splitter;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.GenericPopup;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class CreateMessagePanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateMessagePanel.class.getName());
    protected SuggestBox tosSuggestBox = new SuggestBox(constants, "tos", "Message", false, true);

    public CreateMessagePanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("Message", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject msg = new JSONObject();
        assignEntityValueFromField("subject", msg);
        assignEntityValueFromField("message", msg);
        assignEntityValueFromField("messageTs", msg);
        msg.put("tos", populateTos());
        logger.info(msg.toString());
        return msg;
    }

    protected JSONArray populateTos() {
        JSONArray array = new JSONArray();

        String tos = tosSuggestBox.getValue();
        int i = 0;
        for (String toStr : splitString(tos)) {
            if (!toStr.isEmpty()) {
                JSONObject to = new JSONObject();
                to.put("id", new JSONString(toStr));
                array.set(i, to);
            }
            i++;
        }
        return array;
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
        TabPanel.instance().homePanel.entityPanel.add(new ReadAllMessagePanel());
//        ReadAllMessagePanel.instance.refresh();
//        GenericPopup.instance().hide();
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        initTosSuggesBox();
    }

    @Override
    protected void addWidgets() {
        entityDisplayWidget.add(tosSuggestBox);
        addField("subject", false, true, DataType.STRING_FIELD);
        addField("message", false, true, DataType.STRING_FIELD);
        addField("messageTs", false, true, DataType.DATE_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "message";
    }

    protected void initTosSuggesBox() {
        HttpService.HttpServiceAsync.instance().doGet(getEmployeeIdsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                logger.info(entityString);
                Map<Integer, String> values = JSONUtils.convertKeyValuePairs(entityString);
                tosSuggestBox.loadData(values.values());
            }
        });
    }

    protected String getEmployeeIdsDropDownUrl() {
        //TODO think anout the limit
        return OfficeWelcome.constants.root_url() + "employee/dropdown/0/500?column=id&column=employeeId";
    }
}
