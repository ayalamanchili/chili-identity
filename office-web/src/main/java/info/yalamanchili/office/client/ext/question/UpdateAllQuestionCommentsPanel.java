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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayalamanchili
 */
public class UpdateAllQuestionCommentsPanel extends ReadAllQuestionCommentsPanel {
    
    protected JSONArray questions = new JSONArray();
    protected List<UpdateQuestionCommentPanel> updatePanels = new ArrayList<UpdateQuestionCommentPanel>();
    
    public UpdateAllQuestionCommentsPanel(String title, String url) {
        super(title, url);
    }
    
    @Override
    protected void populateData(JSONArray questions) {
        for (int i = 0; i < questions.size(); i++) {
            UpdateQuestionCommentPanel updatePanel = new UpdateQuestionCommentPanel(questions.get(i).isObject());
            updatePanels.add(updatePanel);
            panel.add(updatePanel);
        }
    }
    
    public JSONArray getQuestions() {
        for (int i = 0; i < updatePanels.size(); i++) {
            logger.info( updatePanels.get(i).populateEntityFromFields().toString());
            questions.set(i, updatePanels.get(i).populateEntityFromFields());
        }
        return questions;
        
    }
}
