/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prefeval;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
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
    TextAreaField commentTB = new TextAreaField(OfficeWelcome.constants, "comment", "Comment", false, true, Alignment.VERTICAL);
    String[] rating = {"1", "2", "3", "4", "5"};
    protected EnumField ratingF = new EnumField(OfficeWelcome.constants, "comment", "Comment", false, true, false, rating, Alignment.VERTICAL);

    public CreateQuestionCommentWidget(JSONObject question) {
        this.question = question;
        init(captionPanel);
    }

    @Override
    protected void addListeners() {

    }

    protected JSONObject getQuestionComment() {
        question.put("comment", new JSONString(commentTB.getValue()));
        question.put("rating", new JSONString(ratingF.getValue()));
        return question;
    }

    @Override
    protected void configure() {
        questionL.setHTML(JSONUtils.toString(question, "question"));
        questionDecriptionL.setHTML(JSONUtils.toString(question, "questionInfo"));
    }

    @Override
    protected void addWidgets() {
        panel.add(questionL);
        panel.add(questionDecriptionL);
        panel.add(commentTB);
        panel.add(ratingF);
        captionPanel.setContentWidget(panel);
    }
}
