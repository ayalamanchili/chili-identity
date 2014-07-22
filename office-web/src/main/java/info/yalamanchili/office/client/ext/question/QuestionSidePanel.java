/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.ext.question;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class QuestionSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(QuestionSidePanel.class.getName());
    public FlowPanel questionSidePanel = new FlowPanel();
    ClickableLink createQuestionLink = new ClickableLink("Create Question");

    public QuestionSidePanel() {
        init(questionSidePanel);
    }

    @Override
    protected void addListeners() {
        createQuestionLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.isHR()) {
            questionSidePanel.add(createQuestionLink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createQuestionLink)) {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().entityPanel.add(new CreateQuestionPanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
}
