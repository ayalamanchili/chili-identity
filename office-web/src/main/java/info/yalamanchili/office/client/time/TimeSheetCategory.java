/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time;

/**
 *
 * @author ayalamanchili
 */
public enum TimeSheetCategory {

    Regular,
    Vacation_Earned,
    Vacation_Spent,
    Vacation_CarryForward,
    Personal_Earned,
    Personal_Spent,
    Unpaid,
    Sick_Earned,
    Sick_Spent,
    JuryDuty;

    public static String[] names() {
        TimeSheetCategory[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }

}
