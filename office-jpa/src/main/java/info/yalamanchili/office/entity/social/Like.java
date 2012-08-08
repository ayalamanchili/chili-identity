/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.social;

import info.yalamanchili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author raghu
 */
@Indexed
@XmlRootElement
@Entity
public class Like extends AbstractEntity{
      private static final long serialVersionUID = 1L;
      
       protected Employee employee;
       
       protected Post post;
       
        @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
        protected List<Like> likes;
    
        public Post getPost() {
        return post;
        }

         public void setPost(Post post) {
         this.post = post;
         }
         
         public Employee getEmployee() {
        return employee;
        }

         public void setEmployee(Employee employee) {
         this.employee = employee;
         }
}
