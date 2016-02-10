/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.expense.bnkacct.UpdateBankAcctWidget;
import info.yalamanchili.office.client.profile.employee.UpdateBankAccountPanel;

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
        ProfileHome.instance().refreshBankAccountPanel();
    }
}
