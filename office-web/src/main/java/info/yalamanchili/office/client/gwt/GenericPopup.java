/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.gwt;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import info.chili.gwt.widgets.ClickableImage;
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

    private GenericPopup(Composite widget, int left, int top) {
        instance = this;
        this.addStyleName("genericPopup");
        FlowPanel panel = new FlowPanel();
        panel.add(closeB);
        panel.add(widget);
        setWidget(panel);
        closeB.addClickHandler(this);
        super.setPopupPosition(left, top);
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
        new GenericPopup(widget, Window.getClientWidth() / 3, Window.getClientHeight() / 3);
        instance.show();
    }

    public static void show(Composite widget, int left, int top) {
        if (instance != null) {
            instance.hide();
        }
        instance = null;
        new GenericPopup(widget, left, top);
        instance.show();
    }
}
