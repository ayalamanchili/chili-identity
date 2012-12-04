/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.security.CUser;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("request")
public class CuserDao extends CRUDDao<CUser> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public CuserDao() {
        super(CUser.class);
    }

    public static CuserDao instance() {
        return (CuserDao) SpringContext.getBean("cuserDao");
    }
}
