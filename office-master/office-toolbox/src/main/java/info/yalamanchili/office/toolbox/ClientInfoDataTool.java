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
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.client.InvoiceDeliveryMethod;
import info.yalamanchili.office.entity.client.InvoiceFrequency;
import info.yalamanchili.office.entity.profile.BillingDuration;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Employee;
import static info.chili.docs.ExcelUtils.getCellNumericValue;
import static info.chili.docs.ExcelUtils.getCellStringOrNumericValue;
import static info.chili.docs.ExcelUtils.getCellStringValue;
import info.yalamanchili.office.toolbox.types.ClientInformationRecord;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Component("clientInfoDataTool")
@Transactional
public class ClientInfoDataTool {

    private static final Log log = LogFactory.getLog(ClientInfoDataTool.class);

    public static void main(String... args) {
        ClientInfoDataTool load = new ClientInfoDataTool();
        System.out.println(load.readClientInfoData());
    }

    public void syncClientInformationData() {
        Map<Long, ClientInformationRecord> data = new HashMap<Long, ClientInformationRecord>();
        for (ClientInformationRecord record : readClientInfoData()) {
            if (StringUtils.isNotEmpty(record.getEmployeeId())) {
                Employee emp = OfficeSecurityService.instance().findEmployee(record.getEmployeeId());
                if (emp != null) {
                    for (ClientInformation ci : emp.getClientInformations()) {
                        double similarity1 = info.chili.commons.StringUtils.jaccardSimilarity(ci.getClient().getName().toUpperCase(), record.getClientName().toUpperCase().trim());
                        int similarity2 = info.chili.commons.StringUtils.stringSimilarity(ci.getClient().getName().toUpperCase(), record.getClientName().toUpperCase().trim());
                        if (similarity1 >= 0.10 || similarity2 > 1) {
                            log.info("processing employee:" + emp.getFirstName());
                            log.info("processing associated::" + record.getClientName() + "------" + ci.getClient().getName());
                            data.put(ci.getId(), record);
                        } else {
                            log.info("no client information found::" + record.getClientName() + "------" + ci.getClient().getName());
                        }
                    }
                }
            }
        }
        System.out.println("asdfasdf:" + data.keySet().size());
        mapAndSaveClientInformationValues(data);
    }

    protected void mapAndSaveClientInformationValues(Map<Long, ClientInformationRecord> data) {
        for (Entry<Long, ClientInformationRecord> entry : data.entrySet()) {
            ClientInformation ci = ClientInformationDao.instance().findById(entry.getKey());
            if (entry.getValue().getStartDate() != null) {
                ci.setStartDate(entry.getValue().getStartDate());
            }
            if (entry.getValue().getEndDate() != null) {
                ci.setEndDate(entry.getValue().getEndDate());
            }
            ci.setItemNumber(entry.getValue().getItemNumber());
            ci.setBillingRate(entry.getValue().getBillingRate());
            ci.setBillingRateDuration(entry.getValue().getBillingDuration());
            ci.setInvoiceDeliveryMethod(entry.getValue().getInvoiceDeliveryMethod());
            ci.setInvoiceFrequency(entry.getValue().getInvoiceFrequency());
            ci.setOverTimeBillingRate(entry.getValue().getOvertimePayRate());
            ci.setOverTimeRateDuration(entry.getValue().getOvertimeBillingDuration());
            ci.setNotes(entry.getValue().getNotes());
            ci.setSignedCopyOfWorkOrder(entry.getValue().isSignedCopyOfWO());
            ci.setHrOrientation(entry.getValue().isHrOrientation());
            ci.setLogisticsPreparation(entry.getValue().isLogisticsPreparation());
            ci.setI9Filled(entry.getValue().isI9Filled());
            ci.setW4Filled(entry.getValue().isW4Filled());
            ci.setVisaStatus(entry.getValue().getVisaStatus());
            if (StringUtils.isNotBlank(entry.getValue().getVendorPaymentTerm())) {
                if (ci.getNotes() != null) {
                    ci.setNotes(ci.getNotes().concat("Vendor Payment Terms:").concat(entry.getValue().getVendorPaymentTerm()).concat("\n"));
                } else {
                    ci.setNotes("Vendor Payment Terms:".concat(entry.getValue().getVendorPaymentTerm()).concat("\n"));
                }
            }
            ClientInformationDao.instance().getEntityManager().merge(ci);
        }
    }

