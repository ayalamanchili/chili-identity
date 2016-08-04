/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.insurance;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class InsuranceEnrollmentPanel extends CreateComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(InsuranceEnrollmentPanel.class.getName());

    EnumField yearsF;

    public InsuranceEnrollmentPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("InsuranceEnrollment", OfficeWelcome.constants);
    }

    @Override
    public JSONObject populateEntityFromFields() {
        JSONObject insuranceEnrollment = new JSONObject();
        logger.info("logger info of insurance Enrollment " + insuranceEnrollment);
        assignEntityValueFromField("year", insuranceEnrollment);
        assignEntityValueFromField("type", insuranceEnrollment);
        assignEntityValueFromField("comments", insuranceEnrollment);
        logger.info(insuranceEnrollment.toString());
        return insuranceEnrollment;

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
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Insurance Enrollment Created");
        TabPanel.instance().profilePanel.entityPanel.clear();
        TabPanel.instance().profilePanel.entityPanel.add(new ReadAllInsuranceEnrollment());
    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {
        create.setVisible(false);
    }

    @Override
    protected void addWidgets() {
        addEnumField("year", false, true, HealthInsuranceYear.getyears().toArray(new String[0]), Alignment.HORIZONTAL);
        yearsF = (EnumField) fields.get("year");
        addEnumField("type", false, true, InsuranceType.names(), Alignment.HORIZONTAL);
        addField("comments", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        alignFields();

    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "insurance-enrollment";
    }

}
