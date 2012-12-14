/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import info.yalamanchili.office.entity.profile.Contact;

/**
 *
 * @author raghu
 */
public class ContactDto implements Serializable{
    @XmlRootElement
    @XmlType
    public static class ContactTable {

        protected Long size;
        protected List<Contact> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<Contact> getEntities() {
            return entities;
        }

        public void setEntities(List<Contact> entities) {
            this.entities = entities;
        }
    }
}
