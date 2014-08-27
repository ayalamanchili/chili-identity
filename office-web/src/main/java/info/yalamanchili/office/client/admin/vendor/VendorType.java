/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendor;

/**
 *
 * @author anuyalamanchili
 */
public enum VendorType {

    TIER_ONE, THIRD_PARTY, SUB_CONTRACTOR;

    public static String[] names() {
        VendorType[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
