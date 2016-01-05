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
import info.chili.reporting.ReportGenerator;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.EmployeeDto;
import info.yalamanchili.office.entity.profile.Certification;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Skill;
import info.yalamanchili.office.entity.profile.SkillSet;
import info.yalamanchili.office.entity.recruiting.SkillSetTag;
import info.yalamanchili.office.jms.MessagingService;
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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("prototype")
@Transactional
public class RecruitingReportsService {

    @PersistenceContext
    protected EntityManager em;

    @Autowired
    protected Mapper mapper;

    public List<EmployeeDto> search(String text) {
        //TODO need to pass only necessary columns that are used for searching
        Query searchQ = em.createQuery(SearchUtils.getSearchQueryString(SkillSet.class, text, null, true));
        return searchQ.getResultList();
    }

    public List<EmployeeDto> searchSkillSet(SkillSetSearchDto searchDto) {
        List<info.yalamanchili.office.dao.profile.EmployeeDto> employees = new ArrayList<>();
        TypedQuery<Employee> query = em.createQuery(getSearchSkillSetQueryString(searchDto), Employee.class);
        for (Object empObj : query.getResultList()) {
            employees.add(info.yalamanchili.office.dao.profile.EmployeeDto.map(mapper, (Employee) empObj));
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

    public void generateEmployeeSkillSetReport() {
        List<EmployeeSkillSetReportDto> res = new ArrayList<>();
        for (Employee emp : EmployeeDao.instance().getEmployeesByType("Corporate Employee", "Employee")) {
            EmployeeSkillSetReportDto dto = new EmployeeSkillSetReportDto();
            dto.setName(emp.getFirstName() + emp.getLastName());
            if (emp.getSkillSet() != null) {
                if (emp.getSkillSet().getPractice() != null) {
                    dto.setPractice(emp.getSkillSet().getPractice().getName());
                }
                if (emp.getSkillSet().getTechnologyGroup() != null) {
                    dto.setTechnologyGroup(emp.getSkillSet().getTechnologyGroup().getName());
                }
                StringBuilder skills = new StringBuilder("");
                for (Skill skill : emp.getSkillSet().getSkills()) {
                    skills.append(skill.getName()).append(",");
                }
                dto.setSkills(skills.toString());
                StringBuilder certifications = new StringBuilder("");
                for (Certification cert : emp.getSkillSet().getCertifications()) {
                    certifications.append(cert.getName()).append(",");
                }
                dto.setCertifications(skills.toString());
                StringBuilder tags = new StringBuilder("");
                for (SkillSetTag tag : emp.getSkillSet().getTags()) {
                    tags.append(tag.getName()).append(",");
                }
                dto.setTags(tags.toString());
            }
            res.add(dto);
        }
        MessagingService.instance().emailReport(ReportGenerator.generateExcelReport(res, "SkillSet-Information-Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot()), OfficeServiceConfiguration.instance().getAdminEmail());
    }

    protected boolean disableRegularSearch() {
        return true;
    }

    public static RecruitingReportsService instance() {
        return SpringContext.getBean(RecruitingReportsService.class);
    }
}
