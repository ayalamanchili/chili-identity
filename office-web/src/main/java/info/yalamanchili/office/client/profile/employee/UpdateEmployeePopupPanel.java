/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.profile.ProfileHome;

/**
 *
 * @author prani
 */
public class UpdateEmployeePopupPanel extends UpdateEmployeePanel {

    public UpdateEmployeePopupPanel(JSONObject entity) {
        super(entity);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Employee Information");
        GenericPopup.instance().hide();
        ProfileHome.instance().refreshEmployeePanel();
    }

    @Override
    protected void addWidgets() {
        // same here update them
        addDropDown("employeeType", employeeSelectWidget);
        addField("firstName", true, true, DataType.STRING_FIELD);
        addField("middleInitial", true, false, DataType.STRING_FIELD);
        addField("lastName", true, true, DataType.STRING_FIELD);
        addField("dateOfBirth", true, true, DataType.DATE_FIELD);
        String[] strs = {"MALE", "FEMALE"};
        addEnumField("sex", true, true, strs);
        addField("startDate", true, false, DataType.DATE_FIELD);
        addField("jobTitle", false, true, DataType.STRING_FIELD);
        if (Auth.isAdmin()) {
            addField("ssn", false, false, DataType.STRING_FIELD);
        }
        entityFieldsPanel.add(empImageUploadPanel);

    }
}
