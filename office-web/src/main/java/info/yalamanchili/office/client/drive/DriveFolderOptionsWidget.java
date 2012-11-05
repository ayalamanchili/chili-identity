/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.drive;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.GenericPopup;

/**
 *
 * @author yphanikumar
 */
public class DriveFolderOptionsWidget extends ALComposite implements ClickHandler {

    protected FlowPanel panel = new FlowPanel();
    ClickableLink createFolderL = new ClickableLink("add sub folder");
    ClickableLink createFileL = new ClickableLink("add file");

    public DriveFolderOptionsWidget() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        createFolderL.addClickHandler(this);
        createFileL.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        panel.add(createFolderL);
        panel.add(createFileL);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createFolderL)) {
            newFolderLinkClicked();
        }
        if (event.getSource().equals(createFileL)) {
            newFileLinkClicked();
        }
    }

    protected void newFolderLinkClicked() {
        GenericPopup.instance().show(new CreateFolderPanel(CreateComposite.CreateCompositeType.CREATE));
    }

    protected void newFileLinkClicked() {
        GenericPopup.instance().show(new CreateFilePanel());
    }
}
