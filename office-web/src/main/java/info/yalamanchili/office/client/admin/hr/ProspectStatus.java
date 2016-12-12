/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.hr;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author radhika.mukkala
 */
public enum ProspectStatus {

    IN_PROGRESS, RECRUITING, BENCH, ONHOLD, CLOSED_WON, CLOSED_LOST, CLOSED_ONBOARDING_REQUESTED;

    public static String[] names() {
        ProspectStatus[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }

    public static String[] validStatusFor(ProspectStatus status) {
        List<String> roles = new ArrayList<String>();
        roles.add(status.name());

        switch (status) {
            case IN_PROGRESS:
                roles.add(ProspectStatus.RECRUITING.name());
                roles.add(ProspectStatus.ONHOLD.name());
                roles.add(ProspectStatus.CLOSED_WON.name());
                roles.add(ProspectStatus.CLOSED_LOST.name());
                break;
            case RECRUITING:
                roles.add(ProspectStatus.BENCH.name());
                roles.add(ProspectStatus.ONHOLD.name());
                roles.add(ProspectStatus.CLOSED_WON.name());
                roles.add(ProspectStatus.CLOSED_LOST.name());
                break;
            case BENCH:
                roles.add(ProspectStatus.ONHOLD.name());
                roles.add(ProspectStatus.CLOSED_WON.name());
                roles.add(ProspectStatus.CLOSED_LOST.name());
                break;
            case ONHOLD:
                roles.add(ProspectStatus.RECRUITING.name());
                roles.add(ProspectStatus.BENCH.name());
                roles.add(ProspectStatus.CLOSED_LOST.name());
                roles.add(ProspectStatus.CLOSED_WON.name());
                break;
            case CLOSED_WON:
                roles.add(ProspectStatus.RECRUITING.name());
                roles.add(ProspectStatus.BENCH.name());
                roles.add(ProspectStatus.ONHOLD.name());
                roles.add(ProspectStatus.CLOSED_LOST.name());
                roles.add(ProspectStatus.CLOSED_ONBOARDING_REQUESTED.name());
                break;
            case CLOSED_LOST:
                roles.add(ProspectStatus.BENCH.name());
                roles.add(ProspectStatus.ONHOLD.name());
                break;
        }
        return roles.toArray(new String[roles.size()]);
    }
}
