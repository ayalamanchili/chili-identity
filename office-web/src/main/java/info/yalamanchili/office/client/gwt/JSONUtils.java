package info.yalamanchili.office.client.gwt;

import com.google.gwt.json.client.JSONObject;

public class JSONUtils {
	public static String toString(JSONObject entity, String property) {
		if (entity.get(property) != null) {
			return entity.get(property).isString().stringValue();
		} else {
			return "";
		}
	}
}
