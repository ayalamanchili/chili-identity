/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;

/**
 *
 * @author raghu
 */
public class SkillSetOptionsPanel extends ALComposite implements ClickHandler {

    protected String employeeId;
    protected HorizontalPanel panel = new HorizontalPanel();
    protected ClickableLink updateSkillSetL = new ClickableLink("Update");

    public SkillSetOptionsPanel(String employeeId) {
        this.employeeId = employeeId;
        init(panel);
    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.isHR()) {
            panel.add(updateSkillSetL);
        }

    }

    @Override
    protected void addListeners() {
        updateSkillSetL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        // TODO move this to common css
        panel.setSpacing(5);

    }

    @Override
    public void onClick(ClickEvent clickEvent) {
        if (clickEvent.getSource().equals(updateSkillSetL)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateSkillSetPanel(employeeId));
        }
    }
}
