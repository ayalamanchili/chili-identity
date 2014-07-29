/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.contact;

import static info.yalamanchili.office.client.profile.contact.Sex.values;

/**
 *
 * @author Prasanthi.p
 */
public enum Branch {

    /**
     * @generated
     */
    INDIA,
    /**
     * @generated
     */
    FLORIDA,
    /**
     * @generated
     */
    TAMPA,
    /**
     * @generated
     */
    HERNDON;

    public static String[] names() {
        Branch[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
