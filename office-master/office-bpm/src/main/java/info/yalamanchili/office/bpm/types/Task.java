/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.types;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.activiti.engine.impl.persistence.entity.TaskEntity;

/**
 *
 * @author anuyalamanchili
 */
@XmlRootElement
@XmlType
public class Task extends TaskEntity {

    public Task(org.activiti.engine.task.Task entity) {
        this.setName(entity.getName());
        //TODO map remaining fields
    }
}
