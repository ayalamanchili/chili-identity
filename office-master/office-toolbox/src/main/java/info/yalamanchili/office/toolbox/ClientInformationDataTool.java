/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.toolbox;

import static info.chili.docs.ExcelUtils.getCellNumericValue;
import static info.chili.docs.ExcelUtils.getCellStringOrNumericValue;
import static info.chili.docs.ExcelUtils.getCellStringValue;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.client.ClientDao;
import info.yalamanchili.office.dao.client.ProjectDao;
import info.yalamanchili.office.dao.client.SubcontractorDao;
import info.yalamanchili.office.dao.client.VendorDao;
import info.yalamanchili.office.dao.practice.PracticeDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.dao.profile.ContactDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.client.InvoiceDeliveryMethod;
import info.yalamanchili.office.entity.client.InvoiceFrequency;
import info.yalamanchili.office.entity.client.Project;
import info.yalamanchili.office.entity.client.Subcontractor;
import info.yalamanchili.office.entity.client.Vendor;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.BillingDuration;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.ClientInformationCompany;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.toolbox.types.CPDRecord;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Madhu.Badiginchala
 */
@Component("clientInformationDataTool")
@Transactional
public class ClientInformationDataTool {

    private static final Log log = LogFactory.getLog(ClientInformationDataTool.class);

    public static void main(String... args) {
        ClientInformationDataTool tool = new ClientInformationDataTool();
        tool.bisCPDMigration();
    }

    @Autowired
    protected ClientInformationDao clientInformationDao;

