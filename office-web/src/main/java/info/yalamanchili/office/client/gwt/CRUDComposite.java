/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.gwt;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.CurrencyField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.FloatField;
import info.chili.gwt.fields.IntegerField;
import info.chili.gwt.fields.LongField;
import info.chili.gwt.fields.PasswordField;
import info.chili.gwt.fields.RichTextField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.widgets.ResponseStatusWidget;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.listeners.KeyPressListener;

public abstract class CRUDComposite extends Composite implements KeyPressListener {

    private Logger logger = Logger.getLogger(CRUDComposite.class.getName());
    /*
     * Panels
     */
    protected FlowPanel basePanel = new FlowPanel();
    protected CaptionPanel entityCaptionPanel = new CaptionPanel();
    protected FlowPanel entityPanel = new FlowPanel();
    protected FlowPanel entityFieldsPanel = new FlowPanel();
    protected FlowPanel entityActionsPanel = new FlowPanel();
    /*
     * attributes
     */
    protected JSONObject entity;
    protected String entityId;
    protected ConstantsWithLookup constants;
    protected String entityName;
    protected Map<String, BaseField> fields = new HashMap<String, BaseField>();

    public JSONObject getEntity() {
        return entity;
    }

    public String getEntityId() {
        if (entityId == null && entity != null) {
            if (JSONUtils.toString(entity, "id") != null) {
                return JSONUtils.toString(entity, "id");
            }
        }
        return entityId;
    }
    protected Boolean readOnly;

    protected void init(String entityName, final Boolean readOnly, ConstantsWithLookup constants) {
        initWidget(basePanel);
        this.readOnly = readOnly;
        this.entityName = entityName;
        this.constants = constants;
        addWidgetsBeforeCaptionPanel();
        entityPanel.add(entityFieldsPanel);
        entityPanel.add(entityActionsPanel);
        entityCaptionPanel.setContentWidget(entityPanel);
        basePanel.add(entityCaptionPanel);
        entityCaptionPanel.setCaptionHTML(entityName);
        addListeners();
        configure();
        addWidgets();
    }

    protected abstract void addListeners();

    protected abstract void configure();

    protected abstract void addWidgets();

    protected abstract void addWidgetsBeforeCaptionPanel();

