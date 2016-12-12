/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.ext.question;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllQuestionPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllQuestionPanel.class.getName());
    public static ReadAllQuestionPanel instance;

    public ReadAllQuestionPanel() {
        instance = this;
        initTable("Question", OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadQuestionPanel(getEntity(entityId)));
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
        new ResponseStatusWidget().show("Successfully Deleted Question Information");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllQuestionPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new UpdateQuestionPanel(getEntity(entityId)));
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getQuestionURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(),
                false, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info(result);
                        postFetchTable(result);
                    }
                });
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("QuestionKey"));
        table.setText(0, 3, getKeyValue("QuestionCategory"));
        table.setText(0, 4, getKeyValue("QuestionContext"));
        table.setText(0, 5, getKeyValue("SortOrder"));
        table.setText(0, 6, getKeyValue("Comment Required"));
        table.setText(0, 7, getKeyValue("Rating Required"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "questionKey"));
            table.setText(i, 3, JSONUtils.toString(entity, "category"));
            table.setText(i, 4, JSONUtils.toString(entity, "context"));
            table.setText(i, 5, JSONUtils.toString(entity, "sortOrder"));
            table.setText(i, 6, JSONUtils.toString(entity, "questionCommentRequired"));
            table.setText(i, 7, JSONUtils.toString(entity, "questionRatingRequired"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.isAdmin() || Auth.isHR()) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "question/delete/" + entityId;
    }

    private String getQuestionURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "question/" + start.toString() + "/" + limit.toString();
    }
    @Override
    protected void createButtonClicked() {
        TabPanel.instance().getAdminPanel().entityPanel.clear();
        TabPanel.instance().getAdminPanel().entityPanel.add(new CreateQuestionPanel(CreateComposite.CreateCompositeType.CREATE));
    }

    @Override
    protected void configureCreateButton() {
         if (Auth.isAdmin()) {
            createButton.setText("Create Question");
            createButton.setVisible(true);
        }
         else {
            createButton.setVisible(false);
        }
    }
}
