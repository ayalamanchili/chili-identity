package info.chili.gwt.utils;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONUtils {

    public static String toString(JSONValue entity, String property) {
        if (entity != null && entity.isObject() != null && entity.isObject().get(property) != null && entity.isObject().get(property).isString() != null) {
            return entity.isObject().get(property).isString().stringValue();
        } else {
            return "";
        }
    }

    public static Boolean toBoolean(JSONValue entity, String property) {
        if ("true".equalsIgnoreCase(JSONUtils.toString(entity, property))) {
            return true;
        } else {
            return false;
        }
    }

    public static JSONArray toJSONArray(JSONValue jsonValue) {
        if (null == jsonValue) {
            return new JSONArray();
        }
        JSONArray array = jsonValue.isArray();
        if (array == null) {
            array = new JSONArray();
            array.set(0, jsonValue);
        }
        return array;
    }

    public static String getValueFromMap(JSONValue entity, String key) {
        JSONArray array = JSONUtils.toJSONArray(entity.isObject().get("entry"));
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).isObject().get("key") != null && array.get(i).isObject().get("key").isString().stringValue().equals(key) && array.get(i).isObject().get("value") != null) {
                return array.get(i).isObject().get("value").isString().stringValue();
            }
        }
        return "";
    }

    public static Map<String, String> convertKeyValueStringPairs(String jsonString) {
        if (jsonString != null && !jsonString.isEmpty()) {
            JSONObject listObject = JSONParser.parseLenient(jsonString).isObject();
            if (listObject != null && listObject.get("entry") != null) {
                JSONArray entities = JSONUtils.toJSONArray(listObject.get("entry"));
                return convertJSONArrayToKayValueStringMap(entities);
            }
        }
        return null;
    }

    public static Map<Integer, String> convertKeyValuePairs(String jsonString) {
        if (jsonString != null && !jsonString.isEmpty()) {
            JSONObject listObject = JSONParser.parseLenient(jsonString).isObject();
            if (listObject != null && listObject.get("entry") != null) {
                JSONArray entities = JSONUtils.toJSONArray(listObject.get("entry"));
                return convertJSONArrayToKayValueMap(entities);
            }
        }
        return null;
    }

    public static JSONArray convertFormProperties(String jsonString) {
        if (jsonString != null && !jsonString.isEmpty()) {
            JSONObject formPropertyObj = JSONParser.parseLenient(jsonString).isObject();
            return toJSONArray(formPropertyObj.get("formProperty"));
        }
        return null;
    }

    protected static Map<Integer, String> convertJSONArrayToKayValueMap(JSONArray entities) {
        Map<Integer, String> values = new HashMap<Integer, String>();
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            Integer key = Integer.valueOf(JSONUtils.toString(entity, "id"));
            String value = JSONUtils.toString(entity, "value");
            values.put(key, value);
        }
        return values;
    }

    protected static Map<String, String> convertJSONArrayToKayValueStringMap(JSONArray entities) {
        Map<String, String> values = new HashMap<String, String>();
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            String key = JSONUtils.toString(entity, "id");
            String value = JSONUtils.toString(entity, "value");
            values.put(key, value);
        }
        return values;
    }

    public static JSONArray toJSONArray(List<String> strs) {
        JSONArray res = new JSONArray();
        int i = 0;
        for (String str : strs) {
            res.set(i, new JSONString(str));
            i++;
        }
        return res;
    }

    public static JSONObject merge(JSONObject object1, JSONObject object2) {
        for (String key : object2.keySet()) {
            object1.put(key, object2.get(key));
        }
        return object1;
    }

    public static String formatEnumString(JSONObject entity, String propertyName) {
        return formatEnumString(JSONUtils.toString(entity, propertyName));
    }

    /**
     * converts All Caps string to regular string eg: MALE-->Male
     *
     * @param str eg: MALE
     * @return eg: Male
     */
    public static String formatEnumString(String str) {
        if (str != null && str.length() > 2) {
            return str.substring(0, 1).toUpperCase() + str.substring(1, str.length()).toLowerCase();
        } else {
            return str;
        }
    }
}
