/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.types;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
@XmlType
public class FormProperty {
    
    protected String id;
    protected String name;
    protected String type;
    protected String value;
    protected boolean readable;
    protected boolean writable;
    protected boolean required;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public boolean isReadable() {
        return readable;
    }
    
    public boolean isWritable() {
        return writable;
    }
    
    public boolean isRequired() {
        return required;
    }
    
    public static FormProperty map(Mapper mapper, org.activiti.engine.form.FormProperty property) {
        FormProperty p = mapper.map(property, FormProperty.class);
        p.setType(property.getType().getName());
        return p;
    }
}
