/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.ext.comment;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadAllCommentsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllCommentsPanel.class.getName());
    protected String targetClassName;

    public ReadAllCommentsPanel(String parentId, String targetClassName) {
        this.parentId = parentId;
        this.targetClassName = targetClassName;
        initTable("Comment", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getCommentsUrl(parentId, targetClassName, start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(),
                false, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info(result);
                        postFetchTable(result);
                    }
                });

    }

    protected String getCommentsUrl(String parentId, String targetClassName, Integer start, String limit) {
        return OfficeWelcome.instance().constants.root_url() + "comment/" + targetClassName + "/" + parentId + "/" + start.toString() + "/" + limit;
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Comment"));
        table.setText(0, 2, getKeyValue("Updated By"));
        table.setText(0, 3, getKeyValue("Updated At"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "comment"));
            table.setText(i, 2, JSONUtils.toString(entity, "updatedBy"));
            table.setText(i, 3, JSONUtils.toString(entity, "updatedTS"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        }
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

    protected void configureCreateButton() {
        createButton.setVisible(true);
    }

    /**
     * override this method to perform logic to handle create button
     */
    protected void createButtonClicked() {
        new GenericPopup(new AddCommentWidget(parentId, targetClassName)).show();
    }

    protected String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "comment/delete/" + entityId;
    }
}
