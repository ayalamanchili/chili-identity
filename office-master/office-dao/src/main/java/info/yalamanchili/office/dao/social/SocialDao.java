/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.dao.social;

import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.dao.profile.CompanyDao;
import info.yalamanchili.office.entity.social.Post;
import info.yalamanchili.office.entity.social.PostLike;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.social.PostFile;
import java.util.Date;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class SocialDao {

    @Autowired
    protected OfficeSecurityService securityService;
    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected CompanyDao companyDao;

    public List<Post> getEmployeeFeed(int start, int limit) {
        Query getPostsQuery = em.createQuery("from " + Post.class.getCanonicalName() + " p where p.parentPost is null and p.employee is not null and p.company is  null order by p.postTimeStamp DESC",
                Post.class);
        getPostsQuery.setFirstResult(start);
        getPostsQuery.setMaxResults(limit);
        return getPostsQuery.getResultList();
    }

    public List<Post> getCompanyFeed(int start, int limit) {
        // TODO implement this
        Query getPostsQuery = em.createQuery("from " + Post.class.getCanonicalName() + " p where p.parentPost is null and p.employee is not null and p.company is not null order by p.postTimeStamp DESC",
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
        for (PostFile file : newPost.getPostFiles()) {
            file.setPost(newPost);
        }
        newPost.setEmployee(securityService.getCurrentUser());
        return em.merge(newPost);
    }

    public Post createCompanyPost(Post newcompanypost) {
        newcompanypost.setEmployee(securityService.getCurrentUser());
        Company company = companyDao.findByCompanyName("System Soft Technologies INC");
        if (company == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.company", "company not found");
        }
        newcompanypost.setCompany(company);
        newcompanypost.setPostTimeStamp(new Date());
        for (PostFile file : newcompanypost.getPostFiles()) {
            file.setPost(newcompanypost);
        }
        return em.merge(newcompanypost);
    }

    public void liked(Long postId) {
        PostLike like = new PostLike();
        like.setEmployee(securityService.getCurrentUser());
        like.setPost(em.find(Post.class, postId));
        em.merge(like);
    }

    public void delete(Long id) {
        try {
            em.remove(em.find(Post.class, id));
            em.flush();
        } catch (javax.persistence.PersistenceException e) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "DELETE", "SQLError", "cannot delete due to associated data");
        }
    }
}
