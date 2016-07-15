/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa.home;

import info.yalamanchili.office.qa.AbstractOfficeTest;
import static info.yalamanchili.office.qa.AbstractOfficeTest.driver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Sadipan.B
 */
public class MyReports extends AbstractOfficeTest {

    @Test(description = "testCreateStatustreport", dataProvider = "StatusReportCreateData", groups = "myReports", dependsOnGroups = "outOfOffice", priority = 1)
    public void testCreateStatusReport(String[][] StatusReportData) throws InterruptedException, IOException {

        System.out.println("Enter Create Status Report: " + new Date());

        driver.findElement(By.cssSelector("div.gwt-TabLayoutPanelTabInner > div.gwt-Label")).click();
        waitForLoader();
        Thread.sleep(2000);
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[2]/div/div[3]/div/div[1]/div/table/tbody/tr[5]/td/div")).click();
        waitForLoader();

        driver.findElement(By.id("gwt-debug-Status ReportsCL")).click();
        waitForLoader();
        driver.findElement(By.xpath("html/body/div[4]/div/div/fieldset/div/span/input")).click();

        for (String[] e : StatusReportData) {

            driver.findElement(By.xpath("//div[4]/div/div/div/div/fieldset/div/button")).click();
            waitForLoader();

            driver.findElement(By.id("gwt-debug-StatusReport_projectDescription_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_reportStartDate_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_reportEndDate_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1Name_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1Deliverable_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1EndDate_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1Status_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2Name_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2Deliverable_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2EndDate_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2Status_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3Name_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3Deliverable_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3EndDate_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3Status_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4Name_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4Deliverable_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4EndDate_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4Status_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_statusDescription_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_accomplishments_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_scheduledActivities_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_preparedBy_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_approvedBy_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_submittedDate_TB")).clear();

            driver.findElement(By.id("gwt-debug-StatusReport_projectDescription_TB")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-StatusReport_reportStartDate_TB")).sendKeys(e[1]);
            driver.findElement(By.id("gwt-debug-StatusReport_reportEndDate_TB")).sendKeys(e[2]);
            WebElement element = driver.findElement(By.id("gwt-debug-StatusReport_status_LB"));
            Select status = new Select(element);
            status.selectByVisibleText(e[3]);

            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1Name_TB")).sendKeys(e[4]);
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1Deliverable_TB")).sendKeys(e[5]);
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1EndDate_TB")).sendKeys(e[6]);
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1Status_TB")).sendKeys(e[7]);

            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2Name_TB")).sendKeys(e[8]);
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2Deliverable_TB")).sendKeys(e[9]);
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2EndDate_TB")).sendKeys(e[10]);
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2Status_TB")).sendKeys(e[11]);

            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3Name_TB")).sendKeys(e[12]);
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3Deliverable_TB")).sendKeys(e[13]);
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3EndDate_TB")).sendKeys(e[14]);
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3Status_TB")).sendKeys(e[15]);

            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4Name_TB")).sendKeys(e[16]);
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4Deliverable_TB")).sendKeys(e[17]);
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4EndDate_TB")).sendKeys(e[18]);
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4Status_TB")).sendKeys(e[19]);

            driver.findElement(By.id("gwt-debug-StatusReport_statusDescription_TB")).sendKeys(e[20]);
            driver.findElement(By.id("gwt-debug-StatusReport_accomplishments_TB")).sendKeys(e[21]);
            driver.findElement(By.id("gwt-debug-StatusReport_scheduledActivities_TB")).sendKeys(e[22]);
            driver.findElement(By.id("gwt-debug-StatusReport_preparedBy_TB")).sendKeys(e[23]);
            //driver.findElement(By.id("gwt-debug-StatusReport_approvedBy_TB")).sendKeys("Pavan Kumar Adapala");
            driver.findElement(By.id("gwt-debug-StatusReport_submittedDate_TB")).click();
            driver.findElement(By.xpath("//td/table/tbody/tr[2]/td[3]")).click();
            //driver.findElement(By.id("gwt-debug-StatusReport_preview_CB-input")).click();
            driver.findElement(By.id("gwt-debug-StatusReport_submitForApproval_CB-input")).click();

            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
            waitForLoader();
            Thread.sleep(2000);
        }

        takeScreenshot("MyReports_CreateStatusReport");
        System.out.println("Exit Create Status Report: " + new Date());
    }

    @Test(description = "testViewStatustReport", groups = "myReports", dependsOnGroups = "outOfOffice", priority = 2)
    public void testViewStatusReport() throws InterruptedException, IOException {

        System.out.println("Enter View Status Report: " + new Date());

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[2]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[2]/td[1]/table/tbody/tr/td[1]/img")).click();
        waitForLoader();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[5]/fieldset/div/button")).click();
        waitForLoader();
        driver.findElement(By.id("gwt-debug-Comment_comment_TB")).sendKeys("Comments Added");
        driver.findElement(By.xpath("//div[4]/div/div/div/fieldset/div/div[2]/button")).click();
        waitForLoader();
        Thread.sleep(2000);

        takeScreenshot("MyReports_ViewStatusReport");
        System.out.println("Exit View Status Report: " + new Date());

        driver.findElement(By.id("gwt-debug-Status ReportsCL")).click();
        waitForLoader();
        Thread.sleep(2000);
    }

    @Test(description = "testUpdateStatustReport", dataProvider = "StatusReportUpdateData", groups = "myReports", dependsOnGroups = "outOfOffice", priority = 3)
    public void testUpdateStatusReport(String[][] StatusReportData) throws InterruptedException, IOException {

        System.out.println("Enter Update Status Report: " + new Date());

        for (String[] e : StatusReportData) {

            driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[2]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[2]/td[1]/table/tbody/tr/td[2]/img")).click();
            waitForLoader();

            driver.findElement(By.id("gwt-debug-StatusReport_projectDescription_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_reportStartDate_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_reportEndDate_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1Name_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1Deliverable_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1EndDate_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1Status_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2Name_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2Deliverable_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2EndDate_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2Status_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3Name_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3Deliverable_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3EndDate_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3Status_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4Name_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4Deliverable_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4EndDate_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4Status_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_statusDescription_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_accomplishments_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_scheduledActivities_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_preparedBy_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_approvedBy_TB")).clear();
            driver.findElement(By.id("gwt-debug-StatusReport_submittedDate_TB")).clear();

            driver.findElement(By.id("gwt-debug-StatusReport_projectDescription_TB")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-StatusReport_reportStartDate_TB")).sendKeys(e[1]);
            driver.findElement(By.id("gwt-debug-StatusReport_reportEndDate_TB")).sendKeys(e[2]);
            WebElement element = driver.findElement(By.id("gwt-debug-StatusReport_status_LB"));
            Select status = new Select(element);
            status.selectByVisibleText(e[3]);

            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1Name_TB")).sendKeys(e[4]);
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1Deliverable_TB")).sendKeys(e[5]);
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1EndDate_TB")).sendKeys(e[6]);
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1Status_TB")).sendKeys(e[7]);

            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2Name_TB")).sendKeys(e[8]);
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2Deliverable_TB")).sendKeys(e[9]);
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2EndDate_TB")).sendKeys(e[10]);
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2Status_TB")).sendKeys(e[11]);

            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3Name_TB")).sendKeys(e[12]);
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3Deliverable_TB")).sendKeys(e[13]);
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3EndDate_TB")).sendKeys(e[14]);
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3Status_TB")).sendKeys(e[15]);

            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4Name_TB")).sendKeys(e[16]);
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4Deliverable_TB")).sendKeys(e[17]);
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4EndDate_TB")).sendKeys(e[18]);
            driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4Status_TB")).sendKeys(e[19]);

            driver.findElement(By.id("gwt-debug-StatusReport_statusDescription_TB")).sendKeys(e[20]);
            driver.findElement(By.id("gwt-debug-StatusReport_accomplishments_TB")).sendKeys(e[21]);
            driver.findElement(By.id("gwt-debug-StatusReport_scheduledActivities_TB")).sendKeys(e[22]);
            driver.findElement(By.id("gwt-debug-StatusReport_preparedBy_TB")).sendKeys(e[23]);

            //driver.findElement(By.id("gwt-debug-StatusReport_approvedBy_TB")).sendKeys("Pavan Kumar Adapala");
            driver.findElement(By.id("gwt-debug-StatusReport_submittedDate_TB")).click();
            driver.findElement(By.xpath("//td/table/tbody/tr[2]/td[2]")).click();
            //driver.findElement(By.id("gwt-debug-StatusReport_preview_CB-input")).click();
            driver.findElement(By.id("gwt-debug-StatusReport_submitForApproval_CB-input")).click();

            driver.findElement(By.xpath("//div[2]/button")).click();
            waitForLoader();
            Thread.sleep(3000);
        }
        takeScreenshot("MyReports_UpdateStatusReport");
        System.out.println("Exit Update Status Report: " + new Date());
    }

    @Test(description = "testDeleteStatustReport", groups = "myReports", dependsOnGroups = "outOfOffice", priority = 4)
    public void testDeleteStatusReport() throws InterruptedException, IOException {

        System.out.println("Enter Delete Status Report: " + new Date());

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[2]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[2]/td[1]/table/tbody/tr/td[3]/img")).click();
        Alert alt = driver.switchTo().alert();
        alt.accept();
        waitForLoader();
        Thread.sleep(2000);

        takeScreenshot("MyReports_DeleteStatusReport");
        System.out.println("Exit Delete Status Report: " + new Date());

    }

    @Test(description = "test PerfomanceEvaluation", groups = "myReports", dependsOnGroups = "outOfOffice", priority = 5, enabled = false)
    public void performance() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[2]/div/div[1]/div/div")).click();
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[2]/div/div[3]/div/div[1]/div/table/tbody/tr[5]/td/div")).click();
        driver.findElement(By.id("gwt-debug-Performance EvaluationsCL")).click();
        driver.findElement(By.xpath("html/body/div[4]/div/div/fieldset/div/span/input")).click();
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[2]/div/div[4]/div/div/div/div/fieldset/div/button")).click();
        WebElement year = driver.findElement(By.id("gwt-debug-Year_year_LB"));
        Select yearNumber = new Select(year);
        yearNumber.selectByValue("2014");
        waitForTime(20);
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[2]/div/div[4]/div/div/div/fieldset/div/fieldset/div/fieldset[1]/div/div[3]/table/tbody/tr/td[1]/textarea")).sendKeys("hello");
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[2]/div/div[4]/div/div/div/fieldset/div/fieldset/div/fieldset[2]/div/div[3]/table/tbody/tr/td[1]/textarea")).sendKeys("hello");
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[2]/div/div[4]/div/div/div/fieldset/div/fieldset/div/fieldset[3]/div/div[3]/table/tbody/tr/td[1]/textarea")).sendKeys("hello");
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[2]/div/div[4]/div/div/div/fieldset/div/fieldset/div/fieldset[4]/div/div[3]/table/tbody/tr/td[1]/textarea")).sendKeys("hello");
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[2]/div/div[4]/div/div/div/fieldset/div/button")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @DataProvider(name = "StatusReportCreateData")
    private Object[][] statusReportCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("StatusReportCreate");
    }

    @DataProvider(name = "StatusReportUpdateData")
    private Object[][] statusReportUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("StatusReportUpdate");
    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Home_StatusReport.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();
        String[][] StatusReportData = new String[rowcount + 1][24];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);
            StatusReportData[i][0] = row.getCell(0).getStringCellValue();
            StatusReportData[i][1] = row.getCell(1).getStringCellValue();
            StatusReportData[i][2] = row.getCell(2).getStringCellValue();
            StatusReportData[i][3] = row.getCell(3).getStringCellValue();
            StatusReportData[i][4] = row.getCell(4).getStringCellValue();
            StatusReportData[i][5] = row.getCell(5).getStringCellValue();
            StatusReportData[i][6] = row.getCell(6).getStringCellValue();
            StatusReportData[i][7] = row.getCell(7).getStringCellValue();
            StatusReportData[i][8] = row.getCell(8).getStringCellValue();
            StatusReportData[i][9] = row.getCell(9).getStringCellValue();
            StatusReportData[i][10] = row.getCell(10).getStringCellValue();
            StatusReportData[i][11] = row.getCell(11).getStringCellValue();
            StatusReportData[i][12] = row.getCell(12).getStringCellValue();
            StatusReportData[i][13] = row.getCell(13).getStringCellValue();
            StatusReportData[i][14] = row.getCell(14).getStringCellValue();
            StatusReportData[i][15] = row.getCell(15).getStringCellValue();
            StatusReportData[i][16] = row.getCell(16).getStringCellValue();
            StatusReportData[i][17] = row.getCell(17).getStringCellValue();
            StatusReportData[i][18] = row.getCell(18).getStringCellValue();
            StatusReportData[i][19] = row.getCell(19).getStringCellValue();
            StatusReportData[i][20] = row.getCell(20).getStringCellValue();
            StatusReportData[i][21] = row.getCell(21).getStringCellValue();
            StatusReportData[i][22] = row.getCell(22).getStringCellValue();
            StatusReportData[i][23] = row.getCell(23).getStringCellValue();
        }

        return new Object[][]{{StatusReportData}};
    }
}
