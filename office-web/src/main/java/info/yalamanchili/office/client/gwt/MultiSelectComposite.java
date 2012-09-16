/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.gwt;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import info.yalamanchili.gwt.composite.ALComposite;
import java.util.List;

/**
 *
 * @author ayalamanchili
 */
public abstract class MultiSelectComposite extends Composite {

    protected String parentId;
    protected String name;
    protected FlowPanel panel = new FlowPanel();
    protected MultiSelectBox multiSelectBox = new MultiSelectBox() {
        @Override
        public void selectionChanged(List<String> selectedIds) {
            MultiSelectComposite.this.selectionChanged(selectedIds);
        }
    };

    public MultiSelectComposite(String name, String parentId) {
        this.name = name;
        this.parentId = parentId;
        initWidget(panel);
        panel.add(multiSelectBox);
        loadData();
    }

    protected abstract void selectionChanged(List<String> selectedIds);

    protected abstract void loadData();

    protected abstract String getMultiSelectUrl();
}
