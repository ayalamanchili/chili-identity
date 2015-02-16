/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.employee;

import info.chili.jpa.AbstractEntity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author benerji.v
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class ProbationPeriodEvalution extends AbstractEntity{
    private static final long serialVersionUID = 1L;
    /**
     * evaluation Date
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date evalutionDate;
    /**
     *
     */
    @Lob
    private String trainingRequirments;
    /**
     *
     */
    @Lob
    private String additionalComments;
    /**
     *
     */
    @Lob
    private String hrNotes;

    /**
     * @return the evalutionDate
     */
    public Date getEvalutionDate() {
        return evalutionDate;
    }

    /**
     * @param evalutionDate the evalutionDate to set
     */
    public void setEvalutionDate(Date evalutionDate) {
        this.evalutionDate = evalutionDate;
    }

    /**
     * @return the trainingRequirments
     */
    public String getTrainingRequirments() {
        return trainingRequirments;
    }

    /**
     * @param trainingRequirments the trainingRequirments to set
     */
    public void setTrainingRequirments(String trainingRequirments) {
        this.trainingRequirments = trainingRequirments;
    }

    /**
     * @return the additionalComments
     */
    public String getAdditionalComments() {
        return additionalComments;
    }

    /**
     * @param additionalComments the additionalComments to set
     */
    public void setAdditionalComments(String additionalComments) {
        this.additionalComments = additionalComments;
    }

    /**
     * @return the hrNotes
     */
    public String getHrNotes() {
        return hrNotes;
    }

    /**
     * @param hrNotes the hrNotes to set
     */
    public void setHrNotes(String hrNotes) {
        this.hrNotes = hrNotes;
    }
    
    
    
}
