package info.yalamanchili.office.client.gwt;

import info.yalamanchili.gwt.composite.BaseField;
import info.yalamanchili.gwt.date.DateUtils;
import info.yalamanchili.gwt.fields.BooleanField;
import info.yalamanchili.gwt.fields.CurrencyField;
import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.gwt.fields.DateField;
import info.yalamanchili.gwt.fields.EnumField;
import info.yalamanchili.gwt.fields.FloatField;
import info.yalamanchili.gwt.fields.IntegerField;
import info.yalamanchili.gwt.fields.LongField;
import info.yalamanchili.gwt.fields.PasswordField;
import info.yalamanchili.gwt.fields.RichTextField;
import info.yalamanchili.gwt.fields.StringField;
import info.yalamanchili.gwt.utils.Utils;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;

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

public abstract class CRUDComposite extends Composite {

	private Logger logger = Logger.getLogger(CRUDComposite.class.getName());
	/* Panels */
	protected FlowPanel basePanel = new FlowPanel();

	protected CaptionPanel entityCaptionPanel = new CaptionPanel();

	protected FlowPanel entityDisplayWidget = new FlowPanel();
	/* attributes */
	protected JSONObject entity;
	protected String entityId;
	protected ConstantsWithLookup constants;
	protected String entityName;
	protected Map<String, BaseField> fields = new HashMap<String, BaseField>();

	public JSONObject getEntity() {
		return entity;
	}

	public String getEntityId() {
		return entityId;
	}

	protected Boolean readOnly;

