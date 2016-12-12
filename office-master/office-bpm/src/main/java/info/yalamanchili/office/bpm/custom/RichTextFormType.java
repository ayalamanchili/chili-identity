/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.custom;

import org.activiti.engine.impl.form.AbstractFormType;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class RichTextFormType extends AbstractFormType {

    @Override
    public String getName() {
        return "richText";
    }

    @Override
    public Object convertFormValueToModelValue(String propertyValue) {
        return propertyValue;
    }

    @Override
    public String convertModelValueToFormValue(Object modelValue) {
        return modelValue != null ? modelValue.toString() : null;
    }

}
