/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.Label;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.fields.FileField;
import info.chili.gwt.widgets.GenericPopup;

/**
 *
 * @author ayalamanchili
 */
public class ReadSkillSetPopupPanel extends ReadSkillSetPanel {

    public ReadSkillSetPopupPanel(String employeeId) {
        super(employeeId);
    }

    public ReadSkillSetPopupPanel(JSONObject skillSet) {
        super(skillSet);
    }

    @Override
    protected void onLoadSuccess(String response) {
        if (response != null && !response.isEmpty()) {
            entity = (JSONObject) JSONParser.parseLenient(response);
            populateFieldsFromEntity(entity);
        } else {
            CreateSkillSetPopupPanel CreateSkillSetPanel = new CreateSkillSetPopupPanel(entityId);
            new GenericPopup(CreateSkillSetPanel).show();
        }
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("practice", entity, null);
        assignFieldValueFromEntity("technologyGroup", entity, null);
        assignFieldValueFromEntity("lastUpdated", entity, DataType.DATE_FIELD);
        //Resume
        Label resumeLabel = new Label("Resume");
        entityFieldsPanel.add(resumeLabel);
        String fileURL = ChiliClientConfig.instance().getFileDownloadUrl() + JSONUtils.toString(entity, "resumeUrl") + "&entityId=" + JSONUtils.toString(entity, "id");
        FileField fileField = new FileField(fileURL);
        entityFieldsPanel.add(fileField);
        //This is overrided
        entityFieldsPanel.add(new SkillSetOptionsPopupPanel(empId));
        loadTags();
    }
}
