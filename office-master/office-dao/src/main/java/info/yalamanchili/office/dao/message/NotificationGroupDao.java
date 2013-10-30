/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.message;

import info.chili.jpa.QueryUtils;
import info.chili.spring.SpringContext;
import info.chili.dao.CRUDDao;
import info.yalamanchili.office.entity.message.NotificationGroup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anuyalamanchili
 */
@Repository
@Scope("prototype")
public class NotificationGroupDao extends CRUDDao<NotificationGroup> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public NotificationGroup findByName(String name) {
        return QueryUtils.findEntity(getEntityManager(), NotificationGroup.class, "name", name);
    }

    public NotificationGroupDao() {
        super(NotificationGroup.class);
    }

    public static NotificationGroupDao instance() {
        return SpringContext.getBean(NotificationGroupDao.class);
    }
}
