/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.ext.question;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class UpdateQuestionPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateQuestionPanel.class.getName());

    public UpdateQuestionPanel(JSONObject entity) {
        initUpdateComposite(entity, "Question", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("questionKey", entity);
        assignEntityValueFromField("category", entity);
        assignEntityValueFromField("context", entity);
        assignEntityValueFromField("sortOrder", entity);
        assignEntityValueFromField("questionCommentRequired", entity);
        assignEntityValueFromField("questionRatingRequired", entity);
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
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("questionKey", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("category", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("context", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("sortOrder", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("questionCommentRequired", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("questionRatingRequired", entity, DataType.BOOLEAN_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Question Information");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllQuestionPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("questionKey", false, true, DataType.STRING_FIELD);
        addEnumField("category", false, true, QuestionCategory.names());
        addEnumField("context", false, true, QuestionContext.names());
        addField("sortOrder", false, false, DataType.INTEGER_FIELD);
        addField("questionCommentRequired", false, false, DataType.BOOLEAN_FIELD);
        addField("questionRatingRequired", false, false, DataType.BOOLEAN_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "question";
    }
}
