/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.social;

import info.yalamanchili.office.dao.social.SocialDao;
import info.yalamanchili.office.dto.social.Post;
import java.util.ArrayList;
import java.util.List;
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
    @Autowired
    protected Mapper mapper;

    public List<Post> getEmployeeFeed(int start, int limit) {
        List<Post> empFeed = new ArrayList<Post>();
        for (info.yalamanchili.office.entity.social.Post entity : socialDao.getEmployeeFeed(start, limit)) {
            empFeed.add(Post.map(mapper, entity));
        }
        return empFeed;
    }
}
