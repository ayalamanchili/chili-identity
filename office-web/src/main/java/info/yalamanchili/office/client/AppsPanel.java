/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class AppsPanel extends Composite {

    private static AppsPanel instance;

    public static AppsPanel instance() {
        return instance;
    }

    @UiField
    public StackLayoutPanel appsPanel;

    private static AppsPanelUiBinder uiBinder = GWT
            .create(AppsPanelUiBinder.class);

    interface AppsPanelUiBinder extends UiBinder<Widget, AppsPanel> {
    }

    public AppsPanel() {
        instance = this;
        initWidget(uiBinder.createAndBindUi(this));
    }

    public AppsPanel(String firstName) {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
