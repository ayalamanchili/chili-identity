/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
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
public enum SOCCodesAndOccupations {

    Computer_and_Information_Research_Scientists_15_1111,
    Computer_Systems_Analysts_15_1121,
    Information_Security_Analysts_15_1122,
    Computer_Programmers_15_1131,
    Software_Developers_Applications_15_1132,
    Software_Developers_Systems_Software_15_1133,
    Web_Developers_15_1134,
    Database_Administrators_15_1141,
    Network_and_Computer_Systems_Administrators_15_1142,
    Computer_Network_Architects_15_1143,
    Computer_User_Support_Specialists_15_1151,
    Computer_Network_Support_Specialists_15_1152,
    Computer_Occupations_All_Other_15_1199;

    public static String[] names() {
        SOCCodesAndOccupations[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }

}
