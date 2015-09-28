/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.hr;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.hr.Prospect;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author radhika.mukkala
 */
@Repository
@Scope("prototype")
public class ProspectDao extends CRUDDao<Prospect>{
    
    @PersistenceContext
    protected EntityManager em;
    
    public ProspectDao(){
        super(Prospect.class);
    }
    
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    public static ProspectDao instance() {
        return SpringContext.getBean(ProspectDao.class);
    }
    
}
