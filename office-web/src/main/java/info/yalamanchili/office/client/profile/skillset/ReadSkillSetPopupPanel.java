/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.GenericPopup;

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
        assignFieldValueFromEntity("lastUpdated", entity, DataType.DATE_FIELD);
        entityFieldsPanel.add(new SkillSetOptionsPopupPanel(super.empId));
    }
}
