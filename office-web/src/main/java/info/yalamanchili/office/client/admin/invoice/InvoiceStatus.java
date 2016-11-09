/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.invoice;

/**
 *
 * @author prasanthi.p
 */
public enum InvoiceStatus {

    Estimated,
    Confirmed,
    Submitted,
    Do_Not_Send_Invoice,
    VMS_Upload;

    public static String[] names() {
        InvoiceStatus[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }

    public static String[] getValues() {
        InvoiceStatus[] values = values();
        String[] names = new String[values.length - 3];
        for (int i = 0; i < values.length - 3; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
