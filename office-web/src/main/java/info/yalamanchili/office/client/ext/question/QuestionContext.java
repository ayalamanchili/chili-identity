/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.ext.question;

/**
 *
 * @author prasanthi.p
 */
public enum QuestionContext {

    PERFORMANCE_EVALUATION_MANGER,
    PERFORMANCE_EVALUATION_SELF,
    PROBATION_PERIOD_EVALUATION;

    public static String[] names() {
        QuestionContext[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
