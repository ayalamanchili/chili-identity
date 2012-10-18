/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.social;

import info.yalamanchili.office.entity.social.PostFile;
import info.yalamanchili.office.entity.social.PostLike;
import java.util.Date;
import java.util.List;
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
public class Post {
    
    protected Long id;
    protected String employeeName;
    protected String employeeImageUrl;
    protected String postContent;
    protected Date postTimeStamp;
    protected Integer numberOfReplies;
    protected List<PostFile> postFiles;
    protected List<PostLike> postLikes;

   
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
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
     public List<PostLike> getPostLikes() {
        return postLikes;
    }

    public void setPostLikes(List<PostLike> postLikes) {
        this.postLikes = postLikes;
    }
    
    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", employeeName=" + employeeName + ", employeeImageUrl=" + employeeImageUrl + ", postContent=" + postContent + ", postTimeStamp=" + postTimeStamp + ", numberOfReplies=" + numberOfReplies + '}';
    }
    
    public static Post map(Mapper mapper, info.yalamanchili.office.entity.social.Post entity) {
        Post dto = mapper.map(entity, Post.class);
        //TODO user query to find size rather than whole entity
        dto.setNumberOfReplies(entity.getReplies().size());
        if (entity.getEmployee() != null) {
            dto.setEmployeeName(entity.getEmployee().getFirstName() + " " + entity.getEmployee().getLastName());
            dto.setEmployeeImageUrl(entity.getEmployee().getImageURL());
            dto.setPostFiles(entity.getPostFiles());
            dto.setPostLikes(entity.getPostLikes());
        }
        return dto;
    }
}
