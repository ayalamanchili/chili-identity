/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.gwt;

import info.chili.gwt.widgets.GenericPopup;
import com.google.gwt.event.dom.client.ContextMenuEvent;
import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.TreeItem;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.utils.Utils;
import info.yalamanchili.office.client.drive.DriveFolderOptionsWidget;

/**
 *
 * @author yphanikumar
 */
public class TreeEntityItem extends TreeItem {

    protected JSONObject entity;
    protected String entityId;
    protected String key;
    protected FolderLabel itemWIdget = new FolderLabel() {
        @Override
        public void handleRightClick(ContextMenuEvent event) {
            rightClick(event);
        }
    };

    public TreeEntityItem(ConstantsWithLookup constants, String key, JSONObject entity) {
        super();
        super.setWidget(itemWIdget);
        itemWIdget.setText(Utils.getKeyValue(key, constants));
        this.key = key;
        this.entity = entity;

    }

    public TreeEntityItem(ConstantsWithLookup constants, String key, String entityId) {
        super();
        super.setWidget(itemWIdget);
        itemWIdget.setText(Utils.getKeyValue(key, constants));
        this.key = key;
        this.entityId = entityId;

    }

    public JSONObject getEntity() {
        return entity;
    }

    public String getEntityId() {
        if (entityId == null) {
            return JSONUtils.toString(entity, "id");
        }
        return entityId;
    }

    public String getKey() {
        return key;
    }
//TODO this does not belong here

    public void rightClick(ContextMenuEvent event) {
        this.getTree().setSelectedItem(this);
        DriveFolderOptionsWidget menu = new DriveFolderOptionsWidget();
        new GenericPopup(menu, "driveMenu", event.getNativeEvent().getClientX(), event.getNativeEvent().getClientY()).show();
    }
}