    protected List<ClientInformationRecord> readClientInfoData() {
        List<ClientInformationRecord> records = new ArrayList<ClientInformationRecord>();
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
            ClientInformationRecord ci = new ClientInformationRecord();
            ci.setEmployeeId(getEmployeeId(getCellStringValue(record, 25), getCellStringValue(record, 26)));
            ci.setClientName(getCellStringValue(record, 36));
            ci.setVendorName(getCellStringValue(record, 35));
            String startDate = getCellStringOrNumericValue(record, 37);

            if (StringUtils.isNotBlank(startDate) && startDate.length() > 4) {
                ci.setStartDate(DateUtils.parse(startDate, "dd-MMM-yyyy"));
            }
            String endDate = getCellStringOrNumericValue(record, 38);
            if (StringUtils.isNotBlank(endDate) && endDate.length() > 4) {
                ci.setEndDate(DateUtils.parse(endDate, "dd-MMM-yyyy"));
            }
            ci.setItemNumber(convertDcimalToWhole(getCellStringOrNumericValue(record, 0)));
            String billingRate = getCellNumericValue(record, 1);
            if (billingRate != null) {
                ci.setBillingRate(new BigDecimal(getCellNumericValue(record, 1)));
            }
            ci.setBillingDuration((BillingDuration) convertEnum(BillingDuration.class, getCellStringValue(record, 5)));
            String overtimeRate = getCellNumericValue(record, 3);
            if (overtimeRate != null) {
                ci.setOvertimePayRate(new BigDecimal(getCellNumericValue(record, 3)));
            }
            ci.setOvertimeBillingDuration((BillingDuration) convertEnum(BillingDuration.class, getCellStringValue(record, 6)));
            ci.setNotes(getCellStringValue(record, 12));
            ci.setVisaStatus(getCellStringValue(record, 11));
            ci.setInvoiceDeliveryMethod((InvoiceDeliveryMethod) convertEnum(InvoiceDeliveryMethod.class, getCellStringValue(record, 8)));
            ci.setInvoiceFrequency((InvoiceFrequency) convertEnum(InvoiceFrequency.class, getCellStringValue(record, 7)));
            ci.setVendorPaymentTerm(getCellStringValue(record, 40));
            ci.setSignedCopyOfWO(convertToBoolean(getCellStringOrNumericValue(record, 39)));
            ci.setHrOrientation(convertToBoolean(getCellStringOrNumericValue(record, 28)));
            ci.setLogisticsPreparation(convertToBoolean(getCellStringOrNumericValue(record, 29)));
            ci.setI9Filled(convertToBoolean(getCellStringOrNumericValue(record, 30)));
            ci.setW4Filled(convertToBoolean(getCellStringOrNumericValue(record, 31)));
            records.add(ci);
        }
        return filterRecords(records);
    }

    protected List<ClientInformationRecord> filterRecords(List<ClientInformationRecord> records) {
        List<ClientInformationRecord> filteredResults = new ArrayList<ClientInformationRecord>();
        for (String empId : getUniqueEmployees(records)) {
            if (StringUtils.isNotEmpty(empId)) {
                List<ClientInformationRecord> matched = getMatchedRecords(empId, records);
                if (matched.size() > 1) {
                    System.out.println("dddd" + empId);
                }
                filteredResults.add(getLatestRecord(matched));
            }
        }
        return filteredResults;
    }

    protected Set<String> getUniqueEmployees(List<ClientInformationRecord> records) {
        Set<String> emps = new HashSet<String>();
        for (ClientInformationRecord record : records) {
            emps.add(record.getEmployeeId());
        }
        return emps;
    }

    protected ClientInformationRecord getLatestRecord(List<ClientInformationRecord> matches) {
        ClientInformationRecord latest = matches.get(0);
        for (ClientInformationRecord record : matches) {
            if (record.getStartDate() != null && latest.getStartDate() != null && record.getStartDate().after(latest.getStartDate())) {
                latest = record;
                System.out.println("dddddddd" + latest);
            }
        }
        return latest;
    }

    protected List<ClientInformationRecord> getMatchedRecords(String employeeId, List<ClientInformationRecord> records) {
        List<ClientInformationRecord> res = new ArrayList<ClientInformationRecord>();
        for (ClientInformationRecord record : records) {
            if (employeeId.equals(record.getEmployeeId())) {
                res.add(record);
            }
        }
        return res;
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

    protected boolean convertToBoolean(String booleanValue) {
        if (StringUtils.isNotBlank(booleanValue) && convertDcimalToWhole(booleanValue.trim()).equals("1")) {
            return true;
        }
        return false;
    }

    protected String convertDcimalToWhole(String itemNumber) {
        if (StringUtils.isNotEmpty(itemNumber) && itemNumber.contains(".")) {
            return itemNumber.substring(0, itemNumber.indexOf("."));
        } else {
            return itemNumber;
        }
    }

    protected String getEmployeeId(String firstName, String lastName) {
        if (StringUtils.isNotEmpty(firstName) && StringUtils.isNotEmpty(lastName)) {
            return firstName.toLowerCase().charAt(0) + lastName.toLowerCase();
        }
        return null;
    }

    protected String getDataFileUrl() {
        return "/Users/anuyalamanchili/Desktop/BIS_DATA.xlsx";
//        return OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "load.xlsx";
    }

    public static ClientInfoDataTool instance() {
        return (ClientInfoDataTool) SpringContext.getBean("clientInfoDataTool");
    }
}
