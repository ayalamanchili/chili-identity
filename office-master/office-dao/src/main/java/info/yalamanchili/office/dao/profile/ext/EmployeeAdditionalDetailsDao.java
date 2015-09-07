/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile.ext;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.profile.ext.EmployeeAdditionalDetails;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Madhu.Badiginchala
 */
public class EmployeeAdditionalDetailsDao extends CRUDDao<EmployeeAdditionalDetails> {

    public EmployeeAdditionalDetailsDao() {
        super(EmployeeAdditionalDetails.class);
    }

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static EmployeeAdditionalDetailsDao instance() {
        return SpringContext.getBean(EmployeeAdditionalDetails.class);
    }

}
