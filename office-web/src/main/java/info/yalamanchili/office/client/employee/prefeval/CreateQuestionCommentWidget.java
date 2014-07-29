/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prefeval;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import info.chili.gwt.composite.ALComposite;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class CreateQuestionCommentWidget extends ALComposite {

    private static Logger logger = Logger.getLogger(CreateQuestionCommentWidget.class.getName());

    protected FlowPanel panel = new FlowPanel();
    protected JSONObject question;
    protected Label questionL = new Label();
    protected Label questionDecriptionL = new Label();
    protected TextArea commentTB = new TextArea();
    protected ListBox ratingF = new ListBox();

    public CreateQuestionCommentWidget(JSONObject question) {
        this.question = question;
        init(panel);
    }

    @Override
    protected void addListeners() {

    }

    protected JSONObject getQuestionComment() {
        question.put("comment", new JSONString(commentTB.getValue()));
        question.put("rating", new JSONString(ratingF.getValue(ratingF.getSelectedIndex())));
        return question;
    }

    @Override
    protected void configure() {
        ratingF.insertItem("SELECT", "SELECT", 0);
        for (Integer i = 1; i <= 5; i++) {
            ratingF.insertItem(i.toString(), i.toString(), i);
        }
    }

    @Override
    protected void addWidgets() {
        panel.add(questionL);
        panel.add(questionDecriptionL);
        panel.add(commentTB);
        panel.add(ratingF);
    }
}