	protected void init(String entityName, final Boolean readOnly, ConstantsWithLookup constants) {
		initWidget(basePanel);
		this.readOnly = readOnly;
		this.entityName = entityName;
		this.constants = constants;
		addWidgetsBeforeCaptionPanel();
		entityCaptionPanel.setContentWidget(entityDisplayWidget);
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

	/* adding and getting Fields */
	protected void addField(String attributeName, Boolean readOnly, Boolean isRequired, DataType type) {
		if (DataType.LONG_FIELD.equals(type)) {
			LongField longField = new LongField(Utils.getAttributeLabel(attributeName, entityName, constants),
					attributeName, entityName, readOnly, isRequired);
			fields.put(attributeName, longField);
			entityDisplayWidget.add(longField);
		}
		if (DataType.INTEGER_FIELD.equals(type)) {
			IntegerField integerField = new IntegerField(Utils.getAttributeLabel(attributeName, entityName, constants),
					attributeName, entityName, readOnly, isRequired);
			fields.put(attributeName, integerField);
			entityDisplayWidget.add(integerField);
		}
		if (DataType.STRING_FIELD.equals(type)) {
			StringField stringField = new StringField(Utils.getAttributeLabel(attributeName, entityName, constants),
					attributeName, entityName, readOnly, isRequired);
			fields.put(attributeName, stringField);
			entityDisplayWidget.add(stringField);
		}
		if (DataType.DATE_FIELD.equals(type)) {
			DateField dateField = new DateField(Utils.getAttributeLabel(attributeName, entityName, constants),
					attributeName, entityName, readOnly, isRequired);
			fields.put(attributeName, dateField);
			entityDisplayWidget.add(dateField);
		}
		if (DataType.BOOLEAN_FIELD.equals(type)) {
			BooleanField booleanField = new BooleanField(Utils.getAttributeLabel(attributeName, entityName, constants),
					attributeName, entityName, readOnly, isRequired);
			fields.put(attributeName, booleanField);
			entityDisplayWidget.add(booleanField);
		}
		if (DataType.FLOAT_FIELD.equals(type)) {
			FloatField floatField = new FloatField(Utils.getAttributeLabel(attributeName, entityName, constants),
					attributeName, entityName, readOnly, isRequired);
			fields.put(attributeName, floatField);
			entityDisplayWidget.add(floatField);
		}
		if (DataType.PASSWORD_FIELD.equals(type)) {
			PasswordField passwordField = new PasswordField(Utils.getAttributeLabel(attributeName, entityName,
					constants), attributeName, entityName);
			fields.put(attributeName, passwordField);
			entityDisplayWidget.add(passwordField);
		}
		if (DataType.DROPDOWN_FIELD.equals(type)) {
			StringField dropDownField = new StringField(Utils.getAttributeLabel(attributeName, entityName, constants),
					attributeName, entityName, readOnly, isRequired);
			fields.put(attributeName, dropDownField);
			entityDisplayWidget.add(dropDownField);
		}
		if (DataType.IMAGE_FIELD.equals(type)) {
			//TODO fix
//			ImageField imageField = new ImageField(Utils.getAttributeLabel(attributeName, entityName, constants),
//					attributeName, entityName, readOnly, isRequired);
//			fields.put(attributeName, imageField);
//			entityDisplayWidget.add(imageField);
		}
		if (DataType.RICH_TEXT_AREA.equals(type)) {
			RichTextField richTextField = new RichTextField(Utils.getAttributeLabel(attributeName, entityName,
					constants), attributeName, entityName, readOnly, isRequired);
			richTextField.addStyleName("y-gwt-RichTextField");
			fields.put(attributeName, richTextField);
			entityDisplayWidget.add(richTextField);
		}
		if (DataType.CURRENCY_FIELD.equals(type)) {
			CurrencyField currencyField = new CurrencyField(Utils.getAttributeLabel(attributeName, entityName,
					constants), attributeName, entityName, readOnly, isRequired);
			currencyField.addStyleName("y-gwt-CurrencyField");
			fields.put(attributeName, currencyField);
			entityDisplayWidget.add(currencyField);
		}
	}

	protected void addEnumField(String key, Boolean readOnly, Boolean isRequired, String[] values) {
		EnumField enumField = new EnumField(Utils.getAttributeLabel(key, entityName, constants), key, entityName,
				readOnly, isRequired, values);
		fields.put(key, enumField);
		entityDisplayWidget.add(enumField);
	}

	protected void addDropDown(SelectComposite widget) {
		entityDisplayWidget.add(widget);
	}

	// TODO convert to use getValue()
	protected void assignEntityValueFromField(String fieldKey, JSONObject entity) {
		if (fields.get(fieldKey) instanceof StringField) {
			StringField field = (StringField) fields.get(fieldKey);
			entity.put(fieldKey, new JSONString(field.getText()));
		}
		if (fields.get(fieldKey) instanceof DateField) {
			DateField field = (DateField) fields.get(fieldKey);
			if (field.getDate() != null) {
				entity.put(fieldKey, new JSONString(DateUtils.toDateString(field.getDate())));
			}
		}
		if (fields.get(fieldKey) instanceof LongField) {
			LongField field = (LongField) fields.get(fieldKey);
			if (field.getValue() != null && field.getValue().trim().equals("")) {
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

	protected void assignFieldValueFromEntity(String fieldKey, JSONObject entity, DataType type) {
		if (fields.get(fieldKey) == null) {
			throw new RuntimeException("there is no field present with key please check the key:" + fieldKey);
		}
		if (DataType.STRING_FIELD.equals(type)) {
			StringField field = (StringField) fields.get(fieldKey);
			field.setValue(JSONUtils.toString(entity, fieldKey));
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
			field.setValue(JSONUtils.toString(entity, fieldKey));
		}
		if (DataType.BOOLEAN_FIELD.equals(type)) {
			BooleanField field = (BooleanField) fields.get(fieldKey);
			if ("true".equalsIgnoreCase(JSONUtils.toString(entity, fieldKey))) {
				field.setValue(true);
			} else if ("false".equalsIgnoreCase(JSONUtils.toString(entity, fieldKey))) {
				field.setValid(false);
			}
		}
	}

	protected abstract String getURI();

	protected void handleErrorResponse(Throwable err) {
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
	}

	protected void processValidationErrors(JSONValue errorsObj) {
		JSONArray errorsArray = JSONUtils.toJSONArray(errorsObj.isObject().get("Error"));
		for (int i = 0; i < errorsArray.size(); i++) {
			JSONObject err = (JSONObject) errorsArray.get(i);
			JSONString errSource = err.get("source").isString();
			if (errSource != null && fields.get(getErrorProperty(errSource.stringValue())) != null) {
				BaseField field = fields.get(getErrorProperty(errSource.stringValue()));
				field.setMessage(err.get("description").isString().stringValue());
			}
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
