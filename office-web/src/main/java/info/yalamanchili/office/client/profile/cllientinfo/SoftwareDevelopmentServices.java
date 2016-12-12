/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.cllientinfo;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Ramana.Lukalapu
 */
public class SoftwareDevelopmentServices {
    public static List<String> getSectorsAndBusinessUnits() {
        List<String> sectors = new ArrayList<String>();
        sectors.add("SELECT");
        sectors.add("4310-COMMUNICATION SECTOR");
        sectors.add("4320-BANKING SECTOR");
        sectors.add("4330-FINANCIAL AND TRADE SECTOR");
        sectors.add("4340-RETAIL AND SALES SECTOR");
        sectors.add("4350-TECHNOLOGY SECTOR");
        sectors.add("4360-HEALTHCARE AND MEDICAL SECTOR");
        sectors.add("4370-INSURANCE SECTOR");
        sectors.add("4380-TRANSPORT AND MANUFACTURING SECTOR");
        sectors.add("4390-OTHER SECTORS");
        sectors.add("4391-GOVERNMENT SECTOR");
        sectors.add("4392-EDUCATION SECTOR");
        sectors.add("4399-LESS SALES DISCOUNTS");
        return sectors;
    }
}