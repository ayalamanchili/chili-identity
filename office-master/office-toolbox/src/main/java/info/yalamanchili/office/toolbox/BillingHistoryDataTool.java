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
import static info.chili.docs.ExcelUtils.getCellStringValue;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.BillingRateDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.entity.client.InvoiceFrequency;
import info.yalamanchili.office.entity.profile.BillingRate;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.toolbox.types.BillingRecord;
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
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Madhu.Badiginchala
 */
@Component("billingHistoryDataTool")
@Transactional
public class BillingHistoryDataTool {

    private static final Log log = LogFactory.getLog(BillingHistoryDataTool.class);

    public static void main(String... args) {
        BillingHistoryDataTool tool = new BillingHistoryDataTool();
        tool.migrateBillingHistoryData();
    }

    public void migrateBillingHistoryData() {
        InputStream inp;
        int i = 0;
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
            BillingRecord br = new BillingRecord();
            BillingRate billingRate = new BillingRate();
            ClientInformation clientInfo = new ClientInformation();
            String ClientInfoId = getCellNumericValue(record, 3);
            if (ClientInfoId != null) {
                br.setClientInfoId(new Long(convertDcimalToWhole(getCellNumericValue(record, 3))));
                clientInfo = ClientInformationDao.instance().findById(br.getClientInfoId());
            } else {
                continue;
            }
            System.out.println("BillingHistory : ClientID >>>>>>>>>>>>>>>><<<<<<<<<<<<<<: " + ClientInfoId);
            br.setEffectiveDate(convertToDate(getCellNumericValue(record, 13)));
            if (br.getEffectiveDate() != null) {
                billingRate.setEffectiveDate(br.getEffectiveDate());
            } else {
                continue;
            }
            String PayRate = getCellNumericValue(record, 4);
            if (PayRate != null) {
                br.setPayRate(new BigDecimal(getCellNumericValue(record, 4)));
                billingRate.setBillingRate(br.getPayRate());
            }
            String OverTimePayrate = getCellNumericValue(record, 6);
            if (OverTimePayrate != null) {
                br.setOverTimePayrate(new BigDecimal(getCellNumericValue(record, 6)));
                billingRate.setOverTimeBillingRate(br.getOverTimePayrate());
            }
            String SubContractorPayRate = getCellNumericValue(record, 9);
            if (SubContractorPayRate != null) {
                br.setSubContractorPayRate(new BigDecimal(getCellNumericValue(record, 9)));
                billingRate.setSubContractorPayRate(br.getSubContractorPayRate());
            }
            String SubContractorOverTimePayRate = getCellNumericValue(record, 10);
            if (SubContractorOverTimePayRate != null) {
                br.setSubContractorOverTimePayRate(new BigDecimal(getCellNumericValue(record, 10)));
                billingRate.setSubContractorOverTimePayRate(br.getSubContractorOverTimePayRate());
            }
            br.setSubContractorInvoiceFrequency((InvoiceFrequency) convertEnum(InvoiceFrequency.class, getCellStringValue(record, 12)));
            if (br.getSubContractorInvoiceFrequency() != null) {
                billingRate.setSubContractorInvoiceFrequency(br.getSubContractorInvoiceFrequency());
            }
            br.setBillingInvoiceFrequency((InvoiceFrequency) convertEnum(InvoiceFrequency.class, getCellStringValue(record, 8)));
            if (br.getBillingInvoiceFrequency() != null) {
                billingRate.setBillingInvoiceFrequency(br.getBillingInvoiceFrequency());
            }
            br.setUpdatedTs(convertToDate(getCellNumericValue(record, 15)));
            billingRate.setUpdatedTs(br.getUpdatedTs());
            br.setUpdatedBy(getCellStringValue(record, 14));
            billingRate.setUpdatedBy(br.getUpdatedBy());
            billingRate.setClientInformation(clientInfo);
            BillingRateDao.instance().getEntityManager().merge(billingRate);
        }
    }

    protected String getDataFileUrl() {
        return OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "BIS_Billinghistory.xlsx";
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

    public static BillingHistoryDataTool instance() {
        return SpringContext.getBean(BillingHistoryDataTool.class);
    }

}
