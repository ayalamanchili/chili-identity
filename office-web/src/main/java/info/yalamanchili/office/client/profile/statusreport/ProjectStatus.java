/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.statusreport;

/**
 *
 * @author prasanthi.p
 */
public enum ProjectStatus {

    OnSchedule, BehindSehedule, OnHold, AboveSchedule, Cancelled;

    public static String[] names() {
        ProjectStatus[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
