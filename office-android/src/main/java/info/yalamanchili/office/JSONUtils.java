/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author ayalamanchili
 */
public class JSONUtils {

    public static String getString(JSONObject object, String property) {
        try {
            return object.getString(property);
        } catch (JSONException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static JSONObject getObject(String jsonResponse) {
        try {
            return new JSONObject(jsonResponse);
        } catch (JSONException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void putValue(JSONObject object, String propertyName, Object value) {
        try {
            object.put(propertyName, value);
        } catch (JSONException ex) {
            throw new RuntimeException(ex);
        }
    }
}
