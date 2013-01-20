package info.yalamanchili.office.client.gwt;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Button;
import info.chili.gwt.utils.Utils;

public abstract class UpdateComposite extends CRUDComposite implements ClickHandler {

    Logger logger = Logger.getLogger(UpdateComposite.class.getName());
    protected boolean submited = false;
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

    @Override
    public void onClick(ClickEvent event) {
        entity = populateEntityFromFields();
        if (processClientSideValidations(entity)) {
            submitted();
            if (event.getSource() == update) {
                updateButtonClicked();
            }
        }
    }

    protected void submitted() {
        this.submited = true;
        //TODO need to enable these back after validations
//        update.setEnabled(false);
    }

    @Override
    protected void enterKeyPressed() {
        onClick(null);
    }

    protected void setButtonText(String key) {
        update.setText(Utils.getKeyValue(key, constants));
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
