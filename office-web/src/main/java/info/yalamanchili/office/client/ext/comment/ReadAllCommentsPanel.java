/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
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
import info.chili.gwt.date.DateUtils;
import static info.chili.gwt.date.DateUtils.toDate;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadAllCommentsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllCommentsPanel.class.getName());
    protected String targetClassName;

    private static ReadAllCommentsPanel instance;

    public static ReadAllCommentsPanel instance() {
        return instance;
    }

    public ReadAllCommentsPanel(String parentId, String targetClassName) {
        instance = this;
        this.parentId = parentId;
        this.targetClassName = targetClassName;
        initTable("Comment", OfficeWelcome.constants);
        createButton.setText("Add Comment");
    }

    @Override
    public void preFetchTable(final int start) {
        HttpService.HttpServiceAsync.instance().doGet(getCommentsUrl(parentId, targetClassName, start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(),
                true, new ALAsyncCallback<String>() {
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
            table.setText(i, 3, formatDateWithTime(JSONUtils.toString(entity, "updatedTS")));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN , Auth.ROLE.ROLE_BILLING_ADMIN , Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_CONSULTANT_TIME_ADMIN)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        }
    }

    @Override
    public void viewClicked(String entityId) {
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

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Comments");
        refresh();
    }

    @Override
    public void updateClicked(String entityId) {

    }

    @Override
    protected void configureCreateButton() {
        createButton.setVisible(true);
    }

    /**
     * override this method to perform logic to handle create button
     */
    @Override
    protected void createButtonClicked() {
        new GenericPopup(new AddCommentWidget(parentId, targetClassName)).show();
    }

    protected String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "comment/delete/" + entityId;
    }
    
    public static String formatDateWithTime(String dateString) {
            Date date = toDate(dateString);
            String formatteddate = DateUtils.formatDate(dateString);
            String[] times = date.toString().split(" ");
            return formatteddate.concat(" "+times[3]);
        }
}
