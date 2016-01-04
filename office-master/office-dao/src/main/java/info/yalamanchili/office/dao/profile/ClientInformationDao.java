/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.dao.profile;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.entity.profile.ClientInformation;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope("prototype")
public class ClientInformationDao extends CRUDDao<ClientInformation> {

    @PersistenceContext
    protected EntityManager em;

    public ClientInformationDao() {
        super(ClientInformation.class);
    }

    @CacheEvict(value = OfficeCacheKeys.CLIENTINFORMATION, allEntries = true)
    @Override
    public ClientInformation save(ClientInformation entity) {
        return super.save(entity);
    }

    public String queryForPrevProjEndDate(Long id) {
        TypedQuery<ClientInformation> q = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " WHERE employee.id=:employeeIdParam order by endDate desc)", entityCls);
        q.setParameter("employeeIdParam", id);
        if (q.getResultList().size() > 0) {
            ClientInformation ci = q.getResultList().get(0);
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            return sdf.format(ci.getEndDate());
        } else {
            return null;
        }
    }
    
    @Transactional(readOnly = true)
    public List<ClientInformation> queryForProjEndBetweenDays(int start, int limit, Date startDate, Date endDate) {
        Query findAllQuery = getEntityManager().createQuery("from " + ClientInformation.class.getCanonicalName() + " WHERE endDate>=:startDateParam AND endDate<=:endDateParam", entityCls);
        findAllQuery.setParameter("startDateParam", startDate);
        findAllQuery.setParameter("endDateParam", endDate);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static ClientInformationDao instance() {
        return SpringContext.getBean(ClientInformationDao.class);
    }
}
