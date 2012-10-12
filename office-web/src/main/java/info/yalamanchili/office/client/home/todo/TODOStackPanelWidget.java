/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.todo;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.GenericPopup;

/**
 *
 * @author yphanikumar
 */
public class TODOStackPanelWidget extends ALComposite implements ClickHandler {

    protected ScrollPanel panel = new ScrollPanel();
    protected FlowPanel mainPanel = new FlowPanel();
    protected ClickableLink createTODOL = new ClickableLink("create");
    protected ReadAllTodosPanel readAllPanel = new ReadAllTodosPanel();

    public TODOStackPanelWidget() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        createTODOL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        createTODOL.addStyleName("createTODOL");
    }

    @Override
    protected void addWidgets() {
        mainPanel.add(createTODOL);
        mainPanel.add(readAllPanel);
        panel.add(mainPanel);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createTODOL)) {
            GenericPopup.instance().show(new CreateTodoPanel(CreateComposite.CreateCompositeType.CREATE), createTODOL.getAbsoluteLeft(), createTODOL.getAbsoluteTop());
        }
    }
}
