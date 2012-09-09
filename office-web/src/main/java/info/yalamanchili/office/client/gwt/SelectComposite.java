package info.yalamanchili.office.client.gwt;

import info.yalamanchili.gwt.utils.JSONUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

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

public abstract class SelectComposite extends BaseField implements ClickHandler, ChangeHandler {
    
    private static Logger logger = Logger.getLogger(SelectComposite.class.getName());
    protected ListBox listBox = new ListBox();
    protected Map<Integer, String> values;
    protected Map<Integer, JSONObject> entityMap = new HashMap<Integer, JSONObject>();
    protected String type = null;
    protected String attributeKey = null;
    protected JSONObject selectedObject = null;
    
    public SelectComposite(ConstantsWithLookup constants, String attributeName, String className, String attributeKey, Boolean readOnly, Boolean isRequired) {
        super(constants, attributeName, className, readOnly, isRequired);
        this.type = attributeName;
        this.attributeKey = attributeKey;
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
        if (listObject.get(type) != null) {
            JSONArray entities = JSONUtils.toJSONArray(listObject.get(type));
            values = populateValues(entities);
            for (int i = 1; i <= entities.size(); i++) {
                JSONObject entity = (JSONObject) entities.get(i - 1);
                Integer id = Integer.valueOf(JSONUtils.toString(entity, "id"));
                entityMap.put(id, entity);
            }
            // TODO see option to populate the drop down here by taking in the
            // attr names
            populateDropDown(values);
        }
    }
    
    public void setSelectedValue(JSONObject entity) {
        this.selectedObject = entity;
    }
    
    public void populateSelectedValue() {
        for (int i = 0; i < listBox.getItemCount(); i++) {
            if (listBox.getItemText(i) != null && listBox.getItemText(i).equalsIgnoreCase(JSONUtils.toString(selectedObject, attributeKey))) {
                listBox.setSelectedIndex(i);
            }
        }
    }
    
    protected abstract Map<Integer, String> populateValues(JSONArray entities);
    
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
    
    public String getAttributeKey() {
        return attributeKey;
    }
    
    public void setAttributeKey(String attributeKey) {
        this.attributeKey = attributeKey;
    }
    
    protected abstract String getDropDownURL(Integer start, Integer limit, String param1, String param2, String param3);
}
