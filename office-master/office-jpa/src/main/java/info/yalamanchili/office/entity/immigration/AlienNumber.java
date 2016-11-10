/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
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
 * @author Sandeep Sunchu <sandeep.sunchu@sstech.us>
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class AlienNumber extends AbstractHandleEntity {
    
    private static final long serialVersionUID = 13L;
    
    protected String alienNumber;

    /**
     * @return the alienNumber
     */
    public String getAlienNumber() {
        return alienNumber;
    }

    /**
     * @param alienNumber the alienNumber to set
     */
    public void setAlienNumber(String alienNumber) {
        this.alienNumber = alienNumber;
    }
    
}