    public void bisCPDMigration() {
        InputStream inp;
        XSSFWorkbook workbook;
        try {
            inp = new FileInputStream(getDataFileUrl());
            workbook = new XSSFWorkbook(inp);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row record = rowIterator.next();
            Employee emp = new Employee();
            ClientInformation clientInfo = new ClientInformation();
            Vendor vendor = new Vendor();
            Vendor middleVendor = new Vendor();
            Project project = new Project();
            Client client = new Client();
            Address address = new Address();
            if (record.getRowNum() == 0) {
                continue;
            }
            CPDRecord cpd = new CPDRecord();
            cpd.setEmployeeId(new Long(convertDcimalToWhole(getCellNumericValue(record, 2))));
            emp = EmployeeDao.instance().findById(cpd.getEmployeeId());
            cpd.setStartDate(convertToDate(getCellNumericValue(record, 4)));
            cpd.setEndDate(convertToDate(getCellNumericValue(record, 5)));
            if (cpd.getStartDate() != null) {
                clientInfo.setStartDate(cpd.getStartDate());
            }
            if (cpd.getEndDate() != null) {
                clientInfo.setStartDate(cpd.getEndDate());
            }
            cpd.setItemNum(convertDcimalToWhole(getCellStringOrNumericValue(record, 6)));
            if (cpd.getItemNum() != null) {
                clientInfo.setItemNumber(cpd.getItemNum());
            }
            cpd.setPayRate(new BigDecimal(getCellNumericValue(record, 8)));
            if (cpd.getPayRate() != null) {
                clientInfo.setPayRate(cpd.getPayRate());
            }
            cpd.setOverTimePayrate(new BigDecimal(getCellNumericValue(record, 10)));
            if (cpd.getOverTimePayrate() != null) {
                clientInfo.setOverTimePayRate(cpd.getOverTimePayrate());
            }
            cpd.setBillingDuration((BillingDuration) convertEnum(BillingDuration.class, getCellStringValue(record, 11)));
            if (cpd.getBillingDuration() != null) {
                clientInfo.setBillingRateDuration(cpd.getBillingDuration());
            }
            cpd.setOverTimeDuration((BillingDuration) convertEnum(BillingDuration.class, getCellStringValue(record, 12)));
            if (cpd.getOverTimeDuration() != null) {
                clientInfo.setOverTimeRateDuration(cpd.getOverTimeDuration());
            }
            cpd.setJobTitle(getCellStringValue(record, 14));
            if (cpd.getJobTitle() != null) {
                clientInfo.getEmployee().setJobTitle(cpd.getJobTitle());
            }
            cpd.setInvoiceFrequency((InvoiceFrequency) convertEnum(InvoiceFrequency.class, getCellStringValue(record, 16)));
            if (cpd.getInvoiceFrequency() != null) {
                clientInfo.setInvoiceFrequency(cpd.getInvoiceFrequency());
            }
            cpd.setInvoiceDeliveryMethod((InvoiceDeliveryMethod) convertEnum(InvoiceDeliveryMethod.class, getCellStringValue(record, 16)));
            if (cpd.getInvoiceDeliveryMethod() != null) {
                clientInfo.setInvoiceDeliveryMethod(cpd.getInvoiceDeliveryMethod());
            }
            cpd.setRecID1(new Long(convertDcimalToWhole(getCellNumericValue(record, 18))));
            if (cpd.getRecID1() != null) {
                clientInfo.getRecruiters().add(EmployeeDao.instance().findById(cpd.getRecID1()));
            }
            cpd.setRecID2(new Long(convertDcimalToWhole(getCellNumericValue(record, 19))));
            if (cpd.getRecID2() != null) {
                clientInfo.getRecruiters().add(EmployeeDao.instance().findById(cpd.getRecID2()));
            }
            cpd.setRecID3(new Long(convertDcimalToWhole(getCellNumericValue(record, 20))));
            if (cpd.getRecID3() != null) {
                clientInfo.getRecruiters().add(EmployeeDao.instance().findById(cpd.getRecID3()));
            }
            cpd.setRecID4(new Long(convertDcimalToWhole(getCellNumericValue(record, 21))));
            if (cpd.getRecID4() != null) {
                clientInfo.getRecruiters().add(EmployeeDao.instance().findById(cpd.getRecID4()));
            }
            cpd.setSubContractorID(new Long(convertDcimalToWhole(getCellNumericValue(record, 23))));
            if (cpd.getSubContractorID() != null) {
                Subcontractor subcontractor = SubcontractorDao.instance().findById(cpd.getSubContractorID());
                clientInfo.setSubcontractor(subcontractor);
            }
            cpd.setSubContractorContactID(new Long(convertDcimalToWhole(getCellNumericValue(record, 25))));
            if (cpd.getSubContractorContactID() != null) {
                Contact contact = ContactDao.instance().findById(cpd.getSubContractorContactID());
                clientInfo.setSubcontractorContact(contact);
            }
            cpd.setSubContractorPayRate(new BigDecimal(getCellNumericValue(record, 26)));
            if (cpd.getSubContractorPayRate() != null) {
                clientInfo.setSubcontractorPayRate(cpd.getSubContractorPayRate());
            }
            cpd.setSubcontractorinvoiceFrequency((InvoiceFrequency) convertEnum(InvoiceFrequency.class, getCellStringValue(record, 28)));
            if (cpd.getSubcontractorinvoiceFrequency() != null) {
                clientInfo.setSubcontractorinvoiceFrequency(cpd.getSubcontractorinvoiceFrequency());
            }
            cpd.setSubContractorOverTimePayRate(new BigDecimal(getCellNumericValue(record, 29)));
            if (cpd.getSubContractorOverTimePayRate() != null) {
                clientInfo.setSubcontractorOvertimePayRate(cpd.getSubContractorOverTimePayRate());
            }
            cpd.setVenAPID1(new Long(convertDcimalToWhole(getCellNumericValue(record, 33))));
            if (cpd.getVenAPID1() != null) {
                clientInfo.getVendorAPContacts().add(ContactDao.instance().findById(cpd.getVenAPID1()));
            }
            cpd.setVenAPID2(new Long(convertDcimalToWhole(getCellNumericValue(record, 34))));
            if (cpd.getVenAPID2() != null) {
                clientInfo.getVendorAPContacts().add(ContactDao.instance().findById(cpd.getVenAPID2()));
            }
            cpd.setVenAPID3(new Long(convertDcimalToWhole(getCellNumericValue(record, 35))));
            if (cpd.getVenAPID3() != null) {
                clientInfo.getVendorAPContacts().add(ContactDao.instance().findById(cpd.getVenAPID3()));
            }
            cpd.setCompany((ClientInformationCompany) convertEnum(ClientInformationCompany.class, getCellStringValue(record, 40)));
            if (cpd.getCompany() != null) {
                clientInfo.setCompany(cpd.getCompany());
            }
            cpd.setVenRECID1(new Long(convertDcimalToWhole(getCellNumericValue(record, 48))));
            if (cpd.getVenRECID1() != null) {
                clientInfo.getVendorRecruiters().add(ContactDao.instance().findById(cpd.getVenRECID1()));
            }
            cpd.setVenRECID2(new Long(convertDcimalToWhole(getCellNumericValue(record, 49))));
            if (cpd.getVenRECID2() != null) {
                clientInfo.getVendorRecruiters().add(ContactDao.instance().findById(cpd.getVenRECID2()));
            }
            cpd.setPracticeID(new Long(convertDcimalToWhole(getCellNumericValue(record, 70))));
            if (cpd.getPracticeID() != null) {
                clientInfo.setPractice(PracticeDao.instance().findById(cpd.getPracticeID()));
            }
            cpd.setSectorsAndBUs(getCellStringValue(record, 71));
            if (cpd.getSectorsAndBUs() != null) {
                clientInfo.setSectorsAndBUs(cpd.getSectorsAndBUs());
            }
            cpd.setClientID(new Long(convertDcimalToWhole(getCellNumericValue(record, 76))));
            if (cpd.getClientID() != null) {
                clientInfo.setClient(ClientDao.instance().findById(cpd.getClientID()));
            }
            cpd.setVendorID(new Long(convertDcimalToWhole(getCellNumericValue(record, 74))));
            if (cpd.getVendorID() != null) {
                clientInfo.setVendor(VendorDao.instance().findById(cpd.getVendorID()));
            }
            cpd.setProjectName(getCellStringValue(record, 72));
            if (cpd.getProjectName() != null) {
                project.setName(cpd.getProjectName());
            }
            cpd.setPurchaseOrderNo(getCellStringValue(record, 78));
            if (cpd.getPurchaseOrderNo() != null) {
                project.setPurchaseOrderNo(cpd.getPurchaseOrderNo());
            }
            if ((cpd.getVendorID() != null) && (cpd.getClientID() != null)) {
                project.setVendor(vendor);
                client.getVendors().add(vendor);
                vendor.getClients().add(client);
                VendorDao.instance().save(vendor);
            }
            if (cpd.getStartDate() != null) {
                project.setStartDate(cpd.getStartDate());
            }
            if (cpd.getClientID() != null) {
                project.setClient(client);
                ClientDao.instance().save(client);
            }
            if (project != null) {
                project = ProjectDao.instance().save(project);
                clientInfo.setClientProject(project);
            }
            clientInfo = clientInformationDao.save(clientInfo);
            emp.addClientInformation(clientInfo);
            EmployeeDao.instance().getEntityManager().merge(emp);

        }
    }

    protected String getDataFileUrl() {
        return OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "BIS_ClientInformationData.xlsx";
    }

    protected String convertDcimalToWhole(String id) {
        if (StringUtils.isNotEmpty(id) && id.contains(".")) {
            return id.substring(0, id.indexOf("."));
        } else {
            return id;
        }
    }

    protected Enum convertEnum(Class enumClass, String value) {
        try {
            if (StringUtils.isNotBlank(value)) {
                return Enum.valueOf(enumClass, value.toUpperCase().replace("-", "_"));
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    protected Date convertToDate(String dte) {
        if (dte != null) {
            Date date = null;
            try {
                date = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).parse(dte);
                return date;
            } catch (ParseException ex) {
                System.out.println("date parsing error" + dte);
            }
        }
        return null;
    }

    public static ClientInformationDataTool instance() {
        return SpringContext.getBean(ClientInformationDataTool.class);
    }

}
