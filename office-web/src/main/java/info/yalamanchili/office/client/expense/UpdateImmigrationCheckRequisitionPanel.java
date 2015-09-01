/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Madhu.Badiginchala
 */
public class UpdateImmigrationCheckRequisitionPanel extends UpdateComposite {
    
    protected SelectCompanyWidget selectCompanyWidget = new SelectCompanyWidget(true, true, Alignment.HORIZONTAL);
    protected ClickableLink addItemL = new ClickableLink("Add Check Item");
     protected List<CreateImmigrationCheckItemPanel> checkItemPanels = new ArrayList<CreateImmigrationCheckItemPanel>();

    @Override
    protected JSONObject populateEntityFromFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void updateButtonClicked() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("attorneyName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("mailingAddress", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("neededByDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("amount", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("purpose", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("requestedDate", entity, DataType.DATE_FIELD);  
        assignFieldValueFromEntity("employee", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("company", entity, null);
        assignFieldValueFromEntity("caseType", entity, DataType.ENUM_FIELD);
        
        JSONArray checkItems = JSONUtils.toJSONArray(entity.get("items"));
        populateCheckItems(checkItems);
    }
    
    protected void populateCheckItems(JSONArray items) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isObject() != null) {
////                UpdateExpenseItemPanel panel = new UpdateExpenseItemPanel(this, items.get(i).isObject());
////                updateItemPanels.add(panel);
//                entityFieldsPanel.add(panel);
            }
        }
    }

    @Override
    protected void postUpdateSuccess(String result) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void addListeners() {
        addItemL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        setButtonText("Submit");
    }

    @Override
    protected void addWidgets() {
        addField("attorneyName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("mailingAddress", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);        
        addField("neededByDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("amount", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("purpose", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("requestedDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Check Details"));
        addField("employee", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addDropDown("company", selectCompanyWidget);
        addEnumField("caseType", false, true, ImmigrationCaseType.names(), Alignment.HORIZONTAL);                              
        entityFieldsPanel.add(addItemL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getURI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
