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
public enum VeteranStatus {
 
    I_identify_as_one_or_more_of_the_classifications_of_protected_veteran,
    I_identify_as_a_veteran_but_not_a_protected_veteran,
    I_am_not_a_veteran,
    I_do_not_wish_to_self_identify;
    
    public static String[] names() {
        VeteranStatus[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }    
}
