/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prefeval;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.ext.question.QuestionCategory;
import info.yalamanchili.office.client.ext.question.QuestionContext;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayalamanchili
 */
public class CreateQuestionCommentsWidget extends Composite {

    public CaptionPanel captionPanel = new CaptionPanel();
    protected FlowPanel panel = new FlowPanel();
    List<CreateQuestionCommentWidget> commentWidgets = new ArrayList<>();
    protected QuestionCategory category;
    protected QuestionContext context;
    protected Boolean displayRating;
    protected Boolean displayComment;
    protected Boolean useRichTextEditor;
    protected String fyYear;

    public CreateQuestionCommentsWidget(QuestionCategory category, QuestionContext context) {
        this.category = category;
        this.context = context;
        initWidget(captionPanel);
        captionPanel.setCaptionHTML(category.name());
        captionPanel.setContentWidget(panel);
    }

    public CreateQuestionCommentsWidget(QuestionCategory category, QuestionContext context, boolean displayRating, boolean displayComment, boolean useRichTextEditor) {
        this.category = category;
        this.context = context;
        this.displayRating = displayRating;
        this.displayComment = displayComment;
        this.useRichTextEditor = useRichTextEditor;
        initWidget(captionPanel);
        captionPanel.setCaptionHTML(category.name());
        captionPanel.setContentWidget(panel);
    }

    public CreateQuestionCommentsWidget(QuestionCategory category, QuestionContext context, String year, boolean displayRating, boolean displayComment, boolean useRichTextEditor) {
        this.category = category;
        this.context = context;
        this.displayRating = displayRating;
        this.displayComment = displayComment;
        this.useRichTextEditor = useRichTextEditor;
        this.fyYear = year;
        initWidget(captionPanel);
        captionPanel.setCaptionHTML(category.name());
        captionPanel.setContentWidget(panel);
    }

    public void loadQuestions() {
        if (commentWidgets.isEmpty()) {
            HttpService.HttpServiceAsync.instance().doGet(getQuestionsUrl(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {

                        @Override
                        public void onResponse(String result) {
                            if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                                new ResponseStatusWidget().show("no results");
                            } else {
                                //TODO use size and entities attributes
                                JSONObject resObj = JSONParser.parseLenient(result).isObject();
                                String key = (String) resObj.keySet().toArray()[0];
                                JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                                populateQuestion(results);
                            }
                        }
                    });
        }
    }

    public void populateQuestion(JSONArray questions) {
        panel.clear();
        for (int i = 0; i < questions.size(); i++) {
            JSONObject obj = (JSONObject) questions.get(i);
            CreateQuestionCommentWidget commentwidget;
            if (useRichTextEditor != null || displayRating != null) {
                commentwidget = new CreateQuestionCommentWidget(obj, displayRating, displayComment, useRichTextEditor);
            } else {
                commentwidget = new CreateQuestionCommentWidget(obj, true, true, false);
            }
            commentWidgets.add(commentwidget);
            panel.add(commentwidget);
        }
    }

    public JSONArray getValues() {
        JSONArray questionComments = new JSONArray();
        int i = 0;
        for (CreateQuestionCommentWidget widget : commentWidgets) {
            JSONObject qc = widget.getQuestionComment();
            questionComments.set(i, qc);
            i++;
        }
        return questionComments;
    }

    public boolean validate() {
        int i = 0;
        for (CreateQuestionCommentWidget widget : commentWidgets) {
            if (!widget.validate()) {
                i++;
            }
        }
        if (i == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void clearMessages() {
        for (CreateQuestionCommentWidget widget : commentWidgets) {
            widget.clearMessages();
        }
    }

    public String getFyYear() {
        return fyYear;
    }

    public void setFyYear(String fyYear) {
        this.fyYear = fyYear;
    }

    protected String getQuestionsUrl() {
        if (fyYear != null) {
            return OfficeWelcome.instance().constants.root_url() + "question/query/0/100?category=" + category.name() + "&context=" + context.name() + "&fyYear=" + fyYear;
        }
        return OfficeWelcome.instance().constants.root_url() + "question/query/0/100?category=" + category.name() + "&context=" + context.name();
    }

}
