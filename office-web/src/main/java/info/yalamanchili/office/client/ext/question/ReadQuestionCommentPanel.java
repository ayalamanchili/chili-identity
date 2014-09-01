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
import com.google.gwt.user.client.ui.Label;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadQuestionCommentPanel extends ReadComposite {

    private static Logger logger = Logger.getLogger(ReadQuestionCommentPanel.class.getName());
    protected Label questionInfoL = new Label("");

    public ReadQuestionCommentPanel(JSONObject entity) {
        initReadComposite(entity, "QuestionComment", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {

    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        questionInfoL.setText(entity.get("questionInfo").isString().stringValue());
        assignFieldValueFromEntity("comment", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("rating", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        entityFieldsPanel.add(questionInfoL);
        addField("comment", true, false, DataType.RICH_TEXT_AREA);
        addField("rating", true, false, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return "";
    }
}
