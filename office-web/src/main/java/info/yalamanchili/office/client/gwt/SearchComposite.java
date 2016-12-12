/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.gwt;

import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.LongField;
import info.chili.gwt.fields.IntegerField;
import info.chili.gwt.fields.FloatField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.fields.RichTextField;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.CurrencyField;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.PasswordField;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.json.client.*;
import com.google.gwt.user.client.ui.*;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.utils.FileUtils;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.Collection;
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
    //search suggestbox
    MultiWordSuggestOracle data = new MultiWordSuggestOracle();
    protected com.google.gwt.user.client.ui.SuggestBox searchTB = new com.google.gwt.user.client.ui.SuggestBox(data);
    protected Button searchButton = new Button("Search");
    /*
     * Advanced search Panels
     */
    protected DisclosurePanel advancedSearchDP = new DisclosurePanel("Advanced Search");
    protected FlowPanel advancedSearchPanel = new FlowPanel();
    /*
     reports
     */
    protected ReportsWidget reportsW = new ReportsWidget(this);
    /*
     * attributes
     */
    protected JSONObject entity;
    protected ConstantsWithLookup constants;
    protected String entityName;
    protected Map<String, Object> fields = new HashMap<>();
    
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
        searchTB.setVisible(!disableRegularSearch());
        mainPanel.add(searchTB);
        advancedSearchDP.setContent(advancedSearchPanel);
        advancedSearchDP.addOpenHandler(new OpenHandler<DisclosurePanel>() {
            @Override
            public void onOpen(OpenEvent<DisclosurePanel> event) {
                onOpenAdvancedSearch();
            }
        });
        advancedSearchDP.addCloseHandler(new CloseHandler<DisclosurePanel>() {
            @Override
            public void onClose(CloseEvent<DisclosurePanel> event) {
                onCloseAdvancedSearch();
            }
        });
        mainPanel.add(advancedSearchDP);
        mainPanel.add(searchButton);
        //reports
        if (enableGenerateReport()) {
            configureReportsPanel();
        }
        captionPanel.setContentWidget(mainPanel);
        searchButton.addClickHandler(this);
        addListeners();
        configure();
        addWidgets();
        for (String fieldKey : fields.keySet()) {
            if (fields.get(fieldKey) instanceof SuggestBox) {
                ((SuggestBox) fields.get(fieldKey)).getValueBox().addKeyPressHandler(this);
            }
        }
        populateSearchSuggestBox();
    }
    
    protected Map<String, String> suggestionsMap = new HashMap<>();
    
    protected void onOpenAdvancedSearch() {
        populateAdvancedSuggestBoxes();
        reportsW.setVisible(true);
    }
    
    protected void onCloseAdvancedSearch() {
        reportsW.setVisible(false);
    }
    
    protected void configureReportsPanel() {
        mainPanel.add(reportsW);
    }
    
    protected abstract void populateSearchSuggestBox();
    
    protected abstract void populateAdvancedSuggestBoxes();
    
    protected abstract void addListeners();
    
    protected abstract void configure();
    
    protected abstract void addWidgets();
    
    protected String getSearchText() {
        if (searchTB.getValue() != null && searchTB.getValue().trim().length() > 0) {
            return searchTB.getValue().trim();
        } else {
            return null;
        }
    }
    /*
     * adding and getting Fields
     */
    
    protected void addField(String attributeName, DataType type) {
        if (DataType.LONG_FIELD.equals(type)) {
            LongField longField = new LongField(constants,
                    attributeName, entityName, false, false);
            fields.put(attributeName, longField);
            advancedSearchPanel.add(longField);
        }
        if (DataType.INTEGER_FIELD.equals(type)) {
            IntegerField integerField = new IntegerField(constants,
                    attributeName, entityName, false, false);
            fields.put(attributeName, integerField);
            advancedSearchPanel.add(integerField);
        }
        if (DataType.STRING_FIELD.equals(type)) {
            info.chili.gwt.widgets.SuggestBox suggestBox = new info.chili.gwt.widgets.SuggestBox(constants,
                    attributeName, entityName, false, false);
            fields.put(attributeName, suggestBox);
            advancedSearchPanel.add(suggestBox);
        }
        if (DataType.DATE_FIELD.equals(type)) {
            DateField dateField = new DateField(constants,
                    attributeName, entityName, false, false);
            fields.put(attributeName, dateField);
            advancedSearchPanel.add(dateField);
        }
        if (DataType.BOOLEAN_FIELD.equals(type)) {
            BooleanField booleanField = new BooleanField(constants,
                    attributeName, entityName, false, false);
            fields.put(attributeName, booleanField);
            advancedSearchPanel.add(booleanField);
        }
        if (DataType.FLOAT_FIELD.equals(type)) {
            FloatField floatField = new FloatField(constants,
                    attributeName, entityName, false, false);
            fields.put(attributeName, floatField);
            advancedSearchPanel.add(floatField);
        }
        if (DataType.PASSWORD_FIELD.equals(type)) {
            PasswordField passwordField = new PasswordField(constants, attributeName, entityName, false);
            fields.put(attributeName, passwordField);
            advancedSearchPanel.add(passwordField);
        }
        if (DataType.DROPDOWN_FIELD.equals(type)) {
            StringField dropDownField = new StringField(constants,
                    attributeName, entityName, false, false);
            fields.put(attributeName, dropDownField);
            advancedSearchPanel.add(dropDownField);
        }
        if (DataType.IMAGE_FIELD.equals(type)) {
            FileuploadField fileUploadPanel = new FileuploadField(constants, attributeName, entityName, "name", false) {
                @Override
                public void onUploadComplete(String res) {
                }
            };
            advancedSearchPanel.add(fileUploadPanel);
        }
        if (DataType.RICH_TEXT_AREA.equals(type)) {
            RichTextField richTextField = new RichTextField(constants, attributeName, entityName, false, false);
            richTextField.addStyleName("y-gwt-RichTextField");
            fields.put(attributeName, richTextField);
            advancedSearchPanel.add(richTextField);
        }
        if (DataType.CURRENCY_FIELD.equals(type)) {
            CurrencyField currencyField = new CurrencyField(constants, attributeName, entityName, false, false);
            currencyField.addStyleName("y-gwt-CurrencyField");
            fields.put(attributeName, currencyField);
            advancedSearchPanel.add(currencyField);
        }
    }
    
    protected void addEnumField(String key, Boolean readOnly, Boolean isRequired, String[] values) {
        EnumField enumField = new EnumField(OfficeWelcome.constants, key, entityName,
                readOnly, isRequired, values);
        fields.put(key, enumField);
        advancedSearchPanel.add(enumField);
    }
    
    protected void addDropDown(String key, SelectComposite widget) {
        fields.put(key, widget);
        advancedSearchPanel.add(widget);
    }
    
    protected void assignEntityValueFromField(String fieldKey, JSONObject entity, String propertyValue) {
        if (fields.get(fieldKey) instanceof StringField) {
            StringField field = (StringField) fields.get(fieldKey);
            if (field.getValue() != null && field.getValue().trim().length() > 0) {
                entity.put(propertyValue, new JSONString(field.getValue()));
            }
        }
        if (fields.get(fieldKey) instanceof info.chili.gwt.widgets.SuggestBox) {
            info.chili.gwt.widgets.SuggestBox field = (info.chili.gwt.widgets.SuggestBox) fields.get(fieldKey);
            if (field.getValue() != null && field.getValue().trim().length() > 0) {
                entity.put(propertyValue, new JSONString(field.getValue()));
            }
        }
        if (fields.get(fieldKey) instanceof DateField) {
            DateField field = (DateField) fields.get(fieldKey);
            if (field.getDate() != null) {
                entity.put(propertyValue, new JSONString(DateUtils.toDateString(field.getDate())));
            }
        }
        if (fields.get(fieldKey) instanceof LongField) {
            LongField field = (LongField) fields.get(fieldKey);
            if (field.getValue() != null && field.getValue().trim().length() > 0) {
                entity.put(propertyValue, new JSONString(String.valueOf(field.getValue())));
            }
        }
        if (fields.get(fieldKey) instanceof EnumField) {
            EnumField field = (EnumField) fields.get(fieldKey);
            if (field.getValue() != null && field.getValue().trim().length() > 0) {
                entity.put(propertyValue, new JSONString(field.getValue()));
            }
        }
        if (fields.get(fieldKey) instanceof BooleanField) {
            BooleanField field = (BooleanField) fields.get(fieldKey);
            if (field.getValue() != null) {
                entity.put(propertyValue, new JSONString(field.getValue().toString()));
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
    }
    // TODO convert to use getValue()

    protected void assignEntityValueFromField(String fieldKey, JSONObject entity) {
        assignEntityValueFromField(fieldKey, entity, fieldKey);
    }
    
    protected abstract JSONObject populateEntityFromFields();
    
    protected abstract void search(String searchText);
    
    protected abstract void search(JSONObject entity);
    
    protected void generateReport(JSONObject entity) {
        FileUtils.openFile(entity, getReportURL());
    }
    
    protected boolean disableRegularSearch() {
        return false;
    }
    
    protected boolean enableGenerateReport() {
        return false;
    }
    
    protected abstract void postSearchSuccess(JSONArray result);
    
    protected void processSearchResult(String result) {
        clearSearch();
        if (result == null || JSONParser.parseLenient(result).isObject() == null) {
            new ResponseStatusWidget().show("no results");
        } else {
            //TODO use size and entities attributes
            JSONObject resObj = JSONParser.parseLenient(result).isObject();
            String key = (String) resObj.keySet().toArray()[0];
            JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
            postSearchSuccess(results);
        }
    }
    
    @Override
    public void onKeyPress(KeyPressEvent event) {
        int keyCode = event.getUnicodeCharCode();
        if (keyCode == 0) {
            // Probably Firefox
            keyCode = event.getNativeEvent().getKeyCode();
        }
        if (keyCode == KeyCodes.KEY_ENTER) {
            processSearch();
        }
    }
    
    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource() == searchButton) {
            processSearch();
        }
        if (event.getSource() == reportsW.getGenerateReportButton()) {
            generateReportClicked();
        }
    }
    
    protected void generateReportClicked() {
        entity = populateEntityFromFields();
        if (entity.toString().length() > 3) {
            generateReport(entity);
        }
    }
    
    protected void processSearch() {
        if (getSearchText() != null && getSearchText().trim().length() > 0) {
            search(getSearchText());
        } else {
            entity = populateEntityFromFields();
            if (entity.toString().length() > 3) {
                search(entity);
            }
        }
    }
    
    public void loadSearchSuggestions(Collection<String> inputs) {
        data.addAll(inputs);
    }
    
    protected void clearSearch() {
        searchTB.setText("");
        for (String fieldKey : fields.keySet()) {
            if (fields.get(fieldKey) instanceof StringField) {
                StringField field = (StringField) fields.get(fieldKey);
                field.setValue("");
            }
            if (fields.get(fieldKey) instanceof info.chili.gwt.widgets.SuggestBox) {
                info.chili.gwt.widgets.SuggestBox field = (info.chili.gwt.widgets.SuggestBox) fields.get(fieldKey);
                field.setValue("");
            }
            if (fields.get(fieldKey) instanceof SelectComposite) {
                SelectComposite field = (SelectComposite) fields.get(fieldKey);
                field.getListBox().setSelectedIndex(0);
            }
            if (fields.get(fieldKey) instanceof DateField) {
                DateField field = (DateField) fields.get(fieldKey);
                field.setValue("");
            }
            if (fields.get(fieldKey) instanceof LongField) {
                LongField field = (LongField) fields.get(fieldKey);
                field.setValue("");
            }
            if (fields.get(fieldKey) instanceof EnumField) {
                EnumField field = (EnumField) fields.get(fieldKey);
                field.setSelectedIndex(0);
            }
            if (fields.get(fieldKey) instanceof BooleanField) {
                BooleanField field = (BooleanField) fields.get(fieldKey);
                //TODO
            }
        }
    }
    
    protected abstract String getSearchURI(String searchText, Integer start, Integer limit);
    
    protected abstract String getSearchURI(Integer start, Integer limit);
    
    protected String getReportURL() {
        return null;
    }
    
    protected String getReportFormat() {
        return reportsW.getReportFormat();
    }
    
    public String getValue() {
        if (searchTB.getText() != null) {
            return searchTB.getText().trim();
        } else {
            return null;
        }
    }
    
    public String getKey() {
        for (String key : suggestionsMap.keySet()) {
            if (suggestionsMap.get(key).trim().equalsIgnoreCase(getValue())) {
                return key;
            }
        }
        return null;
    }
    
}
