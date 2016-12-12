/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.bnkacct;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.ReadAllBankAcctWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class CreateBankAcctWidget extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateBankAcctWidget.class.getName());

    public CreateBankAcctWidget() {
        super(CreateComposite.CreateCompositeType.CREATE);
        initCreateComposite("BankAccount", OfficeWelcome.constants);
        create.setVisible(false);
    }

    public CreateBankAcctWidget(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("BankAccount", OfficeWelcome.constants);
        create.setVisible(true);
    }

    @Override
    public JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("accountFirstName", entity);
        assignEntityValueFromField("accountLastName", entity);
        assignEntityValueFromField("bankName", entity);
        assignEntityValueFromField("bankRoutingNumber", entity);
        assignEntityValueFromField("bankAccountNumber", entity);
        assignEntityValueFromField("bankAddress1", entity);
        assignEntityValueFromField("bankAddress2", entity);
        assignEntityValueFromField("accountType", entity);
        assignEntityValueFromField("achBlocked", entity);
        entity.put("targetEntityName", new JSONString("targetEntityName"));
        entity.put("targetEntityId", new JSONString("0"));
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        // TODO Auto-generated method stub
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postCreateSuccess(arg0);
                    }
                });
    }

    @Override
    protected void addButtonClicked() {

    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully BankAccount Created");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllBankAcctWidget(TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
        addField("accountFirstName", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("accountLastName", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankName", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankRoutingNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankAccountNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankAddress1", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankAddress2", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("accountType", false, true, AccountType.names(), Alignment.HORIZONTAL);
        addField("achBlocked", false, true, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee-forms/ach-save/" + TreeEmployeePanel.instance().getEntityId();
    }
}
