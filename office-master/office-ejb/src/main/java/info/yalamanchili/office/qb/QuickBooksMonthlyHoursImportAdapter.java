/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qb;

import info.yalamanchili.office.Time.TimeJobService;
import info.yalamanchili.office.adp.AdpRecord;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import info.yalamanchili.office.entity.bulkimport.BulkImportMessage;
import info.yalamanchili.office.entity.bulkimport.BulkImportMessageType;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.TimeSheetPeriod;
import info.yalamanchili.office.profile.EmployeeFinder;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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
@Component
public class QuickBooksMonthlyHoursImportAdapter {

    private final static Logger logger = Logger.getLogger(QuickBooksMonthlyHoursImportAdapter.class.getName());
    @PersistenceContext
    protected EntityManager em;
    private String description;

    public List<QuickBooksRecord> mapADPHoursRecords(BulkImport bulkImport) {
        List<QuickBooksRecord> records = new ArrayList<QuickBooksRecord>();
        HSSFWorkbook workbook;
        try {
            FileInputStream fstream = new FileInputStream(getFilePath(bulkImport));
            workbook = new HSSFWorkbook(fstream);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String timesheetline;
            //Read File Line By Line
            while ((timesheetline = br.readLine()) != null) {
                if (timesheetline.contains("Total")) {
                    String lastName = null;
                    String firstName = null;
                    BigDecimal hours = null;
                    //LastName
                    int lastNameStartIndex = timesheetline.indexOf("-") + 1;
                    int lastNameEndIndex = timesheetline.indexOf(" ", lastNameStartIndex);
                    if (lastNameStartIndex < timesheetline.length() && lastNameEndIndex < timesheetline.length()) {
                        lastName = timesheetline.substring(lastNameStartIndex, lastNameEndIndex);
                    }
                    //first name
                    int firstNameStartIndex = lastNameEndIndex + 1;
                    int firstNameEndIndex = timesheetline.indexOf(",", firstNameStartIndex) - 1;
                    if (firstNameStartIndex < timesheetline.length() && firstNameEndIndex < timesheetline.length()) {
                        firstName = timesheetline.substring(firstNameStartIndex, firstNameEndIndex);
                    }
                    //hours
                    int hoursStartIndex = timesheetline.lastIndexOf(",") + 2;
                    if (hoursStartIndex < timesheetline.length()) {
                        String hoursString = timesheetline.substring(hoursStartIndex, timesheetline.length() - 1);
                        hours = new BigDecimal(hoursString.replace(":", "."));
                    }
                    System.out.println("lastname:" + lastName);
                    System.out.println("firstname:" + firstName);
                    System.out.println("hours:" + hours);
                }
            }
            //TODO add logic similar to ADP mapper     
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row record = rowIterator.next();
                if (record.getCell(0) != null && !record.getCell(0).toString().trim().isEmpty()) {
                    QuickBooksRecord adpRecord = new QuickBooksRecord();
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
            in.close();
        } catch (Exception e) {//Catch exception if any
            throw new RuntimeException(e);
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
            int monthStart = url.indexOf("QB_") + 3;
            int yearStart = monthStart + 3;
            Integer month = new Integer(url.substring(monthStart, monthStart + 2));
            Integer year = new Integer(url.substring(yearStart, yearStart + 4));
            return TimeJobService.instance().getTimePeriod(year, month - 1);
        } catch (Exception e) {
            BulkImportMessage msg = new BulkImportMessage();
            msg.setCode("invalid.timeperiod");
            msg.setDescription("Invalid Date format for the uploaded file eg:QB_01_2013.xls for jan 2013");
            bulkImport.addMessage(msg);
            return null;
        }
    }

    protected String getFilePath(BulkImport bulkImport) {
        String fileUrl = OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + bulkImport.getFileUrl();
        return fileUrl.replace("entityId", bulkImport.getId().toString());
    }
}