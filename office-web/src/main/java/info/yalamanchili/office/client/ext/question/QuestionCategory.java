/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.ext.question;

/**
 *
 * @author prasanthi.p
 */
public enum QuestionCategory {

    SKILL_AND_APTITUDE,
    ATTITUDE,
    MANAGEMENT;

    public static String[] names() {
        QuestionCategory[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
