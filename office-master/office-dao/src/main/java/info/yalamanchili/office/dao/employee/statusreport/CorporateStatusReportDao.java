/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.employee.statusreport;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.employee.statusreport.CorporateStatusReport;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author benerji.v
 */
@Repository
@Scope("prototype")
public class CorporateStatusReportDao extends CRUDDao<CorporateStatusReport> {

    public CorporateStatusReportDao() {
        super(CorporateStatusReport.class);
    }
    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static CorporateStatusReportDao instance() {
        return SpringContext.getBean(CorporateStatusReportDao.class);
    }
}
