package info.yalamanchili.office.dao.social;

import info.yalamanchili.office.entity.social.Post;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.profile.Employee;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import org.hsqldb.User;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SocialDao {
    
    @Autowired
    protected SecurityService securityService;

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    protected EntityManager em;
    
    

    public List<Post> getEmployeeFeed(int start, int limit) {
        Query getPostsQuery = em.createQuery("from " + Post.class.getCanonicalName() + " p where p.parentPost is null and p.employee is not null order by p.postTimeStamp",
                Post.class);
        getPostsQuery.setFirstResult(start);
        getPostsQuery.setMaxResults(limit);
        return getPostsQuery.getResultList();
    }

    public List<Post> getCompanyFeed() {
        // TODO implement this
        return null;
    }

    public Post addReply(Long parentPostId, Post post) {
        Post parentPost = em.find(Post.class, parentPostId);
        parentPost.addReply(post);
        return parentPost;
    }


	public Post createPost(Post newPost) {
		// TODO Auto-generated method stub
            newPost.setEmployee(securityService.getCurrentUser());
	    em.persist(newPost);         
                return em.merge(newPost);
	}

    

       

       
}
