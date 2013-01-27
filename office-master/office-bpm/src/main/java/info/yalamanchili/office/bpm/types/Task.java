/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author anuyalamanchili
 */
@XmlRootElement
@XmlType
public class Task {

    protected String id;
    protected String name;
    protected String description;
    protected String owner;
    protected String assignee;
    protected Date createdDate;
    protected Date dueDate;

    public Task() {
    }

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

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", name=" + name + ", assignee=" + assignee + '}';
    }

    @XmlRootElement
    @XmlType
    public static class TaskTable {

        protected Long size;
        protected List<Task> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<Task> getEntities() {
            if (this.entities == null) {
                this.entities = new ArrayList<Task>();
            }
            return entities;
        }

        public void setEntities(List<Task> entities) {
            this.entities = entities;
        }
    }
}
