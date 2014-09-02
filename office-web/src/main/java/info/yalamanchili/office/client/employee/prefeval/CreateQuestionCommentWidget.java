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
import com.google.gwt.user.client.ui.RadioButton;
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
    RadioButton radioButton1 = new RadioButton("rating", "1");
    RadioButton radioButton2 = new RadioButton("rating", "2");
    RadioButton radioButton3 = new RadioButton("rating", "3");
    RadioButton radioButton4 = new RadioButton("rating", "4 ");
    RadioButton radioButton5 = new RadioButton("rating", "5");

    public CreateQuestionCommentWidget(JSONObject question) {
        this.question = question;
        init(captionPanel);
    }

    @Override
    protected void addListeners() {
    }

    protected JSONObject getQuestionComment() {
        JSONObject entity = new JSONObject();
        entity.put("id", question.get("id").isString());
        if (!Strings.isNullOrEmpty(commentTB.getValue())) {
            entity.put("comment", new JSONString(commentTB.getValue()));
        }

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
        panel.add(commentTB);
        panel.add(radioButton1);
        panel.add(radioButton2);
        panel.add(radioButton3);
        panel.add(radioButton4);
        panel.add(radioButton5);

        captionPanel.setContentWidget(panel);
    }
}
