/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.invite;

import info.yalamanchili.office.entity.profile.invite.InvitationType;
import info.yalamanchili.office.entity.profile.invite.TypeOfInvitation;
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
public class InvitationTypeDao {

    @Autowired
    protected MongoOperations mongoTemplate;

    public void save(InvitationType entity) {
        mongoTemplate.save(entity);
    }

    public InvitationType find(TypeOfInvitation type) {
        Query query = new Query();
        query.addCriteria(Criteria.where("type").is(type.name()));
        return mongoTemplate.findOne(query, InvitationType.class);
    }

    public static InvitationTypeDao instance() {
        return SpringContext.getBean(InvitationTypeDao.class);
    }

}
