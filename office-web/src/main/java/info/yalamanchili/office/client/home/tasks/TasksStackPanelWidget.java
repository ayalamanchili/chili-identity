/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.tasks;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.GenericPopup;
import info.yalamanchili.office.client.home.todo.CreateTodoPanel;

/**
 *
 * @author ayalamanchili
 */
public class TasksStackPanelWidget extends ALComposite implements ClickHandler {

    protected ScrollPanel panel = new ScrollPanel();
    protected FlowPanel mainPanel = new FlowPanel();
    protected ClickableLink newTaskL = new ClickableLink("New Task");
    protected ClickableLink myTasksL = new ClickableLink("My Tasks");

    public TasksStackPanelWidget() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        newTaskL.addClickHandler(this);
        myTasksL.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        mainPanel.add(newTaskL);
        mainPanel.add(myTasksL);
        panel.add(mainPanel);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(myTasksL)) {
            TabPanel.instance().getHomePanel().entityPanel.clear();
            TabPanel.instance().getHomePanel().entityPanel.add(new ReadAllTasks());
        }
        if (event.getSource().equals(newTaskL)) {
            new GenericPopup(new CreateTaskPanel(CreateComposite.CreateCompositeType.CREATE), newTaskL.getAbsoluteLeft(), newTaskL.getAbsoluteTop()).show();
        }
    }
}
