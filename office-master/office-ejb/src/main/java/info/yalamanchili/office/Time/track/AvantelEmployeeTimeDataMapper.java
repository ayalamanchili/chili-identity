/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time.track;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import info.yalamanchili.office.entity.time.TimeEntry;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class AvantelEmployeeTimeDataMapper {

    public List<TimeEntry> mapAvantelTimeRecords(BulkImport bulkImport) {
        List<TimeEntry> res = new ArrayList<>();
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
            if (record.getRowNum() < 4) {
                continue;
            }
            TimeEntry timeEntry = new TimeEntry();
            timeEntry.setEmployeeId(Integer.toString(new Double(record.getCell(1).getNumericCellValue()).intValue()));
            timeEntry.setEntryDate(record.getCell(2).getDateCellValue());
            timeEntry.setEntryTimeStamp(record.getCell(3).getDateCellValue());
            timeEntry.setLocation(record.getCell(4).getStringCellValue());
            res.add(timeEntry);
        }
        return res;
    }

    @Autowired
    protected OfficeServiceConfiguration officeServiceConfiguration;

    public String getFilePath(BulkImport bulkImport) {
        String fileUrl = officeServiceConfiguration.getContentManagementLocationRoot() + bulkImport.getFileUrl();
        return fileUrl.replace("entityId", bulkImport.getId().toString());
    }

    public static AvantelEmployeeTimeDataMapper instance() {
        return SpringContext.getBean(AvantelEmployeeTimeDataMapper.class);
    }
}