    /*
     * adding and getting Fields
     */
    protected void addField(String attributeName, Boolean readOnly, Boolean isRequired, DataType type) {
        if (DataType.LONG_FIELD.equals(type)) {
            LongField longField = new LongField(constants,
                    attributeName, entityName, readOnly, isRequired);
            longField.addEnterKeyPressesListener(this);
            fields.put(attributeName, longField);
            entityFieldsPanel.add(longField);
        }
        if (DataType.INTEGER_FIELD.equals(type)) {
            IntegerField integerField = new IntegerField(constants,
                    attributeName, entityName, readOnly, isRequired);
            integerField.addEnterKeyPressesListener(this);
            fields.put(attributeName, integerField);
            entityFieldsPanel.add(integerField);
        }
        if (DataType.STRING_FIELD.equals(type)) {
            StringField stringField = new StringField(constants,
                    attributeName, entityName, readOnly, isRequired);
            stringField.addEnterKeyPressesListener(this);
            fields.put(attributeName, stringField);
            entityFieldsPanel.add(stringField);
        }
        if (DataType.DATE_FIELD.equals(type)) {
            DateField dateField = new DateField(constants,
                    attributeName, entityName, readOnly, isRequired);
            fields.put(attributeName, dateField);
            entityFieldsPanel.add(dateField);
        }
        if (DataType.BOOLEAN_FIELD.equals(type)) {
            BooleanField booleanField = new BooleanField(constants,
                    attributeName, entityName, readOnly, isRequired);
            fields.put(attributeName, booleanField);
            entityFieldsPanel.add(booleanField);
        }
        if (DataType.FLOAT_FIELD.equals(type)) {
            FloatField floatField = new FloatField(constants,
                    attributeName, entityName, readOnly, isRequired);
            floatField.addEnterKeyPressesListener(this);
            fields.put(attributeName, floatField);
            entityFieldsPanel.add(floatField);
        }
        if (DataType.PASSWORD_FIELD.equals(type)) {
            PasswordField passwordField = new PasswordField(constants, attributeName, entityName, isRequired);
            fields.put(attributeName, passwordField);
            entityFieldsPanel.add(passwordField);
        }
        if (DataType.DROPDOWN_FIELD.equals(type)) {
            StringField dropDownField = new StringField(constants,
                    attributeName, entityName, readOnly, isRequired);
            fields.put(attributeName, dropDownField);
            entityFieldsPanel.add(dropDownField);
        }
        if (DataType.IMAGE_FIELD.equals(type)) {
            FileuploadField fileUploadPanel = new FileuploadField(constants, attributeName, entityName,
                    "name", isRequired) {
                @Override
                public void onUploadComplete() {
                }
            };
            entityFieldsPanel.add(fileUploadPanel);
        }
        if (DataType.TEXT_AREA_FIELD.equals(type)) {
            TextAreaField textAreaField = new TextAreaField(constants, attributeName, entityName, readOnly, isRequired);
            textAreaField.addStyleName("y-gwt-TextAreaField");
            fields.put(attributeName, textAreaField);
            entityFieldsPanel.add(textAreaField);
        }
        if (DataType.RICH_TEXT_AREA.equals(type)) {
            RichTextField richTextField = new RichTextField(constants, attributeName, entityName, readOnly, isRequired);
            richTextField.addStyleName("y-gwt-RichTextField");
            fields.put(attributeName, richTextField);
            entityFieldsPanel.add(richTextField);
        }
        if (DataType.CURRENCY_FIELD.equals(type)) {
            CurrencyField currencyField = new CurrencyField(constants, attributeName, entityName, readOnly, isRequired);
            currencyField.addStyleName("y-gwt-CurrencyField");
            currencyField.addEnterKeyPressesListener(this);
            fields.put(attributeName, currencyField);
            entityFieldsPanel.add(currencyField);
        }
        if (DataType.SUGGEST_FIELD.equals(type)) {
            info.chili.gwt.widgets.SuggestBox suggestBox = new info.chili.gwt.widgets.SuggestBox(constants, attributeName, entityName, readOnly, isRequired);
            fields.put(attributeName, suggestBox);
            entityFieldsPanel.add(suggestBox);
        }
    }

    protected void addEnumField(String key, Boolean readOnly, Boolean isRequired, String[] values) {
        EnumField enumField = new EnumField(constants, key, entityName,
                readOnly, isRequired, values);
        fields.put(key, enumField);
        entityFieldsPanel.add(enumField);
    }

    protected void addDropDown(String key, SelectComposite widget) {
        fields.put(key, widget);
        widget.getListBox().setEnabled(!readOnly);
        entityFieldsPanel.add(widget);
    }

