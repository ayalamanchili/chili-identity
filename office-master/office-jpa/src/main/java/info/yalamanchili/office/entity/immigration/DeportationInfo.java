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
public class DeportationInfo extends AbstractHandleEntity {
    
    private static final long serialVersionUID = 13L;
    
    protected Boolean isBenfRemProceed;

    public Boolean getIsBenfRemProceed() {
        return isBenfRemProceed;
    }

    public void setIsBenfRemProceed(Boolean isBenfRemProceed) {
        this.isBenfRemProceed = isBenfRemProceed;
    }

    @Override
    public String toString() {
        return "DeportationInfo{" + "isBenfRemProceed=" + isBenfRemProceed + '}';
    }
}