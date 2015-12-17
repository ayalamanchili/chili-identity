/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.cllientinfo;

/**
 *
 * @author ayalamanchili
 */
public enum ClientInformationCompany {

    SSTECH_LLC,
    SSTECH_INC,
    Techpillars,
    SST_PVT,
    SST_Canada,
    CapMark_Solutions,
    ACO360,
    CGS_INC;

    public static String[] names() {
        ClientInformationCompany[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
