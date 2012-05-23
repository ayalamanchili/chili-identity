package info.yalamanchili.office.client.gwt;

import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.widgets.ClickableLink;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class TableRowOptionsWidget extends ALComposite {

	HorizontalPanel panel = new HorizontalPanel();

	protected String entityId;
	ClickableLink readLink = new ClickableLink("view");
	ClickableLink updateLink = new ClickableLink("update");
	ClickableLink deleteLink = new ClickableLink("delete");

	public enum OptionsType {
		READ, UPDATE, DELETE, READ_UPDATE, READ_UPDATE_DELETE, READ_DELETE
	};

	protected OptionsType type;

	public TableRowOptionsWidget(OptionsType type, String id) {
		this.type = type;
		init(panel);
		this.entityId = id;
	}

	@Override
	protected void addListeners() {

	}

	protected void initListeners(ClickHandler handler) {
		readLink.addClickHandler(handler);
		updateLink.addClickHandler(handler);
		deleteLink.addClickHandler(handler);

	}

	@Override
	protected void configure() {
		panel.setSpacing(3);
	}

	@Override
	protected void addWidgets() {
		if (OptionsType.READ.equals(type)) {
			panel.add(readLink);
		}
		if (OptionsType.READ_UPDATE.equals(type)) {
			panel.add(readLink);
			panel.add(updateLink);
		}
		if (OptionsType.READ_UPDATE_DELETE.equals(type)) {
			panel.add(readLink);
			panel.add(updateLink);
			panel.add(deleteLink);
		}
		if (OptionsType.READ_DELETE.equals(type)) {
			panel.add(readLink);
			panel.add(deleteLink);
		}

	}

	public ClickableLink getReadLink() {
		return readLink;
	}

	public ClickableLink getUpdateLink() {
		return updateLink;
	}

	public ClickableLink getDeleteLink() {
		return deleteLink;
	}

}
