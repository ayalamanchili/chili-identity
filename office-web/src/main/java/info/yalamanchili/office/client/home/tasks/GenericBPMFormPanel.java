/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.tasks;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.CurrencyField;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.LongField;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public abstract class GenericBPMFormPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(GenericBPMTaskFormPanel.class.getName());
    protected JSONArray formProperties;

    public GenericBPMFormPanel() {
        super(CreateComposite.CreateCompositeType.CREATE);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        JSONArray vars = new JSONArray();
        int i = 0;
        for (String key : fields.keySet()) {
            JSONObject value = new JSONObject();
            JSONObject type = new JSONObject();
            value.put("id", new JSONString(key));
            //TODO currently support string and enum fields
            if (fields.get(key) instanceof StringField) {
                StringField stringField = (StringField) fields.get(key);
                value.put("value", new JSONString(stringField.getValue()));
                type.put("name", new JSONString("string"));
            }
            if (fields.get(key) instanceof TextAreaField) {
                TextAreaField stringField = (TextAreaField) fields.get(key);
                value.put("value", new JSONString(stringField.getValue()));
                type.put("name", new JSONString("string"));
            }
            if (fields.get(key) instanceof BooleanField) {
                BooleanField booleanField = (BooleanField) fields.get(key);
                value.put("value", new JSONString(booleanField.getValue().toString()));
                type.put("name", new JSONString("boolean"));
            }
            if (fields.get(key) instanceof LongField) {
                LongField longField = (LongField) fields.get(key);
                value.put("value", new JSONString(longField.getValue()));
                type.put("name", new JSONString("long"));
            }
            if (fields.get(key) instanceof CurrencyField) {
                CurrencyField field = (CurrencyField) fields.get(key);
                value.put("value", new JSONString(field.getValue()));
                type.put("name", new JSONString("currency"));
            }
            if (fields.get(key) instanceof DateField) {
                DateField field = (DateField) fields.get(key);
                if (field.getDate() != null) {
                    value.put("value", new JSONString(DateUtils.toDateStringForBPMN(field.getDate())));
                    type.put("name", new JSONString("date"));
                }
            }
            if (fields.get(key) instanceof EnumField) {
                EnumField enumField = (EnumField) fields.get(key);
                if (enumField.getValue() != null) {
                    value.put("value", new JSONString(enumField.getValue()));
                }
                type.put("name", new JSONString("enum"));
            }
            value.put("type", type);
            vars.set(i, value);
            i++;
        }
        entity.put("entries", vars);
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        GenericPopup.hideIfOpen();
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable arg0) {
                handleErrorResponse(arg0);
            }

            @Override
            public void onSuccess(String arg0) {
                postCreateSuccess(arg0);
            }
        });
    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected abstract void postCreateSuccess(String result);

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        setButtonText("Complete");

    }

    @Override
    protected void addWidgets() {
        if (formProperties == null) {
            return;
        }
        for (int i = 0; i < formProperties.size(); i++) {
            JSONObject formProperty = formProperties.get(i).isObject();
            boolean isRequired = JSONUtils.toString(formProperty, "required").equals("true");
            if (JSONUtils.toString(formProperty.get("type").isObject(), "name").equals("string")) {
                addField(JSONUtils.toString(formProperty, "id"), false, isRequired, DataType.TEXT_AREA_FIELD);
                TextAreaField taf = (TextAreaField) fields.get(JSONUtils.toString(formProperty, "id"));
                taf.getTextbox().setCharacterWidth(75);
                taf.getTextbox().setVisibleLines(4);
            }
            if (JSONUtils.toString(formProperty.get("type").isObject(), "name").equals("boolean")) {
                addField(JSONUtils.toString(formProperty, "id"), false, isRequired, DataType.BOOLEAN_FIELD);
            }
            if (JSONUtils.toString(formProperty.get("type").isObject(), "name").equals("long")) {
                addField(JSONUtils.toString(formProperty, "id"), false, isRequired, DataType.LONG_FIELD);
            }
            if (JSONUtils.toString(formProperty.get("type").isObject(), "name").equals("currency")) {
                addField(JSONUtils.toString(formProperty, "id"), false, isRequired, DataType.CURRENCY_FIELD);
            }
            if (JSONUtils.toString(formProperty.get("type").isObject(), "name").equals("date")) {
                addField(JSONUtils.toString(formProperty, "id"), false, isRequired, DataType.DATE_FIELD);
            }
            if (JSONUtils.toString(formProperty.get("type").isObject(), "name").equals("enum")) {
                JSONObject type = formProperty.get("type").isObject();
                JSONArray enumArray = JSONUtils.toJSONArray(type.get("values"));
                HashMap<String, String> enumVals = new HashMap<String, String>();
                for (int y = 0; y < enumArray.size(); y++) {
                    JSONObject enm = enumArray.get(y).isObject();
                    enumVals.put(JSONUtils.toString(enm, "id"), JSONUtils.toString(enm, "value"));
                }
                addEnumField(JSONUtils.toString(formProperty, "id"), false, isRequired, enumVals);
            }
            if (JSONUtils.toString(formProperty.get("type").isObject(), "name").equals("multiSelect")) {
                JSONObject type = formProperty.get("type").isObject();
                JSONArray enumArray = JSONUtils.toJSONArray(type.get("values"));
                HashMap<String, String> enumVals = new HashMap<String, String>();
                for (int y = 0; y < enumArray.size(); y++) {
                    JSONObject enm = enumArray.get(y).isObject();
                    enumVals.put(JSONUtils.toString(enm, "id"), JSONUtils.toString(enm, "value"));
                }
                String[] enumValsArray = new String[enumVals.keySet().toArray().length];
                for (int idx = 0; idx < enumVals.keySet().toArray().length; idx++) {
                    enumValsArray[idx] = enumVals.keySet().toArray()[idx].toString();
                }
                EnumField enumField = new EnumField(constants, JSONUtils.toString(formProperty, "id"), entityName,
                        readOnly, isRequired, true, enumValsArray, Alignment.VERTICAL);
                fields.put(JSONUtils.toString(formProperty, "id"), enumField);
                entityFieldsPanel.add(enumField);
            }
        }
        for (String str : fields.keySet()) {
            if (fields.get(str) instanceof StringField) {
                StringField sf = (StringField) fields.get(str);
                sf.getTextbox().setVisibleLength(80);
            }
        }
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        //TODO add task name and description;
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        boolean valid = true;
        for (int i = 0; i < formProperties.size(); i++) {
            JSONObject formProperty = formProperties.get(i).isObject();
            if (JSONUtils.toString(formProperty, "required").trim().length() > 0 && JSONUtils.toString(formProperty, "required").equals("true")) {
                BaseField field = fields.get(JSONUtils.toString(formProperty, "id"));
                if (field instanceof StringField) {
                    StringField stringField = (StringField) field;
                    if (stringField.getValue() == null || stringField.getValue().isEmpty()) {
                        stringField.setMessage("value is required");
                        valid = false;
                    }
                }
                if (field instanceof TextAreaField) {
                    TextAreaField stringField = (TextAreaField) field;
                    if (stringField.getValue() == null || stringField.getValue().isEmpty()) {
                        stringField.setMessage("value is required");
                        valid = false;
                    }
                }
                if (field instanceof LongField) {
                    LongField fld = (LongField) field;
                    if (fld.getLong() == null) {
                        fld.setMessage("value is required");
                        valid = false;
                    }
                }
                if (field instanceof CurrencyField) {
                    CurrencyField fld = (CurrencyField) field;
                    if (fld.getValue() == null) {
                        fld.setMessage("value is required");
                        valid = false;
                    }
                }
                if (field instanceof DateField) {
                    DateField fld = (DateField) field;
                    if (fld.getDate() == null) {
                        fld.setMessage("value is required");
                        valid = false;
                    }
                }
                if (field instanceof EnumField) {
                    EnumField enumField = (EnumField) field;
                    if (enumField.getValue() == null || enumField.getValue().trim().equalsIgnoreCase("SELECT")) {
                        enumField.setMessage("value is required");
                        valid = false;
                    }
                }
            }
        }
        return valid;
    }

    protected abstract String getURI();
}
