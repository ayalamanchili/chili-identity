package info.yalamanchili.office.entity.social;

import info.yalamanchili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.profile.Company;
import info.yalamanchili.office.entity.profile.Employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
public class Post extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    @Temporal(TemporalType.TIMESTAMP)
    @Field(index = Index.UN_TOKENIZED)
    @NotNull
    protected Date postTimeStamp;
    @NotEmpty
    protected String postContent;
    @ManyToOne(cascade = CascadeType.MERGE)
    protected Employee employee;
    @ManyToOne(cascade = CascadeType.MERGE)
    protected Company company;
    @ManyToOne(cascade = CascadeType.MERGE)
    protected Post parentPost;
    @OneToMany(mappedBy = "parentPost", cascade = CascadeType.ALL)
    protected List<Post> replies;

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
}
