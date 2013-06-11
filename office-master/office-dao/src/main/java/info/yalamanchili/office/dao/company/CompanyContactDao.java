/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.company;

import info.chili.dao.CRUDDao;
import info.chili.jpa.QueryUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.company.CompanyContact;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Component
@Scope("prototype")
public class CompanyContactDao extends CRUDDao<CompanyContact> {

    @PersistenceContext
    protected EntityManager em;

    public CompanyContactDao() {
        super(CompanyContact.class);
    }

    @Override
    public CompanyContact save(CompanyContact cnt) {
        CompanyContact entity = null;
        if (cnt.getId() == null) {
            entity = new CompanyContact();
            entity.setEmployee(EmployeeDao.instance().findById(cnt.getEmployee().getId()));
        } else {
            entity = findById(cnt.getId());
        }
        entity.setType(CompanyContactTypeDao.instance().findById(cnt.getType().getId()));
        entity.setContact(EmployeeDao.instance().findById(cnt.getContact().getId()));
        return em.merge(entity);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static CompanyContactDao instance() {
        return SpringContext.getBean(CompanyContactDao.class);
    }
}
