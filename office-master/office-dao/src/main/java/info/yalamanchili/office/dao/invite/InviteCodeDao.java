/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.invite;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.profile.invite.InviteCode;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author Madhu.Badiginchala
 */
@Component
@Scope("prototype")
public class InviteCodeDao {

    @Autowired
    protected MongoOperations mongoTemplate;
    
    public void save(InviteCode entity) {
        mongoTemplate.save(entity);
    }

    public InviteCode find(String invitationCode) {
        Query query = new Query();
        query.addCriteria(Criteria.where("invitationCode").is(invitationCode.trim()));
        return mongoTemplate.findOne(query, InviteCode.class);
    }

    public void invalidateCode(InviteCode invitationCode) {
        invitationCode.setExpiryDate(DateUtils.addDays(new Date(), -1));
        save(invitationCode);
    }

    public List<InviteCode> query() {
        Query query = new Query();
        return mongoTemplate.find(query, InviteCode.class);
    }
    
    public static InviteCodeDao instance() {
        return SpringContext.getBean(InviteCodeDao.class);
    }

}
