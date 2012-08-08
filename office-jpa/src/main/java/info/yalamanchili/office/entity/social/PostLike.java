/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.social;

import info.yalamanchili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.profile.Employee;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author raghu
 */
@Indexed
@XmlRootElement
@Entity
public class PostLike extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    @ManyToOne
    protected Employee employee;
    @ManyToOne
    protected Post post;

    public PostLike() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
