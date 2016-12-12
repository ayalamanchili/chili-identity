/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.adp;

import info.yalamanchili.office.Time.TimeJobService;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.time.TimeSheetPeriodDao;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import info.yalamanchili.office.entity.bulkimport.BulkImportMessage;
import info.yalamanchili.office.entity.bulkimport.BulkImportMessageType;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.TimeSheetPeriod;
import info.yalamanchili.office.profile.EmployeeFinder;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    @PersistenceContext
    protected EntityManager em;

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
                Employee emp = EmployeeFinder.instance().find(firstName, lastName);
                if (emp != null) {
                    adpRecord.setEmployee(emp);
                    Double hoursValue = null;
                    Cell hoursCell = record.getCell(2);
                    if (hoursCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                        hoursValue = record.getCell(2).getNumericCellValue();
                        if (hoursValue != null) {
                            adpRecord.setHours(new BigDecimal(hoursValue));
                            records.add(adpRecord);
                            String description = "employee:" + emp.getEmployeeId() + ":hours:" + "" + adpRecord.getHours();
                            createBulkImportMessage(bulkImport, "employee.timesheet.record.found", description, BulkImportMessageType.INFO);

                        }
                    }
                } else {
                    if (!firstName.isEmpty() && !lastName.isEmpty()) {
                        String description = "Employee not found for " + firstName + ":lastname:" + lastName;
                        createBulkImportMessage(bulkImport, "emp.not.found", description, BulkImportMessageType.WARN);
                        logger.log(Level.INFO, "adp--- employee not found last:{0} first:{1}", new Object[]{lastName, firstName});
                    }
                }
            }
        }
        return records;
    }

    protected void createBulkImportMessage(BulkImport bulkImport, String code, String description, BulkImportMessageType type) {
        BulkImportMessage msg = new BulkImportMessage();
        msg.setCode(code);
        msg.setDescription(description);
        msg.setMessageType(type);
        bulkImport.addMessage(msg);
    }

    protected TimeSheetPeriod getImportMonth(BulkImport bulkImport) {
        try {
            String url = bulkImport.getFileUrl();
            int monthStart = url.indexOf("ADP_") + 4;
            int yearStart = monthStart + 3;
            Integer month = new Integer(url.substring(monthStart, monthStart + 2));
            Integer year = new Integer(url.substring(yearStart, yearStart + 4));
            return TimeSheetPeriodDao.instance().getTimePeriod(year, month - 1);
        } catch (Exception e) {
            BulkImportMessage msg = new BulkImportMessage();
            msg.setCode("invalid.timeperiod");
            msg.setDescription("Invalid Date format for the uploaded file eg:ADP_01_2013.xls for jan 2013");
            bulkImport.addMessage(msg);
            return null;
        }
    }

    protected String getFilePath(BulkImport bulkImport) {
        String fileUrl = OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + bulkImport.getFileUrl();
        return fileUrl.replace("entityId", bulkImport.getId().toString());
    }
}
