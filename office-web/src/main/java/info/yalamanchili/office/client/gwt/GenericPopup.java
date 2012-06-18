/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.gwt;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import info.yalamanchili.office.client.profile.employee.ReadEmployeePanel;

/**
 *
 * @author anu
 */
public class GenericPopup extends PopupPanel implements ClickHandler {

    private static GenericPopup instance;

    public static GenericPopup instance() {
        return instance;
    }
    Button closeB = new Button("close");

    public GenericPopup(Composite widget) {
        instance = this;
        this.addStyleName("genericPopup");
        FlowPanel panel = new FlowPanel();
        panel.add(widget);
        panel.add(closeB);
        setWidget(panel);
        closeB.addClickHandler(this);
        super.setPopupPosition(Window.getClientWidth() / 3, Window.getClientHeight() / 3);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(closeB)) {
            this.hide();
        }
    }
}
