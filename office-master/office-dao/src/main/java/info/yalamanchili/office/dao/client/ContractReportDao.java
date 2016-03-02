/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.client;

import com.google.common.base.Strings;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.EmployeeLocationDto;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author radhika.mukkala
 */
@Repository
@Scope("prototype")
public class ContractReportDao {

    @PersistenceContext
    protected EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    public static ContractReportDao instance() {
        return SpringContext.getBean(ContractReportDao.class);
    }

    protected String getSearchQuery(EmployeeLocationDto dto) {
        StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT emp from ").append(Employee.class.getCanonicalName()).append(" as emp");
        if (!Strings.isNullOrEmpty(dto.getCity()) || !Strings.isNullOrEmpty(dto.getState()) || !Strings.isNullOrEmpty(dto.getCountry())) {
            queryStr.append(" join emp.addresss as address");
        }
        queryStr.append("  where ");
        if (!Strings.isNullOrEmpty(dto.getCity())) {
            queryStr.append("lower(address.city) = '").append(dto.getCity().toLowerCase().trim()).append("' ").append(" and ");
        }
        if (!Strings.isNullOrEmpty(dto.getState())) {
            queryStr.append("address.state = '").append(dto.getState().trim()).append("' ").append(" and ");
        }
        if (!Strings.isNullOrEmpty(dto.getCountry())) {
            queryStr.append("address.country = '").append(dto.getCountry().trim()).append("' ").append(" and ");
        }
        if (!Strings.isNullOrEmpty(dto.getBranch())) {
            queryStr.append("emp.branch = '").append(dto.getBranch().trim()).append("' ").append(" and ");
        }

        return queryStr.toString().substring(0, queryStr.toString().lastIndexOf("and"));
    }

    public List<Employee> getEmpsInLocation(EmployeeLocationDto dto) {
        TypedQuery<Employee> emps = em.createQuery(getSearchQuery(dto), Employee.class);
        if (emps.getResultList().size() > 0) {
            return emps.getResultList();
        } else {
            return null;
        }
    }
}
