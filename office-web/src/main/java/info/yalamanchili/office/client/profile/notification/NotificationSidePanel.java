/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.notification;

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
public class NotificationSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(NotificationSidePanel.class.getName());
    public FlowPanel notificationsidepanel = new FlowPanel();
    ClickableLink createnotificationlink = new ClickableLink("Create Notification");

    public NotificationSidePanel() {
        init(notificationsidepanel);
    }

    @Override
    protected void addListeners() {
        createnotificationlink.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.isHR()) {
            notificationsidepanel.add(createnotificationlink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createnotificationlink)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateNotificationPanel(CreateComposite.CreateCompositeType.CREATE));
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateNotificationGroupPanel());
        }
    }
}
