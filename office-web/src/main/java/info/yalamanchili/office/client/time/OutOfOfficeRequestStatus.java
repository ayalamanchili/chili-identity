/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time;

/**
 *
 * @author Ramana.Lukalapu
 */
public enum OutOfOfficeRequestStatus {

    PENDING_MANAGER_APPROVAL,
    REJECTED,
    APPROVED;

    public static String[] names() {
        OutOfOfficeRequestStatus[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }

}
