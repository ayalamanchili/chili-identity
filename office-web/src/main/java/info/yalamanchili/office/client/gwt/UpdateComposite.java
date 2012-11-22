package info.yalamanchili.office.client.gwt;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Button;

public abstract class UpdateComposite extends CRUDComposite implements ClickHandler {

    Logger logger = Logger.getLogger(UpdateComposite.class.getName());
    protected Button update = new Button("update");

    public void initUpdateComposite(JSONObject entity, String className, final ConstantsWithLookup constants) {
        this.entity = entity;
        init(className, false, constants);
        entityCaptionPanel.addStyleName("y-gwt-UpdateEntityCaptionPanel");
        entityDisplayWidget.addStyleName("y-gwt-UpdateEntityDisplayWidget");
        basePanel.addStyleName("y-gwt-UpdateBasePanel");
        entityDisplayWidget.add(update);
        update.addClickHandler(this);
        populateFieldsFromEntity(entity);
    }

    public void onClick(ClickEvent event) {
        entity = populateEntityFromFields();
        if (processClientSideValidations(entity)) {
            if (event.getSource() == update) {
                updateButtonClicked();
            }
        }
    }

    protected abstract JSONObject populateEntityFromFields();

    protected abstract void updateButtonClicked();

    public abstract void populateFieldsFromEntity(JSONObject entity);

    /**
     * override this method to handle any client side validation before calling
     * the server
     */
    protected boolean processClientSideValidations(JSONObject entity) {
        return true;
    }

    protected abstract void postUpdateSuccess(String result);
}
