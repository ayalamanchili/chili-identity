/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.reports.recruiting;

import info.chili.reporting.ReportGenerator;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.SkillSetDao;
import info.yalamanchili.office.dto.profile.SkillSetDto;
import info.yalamanchili.office.entity.profile.Certification;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.profile.Skill;
import info.yalamanchili.office.entity.profile.SkillSet;
import info.yalamanchili.office.entity.recruiting.SkillSetTag;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
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

    public List<SkillSetDto> search(String text) {
        List<SkillSetDto> res = new ArrayList<>();
        for (SkillSet entity : SkillSetDao.instance().hibernateSearch(text, 0, 100, "resumeContent", "skills.name", "certifications.name", "tags.name")) {
            SkillSetDto dto = mapper.map(entity, SkillSetDto.class);
            dto.setEmployeeName(entity.getEmployee().getFirstName() + " " + entity.getEmployee().getLastName());
            res.add(dto);
        }
        return res;
    }

    public List<SkillSetDto> searchSkillSet(SkillSetSearchDto searchDto) {
        List<SkillSetDto> dtos = new ArrayList<>();
        TypedQuery<Employee> query = em.createQuery(getSearchSkillSetQueryString(searchDto), Employee.class);
        for (Object empObj : query.getResultList()) {
            Employee emp = (Employee) empObj;
            SkillSet skillSet = emp.getSkillSet();
                SkillSetDto dto = mapper.map(skillSet, SkillSetDto.class);
                dto.setEmployeeName(skillSet.getEmployee().getFirstName()+" "+skillSet.getEmployee().getLastName());
                dtos.add(dto);
            }
        return dtos;
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

    @Async
    @Transactional
    public void generateEmployeeSkillSetReport(String email) {
        List<EmployeeSkillSetReportDto> res = new ArrayList<>();
        for (Employee emp : EmployeeDao.instance().getEmployeesByType(EmployeeType.CORPORATE_EMPLOYEE, EmployeeType.EMPLOYEE, EmployeeType.INTERN_SEASONAL_EMPLOYEE)) {
            if (emp.getSkillSet() != null) {
                EmployeeSkillSetReportDto dto = new EmployeeSkillSetReportDto();
                dto.setEmployee(emp.getFirstName() + emp.getLastName());
                if (emp.getSkillSet().getSkills().size() > 0) {
                    int count = emp.getSkillSet().getSkills().size();
                    StringBuilder skills = new StringBuilder("");
                    for (Skill skill : emp.getSkillSet().getSkills()) {
                        skills.append(skill.getName());
                        if (count > 1) {
                            skills.append(",");
                            count--;
                        }
                    }
                    dto.setSkills(skills.toString());
                }
                if (emp.getSkillSet().getCertifications().size() > 0) {
                    int councert = emp.getSkillSet().getCertifications().size();
                    StringBuilder certifications = new StringBuilder("");
                    for (Certification cert : emp.getSkillSet().getCertifications()) {
                        certifications.append(cert.getName());
                        if (councert > 1) {
                            certifications.append(",");
                            councert--;
                        }
                    }
                    dto.setCertifications(certifications.toString());
                }
                if (emp.getSkillSet().getTags().size() > 0) {
                    int counttags = emp.getSkillSet().getTags().size();
                    StringBuilder tags = new StringBuilder("");
                    for (SkillSetTag tag : emp.getSkillSet().getTags()) {
                        tags.append(tag.getName());
                        if (counttags > 1) {
                            tags.append(",");
                            counttags--;
                        }
                    }
                    dto.setSkillSetTags(tags.toString());
                }
                //if (emp.getSkillSet().getResumeUrl() != null && emp.getSkillSet().getResumeUrl().contains("SkillSet")) {
                if (emp.getSkillSet().getSkillSetFile().size() > 0) {
                    dto.setResumeUploadStatus("Yes");
                } else {
                    dto.setResumeUploadStatus("No");
                }
                if (emp.getSkillSet().getPractice() != null) {
                    dto.setPractice(emp.getSkillSet().getPractice().getName());
                }
                if (emp.getSkillSet().getTechnologyGroup() != null) {
                    dto.setTechnologyGroup(emp.getSkillSet().getTechnologyGroup().getName());
                }
                res.add(dto);
            }
        }
        String[] columnOrder = new String[]{"employee", "skills", "certifications", "skillSetTags", "practice", "technologyGroup", "resumeUploadStatus"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(res, "Employee-SkillSet-Information-Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);
    }

    protected boolean disableRegularSearch() {
        return true;
    }

    public static RecruitingReportsService instance() {
        return SpringContext.getBean(RecruitingReportsService.class);
    }
}
