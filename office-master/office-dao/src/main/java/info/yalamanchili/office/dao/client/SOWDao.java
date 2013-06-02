/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.client;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.entity.client.StatementOfWork;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;
/**
 *
 * @author bala
 */
@Component
@Scope("prototype")
public class SOWDao extends CRUDDao<StatementOfWork> {

    public SOWDao() {
        super(StatementOfWork.class);
    }
    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}