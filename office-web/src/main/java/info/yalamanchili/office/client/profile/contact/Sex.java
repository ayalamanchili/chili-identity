/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.contact;

/**
 * @todo add comment for javadoc
 * @author ayalamanchili
 * @generated
 */
public enum Sex {

    /**
     * @generated
     */
    MALE,
    /**
     * @generated
     */
    FEMALE;

    public static String[] names() {
        Sex[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
