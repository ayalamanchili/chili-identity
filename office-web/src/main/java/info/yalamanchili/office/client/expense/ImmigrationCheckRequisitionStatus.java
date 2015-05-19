/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense;

/**
 *
 * @author benerji.v
 */
public enum ImmigrationCheckRequisitionStatus {
    Open,
    //TODO remove pending
    Pending,
    Pending_Initial_Approval,
    Pending_Final_Approval,
    Approved,
    //TODO remove pending
    Completed,
    Rejected;
    public static String[] names() {
        ImmigrationCheckRequisitionStatus[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
