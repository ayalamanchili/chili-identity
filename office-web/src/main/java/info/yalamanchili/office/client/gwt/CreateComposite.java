package info.yalamanchili.office.client.gwt;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Button;

public abstract class CreateComposite extends CRUDComposite implements ClickHandler {

    private Logger logger = Logger.getLogger(CreateComposite.class.getName());

    public enum CreateCompositeType {

        CREATE, ADD
    }
    CreateCompositeType type;

    public CreateComposite(CreateCompositeType type) {
        this.type = type;
    }
    // TODO get button names from resource bundle
    public Button create = new Button("create");
    public Button add = new Button("add");

    public void initCreateComposite(String className, final ConstantsWithLookup constants) {
        init(className, false, constants);
        if (CreateCompositeType.CREATE.equals(type)) {
            entityDisplayWidget.add(create);
            create.addClickHandler(this);
        }
        if (CreateCompositeType.ADD.equals(type)) {
            entityDisplayWidget.add(add);
            add.addClickHandler(this);
        }

        entityCaptionPanel.addStyleName("y-gwt-CreateEntityCaptionPanel");
        entityDisplayWidget.addStyleName("y-gwt-CreateEntityDisplayWidget");
        basePanel.addStyleName("y-gwt-CreateBasePanel");
    }

    protected abstract JSONObject populateEntityFromFields();

    protected abstract void createButtonClicked();

    protected abstract void addButtonClicked();

    protected abstract void postCreateSuccess(String result);

    @Override
    public void onClick(ClickEvent event) {
        entity = populateEntityFromFields();
        if (event.getSource() == create) {
            createButtonClicked();
        }
        if (event.getSource() == add) {
            addButtonClicked();
        }
    }
}
