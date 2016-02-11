/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration;

/**
 *
 * @author Madhu.Badiginchala
 */
public enum LCAStatus {

    Pending,
    Approved_Open,
    Approved_Closed,
    Withdrawn;

    public static String[] names() {
        LCAStatus[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }

}
