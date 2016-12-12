/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.privacy;

/**
 *
 * @author anuyalamanchili
 */
public enum PrivacyData {

    EMAILS,
    PHONES,
    ADDRESSES,
    EMERGENCY_CONTACTS,
    SKILL_SET,
    CLIENT_INFORMATION,
    DEPENDENTS,
    ALL;

    public static String[] names() {
        PrivacyData[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
