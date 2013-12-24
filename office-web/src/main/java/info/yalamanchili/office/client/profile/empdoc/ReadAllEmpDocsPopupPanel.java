/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.empdoc;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.utils.JSONUtils;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllEmpDocsPopupPanel extends ReadAllEmpDocsPanel {

    public ReadAllEmpDocsPopupPanel(String parentId) {
        super(parentId);
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    public void updateClicked(String entityId) {
    }

    @Override
    public void postDeleteSuccess() {
    }

    @Override
    protected void configureCreateButton() {
        createButton.setVisible(false);
    }

    @Override
    protected void createButtonClicked() {
    }
}
