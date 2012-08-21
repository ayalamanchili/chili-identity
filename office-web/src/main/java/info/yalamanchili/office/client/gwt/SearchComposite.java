/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.gwt;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.json.client.*;
import info.yalamanchili.gwt.fields.*;
import com.google.gwt.user.client.ui.*;
import info.yalamanchili.gwt.composite.BaseField;
import info.yalamanchili.gwt.date.DateUtils;
import info.yalamanchili.gwt.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author yalamanchili
 */
public abstract class SearchComposite extends Composite implements ClickHandler, KeyPressHandler {

    private Logger logger = Logger.getLogger(SearchComposite.class.getName());
    /*
     * Panels
     */
    protected CaptionPanel captionPanel = new CaptionPanel();
    protected FlowPanel mainPanel = new FlowPanel();
    protected TextBox searchTB = new TextBox();
    protected Button searchButton = new Button("Search");
    /*
     * Advanced search Panels
     */
    protected DisclosurePanel disclosurePanel = new DisclosurePanel("Advanced Search");
    protected FlowPanel advancedSearchPanel = new FlowPanel();
    /*
     * attributes
     */
    protected JSONObject entity;
    protected ConstantsWithLookup constants;
    protected String entityName;
    protected Map<String, BaseField> fields = new HashMap<String, BaseField>();

    public JSONObject getEntity() {
        return entity;
    }

    protected void init(String title, String entityName, ConstantsWithLookup constants) {
        initWidget(captionPanel);
        this.entityName = entityName;
        this.constants = constants;
        captionPanel.setCaptionHTML(title);
        searchTB.addStyleName("searchComposite");
        searchTB.addKeyPressHandler(this);
        mainPanel.add(searchTB);
        disclosurePanel.setContent(advancedSearchPanel);
        mainPanel.add(disclosurePanel);
        mainPanel.add(searchButton);
        captionPanel.setContentWidget(mainPanel);
        searchButton.addClickHandler(this);
        addListeners();
        configure();
        addWidgets();
    }

    protected abstract void addListeners();

    protected abstract void configure();

    protected abstract void addWidgets();

    protected String getSearchText() {
        return searchTB.getText();
    }
    /*
     * adding and getting Fields
     */

    protected void addField(String attributeName, DataType type) {
        if (DataType.LONG_FIELD.equals(type)) {
            LongField longField = new LongField(Utils.getAttributeLabel(attributeName, entityName, constants),
                    attributeName, entityName, false, false);
            fields.put(attributeName, longField);
            advancedSearchPanel.add(longField);
        }
        if (DataType.INTEGER_FIELD.equals(type)) {
            IntegerField integerField = new IntegerField(Utils.getAttributeLabel(attributeName, entityName, constants),
                    attributeName, entityName, false, false);
            fields.put(attributeName, integerField);
            advancedSearchPanel.add(integerField);
        }
        if (DataType.STRING_FIELD.equals(type)) {
            StringField stringField = new StringField(Utils.getAttributeLabel(attributeName, entityName, constants),
                    attributeName, entityName, false, false);
            fields.put(attributeName, stringField);
            advancedSearchPanel.add(stringField);
        }
        if (DataType.DATE_FIELD.equals(type)) {
            DateField dateField = new DateField(Utils.getAttributeLabel(attributeName, entityName, constants),
                    attributeName, entityName, false, false);
            fields.put(attributeName, dateField);
            advancedSearchPanel.add(dateField);
        }
        if (DataType.BOOLEAN_FIELD.equals(type)) {
            BooleanField booleanField = new BooleanField(Utils.getAttributeLabel(attributeName, entityName, constants),
                    attributeName, entityName, false, false);
            fields.put(attributeName, booleanField);
            advancedSearchPanel.add(booleanField);
        }
        if (DataType.FLOAT_FIELD.equals(type)) {
            FloatField floatField = new FloatField(Utils.getAttributeLabel(attributeName, entityName, constants),
                    attributeName, entityName, false, false);
            fields.put(attributeName, floatField);
            advancedSearchPanel.add(floatField);
        }
        if (DataType.PASSWORD_FIELD.equals(type)) {
            PasswordField passwordField = new PasswordField(Utils.getAttributeLabel(attributeName, entityName,
                    constants), attributeName, entityName, false);
            fields.put(attributeName, passwordField);
            advancedSearchPanel.add(passwordField);
        }
        if (DataType.DROPDOWN_FIELD.equals(type)) {
            StringField dropDownField = new StringField(Utils.getAttributeLabel(attributeName, entityName, constants),
                    attributeName, entityName, false, false);
            fields.put(attributeName, dropDownField);
            advancedSearchPanel.add(dropDownField);
        }
        if (DataType.IMAGE_FIELD.equals(type)) {
            FileUploadPanel fileUploadPanel = new FileUploadPanel(Utils.getAttributeLabel(attributeName, entityName,
                    constants), "name");
            advancedSearchPanel.add(fileUploadPanel);
        }
        if (DataType.RICH_TEXT_AREA.equals(type)) {
            RichTextField richTextField = new RichTextField(Utils.getAttributeLabel(attributeName, entityName,
                    constants), attributeName, entityName, false, false);
            richTextField.addStyleName("y-gwt-RichTextField");
            fields.put(attributeName, richTextField);
            advancedSearchPanel.add(richTextField);
        }
        if (DataType.CURRENCY_FIELD.equals(type)) {
            CurrencyField currencyField = new CurrencyField(Utils.getAttributeLabel(attributeName, entityName,
                    constants), attributeName, entityName, false, false);
            currencyField.addStyleName("y-gwt-CurrencyField");
            fields.put(attributeName, currencyField);
            advancedSearchPanel.add(currencyField);
        }
    }

