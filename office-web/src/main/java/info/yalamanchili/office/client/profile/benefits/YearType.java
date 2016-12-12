/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.benefits;

/**
 *
 * @author Hemanth
 */
public enum YearType {
     
    TWO_K15("2015"),
    TWO_K16("2016"),
    TWO_K17("2017"),
    TWO_K18("2018");
    
    private final String value;
    YearType(final String newValue){
     value = newValue;
    }
    
    public String getValue(){
        return value;
    }
    public static String[] names() {
        YearType[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].getValue();
        }
        return names;
    } 
    
} 
   
