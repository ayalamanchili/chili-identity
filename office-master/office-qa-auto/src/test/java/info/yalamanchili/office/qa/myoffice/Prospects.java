/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa.myoffice;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author joel kolli
 */
public class Prospects extends AbstractOfficeTest {

    @Test(description = "Prospects Section", groups = "prospects", dependsOnGroups = "onBoarding", priority = 1)
    public void testViewProspects() throws IOException {
        System.out.println("Enter Prospects Section: " + new Date());

        driver.findElement(By.id("Prospects")).click();
        waitForLoader();

        takeScreenshot("Prospects_Section");
        System.out.println("Exit Prospects Section: " + new Date());
    }

    @Test(description = "Prospects Create", dataProvider = "prospectsCreateData", groups = "prospects", dependsOnGroups = "onBoarding", priority = 2)
    public void testCreateProspects(String[][] ProspectsData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter Prospects Create: " + new Date());

        for (String[] e : ProspectsData) {

            driver.findElement(By.xpath("//div[4]/div/div/div/div/fieldset/div/button")).click();

            driver.findElement(By.xpath("//td[2]/table/tbody/tr/td/input")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-Prospect_middleInitial_TB")).sendKeys(e[1]);
            driver.findElement(By.xpath("//table[3]/tbody/tr/td[2]/table/tbody/tr/td/input")).sendKeys(e[2]);
            driver.findElement(By.xpath("//table[4]/tbody/tr/td[2]/table/tbody/tr/td/input")).sendKeys(e[3]);
            driver.findElement(By.id("gwt-debug-Prospect_email_TB")).sendKeys(e[4]);
            driver.findElement(By.id("gwt-debug-Prospect_countryCode_TB")).sendKeys(e[5]);
            driver.findElement(By.id("gwt-debug-Prospect_phoneNumber_TB")).sendKeys(e[6]);
            driver.findElement(By.id("gwt-debug-Prospect_dateOfBirth_TB")).sendKeys(e[7]);
            driver.findElement(By.id("gwt-debug-Prospect_street1_TB")).sendKeys(e[8]);
            driver.findElement(By.id("gwt-debug-Prospect_street2_TB")).sendKeys(e[9]);
            driver.findElement(By.id("gwt-debug-Prospect_city_TB")).sendKeys(e[10]);
            WebElement element = driver.findElement(By.id("gwt-debug-Prospect_country_LB"));
            Select country = new Select(element);
            country.selectByVisibleText(e[11]);
            element = driver.findElement(By.id("gwt-debug-Prospect_state_LB"));
            Select state = new Select(element);
            state.selectByVisibleText(e[12]);
            driver.findElement(By.id("gwt-debug-Prospect_zip_TB")).sendKeys(e[13]);
            driver.findElement(By.id("gwt-debug-Prospect_screenedBy_TB")).sendKeys(e[14]);
            driver.findElement(By.xpath("//table[16]/tbody/tr/td[2]/table/tbody/tr/td/input")).sendKeys(e[15]);

            driver.findElement(By.id("gwt-debug-Employee_search_TB")).sendKeys(e[16]);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            driver.findElement(By.xpath("//table[18]/tbody/tr/td[2]/table/tbody/tr/td/input")).sendKeys(e[17]);
            driver.findElement(By.xpath("//table[19]/tbody/tr/td[2]/table/tbody/tr/td/input")).sendKeys(e[18]);
            driver.findElement(By.id("gwt-debug-Prospect_comment_TB")).sendKeys(e[19]);

            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
            waitForLoader();
            sleep(5000);
            driver.findElement(By.id("Prospects")).click();
            waitForLoader();
            sleep(5000);
        }

        takeScreenshot("Prospects_Create");
        System.out.println("Exit Prospects Create: " + new Date());
    }

    @Test(description = "Prospects View", dataProvider = "prospectsViewData", groups = "prospects", dependsOnGroups = "onBoarding", priority = 3)
    public void testProspectsView(String[][] ProspectsData) throws InterruptedException, IOException {
        System.out.println("Enter Prospects View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : ProspectsData) {
            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();
                    waitForLoader();

                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        sleep(5000);
        takeScreenshot("Prospects_View");

        driver.findElement(By.id("Prospects")).click();
        waitForLoader();
        sleep(5000);
        System.out.println("Exit Prospects View: " + new Date());
    }

    @Test(description = "Prospects Quick View", dataProvider = "prospectsQuickViewData", groups = "prospects", dependsOnGroups = "onBoarding", priority = 4)
    public void testProspectsQuickView(String[][] ProspectsData) throws InterruptedException, IOException {
        System.out.println("Enter Prospects Quick View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : ProspectsData) {
            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    WebElement quickView = driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[1]/img"));
                    Actions action = new Actions(driver);
                    action.moveToElement(quickView).perform();
                    waitForLoader();
                    sleep(5000);
                    takeScreenshot("Prospects_QuickView");

                    WebElement view = driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img"));
                    Actions actiona = new Actions(driver);
                    actiona.moveToElement(view).perform();

                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        System.out.println("Exit Prospects Quick View: " + new Date());
    }

    @Test(description = "Prospects Update", dataProvider = "prospectsUpdateData", groups = "prospects", dependsOnGroups = "onBoarding", priority = 5)
    public void testUpdateProspects(String[][] ProspectsData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter Prospects Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : ProspectsData) {
            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[3]/img")).click();
                    waitForLoader();
                    sleep(5000);

                    driver.findElement(By.xpath("//td[2]/table/tbody/tr/td/input")).clear();
                    driver.findElement(By.id("gwt-debug-Prospect_middleInitial_TB")).clear();
                    driver.findElement(By.xpath("//table[3]/tbody/tr/td[2]/table/tbody/tr/td/input")).clear();
                    driver.findElement(By.xpath("//table[4]/tbody/tr/td[2]/table/tbody/tr/td/input")).clear();
                    driver.findElement(By.id("gwt-debug-Prospect_email_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Prospect_countryCode_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Prospect_phoneNumber_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Prospect_dateOfBirth_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Prospect_street1_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Prospect_street2_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Prospect_city_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Prospect_zip_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Prospect_screenedBy_TB")).clear();
                    driver.findElement(By.xpath("//table[14]/tbody/tr/td[2]/table/tbody/tr/td/input")).clear();
                    driver.findElement(By.xpath("//table[15]/tbody/tr/td[2]/table/tbody/tr/td/input")).clear();
                    driver.findElement(By.xpath("//table[17]/tbody/tr/td[2]/table/tbody/tr/td/input")).clear();
                    driver.findElement(By.id("gwt-debug-Employee_search_TB")).clear();
                    driver.findElement(By.xpath("//table[19]/tbody/tr/td[2]/table/tbody/tr/td/input")).clear();
                    driver.findElement(By.id("gwt-debug-Prospect_comment_TB")).clear();

                    driver.findElement(By.xpath("//td[2]/table/tbody/tr/td/input")).sendKeys(e[0]);
                    driver.findElement(By.id("gwt-debug-Prospect_middleInitial_TB")).sendKeys(e[1]);
                    driver.findElement(By.xpath("//table[3]/tbody/tr/td[2]/table/tbody/tr/td/input")).sendKeys(e[2]);
                    driver.findElement(By.id("gwt-debug-Prospect_email_TB")).sendKeys(e[4]);
                    driver.findElement(By.id("gwt-debug-Prospect_countryCode_TB")).sendKeys(e[5]);
                    driver.findElement(By.id("gwt-debug-Prospect_phoneNumber_TB")).sendKeys(e[6]);
                    driver.findElement(By.id("gwt-debug-Prospect_dateOfBirth_TB")).sendKeys(e[7]);
                    driver.findElement(By.id("gwt-debug-Prospect_street1_TB")).sendKeys(e[8]);
                    driver.findElement(By.id("gwt-debug-Prospect_street2_TB")).sendKeys(e[9]);
                    driver.findElement(By.id("gwt-debug-Prospect_city_TB")).sendKeys(e[10]);
                    WebElement element = driver.findElement(By.id("gwt-debug-Prospect_country_LB"));
                    Select country = new Select(element);
                    country.selectByVisibleText(e[11]);
                    element = driver.findElement(By.id("gwt-debug-Prospect_state_LB"));
                    Select state = new Select(element);
                    state.selectByVisibleText(e[12]);
                    driver.findElement(By.id("gwt-debug-Prospect_zip_TB")).sendKeys(e[13]);
                    driver.findElement(By.xpath("//table[14]/tbody/tr/td[2]/table/tbody/tr/td/input")).sendKeys(e[3]);
                    driver.findElement(By.xpath("//table[15]/tbody/tr/td[2]/table/tbody/tr/td/input")).sendKeys(e[15]);
                    driver.findElement(By.id("gwt-debug-Employee_search_TB")).sendKeys(e[16]);
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                    driver.findElement(By.xpath("//table[17]/tbody/tr/td[2]/table/tbody/tr/td/input")).sendKeys(e[17]);
                    driver.findElement(By.id("gwt-debug-Prospect_screenedBy_TB")).sendKeys(e[14]);
                    driver.findElement(By.xpath("//table[19]/tbody/tr/td[2]/table/tbody/tr/td/input")).sendKeys(e[18]);
                    driver.findElement(By.id("gwt-debug-Prospect_comment_TB")).sendKeys(e[19]);
                    element = driver.findElement(By.xpath("//table[21]/tbody/tr/td[2]/table/tbody/tr/td/select"));
                    Select status = new Select(element);
                    status.selectByVisibleText(e[20]);

                    driver.findElement(By.xpath("//div[2]/button")).click();
                    waitForLoader();
                    sleep(5000);

                    driver.findElement(By.id("Prospects")).click();
                    waitForLoader();
                    sleep(5000);

                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("Prospects_Update");
        System.out.println("Exit Prospects Update: " + new Date());
    }

    @Test(description = "viewProspectStatus", groups = "prospects", dependsOnGroups = "onBoarding", priority = 6)
    public void testViewProspectStatus() throws InterruptedException, IOException {
        System.out.println("Enter Prospect Status: " + new Date());

        driver.findElement(By.id("IN_PROGRESS")).click();
        waitForLoader();
        sleep(2000);
        takeScreenshot("ProspectStatus_InProgress");

        driver.findElement(By.id("RECRUITING")).click();
        waitForLoader();
        sleep(2000);
        takeScreenshot("ProspectStatus_Recruiting");

        driver.findElement(By.id("BENCH")).click();
        waitForLoader();
        sleep(2000);
        takeScreenshot("ProspectStatus_Bench");

        driver.findElement(By.id("ONHOLD")).click();
        waitForLoader();
        sleep(2000);
        takeScreenshot("ProspectStatus_Onhold");

        driver.findElement(By.id("CLOSED_WON")).click();
        waitForLoader();
        sleep(2000);
        takeScreenshot("ProspectStatus_ClosedWon");

        driver.findElement(By.id("CLOSED_LOST")).click();
        waitForLoader();
        sleep(2000);
        takeScreenshot("ProspectStatus_ClosedLost");

        driver.findElement(By.id("All")).click();
        waitForLoader();
        sleep(2000);
        System.out.println("Exit Prospect Status: " + new Date());
    }

    @Test(description = "searchProspect", groups = "prospects", dependsOnGroups = "onBoarding", priority = 7)
    public void testSearchProspect() throws InterruptedException, IOException, AWTException {
        System.out.println("Enter Search Prospect: " + new Date());

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[3]/div/div[1]/div/div/fieldset/div/input")).sendKeys("Larry Bird");
        waitForTime(05);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        waitForLoader();
        sleep(2000);
        takeScreenshot("SearchProspect");

        driver.findElement(By.id("All")).click();
        waitForLoader();
        sleep(2000);

        System.out.println("Exit Search Prospect: " + new Date());
    }

    @Test(description = "advanceSearchProspect", dataProvider = "prospectsAdvanceSearchData", groups = "prospects", dependsOnGroups = "onBoarding", priority = 8)
    public void testAdvanceSearchProspect(String[][] ProspectsData) throws InterruptedException, IOException, AWTException {
        System.out.println("Enter Advance Search Prospect: " + new Date());

        for (String[] e : ProspectsData) {

            driver.findElement(By.id("gwt-debug-Prospect_firstName_TB")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-Prospect_processDocSentDate_TB")).sendKeys(e[18]);
            driver.findElement(By.id("gwt-debug-Prospect_lastName_TB")).sendKeys(e[2]);
            driver.findElement(By.id("gwt-debug-Prospect_referredBy_TB")).sendKeys(e[3]);
            driver.findElement(By.id("gwt-debug-Employee_assignedTo_TB")).sendKeys(e[15]);
            driver.findElement(By.id("gwt-debug-Employee_caseManager_TB")).sendKeys(e[17]);
            sleep(2000);

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            driver.findElement(By.cssSelector("button.gwt-Button")).click();
            waitForLoader();
            sleep(2000);

            takeScreenshot("advanceSearchProspect");
        }

        driver.findElement(By.id("All")).click();
        waitForLoader();
        sleep(2000);

        System.out.println("Exit Advance Search Prospect: " + new Date());
    }

    @Test(description = "ProspectsDelete", dataProvider = "prospectsDeleteData", groups = "prospects", dependsOnGroups = "onBoarding", priority = 9)
    public void testProspectDelete(String [][] ProspectsData) throws InterruptedException, IOException {
        System.out.println("Enter Prospects Delete: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : ProspectsData) {
            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[4]/img")).click();
                    Alert alt = driver.switchTo().alert();
                    alt.accept();

                    waitForLoader();
                    Thread.sleep(5000);
                    takeScreenshot("Prospect_Delete");
                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        System.out.println("Exit Prospect Delete: " + new Date());
    }

    @DataProvider(name = "prospectsCreateData")
    private Object[][] prospectsCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateProspects");
    }

    @DataProvider(name = "prospectsViewData")
    private Object[][] prospectsViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewProspects");
    }

    @DataProvider(name = "prospectsQuickViewData")
    private Object[][] prospectsQuickViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("QuickViewProspects");
    }

    @DataProvider(name = "prospectsUpdateData")
    private Object[][] prospectsUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateProspects");
    }

    @DataProvider(name = "prospectsAdvanceSearchData")
    private Object[][] prospectsAdvanceSearchData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("AdvanceSearchProspects");
    }

