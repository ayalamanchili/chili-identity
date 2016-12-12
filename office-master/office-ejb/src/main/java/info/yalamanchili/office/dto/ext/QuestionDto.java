/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.ext;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author anuyalamanchili
 */
@XmlRootElement(name = "Question")
@XmlType
public class QuestionDto implements Serializable {

    protected Long id;
    /**
     *
     */
    @NotEmpty(message = "{subject.not.empty.msg}")
    protected String question;
    /**
     *
     */
    protected String questionInfo;
    /**
     *
     */
    protected Integer sortOrder;
    /**
     *
     */
    protected boolean questionCommentRequired;
    /**
     *
     */
    protected boolean questionRatingRequired;

    public QuestionDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestionInfo() {
        return questionInfo;
    }

    public void setQuestionInfo(String questionInfo) {
        this.questionInfo = questionInfo;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public boolean isQuestionCommentRequired() {
        return questionCommentRequired;
    }

    public void setQuestionCommentRequired(boolean questionCommentRequired) {
        this.questionCommentRequired = questionCommentRequired;
    }

    public boolean isQuestionRatingRequired() {
        return questionRatingRequired;
    }

    public void setQuestionRatingRequired(boolean questionRatingRequired) {
        this.questionRatingRequired = questionRatingRequired;
    }

}
