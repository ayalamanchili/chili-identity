/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.ext.question;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.employee.prefeval.PerformanceEvaluationStage;
import info.yalamanchili.office.client.employee.prefeval.UpdatePerformanceEvaluationPanel;
import info.yalamanchili.office.client.gwt.RatingWidget;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class UpdateQuestionCommentPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateQuestionCommentPanel.class.getName());
    protected HTML questionInfoL = new HTML("");
    protected RatingWidget ratingWidget;
    protected Boolean isRatingRequired;
    protected Boolean isCommentRequired;

    public UpdateQuestionCommentPanel(JSONObject entity) {
        isRatingRequired = JSONUtils.toBoolean(entity, "questionRatingRequired");
        isCommentRequired = JSONUtils.toBoolean(entity, "questionCommentRequired");
        initUpdateComposite(entity, "QuestionComment", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("comment", entity);
        if (!PerformanceEvaluationStage.Self_Review.name().equals(JSONUtils.toString(UpdatePerformanceEvaluationPanel.instance().getEntity(), "stage"))) {
            if (ratingWidget.getRating() > 0) {
                entity.put("rating", new JSONString(ratingWidget.getRating().toString()));
            } else {
                entity.put("rating", new JSONString("null"));
            }
        }
        entity.put("targetEntityName", new JSONString("dummy"));
        entity.put("targetEntityId", new JSONString("0"));
        entity.put("id", entity.get("commentId").isString());
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {

            @Override
            public void onResponse(String arg0) {
                new ResponseStatusWidget().show("Successfuly update comment");
            }
        });
    }

    @Override
    protected void postUpdateSuccess(String result) {

    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        questionInfoL.setHTML(entity.get("questionInfo").isString().stringValue());
        assignFieldValueFromEntity("comment", entity, DataType.TEXT_AREA_FIELD);
        if (!PerformanceEvaluationStage.Self_Review.name().equals(JSONUtils.toString(UpdatePerformanceEvaluationPanel.instance().getEntity(), "stage"))) {
            if (JSONUtils.toString(entity, "rating").isEmpty()) {
                ratingWidget.setRating(0);
            } else {
                ratingWidget.setRating(Double.valueOf(JSONUtils.toString(entity, "rating")).intValue());
            }
        }
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        TextAreaField commentF = (TextAreaField) fields.get("comment");
        commentF.getTextbox().setCharacterWidth(75);
        commentF.getTextbox().setVisibleLines(4);
        entityCaptionPanel.setCaptionHTML("<b>" + JSONUtils.toString(entity, "question") + "</b>");
        update.setVisible(false);
    }

    @Override
    protected void addWidgets() {
        entityFieldsPanel.add(questionInfoL);
        addField("comment", false, false, DataType.TEXT_AREA_FIELD);
        if (!PerformanceEvaluationStage.Self_Review.name().equals(JSONUtils.toString(UpdatePerformanceEvaluationPanel.instance().getEntity(), "stage"))) {
            ratingWidget = new RatingWidget(5, isRatingRequired, false);
            entityFieldsPanel.add(ratingWidget);
        }
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "comment";
    }
}
