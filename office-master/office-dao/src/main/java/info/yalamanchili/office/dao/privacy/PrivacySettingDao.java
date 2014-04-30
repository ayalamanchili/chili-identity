/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.privacy;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.privacy.PrivacyData;
import info.yalamanchili.office.entity.privacy.PrivacyMode;
import info.yalamanchili.office.entity.privacy.PrivacySetting;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anuyalamanchili
 */
@Repository
@Scope("prototype")
public class PrivacySettingDao extends CRUDDao<PrivacySetting> {

    @PersistenceContext
    protected EntityManager em;

    public PrivacySettingDao() {
        super(PrivacySetting.class);
    }

    public List<PrivacySetting> getPrivacySettings(Employee employee) {
        Query q = getEntityManager().createQuery("from " + PrivacySetting.class.getCanonicalName() + " where employee=:employeeParam", PrivacySetting.class);
        q.setParameter("employeeParam", employee);
        return q.getResultList();
    }
//TODO cache this

    public PrivacySetting getPrivacySettingsForData(Employee employee, PrivacyData privacyDataParam) {
        Query q = getEntityManager().createQuery("from " + PrivacySetting.class.getCanonicalName() + " where employee=:employeeParam and privacyData=:privacyDataParam", PrivacySetting.class);
        q.setParameter("employeeParam", employee);
        q.setParameter("privacyDataParam", privacyDataParam);
        if (q.getResultList().size() > 0) {
            return (PrivacySetting) q.getResultList().get(0);
        } else {
            return null;
        }
    }

    @Override
    public PrivacySetting save(PrivacySetting privacySetting) {
        Employee emp = EmployeeDao.instance().findById(privacySetting.getEmployee().getId());
        if (PrivacyData.ALL.equals(privacySetting.getPrivacyData())) {
            makeAllDataPublic(emp);
            return null;
        } else {
            return savePrivacySetting(emp, privacySetting.getPrivacyData());
        }
    }

    public void makeAllDataPublic(Employee emp) {
        for (PrivacyData data : PrivacyData.values()) {
            if (PrivacyData.ALL.equals(data)) {
                continue;
            }
            savePrivacySetting(emp, data);
        }
    }

    protected PrivacySetting savePrivacySetting(Employee emp, PrivacyData privacyData) {
        PrivacySetting ps = getPrivacySettingsForData(emp, privacyData);
        if (ps == null) {
            ps = new PrivacySetting();
            ps.setEmployee(emp);
            ps.setPrivacyData(privacyData);
            ps.setPrivacyMode(PrivacyMode.PUBLIC);
            ps = super.save(ps);
        }
        return ps;
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static PrivacySettingDao instance() {
        return SpringContext.getBean(PrivacySettingDao.class);
    }
}
