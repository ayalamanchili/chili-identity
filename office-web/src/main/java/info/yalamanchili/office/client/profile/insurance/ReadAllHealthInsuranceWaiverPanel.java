/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.insurance;

import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.fields.FileField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class ReadAllHealthInsuranceWaiverPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllHealthInsuranceWaiverPanel.class.getName());
    public static ReadAllHealthInsuranceWaiverPanel instance;
    protected String url;
    protected String empId;

    public ReadAllHealthInsuranceWaiverPanel() {
        instance = this;
        initTable("HealthInsurances", OfficeWelcome.constants2);
    }

    public ReadAllHealthInsuranceWaiverPanel(String empId) {
        instance = this;
        this.empId = empId;
        initTable("HealthInsurances", OfficeWelcome.constants2);
    }

    public ReadAllHealthInsuranceWaiverPanel(JSONArray array) {
        instance = this;
        initTable("HealthInsurances", array, OfficeWelcome.constants2);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllInsuranceWaiverURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });

    }

    public String getReadAllInsuranceWaiverURL(Integer start, String limit) {
        if (empId != null && !"".equals(empId)) {
            return OfficeWelcome.constants.root_url() + "insurance-enrollment/" + empId + "/" + start.toString() + "/" + limit;
        } else {
            return OfficeWelcome.constants.root_url() + "insurance-enrollment/" + start.toString() + "/" + limit;
        }
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Action"));
        table.setText(0, 1, getKeyValue("Year"));
        table.setText(0, 2, getKeyValue("Enrolled"));
        table.setText(0, 3, getKeyValue("WaivingCoverageFor"));
        table.setText(0, 4, getKeyValue("WaivingCoverageDueTo"));
        table.setText(0, 5, getKeyValue("File"));
    }

    @Override
    public void fillData(JSONArray entities) {
        int count = 0;
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            if (entity.get("enrolled").isString().stringValue().equals("false")) {
                count++;
                JSONObject healthInsuranceWaiver = (JSONObject) entity.get("healthInsuranceWaiver");
                addOptionsWidget(i, entity);
                table.setText(i, 1, JSONUtils.toString(healthInsuranceWaiver, "waiverYear"));
                table.setText(i, 2, JSONUtils.toString(entity, "enrolled"));
                table.setText(i, 3, JSONUtils.toString(healthInsuranceWaiver, "waivingCoverageFor"));
                table.setText(i, 4, JSONUtils.toString(healthInsuranceWaiver, "waivingCoverageDueTo"));
                String fileURL = ChiliClientConfig.instance().getFileDownloadUrl() + JSONUtils.toString(healthInsuranceWaiver, "fileUrl") + "&entityId=" + JSONUtils.toString(entity, "id");
                FileField fileField = new FileField(fileURL);
                table.setWidget(i, 5, fileField);
            }
        }
        setTotalResults(count);
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.DELETE, TableRowOptionsWidget.OptionsType.PRINT);
    }

    @Override
    public void printClicked(String entityId) {
        Window.open(ChiliClientConfig.instance().getFileDownloadUrl() + "insurance-enrollment/insurance-print" + "&passthrough=true" + "&id=" + entityId, "_blank", "");
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().profilePanel.entityPanel.clear();
        TabPanel.instance().profilePanel.entityPanel.add(new ReadHealthInsuranceEnrollment(entityId));
    }

    @Override
    public void deleteClicked(String entityId) {
        HttpService.HttpServiceAsync.instance().doPut(getDeleteURL(entityId), null, OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {

                    @Override
                    public void onResponse(String arg0) {
                        postDeleteSuccess();
                    }
                });
    }

    protected String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "insurance-enrollment/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Health Waiver Information");
        TabPanel.instance().profilePanel.entityPanel.clear();
        TabPanel.instance().profilePanel.entityPanel.add(new ReadAllHealthInsuranceWaiverPanel(empId));
    }

    @Override
    public void updateClicked(String entityId) {
    }

    @Override
    protected void createButtonClicked() {
    }
}
