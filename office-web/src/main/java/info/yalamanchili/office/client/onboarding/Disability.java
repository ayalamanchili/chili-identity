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

    Yes_I_Have_A_Disability,
    No_I_Dont_Have_Disability,
    I_do_not_wish_to_self_identify;
    
    public static String[] names() {
        Disability[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }      
}
