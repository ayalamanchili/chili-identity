/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.invite;

import info.yalamanchili.office.entity.profile.invite.InviteType;
import info.yalamanchili.office.entity.profile.invite.InvitationType;
import info.chili.spring.SpringContext;
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
public class InviteTypeDao {

    @Autowired
    protected MongoOperations mongoTemplate;

    public void save(InviteType entity) {
        mongoTemplate.save(entity);
    }

    public InviteType find(InvitationType type) {
        Query query = new Query();
        query.addCriteria(Criteria.where("invitationType").is(type.name()));
        return mongoTemplate.findOne(query, InviteType.class);
    }

    public static InviteTypeDao instance() {
        return SpringContext.getBean(InviteTypeDao.class);
    }

}