    @DataProvider(name = "prospectsDeleteData")
    private Object[][] prospectsDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeleteProspects");
    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\MyOffice_Prospects.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();
        String[][] ProspectsData = new String[rowcount + 1][21];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);
            ProspectsData[i][0] = row.getCell(0).getStringCellValue();
            ProspectsData[i][1] = row.getCell(1).getStringCellValue();
            ProspectsData[i][2] = row.getCell(2).getStringCellValue();
            ProspectsData[i][3] = row.getCell(3).getStringCellValue();
            ProspectsData[i][4] = row.getCell(4).getStringCellValue();
            ProspectsData[i][5] = row.getCell(5).getStringCellValue();
            ProspectsData[i][6] = row.getCell(6).getStringCellValue();
            ProspectsData[i][7] = row.getCell(7).getStringCellValue();
            ProspectsData[i][8] = row.getCell(8).getStringCellValue();
            ProspectsData[i][9] = row.getCell(9).getStringCellValue();
            ProspectsData[i][10] = row.getCell(10).getStringCellValue();
            ProspectsData[i][11] = row.getCell(11).getStringCellValue();
            ProspectsData[i][12] = row.getCell(12).getStringCellValue();
            ProspectsData[i][13] = row.getCell(13).getStringCellValue();
            ProspectsData[i][14] = row.getCell(14).getStringCellValue();
            ProspectsData[i][15] = row.getCell(15).getStringCellValue();
            ProspectsData[i][16] = row.getCell(16).getStringCellValue();
            ProspectsData[i][17] = row.getCell(17).getStringCellValue();
            ProspectsData[i][18] = row.getCell(18).getStringCellValue();
            ProspectsData[i][19] = row.getCell(19).getStringCellValue();
            ProspectsData[i][20] = row.getCell(20).getStringCellValue();
        }

        return new Object[][]{{ProspectsData}};
    }
}
