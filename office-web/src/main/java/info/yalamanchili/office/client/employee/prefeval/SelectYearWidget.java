/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prefeval;

import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author ayalamanchili
 */
public class SelectYearWidget extends ALComposite {

    protected FlowPanel panel = new FlowPanel();
    public static String[] yearValuesArray = new String[]{"2012", "2013", "2014", "2015", "2016", "2017", "2018"};
    protected EnumField yearField = new EnumField(OfficeWelcome.constants, "year", "PerformanceEvaluation",
            false, false, yearValuesArray, Alignment.HORIZONTAL);
    HTML message = new HTML("");

    public SelectYearWidget() {
        init(panel);
    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        panel.add(yearField);
    }

    public boolean validate() {
        return true;
    }

    protected JSONString getValue() {
        if (yearField.getValue() == null) {
            return null;
        } else {
            return new JSONString(yearField.getValue());
        }
    }
}
