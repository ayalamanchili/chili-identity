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
import info.chili.gwt.crud.CreateComposite;
import info.yalamanchili.office.client.profile.employee.SelectCorpEmployeeWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class CreateCompanyContactPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateCompanyContactPanel.class.getName());
    SelectCompanyContactTypeWidget contactTypeF = new SelectCompanyContactTypeWidget(false, true);
    SelectCorpEmployeeWidget employeeF = new SelectCorpEmployeeWidget(false, true);

    public CreateCompanyContactPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("CompanyContact", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        entity.put("type", contactTypeF.getSelectedObject());
        entity.put("contact", employeeF.getSelectedObject());
        JSONObject emp = new JSONObject();
        emp.put("id", new JSONString(TreeEmployeePanel.instance().getEntityId()));
        entity.put("employee", emp);
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        logger.info(arg0.getMessage());
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postCreateSuccess(arg0);
                    }
                });

    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added Company Contact");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllCompanyContactPanel(
                TreeEmployeePanel.instance().getEntityId()));
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
