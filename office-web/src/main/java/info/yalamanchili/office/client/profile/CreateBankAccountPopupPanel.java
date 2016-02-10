/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile;

import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.expense.bnkacct.CreateBankAcctWidget;

/**
 *
 * @author Kiranmai.Ramisetti
 */
class CreateBankAccountPopupPanel extends CreateBankAcctWidget {

    public CreateBankAccountPopupPanel(CreateComposite.CreateCompositeType type) {
        super(type);
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee-forms/ach-save/" + OfficeWelcome.instance().employeeId;
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added BankAccount");
        GenericPopup.instance().hide();
        ProfileHome.instance().refreshBankAccountPanel();
    }
}
