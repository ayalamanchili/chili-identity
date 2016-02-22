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
public enum VisaClassificationType {

    H1B_New_Cap,
    H1B_New_Cap_Exempt,
    H1B_Extension,
    H1B_Transfer,
    H1B_Amendment,
    H1B_Amendment_Extension;

    public static String[] names() {
        VisaClassificationType[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }

}
