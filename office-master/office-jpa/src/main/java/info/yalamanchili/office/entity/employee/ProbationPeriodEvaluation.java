/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
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
public class ProbationPeriodEvaluation extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    /**
     * evaluation Date
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date evaluationDate;
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
     * Employee
     */
    @ManyToOne
    @ForeignKey(name = "FK_EMP_PERF_EVALS")
    private Employee employee;
    /**
     * questions
     */
    @ManyToMany
    private Set<Question> questions;
    /**
     * manager approval
     */
    private String approvedBy;
    /**
     * manager approval date
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date approvedDate;
    /**
     * hr approval
     */
    private String hrApprovalBy;
    /**
     * hr approval date
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date hrApprovalDate;
    /**
     * employee accept date
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date acceptDate;
    @Enumerated(EnumType.STRING)
    protected ProbationPeriodEvaluationStage stage;
    private String bpmProcessId;

    protected Boolean active;

    /**
     * @return the evalutionDate
     */
    public Date getEvaluationDate() {
        return evaluationDate;
    }

    /**
     * @param evaluationDate the evalutionDate to set
     */
    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
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

    /**
     * @return the employee
     */
    @XmlTransient
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * @return the questions
     */
    @XmlTransient
    public Set<Question> getQuestions() {
        return questions;
    }

    /**
     * @param questions the questions to set
     */
    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question entity) {
        if (entity == null) {
            return;
        }
        getQuestions().add(entity);
    }

    /**
     * @return the approvedBy
     */
    public String getApprovedBy() {
        return approvedBy;
    }

    /**
     * @param approvedBy the approvedBy to set
     */
    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    /**
     * @return the approvedDate
     */
    public Date getApprovedDate() {
        return approvedDate;
    }

    /**
     * @param approvedDate the approvedDate to set
     */
    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    /**
     * @return the hrApprovalBy
     */
    public String getHrApprovalBy() {
        return hrApprovalBy;
    }

    /**
     * @param hrApprovalBy the hrApprovalBy to set
     */
    public void setHrApprovalBy(String hrApprovalBy) {
        this.hrApprovalBy = hrApprovalBy;
    }

    /**
     * @return the hrApprovalDate
     */
    public Date getHrApprovalDate() {
        return hrApprovalDate;
    }

    /**
     * @param hrApprovalDate the hrApprovalDate to set
     */
    public void setHrApprovalDate(Date hrApprovalDate) {
        this.hrApprovalDate = hrApprovalDate;
    }

    /**
     * @return the acceptDate
     */
    public Date getAcceptDate() {
        return acceptDate;
    }

    /**
     * @param acceptDate the acceptDate to set
     */
    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    /**
     * @return the stage
     */
    public ProbationPeriodEvaluationStage getStage() {
        return stage;
    }

    /**
     * @param stage the stage to set
     */
    public void setStage(ProbationPeriodEvaluationStage stage) {
        this.stage = stage;
    }

    /**
     * @return the bpmProcessId
     */
    public String getBpmProcessId() {
        return bpmProcessId;
    }

    /**
     * @param bpmProcessId the bpmProcessId to set
     */
    public void setBpmProcessId(String bpmProcessId) {
        this.bpmProcessId = bpmProcessId;
    }

    @Transient
    protected boolean enableManagerReview;

    public boolean isEnableManagerReview() {
        return enableManagerReview;
    }

    public void setEnableManagerReview(boolean enableManagerReview) {
        this.enableManagerReview = enableManagerReview;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "ProbationPeriodEvaluation{" + "evaluationDate=" + evaluationDate + ", trainingRequirments=" + trainingRequirments + ", additionalComments=" + additionalComments + ", hrNotes=" + hrNotes + ", approvedBy=" + approvedBy + ", approvedDate=" + approvedDate + ", hrApprovalBy=" + hrApprovalBy + ", hrApprovalDate=" + hrApprovalDate + ", acceptDate=" + acceptDate + ", stage=" + stage + ", active=" + active + ", bpmProcessId=" + bpmProcessId + '}';
    }

}
