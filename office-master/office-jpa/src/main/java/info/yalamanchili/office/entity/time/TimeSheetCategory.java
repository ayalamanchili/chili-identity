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
    PTO_Earned,
    PTO_Spent,
    Unpaid,
    JuryDuty,
    Bereavement,
    Maternity,
    Other;

    public static List<TimeSheetCategory> getLeaveSpentCheckedCategories() {
        List<TimeSheetCategory> res = new ArrayList<TimeSheetCategory>();
        res.add(Vacation_Spent);
        res.add(PTO_Spent);
        return res;
    }

    public static List<TimeSheetCategory> getLeaveSpentCategories() {
        List<TimeSheetCategory> res = new ArrayList<TimeSheetCategory>();
        res.add(Vacation_Spent);
        res.add(PTO_Spent);
        res.add(Unpaid);
        res.add(JuryDuty);
        res.add(Bereavement);
        res.add(Maternity);
        res.add(Other);
        return res;
    }

    public static List<TimeSheetCategory> getEarnedCategories() {
        List<TimeSheetCategory> res = new ArrayList<TimeSheetCategory>();
        res.add(Vacation_Earned);
        res.add(PTO_Earned);
        res.add(Vacation_CarryForward);
        return res;
    }
}
