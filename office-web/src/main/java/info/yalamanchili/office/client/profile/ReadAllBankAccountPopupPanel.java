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
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.ReadAllBankAcctWidget;
import info.yalamanchili.office.client.profile.phone.ReadAllPhonesPopupPanel;

/**
 *
 * @author Kiranmai.Ramisetti
 */
class ReadAllBankAccountPopupPanel extends ReadAllBankAcctWidget {

    public ReadAllBankAccountPopupPanel(String parentId) {
        super(parentId);
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    public void updateClicked(String entityId) {
        UpdateBankAccountPopupPanel updateBankAcct = new UpdateBankAccountPopupPanel(getEntity(entityId));
        new GenericPopup(updateBankAcct).show();
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted BankAccount Information");
        TabPanel.instance().profilePanel.entityPanel.clear();
        TabPanel.instance().profilePanel.entityPanel.add(new ReadAllBankAccountPopupPanel(OfficeWelcome.instance().employeeId));
    }

    @Override
    protected void configureCreateButton() {
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        CreateBankAccountPopupPanel createPanel = new CreateBankAccountPopupPanel(CreateComposite.CreateCompositeType.CREATE);;
        new GenericPopup(createPanel).show();
    }
}

