/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.gwt;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ContextMenuEvent;
import com.google.gwt.event.dom.client.ContextMenuHandler;
import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import info.chili.gwt.utils.Utils;
import info.yalamanchili.office.client.drive.DriveFolderOptionsWidget;
import info.yalamanchili.office.client.resources.OfficeImages;

/**
 *
 * @author anuyalamanchili
 *
 */
/**
 * Label with right click enabled
 */
public abstract class FolderLabel extends Label implements ContextMenuHandler {

    public FolderLabel() {
        this.addDomHandler(this, ContextMenuEvent.getType());
        this.addStyleName("folderLabel");
    }

    @Override
    public void onContextMenu(ContextMenuEvent event) {
        // stop the browser from opening the context menu
        event.preventDefault();
        event.stopPropagation();
        handleRightClick(event);

    }

    public abstract void handleRightClick(ContextMenuEvent event);
}
