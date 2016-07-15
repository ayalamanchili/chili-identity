/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa.time;

import info.yalamanchili.office.qa.AbstractOfficeTest;
import static info.yalamanchili.office.qa.AbstractOfficeTest.driver;
import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.Thread.sleep;
import java.util.Date;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author joel kolli
 */
public class OutOfOffice extends AbstractOfficeTest {

    @Test(description = "OutOfOffice Section", groups = "outOfOffice", dependsOnGroups = "employeeTime", priority = 1)
    public void testViewOutOfOffice() throws IOException, InterruptedException {
        System.out.println("Enter OutOfOffice Section: " + new Date());

        driver.findElement(By.xpath("//div[4]/div/div[2]/div/table/tbody/tr/td[5]/div")).click();
        waitForLoader();
        sleep(5000);

        takeScreenshot("OutOfOffice_Section");
        System.out.println("Exit OutOfOffice Section: " + new Date());
    }

    @Test(description = "OutOfOffice Create", dataProvider = "outOfOfficeCreateData", groups = "outOfOffice", dependsOnGroups = "employeeTime", priority = 2)
    public void testCreateOutOfOffice(String[][] OutOfOfficeData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter OutOfOffice Create: " + new Date());

        for (String[] e : OutOfOfficeData) {

            driver.findElement(By.xpath("//div[4]/div/div[3]/div/div/div/div/div")).click();

            driver.findElement(By.id("gwt-debug-Employee_employee_TB")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-OutOfOffice_workType_LB")).sendKeys(e[1]);
            driver.findElement(By.id("gwt-debug-OutOfOffice_startDate_TB")).sendKeys(e[2]);
            driver.findElement(By.id("gwt-debug-OutOfOffice_endDate_TB")).sendKeys(e[3]);
            driver.findElement(By.id("gwt-debug-OutOfOffice_workForPartiatl_CB-input")).click();
            driver.findElement(By.id("gwt-debug-OutOfOffice_recurring_CB-input")).click();
            driver.findElement(By.id("gwt-debug-OutOfOffice_reason_TB")).sendKeys(e[4]);
            driver.findElement(By.id("gwt-debug-OutOfOffice_contactNo_TB")).sendKeys(e[5]);
            driver.findElement(By.id("gwt-debug-OutOfOffice_time_TB")).sendKeys(e[6]);

            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
            waitForLoader();
            sleep(5000);
        }

        takeScreenshot("OutOfOffice_Create");
        System.out.println("Exit OutOfOffice Create: " + new Date());
    }

    @Test(description = "OutOfOffice View", dataProvider = "outOfOfficeViewData", groups = "outOfOffice", dependsOnGroups = "employeeTime", priority = 3)
    public void testOutOfOfficeView(String[][] OutOfOfficeData) throws InterruptedException, IOException {
        System.out.println("Enter OutOfOffice View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[4]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : OutOfOfficeData) {
            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[1]/img")).click();
                    waitForLoader();
                    sleep(2000);
                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("OutOfOffice_View");

        driver.findElement(By.xpath("//div[4]/div/div[2]/div/table/tbody/tr/td[5]/div")).click();
        waitForLoader();
        sleep(2000);

        System.out.println("Exit OutOfOffice View: " + new Date());
    }

    //Update solution not working; keep this test disabled
    @Test(description = "OutOfOffice Update", dataProvider = "outOfOfficeUpdateData", groups = "outOfOffice", dependsOnGroups = "employeeTime", priority = 4, enabled=false)
    public void testUpdateOutOfOffice(String[][] OutOfOfficeData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter OutOfOffice Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[4]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : OutOfOfficeData) {
            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();
                    waitForLoader();
                    sleep(2000);

                    driver.findElement(By.id("gwt-debug-Employee_employee_TB")).clear();
                    driver.findElement(By.id("gwt-debug-OutOfOffice_workType_LB")).clear();
                    driver.findElement(By.id("gwt-debug-OutOfOffice_startDate_TB")).clear();
                    driver.findElement(By.id("gwt-debug-OutOfOffice_endDate_TB")).clear();
                    driver.findElement(By.id("gwt-debug-OutOfOffice_workForPartiatl_CB-input")).clear();
                    driver.findElement(By.id("gwt-debug-OutOfOffice_recurring_CB-input")).clear();
                    driver.findElement(By.id("gwt-debug-OutOfOffice_reason_TB")).clear();
                    driver.findElement(By.id("gwt-debug-OutOfOffice_contactNo_TB")).clear();
                    driver.findElement(By.id("gwt-debug-OutOfOffice_time_TB")).clear();

                    driver.findElement(By.id("gwt-debug-Employee_employee_TB")).sendKeys(e[0]);
                    driver.findElement(By.id("gwt-debug-OutOfOffice_workType_LB")).sendKeys(e[1]);
                    driver.findElement(By.id("gwt-debug-OutOfOffice_startDate_TB")).sendKeys(e[2]);
                    driver.findElement(By.id("gwt-debug-OutOfOffice_endDate_TB")).sendKeys(e[3]);
                    driver.findElement(By.id("gwt-debug-OutOfOffice_reason_TB")).sendKeys(e[4]);
                    driver.findElement(By.id("gwt-debug-OutOfOffice_contactNo_TB")).sendKeys(e[5]);
                    driver.findElement(By.id("gwt-debug-OutOfOffice_time_TB")).sendKeys(e[6]);

                    driver.findElement(By.xpath("//div[2]/button")).click();
                    waitForLoader();
                    sleep(2000);

                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("OutOfOffice_Update");
        System.out.println("Exit OutOfOffice Update: " + new Date());
    }

    @DataProvider(name = "outOfOfficeCreateData")
    private Object[][] outOfOfficeCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateOutOfOffice");
    }

    @DataProvider(name = "outOfOfficeViewData")
    private Object[][] outOfOfficeViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewOutOfOffice");
    }

    @DataProvider(name = "outOfOfficeUpdateData")
    private Object[][] outOfOfficeUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateOutOfOffice");
    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Time_OutOfOffice.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();
        String[][] OutOfOfficeData = new String[rowcount + 1][7];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);
            OutOfOfficeData[i][0] = row.getCell(0).getStringCellValue();
            OutOfOfficeData[i][1] = row.getCell(1).getStringCellValue();
            OutOfOfficeData[i][2] = row.getCell(2).getStringCellValue();
            OutOfOfficeData[i][3] = row.getCell(3).getStringCellValue();
            OutOfOfficeData[i][4] = row.getCell(4).getStringCellValue();
            OutOfOfficeData[i][5] = row.getCell(5).getStringCellValue();
            OutOfOfficeData[i][6] = row.getCell(6).getStringCellValue();

        }

        return new Object[][]{{OutOfOfficeData}};
    }
}
