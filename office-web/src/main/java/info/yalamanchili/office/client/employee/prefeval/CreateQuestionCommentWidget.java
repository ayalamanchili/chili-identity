/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prefeval;

import com.google.common.base.Strings;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.RatingWidget;
import info.yalamanchili.office.client.gwt.RatingWidget.Presenter;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class CreateQuestionCommentWidget extends ALComposite implements Presenter {

    private static Logger logger = Logger.getLogger(CreateQuestionCommentWidget.class.getName());
    protected CaptionPanel captionPanel = new CaptionPanel();
    protected FlowPanel panel = new FlowPanel();
    protected JSONObject question;
    protected HTML questionL = new HTML();
    protected HTML questionDecriptionL = new HTML();
    protected TextAreaField commentTB;
    protected RatingWidget ratingWidget;
    protected Boolean displayRating;
    protected Boolean displayComment;
    protected Boolean useRichTextEditor;
    protected Boolean isRatingRequired;
    protected Boolean isCommentRequired;
    protected String fyYear;

    public CreateQuestionCommentWidget(JSONObject question, Boolean displayRating, Boolean displayComment, Boolean useRichTextEditor) {
        this.question = question;
        this.displayRating = displayRating;
        this.displayComment = displayComment;
        this.useRichTextEditor = useRichTextEditor;
        isRatingRequired = JSONUtils.toBoolean(question, "questionRatingRequired");
        isCommentRequired = JSONUtils.toBoolean(question, "questionCommentRequired");
        init(captionPanel);
    }

    public CreateQuestionCommentWidget(JSONObject question, Boolean displayRating, Boolean displayComment, Boolean useRichTextEditor, String year) {
        this.question = question;
        this.displayRating = displayRating;
        this.displayComment = displayComment;
        this.useRichTextEditor = useRichTextEditor;
        isRatingRequired = JSONUtils.toBoolean(question, "questionRatingRequired");
        isCommentRequired = JSONUtils.toBoolean(question, "questionCommentRequired");
        this.fyYear=year;
        init(captionPanel);
    }

    @Override
    protected void addListeners() {
    }

    protected JSONObject getQuestionComment() {
        JSONObject entity = new JSONObject();
        entity.put("questionId", question.get("id").isString());

        if (!Strings.isNullOrEmpty((commentTB).getValue())) {
            entity.put("comment", new JSONString(((TextAreaField) commentTB).getValue()));
        }
        if (displayRating && ratingWidget.getRating() > 0) {
            entity.put("rating", new JSONString(ratingWidget.getRating().toString()));
        }
        return entity;
    }

    @Override
    protected void configure() {
        questionL.setHTML(JSONUtils.toString(question, "question"));
        questionDecriptionL.setHTML(JSONUtils.toString(question, "questionInfo"));
    }

    public boolean validate() {
        if (isCommentRequired) {
            if (Strings.isNullOrEmpty(((TextAreaField) commentTB).getValue())) {
                commentTB.setMessage("Please enter comments");
                return false;
            }
        }
        if (isRatingRequired && ratingWidget.getRating() <= 0) {
            new ResponseStatusWidget().show("Rating is required");
            ratingWidget.setErrorStyle();
            return false;
        }
        return true;
    }

    public void clearMessages() {
    }

    @Override
    protected void addWidgets() {
        commentTB = new TextAreaField(OfficeWelcome.constants, "comment", "Comment", false, isCommentRequired, Alignment.VERTICAL);
        commentTB.getTextbox().setCharacterWidth(75);
        commentTB.getTextbox().setVisibleLines(4);
        ratingWidget = new RatingWidget(5, isRatingRequired, false);
        ratingWidget.setPresenter(this);
        panel.add(questionL);
        panel.add(questionDecriptionL);
        if (displayComment) {
            panel.add(commentTB);
        }
        if (displayRating) {
            panel.add(ratingWidget);
        }
        captionPanel.setContentWidget(panel);
    }

    @Override
    public void onRatingChanged(int value) {
        if (PerformanceEvaluationWizard.instance() == null) {
            return;
        }
        Double rating = PerformanceEvaluationWizard.instance().getRating();
        if (rating != null && rating > 0) {
            new ResponseStatusWidget().show("Estimated Final Rating: " + PerformanceEvaluationWizard.instance().getRating().toString());
        }
    }
}