    protected void addEnumField(String key, Boolean readOnly, Boolean isRequired, String[] values) {
        EnumField enumField = new EnumField(Utils.getAttributeLabel(key, entityName, constants), key, entityName,
                readOnly, isRequired, values);
        fields.put(key, enumField);
        advancedSearchPanel.add(enumField);
    }

    protected void addDropDown(SelectComposite widget) {
        advancedSearchPanel.add(widget);
    }

    // TODO convert to use getValue()
    protected void assignEntityValueFromField(String fieldKey, JSONObject entity) {
        if (fields.get(fieldKey) instanceof StringField) {
            StringField field = (StringField) fields.get(fieldKey);
            if (field.getValue() != null) {
                entity.put(fieldKey, new JSONString(field.getValue()));
            }
        }
        if (fields.get(fieldKey) instanceof DateField) {
            DateField field = (DateField) fields.get(fieldKey);
            if (field.getDate() != null) {
                entity.put(fieldKey, new JSONString(DateUtils.toDateString(field.getDate())));
            }
        }
        if (fields.get(fieldKey) instanceof LongField) {
            LongField field = (LongField) fields.get(fieldKey);
            if (field.getValue() != null) {
                entity.put(fieldKey, new JSONString(String.valueOf(field.getValue())));
            }
        }
        if (fields.get(fieldKey) instanceof EnumField) {
            EnumField field = (EnumField) fields.get(fieldKey);
            if (field.getValue() != null) {
                entity.put(fieldKey, new JSONString(field.getValue()));
            }
        }
        if (fields.get(fieldKey) instanceof BooleanField) {
            BooleanField field = (BooleanField) fields.get(fieldKey);
            if (field.getValue() != null) {
                entity.put(fieldKey, new JSONString(field.getValue().toString()));
            }
        }
    }

    protected abstract JSONObject populateEntityFromFields();

    protected abstract void search(String searchText);

    protected abstract void search(JSONObject entity);

    protected abstract void postSearchSuccess(String result);

    @Override
    public void onKeyPress(KeyPressEvent event) {
        int keyCode = event.getUnicodeCharCode();
        if (keyCode == 0) {
            // Probably Firefox
            keyCode = event.getNativeEvent().getKeyCode();
        }
        if (keyCode == KeyCodes.KEY_ENTER) {
            // Do something when Enter is pressed.

            if (getSearchText() != null && getSearchText().trim().length() > 0) {
                search(getSearchText());
            } else {
                entity = populateEntityFromFields();
                if (entity.toString().length() > 3) {
                    search(entity);
                }
            }
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource() == searchButton) {
            if (getSearchText() != null && getSearchText().trim().length() > 0) {
                search(getSearchText());
            } else {
                entity = populateEntityFromFields();
                if (entity.toString().length() > 3) {
                    search(entity);
                }
            }
        }

    }

    protected abstract String getSearchURI(String searchText, Integer start, Integer limit);

    protected abstract String getSearchURI(Integer start, Integer limit);
}
