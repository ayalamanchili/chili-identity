/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.gwt;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import info.chili.gwt.resources.ChiliImages;
import info.chili.gwt.widgets.ClickableImage;

/**
 *
 * @author ayalamanchili
 */
public class SuggestBoxSelectedItem extends Composite implements ClickHandler {

    FlowPanel panel = new FlowPanel();
    protected ClickableImage deleteIcn = new ClickableImage("delete", ChiliImages.INSTANCE.cancelIcon_16_16());
    String key;
    String value;

    public SuggestBoxSelectedItem(String id, String value) {
        this.key = id;
        this.value = value;
        initWidget(panel);
        Label l = new Label(value);
        l.addStyleName("multiSelectSuggestBoxSelectedValue");
        panel.add(l);
        panel.add(deleteIcn);
        deleteIcn.addStyleName("multiSelectSuggestBoxDeleteIcon");
        deleteIcn.addClickHandler(this);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(deleteIcn)) {
            this.removeFromParent();
        }
    }

    protected String getValue() {
        return value;
    }

    protected String getKey() {
        return key;
    }
}
