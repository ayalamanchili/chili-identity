/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.onboarding;

/**
 *
 * @author sudharani.bandaru
 */
public enum Disability {

    Have_A_Disability,
    Dont_Have_Disability,
    Do_not_wish;
    
    public static String[] names() {
        Disability[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }      
}
