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
import info.chili.gwt.crud.CreateComposite;
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
public class CreateQuestionPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateQuestionPanel.class.getName());

    public CreateQuestionPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("Question", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("questionKey", entity);
        assignEntityValueFromField("category", entity);
        assignEntityValueFromField("context", entity);
        assignEntityValueFromField("sortOrder", entity);
        assignEntityValueFromField("questionCommentRequired", entity);
        assignEntityValueFromField("questionRatingRequired", entity);

        logger.info("ddd" + entity);
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable arg0) {
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
        new ResponseStatusWidget().show("Question Successfully Created");
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
