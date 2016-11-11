/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.chkreq;

/**
 *
 * @author Bhavana.Atluri
 */
public enum ImmigrationCaseStatus {
    New,
    Pending_Questionnaire_Submission,
    Pending_Questionnaire_Verification,
    InProgress,
    Approved,
    Request_For_Evidence,
    Rejected,
    Cancelled;
    
    public static String[] names() {
        ImmigrationCaseStatus[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
