/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.empdoc;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.FileField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class ReadAllEmpDocsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllEmpDocsPanel.class.getName());
    public static ReadAllEmpDocsPanel instance;

    public ReadAllEmpDocsPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("EmployeeDocument", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllFilesURL(parentId, start, OfficeWelcome.constants.tableSize()),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });
    }

    public String getReadAllFilesURL(String employeeId, Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "employee-document/" + employeeId + "/" + start + "/" + limit;

    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("DocumentType"));
        table.setText(0, 2, getKeyValue("File"));
        table.setText(0, 3, getKeyValue("Updated Time Stamp"));
        table.setText(0, 4, getKeyValue("Updated By"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.formatEnumString(entity, "documentType"));
            String fileURL = ChiliClientConfig.instance().getFileDownloadUrl() + JSONUtils.toString(entity, "fileUrl") + "&entityId=" + JSONUtils.toString(entity, "id");
            FileField fileField = new FileField(fileURL);
            table.setWidget(i, 2, fileField);
            table.setText(i, 3, DateUtils.getFormatedDate(JSONUtils.toString(entity, "updatedTs"), DateTimeFormat.PredefinedFormat.DATE_LONG));
            table.setText(i, 4, JSONUtils.toString(entity, "updatedBy"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {

    }

    @Override
    public void viewClicked(String entityId) {
    }

    @Override
    public void deleteClicked(String entityId) {
    }

    @Override
    public void postDeleteSuccess() {

    }

    @Override
    public void updateClicked(String entityId) {

    }
}
