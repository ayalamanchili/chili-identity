/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client;

import com.google.gwt.user.client.Window;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class URLParamProcessor {

    private static Logger logger = Logger.getLogger(URLParamProcessor.class.getName());

    public static boolean process() {
        Map<String, List<String>> map = Window.Location.getParameterMap();
        for (Entry e : map.entrySet()) {
            String key = (String) e.getKey();
            List<String> values = (List<String>) e.getValue();
            logger.info("processing url param" + key);
            logger.info("processing url values" + values);
            processUrlParam(key, values);
            return true;
        }
        return false;
    }

    protected static void processUrlParam(String key, List<String> values) {
        switch (key) {
            case "inviteCode":
                InvitationCodeValidator.validate(key, values);
            case "h1b-questionnaire":
                InvitationCodeValidator.validate(key, values);
        }
    }
}
