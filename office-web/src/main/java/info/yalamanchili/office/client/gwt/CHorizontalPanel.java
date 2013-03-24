/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.gwt;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import static com.google.gwt.user.client.ui.Widget.asWidgetOrNull;

/**
 * This is a substitute for gwt horizontal panel which is depreciated. it sets
 * the child widgets float css property to left.
 *
 * @author ayalamanchili
 */
public class CHorizontalPanel extends FlowPanel {

    @Override
    public void add(Widget w) {
        super.add(w);
        setFloatLeftProperty(w);
    }

    @Override
    public void insert(Widget w, int beforeIndex) {
        super.insert(w, getElement(), beforeIndex, true);
        setFloatLeftProperty(w);
    }

    protected void setFloatLeftProperty(Widget widget) {
        widget.getElement().getStyle().setProperty("float", "left");
    }
}
