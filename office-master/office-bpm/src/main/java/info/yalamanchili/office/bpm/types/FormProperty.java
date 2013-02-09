/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.types;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
@XmlType
public class FormProperty implements org.activiti.engine.form.FormProperty {

    protected String id;
    protected String name;
    protected FormType type;
    protected String value;
    protected boolean readable;
    protected boolean writable;
    protected boolean required;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public FormType getType() {
        return type;
    }

    public void setType(FormType type) {
        this.type = type;
    }

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean isReadable() {
        return readable;
    }

    @Override
    public boolean isWritable() {
        return writable;
    }

    @Override
    public boolean isRequired() {
        return required;
    }
}
