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
 * @author ayalamanchili
 */
public enum InvoiceDeliveryMethod {

    MANUAL,
    EMAIL,
    FAX,
    UPLOAD,
    DO_NOT_SEND_INVOICES;

    public static String[] names() {
        InvoiceDeliveryMethod[] invoiceDMs = values();
        String[] names = new String[invoiceDMs.length];

        for (int i = 0; i < invoiceDMs.length; i++) {
            names[i] = invoiceDMs[i].name();
        }

        return names;
    }
}
