/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.ext;

import info.chili.jpa.AbstractEntity;
import info.chili.jpa.validation.Unique;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author anuyalamanchili
 */
@Entity
@Audited
@XmlRootElement
@XmlType
@Table(uniqueConstraints =
        @UniqueConstraint(columnNames = {"questionKey"}))
@Unique(entity = Question.class, fields = {"questionKey"}, message = "{question.key.not.unique.msg}")
//TODO questionInfoKey unique?
public class Question extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    /**
     *
     *
     */
    @NotEmpty(message = "{question.questionKey.empty.msg}")
    @org.hibernate.annotations.Index(name = "QES_KEY_IDX")
    protected String questionKey;
    /**
     *
     *
     */
    protected String questionInfoKey;
    /**
     * Service ticket type
     */
    @Enumerated(EnumType.STRING)
    @NotNull(message = "{question.type.empty.msg}")
    protected QuestionType type;
    protected Integer questionOrder;

    public Question() {
    }

    public String getQuestionKey() {
        return questionKey;
    }

    public void setQuestionKey(String questionKey) {
        this.questionKey = questionKey;
    }

    public String getQuestionInfoKey() {
        return questionInfoKey;
    }

    public void setQuestionInfoKey(String questionInfoKey) {
        this.questionInfoKey = questionInfoKey;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public Integer getQuestionOrder() {
        //TODO return default to supprort sort
        return questionOrder;
    }

    public void setQuestionOrder(Integer questionOrder) {
        this.questionOrder = questionOrder;
    }
}
