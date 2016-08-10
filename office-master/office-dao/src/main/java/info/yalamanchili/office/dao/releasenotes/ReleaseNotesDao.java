/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.releasenotes;

import info.chili.notifications.ReleaseNotes;
import info.chili.spring.SpringContext;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


/**
 *
 * @author sudharani.bandaru
 */
@Repository("releaseNotesDao")
@Scope("prototype")
public class ReleaseNotesDao {

    @Autowired
    protected MongoOperations mongoTemplate;
  
    public void save(ReleaseNotes entity) {
        mongoTemplate.save(entity);
    }
    
    public ReleaseNotes findById(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userIds").is(userId.trim()));
        return mongoTemplate.findOne(query, ReleaseNotes.class);
    }

    public void delete(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userIds").is(userId.trim()));
        mongoTemplate.remove(mongoTemplate.findOne(query, ReleaseNotes.class));
    }
    
    public List<ReleaseNotes> query() {
        Query query = new Query();
        return mongoTemplate.find(query, ReleaseNotes.class);
    }
    public static ReleaseNotesDao instance() {
        return (ReleaseNotesDao) SpringContext.getBean("releaseNotesDao");
    }

}
