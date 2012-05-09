package info.yalamanchili.office.client.gwt;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class JSONUtils {
	public static String toString(JSONObject entity, String property) {
		if (entity.get(property) != null) {
			return entity.get(property).isString().stringValue();
		} else {
			return "";
		}
	}

	public static JSONArray toJSONArray(JSONValue jsonValue) {
		JSONArray array = jsonValue.isArray();
		if (array == null) {
			array = new JSONArray();
			array.set(0, jsonValue.isObject());
		}
		return array;
	}
}
