/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expensereports;

/**
 *
 * @author Kishore.Chigurupati
 */
public enum Department {
    BusinessManagement,
    ITProjects,
    HRPayroll,
    HRImmigration,
    HRAdministration,
    AccountingandFinanceDepartment,
    RecruitingDepartment,
    OffshoreSupportandDevelopment,
    Other;

    public static String[] names() {
        Department[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
