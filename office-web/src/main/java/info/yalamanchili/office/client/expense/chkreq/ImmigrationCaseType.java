/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.chkreq;

/**
 *
 * @author prasanthi.p
 */
public enum ImmigrationCaseType {

    NEW_H1B,
    TRANSFER_H1B,
    ENTENSION_H1B;

    public static String[] names() {
        ImmigrationCaseType[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
