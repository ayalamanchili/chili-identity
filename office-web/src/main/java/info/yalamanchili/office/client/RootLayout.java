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
import com.google.gwt.user.client.Window;
import info.yalamanchili.office.client.Feedback.FeedbackPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.GenericPopup;

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
        public FlowPanel footerPanel;
        
         @UiField
         public Anchor feedbacklnk;

	private static RootLayoutUiBinder uiBinder = GWT
			.create(RootLayoutUiBinder.class);

	interface RootLayoutUiBinder extends UiBinder<Widget, RootLayout> {
	}

	public RootLayout() {
		initWidget(uiBinder.createAndBindUi(this));
		instance = this;
		entityPanel.add(new TabPanel());
	}
        
        @UiHandler("feedbacklnk")
    void feedbacklnkclicked(ClickEvent e) {
//        Window.alert("Feedback Clicked");
             new GenericPopup(new FeedbackPanel(CreateComposite.CreateCompositeType.ADD)).show();
    }

}
