/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.ext.question;

import com.google.gwt.json.client.JSONArray;

/**
 *
 * @author ayalamanchili
 */
public class UpdateAllQuestionCommentsPanel extends ReadAllQuestionCommentsPanel {

    public UpdateAllQuestionCommentsPanel(String title, String url) {
        super(title, url);
    }

    @Override
    protected void populateData(JSONArray questions) {
        for (int i = 0; i < questions.size(); i++) {
            panel.add(new UpdateQuestionCommentPanel(questions.get(i).isObject()));
        }
    }
}
