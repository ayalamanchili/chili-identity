/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.gwt;

import com.google.common.base.Splitter;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public abstract class MultiSelectSuggestBox extends ALComposite implements KeyPressHandler, ClickHandler {

    private static Logger logger = Logger.getLogger(MultiSelectSuggestBox.class.getName());
    protected FlowPanel panel = new FlowPanel();
    protected SuggestBox suggestionsBox = new SuggestBox(OfficeWelcome.constants, "search", "Employee", false, false);
    protected Button selectB = new Button("Add");
    protected TextAreaField valuesTA = new TextAreaField(OfficeWelcome.constants, "selected", "Employee", false, false);

    public MultiSelectSuggestBox() {
        init(panel);
        initTosSuggesBox();
    }

    public abstract void initTosSuggesBox();

    @Override
    protected void addListeners() {
        suggestionsBox.getSuggestBox().addKeyPressHandler(this);
        selectB.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        panel.add(suggestionsBox);
        panel.add(selectB);
        panel.add(valuesTA);
    }

    public JSONArray getValues() {
        JSONArray array = new JSONArray();
        int i = 0;
        for (String toStr : Splitter.on(" ").split(valuesTA.getValue())) {
            if (!toStr.trim().isEmpty()) {
                JSONObject to = new JSONObject();
                to.put("id", new JSONString(toStr.trim()));
                to.put("value", new JSONString(toStr.trim()));
                array.set(i, to);
                i++;
            }
        }
        return array;
    }

    protected void addTo() {
        if (suggestionsBox.getValue() != null && !suggestionsBox.getValue().trim().isEmpty()) {
            valuesTA.setValue(valuesTA.getValue() + " " + suggestionsBox.getKey());
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
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(selectB)) {
            addTo();
        }
    }
}
