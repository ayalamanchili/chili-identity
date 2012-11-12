/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.gwt;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

/**
 *
 * @author anuyalamanchili
 */
public class TreeItemWidget extends Composite {

    protected FlowPanel panel = new FlowPanel();
    protected Label label;
    protected Image menuIcon;

    protected TreeItemWidget() {
        initWidget(panel);
        
    }
}
