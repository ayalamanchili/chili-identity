/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.selfservice;

import info.yalamanchili.office.client.Auth;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raghu.l
 */
public enum TicketStatus {

    Open,
    ReOpened,
    InProgress,
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

    public static String[] validStatusFor(TicketStatus status) {
        List<String> roles = new ArrayList<String>();
        roles.add(status.name());
        if (Auth.isConsultantEmployee()) {
            if (TicketStatus.Rejected.equals(status) || TicketStatus.Resolved.equals(status)) {
                roles.add(TicketStatus.ReOpened.name());
            }
            return roles.toArray(new String[roles.size()]);
        }
        switch (status) {
            case Open:
                roles.add(TicketStatus.InProgress.name());
                break;
            case InProgress:
                roles.add(TicketStatus.Rejected.name());
                roles.add(TicketStatus.Resolved.name());
                break;
            case Rejected:
                roles.add(TicketStatus.ReOpened.name());
                roles.add(TicketStatus.Resolved.name());
                break;
            case Resolved:
                roles.add(TicketStatus.ReOpened.name());
                break;
            case ReOpened:
                roles.add(TicketStatus.InProgress.name());
                break;
        }
        return roles.toArray(new String[roles.size()]);
    }

}
