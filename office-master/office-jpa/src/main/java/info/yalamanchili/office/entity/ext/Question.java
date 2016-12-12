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
@Table(uniqueConstraints
        = @UniqueConstraint(columnNames = {"questionKey"}))
@Unique(entity = Question.class, fields = {"questionKey"}, message = "{question.key.not.unique.msg}")
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
     * Service ticket category
     */
    @Enumerated(EnumType.STRING)
    protected QuestionCategory category;
    /**
     * Service ticket context
     */
    @Enumerated(EnumType.STRING)
    protected QuestionContext context;
    /**
     *
     */
    protected Integer sortOrder;
    /**
     *
     */
    protected Boolean questionCommentRequired = false;
    /**
     *
     */
    protected Boolean questionRatingRequired = false;

    public Question() {
    }

    public String getQuestionKey() {
        return questionKey;
    }

    public void setQuestionKey(String questionKey) {
        this.questionKey = questionKey;
    }

    public QuestionCategory getCategory() {
        return category;
    }

    public void setCategory(QuestionCategory category) {
        this.category = category;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public QuestionContext getContext() {
        return context;
    }

    public void setContext(QuestionContext context) {
        this.context = context;
    }

    public void setQuestionCommentRequired(Boolean questionCommentRequired) {
        this.questionCommentRequired = questionCommentRequired;
    }

    public Boolean getQuestionCommentRequired() {
        return questionCommentRequired;
    }

    public Boolean getQuestionRatingRequired() {
        return questionRatingRequired;
    }

    public void setQuestionRatingRequired(Boolean questionRatingRequired) {
        this.questionRatingRequired = questionRatingRequired;
    }
}
