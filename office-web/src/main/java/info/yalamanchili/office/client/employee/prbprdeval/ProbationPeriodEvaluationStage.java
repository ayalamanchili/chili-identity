/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prbprdeval;

/**
 *
 * @author benerji.v
 */
public enum ProbationPeriodEvaluationStage {

    Manager_Review,
    Employee_Acceptance,
    HR_Approval,
    Complete;

    public static String[] names() {
        ProbationPeriodEvaluationStage[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
