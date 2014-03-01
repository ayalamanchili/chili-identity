/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.time;

import java.util.ArrayList;
import java.util.List;

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

    public static List<TimeSheetCategory> getLeaveSpentCategories() {
        List<TimeSheetCategory> res = new ArrayList<TimeSheetCategory>();
        res.add(Vacation_Spent);
        res.add(Sick_Spent);
        res.add(Personal_Spent);
        res.add(Unpaid);
        res.add(JuryDuty);
        return res;
    }
}
