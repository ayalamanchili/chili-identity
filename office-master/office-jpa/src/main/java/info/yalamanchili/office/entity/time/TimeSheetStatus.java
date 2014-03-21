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
public enum TimeSheetStatus {

    Saved, Pending, Approved, Rejected, Canceled;

    public static List<TimeSheetStatus> getPendingAndSavedCategories() {
        List<TimeSheetStatus> res = new ArrayList<TimeSheetStatus>();
        res.add(Saved);
        res.add(Pending);
        return res;
    }
}
