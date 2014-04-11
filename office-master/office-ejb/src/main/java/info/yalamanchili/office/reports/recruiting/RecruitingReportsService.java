/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.reports.recruiting;

import info.chili.commons.SearchUtils;
import info.yalamanchili.office.dto.profile.EmployeeDto;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.SkillSet;
import java.util.ArrayList;
import java.util.List;
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
        //TODO need to pass only necessary columns that are used for searching
        Query searchQ = em.createQuery(SearchUtils.getSearchQueryString(SkillSet.class, text, null));
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
        sb.append("select DISTINCT emp from SkillSet skillSet, Employee emp ");
        if (searchDto.getTags() != null) {
            sb.append(" join skillSet.tags tags ");
        }
        if (searchDto.getSkills() != null) {
            sb.append(" join skillSet.skills skills ");
        }
        if (searchDto.getCertifications() != null) {
            sb.append(" join skillSet.certifications certifications ");
        }
        sb.append("where skillSet.employee.id=emp.id ");
        //Practice
        if (searchDto.getPractice() != null) {
            sb.append("and skillSet.practice.name like'%").append(searchDto.getPractice().trim()).append("%' ");
        }
        //Technology Group
        if (searchDto.getTechnologyGroup() != null) {
            sb.append("and skillSet.technologyGroup.name like'%").append(searchDto.getTechnologyGroup().trim()).append("%' ");
        }
        //Skills
        if (searchDto.getSkills() != null) {
            sb.append("and skills.name like'%").append(searchDto.getSkills().trim()).append("%' ");
        }
        //Certifications
        if (searchDto.getCertifications() != null) {
            sb.append("and certifications.name like'%").append(searchDto.getCertifications().trim()).append("%' ");
        }
        //Tags
        if (searchDto.getTags() != null) {
            sb.append("and tags.name like'%").append(searchDto.getTags().trim()).append("%' ");
        }
        return sb.toString();
    }

    protected boolean disableRegularSearch() {
        return true;
    }
}
