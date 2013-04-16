/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office;

import info.chili.android.commons.Base64;
import static info.yalamanchili.office.LoginActivity.preferences;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ayalamanchili
 */
public class OfficeConfig {

    public static String TAG = "office-android";
    public static String username;
    public static String password;
    public static String endpoint = null;
    public static String contextPath = null;
    public static Map<String, String> headers = null;

    public static String getBaseUrl() {
        return getEndpoint() + getContextRoot() + "secured/";
    }

    public static String getEndpoint() {
        endpoint = LoginActivity.preferences.getString("endpoint", "NA");
        return endpoint;
    }

    public static String getContextRoot() {
        if (contextPath == null) {
            contextPath = preferences.getString("contextPath", "NA");
        }
        return contextPath;
    }

    public static Map<String, String> getHeaders() {
        if (headers == null) {
            headers = new HashMap<String, String>();
            headers.put("Content-Type", "application/json");
            String userpass = username + ":" + password;
            headers.put("Authorization",
                    "Basic " + Base64.encodeBytes(userpass.getBytes()));
        }
        return headers;
    }
}
