/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.employee;

import info.yalamanchili.office.entity.employee.PerformanceEvaluation;
import java.io.Serializable;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
@XmlType
public class PerformanceEvaluationSaveDto implements Serializable {

    protected String year;
    /**
     *
     */
    protected Long employeeId;
    /**
     *
     */
    protected PerformanceEvaluation performanceEvaluation;
    /**
     *
     */
    @Valid
    protected List<QuestionComment> comments;

    public PerformanceEvaluationSaveDto() {
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @XmlElement
    public PerformanceEvaluation getPerformanceEvaluation() {
        return performanceEvaluation;
    }

    public void setPerformanceEvaluation(PerformanceEvaluation performanceEvaluation) {
        this.performanceEvaluation = performanceEvaluation;
    }

    @XmlElement
    public List<QuestionComment> getComments() {
        return comments;
    }

    public void setComments(List<QuestionComment> comments) {
        this.comments = comments;
    }

}
