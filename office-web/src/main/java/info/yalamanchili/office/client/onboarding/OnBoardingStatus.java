/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.onboarding;

/**
 *
 * @author Madhu.Badiginchala
 */
public enum OnBoardingStatus {

    Pending_Initial_Document_Submission,
    Pending_Document_Verification,
    Pending_Background_Check,
    Pending_EVerify,
    Pending_Payroll_Registration,
    Pending_Network_Team_Provisioning,
    Pending_Employee_Orientation,
    Pending_HR_Validation,
    Complete,
    Rejected;

    public static String[] names() {
        OnBoardingStatus[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }

}
