/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.insurance;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadHealthInsuranceEnrollment extends ReadComposite {

    private static ReadHealthInsuranceEnrollment instance;
    private static Logger logger = Logger.getLogger(ReadHealthInsuranceEnrollment.class.getName());

    public static ReadHealthInsuranceEnrollment instance() {
        return instance;
    }

    public ReadHealthInsuranceEnrollment(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "HealthInsurances", OfficeWelcome.constants2);
    }

    public ReadHealthInsuranceEnrollment(String id) {
        instance = this;
        initReadComposite(id, "HealthInsurances", OfficeWelcome.constants2);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                    }
                });

    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        if (entity.containsKey("insuranceEnrollment")) {
            entityFieldsPanel.add(new ReadInsuranceEnrollmentWidget(entity.get("insuranceEnrollment").isObject()));
        }
        if (entity.containsKey("healthInsuranceWaiver")) {
            entityFieldsPanel.add(new ReadHealthInsuranceWaiverWidget(entity.get("healthInsuranceWaiver").isObject()));
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
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "insurance-enrollment/" + getEntityId();
    }
}