    protected void assignEntityValueFromField(String fieldKey, JSONObject entity) {
        if (fields.get(fieldKey) instanceof StringField) {
            StringField field = (StringField) fields.get(fieldKey);
            if (field.getValue() != null && !field.getValue().trim().isEmpty()) {
                entity.put(fieldKey, new JSONString(field.getValue()));
            } else {
                entity.put(fieldKey, null);
            }
        }
        if (fields.get(fieldKey) instanceof TextAreaField) {
            TextAreaField field = (TextAreaField) fields.get(fieldKey);
            if (field.getValue() != null && !field.getValue().trim().isEmpty()) {
                entity.put(fieldKey, new JSONString(field.getValue()));
            } else {
                entity.put(fieldKey, null);
            }
        }
        if (fields.get(fieldKey) instanceof PasswordField) {
            PasswordField field = (PasswordField) fields.get(fieldKey);
            if (field.getPassword() != null && !field.getPassword().trim().isEmpty()) {
                entity.put(fieldKey, new JSONString(field.getPassword()));
            } else {
                entity.put(fieldKey, null);
            }
        }
        if (fields.get(fieldKey) instanceof DateField) {
            DateField field = (DateField) fields.get(fieldKey);
            if (field.getDate() != null) {
                entity.put(fieldKey, new JSONString(DateUtils.toDateString(field.getDate())));
            } else {
                entity.put(fieldKey, null);
            }
        }
        if (fields.get(fieldKey) instanceof LongField) {
            LongField field = (LongField) fields.get(fieldKey);
            if (field.getValue() != null && !field.getValue().trim().isEmpty()) {
                entity.put(fieldKey, new JSONString(String.valueOf(field.getValue())));
            } else {
                entity.put(fieldKey, null);
            }
        }
        if (fields.get(fieldKey) instanceof IntegerField) {
            IntegerField field = (IntegerField) fields.get(fieldKey);
            if (field.getValue() != null && !field.getValue().trim().isEmpty()) {
                entity.put(fieldKey, new JSONString(String.valueOf(field.getValue())));
            } else {
                entity.put(fieldKey, null);
            }
        }
        if (fields.get(fieldKey) instanceof EnumField) {
            EnumField field = (EnumField) fields.get(fieldKey);
            if (field.getValue() != null && !field.getValue().trim().isEmpty()) {
                entity.put(fieldKey, new JSONString(field.getValue()));
            } else {
                entity.put(fieldKey, null);
            }
        }
        if (fields.get(fieldKey) instanceof BooleanField) {
            BooleanField field = (BooleanField) fields.get(fieldKey);
            if (field.getValue() != null) {
                entity.put(fieldKey, new JSONString(field.getValue().toString()));
            } else {
                entity.put(fieldKey, null);
            }
        }
        if (fields.get(fieldKey) instanceof SelectComposite) {
            SelectComposite field = (SelectComposite) fields.get(fieldKey);
            if (field.getSelectedObject() != null) {
                entity.put(fieldKey, field.getSelectedObject());
            } else {
                entity.put(fieldKey, null);
            }
        }
        //Currency Field
        if (fields.get(fieldKey) instanceof CurrencyField) {
            CurrencyField field = (CurrencyField) fields.get(fieldKey);
            if (field.getValue() != null && !field.getValue().trim().isEmpty()) {
                entity.put(fieldKey, new JSONString(field.getValue()));
            } else {
                entity.put(fieldKey, null);
            }
        }
        //Float Field
        if (fields.get(fieldKey) instanceof FloatField) {
            FloatField field = (FloatField) fields.get(fieldKey);
            if (field.getValue() != null && !field.getValue().trim().isEmpty()) {
                entity.put(fieldKey, new JSONString(field.getValue()));
            } else {
                entity.put(fieldKey, null);
            }
        }
        if (fields.get(fieldKey) instanceof RichTextField) {
            RichTextField field = (RichTextField) fields.get(fieldKey);
            if (field.getValue() != null && !field.getValue().trim().isEmpty()) {
                entity.put(fieldKey, new JSONString(field.getHtml()));
            } else {
                entity.put(fieldKey, null);
            }
        }
        if (fields.get(fieldKey) instanceof info.chili.gwt.widgets.SuggestBox) {
            info.chili.gwt.widgets.SuggestBox field = (info.chili.gwt.widgets.SuggestBox) fields.get(fieldKey);
            if (field.getValue() != null && !field.getValue().trim().isEmpty()) {
                entity.put(fieldKey, new JSONString(field.getValue()));
            } else {
                entity.put(fieldKey, null);
            }
        }
    }

