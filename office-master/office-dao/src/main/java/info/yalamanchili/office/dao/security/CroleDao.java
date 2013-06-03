/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.security;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.entity.security.CRole;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("prototype")
public class CroleDao extends CRUDDao<CRole> {

    @PersistenceContext
    protected EntityManager em;

    public CroleDao() {
        super(CRole.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
