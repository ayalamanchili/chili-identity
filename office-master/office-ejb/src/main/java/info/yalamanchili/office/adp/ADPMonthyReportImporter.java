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
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row record = rowIterator.next();
            if (record.getCell(1) != null && record.getCell(1).toString().contains("Total")) {
                AdpHoursRecords qbRecord = new AdpHoursRecords();
                String empid = "";
                empid = record.getCell(1).getStringCellValue().substring(0, 1) + record.getCell(2).getStringCellValue();
                qbRecord.setEmployeeId(empid);
                System.out.println("name----" + empid);
                records.add(qbRecord);
            }
        }
        return records;
    }

    protected static String getFilePath() {
        return "c://Jan2013_Hrs_Ran.xls";
    }
}
