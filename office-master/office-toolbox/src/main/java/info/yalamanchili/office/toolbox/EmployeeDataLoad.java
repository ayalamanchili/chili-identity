/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.toolbox;

import info.yalamanchili.office.config.OfficeServiceConfiguration;
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
        System.out.println("dd" + load.load());
    }

    public List<ADPEmployeeRecord> load() {
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
            adpEmpRecord.setSsn(getCellStringValue(record, 5));
            adpEmpRecords.add(adpEmpRecord);
        }
        return adpEmpRecords;
    }

    protected String getCellStringValue(Row record, int column) {
        if (record.getCell(column) != null && record.getCell(column).getCellType() == HSSFCell.CELL_TYPE_STRING && !record.getCell(column).getStringCellValue().isEmpty()) {
            return record.getCell(column).getStringCellValue();
        } else {
            return null;
        }
    }

    protected String getDataFileUrl() {
        return "C:\\Users\\ayalamanchili\\Desktop\\load.xls";
        //return OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "load.xls";
    }
}
