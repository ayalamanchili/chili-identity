package info.yalamanchili.office.client.gwt;

import info.yalamanchili.gwt.composite.ALComposite;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;

public abstract class SelectComposite extends ALComposite implements ClickHandler, ChangeHandler {

    private static Logger logger = Logger.getLogger(SelectComposite.class.getName());
    FlowPanel panel = new FlowPanel();
    protected Label label = new Label();
    protected ListBox listBox = new ListBox();
    protected Map<Integer, String> values;
    protected Map<Integer, JSONObject> entityMap = new HashMap<Integer, JSONObject>();
    protected String type = null;

    public SelectComposite(String name, String type) {
        label.setText(name);
        this.type = type;
        init(panel);
        fetchDropDownData();
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

    protected abstract Map<Integer, String> populateValues(JSONArray entities);

    protected void populateDropDown(Map<Integer, String> values) {
        listBox.insertItem("SELECT", "", 0);
        int i = 1;
        for (Integer key : values.keySet()) {
            listBox.insertItem(values.get(key), key.toString(), i);
            i++;
        }
    }

    @Override
    protected void addListeners() {
        listBox.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        panel.add(label);
        panel.add(listBox);
    }

    @Override
    public void onChange(ChangeEvent arg0) {
    }

    @Override
    public void onClick(ClickEvent arg0) {
        // TODO Auto-generated method stub
    }

    public JSONObject getSelectedObject() {
        if (listBox.getSelectedIndex() > 0) {
            Integer entityId = Integer.valueOf(listBox.getValue(listBox.getSelectedIndex()));
            return entityMap.get(entityId);
        } else {
            return null;
        }
    }

    protected abstract String getDropDownURL(Integer start, Integer limit, String param1, String param2, String param3);
}
