/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.chili.reporting.ReportGenerator;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dto.profile.EmployeProfileDto;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("request")
public class ProfileReportingService {

    @Async
    public void generateProfileReport(String email) {
        List<EmployeProfileDto> res = new ArrayList();
        for (Employee emp : EmployeeDao.instance().query(0, 1000)) {
            EmployeProfileDto dto = new EmployeProfileDto();
            dto.setFirstName(emp.getFirstName());
            dto.setLastName(emp.getLastName());
            dto.setEmployeeType(emp.getEmployeeType());
            dto.setDateOfBirth(emp.getDateOfBirth());
            dto.setJobTitle(emp.getJobTitle());
            dto.setEmail(emp.getPrimaryEmail().getEmail());
            if (emp.getPhones().size() > 0) {
                dto.setPhoneNumber(emp.getPhones().get(0).getPhoneNumber());
            }
            dto.setBranch(emp.getBranch());
            dto.setWorkStatus(emp.getWorkStatus());
            if(emp.getAddresss().size()>0){
                dto.setHomeAddress1(emp.getAddresss().get(0).getStreet1());
                dto.setHomeAddress2(emp.getAddresss().get(0).getStreet2());
                dto.setHomeAddressCity(emp.getAddresss().get(0).getCity());
                dto.setHomeAddressState(emp.getAddresss().get(0).getState());
                dto.setHomeAddressCountry(emp.getAddresss().get(0).getCountry());
                dto.setHomeAddressZip(emp.getAddresss().get(0).getZip());
            }
            if(emp.getEmergencyContacts().size()>0){
                dto.setEmergencyContactName(emp.getEmergencyContacts().get(0).getContact().getFirstName()+" "+emp.getEmergencyContacts().get(0).getContact().getLastName());
            }
            res.add(dto);
        }
        MessagingService.instance().emailReport(ReportGenerator.generateExcelReport(res, "Profile-Information-Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot()), email);
    }

    public static ProfileReportingService instance() {
        return SpringContext.getBean(ProfileReportingService.class);
    }

}
