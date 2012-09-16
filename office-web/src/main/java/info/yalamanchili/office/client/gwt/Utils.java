/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.gwt;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.yalamanchili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class Utils {

    private static Logger logger = Logger.getLogger(Utils.class.getName());

    public static MultiSelectBox getMultiSelectBox(String name, String response) {
        Map<String, String> available = new HashMap<String, String>();
        Set<String> selected = new HashSet<String>();
        JSONObject multiSelectObj = (JSONObject) JSONParser.parseLenient(response);
        JSONArray availableArray = JSONUtils.toJSONArray(multiSelectObj.get("available").isObject().get("entry"));
        for (int i = 0; i < availableArray.size(); i++) {
            JSONObject availableEntry = (JSONObject) availableArray.get(i);
            available.put(JSONUtils.toString(availableEntry, "key"), JSONUtils.toString(availableEntry, "value"));
        }
        JSONArray selectedArray = JSONUtils.toJSONArray(multiSelectObj.get("selected"));
        for (int i = 0; i < selectedArray.size(); i++) {
            selected.add(selectedArray.get(i).isString().stringValue());
        }
        MultiSelectBox muitiSelectBox = new MultiSelectBox(name, available, selected);
        return muitiSelectBox;

    }
}
