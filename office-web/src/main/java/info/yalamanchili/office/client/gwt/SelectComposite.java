package info.yalamanchili.office.client.gwt;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.ListBox;
import info.yalamanchili.gwt.composite.BaseField;
import info.yalamanchili.gwt.utils.JSONUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public abstract class SelectComposite extends BaseField implements ClickHandler, ChangeHandler {

    private static Logger logger = Logger.getLogger(SelectComposite.class.getName());
    protected ListBox listBox = new ListBox();
    protected Map<Integer, String> values;
    protected Map<Integer, JSONObject> entityMap = new HashMap<Integer, JSONObject>();
    protected JSONObject selectedObject = null;

    public SelectComposite(ConstantsWithLookup constants, String className, Boolean readOnly, Boolean isRequired) {
        super(constants, info.yalamanchili.gwt.utils.Utils.getStringCamelCase(className), className, readOnly, isRequired);
        configureAddMainWidget();
        setReadOnly(readOnly);
        fetchDropDownData();
    }

    @Override
    protected void configureAddMainWidget() {
        listBox.insertItem("SELECT", 0);
        listBox.ensureDebugId(className + "_" + attributeName + "_LB");
        fieldPanel.insert(listBox, 0);
    }

    public void setReadOnly(Boolean readOnly) {
        listBox.setEnabled(!readOnly);
    }

    protected abstract void fetchDropDownData();

    protected void processData(String listString) {
        JSONObject listObject = (JSONObject) JSONParser.parseLenient(listString);
        if (listObject.get("entry") != null) {
            JSONArray entities = JSONUtils.toJSONArray(listObject.get("entry"));
            values = populateValues(entities);
            for (int i = 1; i <= entities.size(); i++) {
                JSONObject entity = (JSONObject) entities.get(i - 1);
                Integer key = Integer.valueOf(JSONUtils.toString(entity, "id"));
                entityMap.put(key, entity);
            }
            // TODO see option to populate the drop down here by taking in the
            // attr names
            populateDropDown(values);
        }
    }

    protected Map<Integer, String> populateValues(JSONArray entities) {
        Map<Integer, String> values = new HashMap<Integer, String>();
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            Integer key = Integer.valueOf(JSONUtils.toString(entity, "id"));
            String value = JSONUtils.toString(entity, "value");
            values.put(key, value);
        }
        return values;
    }

    public void setSelectedValue(JSONObject entity) {
        this.selectedObject = entity;
    }

    public void populateSelectedValue() {
        for (int i = 0; i < listBox.getItemCount(); i++) {
            if (listBox.getItemText(i) != null && listBox.getItemText(i).equalsIgnoreCase(JSONUtils.toString(selectedObject, "value"))) {
                listBox.setSelectedIndex(i);
            }
        }
    }

    protected void populateDropDown(Map<Integer, String> values) {
        int i = 1;
        for (Integer key : values.keySet()) {
            listBox.insertItem(values.get(key), key.toString(), i);
            i++;
        }
        if (selectedObject != null) {
            populateSelectedValue();
        }
    }

    @Override
    public void onChange(ChangeEvent arg0) {
    }

    @Override
    public void onClick(ClickEvent arg0) {
        // TODO Auto-generated method stub
    }

    public ListBox getListBox() {
        return listBox;
    }

    public JSONObject getSelectedObject() {
        if (listBox.getSelectedIndex() > 0) {
            Integer entityId = Integer.valueOf(listBox.getValue(listBox.getSelectedIndex()));
            return entityMap.get(entityId);
        } else {
            return null;
        }
    }

    protected abstract String getDropDownURL(Integer start, Integer limit, String... columns);

    protected String generateDropdownUrl(String url, Integer start, Integer limit, String... columns) {
        url = url + "/" + start.toString() + "/" + limit.toString() + "?";
        for (String column : columns) {
            url = url.concat("column=" + column + "&");
        }
        return url;
    }
}
