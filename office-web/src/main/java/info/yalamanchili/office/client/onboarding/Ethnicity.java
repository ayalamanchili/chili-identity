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
public enum Ethnicity {
    
    Latino_Hispanic,
    Asian,
    AmericanIndian_AlaskaNative,
    Black_AfricanAmerican,
    NativeHawaiian_OtherPacificIslander,
    White,
    Unspecified;
    
    public static String[] names() {
        Ethnicity[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
    
}
