/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.gwt;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import info.chili.gwt.widgets.ClickableImage;
import info.yalamanchili.office.client.resources.OfficeImages;

public class TableRowOptionsWidget extends GenericTableRowOptionsWidget implements MouseOverHandler {

    ClickableImage readLink = new ClickableImage("view", OfficeImages.INSTANCE.viewIcon_16_16());
    ClickableImage updateLink = new ClickableImage("update", OfficeImages.INSTANCE.updateIcon_16_16());
    ClickableImage deleteLink = new ClickableImage("delete", OfficeImages.INSTANCE.deleteIcon_16_16());

    public enum OptionsType {

        READ, UPDATE, DELETE, READ_UPDATE, READ_UPDATE_DELETE, READ_DELETE, UPDATE_DELETE
    };
    protected OptionsType type;

    public TableRowOptionsWidget(OptionsType type, String id) {
        super(id);
        this.type = type;
        addWidgets();
        configure();
        addListeners();
    }

    protected void addListeners() {
        readLink.addMouseOverHandler(this);
        updateLink.addMouseOverHandler(this);
        deleteLink.addMouseOverHandler(this);
    }

    protected void initListeners(ClickHandler handler) {
        readLink.addClickHandler(handler);
        updateLink.addClickHandler(handler);
        deleteLink.addClickHandler(handler);

    }

    protected void configure() {
        readLink.addStyleName("readL");
        updateLink.addStyleName("updateLink");
        deleteLink.addStyleName("deleteLink");

    }

    protected void addWidgets() {
        if (OptionsType.READ.equals(type)) {
            panel.add(readLink);
        }
        if (OptionsType.UPDATE.equals(type)) {
            panel.add(updateLink);
        }
        if (OptionsType.DELETE.equals(type)) {
            panel.add(deleteLink);
        }
        if (OptionsType.READ_UPDATE.equals(type)) {
            panel.add(readLink);
            panel.add(updateLink);
        }
        if (OptionsType.READ_UPDATE_DELETE.equals(type)) {
            panel.add(readLink);
            panel.add(updateLink);
            panel.add(deleteLink);
        }
        if (OptionsType.READ_DELETE.equals(type)) {
            panel.add(readLink);
            panel.add(deleteLink);
        }
        if (OptionsType.UPDATE_DELETE.equals(type)) {
            panel.add(updateLink);
            panel.add(deleteLink);
        }
    }

    public ClickableImage getReadLink() {
        return readLink;
    }

    public ClickableImage getUpdateLink() {
        return updateLink;
    }

    public ClickableImage getDeleteLink() {
        return deleteLink;
    }

    @Override
    public void onMouseOver(MouseOverEvent event) {
        if (event.getSource().equals(readLink)) {
        }
        if (event.getSource().equals(updateLink)) {
        }
        if (event.getSource().equals(deleteLink)) {
        }
    }
}
