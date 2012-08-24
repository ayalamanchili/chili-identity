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
import info.yalamanchili.gwt.widgets.ClickableImage;
import info.yalamanchili.office.client.resources.OfficeImages;

/**
 *
 * @author anu
 */
//TODO move to chili-gwt
public class GenericPopup extends PopupPanel implements ClickHandler {

    private static GenericPopup instance;

    public static GenericPopup instance() {
        return instance;
    }
    ClickableImage closeB = new ClickableImage("close", OfficeImages.INSTANCE.closeIcon_16_16());

    private GenericPopup(Composite widget) {
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

    public static void show(Composite widget) {
        if (instance != null) {
            instance.hide();
        }
        instance = null;
        new GenericPopup(widget);
        instance.show();
    }
}
