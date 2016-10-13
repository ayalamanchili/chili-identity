/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.benefits;

/**
 *
 * @author Benarji.v
 */
public enum BenefitType {
    
    Health_Insurance, 
    Dental_Insurance,
    Vision_Insurance,
    Supplemental_Insurance,
    Plan_401K; 
    
    public static String[] names() {
        BenefitType[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    } 
}
