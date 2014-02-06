/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
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
public enum TicketStatus {
    Open,
    ReOpened,
    InProgres,
    Rejected,
    Resolved;
    
     public static String[] names() {
        TicketStatus[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
    
}
