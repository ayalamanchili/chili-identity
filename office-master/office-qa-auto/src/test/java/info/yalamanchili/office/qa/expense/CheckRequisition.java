/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa.expense;

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
public class CheckRequisition extends AbstractOfficeTest {

    @Test(description = "CheckRequisition Section", groups = "checkRequisition", dependsOnGroups = "expenseCategories", priority = 1)
    public void testViewCheckRequisition() throws IOException, InterruptedException {
        System.out.println("Enter CheckRequisition Section: " + new Date());

        driver.findElement(By.xpath("//div[5]/div/div[2]/div/table/tbody/tr/td[3]/div")).click();
        waitForLoader();
        sleep(2000);
        
        takeScreenshot("CheckRequisition_Section");
        System.out.println("Exit CheckRequisition Section: " + new Date());
    }

    @Test(description = "CheckRequisition Create", dataProvider = "checkRequisitionCreateData", groups = "checkRequisition", dependsOnGroups = "expenseCategories", priority = 2)
    public void testCreateCheckRequisition(String[][] CheckRequisitionData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter CheckRequisition Create: " + new Date());

        for (String[] e : CheckRequisitionData) {

            driver.findElement(By.xpath("//div[5]/div/div[4]/div/div/div/div/fieldset/div/button")).click();
            driver.findElement(By.id("gwt-debug-Employee_employee_TB")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_attorneyName_TB")).sendKeys(e[1]);
            driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_mailingAddress_TB")).sendKeys(e[2]);
            driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_neededByDate_TB")).sendKeys(e[3]);
            driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_purpose_TB")).sendKeys(e[4]);
            WebElement element = driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_caseType_LB"));
            Select caseType = new Select(element);
            caseType.selectByVisibleText(e[5]);
            element = driver.findElement(By.id("gwt-debug-Company_company_LB"));
            Select company = new Select(element);
            company.selectByVisibleText(e[6]);
            driver.findElement(By.id("gwt-debug-Add Check ItemCL")).click();
            driver.findElement(By.id("gwt-debug-CheckRequisitionItem_itemName_TB")).sendKeys(e[7]);
            driver.findElement(By.id("gwt-debug-CheckRequisitionItem_itemDesc_TB")).sendKeys(e[8]);
            driver.findElement(By.id("gwt-debug-CheckRequisitionItem_amount_TB")).sendKeys(e[9]);

            driver.findElement(By.xpath("//div/div/div/div/fieldset/div/div[2]/button")).click();
            waitForLoader();
            sleep(5000);
        }

        takeScreenshot("CheckRequisition_Create");
        System.out.println("Exit CheckRequisition Create: " + new Date());
    }

    @Test(description = "CheckRequisition QuickView", dataProvider = "checkRequisitionQuickViewData", groups = "checkRequisition", dependsOnGroups = "expenseCategories", priority = 3)
    public void testCheckRequisitionQuickView(String[][] CheckRequisitionData) throws InterruptedException, IOException, AWTException {
        System.out.println("Enter CheckRequisition QuickView: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : CheckRequisitionData) {
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

                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_PAGE_DOWN);
                    robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
                    sleep(5000);

                    driver.findElement(By.xpath("//div[2]/fieldset/div/button")).click();
                    driver.findElement(By.id("gwt-debug-Comment_comment_TB")).sendKeys("Test Comments");
                    driver.findElement(By.id("gwt-debug-Employee_search_TB")).sendKeys("admin admin");
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

        takeScreenshot("CheckRequisition_QuickView");

        driver.findElement(By.xpath("//div[5]/div/div[2]/div/table/tbody/tr/td[3]/div")).click();
        waitForLoader();
        sleep(2000);

        System.out.println("Exit CheckRequisition QuickView: " + new Date());
    }

    @Test(description = "CheckRequisitionView", dataProvider = "checkRequisitionViewData", groups = "checkRequisition", dependsOnGroups = "expenseCategories", priority = 4)
    public void testCheckRequisitionView(String[][] CheckRequisitionData) throws InterruptedException, IOException {
        System.out.println("Enter CheckRequisition View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : CheckRequisitionData) {
            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();
                    waitForLoader();
                    sleep(2000);

                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("CheckRequisition_View");

        driver.findElement(By.xpath("//div[5]/div/div[2]/div/table/tbody/tr/td[3]/div")).click();
        waitForLoader();
        sleep(2000);

        System.out.println("Exit CheckRequisition View: " + new Date());
    }

    @Test(description = "CheckRequisition Update", dataProvider = "checkRequisitionUpdateData", groups = "checkRequisition", dependsOnGroups = "expenseCategories", priority = 5)
    public void testUpdateCheckRequisition(String[][] CheckRequisitionData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter CheckRequisition Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : CheckRequisitionData) {
            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[3]/img")).click();
                    waitForLoader();
                    sleep(2000);

                    driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_attorneyName_TB")).clear();
                    driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_mailingAddress_TB")).clear();
                    driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_neededByDate_TB")).clear();
                    driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_purpose_TB")).clear();
                    driver.findElement(By.id("gwt-debug-CheckRequisitionItem_itemName_TB")).clear();
                    driver.findElement(By.id("gwt-debug-CheckRequisitionItem_itemDesc_TB")).clear();
                    driver.findElement(By.id("gwt-debug-CheckRequisitionItem_amount_TB")).clear();

                    driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_attorneyName_TB")).sendKeys(e[1]);
                    driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_mailingAddress_TB")).sendKeys(e[2]);
                    driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_neededByDate_TB")).sendKeys(e[3]);
                    driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_purpose_TB")).sendKeys(e[4]);
                    WebElement element = driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_caseType_LB"));
                    Select label = new Select(element);
                    label.selectByVisibleText(e[5]);
                    driver.findElement(By.id("gwt-debug-CheckRequisitionItem_itemName_TB")).sendKeys(e[7]);
                    driver.findElement(By.id("gwt-debug-CheckRequisitionItem_itemDesc_TB")).sendKeys(e[8]);
                    driver.findElement(By.id("gwt-debug-CheckRequisitionItem_amount_TB")).sendKeys(e[9]);

                    driver.findElement(By.xpath("//div/div/div/div/fieldset/div/div[2]/button")).click();
                    waitForLoader();
                    sleep(2000);

                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("CheckRequisition_Update");
        System.out.println("Exit CheckRequisition Update: " + new Date());
    }

    @Test(description = "CheckRequisition Copy", dataProvider = "checkRequisitionCopyData", groups = "checkRequisition", dependsOnGroups = "expenseCategories", priority = 6)
    public void testCopyCheckRequisition(String[][] CheckRequisitionData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter CheckRequisition Copy: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : CheckRequisitionData) {
            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[5]/img")).click();
                    waitForLoader();
                    sleep(2000);

                    driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_attorneyName_TB")).clear();
                    driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_mailingAddress_TB")).clear();
                    driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_neededByDate_TB")).clear();
                    driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_purpose_TB")).clear();
                    driver.findElement(By.id("gwt-debug-CheckRequisitionItem_itemName_TB")).clear();
                    driver.findElement(By.id("gwt-debug-CheckRequisitionItem_itemDesc_TB")).clear();
                    driver.findElement(By.id("gwt-debug-CheckRequisitionItem_amount_TB")).clear();

                    driver.findElement(By.id("gwt-debug-Employee_employee_TB")).sendKeys(e[0] + "Copy");
                    driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_attorneyName_TB")).sendKeys(e[1]);
                    driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_mailingAddress_TB")).sendKeys(e[2]);
                    driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_neededByDate_TB")).sendKeys(e[3]);
                    driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_purpose_TB")).sendKeys(e[4]);
                    WebElement element = driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_caseType_LB"));
                    Select label = new Select(element);
                    label.selectByVisibleText(e[5]);
                    element = driver.findElement(By.id("gwt-debug-Company_company_LB"));
                    Select company = new Select(element);
                    company.selectByVisibleText(e[6]);
                    driver.findElement(By.id("gwt-debug-CheckRequisitionItem_itemName_TB")).sendKeys(e[7]);
                    driver.findElement(By.id("gwt-debug-CheckRequisitionItem_itemDesc_TB")).sendKeys(e[8]);
                    driver.findElement(By.id("gwt-debug-CheckRequisitionItem_amount_TB")).sendKeys(e[9]);

                    driver.findElement(By.xpath("//div/div/div/div/fieldset/div/div[2]/button")).click();
                    waitForLoader();
                    sleep(2000);

                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("CheckRequisition_Copy");
        System.out.println("Exit CheckRequisition Copy: " + new Date());
    }

    @Test(description = "CheckRequisitionAdvancedSearch", groups = "checkRequisition", dependsOnGroups = "expenseCategories", priority = 7)
    public void testAdvancedSearchCheckRequisition() throws InterruptedException, IOException {
        System.out.println("Enter CheckRequisition Adv Search: " + new Date());

        driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_employee_TB")).sendKeys("Copy");
        WebElement element = driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_status_LB"));
        Select label = new Select(element);
        label.selectByIndex(1);
        driver.findElement(By.xpath("//div[5]/div/div[3]/div/div/div/div/fieldset/div/button")).click();
        waitForLoader();
        sleep(2000);
        
        takeScreenshot("CheckRequisition_AdvancedSearch");
        System.out.println("Exit  CheckRequisition Adv Search: " + new Date());
    }

    @DataProvider(name = "checkRequisitionCreateData")
    private Object[][] checkRequisitionCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateCheckRequisition");
    }

    @DataProvider(name = "checkRequisitionViewData")
    private Object[][] checkRequisitionViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewCheckRequisition");
    }

