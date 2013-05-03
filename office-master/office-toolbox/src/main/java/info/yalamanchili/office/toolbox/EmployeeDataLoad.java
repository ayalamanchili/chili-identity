/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.toolbox;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.security.SecurityService;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Component
@Transactional
public class EmployeeDataLoad {

    public static void main(String... args) {
        EmployeeDataLoad load = new EmployeeDataLoad();
        System.out.println(load.loadADPRecords());
    }

    public void syncEmployeeAddresses() {
        for (ADPEmployeeRecord record : loadADPRecords()) {
            if (record.getSsn() != null) {
                System.out.println(SecurityService.instance().findEmployeeBySSN(record.getSsn()));
            }
        }
    }

    public List<ADPEmployeeRecord> loadADPRecords() {
        List<ADPEmployeeRecord> adpEmpRecords = new ArrayList<ADPEmployeeRecord>();
        InputStream inp;
        HSSFWorkbook workbook;
        try {
            inp = new FileInputStream(getDataFileUrl());
            workbook = new HSSFWorkbook(inp);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        HSSFSheet sheet = workbook.getSheetAt(1);
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row record = rowIterator.next();
            ADPEmployeeRecord adpEmpRecord = new ADPEmployeeRecord();

            adpEmpRecord.setSsn(removeDashes(getCellStringValue(record, 6)));
            adpEmpRecord.setFirstName((getCellStringValue(record, 10)));
            adpEmpRecord.setLastName((getCellStringValue(record, 12)));
            adpEmpRecord.setEmail((getCellStringValue(record, 28)));
            adpEmpRecord.setCellPhone(removeDashes((getCellStringValue(record, 4))));
            adpEmpRecord.setHomePhone(removeDashes((getCellStringValue(record, 14))));
            adpEmpRecord.setStatus(getCellStringValue(record, 8));
            adpEmpRecord.setDob(getCellNumericValue(record, 16));
            adpEmpRecord.setStreet1(getCellStringValue(record, 18));
            adpEmpRecord.setStreet2(getCellStringValue(record, 20));
            adpEmpRecord.setCity(getCellStringValue(record, 22));
            adpEmpRecord.setState(getCellStringValue(record, 24));
            adpEmpRecord.setZip(getCellStringValue(record, 26));
            adpEmpRecords.add(adpEmpRecord);
        }
        return adpEmpRecords;
    }

    protected String getCellStringValue(Row record, int column) {
        if (column == 16) {
            System.out.println(record.getCell(column).getCellType());
        }
        if (record.getCell(column) != null && record.getCell(column).getCellType() == HSSFCell.CELL_TYPE_STRING && !record.getCell(column).getStringCellValue().isEmpty()) {
            return record.getCell(column).getStringCellValue();
        } else {
            return null;
        }
    }

    protected String getCellNumericValue(Row record, int column) {
        if (record.getCell(column) != null && record.getCell(column).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
            return record.getCell(column).toString();
        } else {
            return null;
        }
    }

    protected String removeDashes(String str) {
        if (str != null) {
            return str.replace("-", "");
        } else {
            return null;
        }
    }

    protected String getDataFileUrl() {
        return "C:\\Users\\ayalamanchili\\Desktop\\load.xls";
        //return OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "load.xls";
    }

    public static EmployeeDataLoad instance() {
        return SpringContext.getBean(EmployeeDataLoad.class);
    }
}
