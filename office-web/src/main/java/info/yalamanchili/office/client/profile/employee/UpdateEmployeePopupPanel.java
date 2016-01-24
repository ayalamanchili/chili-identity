/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.profile.ProfileHome;
import info.yalamanchili.office.client.profile.contact.Branch;
import info.yalamanchili.office.client.profile.contact.Sex;
import info.yalamanchili.office.client.profile.contact.WorkStatus;

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
        addField("firstName", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("middleInitial", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lastName", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dateOfBirth", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("sex", true, true, Sex.names(), Alignment.HORIZONTAL);
        addField("startDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("jobTitle", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("branch", true, true, Branch.names(), Alignment.HORIZONTAL);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_HR)) {
            addEnumField("workStatus", true, true, WorkStatus.names(), Alignment.HORIZONTAL);
        }
        if (Auth.isAdmin()) {
            addField("ssn", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        }
        entityFieldsPanel.add(empImageUploadPanel);
        alignFields();
    }
}
