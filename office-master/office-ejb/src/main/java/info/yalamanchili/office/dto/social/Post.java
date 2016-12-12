/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.social;

import info.yalamanchili.office.entity.social.PostFile;
import info.yalamanchili.office.entity.social.PostLike;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;

/**
 *
 * @author yalamanchili
 */
@XmlRootElement
@XmlType
public class Post implements java.io.Serializable{

    protected Long id;
    protected Long employeeId;
    protected String employeeName;
    protected String employeeImageUrl;
    protected String postContent;
    protected Date postTimeStamp;
    protected Integer numberOfReplies;
    protected List<PostFile> postFiles;
    protected List<String> postLikes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeImageUrl() {
        return employeeImageUrl;
    }

    public void setEmployeeImageUrl(String employeeImageUrl) {
        this.employeeImageUrl = employeeImageUrl;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Date getPostTimeStamp() {
        return postTimeStamp;
    }

    public void setPostTimeStamp(Date postTimeStamp) {
        this.postTimeStamp = postTimeStamp;
    }

    public Integer getNumberOfReplies() {
        return numberOfReplies;
    }

    public void setNumberOfReplies(Integer numberOfReplies) {
        this.numberOfReplies = numberOfReplies;
    }

    @XmlElement
    public List<PostFile> getPostFiles() {
        return postFiles;
    }

    public void setPostFiles(List<PostFile> postFiles) {
        this.postFiles = postFiles;
    }

    @XmlElement
    public List<String> getPostLikes() {
        return postLikes;
    }

    public void setPostLikes(List<String> postLikes) {
        this.postLikes = postLikes;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", employeeName=" + employeeName + ", employeeImageUrl=" + employeeImageUrl + ", postContent=" + postContent + ", postTimeStamp=" + postTimeStamp + ", numberOfReplies=" + numberOfReplies + '}';
    }

    public static Post map(EntityManager em, Mapper mapper, info.yalamanchili.office.entity.social.Post entity) {
        Post dto = mapper.map(entity, Post.class);
        //TODO user query to find size rather than whole entity
        dto.setNumberOfReplies(entity.getReplies().size());
        if (entity.getEmployee() != null) {
            dto.setEmployeeName(entity.getEmployee().getFirstName() + " " + entity.getEmployee().getLastName());
            dto.setEmployeeImageUrl(entity.getEmployee().getImageURL());
            dto.setEmployeeId(entity.getEmployee().getId());
            dto.setPostFiles(entity.getPostFiles());
            Query getEmpDetailsQuery = em.createQuery("select postLike.employee.firstName, postLike.employee.lastName from PostLike postLike where postLike.post=:postParam");
            getEmpDetailsQuery.setParameter("postParam", entity);
            for (Object obj : getEmpDetailsQuery.getResultList()) {
                Object[] obs = (Object[]) obj;
                String firstName = (String) obs[0];
                String lastName = (String) obs[1];
                dto.getPostLikes().add(firstName + " " + lastName);
            }
        }
        return dto;
    }
}
