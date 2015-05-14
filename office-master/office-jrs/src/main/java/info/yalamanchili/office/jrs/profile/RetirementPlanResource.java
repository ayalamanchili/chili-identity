/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.profile.RetirementPlanDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.ext.Comment;
import info.yalamanchili.office.entity.profile.RetirementPlan;
import java.util.Date;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Path("secured/retirement-plan")
@Component
@Transactional
@Scope("request")
public class RetirementPlanResource {

    @Autowired
    public RetirementPlanDao retirementPlanDao;

    @PUT
    @Path("/opt-in")
    public void optIn(Comment comment) {
        RetirementPlan rp = new RetirementPlan();
        rp.setOptInDate(new Date());
        rp.setEmployee(OfficeSecurityService.instance().getCurrentUser());
        rp = retirementPlanDao.save(rp);
        CommentDao.instance().addComment(comment.getComment(), rp);
    }

}
