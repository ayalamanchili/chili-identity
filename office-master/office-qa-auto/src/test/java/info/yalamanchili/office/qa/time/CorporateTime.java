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
import static java.lang.Thread.sleep;
import java.util.Date;
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
 * @author joel kolli
 */
public class CorporateTime extends AbstractOfficeTest {

    @Test(description = "CorporateTime Section", groups = "corporateTime", dependsOnGroups = "summary", priority = 1)
    public void testViewCorporateTime() throws IOException, InterruptedException {
        System.out.println("Enter CorporateTime Section: " + new Date());

        driver.findElement(By.xpath("//div[4]/div/div[2]/div/table/tbody/tr/td[2]/div")).click();
        waitForLoader();
        Thread.sleep(5000);

        takeScreenshot("CorporateTime_Section");
        System.out.println("Exit CorporateTime Section: " + new Date());
    }

    @Test(description = "CorporateLeaveRequest", dataProvider = "corporateLeaveRequestData", groups = "corporateTime", dependsOnGroups = "summary", priority = 2)
    public void testCorporateLeaveRequest(String[][] CorporateTimeData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter CorporateLeaveRequest: " + new Date());

        for (String[] e : CorporateTimeData) {

            driver.findElement(By.id("gwt-debug-Submit Leave RequestCL")).click();
                                       
            waitForLoader();
            Thread.sleep(5000);

            driver.findElement(By.xpath("//td[2]/table/tbody/tr/td/input")).sendKeys(e[0]);

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

            driver.findElement(By.id("gwt-debug-CorpEmpLeaveRequest_startDate_TB")).sendKeys(e[1]);
            driver.findElement(By.id("gwt-debug-CorpEmpLeaveRequest_endDate_TB")).sendKeys(e[2]);
            driver.findElement(By.id("gwt-debug-CorpEmpLeaveRequest_hours_TB")).sendKeys(e[3]);
            WebElement element = driver.findElement(By.id("gwt-debug-CorpEmpLeaveRequest_category_LB"));
            Select category = new Select(element);
            category.selectByVisibleText(e[4]);
            driver.findElement(By.id("gwt-debug-CorpEmpLeaveRequest_notes_TB")).sendKeys(e[5]);
            driver.findElement(By.id("gwt-debug-Employee_search_TB")).sendKeys(e[6]);

            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
            waitForLoader();
            Thread.sleep(5000);
        }

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

        takeScreenshot("CorporateTime_CorporateLeaveRequest");
        System.out.println("Exit CorporateLeaveRequest: " + new Date());
    }

    @Test(description = "CorporateLeaveRequestUpdate", dataProvider = "corporateLeaveRequestUpdateData", groups = "corporateTime", dependsOnGroups = "summary", priority = 3)
    public void testCorporateLeaveRequestUpdate(String[][] CorporateTimeData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter CorporateLeaveRequestUpdate: " + new Date());

        driver.findElement(By.xpath("//div[4]/div/div[2]/div/table/tbody/tr/td[1]/div")).click();
        waitForLoader();
        sleep(5000);

        for (String[] e : CorporateTimeData) {

            driver.findElement(By.id("gwt-debug-Update RequestCL")).click();

            driver.findElement(By.id("gwt-debug-CorporateTimeSheet_startDate_TB")).clear();
            driver.findElement(By.id("gwt-debug-CorporateTimeSheet_endDate_TB")).clear();
            driver.findElement(By.id("gwt-debug-CorporateTimeSheet_hours_TB")).clear();
            driver.findElement(By.id("gwt-debug-CorporateTimeSheet_notes_TB")).clear();

            WebElement element = driver.findElement(By.id("gwt-debug-CorporateTimeSheet_category_LB"));
            Select category = new Select(element);
            category.selectByVisibleText("UnPaid");
            driver.findElement(By.id("gwt-debug-CorporateTimeSheet_startDate_TB")).sendKeys(e[1]);
            driver.findElement(By.id("gwt-debug-CorporateTimeSheet_endDate_TB")).sendKeys(e[2]);
            driver.findElement(By.id("gwt-debug-CorporateTimeSheet_hours_TB")).sendKeys(e[3]);
            driver.findElement(By.id("gwt-debug-CorporateTimeSheet_notes_TB")).sendKeys(e[5]);

            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-updateB")).click();
            waitForLoader();
            Thread.sleep(5000);
        }

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        
        takeScreenshot("CorporateTime_CorporateLeaveRequestUpdate");
        System.out.println("Exit CorporateLeaveRequestUpdate: " + new Date());
    }

