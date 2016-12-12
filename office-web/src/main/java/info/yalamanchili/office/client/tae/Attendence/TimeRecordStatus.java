/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.Attendence;

/**
 *
 * @author ayalamanchili
 */
public enum TimeRecordStatus {
    

    Saved,
    Pending,
    Approved,
    Error;

    public static String[] names() {
        TimeRecordStatus[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
