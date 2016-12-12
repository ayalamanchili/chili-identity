/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.releasenotes;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author sudharani.bandaru
 */
public class ReleaseNotesSidePanel  extends ALComposite implements ClickHandler {
    
    private static Logger logger = Logger.getLogger(ReleaseNotesSidePanel.class.getName());
    public FlowPanel notesSidePanel = new FlowPanel();

    public ReleaseNotesSidePanel() {
        init(notesSidePanel);
    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        notesSidePanel.add(new SearchReleaseNotesPanel());
    }

    @Override
    public void onClick(ClickEvent event) {
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllReleaseNotesPanel());
    }
}