    @Test(description = "CorporateLeaveRequestCancel", dataProvider = "corporateLeaveRequestCancelData", groups = "corporateTime", dependsOnGroups = "summary", priority = 4)
    public void testCorporateLeaveRequestCancel(String[][] CorporateTimeData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter CorporateLeaveRequestCancel: " + new Date());

        for (String[] e : CorporateTimeData) {

            driver.findElement(By.id("gwt-debug-Cancel RequestCL")).click();

            driver.findElement(By.id("gwt-debug-CorpEmpLeaveRequest_cancel_TB")).sendKeys(e[1]);

            driver.findElement(By.xpath("//div/div/div/button")).click();
            Alert Alert = driver.switchTo().alert();
            Alert.accept();

            waitForLoader();
            Thread.sleep(5000);
        }

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        
        takeScreenshot("CorporateTime_CorporateLeaveRequestCancel");
        System.out.println("Exit CorporateLeaveRequestCancel: " + new Date());
    }

    @Test(description = "CorporateLeaveRequestApprove", dataProvider = "corporateLeaveRequestApproveData", groups = "corporateTime", dependsOnGroups = "summary", priority = 5)
    public void testCorporateLeaveRequestApprove(String[][] CorporateTimeData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter CorporateLeaveRequestApprove: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[4]/div/div[4]/div/div/div/div[2]/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : CorporateTimeData) {

            int i = 2;
            int j = 3;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[4])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();
                    waitForLoader();
                    Thread.sleep(5000);

                    driver.findElement(By.id("gwt-debug-CorporateTimeSheet_startDate_TB")).clear();
                    driver.findElement(By.id("gwt-debug-CorporateTimeSheet_endDate_TB")).clear();
                    driver.findElement(By.id("gwt-debug-CorporateTimeSheet_hours_TB")).clear();
                    driver.findElement(By.id("gwt-debug-CorporateTimeSheet_notes_TB")).clear();

                    WebElement element = driver.findElement(By.id("gwt-debug-CorporateTimeSheet_status_LB"));
                    Select status = new Select(element);
                    status.selectByVisibleText("Approved");

                    driver.findElement(By.id("gwt-debug-CorporateTimeSheet_startDate_TB")).sendKeys(e[1]);
                    driver.findElement(By.id("gwt-debug-CorporateTimeSheet_endDate_TB")).sendKeys(e[2]);
                    driver.findElement(By.id("gwt-debug-CorporateTimeSheet_hours_TB")).sendKeys(e[3]);
                    driver.findElement(By.id("gwt-debug-CorporateTimeSheet_notes_TB")).sendKeys(e[5]);

                    driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-updateB")).click();
                    waitForLoader();
                    Thread.sleep(5000);

