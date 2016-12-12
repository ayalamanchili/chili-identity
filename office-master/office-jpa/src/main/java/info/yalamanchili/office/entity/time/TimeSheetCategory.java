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
    Other,
    /**
     * There will be only one and one only PTO_ACRUED Time sheet that will be
     * used to accumulate hours on a monthly basis
     */
    PTO_ACCRUED,
    PTO_USED,
    TDL_PAID,
    TDL_UNPAID;

    public static List<TimeSheetCategory> getLeaveSpentCheckedCategories() {
        List<TimeSheetCategory> res = new ArrayList<TimeSheetCategory>();
        res.add(PTO_USED);
        res.add(TDL_PAID);
        return res;
    }

    public static List<TimeSheetCategory> getLeaveSpentCategories() {
        List<TimeSheetCategory> res = new ArrayList<TimeSheetCategory>();
        res.add(PTO_USED);
        res.add(Unpaid);
        res.add(JuryDuty);
        res.add(Bereavement);
        res.add(Maternity);
        res.add(Other);
        res.add(TDL_PAID);
        res.add(TDL_UNPAID);
        return res;
    }

    public static List<TimeSheetCategory> getEarnedCategories() {
        List<TimeSheetCategory> res = new ArrayList<TimeSheetCategory>();
        res.add(PTO_ACCRUED);
        return res;
    }
}
