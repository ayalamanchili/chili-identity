/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.notificationgroup;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class NotificationGroupSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(NotificationGroupSidePanel.class.getName());
    public FlowPanel notificationsidepanel = new FlowPanel();
    ClickableLink createnotificationlink = new ClickableLink("Create Notification");
    ClickableLink createnotificationGrouplink = new ClickableLink("Create Notification Group");

    public NotificationGroupSidePanel() {
        init(notificationsidepanel);
    }

    @Override
    protected void addListeners() {
        createnotificationlink.addClickHandler(this);
        createnotificationGrouplink.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.isHR()) {
            notificationsidepanel.add(createnotificationlink);
            notificationsidepanel.add(createnotificationGrouplink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createnotificationlink)) {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().entityPanel.add(new CreateNotificationPanel(CreateComposite.CreateCompositeType.CREATE));
        }
        if (event.getSource().equals(createnotificationGrouplink)) {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().entityPanel.add(new CreateNotificationGroupPanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
}
