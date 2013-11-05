/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.toolbox;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.client.InvoiceDeliveryMethod;
import info.yalamanchili.office.entity.client.InvoiceFrequency;
import info.yalamanchili.office.entity.profile.BillingDuration;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Employee;
import static info.yalamanchili.office.toolbox.ExcelUtils.getCellNumericValue;
import static info.yalamanchili.office.toolbox.ExcelUtils.getCellStringOrNumericValue;
import static info.yalamanchili.office.toolbox.ExcelUtils.getCellStringValue;
import info.yalamanchili.office.toolbox.types.ClientInformationRecord;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
        for (ClientInformationRecord record : readClientInfoData()) {
            if (StringUtils.isNotEmpty(record.getEmployeeId())) {
                Employee emp = SecurityService.instance().findEmployee(record.getEmployeeId());
                if (emp != null) {
                    log.info("processing employee:" + emp.getFirstName());
                    for (ClientInformation ci : emp.getClientInformations()) {
                        double similarity1 = info.chili.commons.StringUtils.jaccardSimilarity(ci.getClient().getName(), record.getClientName().trim());
                        int similarity2 = info.chili.commons.StringUtils.stringSimilarity(ci.getClient().getName(), record.getClientName().trim());
                        if (similarity1 >= 0.10 || similarity2 > 1) {
                            log.info("processing associated::" + record.getClientName() + "------" + ci.getClient().getName());
                            mapAndSaveClientInformationValues(ci, record);
                        } else {
                            log.info("no client information found::" + record.getClientName() + "------" + ci.getClient().getName());
                        }
                    }
                }
            }
        }
    }

    protected void mapAndSaveClientInformationValues(ClientInformation ci, ClientInformationRecord record) {
        ci.setItemNumber(record.getItemNumber());
        ci.setBillingRate(record.getBillingRate());
        ci.setBillingRateDuration(record.getBillingDuration());
        ci.setInvoiceDeliveryMethod(record.getInvoiceDeliveryMethod());
        ci.setInvoiceFrequency(record.getInvoiceFrequency());
        ci.setOverTimeBillingRate(record.getOvertimePayRate());
        ci.setOverTimeRateDuration(record.getOvertimeBillingDuration());
        ci.setNotes(record.getNotes());
        ci.setHrOrientation(record.isHrOrientation());
        ci.setLogisticsPreparation(record.isLogisticsPreparation());
        ci.setI9Filled(record.isI9Filled());
        ci.setW4Filled(record.isW4Filled());
        ci.setVisaStatus(record.getVisaStatus());
        if (ci.getNotes() != null) {
            ci.setNotes(ci.getNotes().concat("Vendor Payment Terms:").concat(record.getVendorPaymentTerm()).concat("\n"));
        } else {
            ci.setNotes("Vendor Payment Terms:".concat(record.getVendorPaymentTerm()).concat("\n"));
        }
        ClientInformationDao.instance().getEntityManager().merge(ci);
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
            ClientInformationRecord ci = new ClientInformationRecord();
            ci.setEmployeeId(getEmployeeId(getCellStringValue(record, 25), getCellStringValue(record, 26)));
            ci.setClientName(getCellStringValue(record, 36));
            ci.setVendorName(getCellStringValue(record, 35));
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
            ci.setHrOrientation(convertToBoolean(getCellStringOrNumericValue(record, 28)));
            ci.setLogisticsPreparation(convertToBoolean(getCellStringOrNumericValue(record, 29)));
            ci.setI9Filled(convertToBoolean(getCellStringOrNumericValue(record, 30)));
            ci.setW4Filled(convertToBoolean(getCellStringOrNumericValue(record, 31)));
            records.add(ci);
        }
        return records;
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
        return "C:\\Users\\ayalamanchili\\Desktop\\BIS_DATA.xlsx";
//        return OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "load.xls";
    }

    public static ClientInfoDataTool instance() {
        return (ClientInfoDataTool) SpringContext.getBean("clientInfoDataTool");
    }
}
