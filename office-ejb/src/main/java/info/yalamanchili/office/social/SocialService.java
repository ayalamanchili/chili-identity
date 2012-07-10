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
import org.springframework.stereotype.Component;

/**
 *
 * @author yalamanchili
 */
@Component
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
            empFeed.add(Post.map(mapper, entity));
        }
        return empFeed;
    }

    public List<Post> getRepies(String parentPostId) {
        List<Post> replies = new ArrayList<Post>();
        info.yalamanchili.office.entity.social.Post parenPost = em.find(info.yalamanchili.office.entity.social.Post.class, Long.valueOf(parentPostId));
        for (info.yalamanchili.office.entity.social.Post entity : parenPost.getReplies()) {
            replies.add(Post.map(mapper, entity));
        }
        return replies;
    }
}
