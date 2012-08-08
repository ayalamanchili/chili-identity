package info.yalamanchili.office.dao.social;

import info.yalamanchili.office.dao.profile.CompanyDao;
import info.yalamanchili.office.entity.social.Post;
import info.yalamanchili.office.entity.social.PostLike;
import info.yalamanchili.office.dao.security.SecurityService;
import java.util.Date;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;

@Component
public class SocialDao {

    @Autowired
    protected SecurityService securityService;
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    protected EntityManager em;
    @Autowired
    protected CompanyDao companyDao;

    public List<Post> getEmployeeFeed(int start, int limit) {
        Query getPostsQuery = em.createQuery("from " + Post.class.getCanonicalName() + " p where p.parentPost is null and p.employee is not null and p.company is  null order by p.postTimeStamp",
                Post.class);
        getPostsQuery.setFirstResult(start);
        getPostsQuery.setMaxResults(limit);
        return getPostsQuery.getResultList();
    }

    public List<Post> getCompanyFeed(int start, int limit) {
        // TODO implement this
        Query getPostsQuery = em.createQuery("from " + Post.class.getCanonicalName() + " p where p.parentPost is null and p.employee is not null and p.company is not null order by p.postTimeStamp",
                Post.class);
        getPostsQuery.setFirstResult(start);
        getPostsQuery.setMaxResults(limit);
        return getPostsQuery.getResultList();
    }

    public Post addReply(Long parentPostId, Post post) {
        Post parentPost = em.find(Post.class, parentPostId);
        post.setEmployee(securityService.getCurrentUser());
        parentPost.addReply(post);
        return parentPost;
    }

    public Post createPost(Post newPost) {
        newPost.setPostTimeStamp(new Date());
        newPost.setEmployee(securityService.getCurrentUser());
        return em.merge(newPost);
    }

    public Post createCompanyPost(Post newcompanypost) {
        newcompanypost.setEmployee(securityService.getCurrentUser());
        newcompanypost.setCompany(companyDao.findByCompanyName("sstech"));
        newcompanypost.setPostTimeStamp(new Date());
        return em.merge(newcompanypost);
    }
    public void liked(Long postId){
        PostLike like = new PostLike();
        like.setEmployee(securityService.getCurrentUser());
        like.setPost(em.find(Post.class,postId));
        em.merge(like);
    }
}
