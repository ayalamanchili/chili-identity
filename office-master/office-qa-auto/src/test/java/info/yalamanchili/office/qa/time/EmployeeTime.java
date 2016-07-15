/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa.time;

import com.sun.glass.events.KeyEvent;
import info.yalamanchili.office.qa.AbstractOfficeTest;
import static info.yalamanchili.office.qa.AbstractOfficeTest.driver;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author joel kolli
 */
public class EmployeeTime extends AbstractOfficeTest {

    @Test(description = "EmployeeTime Section", groups = "employeeTime", dependsOnGroups = "corporateTime", priority = 1)
    public void testViewEmployeeTime() throws IOException, InterruptedException {
        System.out.println("Enter EmployeeTime Section: " + new Date());

        /*
         driver.findElement(By.xpath("//div/div/div[2]/div/div[3]/div/div")).click();
         waitForLoader();
         Thread.sleep(2000);
         */
        driver.findElement(By.xpath("//div[4]/div/div[2]/div/table/tbody/tr/td[3]/div")).click();
        waitForLoader();
        Thread.sleep(2000);

        takeScreenshot("EmployeeTime_Section");
        System.out.println("Exit EmployeeTime Section: " + new Date());
    }

    @Test(description = "EmployeeLeaveRequest", dataProvider = "employeeLeaveRequestData", groups = "employeeTime", dependsOnGroups = "corporateTime", priority = 2)
    public void testEmployeeLeaveRequest(String[][] EmployeeTimeData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter EmployeeLeaveRequest: " + new Date());

        for (String[] e : EmployeeTimeData) {

            driver.findElement(By.id("gwt-debug-Submit Leave RequestCL")).click();
            waitForLoader();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//td[2]/table/tbody/tr/td/input")).sendKeys(e[0]);

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            driver.findElement(By.id("gwt-debug-EmpLeaveRequest_startDate_TB")).sendKeys(e[1]);
            driver.findElement(By.id("gwt-debug-EmpLeaveRequest_endDate_TB")).sendKeys(e[2]);
            driver.findElement(By.id("gwt-debug-EmpLeaveRequest_hours_TB")).sendKeys(e[3]);
            WebElement element = driver.findElement(By.id("gwt-debug-EmpLeaveRequest_category_LB"));
            Select category = new Select(element);
            category.selectByVisibleText(e[4]);
            driver.findElement(By.id("gwt-debug-EmpLeaveRequest_createdTimeStamp_TB")).sendKeys(e[5]);
            driver.findElement(By.id("gwt-debug-EmpLeaveRequest_notes_TB")).sendKeys(e[6]);

            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
            waitForLoader();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//div[4]/div/div[2]/div/table/tbody/tr/td[3]/div")).click();
            waitForLoader();
            Thread.sleep(2000);
        }

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

        takeScreenshot("EmployeeTime_EmployeeLeaveRequest");
        System.out.println("Exit EmployeeLeaveRequest: " + new Date());
    }

    @Test(description = "EmployeeTimeSummary", groups = "employeeTime", dependsOnGroups = "corporateTime", priority = 3)
    public void testEmployeeTimeSummary() throws InterruptedException, IOException, AWTException {
        System.out.println("Enter EmployeeTimeSummary: " + new Date());

        driver.findElement(By.xpath("//div[4]/div/div[2]/div/table/tbody/tr/td[3]/div")).click();
        waitForLoader();
        Thread.sleep(2000);

        driver.findElement(By.id("gwt-debug-Employee_employee_TB")).sendKeys("Pavan Kumar Adapala");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        WebElement element = driver.findElement(By.id("gwt-debug-ConsultantTimeSheet_category_LB"));
        Select category = new Select(element);
        category.selectByVisibleText("Maternity");
        element = driver.findElement(By.id("gwt-debug-ConsultantTimeSheet_status_LB"));
        Select status = new Select(element);
        status.selectByVisibleText("Pending");

        driver.findElement(By.xpath("//div[4]/div/div[3]/div/div/div/div/fieldset/div/button")).click();
        waitForLoader();
        Thread.sleep(2000);

        driver.switchTo().parentFrame();

        robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

        takeScreenshot("EmployeeTime_EmployeeTimeSummary");
        System.out.println("Exit EmployeeTimeSummary: " + new Date());

    }

    @Test(description = "employeeTimeReport", dataProvider = "employeeTimeReportData", groups = "employeeTime", dependsOnGroups = "corporateTime", priority = 4)
    public void testEmployeeTimeReport(String[][] EmployeeTimeData) throws InterruptedException, IOException, AWTException {
        System.out.println("Enter EmployeeTimeReport: " + new Date());

        driver.findElement(By.xpath("//div[4]/div/div[2]/div/table/tbody/tr/td[3]/div")).click();
        waitForLoader();
        Thread.sleep(2000);

        for (String[] e : EmployeeTimeData) {

            driver.findElement(By.id("gwt-debug-ConsultantTimeSheet_startDate_TB")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-ConsultantTimeSheet_endDate_TB")).sendKeys(e[1]);
            WebElement element = driver.findElement(By.id("gwt-debug-ConsultantTimeSheet_category_LB"));
            Select category = new Select(element);
            category.selectByVisibleText(e[2]);
            element = driver.findElement(By.id("gwt-debug-ConsultantTimeSheet_status_LB"));
            Select branch = new Select(element);
            branch.selectByVisibleText(e[3]);

            driver.findElement(By.xpath("//fieldset[2]/div/button")).click();
            waitForLoader();
            Thread.sleep(2000);
        }

        driver.switchTo().parentFrame();

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

        takeScreenshot("EmployeeTime_employeeTimeReport");
        System.out.println("Exit employeeTimeReport: " + new Date());

    }

    @DataProvider(name = "employeeLeaveRequestData")
    private Object[][] employeeLeaveRequestData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("EmployeeLeaveRequest");
    }

    @DataProvider(name = "employeeTimeReportData")
    private Object[][] employeeTimeReportData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("EmployeeTimeReport");
    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Time_EmployeeTime.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();
        String[][] EmployeeTimeData = new String[rowcount + 1][7];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);
            EmployeeTimeData[i][0] = row.getCell(0).getStringCellValue();
            EmployeeTimeData[i][1] = row.getCell(1).getStringCellValue();
            EmployeeTimeData[i][2] = row.getCell(2).getStringCellValue();
            EmployeeTimeData[i][3] = row.getCell(3).getStringCellValue();
            EmployeeTimeData[i][4] = row.getCell(4).getStringCellValue();
            EmployeeTimeData[i][5] = row.getCell(5).getStringCellValue();
            EmployeeTimeData[i][6] = row.getCell(6).getStringCellValue();

        }
        return new Object[][]{{EmployeeTimeData}};
    }
}
