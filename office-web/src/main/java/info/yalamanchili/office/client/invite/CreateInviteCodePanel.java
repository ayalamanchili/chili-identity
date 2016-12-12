/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.invite;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.CreateComposite.CreateCompositeType;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.EmployeeSidePanel;
import info.yalamanchili.office.client.profile.employee.ReadAllEmployeesPanel;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class CreateInviteCodePanel extends CreateComposite {
    
    private static Logger logger = Logger.getLogger(CreateInviteCodePanel.class.getName());

    HTML emptyLine = new HTML("<br/>");

    public CreateInviteCodePanel(CreateCompositeType type) {
        super(type);
        initCreateComposite("InviteCode", OfficeWelcome.constants);
    }

    @Override
    public JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        JSONObject inviteType = new JSONObject();
        assignEntityValueFromField("invitationType", inviteType);
        assignEntityValueFromField("validFromDate", entity);
        assignEntityValueFromField("expiryDate", entity);
        assignEntityValueFromField("email", entity);
        entity.put("inviteType", inviteType);
        return entity;
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
        setButtonText("Submit");
    }

    @Override
    protected void addWidgets() {
        addEnumField("invitationType", false, true, InvitationType.names(), Alignment.HORIZONTAL);
        addField("validFromDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("expiryDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("email", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(emptyLine);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    public void createButtonClicked() {
        logger.info("entity details:" + entity.toString());
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
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Sent Onboarding Invitation");
        TabPanel.instance().myOfficePanel.sidePanelTop.clear();
        TabPanel.instance().myOfficePanel.sidePanelTop.add(new EmployeeSidePanel());
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmployeesPanel());

    }


    @Override
    protected void addButtonClicked() {
        // TODO Auto-generated method stub
    }

    @Override
    protected boolean showDocumentationLink() {
        return true;
    }

    @Override
    protected String getDocumentationLink() {
        return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "employee.html";
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "invitecode/invite";
    }
    
}
