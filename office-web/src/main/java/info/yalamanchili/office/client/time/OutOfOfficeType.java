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
public enum OutOfOfficeType {

    OUTOF_OFFICE,
    WORK_FROM_HOME;

    public static String[] names() {
        OutOfOfficeType[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
