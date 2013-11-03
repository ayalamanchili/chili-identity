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
import info.yalamanchili.office.dao.security.SecurityService;
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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.tool.hbm2x.StringUtils;
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
        load.syncClientInformationData();
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
                        System.out.println("similarity1" + similarity1);
                        System.out.println("similarity2" + similarity2);
                        if (similarity1 >= 0.10 || similarity2 > 1) {
                            log.info("processing associated::" + record.getClientName() + "------" + ci.getClient().getName());
                        } else {
                            log.info("no client information found::" + record.getClientName() + "------" + ci.getClient().getName());
                        }
                    }
                }
            }
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
            ClientInformationRecord ci = new ClientInformationRecord();
            ci.setEmployeeId(getEmployeeId(getCellStringValue(record, 25), getCellStringValue(record, 26)));
            ci.setClientName(getCellStringValue(record, 36));
            ci.setVendorName(getCellStringValue(record, 35));
            ci.setItemNumber(formatItemNumber(getCellStringOrNumericValue(record, 0)));
            String payRate = getCellNumericValue(record, 1);
            if (payRate != null) {
                ci.setPayRate(new BigDecimal(getCellNumericValue(record, 1)));
            }
            ci.setBillRateDuration(getCellStringValue(record, 5));
            ci.setNotes(getCellStringValue(record, 12));
            ci.setVisaStatus(getCellStringValue(record, 11));
            ci.setDeliveryMethod(getCellStringValue(record, 8));
            ci.setFrequency(getCellStringValue(record, 7));
            records.add(ci);
        }
        return records;
    }

    protected String formatItemNumber(String itemNumber) {
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
//        return OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "load.xls";
    }

    public static ClientInfoDataTool instance() {
        return (ClientInfoDataTool) SpringContext.getBean("clientInfoDataTool");
    }
}
