/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.expense.chkreq;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.entity.expense.CheckRequisitionItem;
import info.yalamanchili.office.entity.expense.ImmigrationCheckRequisition;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ayalamanchili
 */
@Repository
@Scope("prototype")
public class CheckRequisitionItemDao extends CRUDDao<CheckRequisitionItem> {

    public CheckRequisitionItemDao() {
        super(CheckRequisitionItem.class);
    }

    @CacheEvict(value = OfficeCacheKeys.IMMIGRATION_CHECK, allEntries = true)
    @Override
    public void delete(Long id) {
        CheckRequisitionItem item = findById(id);
        ImmigrationCheckRequisition report = item.getImmigrationCheckRequisition();
        report.getItems().remove(item);
        report.updateTotalAmount();
        super.delete(id);
    }

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static CheckRequisitionItemDao instance() {
        return SpringContext.getBean(CheckRequisitionItemDao.class);
    }

}
