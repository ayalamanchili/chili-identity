/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.onboarding;

/**
 *
 * @author Madhu.Badiginchala
 */
public enum Relationship {

    Spouse,
    Child,
    Legal_Dependent,
    Mother,
    Father,
    Son,
    Daughter,
    Son_in_Law,
    Daughter_in_Law,
    GrandSon,
    GrandDaughter,
    Great_GrandSon,
    Great_GrandDaughter,
    Father_in_Law,
    Mother_in_Law,
    Brother_in_Law,
    Sister_in_Law,
    Nephew,
    Niece,
    Cousin,
    Uncle,
    Aunt,
    GrandUncle,
    GrandAunt,
    Husband,
    PaternalCousin,
    Friend,
    Relative,
    Sister;

    public static String[] names() {
        Relationship[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
    
    public static String[] getRelationsForDepenents() {
        Relationship[] values = values();
        String[] names = new String[3];
        for (int i = 0; i < 3; i++) {
            names[i] = values[i].name();
        }
        return names;
    }

}
