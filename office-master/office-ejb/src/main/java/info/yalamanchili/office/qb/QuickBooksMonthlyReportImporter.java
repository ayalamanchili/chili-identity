/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qb;

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
 *
 * @author ayalamanchili
 */
public class QuickBooksMonthlyReportImporter {
//sample http://viralpatel.net/blogs/java-read-write-excel-file-apache-poi/

    public static void main(String... str) throws Exception {
        importEmployeeHoursData();
    }

    protected static List<QuickBooksRecord> importEmployeeHoursData() throws Exception {
        List<QuickBooksRecord> records = new ArrayList<QuickBooksRecord>();
        InputStream inp = new FileInputStream(getFilePath());
        HSSFWorkbook workbook = new HSSFWorkbook(inp);
        HSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row record = rowIterator.next();
            if (record.getCell(1) != null && record.getCell(1).toString().contains("Total")) {
                QuickBooksRecord qbRecord = new QuickBooksRecord();
                qbRecord.setEmployeeId(record.getCell(1).getStringCellValue());
                System.out.println("name----" + record.getCell(1).getStringCellValue());
                qbRecord.setHours(new BigDecimal(record.getCell(3).getNumericCellValue()));
                System.out.println("hours----" + record.getCell(3).getNumericCellValue());
                records.add(qbRecord);
            }

        }
        return records;
    }

    protected static String getFilePath() {
        return "c://QB_01_2013.xls";
    }
}
