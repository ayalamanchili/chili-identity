/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.drive;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.Auth;

/**
 *
 * @author yphanikumar
 */
public class DriveFolderOptionsWidget extends ALComposite implements ClickHandler {

    protected FlowPanel panel = new FlowPanel();
    FolderMenuLabel createFolderL = new FolderMenuLabel("Add Sub Folder");
    FolderMenuLabel createFileL = new FolderMenuLabel("Add File");
    //Add rename options here
    FolderMenuLabel renameFoldeerL = new FolderMenuLabel("Rename Folder");
    FolderMenuLabel deleteFolderL = new FolderMenuLabel("Delete Sub Folder");

    public DriveFolderOptionsWidget() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        createFolderL.addClickHandler(this);
        createFileL.addClickHandler(this);
        renameFoldeerL.addClickHandler(this);
        deleteFolderL.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.isCorporateEmployee()) {
            panel.add(createFolderL);
            panel.add(createFileL);
            panel.add(renameFoldeerL);
            panel.add(deleteFolderL);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        GenericPopup.instance().hide(true);
        if (event.getSource().equals(createFolderL)) {
            newFolderLinkClicked();
        }
        if (event.getSource().equals(createFileL)) {
            newFileLinkClicked();
        }
        if (event.getSource().equals(deleteFolderL)) {
            deleteFolderLinkClicked();
        }
        //TODO add condition for rename folder created
        if (event.getSource().equals(renameFoldeerL)) {
            renameFolderClicked();
        }
    }

    protected void newFolderLinkClicked() {
        new GenericPopup(new CreateFolderPanel(CreateComposite.CreateCompositeType.CREATE)).show();
    }

    protected void newFileLinkClicked() {
        new GenericPopup(new CreateFilePanel()).show();
    }

    protected void renameFolderClicked() {
        new GenericPopup(new RenameFolderWidget()).show();
    }

    protected void deleteFolderLinkClicked() {
        if (Window.confirm("Are you sure? Folder and all files in this folder will be deleted")) {
            HttpService.HttpServiceAsync.instance().doPut(getDeleteURL(), null, OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                @Override
                public void onResponse(String arg0) {
                    new ResponseStatusWidget().show("Successfully Deleted Folder");
                    DriveTreePanel.instance().refresh();
                }
            });
        }
    }

    private String getDeleteURL() {
        return OfficeWelcome.instance().constants.root_url() + "drive/folder/delete/" + DriveTreePanel.instance().getSelectedNode().getEntityId();
    }

    /**
     * Extends gwt label and ad common style class
     */
    public class FolderMenuLabel extends Label {

        public FolderMenuLabel(String txt) {
            super(txt);
            this.addStyleName("folderMenuLabel");
        }
    }
}
