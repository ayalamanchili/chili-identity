/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.statusreport;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.admin.project.SelectProjectWidget;
import info.yalamanchili.office.client.profile.cllientinfo.SelectClientInfoWidget;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadStatusReportPanel extends ReadComposite {

    private static ReadStatusReportPanel instance;
    private static Logger logger = Logger.getLogger(ReadStatusReportPanel.class.getName());

    public static ReadStatusReportPanel instance() {
        return instance;
    }

    public ReadStatusReportPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "StatusReport", OfficeWelcome.constants);
    }

    public ReadStatusReportPanel(String id) {
        initReadComposite(id, "StatusReport", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String response) {
                logger.info("read ec6 response" + response);
                entity = (JSONObject) JSONParser.parseLenient(response);
                populateFieldsFromEntity(entity);
            }
        });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("reportStartDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("reportEndDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("status", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("preparedBy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("approvedBy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("report", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("submittedDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("project", entity, null);
//        assignFieldValueFromEntity("clientInformation", entity, null);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("reportStartDate", false, true, DataType.DATE_FIELD);
        addField("reportEndDate", false, true, DataType.DATE_FIELD);
        addEnumField("status", false, true, ProjectStatus.names());
        addField("preparedBy", false, false, DataType.STRING_FIELD);
        addField("approvedBy", false, false, DataType.STRING_FIELD);
        addField("report", false, true, DataType.STRING_FIELD);
        addField("submittedDate", false, false, DataType.DATE_FIELD);
        addDropDown("project", new SelectProjectWidget(false, true));
//        addDropDown("clientInformation", new SelectClientInfoWidget(false, true));
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "statusreport";
    }
}