                    j = 3;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        
        takeScreenshot("CorporateTime_CorporateLeaveRequestApprove");
        System.out.println("Exit CorporateLeaveRequestApprove: " + new Date());
    }

    @Test(description = "CorporateTimeSummary", groups = "corporateTime", dependsOnGroups = "summary", priority = 6)
    public void testCorporateTimeSummary() throws InterruptedException, IOException, AWTException {
        System.out.println("Enter CorporateTimeSummary: " + new Date());

        driver.findElement(By.xpath("//div[4]/div/div[2]/div/table/tbody/tr/td[2]/div")).click();
        waitForLoader();
        Thread.sleep(5000);

        driver.findElement(By.id("gwt-debug-Employee_employee_TB")).sendKeys("admin admin");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        WebElement element = driver.findElement(By.id("gwt-debug-CorporateTimeSheet_category_LB"));
        Select category = new Select(element);
        category.selectByVisibleText("Maternity");
        element = driver.findElement(By.id("gwt-debug-CorporateTimeSheet_status_LB"));
        Select status = new Select(element);
        status.selectByVisibleText("Pending");

        driver.findElement(By.xpath("//div[4]/div/div[3]/div/div/div/div/fieldset/div/button")).click();
        waitForLoader();
        Thread.sleep(5000);

        driver.switchTo().parentFrame();

        robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

        takeScreenshot("CorporateTime_CorporateTimeSummary");
        System.out.println("Exit CorporateTimeSummary: " + new Date());

    }

    @Test(description = "corporateTimeReport", dataProvider = "corporateTimeReportData", groups = "corporateTime", dependsOnGroups = "summary", priority = 7)
    public void testCorporateTimeReport(String[][] CorporateTimeData) throws InterruptedException, IOException, AWTException {
        System.out.println("Enter CorporateTimeReport: " + new Date());

        driver.findElement(By.xpath("//div[4]/div/div[2]/div/table/tbody/tr/td[2]/div")).click();
        waitForLoader();
        Thread.sleep(5000);

        for (String[] e : CorporateTimeData) {

            driver.findElement(By.id("gwt-debug-CorporateTimeSheet_startDate_TB")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-CorporateTimeSheet_endDate_TB")).sendKeys(e[1]);
            WebElement element = driver.findElement(By.xpath("//fieldset[2]/div/div[3]/table/tbody/tr/td/select"));
            Select category = new Select(element);
            category.selectByVisibleText(e[2]);
            /*
             element = driver.findElement(By.xpath("//div[4]/table/tbody/tr/td/select"));
             Select branch = new Select(element);
             branch.selectByVisibleText(e[3]);
             */
            element = driver.findElement(By.xpath("//div[5]/table/tbody/tr/td/select"));
            Select status = new Select(element);
            status.selectByVisibleText(e[4]);
            element = driver.findElement(By.xpath("//div[6]/table/tbody/tr/td/select"));
            Select role = new Select(element);
            role.selectByVisibleText(e[5]);

            driver.findElement(By.xpath("//fieldset[2]/div/button")).click();
            waitForLoader();
            Thread.sleep(5000);
        }

        driver.switchTo().parentFrame();

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

        takeScreenshot("CorporateTime_corporateTimeReport");
        System.out.println("Exit corporateTimeReport: " + new Date());

    }

    @DataProvider(name = "corporateLeaveRequestData")
    private Object[][] corporateLeaveRequestData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CorporateLeaveRequest");
    }

    @DataProvider(name = "corporateLeaveRequestUpdateData")
    private Object[][] corporateLeaveRequestUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CorporateLeaveRequestUpdate");
    }

    @DataProvider(name = "corporateLeaveRequestCancelData")
    private Object[][] corporateLeaveRequestCancelData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CorporateLeaveRequestCancel");
    }

    @DataProvider(name = "corporateLeaveRequestApproveData")
    private Object[][] corporateLeaveRequestApproveData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CorporateLeaveRequestApprove");
    }

    @DataProvider(name = "corporateTimeReportData")
    private Object[][] corporateTimeReportData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CorporateTimeReport");
    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Time_CorporateTime.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();
        String[][] CorporateTimeData = new String[rowcount + 1][7];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);
            CorporateTimeData[i][0] = row.getCell(0).getStringCellValue();
            CorporateTimeData[i][1] = row.getCell(1).getStringCellValue();
            CorporateTimeData[i][2] = row.getCell(2).getStringCellValue();
            CorporateTimeData[i][3] = row.getCell(3).getStringCellValue();
            CorporateTimeData[i][4] = row.getCell(4).getStringCellValue();
            CorporateTimeData[i][5] = row.getCell(5).getStringCellValue();
            CorporateTimeData[i][6] = row.getCell(6).getStringCellValue();

        }
        return new Object[][]{{CorporateTimeData}};
    }
}
