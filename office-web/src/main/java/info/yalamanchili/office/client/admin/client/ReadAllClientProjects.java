/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.client;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.admin.project.ReadAllProjectsPanel;
import info.chili.gwt.crud.TableRowOptionsWidget;

/**
 *
 * @author anuyalamanchili
 */
public class ReadAllClientProjects extends ReadAllProjectsPanel {

    public ReadAllClientProjects(String entityId) {
        super(entityId);
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE, row, JSONUtils.toString(entity, "id"));
    }
}
