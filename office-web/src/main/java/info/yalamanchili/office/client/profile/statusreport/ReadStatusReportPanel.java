/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
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
import info.chili.gwt.fields.RichTextField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.project.SelectProjectWidget;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
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
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    protected void populateComments() {
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.client.StatusReport"));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        logger.info(entity.toString());
        if (TabPanel.instance().homePanel.isVisible()) {
            assignFieldValueFromEntity("clientInformation", entity, null);
        }
        assignFieldValueFromEntity("project", entity, null);
        assignFieldValueFromEntity("reportStartDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("reportEndDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("status", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("preparedBy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("approvedBy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("report", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("submittedDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("approvedDate", entity, DataType.DATE_FIELD);
        populateComments();
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        RichTextField reportF = (RichTextField) fields.get("report");
        reportF.setHeightAndWidth("400px", "100%");
    }

    @Override
    protected void addWidgets() {
        if (TabPanel.instance().homePanel.isVisible()) {
            addDropDown("clientInformation", new SelectClientInfoWidget(false, true));
        }
        addDropDown("project", new SelectProjectWidget(getEntityId(), false, true));
        addField("reportStartDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("reportEndDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("status", true, true, ProjectStatus.names(), Alignment.HORIZONTAL);
        addField("report", true, true, DataType.RICH_TEXT_AREA);
        addField("preparedBy", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("submittedDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("approvedBy", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("approvedDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);

        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "statusreport";
    }
}
