/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.profile;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Ramana.Lukalapu
 */
public class ConsultingServices {
    public static List<String> getSectorsAndBusinessUnits() {
        List<String> sectors = new ArrayList<String>();
        sectors.add("SELECT");
        sectors.add("4110-COMMUNICATION SECTOR");
        sectors.add("4120-BANKING SECTOR");
        sectors.add("4130-FINANCIAL AND TRADE SECTOR");
        sectors.add("4140-RETAIL AND SALES SECTOR");
        sectors.add("4150-TECHNOLOGY SECTOR");
        sectors.add("4160-HEALTHCARE AND MEDICAL SECTOR");
        sectors.add("4170-INSURANCE SECTOR");
        sectors.add("4180-TRANSPORT AND MANUFACTURING SECTOR");
        sectors.add("4190-OTHER SECTORS");
        sectors.add("4191-GOVERNMENT SECTOR");
        sectors.add("4192-EDUCATION SECTOR");
        sectors.add("4199-LESS SALES DISCOUNTS");
        return sectors;
    }
}

    

