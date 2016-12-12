/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.jrs.social;

import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.social.SocialDao;
import info.yalamanchili.office.entity.social.Post;
import info.yalamanchili.office.profile.notification.ProfileNotificationService;
import info.yalamanchili.office.social.notification.SocialNotificationService;
import info.yalamanchili.office.social.SocialService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 *
 * @author ayalamanchili
 */
@Path("secured/social")
@Component
@Transactional
@Produces("application/json")
@Consumes("application/json")
@Scope("request")
public class SocialResource {

    @Autowired
    public SocialDao socialDao;
    @Autowired
    public SocialService socialService;
    @Autowired
    protected ProfileNotificationService profileNotificationservice;
    @Autowired
    protected SocialNotificationService socialnotificationservice;

    @GET
    @Path("/employeefeed/{start}/{limit}")
    @Cacheable(value = OfficeCacheKeys.SOCIAL, key = "{#root.methodName,#start,#limit}")
    public List<info.yalamanchili.office.dto.social.Post> getEmployeeFeed(@PathParam("start") int start, @PathParam("limit") int limit) {
        return socialService.getEmployeeFeed(start, limit);
    }

    @GET
    @Path("/companyfeed/{start}/{limit}")
    @Cacheable(value = OfficeCacheKeys.SOCIAL, key = "{#root.methodName,#start,#limit}")
    public List<info.yalamanchili.office.dto.social.Post> getCompanyFeed(@PathParam("start") int start, @PathParam("limit") int limit) {
        return socialService.getCompanyFeed(start, limit);
    }
//TODO change this to create employee post and also update ui url

    @PUT
    @Validate
    @Path("/createpost")
    @CacheEvict(value = OfficeCacheKeys.SOCIAL, allEntries = true)
    public Post createPost(Post post) {
        return socialDao.createPost(post);
    }

    // For deleting Employee feed and company Feed
    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @CacheEvict(value = OfficeCacheKeys.SOCIAL, allEntries = true)
    public void delete(@PathParam("id") Long id) {
        socialDao.delete(id);
    }

    @PUT
    @Path("/addreply/{parentPostId}")
    @CacheEvict(value = OfficeCacheKeys.SOCIAL, allEntries = true)
    public Post addReply(@PathParam("parentPostId") Long parentPostId, Post reply) {
        return socialDao.addReply(parentPostId, reply);
    }

    @GET
    @Path("/replies/{parentPostId}")
    public List<info.yalamanchili.office.dto.social.Post> getReplies(@PathParam("parentPostId") String parentPostId) {
        return socialService.getRepies(parentPostId);
    }

    @PUT
    @Path("/createCompanyPost")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_RELATIONSHIP','ROLE_RECRUITER')")
    @CacheEvict(value = OfficeCacheKeys.SOCIAL, allEntries = true)
    public Post createCompanyPost(Post companypost) {
        companypost = socialDao.createCompanyPost(companypost);
        return companypost;
    }

    @PUT
    @Path("/liked/{postId}")
    @CacheEvict(value = OfficeCacheKeys.SOCIAL, allEntries = true)
    public void liked(@PathParam("postId") Long postId) {
        socialDao.liked(postId);
    }
}
