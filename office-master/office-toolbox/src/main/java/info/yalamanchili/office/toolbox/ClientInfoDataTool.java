/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.toolbox;

import static info.yalamanchili.office.toolbox.ExcelUtils.getCellStringOrNumericValue;
import static info.yalamanchili.office.toolbox.ExcelUtils.getCellStringValue;
import info.yalamanchili.office.toolbox.types.ClientInformationRecord;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.tool.hbm2x.StringUtils;

/**
 *
 * @author ayalamanchili
 */
public class ClientInfoDataTool {

    public static void main(String... args) {
        ClientInfoDataTool load = new ClientInfoDataTool();
        System.out.println(load.loadClientInfoFromExcel());
    }

    protected List<ClientInformationRecord> loadClientInfoFromExcel() {
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
            System.out.println(formatItemNumber(getCellStringOrNumericValue(record, 0)));
//            ci.setPayRate(new BigDecimal(getCellNumericValue(record, 1)));
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
        return "E:\\BIS_DATA.xlsx";
//        return OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "load.xls";
    }
}
