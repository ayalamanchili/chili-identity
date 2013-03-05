/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qb;

import info.yalamanchili.office.Time.TimeJobService;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import info.yalamanchili.office.entity.bulkimport.BulkImportMessage;
import info.yalamanchili.office.entity.bulkimport.BulkImportMessageType;
import info.yalamanchili.office.entity.time.TimeSheetPeriod;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    public static void main(String... strs) {
        QuickBooksMonthlyHoursImportAdapter ser = new QuickBooksMonthlyHoursImportAdapter();
        ser.mapADPHoursRecords(new BulkImport());
    }

    public List<QuickBooksRecord> mapADPHoursRecords(BulkImport bulkImport) {
        List<QuickBooksRecord> records = new ArrayList<QuickBooksRecord>();
        try {
            FileInputStream fstream = new FileInputStream(getFilePath(bulkImport));
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                System.out.println(strLine);
                if (strLine.contains("Total")) {
                }
                //TODO add logic similar to ADP mapper
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
            int monthStart = url.indexOf("QB_") + 4;
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
//        String fileUrl = OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + bulkImport.getFileUrl();
//        return fileUrl.replace("entityId", bulkImport.getId().toString());
        return "c://QB_01_2013.csv";
    }
}