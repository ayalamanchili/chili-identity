/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.immigration;

import info.chili.jpa.AbstractHandleEntity;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author radhika.mukkala
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class DeportationInfo extends AbstractHandleEntity{
    
    private Boolean isRemProcedngs;

    public Boolean getIsRemProcedngs() {
        return isRemProcedngs;
    }

    public void setIsRemProcedngs(Boolean isRemProcedngs) {
        this.isRemProcedngs = isRemProcedngs;
    }

    @Override
    public String toString() {
        return "DeportationInfo{" + "isRemProcedngs=" + isRemProcedngs + '}';
    }
}
