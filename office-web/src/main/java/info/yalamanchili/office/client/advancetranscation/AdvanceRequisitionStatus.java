/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.advancetranscation;

/**
 *
 * @author prasanthi.p
 */
public enum AdvanceRequisitionStatus {

    Open,
    Pending,
    Approved,
    Rejected,
    Completed;

    public static String[] names() {
        AdvanceRequisitionStatus[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
