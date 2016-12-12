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
public class Summary extends AbstractOfficeTest {

    @Test(description = "Summary Section", groups = "summary", dependsOnGroups = "travelAuthorization", priority = 1)
    public void testViewSummary() throws IOException, InterruptedException {
        System.out.println("Enter Summary Section: " + new Date());

        driver.findElement(By.xpath("//div/div/div[2]/div/div[3]/div/div")).click();
        waitForLoader();
        
        driver.findElement(By.xpath("//div[4]/div/div[2]/div/table/tbody/tr/td[1]/div")).click();
        waitForLoader();
        sleep(2000);

        takeScreenshot("Summary_Section");
        System.out.println("Exit Summary Section: " + new Date());
    }

    @Test(description = "Summary Update", dataProvider = "summaryUpdateData", groups = "summary", dependsOnGroups = "travelAuthorization", priority = 2)
    public void testSummaryUpdate(String[][] SummaryData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter Summary Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[4]/div/div[4]/div/div/div/div[2]/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : SummaryData) {
            int i = 2;
            int j = 3;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[1])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();
                    waitForLoader();
                    sleep(2000);

                    driver.findElement(By.id("gwt-debug-PTOAccruedHoursAdjustment_adjustmentHours_TB")).sendKeys(e[2]);
                    driver.findElement(By.id("gwt-debug-PTOAccruedHoursAdjustment_adjustmentReason_TB")).sendKeys(e[3]);

                    driver.findElement(By.xpath("html/body/div[4]/div/div/fieldset/div/button")).click();
                    waitForLoader();
                    sleep(2000);

                    /* Adding the below code as update not taking 
                     the control back to summary page
                     */
                    driver.findElement(By.xpath("//div[4]/div/div[2]/div/table/tbody/tr/td[1]/div")).click();
                    waitForLoader();
                    sleep(2000);

                    j = 3;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("Summary_Update");
        System.out.println("Exit Summary Update: " + new Date());
    }

    @Test(description = "Summary View", dataProvider = "summaryViewData", groups = "summary", dependsOnGroups = "travelAuthorization", priority = 3)
    public void testSummaryView(String[][] SummaryData) throws InterruptedException, IOException {
        System.out.println("Enter Summary  View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[4]/div/div[4]/div/div/div/div[2]/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : SummaryData) {
            int i = 2;
            int j = 3;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[1])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[1]/img")).click();
                    waitForLoader();
                    sleep(2000);

                    driver.findElement(By.xpath("//div[9]/fieldset/div/button")).click();
                    driver.findElement(By.id("gwt-debug-Comment_comment_TB")).sendKeys(e[3]);

                    driver.findElement(By.xpath("//div[2]/button")).click();
                    waitForLoader();
                    sleep(2000);

                    j = 3;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("Summary_View");

        driver.findElement(By.xpath("//div[4]/div/div[2]/div/table/tbody/tr/td[1]/div")).click();
        waitForLoader();
        sleep(2000);

        System.out.println("Exit Summary  View: " + new Date());
    }

    @DataProvider(name = "summaryViewData")
    private Object[][] summaryViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewSummary");
    }

    @DataProvider(name = "summaryUpdateData")
    private Object[][] summaryUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateSummary");
    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Time_Summary.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();
        String[][] SummaryData = new String[rowcount + 1][4];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);
            SummaryData[i][0] = row.getCell(0).getStringCellValue();
            SummaryData[i][1] = row.getCell(1).getStringCellValue();
            SummaryData[i][2] = row.getCell(2).getStringCellValue();
            SummaryData[i][3] = row.getCell(3).getStringCellValue();

        }

        return new Object[][]{{SummaryData}};
    }
}
