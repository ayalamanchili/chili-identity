/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.ext.question;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class UpdateQuestionCommentPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateQuestionCommentPanel.class.getName());
    protected HTML questionInfoL = new HTML("");

    public UpdateQuestionCommentPanel(JSONObject entity) {
        logger.info("aaaaaaaaaa"+entity);
        initUpdateComposite(entity, "QuestionComment", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("comment", entity);
        assignEntityValueFromField("rating", entity);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {

    }

    @Override
    protected void postUpdateSuccess(String result) {

    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        questionInfoL.setHTML(entity.get("questionInfo").isString().stringValue());
        assignFieldValueFromEntity("comment", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("rating", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        entityCaptionPanel.setCaptionHTML("<b>" + JSONUtils.toString(entity, "question") + "</b>");
    }

    @Override
    protected void addWidgets() {
        entityFieldsPanel.add(questionInfoL);
        addField("comment", false, false, DataType.RICH_TEXT_AREA);
        addField("rating", false, false, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return "";
    }
}