    protected void assignFieldValueFromEntity(String fieldKey, JSONObject entity, DataType type) {
        if (fields.get(fieldKey) == null) {
            throw new RuntimeException("there is no field present with key please check the key:" + fieldKey);
        }
        if (DataType.STRING_FIELD.equals(type)) {
            StringField field = (StringField) fields.get(fieldKey);
            field.setValue(JSONUtils.toString(entity, fieldKey));
        }
        if (DataType.TEXT_AREA_FIELD.equals(type)) {
            TextAreaField field = (TextAreaField) fields.get(fieldKey);
            field.setValue(JSONUtils.toString(entity, fieldKey));
        }
        if (DataType.RICH_TEXT_AREA.equals(type)) {
            RichTextField field = (RichTextField) fields.get(fieldKey);
            field.setHtml(JSONUtils.toString(entity, fieldKey));
        }
        if (DataType.DATE_FIELD.equals(type)) {
            DateField field = (DateField) fields.get(fieldKey);
            field.setValue(JSONUtils.toString(entity, fieldKey));
        }
        if (DataType.LONG_FIELD.equals(type)) {
            LongField field = (LongField) fields.get(fieldKey);
            field.setValue(JSONUtils.toString(entity, fieldKey));
        }
        if (DataType.ENUM_FIELD.equals(type)) {
            EnumField field = (EnumField) fields.get(fieldKey);
            field.selectValue(JSONUtils.toString(entity, fieldKey));
        }
        if (DataType.BOOLEAN_FIELD.equals(type)) {
            BooleanField field = (BooleanField) fields.get(fieldKey);
            if ("true".equalsIgnoreCase(JSONUtils.toString(entity, fieldKey))) {
                field.setValue(true);
            } else if ("false".equalsIgnoreCase(JSONUtils.toString(entity, fieldKey))) {
                field.setValid(false);
            }
        }
        // Currency Field
        if (DataType.CURRENCY_FIELD.equals(type)) {
            CurrencyField field = (CurrencyField) fields.get(fieldKey);
            field.setValue(JSONUtils.toString(entity, fieldKey));
        }
        if (DataType.SUGGEST_FIELD.equals(type)) {
            info.chili.gwt.widgets.SuggestBox field = (info.chili.gwt.widgets.SuggestBox) fields.get(fieldKey);
            field.setValue(JSONUtils.toString(entity, fieldKey));
        }
        //Float Field
        if (DataType.FLOAT_FIELD.equals(type)) {
            FloatField field = (FloatField) fields.get(fieldKey);
            field.setValue(JSONUtils.toString(entity, fieldKey));
        }
        //Dropdown
        if (fields.get(fieldKey) instanceof SelectComposite && entity.get(fieldKey) != null) {
            SelectComposite selectComposite = (SelectComposite) fields.get(fieldKey);
            selectComposite.setSelectedValue(entity.get(fieldKey).isObject());
        }
    }

    @Override
    public void keyPressed(KeyPressEvent event) {
        if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER) {
            enterKeyPressed();
        }
    }

    protected void enterKeyPressed() {
    }

    protected abstract String getURI();

    protected void clearMessages() {
        for (String fieldKey : fields.keySet()) {
            if (fields.get(fieldKey) instanceof BaseField) {
                BaseField field = fields.get(fieldKey);
                field.clearMessage();
            }
        }
    }

    protected void enableSubmitButtons() {
    }

    protected void disableSubmitButtons() {
    }

    protected void handleErrorResponse(Throwable err) {
        //TODO enhance to show generic error messages
        logger.info(err.getMessage());
        if (!err.getMessage().isEmpty() && err.getMessage().contains("Error")) {
            try {
                JSONValue errors = JSONParser.parseLenient(err.getMessage());
                processValidationErrors(errors);
            } catch (Exception e) {
                new ResponseStatusWidget().show("Call Failed");
            }
        } else {
            new ResponseStatusWidget().show("Call Failed");
        }
        enableSubmitButtons();
    }

    protected void processValidationErrors(JSONValue errorsObj) {
        clearMessages();
        JSONArray errorsArray = JSONUtils.toJSONArray(errorsObj.isObject().get("Error"));
        String genericErrorMessage = null;
        for (int i = 0; i < errorsArray.size(); i++) {
            JSONObject err = (JSONObject) errorsArray.get(i);
            JSONString errSource = err.get("source").isString();
            BaseField field = fields.get(getErrorProperty(errSource.stringValue()));
            if (errSource != null && fields.get(getErrorProperty(errSource.stringValue())) != null) {
                field.setMessage(err.get("description").isString().stringValue());
            } else {
                //Generic error not specific to any field / class level error
                if (genericErrorMessage == null) {
                    genericErrorMessage = new String();
                    genericErrorMessage = genericErrorMessage.concat("Error:");
                }
                genericErrorMessage = genericErrorMessage.concat(err.get("source").isString().stringValue() + ":" + err.get("description").isString().stringValue());
            }
        }
        if (genericErrorMessage != null) {
            new ResponseStatusWidget().show(genericErrorMessage);
        }
    }

    protected String getErrorProperty(String str) {
        if (str.contains(".")) {
            return str.substring(str.indexOf(".") + 1);
        } else {
            return str;
        }
    }
}
