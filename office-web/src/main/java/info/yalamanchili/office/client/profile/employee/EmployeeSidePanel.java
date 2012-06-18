package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite.CreateCompositeType;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;

public class EmployeeSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(EmployeeSidePanel.class.getName());
    public FlowPanel employeeSidePanel = new FlowPanel();
    ClickableLink createEmployeeLink = new ClickableLink("Create Employee");

    public EmployeeSidePanel() {
        init(employeeSidePanel);
    }

    @Override
    protected void addListeners() {
        createEmployeeLink.addClickHandler(this);

    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.isHR()) {
            employeeSidePanel.add(createEmployeeLink);
        }
        employeeSidePanel.add(new SearchEmployeePanel());
    }

    @Override
    public void onClick(ClickEvent clickEvent) {
        if (clickEvent.getSource().equals(createEmployeeLink)) {
            TabPanel.instance().myOfficePanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateEmployeePanel(CreateCompositeType.CREATE));
        }

    }
}
