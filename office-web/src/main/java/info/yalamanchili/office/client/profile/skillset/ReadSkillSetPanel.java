/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.ReadComposite;
import info.chili.gwt.rpc.HttpService.HttpServiceAsync;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.HTML;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.gwt.FileField;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class ReadSkillSetPanel extends ReadComposite {

    private static Logger logger = Logger.getLogger(ReadSkillSetPanel.class.getName());
    protected String empId;
    private static ReadSkillSetPanel instance;

    public static ReadSkillSetPanel instance() {
        return instance;
    }

    public ReadSkillSetPanel() {
        instance = this;
    }

    public ReadSkillSetPanel(String empId) {
        instance = this;
        this.empId = empId;
        initReadComposite("SkillSet", OfficeWelcome.constants);
    }

    public ReadSkillSetPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "SkillSet", OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    public void loadEntity(String entityId) {
        HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        onLoadSuccess(response);
                    }
                });

    }

    protected void onLoadSuccess(String response) {
        if (response != null && !response.isEmpty()) {
            entity = (JSONObject) JSONParser.parseLenient(response);
            populateFieldsFromEntity(entity);

        } else {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            if (Auth.isAdmin() || Auth.isHR()) {
                TabPanel.instance().myOfficePanel.entityPanel.add(new CreateSkillSetPanel(empId));
            } else {
                TabPanel.instance().myOfficePanel.entityPanel.add(new HTML("No SkillSet Information"));
            }
        }
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        logger.info("entity" + entity.toString());
        assignFieldValueFromEntity("lastUpdated", entity, DataType.DATE_FIELD);
        String fileURL = OfficeWelcome.config.getFileDownloadUrl() + JSONUtils.toString(entity, "resumeUrl") + "&entityId=" + JSONUtils.toString(entity, "id");
        FileField fileField = new FileField(fileURL);
        entityFieldsPanel.add(fileField);
        entityFieldsPanel.add(new SkillSetOptionsPanel(empId));
    }

    @Override
    protected void addWidgets() {
        addField("lastUpdated", true, false, DataType.DATE_FIELD);
    }

    @Override
    public String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/skillset/" + empId;
    }
}
