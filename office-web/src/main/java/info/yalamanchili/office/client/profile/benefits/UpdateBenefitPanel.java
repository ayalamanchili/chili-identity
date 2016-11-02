/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.benefits;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author Hemanth
 */
public class UpdateBenefitPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateBenefitPanel.class.getName());

    public UpdateBenefitPanel(JSONObject entity) {
        initUpdateComposite(entity, "Benefit", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("benefitType", entity);
        assignEntityValueFromField("year", entity);
        assignEntityValueFromField("enrolled", entity);
        assignEntityValueFromField("comments", entity);
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
        new ResponseStatusWidget().show("Successfully Updated Benefit Information");
        GenericPopup.hideIfOpen();
        if (TabPanel.instance().profilePanel.isVisible()) {
            TabPanel.instance().profilePanel.entityPanel.clear();
            TabPanel.instance().profilePanel.entityPanel.add(new ReadAllBenefitsPanel(OfficeWelcome.instance().employeeId));
        } else {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllBenefitsPanel(TreeEmployeePanel.instance().getEntityId()));
        }
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("benefitType", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("year", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("enrolled", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("comments", entity, DataType.RICH_TEXT_AREA);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addEnumField("benefitType", false, false, BenefitType.names(), Alignment.HORIZONTAL);
        addEnumField("year", false, false, YearType.names(), Alignment.HORIZONTAL);
        addField("enrolled", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("comments", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            return OfficeWelcome.constants.root_url() + "benefit/save/" + TreeEmployeePanel.instance().getEntityId();
        } else {
            return OfficeWelcome.constants.root_url() + "benefit/save/" + OfficeWelcome.instance().employeeId;
        }
    }
}
