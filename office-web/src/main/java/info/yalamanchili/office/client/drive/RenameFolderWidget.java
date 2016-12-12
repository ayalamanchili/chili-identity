/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.drive;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author ayalamanchili
 */
public class RenameFolderWidget extends ALComposite implements ClickHandler {

    FlowPanel panel = new FlowPanel();
    StringField stringField = new StringField(OfficeWelcome.constants,
            "name", "Folder", false, false);
    Button renameB = new Button("Rename Folder");

    public RenameFolderWidget() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        renameB.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        panel.add(stringField);
        panel.add(renameB);
    }

    @Override
    public void onClick(ClickEvent event) {
        //TODO check empty string validation
        HttpService.HttpServiceAsync.instance().doGet(getRenameURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String arg0) {
                new ResponseStatusWidget().show("Folder Renamed");
                GenericPopup.instance().hide();
                DriveTreePanel.instance().refresh();
            }
        });
    }

    protected String getRenameURI() {
        return OfficeWelcome.constants.root_url() + "drive/rename-folder/" + DriveTreePanel.instance().getSelectedNode().getEntityId() + "/" + stringField.getValue();
    }
}
