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
 * @author benerji.v
 */
public enum ImmigrationCheckRequisitionStatus {

    PENDING_APPROVAL,
    PENDING_ACCOUNTS_PAYABLE_DISPATCH,
    COMPLETE,
    PENDING_VOID,
    VOIDED,
    REJECTED;

    public static String[] names() {
        ImmigrationCheckRequisitionStatus[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
