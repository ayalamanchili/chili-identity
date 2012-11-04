/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.gwt;

import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.TreeItem;

/**
 *
 * @author yphanikumar
 */
public class TreeEntityItem extends TreeItem {

    protected JSONObject entity;
    protected String entityId;
    protected String key;

    public TreeEntityItem(ConstantsWithLookup constants, String key, JSONObject entity) {
        super(key);
        this.key = key;
        this.entity = entity;
    }

    public TreeEntityItem(ConstantsWithLookup constants, String key, String entityId) {
        super(key);
        this.key = key;
        this.entityId = entityId;
    }

    public JSONObject getEntity() {
        return entity;
    }

    public String getEntityId() {
        return entityId;
    }

    public String getKey() {
        return key;
    }
}
