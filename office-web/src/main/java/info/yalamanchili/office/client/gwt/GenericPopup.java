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
public class GenericPopup extends PopupPanel {

    private static GenericPopup instance;

    public static GenericPopup instance() {
        return instance;
    }

    public GenericPopup(Composite widget, int left, int top) {
        instance = this;
        addWidgets(widget, left, top);
        configure();
    }
     public GenericPopup(Composite widget,String styleName, int left, int top) {
        instance = this;
        addWidgets(widget, left, top);
        configure();
        useStyleName(styleName);
    }

    public GenericPopup(Composite widget) {
        addWidgets(widget, Window.getClientWidth() / 3, Window.getClientHeight() / 3);
        configure();
    }

    protected void addWidgets(Composite widget, int left, int top) {
        FlowPanel panel = new FlowPanel();
        panel.add(widget);
        setWidget(panel);
        super.setPopupPosition(left, top);
    }

    protected void configure() {
        setAutoHideEnabled(true);
        this.addStyleName("genericPopup");
    }

    public void useStyleName(String styleName) {
        this.removeStyleName("genericPopup");
        this.addStyleName(styleName);
    }
}
