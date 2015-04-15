/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheet.Attendence;

/**
 *
 * @author benerji.v
 */
public enum TimeRecordCategory {
    
    Regular;
    
     public static String[] names() {
        TimeRecordCategory[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
    
}
