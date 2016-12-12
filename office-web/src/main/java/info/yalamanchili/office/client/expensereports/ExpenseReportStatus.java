/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expensereports;

/**
 *
 * @author prasanthi.p
 */
public enum ExpenseReportStatus {

    PENDING_MANAGER_APPROVAL,
    PENDING_ACCOUNTS_PAYABLE_DISPATCH,
    PENDING_CEO_APPROVAL,
    REJECTED,
    APPROVED,
    SAVED;

    public static String[] names() {
        ExpenseReportStatus[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
