/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.social;

import info.yalamanchili.office.dao.social.SocialDao;
import info.yalamanchili.office.dto.social.Post;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author yalamanchili
 */
@Component
@Scope("request")
public class SocialService {

    @Autowired
    protected SocialDao socialDao;
    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;
    /*
     * Employee Feed
     */

    public List<Post> getEmployeeFeed(int start, int limit) {
        List<Post> empFeed = new ArrayList<Post>();
        for (info.yalamanchili.office.entity.social.Post entity : socialDao.getEmployeeFeed(start, limit)) {
            empFeed.add(Post.map(em, mapper, entity));
        }
        return empFeed;
    }

    public List<Post> getCompanyFeed(int start, int limit) {
        List<Post> compFeed = new ArrayList<Post>();
        for (info.yalamanchili.office.entity.social.Post entity : socialDao.getCompanyFeed(start, limit)) {
            compFeed.add(Post.map(em, mapper, entity));
        }
        return compFeed;
    }

    public List<Post> getRepies(String parentPostId) {
        List<Post> replies = new ArrayList<Post>();
        info.yalamanchili.office.entity.social.Post parenPost = em.find(info.yalamanchili.office.entity.social.Post.class, Long.valueOf(parentPostId));
        for (info.yalamanchili.office.entity.social.Post entity : parenPost.getReplies()) {
            replies.add(Post.map(em, mapper, entity));
        }
        return replies;
    }
}
