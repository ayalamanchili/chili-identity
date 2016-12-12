/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import info.yalamanchili.office.client.Feedback.FeedbackPanel;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.GenericPopup;

public class RootLayout extends Composite {

    private static RootLayout instance;

    public static RootLayout instance() {
        return instance;
    }
    @UiField
    public FlowPanel statusPanel;
    @UiField
    public FlowPanel entityPanel;
    @UiField
    public Anchor feedbacklnk;
    private static RootLayoutUiBinder uiBinder = GWT
            .create(RootLayoutUiBinder.class);

    interface RootLayoutUiBinder extends UiBinder<Widget, RootLayout> {
    }

    public RootLayout() {
        initWidget(uiBinder.createAndBindUi(this));
        instance = this;
        if (OfficeWelcome.instance().employee != null) {
            entityPanel.add(new TabPanel());
        }
    }

    @UiHandler("feedbacklnk")
    void feedbacklnkclicked(ClickEvent e) {
        new GenericPopup(new FeedbackPanel(CreateComposite.CreateCompositeType.CREATE)).show();
    }
}
