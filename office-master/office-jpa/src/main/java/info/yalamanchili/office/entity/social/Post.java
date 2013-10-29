/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.entity.social;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.profile.Employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @todo add comment for javadoc
 *
 * @author ayalamanchili
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class Post extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    @Temporal(TemporalType.TIMESTAMP)
    @Field(index = Index.UN_TOKENIZED)
    @org.hibernate.annotations.Index(name = "POST_TM_STMP")
    protected Date postTimeStamp;
    @NotEmpty(message = "{postContent.not.empty.msg}")
    @Lob
    protected String postContent;
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Employee_Posts")
    protected Employee employee;
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Company_Posts")
    protected Company company;
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Post_ChildPosts")
    protected Post parentPost;
    @OneToMany(mappedBy = "parentPost", cascade = CascadeType.ALL)
    protected List<Post> replies;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    protected List<PostFile> postFiles;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    protected List<PostLike> postLikes;

    public Date getPostTimeStamp() {
        return postTimeStamp;
    }

    public void setPostTimeStamp(Date postTimeStamp) {
        this.postTimeStamp = postTimeStamp;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    @XmlElement
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @XmlElement
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Post getParentPost() {
        return parentPost;
    }

    public void setParentPost(Post parentPost) {
        this.parentPost = parentPost;
    }

    @XmlTransient
    public List<Post> getReplies() {
        if (this.replies == null) {
            this.replies = new ArrayList<Post>();
        }
        return this.replies;
    }

    public void setReplies(List<Post> replies) {
        this.replies = replies;
    }

    public void addReply(Post reply) {
        if (reply == null) {
            return;
        }
        getReplies().add(reply);
        reply.setParentPost(this);
    }

    @XmlElement
    public List<PostFile> getPostFiles() {
        if (this.postFiles == null) {
            this.postFiles = new ArrayList<PostFile>();
        }
        return postFiles;
    }

    public void setPostFiles(List<PostFile> postFiles) {
        this.postFiles = postFiles;
    }

    public void addPostFile(PostFile postFile) {
        if (postFile == null) {
            return;
        }
        getPostFiles().add(postFile);
    }

    //TODO add pre/post persiste or update to save the current time stamp.
    @XmlTransient
    public List<PostLike> getPostLikes() {
        if (this.postLikes == null) {
            this.postLikes = new ArrayList<PostLike>();
        }
        return postLikes;
    }

    public void setPostLikes(List<PostLike> postLikes) {
        this.postLikes = postLikes;
    }
}
