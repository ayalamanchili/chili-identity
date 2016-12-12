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
 
    One_or_more_of_the_classifications,
    Veteran_but_not_a_protected_veteran,
    Not_a_veteran,
    Do_not_wish;
    
    public static String[] names() {
        VeteranStatus[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }    
}
