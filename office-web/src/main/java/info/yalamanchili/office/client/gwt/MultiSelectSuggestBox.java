/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.gwt;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public abstract class MultiSelectSuggestBox extends ALComposite implements KeyPressHandler, ClickHandler, BlurHandler {

    private static Logger logger = Logger.getLogger(MultiSelectSuggestBox.class.getName());
    protected FlowPanel panel = new FlowPanel();
    protected SuggestBox suggestionsBox = new SuggestBox(OfficeWelcome.constants, "search", "Employee", false, false);
    List<SuggestBoxSelectedItem> selectedItemWidgets = new ArrayList();
    protected FlowPanel selectedValuesPanel = new FlowPanel();
    Anchor addE = new Anchor("Add");
    HTML noneSelected = new HTML("<b>None selected.</b>");
    HTML info = new HTML("<fieldset class=\"lineSeperator\">" + "<legend align=\"left\">Search and press enter to add.</legend></fieldset>");
    HTML infoEnd = new HTML("<fieldset class=\"lineSeperator\"></fieldset>");

    public MultiSelectSuggestBox() {
        init(panel);
        initTosSuggesBox();
    }

    public abstract void initTosSuggesBox();

    @Override
    protected void addListeners() {
        suggestionsBox.getSuggestBox().addKeyPressHandler(this);
        suggestionsBox.getSuggestBox().getValueBox().addBlurHandler(this);
        addE.addClickHandler(this);
    }

    @Override
    protected void configure() {
        noneSelected.addStyleName("multiSelectSuggestBoxSelectedValue");
        selectedValuesPanel.addStyleName("multiSelectSuggestBoxSelectedValuesPanel");
    }

    @Override
    protected void addWidgets() {
        panel.add(suggestionsBox);
        panel.add(addE);
        panel.add(info);
        panel.add(selectedValuesPanel);
        panel.add(infoEnd);
        selectedValuesPanel.add(noneSelected);
    }

    public JSONArray getValues() {
        JSONArray array = new JSONArray();
        int i = 0;
        for (int j = 0; j < selectedValuesPanel.getWidgetCount(); j++) {
            if (selectedValuesPanel.getWidget(i) instanceof SuggestBoxSelectedItem) {
                SuggestBoxSelectedItem si = (SuggestBoxSelectedItem) selectedValuesPanel.getWidget(i);
                JSONObject to = new JSONObject();
                to.put("id", new JSONString(si.getKey()));
                to.put("value", new JSONString(si.getValue()));
                array.set(i, to);
                i++;
            }
        }
        logger.info(array.toString());
        return array;
    }

    protected void addTo() {
        if (suggestionsBox.getValue() != null && !suggestionsBox.getValue().trim().isEmpty()) {
            SuggestBoxSelectedItem selectedItem = new SuggestBoxSelectedItem(suggestionsBox.getKey().trim(), suggestionsBox.getValue().trim());
            selectedItemWidgets.add(selectedItem);
            selectedValuesPanel.add(selectedItem);
            suggestionsBox.setValue("");
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
            addTo();
        }
        if (selectedItemWidgets.size() > 0) {
            noneSelected.removeFromParent();
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if(event.getSource().equals(addE)){
            addTo();
        }
    }

    @Override
    public void onBlur(BlurEvent event) {
        if (suggestionsBox.getSelectedObject() != null) {
            addTo();
        }
        if (selectedItemWidgets.size() > 0) {
            noneSelected.removeFromParent();
        }
    }
}
