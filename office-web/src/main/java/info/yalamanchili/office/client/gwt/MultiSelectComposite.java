/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.gwt;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import info.yalamanchili.gwt.composite.ALComposite;

/**
 *
 * @author ayalamanchili
 */
public abstract class MultiSelectComposite extends Composite {

    protected String parentId;
    protected String name;
    protected FlowPanel panel = new FlowPanel();
    protected MultiSelectBox multiSelectBox;

    public MultiSelectComposite(String name, String parentId) {
        this.name = name;
        this.parentId = parentId;
        initWidget(panel);
        loadData();
    }

    protected abstract void loadData();

    protected abstract String getMultiSelectUrl();
}
