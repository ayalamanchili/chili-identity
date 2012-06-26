/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.social;

import java.util.Date;
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
    protected String postContent;
    protected Date postTimeStamp;
    protected Integer numberOfReplies;

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

    public static Post map(Mapper mapper, info.yalamanchili.office.entity.social.Post entity) {
        Post dto = mapper.map(entity, Post.class);
        //TODO user query to find size rather than whole entity
        dto.setNumberOfReplies(entity.getReplies().size());
        if (entity.getEmployee() != null) {
            dto.setEmployeeName(entity.getEmployee().getFirstName() + " " + entity.getEmployee().getLastName());
        }
        return dto;
    }
}
