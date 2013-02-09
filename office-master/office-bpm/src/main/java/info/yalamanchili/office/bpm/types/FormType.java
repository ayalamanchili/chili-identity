/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.types;

/**
 *
 * @author ayalamanchili
 */
public class FormType implements org.activiti.engine.form.FormType {

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object getInformation(String key) {
        return null;
    }
}
