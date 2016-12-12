/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.companycontact;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.contacttype.SelectCompanyContactTypeWidget;
import info.chili.gwt.crud.UpdateComposite;
import info.yalamanchili.office.client.profile.employee.SelectCorpEmployeeWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.profile.phone.UpdatePhonePanel;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class UpdateCompanyContactPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdatePhonePanel.class.getName());
    SelectCompanyContactTypeWidget contactTypeF = new SelectCompanyContactTypeWidget(false, true);
    SelectCorpEmployeeWidget employeeF = new SelectCorpEmployeeWidget(false, true);

    public UpdateCompanyContactPanel(JSONObject entity) {
        initUpdateComposite(entity, "CompanyContact", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        entity.put("type", contactTypeF.getSelectedObject());
        entity.put("contact", employeeF.getSelectedObject());
        JSONObject emp = new JSONObject();
        emp.put("id", new JSONString(TreeEmployeePanel.instance().getEntityId()));
        entity.put("employee", emp);
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postUpdateSuccess(arg0);
                    }
                });

    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Company Contact Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllCompanyContactPanel(TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("type", entity, null);
        assignFieldValueFromEntity("contact", entity, null);
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
        addDropDown("type", contactTypeF);
        addDropDown("contact", employeeF);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "companycontact";
    }
}
