/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.toolbox;

import info.chili.commons.DateUtils;
import info.chili.jpa.QueryUtils;
import info.chili.jpa.validation.ValidationUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.client.ClientDao;
import info.yalamanchili.office.dao.client.VendorDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dto.profile.EmployeeCreateDto;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.client.InvoiceDeliveryMethod;
import info.yalamanchili.office.entity.client.InvoiceFrequency;
import info.yalamanchili.office.entity.client.Subcontractor;
import info.yalamanchili.office.entity.client.Vendor;
import info.yalamanchili.office.entity.profile.BillingDuration;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.profile.Sex;
import info.yalamanchili.office.profile.EmployeeService;
import static info.chili.docs.ExcelUtils.getCellNumericValue;
import static info.chili.docs.ExcelUtils.getCellStringOrNumericValue;
import static info.chili.docs.ExcelUtils.getCellStringValue;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Component("nonEmpDataTool")
@Transactional
@Scope("prototype")
public class NonEmpDataTool {

    private static final Log log = LogFactory.getLog(NonEmpDataTool.class);

    @PersistenceContext
    protected EntityManager em;

    public static void main(String... strings) {
        NonEmpDataTool tool = new NonEmpDataTool();
        tool.loadNonEmpData();
    }

    public void loadNonEmpData() {
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
            if (record.getRowNum() == 0) {
                continue;
            }
            String empType = getCellStringValue(record, 24);
            if (StringUtils.isNotBlank(empType) && (empType.equalsIgnoreCase("Subcontractor") || empType.equalsIgnoreCase("1099 Contractor"))) {
                EmployeeCreateDto dto = new EmployeeCreateDto();
                dto.setFirstName(getCellStringValue(record, 25));
                dto.setLastName(getCellStringValue(record, 26));
                dto.setEmail(getCellStringValue(record, 41));
                if (empType.equalsIgnoreCase("Subcontractor")) {
                    dto.setEmployeeType((EmployeeType) QueryUtils.findEntity(em, EmployeeType.class, "name", "Subcontractor"));

                }
                if (empType.equalsIgnoreCase("1099 Contractor")) {
                    dto.setEmployeeType((EmployeeType) QueryUtils.findEntity(em, EmployeeType.class, "name", "1099 Contractor"));
                }
                String gender = getCellStringValue(record, 43);
                if (StringUtils.isNotBlank(gender)) {
                    dto.setSex(Sex.valueOf(gender.toUpperCase()));
                }
                String dob = getCellStringOrNumericValue(record, 42);
                if (StringUtils.isNotBlank(dob) && dob.length() > 4) {
                    dto.setDateOfBirth(DateUtils.parse(dob, "dd-MMM-yyyy"));
                }
                if (dto.getDateOfBirth() == null || dto.getDateOfBirth().after(new Date())) {
                    dto.setDateOfBirth(DateUtils.getNextDay(new Date(), -1));
                }
                String empId = EmployeeService.instance().createUser(dto);
                //read sub contractor information
                String subContractorName = getCellStringValue(record, 14);
                Subcontractor subContractor = QueryUtils.findEntity(em, Subcontractor.class, "name", subContractorName);
                if (subContractor == null && !subContractorName.equalsIgnoreCase(null)) {
                    subContractor = new Subcontractor();
                    subContractor.setName(getCellStringValue(record, 14));
                    subContractor = em.merge(subContractor);
                }
                subContractor = em.merge(subContractor);

                ClientInformation ci = new ClientInformation();
                ci.setClient(getClient(getCellStringValue(record, 36)));
                ci.setVendor(getVendor(getCellStringValue(record, 35)));
                if (subContractor != null) {
                    ci.setSubcontractor(subContractor);
                }
                if (empType.equalsIgnoreCase("Subcontractor")) {
                    ci.setSubcontractorPayRate(new BigDecimal(getCellNumericValue(record, 18)));
                    ci.setSubcontractorpaymentTerms(getCellStringValue(record, 21));
                    ci.setSubcontractorw4Filled(convertToBoolean(getCellStringOrNumericValue(record, 23)));
                }
                ci.setConsultantJobTitle(getCellStringValue(record, 34));
                String startDate = getCellStringOrNumericValue(record, 37);
                if (StringUtils.isNotBlank(startDate) && startDate.length() > 4) {
                    ci.setStartDate(DateUtils.parse(startDate, "dd-MMM-yyyy"));
                }
                ci.setItemNumber(convertDcimalToWhole(getCellStringOrNumericValue(record, 0)));
                String billingRate = getCellNumericValue(record, 1);
                if (billingRate != null) {
                    ci.setBillingRate(new BigDecimal(getCellNumericValue(record, 1)));
                }
                ci.setBillingRateDuration((BillingDuration) convertEnum(BillingDuration.class, getCellStringValue(record, 5)));
                String overtimeRate = getCellNumericValue(record, 3);
                if (overtimeRate != null) {
                    ci.setOverTimeBillingRate(new BigDecimal(getCellNumericValue(record, 3)));
                }

                ci.setNotes(getCellStringValue(record, 12));
                ci.setVisaStatus(getCellStringValue(record, 11));
                ci.setInvoiceDeliveryMethod((InvoiceDeliveryMethod) convertEnum(InvoiceDeliveryMethod.class, getCellStringValue(record, 8)));
                ci.setInvoiceFrequency((InvoiceFrequency) convertEnum(InvoiceFrequency.class, getCellStringValue(record, 7)));
                //ci.setVendorPaymentTerm(getCellStringValue(record, 40));
                ci.setSignedCopyOfWorkOrder(convertToBoolean(getCellStringOrNumericValue(record, 39)));
                ci.setHrOrientation(convertToBoolean(getCellStringOrNumericValue(record, 28)));
                ci.setLogisticsPreparation(convertToBoolean(getCellStringOrNumericValue(record, 29)));
                ci.setI9Filled(convertToBoolean(getCellStringOrNumericValue(record, 30)));
                ci.setW4Filled(convertToBoolean(getCellStringOrNumericValue(record, 31)));

                for (ConstraintViolation cv : ValidationUtils.validate(ci)) {
                    System.out.println("-----------------validation ERROR------" + cv.getInvalidValue());
                    System.out.println("-----------------validation MESSAGE------" + cv.getMessage());
                }
                if (ValidationUtils.validate(ci).size() < 1) {
                    ci = em.merge(ci);
                    EmployeeDao.instance().findById(new Long(empId)).addClientInformation(ci);
                }
            }
        }
    }

    protected Client getClient(String clientName) {
        List<String> columns = new ArrayList<String>();
        columns.add("name");
        for (Client client : ClientDao.instance().search(clientName.replace("'", ""), 0, 10, columns, true, true)) {
            if (client.getName().toUpperCase().equals(clientName.trim().toUpperCase())) {
                return client;
            }
        }
        System.out.println("------------client not found---------" + clientName);
        return null;
    }

    protected Vendor getVendor(String vendorName) {
        List<String> columns = new ArrayList<String>();
        columns.add("name");
        for (Vendor vendor : VendorDao.instance().search(vendorName.replace("'", ""), 0, 10, columns, true, true)) {
            if (vendor.getName().toUpperCase().equals(vendorName.trim().toUpperCase())) {
                return vendor;
            }
        }
        System.out.println("------------vendor not found---------" + vendorName);
        return null;
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

    protected String convertDcimalToWhole(String itemNumber) {
        if (StringUtils.isNotEmpty(itemNumber) && itemNumber.contains(".")) {
            return itemNumber.substring(0, itemNumber.indexOf("."));
        } else {
            return itemNumber;
        }
    }

    protected boolean convertToBoolean(String booleanValue) {
        if (StringUtils.isNotBlank(booleanValue) && convertDcimalToWhole(booleanValue.trim()).equals("1")) {
            return true;
        }
        return false;
    }

    protected String getDataFileUrl() {
        return OfficeServiceConfiguration.instance().getDataloadFilePath();
    }

    public static NonEmpDataTool instance() {
        return (NonEmpDataTool) SpringContext.getBean("nonEmpDataTool");
    }
}
