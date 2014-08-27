/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.tasks;

import com.google.gwt.event.dom.client.ClickEvent;
import info.chili.gwt.crud.ReadAllComposite;

/**
 *
 * @author anuyalamanchili
 */
public abstract class ReadAllTasksComposite extends ReadAllComposite<TaskTableRowOptionsWidget> {

    protected void createOptionsWidget(TaskTableRowOptionsWidget.OptionsType type, int row, String id) {
        TaskTableRowOptionsWidget rowOptionsWidget = new TaskTableRowOptionsWidget(type, id);
        createOptionsWidget(rowOptionsWidget, row, id);
    }

    @Override
    protected void createOptionsWidget(TaskTableRowOptionsWidget rowOptionsWidget, int row, String id) {
        rowOptionsWidget.initListeners(this);
        table.setWidget(row, 0, rowOptionsWidget);
        optionsWidgetMap.put(String.valueOf(row), rowOptionsWidget);
    }

    @Override
    public void onOptionsSelected(ClickEvent event, TaskTableRowOptionsWidget rowOptionsWidget) {
        if (event.getSource().equals(rowOptionsWidget.getClaimLink())) {
            claimClicked(rowOptionsWidget.getEntityId());
        }
        if (event.getSource().equals(rowOptionsWidget.getResolveLink())) {
            resolveClicked(rowOptionsWidget.getEntityId());
        }
        if (event.getSource().equals(rowOptionsWidget.getCompleteLink())) {
            completedClicked(rowOptionsWidget.getEntityId());
        }
    }

    public abstract void claimClicked(String entityId);

    public abstract void resolveClicked(String entityId);

    public abstract void completedClicked(String entityId);
}
