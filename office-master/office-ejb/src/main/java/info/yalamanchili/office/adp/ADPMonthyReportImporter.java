/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.adp;

import info.yalamanchili.office.qb.QuickBooksRecord;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * This class is responsible for reading the export file and converting it
 *
 * @author ayalamanchili
 */
public class ADPMonthyReportImporter {
    
    String path = "";
    
    public static void main(String... str) throws Exception {
        importEmployeeHoursData();
    }
    
    protected static List<AdpHoursRecords> importEmployeeHoursData() throws Exception {
        List<AdpHoursRecords> records = new ArrayList<AdpHoursRecords>();
        InputStream inp = new FileInputStream(getFilePath());
        HSSFWorkbook workbook = new HSSFWorkbook(inp);
        HSSFSheet sheet = workbook.getSheetAt(0);
        for (Row record : sheet) {
            for (Cell cell : record) {
                // Do something here
                if (cell != null) {
                    AdpHoursRecords qbRecord = new AdpHoursRecords();
                    String empid = "";
                    empid = record.getCell(1).getStringCellValue().substring(0, 1) + record.getCell(2).getStringCellValue();
                    qbRecord.setEmployeeId(empid);
                    System.out.println("name----" + empid);
                    qbRecord.setHours(new BigDecimal(record.getCell(4).getNumericCellValue()));
                    System.out.println("hours----" + record.getCell(4).getNumericCellValue());
                    records.add(qbRecord);
                }
            }
        }
        return records;
    }
    
    protected static String getFilePath() {
        return "c://Jan2013_Hrs_Ran.xls";
    }
}
