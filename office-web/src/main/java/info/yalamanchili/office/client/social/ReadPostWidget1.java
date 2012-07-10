/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.social;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import info.yalamanchili.office.client.RootLayout;

/**
 *
 * @author yalamanchili
 */
public class ReadPostWidget1 extends Composite {

    @UiField
    public FlowPanel readPostStatusPanel;
    @UiField
    public CaptionPanel readPostCenterPanel;
    private static ReadPostWidget1.ReadPostWidget1UiBinder uiBinder = GWT
            .create(ReadPostWidget1.ReadPostWidget1UiBinder.class);

    interface ReadPostWidget1UiBinder extends UiBinder<Widget, ReadPostWidget1> {
    }

    public ReadPostWidget1() {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
