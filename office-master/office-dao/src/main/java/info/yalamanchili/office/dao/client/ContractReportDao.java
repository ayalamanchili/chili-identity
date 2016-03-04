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
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    public List<ClientInformation> queryForProjEndBetweenDays(Date startDate, Date endDate, String value, String employeeType) {
        String searchQuery = getCpdsBWDates(value, employeeType);
        Query cpds = em.createQuery(searchQuery);
        cpds.setParameter("startDateParam", startDate);
        cpds.setParameter("endDateParam", endDate);
        return cpds.getResultList();
    }

    private String getCpdsBWDates(String value, String employeeType) {
        StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT ci from ").append(ClientInformation.class.getCanonicalName()).append(" as ci where ");

        if (value.equalsIgnoreCase("startDate")) {
            queryStr.append("startDate>=:startDateParam AND startDate<=:endDateParam").append(" and ");
        }
        if (value.equalsIgnoreCase("endDate")) {
            queryStr.append("endDate>=:startDateParam AND endDate<=:endDateParam").append(" and ");
        }
        if (employeeType != null) {
            queryStr.append("ci.employee.employeeType.name = '").append(employeeType).append("' ").append(" and ");
        }
        return queryStr.toString().substring(0, queryStr.toString().lastIndexOf("and"));
    }
}
