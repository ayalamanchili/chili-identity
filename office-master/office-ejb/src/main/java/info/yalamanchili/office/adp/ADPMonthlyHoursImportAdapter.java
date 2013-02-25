/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.adp;

import info.yalamanchili.office.Time.TimeJobService;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import info.yalamanchili.office.entity.bulkimport.BulkImportMessage;
import info.yalamanchili.office.entity.bulkimport.BulkImportMessageType;
import info.yalamanchili.office.entity.time.TimeSheetPeriod;
import info.yalamanchili.office.profile.EmployeeFinder;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component("adpMonthlyHoursImportAdapter")
public class ADPMonthlyHoursImportAdapter {

    private final static Logger logger = Logger.getLogger(ADPMonthlyHoursImportAdapter.class.getName());

    public List<AdpRecord> mapADPHoursRecords(BulkImport bulkImport) {
        List<AdpRecord> records = new ArrayList<AdpRecord>();
        InputStream inp;
        HSSFWorkbook workbook;
        try {
            inp = new FileInputStream(getFilePath(bulkImport));
            workbook = new HSSFWorkbook(inp);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        HSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row record = rowIterator.next();
            if (record.getCell(0) != null && !record.getCell(0).toString().trim().isEmpty()) {
                AdpRecord adpRecord = new AdpRecord();
                String lastName = record.getCell(0).toString();
                String firstName = record.getCell(1).toString();
                if (EmployeeFinder.instance().find(firstName, lastName) != null) {
                    adpRecord.setEmployee(EmployeeFinder.instance().find(firstName, lastName));
                    Double hoursValue = null;
                    Cell hoursCell = record.getCell(2);
                    if (hoursCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                        hoursValue = record.getCell(2).getNumericCellValue();
                        if (hoursValue != null) {
                            adpRecord.setHours(new BigDecimal(hoursValue));
                        }
                    }
                    records.add(adpRecord);
                } else {
                    if (!firstName.isEmpty() && !lastName.isEmpty()) {
                        BulkImportMessage msg = new BulkImportMessage();
                        msg.setCode("emp.not.found");
                        msg.setDescription("Employee not found for " + firstName + ":lastname:" + lastName);
                        msg.setMessageType(BulkImportMessageType.WARN);
                        bulkImport.addMessage(msg);
                        logger.log(Level.INFO, "adp--- employee not found last:{0} first:{1}", new Object[]{lastName, firstName});
                    }
                }
            }
        }
        return records;
    }

    protected TimeSheetPeriod getImportMonth(BulkImport bulkImport) {
        //TODO get the date from the file name (eg: ADP_01_2013.xls) implies jan 2013
        String url = bulkImport.getFileUrl();
        String[] result = url.split("-");
        int Month = 0;
        int Year = 0;
        if (result.length == 3)
        {
            Month = Integer.parseInt(result[1]);
            Month = Month - 1; // for java api
            Year = Integer.parseInt(result[2]);
        }
        return TimeJobService.instance().getTimePeriod(Month , Year);
    }

    protected String getFilePath(BulkImport bulkImport) {
        String fileUrl = OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + bulkImport.getFileUrl();
        return fileUrl.replace("entityId", bulkImport.getId().toString());
//        return "c://ADP_01_2013.xls";
    }
}
