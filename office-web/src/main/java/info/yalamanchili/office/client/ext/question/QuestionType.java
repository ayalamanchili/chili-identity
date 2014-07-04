/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.ext.question;

/**
 *
 * @author prasanthi.p
 */
enum QuestionType {

    Review_Self,
    Review_Mgr;

    public static String[] names() {
        QuestionType[] values = values();
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].name();
        }
        return names;
    }
}
