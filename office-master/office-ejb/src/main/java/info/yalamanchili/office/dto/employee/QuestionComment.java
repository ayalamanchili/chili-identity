/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.employee;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author anuyalamanchili
 */
@XmlRootElement(name = "QuestionAnswer")
@XmlType
public class QuestionComment {

    /**
     *
     */
    protected Long commentId;
    /**
     *
     */
    protected Long questionId;
    /**
     *
     */
    protected String comment;
    /**
     *
     */
    protected Double rating;

    /**
     *
     */
    protected String question;
    /**
     *
     */
    protected String questionInfo;

    /**
     *
     */
    protected int sortOrder;
    /**
     *
     */
    protected boolean questionCommentRequired;
    /**
     *
     */
    protected boolean questionRatingRequired;

    public QuestionComment() {
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
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

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
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
