/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.tasks;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.FloatField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.rpc.HttpService;
import info.yalamanchili.office.client.tae.timesheet.CurrentEmployeeTimeSummaryPanel;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class GenericTaskFormPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(GenericTaskFormPanel.class.getName());
    protected String taskId;
    protected JSONArray formProperties;

    public GenericTaskFormPanel(String taskId,JSONArray array) {
        super(CreateComposite.CreateCompositeType.CREATE);
        this.taskId=taskId;
        this.formProperties = array;
        initCreateComposite("Task", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        JSONArray vars = new JSONArray();
        int i = 0;
        for (String key : fields.keySet()) {
            JSONObject value = new JSONObject();
            value.put("id", new JSONString(key));
            //TODO currently support string and enum fields
            if (fields.get(key) instanceof StringField) {
                StringField stringField = (StringField) fields.get(key);
                value.put("value", new JSONString(stringField.getValue()));
            }
            if (fields.get(key) instanceof EnumField) {
                EnumField enumField = (EnumField) fields.get(key);
                value.put("value", new JSONString(enumField.getValue()));
            }
            vars.set(i, value);
            i++;
        }
        entity.put("entries", vars);
        logger.info("ddddw" + entity);
        return entity;
    }

    @Override
    protected void createButtonClicked() {
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
        new ResponseStatusWidget().show("Task Completed");
        TabPanel.instance().getHomePanel().entityPanel.clear();
        TabPanel.instance().getHomePanel().entityPanel.add(new ReadAllTasks());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        setButtonText("Complete Task");
    }

    @Override
    protected void addWidgets() {
        //TODO support more field types
        for (int i = 0; i < formProperties.size(); i++) {
            JSONObject formProperty = formProperties.get(i).isObject();
            if (JSONUtils.toString(formProperty.get("type").isObject(), "name").equals("string")) {
                addField(JSONUtils.toString(formProperty, "id"), false, true, DataType.STRING_FIELD);
            }
            if (JSONUtils.toString(formProperty.get("type").isObject(), "name").equals("enum")) {
                JSONObject type = formProperty.get("type").isObject();
                JSONArray enumArray = JSONUtils.toJSONArray(type.get("values"));
                String[] enumVals = new String[enumArray.size()];
                for (int y = 0; y < enumArray.size(); y++) {
                    JSONObject enm = enumArray.get(y).isObject();
                    enumVals[y] = JSONUtils.toString(enm, "id");
                }
                addEnumField(JSONUtils.toString(formProperty, "id"), false, true, enumVals);
            }
        }
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        //TODO add task name and description;
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "bpm/completetask/"+taskId;
    }
}
