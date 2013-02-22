/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.adp;

import info.yalamanchili.office.dao.security.SecurityService;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author ayalamanchili
 */
public class ADPMonthlyHoursImportAdapter {

    public static void main(String... str) throws Exception {
        ADPMonthlyHoursImportAdapter adapter = new ADPMonthlyHoursImportAdapter();
        System.out.println(adapter.mapADPHoursRecords());
    }

    public List<AdpHoursRecord> mapADPHoursRecords() throws Exception {
        List<AdpHoursRecord> records = new ArrayList<AdpHoursRecord>();
        InputStream inp = new FileInputStream(getFilePath());
        HSSFWorkbook workbook = new HSSFWorkbook(inp);
        HSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row record = rowIterator.next();
            if (record.getCell(0) != null && !record.getCell(0).toString().trim().isEmpty()) {
                AdpHoursRecord adpRecord = new AdpHoursRecord();
                String lastName = record.getCell(0).toString();
                String firstName = record.getCell(1).toString();
                Double hoursValue = null;
                Cell hoursCell = record.getCell(2);
                if (hoursCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                    hoursValue = record.getCell(2).getNumericCellValue();
                    if (hoursValue != null) {
                        adpRecord.setHours(new BigDecimal(hoursValue));
                    }
                }
                adpRecord.setEmployeeId(findEmployeeId(firstName, lastName));

                records.add(adpRecord);
            }
        }
        return records;
    }
//TODO  implement this method to validate if the empid from the import exists and matches else return null

    protected String findEmployeeId(String firstName, String lastName) {
        String empId = null;
        if (firstName == null || lastName == null || firstName.isEmpty() || lastName.isEmpty()) {
            return empId;
        }
        StringBuilder empIdBuilder = new StringBuilder();
        empIdBuilder.append(firstName.substring(0, 1));
        empIdBuilder.append(lastName);
        if (SecurityService.instance().isValidEmployeeId(empIdBuilder.toString())) {
            empId = empIdBuilder.toString();
        } else {
            //TODO do some advanced look up to find the employee
        }
        return empId;
    }

    protected String getFilePath() {
        return "c://ADP_01_2013.xls";
    }
}
