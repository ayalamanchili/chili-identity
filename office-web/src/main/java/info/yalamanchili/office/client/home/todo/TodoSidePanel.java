/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.todo;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import java.util.logging.Logger;
/**
 *
 * @author bala
 */

public class TodoSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger=Logger.getLogger(info.yalamanchili.office.client.tae.client.ClientSidePanel.class.getName());
    public FlowPanel todoSidesidepanel=new FlowPanel();
    ClickableLink createtodolink= new ClickableLink("Create Todo");
    
     public TodoSidePanel(){
        init(todoSidesidepanel);
    }
    @Override
    protected void addListeners() {
        createtodolink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        
    }

    @Override
    protected void addWidgets() {
         if (Auth.isAdmin() || Auth.isHR()) {
            todoSidesidepanel.add(createtodolink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createtodolink)) {
            TabPanel.instance().TimeandExpensePanel.entityPanel.clear();
            TabPanel.instance().TimeandExpensePanel.entityPanel.add(new CreateTodoPanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
    
}