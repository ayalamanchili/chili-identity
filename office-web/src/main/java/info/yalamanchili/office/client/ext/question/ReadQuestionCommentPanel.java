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
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.RatingWidget;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadQuestionCommentPanel extends ReadComposite {

    private static Logger logger = Logger.getLogger(ReadQuestionCommentPanel.class.getName());
    protected HTML questionInfoL = new HTML("");
    protected RatingWidget ratingWidget = new RatingWidget(5, false, true);

    public ReadQuestionCommentPanel(JSONObject entity) {
        initReadComposite(entity, "QuestionComment", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {

    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        questionInfoL.setHTML(entity.get("questionInfo").isString().stringValue());
        assignFieldValueFromEntity("comment", entity, DataType.TEXT_AREA_FIELD);
        if (JSONUtils.toString(entity, "rating").isEmpty()) {
            ratingWidget.setRating(0);
        } else {
            ratingWidget.setRating(Double.valueOf(JSONUtils.toString(entity, "rating")).intValue());
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
    }

    @Override
    protected void addWidgets() {
        entityFieldsPanel.add(questionInfoL);
        addField("comment", true, false, DataType.TEXT_AREA_FIELD);
        entityFieldsPanel.add(ratingWidget);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return "";
    }
    
    @Override
   protected boolean enableBack() {
       return true;
   }
   
    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllQuestionCommentsPanel.instance;
    }
}
