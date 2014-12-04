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

    Pending_Approval,
    Pending_Dispatch_Approval,
    Rejected,
    Completed;

    public static String[] names() {
        ExpenseReportStatus[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
