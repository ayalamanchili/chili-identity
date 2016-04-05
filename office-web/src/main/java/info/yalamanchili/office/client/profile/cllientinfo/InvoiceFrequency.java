/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.cllientinfo;

/**
 *
 * @author anuyalamanchili
 */
public enum InvoiceFrequency {

    WEEKLY,
    WEEKLY_ENDING_FRIDAY,
    WEEKLY_ENDING_SUNDAY,
    WEEKLY_MON_TO_SUN,
    SCHEDULED,
    BI_WEEKLY,
    MONTHLY,
    MONTHLY_LAST_FRIDAY,
    MONTHLY_LAST_SATURDAY,
    MONTHLY_EVERY_4_WEEKS,
    WEEKLY_CSV_EXCEL_SHEET,
    MONTHLY_FIRST_SUNDAY,
    WEEKLY_TO_BE_UPLOADED,
    SEMI_MONTHLY,
    NOT_REQUIRED;

    public static String[] names() {
        InvoiceFrequency[] invoiceFrequencies = values();
        String[] names = new String[invoiceFrequencies.length];

        for (int i = 0; i < invoiceFrequencies.length; i++) {
            names[i] = invoiceFrequencies[i].name();
        }

        return names;
    }
}
