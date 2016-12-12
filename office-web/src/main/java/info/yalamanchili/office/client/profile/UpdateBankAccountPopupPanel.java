/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.expense.bnkacct.UpdateBankAcctWidget;
import info.yalamanchili.office.client.profile.employee.UpdateBankAccountPanel;
import info.yalamanchili.office.client.profile.phone.ReadAllPhonesPopupPanel;

/**
 *
 * @author Kiranmai.Ramisetti
 */
class UpdateBankAccountPopupPanel extends UpdateBankAccountPanel {

    public UpdateBankAccountPopupPanel(JSONObject entity) {
        super(entity);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated BankAccount Information");
        GenericPopup.instance().hide();
        TabPanel.instance().profilePanel.entityPanel.clear();
        TabPanel.instance().profilePanel.entityPanel.add(new ReadAllBankAccountPopupPanel(OfficeWelcome.instance().employeeId));
    }
}
