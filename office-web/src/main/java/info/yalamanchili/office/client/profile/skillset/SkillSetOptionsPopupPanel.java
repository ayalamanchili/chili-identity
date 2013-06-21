/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.GenericPopup;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class SkillSetOptionsPopupPanel extends SkillSetOptionsPanel {

    private static Logger logger = Logger.getLogger(SkillSetOptionsPopupPanel.class.getName());

    public SkillSetOptionsPopupPanel(String employeeId) {
        super(employeeId);
    }

    @Override
    protected void addWidgets() {
        panel.add(updateSkillSetL);
    }

    @Override
    public void onClick(ClickEvent clickEvent) {
        if (clickEvent.getSource().equals(updateSkillSetL)) {
            HttpService.HttpServiceAsync.instance().doGet(getSkillSetURI(),
                    OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                @Override
                public void onResponse(String arg0) {
                    logger.info("dddd"+arg0);
                    if (arg0 != null) {
                        UpdateSkillSetPopupPanel updateSkillSetPanel = new UpdateSkillSetPopupPanel((JSONObject) (JSONParser.parseLenient(arg0)));
                        new GenericPopup(updateSkillSetPanel).show();
                    }
                }
            });
        }
    }
}
