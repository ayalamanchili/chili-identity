package info.yalamanchili.office.client.gwt;

import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.json.client.JSONObject;

public abstract class ReadComposite extends CRUDComposite {

	protected void initReadComposite(JSONObject entity, String className, final ConstantsWithLookup constants) {
		init(className, true, constants);
		entityCaptionPanel.addStyleName("y-gwt-ReadEntityCaptionPanel");
		entityDisplayWidget.addStyleName("y-gwt-ReadEntityDisplayWidget");
		basePanel.addStyleName("y-gwt-ReadBasePanel");
		this.entity = entity;
	}

	protected void initReadComposite(String id, String className, final ConstantsWithLookup constants) {
		init(className, true, constants);
		entityCaptionPanel.addStyleName("y-gwt-ReadEntityCaptionPanel");
		entityDisplayWidget.addStyleName("y-gwt-ReadEntityDisplayWidget");
		basePanel.addStyleName("y-gwt-ReadBasePanel");
		this.entityId = id;
		loadEntity(entityId);
	}

	public abstract void loadEntity(String entityId);

	public abstract void populateFieldsFromEntity(JSONObject entity);
}
