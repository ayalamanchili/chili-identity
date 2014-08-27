/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.selfservice;

/**
 *
 * @author raghu.l
 */
public enum TicketType {

    HumanResource,
    Invoicing,
    Payroll,
    Immigration,
    HealthInsurance,
    Recruiting,
    Network,
    Other;

    public static String[] names() {
        TicketType[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
