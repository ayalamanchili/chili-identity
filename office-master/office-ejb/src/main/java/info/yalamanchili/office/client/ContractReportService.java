/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client;

import info.chili.reporting.ReportGenerator;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.client.ContractReportDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.EmployeeDao.EmployeeTable;
import info.yalamanchili.office.dao.profile.EmployeeDto;
import info.yalamanchili.office.dao.profile.EmployeeLocationDto;
import info.yalamanchili.office.dao.profile.EmployeeLocationReportDto;
import info.yalamanchili.office.dto.client.ContractDto;
import info.yalamanchili.office.dto.client.ContractDto.ContractTable;
import info.yalamanchili.office.dto.client.ContractSearchDto;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radhika.mukkala
 */
@Component
@Scope("request")
public class ContractReportService {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;

    public static ContractReportService instance() {
        return SpringContext.getBean(ContractReportService.class);
    }

    public EmployeeDao.EmployeeTable empJoinedLeftInAPeriod(int start, int limit, Date startDate, Date endDate, String value) {
        EmployeeTable table = new EmployeeTable();
        List<EmployeeDto> dtos = new ArrayList();
        EmployeeDao.instance().queryBetweenDays(start, limit, startDate, endDate, value).stream().forEach((empObj) -> {
            dtos.add(info.yalamanchili.office.dao.profile.EmployeeDto.map(mapper, (Employee) empObj));
        });
        table.setEntities(dtos);
        table.setSize(Long.valueOf(dtos.size()));
        return table;
    }

    @Async
    @Transactional
    public void empJoinedLeftInAPeriodReport(int start, int limit, Date startDate, Date endDate, String value, String email) {
        EmployeeTable table = empJoinedLeftInAPeriod(0, 10000, startDate, endDate, value);
        if (table.getSize() > 0) {
            String[] columnOrder = new String[]{"firstName", "lastName", "startDate", "endDate", "phoneNumber"};
            String fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "Emp Joined Or Left In a Period Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
            MessagingService.instance().emailReport(fileName, email);
        }
    }

    public List<ContractDto> getMultipleCpds() {
        ContractSearchDto searchDto = new ContractSearchDto();
        List<ContractDto> dtos = new ArrayList();
        List<ContractDto> activeCpds = new ArrayList();
        String[] types = {"Corporate Employee", "Employee", "Subcontractor", "W2 Contractor", "1099 Contractor", EmployeeType.INTERN_SEASONAL_EMPLOYEE};
        for (String type : types) {
            searchDto.setEmployeeType(type);
            dtos.addAll(ContractService.instance().getResultForReport(searchDto).getEntities());
        }
        activeCpds = ContractService.instance().activeCPDs(dtos);
        if (activeCpds.size() > 1) {
            return activeCpds;
        } else {
            return null;
        }
    }

