/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.contact;

import info.chili.commons.pdf.PDFUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.profile.EmployeeDto;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.template.TemplateService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;
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
public class ContactInfoReportingService {

    @Autowired
    protected Mapper mapper;
    @PersistenceContext
    protected EntityManager em;

    public Response getCorporateContactInfo() {
        List<EmployeeDto> res = new ArrayList<EmployeeDto>();
        for (Employee emp : OfficeSecurityService.instance().getUsersWithRoles(0, 2000, info.yalamanchili.office.OfficeRoles.OfficeRole.ROLE_CORPORATE_EMPLOYEE.name())) {
            EmployeeDto dto = new EmployeeDto();
            dto.setFirstName(emp.getFirstName());
            dto.setLastName(emp.getLastName());
            dto.setJobTitle(emp.getJobTitle());
            dto.setBranch(emp.getBranch());

            String primaryEmail = EmployeeDao.instance().getPrimaryEmail(emp);
            if (primaryEmail != null) {
                dto.setEmail(primaryEmail);
            }
            for (Phone phone : emp.getPhones()) {
                if (phone.getPhoneType() != null && "work".equalsIgnoreCase(phone.getPhoneType().getPhoneType())) {
                    dto.setPhoneNumber(phone.getPhoneNumber());
                    dto.setPhoneNumberExt(phone.getExtension());
                }
            }
            res.add(dto);
            Collections.sort(res, new Comparator<EmployeeDto>() {
                @Override
                public int compare(EmployeeDto dto1, EmployeeDto dto2) {
                    return dto1.getFirstName().compareTo(dto2.getFirstName());
                }
            });
        }
        String report = TemplateService.instance().process("corp-emp-contact-info.xhtml", res);
        //TODO move to commons
        byte[] pdf = PDFUtils.convertToPDF(report);
        return Response
                .ok(pdf)
                .header("content-disposition", "filename = corporate-employee-contact-info.pdf")
                .header("Content-Length", pdf.length)
                .build();
    }

    public static ContactInfoReportingService instance() {
        return SpringContext.getBean(ContactInfoReportingService.class);
    }
}