    @DataProvider(name = "checkRequisitionQuickViewData")
    private Object[][] checkRequisitionQuickViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("QuickViewCheckRequisition");
    }

    @DataProvider(name = "checkRequisitionUpdateData")
    private Object[][] checkRequisitionUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateCheckRequisition");
    }

    @DataProvider(name = "checkRequisitionCopyData")
    private Object[][] checkRequisitionCopyData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CopyCheckRequisition");
    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Expense_CheckRequisition.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();
        String[][] CheckRequisitionData = new String[rowcount + 1][10];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);
            CheckRequisitionData[i][0] = row.getCell(0).getStringCellValue();
            CheckRequisitionData[i][1] = row.getCell(1).getStringCellValue();
            CheckRequisitionData[i][2] = row.getCell(2).getStringCellValue();
            CheckRequisitionData[i][3] = row.getCell(3).getStringCellValue();
            CheckRequisitionData[i][4] = row.getCell(4).getStringCellValue();
            CheckRequisitionData[i][5] = row.getCell(5).getStringCellValue();
            CheckRequisitionData[i][6] = row.getCell(6).getStringCellValue();
            CheckRequisitionData[i][7] = row.getCell(7).getStringCellValue();
            CheckRequisitionData[i][8] = row.getCell(8).getStringCellValue();
            CheckRequisitionData[i][9] = row.getCell(9).getStringCellValue();

        }

        return new Object[][]{{CheckRequisitionData}};
    }
}
