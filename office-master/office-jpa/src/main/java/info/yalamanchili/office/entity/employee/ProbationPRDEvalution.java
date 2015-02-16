/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.employee;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.ext.Question;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ForeignKey;
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
public class ProbationPRDEvalution extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    /**
     * evaluation Date
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    protected Date evalutionDate;
    /**
     *
     */
    @Lob
    protected String trainingRequirments;
    /**
     *
     */
    @Lob
    protected String additionalComments;
    /**
     *
     */
    @Lob
    protected String hrNotes;
    /**
     * Employee
     */
}
