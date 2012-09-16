/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.gwt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import info.yalamanchili.gwt.composite.ALComposite;

public abstract class MultiSelectBox extends ALComposite implements ClickHandler {
    
    private Logger logger = Logger.getLogger(MultiSelectBox.class.getName());
    FlowPanel panel = new FlowPanel();
    Label titleLabel = new Label();
    ListBox availableListBox = new ListBox(true);
    ListBox selectedListBox = new ListBox(true);
    public Button selectButton = new Button("  >>  ");
    public Button unselectButton = new Button("  <<  ");
    Map<String, String> available;
    Set<String> selected;
    List<String> tempSelectedItems = new ArrayList<String>();

    /* holds the selected varialbes in temp */
    public MultiSelectBox() {
        init(panel);
    }
    
    public void popuplateWidget(String title, MultiSelectObj obj) {
        titleLabel.setText(title);
        this.available = obj.getAvailable();
        this.selected = obj.getSelected();
        for (String id : available.keySet()) {
            if (selected.contains(id)) {
                selectedListBox.insertItem(available.get(id), id.toString(),
                        new Integer(id));
            } else {
                availableListBox.insertItem(available.get(id), id.toString(),
                        new Integer(id));
            }
        }
    }
    
    @Override
    public void addWidgets() {
        panel.add(titleLabel);
        panel.add(availableListBox);
        panel.add(selectButton);
        panel.add(unselectButton);
        panel.add(selectedListBox);
    }
    
    @Override
    public void addListeners() {
        selectButton.addClickHandler(this);
        unselectButton.addClickHandler(this);
    }
    
    @Override
    public void configure() {
        availableListBox.setVisibleItemCount(10);
        selectedListBox.setVisibleItemCount(10);
        titleLabel.addStyleName("y-gwt-titleLabel");
        panel.addStyleName("y-gwt-multipleSelectWidget");
        availableListBox
                .addStyleName("y-gwt-multipleSelectWidget-availableListBox");
        selectedListBox
                .addStyleName("y-gwt-multipleSelectWidget-selectedListBox");
        selectButton.addStyleName("y-gwt-multipleSelectWidget-selectButton");
        unselectButton
                .addStyleName("y-gwt-multipleSelectWidget-unselectButton");
    }
    
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(selectButton)) {
            tempSelectedItems = new ArrayList<String>();
            for (String id : getSelectedIds(availableListBox)) {
                selectedListBox.insertItem(available.get(id), id.toString(),
                        new Integer(id));
                removeSelectedItems(availableListBox);
                tempSelectedItems.add(id);
            }
            itemsSelected(getSelectedIds());
        }
        if (event.getSource().equals(unselectButton)) {
            tempSelectedItems = new ArrayList<String>();
            for (String id : getSelectedIds(selectedListBox)) {
                availableListBox.insertItem(available.get(id), id.toString(),
                        new Integer(id));
                removeSelectedItems(selectedListBox);
                tempSelectedItems.add(id);
            }
            itemsUnselected(getSelectedIds());
        }
    }
    
    public abstract void itemsSelected(List<String> selectedIds);
    
    public abstract void itemsUnselected(List<String> selectedIds);

    /* returns the selected ids */
    public List<String> getSelectedIds() {
        return tempSelectedItems;
    }
    
    private Set<String> getSelectedIds(ListBox listBox) {
        Set<String> ids = new HashSet<String>();
        for (int i = 0; i < listBox.getItemCount(); i++) {
            if (listBox.isItemSelected(i)) {
                ids.add(listBox.getValue(i));
            }
        }
        return ids;
    }
    
    protected void removeSelectedItems(ListBox listBox) {
        for (int i = 0; i < listBox.getItemCount(); i++) {
            if (listBox.isItemSelected(i)) {
                listBox.removeItem(i);
            }
        }
    }
}
