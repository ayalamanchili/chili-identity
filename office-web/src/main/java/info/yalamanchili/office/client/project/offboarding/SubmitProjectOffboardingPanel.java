/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.project.offboarding;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.cllientinfo.ReadAllClientInfoPanel;
import info.yalamanchili.office.client.profile.cllientinfo.ReadAllClientInfoPopupPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class SubmitProjectOffboardingPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(SubmitProjectOffboardingPanel.class.getName());

    protected String clientInfoId;

    public SubmitProjectOffboardingPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("ProjectOffboarding", OfficeWelcome.constants2);
        create.setText("Submit");
    }

    public SubmitProjectOffboardingPanel(CreateCompositeType type, String clientInfoId) {
        super(type);
        this.clientInfoId = clientInfoId;
        initCreateComposite("ProjectOffboarding", OfficeWelcome.constants2);
        create.setText("Submit");
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("notes", entity);
        assignEntityValueFromField("projectInPipeline", entity);
        assignEntityValueFromField("specialNotes", entity);
        entity.put("clientInformtaionId", new JSONString(clientInfoId));
        return entity;
    }

    @Override
    protected void addButtonClicked() {

    }

    @Override
    protected void createButtonClicked() {
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
        new ResponseStatusWidget().show("Successfully Submitted Project End Details");
        if (GenericPopup.instance() != null) {
            GenericPopup.instance().hide();
        }
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllClientInfoPanel(TreeEmployeePanel.instance().getEntityId()));
        } else {
            TabPanel.instance().profilePanel.entityPanel.clear();
            TabPanel.instance().profilePanel.entityPanel.add(new ReadAllClientInfoPopupPanel(OfficeWelcome.instance().employeeId));

        }

    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        addField("endDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("notes", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("projectInPipeline", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("specialNotes", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);

        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "clientinformation/project-off-boarding";
    }
}
