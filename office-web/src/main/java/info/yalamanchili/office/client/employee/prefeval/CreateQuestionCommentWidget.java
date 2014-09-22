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
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.fields.RichTextField;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.RatingWidget;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class CreateQuestionCommentWidget extends ALComposite {

    private static Logger logger = Logger.getLogger(CreateQuestionCommentWidget.class.getName());
    protected CaptionPanel captionPanel = new CaptionPanel();
    protected FlowPanel panel = new FlowPanel();
    protected JSONObject question;
    protected HTML questionL = new HTML();
    protected HTML questionDecriptionL = new HTML();
    protected BaseField commentTB;
    protected RatingWidget ratingWidget = new RatingWidget(5);
    protected boolean displayRating = true;
    protected boolean useRichTextEditor = false;

    public CreateQuestionCommentWidget(JSONObject question) {
        this.question = question;
        init(captionPanel);
    }

    public CreateQuestionCommentWidget(JSONObject question, boolean displayRating, boolean useRichTextEditor) {
        this.question = question;
        this.displayRating = displayRating;
        this.useRichTextEditor = useRichTextEditor;
        init(captionPanel);
    }

    @Override
    protected void addListeners() {
    }

    protected JSONObject getQuestionComment() {
        JSONObject entity = new JSONObject();
        entity.put("id", question.get("id").isString());
        if (useRichTextEditor) {
            if (!Strings.isNullOrEmpty(((RichTextField) commentTB).getValue())) {
                entity.put("comment", new JSONString(((RichTextField) commentTB).getValue()));
                if (displayRating && ratingWidget.getRating() > 0) {
                    entity.put("rating", new JSONString(ratingWidget.getRating().toString()));
                }
            }
        } else {
            if (!Strings.isNullOrEmpty(((TextAreaField) commentTB).getValue())) {
                entity.put("comment", new JSONString(((TextAreaField) commentTB).getValue()));
                if (displayRating && ratingWidget.getRating() > 0) {
                    entity.put("rating", new JSONString(ratingWidget.getRating().toString()));
                }
            }
        }
        logger.info("aaaaaaaaaa" + entity);
        return entity;
    }

    @Override
    protected void configure() {
        questionL.setHTML(JSONUtils.toString(question, "question"));
        questionDecriptionL.setHTML(JSONUtils.toString(question, "questionInfo"));
    }

    public boolean validate() {
        return true;
    }

    public void clearMessages() {
    }

    @Override
    protected void addWidgets() {
        panel.add(questionL);
        panel.add(questionDecriptionL);
        if (useRichTextEditor) {
            commentTB = new RichTextField(OfficeWelcome.constants, "comment", "Comment", false, true, Alignment.VERTICAL);
        } else {
            commentTB = new TextAreaField(OfficeWelcome.constants, "comment", "Comment", false, true, Alignment.VERTICAL);
        }
        panel.add(commentTB);
        if (displayRating) {
            panel.add(ratingWidget);
        }
        captionPanel.setContentWidget(panel);
    }
}
