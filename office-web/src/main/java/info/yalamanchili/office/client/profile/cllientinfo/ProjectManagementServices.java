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
public class ProjectManagementServices {
    public static List<String> getSectorsAndBusinessUnits() {
        List<String> sectors = new ArrayList<String>();
        sectors.add("SELECT");
        sectors.add("4210-COMMUNICATION SECTOR");
        sectors.add("4220-BANKING SECTOR");
        sectors.add("4230-FINANCIAL AND TRADE SECTOR");
        sectors.add("4240-RETAIL AND SALES SECTOR");
        sectors.add("4250-TECHNOLOGY SECTOR");
        sectors.add("4260-HEALTHCARE AND MEDICAL SECTOR");
        sectors.add("4270-INSURANCE SECTOR");
        sectors.add("4280-TRANSPORT AND MANUFACTURING SECTOR");
        sectors.add("4290-OTHER SECTORS");
        sectors.add("4291-GOVERNMENT SECTOR");
        sectors.add("4292-EDUCATION SECTOR");
        sectors.add("4299-LESS SALES DISCOUNTS");
        return sectors;
    }
}