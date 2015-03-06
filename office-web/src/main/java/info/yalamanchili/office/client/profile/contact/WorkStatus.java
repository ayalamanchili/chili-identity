/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.contact;

/**
 *
 * @author prasanthi.p
 */
public enum WorkStatus {

    /**
     * @generated
     */
    OPT,
    /**
     * @generated
     */
    H1B,
    /**
     * @generated
     */
    GREENCARD,
    /**
     * @generated
     */
    CITIZEN;

    public static String[] names() {
        WorkStatus[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
