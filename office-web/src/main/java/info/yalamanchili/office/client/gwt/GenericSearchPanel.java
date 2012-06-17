package info.yalamanchili.office.client.gwt;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;

public abstract class GenericSearchPanel extends Composite {

    @UiField
    protected CaptionPanel captionPanel;
    @UiField
    protected TextBox searchTextBox;
    @UiField
    protected Button searchButton;

    public GenericSearchPanel() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    /**
     * override this method to implement the logic to call server with the
     * search text.
     */
    @UiHandler("searchButton")
    protected abstract void onSearchClicked(ClickEvent clickEvent);
    private static GenericSearchPanelUiBinder uiBinder = GWT.create(GenericSearchPanelUiBinder.class);

    interface GenericSearchPanelUiBinder extends UiBinder<Widget, GenericSearchPanel> {
    }
}
