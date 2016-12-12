/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.project.offboarding;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.UpdateComposite;
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
 * @author chaitanya.k
 */
public class UpdateProjectOffboardingPanal extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateProjectOffboardingPanal.class.getName());

    protected String clientInfoId;

    public UpdateProjectOffboardingPanal(CreateComposite.CreateCompositeType createCompositeType, String clientInfoId) {
        this.clientInfoId = clientInfoId;
        initUpdateComposite(entity, "ProjectOffboarding", OfficeWelcome.constants2);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(entityId), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    private String getReadURI(String entityId) {
        return OfficeWelcome.constants.root_url() + "clientinformation/project-off-boarding/" + entityId;
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
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated OffBoarding");
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
        return OfficeWelcome.constants.root_url() + "clientinformation/update-project-off-boarding/";
    }

}
