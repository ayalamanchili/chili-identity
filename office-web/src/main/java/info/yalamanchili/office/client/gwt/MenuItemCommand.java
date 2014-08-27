/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.gwt;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.MenuItem;

/**
 *
 * @author anuyalamanchili
 */
public abstract class MenuItemCommand implements Command {

    private final MenuItem item;

    public MenuItemCommand(MenuItem item) {
        this.item = item;
    }

    @Override
    public void execute() {
        item.addStyleName(".y-gwt-SelectedMenuItem");
        menuItemClicked();
    }

    public abstract void menuItemClicked();
}
