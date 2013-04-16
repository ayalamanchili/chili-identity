/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office;

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
}
