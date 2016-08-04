/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.insurance;

/**
 *
 * @author prasanthi.p
 */
public enum InsuranceCoverageType {

    Individual,
    COBRA,
    Medicare,
    Medicaid,
    TRICARE,
    EmployerSponsoredGroupPlan;

    public static String[] names() {
        InsuranceCoverageType[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
