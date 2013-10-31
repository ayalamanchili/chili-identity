/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.toolbox;

import static info.yalamanchili.office.toolbox.ExcelUtils.getCellStringValue;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ayalamanchili
 */
public class ClientInfoDataTool {

    public static void main(String... args) {
        ClientInfoDataTool load = new ClientInfoDataTool();
        load.loadClientInfoFromExcel();
    }

    protected void loadClientInfoFromExcel() {
        InputStream inp;
        XSSFWorkbook workbook;
        try {
            inp = new FileInputStream(getDataFileUrl());
            workbook = new XSSFWorkbook(inp);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row record = rowIterator.next();
            System.out.println("Item number" + getCellStringValue(record, 0));
        }
    }

    protected String getDataFileUrl() {
        return "E:\\BIS_DATA.xlsx";
//        return OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "load.xls";
    }
}
