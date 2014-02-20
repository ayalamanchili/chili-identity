/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.reports.recruiting;

import info.chili.commons.ReflectionUtils;
import info.chili.commons.SearchUtils;
import info.yalamanchili.office.dto.profile.EmployeeDto;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.SkillSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("request")
public class RecruitingReportsService {

    @PersistenceContext
    protected EntityManager em;

    @Autowired
    protected Mapper mapper;

    public List<EmployeeDto> search(String text) {
        Query searchQ = em.createQuery(SearchUtils.getSearchQueryString(SkillSet.class, text));
        return searchQ.getResultList();
    }

    public List<EmployeeDto> searchSkillSet(SkillSetSearchDto searchDto) {
        List<info.yalamanchili.office.dto.profile.EmployeeDto> employees = new ArrayList<info.yalamanchili.office.dto.profile.EmployeeDto>();
        TypedQuery<Employee> query = em.createQuery(getSearchSkillSetQueryString(searchDto), Employee.class);
        for (Object empObj : query.getResultList()) {
            employees.add(info.yalamanchili.office.dto.profile.EmployeeDto.map(mapper, (Employee) empObj));
        }
        return employees;
    }

    public String getSearchSkillSetQueryString(SkillSetSearchDto searchDto) {
        StringBuilder sb = new StringBuilder();
        sb.append("select emp from SkillSet skillSet, Employee emp where skillSet.employee.id=emp.id ");
        for (Entry<String, String> entry : SkillSetSearchDto.properties.entrySet()) {
            if (ReflectionUtils.callGetter(searchDto, entry.getKey()) != null) {
                sb.append("and ");
                sb.append("skillSet.").append(entry.getValue()).append(" like '%").append(ReflectionUtils.callGetter(searchDto, entry.getKey()).toString().trim()).append("%'");
            }
        }
        return sb.toString();
    }

    protected boolean disableRegularSearch() {
        return true;
    }
}