    @Async
    @Transactional
    public void multipleCPDsReport(String email) {
        List<ContractDto> dtos = getMultipleCpds();
        if (dtos != null) {
            String[] columnOrder = new String[]{"employee", "client", "vendor", "billingRate", "startDate", "endDate"};
            String fileName = ReportGenerator.generateExcelOrderedReport(dtos, "Employees On Multiple Projects Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
            MessagingService.instance().emailReport(fileName, email);
        }
    }

    public List<ContractDto> getEmpsInLocation(EmployeeLocationDto dto, int start, int limit) {
        List<Employee> emps = ContractReportDao.instance().getEmpsInLocation(dto);
        List<ContractDto> dtos = new ArrayList();
        if (emps != null) {
            emps.stream().map((emp) -> emp.getClientInformations()).filter((cpds) -> (cpds.size() > 0)).forEach((cpds) -> {
                cpds.stream().forEach((ci) -> {
                    dtos.add(ContractService.instance().mapClientInformation(ci));
                });
            });
        }
        List<ContractDto> activeCpds = ContractService.instance().activeCPDs(dtos);
        if (activeCpds != null && activeCpds.size() > 0) {
            return activeCpds;
        } else {
            return null;
        }
    }

    @Async
    @Transactional
    public void getEmpsLocationReport(EmployeeLocationDto dto, String email) {
        List<ContractDto> dtos = getEmpsInLocation(dto, 0, 10000);
        if (dtos != null) {
            String[] columnOrder = new String[]{"employee", "client", "clientLocation", "vendor", "startDate", "endDate"};
            if (dto.getCity() != null) {
                String fileName = ReportGenerator.generateExcelOrderedReport(dtos, "Emp Working In City " + dto.getCity(), OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
                MessagingService.instance().emailReport(fileName, email);
            } else if (dto.getState() != null) {
                String fileName = ReportGenerator.generateExcelOrderedReport(dtos, "Emp Working In State " + dto.getState(), OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
                MessagingService.instance().emailReport(fileName, email);
            }
        }
    }

    public List<EmployeeLocationReportDto> searchEmpsByAddress(EmployeeLocationDto dto) {
        List<Employee> emps = new ArrayList();
        emps = ContractReportDao.instance().getEmpsInLocation(dto);
        List<EmployeeLocationReportDto> dtos = new ArrayList();
        if (emps == null) {
            return null;
        } else {
            if (emps.size() > 0) {
                for (Employee emp : emps) {
                    dtos.add(EmployeeLocationReportDto.map(mapper, emp, dto));
                }
            }
            return dtos;
        }
    }

    @Async
    @Transactional
    public void getEmpsByAddressReport(EmployeeLocationDto dto, String email) {
        List<EmployeeLocationReportDto> dtos = searchEmpsByAddress(dto);
        if (dtos != null) {
            String[] columnOrder = new String[]{"employee", "branch", "street1", "street2", "city", "state", "country","zip"};
            String fileName = ReportGenerator.generateExcelOrderedReport(dtos, "Employee In A Location report ", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
            MessagingService.instance().emailReport(fileName, email);
        }
    }

    public ContractTable searchProjsBWDates(int start, int limit, Date startDate, Date endDate, String value, String employeeType) {
        ContractTable table = new ContractTable();
        List<ContractDto> dtos = new ArrayList();
        List<ClientInformation> cpds = ContractReportDao.instance().queryForProjEndBetweenDays(startDate, endDate, value, employeeType);
        for (ClientInformation cpd : cpds) {
            dtos.add(ContractService.instance().mapClientInformation(cpd));
        }
        table.setEntities(dtos);
        table.setSize((long) dtos.size());
        return table;
    }

    @Async
    @Transactional
    public void searchProjsBWDatesReport(Date startDate, Date endDate, String value, String employeeType, String email) {
        ContractTable table = searchProjsBWDates(0, 100000, startDate, endDate, value, employeeType);
        String[] columnOrder = new String[]{"employee", "client", "vendor", "startDate", "endDate", "billingRate", "subcontractorPayRate", "subContractorName", "recruiter"};
        String start = org.apache.http.client.utils.DateUtils.formatDate(startDate, "MM-dd-yyyy");
        String end = org.apache.http.client.utils.DateUtils.formatDate(endDate, "MM-dd-yyyy");
        String fileName = ReportGenerator.generateExcelOrderedReport(table.getEntities(), "Emp Projects Going To Start Or End Between " + start + " and " + end, OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder);
        MessagingService.instance().emailReport(fileName, email);
    }

    @Async
    @Transactional
    public void subContractorSummaryReport(String email) {
        ContractDto.ContractTable table = new ContractDto.ContractTable();
        ContractSearchDto searchDto = new ContractSearchDto();
        searchDto.setEmployeeType(EmployeeType.SUBCONTRACTOR);
        table = ContractService.instance().getResultForReport(searchDto);
        if (table != null) {
            String[] columnOrder = new String[]{"employee", "employeeType", "vendor", "vendorLocation", "vendorAPContact", "vendorRecruiter", "subContractorName", "subcontractorAddress", "subContractorContactName", "startDate", "endDate", "subcontractorPayRate"};
            MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(table.getEntities(), "SubContractors Summary Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);
        }
    }
}
