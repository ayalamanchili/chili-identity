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
import java.util.ArrayList;
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
        List<Entry> entryList = new ArrayList();
        for (Entry e : map.entrySet()) {
            entryList.add(e);
        }
        processUrlParam(entryList);
        return false;
    }

    protected static void processUrlParam(List<Entry> entryList) {
        InvitationCodeValidator.validateParams(entryList);
    }
}