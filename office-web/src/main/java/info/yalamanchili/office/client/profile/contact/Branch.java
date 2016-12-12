/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.contact;

/**
 *
 * @author Prasanthi.p
 */
public enum Branch {

    /**
     * @generated
     */
    Hyderabad,
    /**
     * @generated
     */
    Atlanta,
    /**
     * @generated
     */
    Herndon,
    /**
     * @generated
     */
    Dallas,
    /**
     *
     */
    Tampa;

    public static String[] names() {
        Branch[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
