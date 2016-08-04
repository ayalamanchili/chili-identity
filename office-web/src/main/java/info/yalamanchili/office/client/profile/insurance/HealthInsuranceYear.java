/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.insurance;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prasanthi.p
 */
public class HealthInsuranceYear {

    public static List<String> getyears() {
        List<String> years = new ArrayList<String>();
        int thisYear = 2017;
        for (int i = thisYear; i >= 2013; i--) {
            years.add(Integer.toString(i));
        }
        return years;
    }
}
