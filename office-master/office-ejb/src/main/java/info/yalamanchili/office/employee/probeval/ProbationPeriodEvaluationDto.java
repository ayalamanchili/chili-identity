/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.employee.probeval;

import info.yalamanchili.office.dto.employee.QuestionComment;
import info.yalamanchili.office.entity.employee.ProbationPeriodEvaluation;
import java.io.Serializable;
import java.util.List;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author prasanthi.p
 */
@XmlRootElement
@XmlType
public class ProbationPeriodEvaluationDto implements Serializable {

    protected ProbationPeriodEvaluation evaluation;
    @Valid
    protected List<QuestionComment> comments;

    public ProbationPeriodEvaluationDto() {
    }

    @XmlElement
    public ProbationPeriodEvaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(ProbationPeriodEvaluation evaluation) {
        this.evaluation = evaluation;
    }

    @XmlElement
    public List<QuestionComment> getComments() {
        return comments;
    }

    public void setComments(List<QuestionComment> comments) {
        this.comments = comments;
    }

}
