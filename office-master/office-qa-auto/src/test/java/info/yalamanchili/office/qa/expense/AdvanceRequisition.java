/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa.expense;

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
public class AdvanceRequisition extends AbstractOfficeTest {

    @Test(description = "AdvanceRequisition Section", groups = "advanceRequisition", dependsOnGroups = "contactType", priority = 1)
    public void testViewAdvanceRequisition() throws IOException, InterruptedException {
        System.out.println("Enter AdvanceRequisition Section: " + new Date());

        driver.findElement(By.xpath("//div/div/div[2]/div/div[4]/div/div")).click();
        waitForLoader();
        sleep(2000);

        driver.findElement(By.xpath("html/body/div[4]/div/div/fieldset/div/span/input")).click();

        /*
         if (driver.findElement(By.id("gwt-uid-17")).isDisplayed()) {
         driver.findElement(By.id("gwt-uid-17")).click();
         }
         driver.findElement(By.xpath("//div[5]/div/div[2]/div/table/tbody/tr/td/div")).click();
         waitForLoader();
         */
        takeScreenshot("AdvanceRequisition_Section");
        System.out.println("Exit AdvanceRequisition Section: " + new Date());
    }

    @Test(description = "AdvanceRequisition Create", dataProvider = "advanceRequisitionCreateData", groups = "advanceRequisition", dependsOnGroups = "contactType", priority = 2)
    public void testCreateAdvanceRequisition(String[][] AdvanceRequisitionData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter AdvanceRequisition Create: " + new Date());

        for (String[] e : AdvanceRequisitionData) {

            driver.findElement(By.xpath("//div[5]/div/div[4]/div/div/div/div/fieldset/div/button")).click();
            driver.findElement(By.id("gwt-debug-AdvanceRequisition_purpose_TB")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-AdvanceRequisition_amount_TB")).sendKeys(e[1]);
            driver.findElement(By.id("gwt-debug-AdvanceRequisition_neededBy_TB")).sendKeys(e[2]);
            driver.findElement(By.id("gwt-debug-AdvanceRequisition_repaymentMonths_TB")).sendKeys(e[3]);
            driver.findElement(By.id("gwt-debug-AdvanceRequisition_repaymentNotes_TB")).sendKeys(e[4]);
            driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div[1]/span[1]/input")).click();
            driver.findElement(By.id("gwt-debug-BankAccount_accountFirstName_TB")).sendKeys(e[5]);
            driver.findElement(By.id("gwt-debug-BankAccount_accountLastName_TB")).sendKeys(e[6]);
            driver.findElement(By.id("gwt-debug-BankAccount_bankName_TB")).sendKeys(e[7]);
            driver.findElement(By.id("gwt-debug-BankAccount_bankRoutingNumber_TB")).sendKeys(e[8]);
            driver.findElement(By.id("gwt-debug-BankAccount_bankAccountNumber_TB")).sendKeys(e[9]);
            driver.findElement(By.id("gwt-debug-BankAccount_bankAddress1_TB")).sendKeys(e[10]);
            driver.findElement(By.id("gwt-debug-BankAccount_bankAddress2_TB")).sendKeys(e[11]);
            driver.findElement(By.id("gwt-debug-BankAccount_accountType_LB")).sendKeys(e[12]);
            driver.findElement(By.id("gwt-debug-BankAccount_achBlocked_CB-input")).click();

            driver.findElement(By.xpath("//div/div/div/div/fieldset/div/div[2]/button")).click();
            waitForLoader();
            sleep(5000);
        }

        takeScreenshot("AdvanceRequisition_Create");
        System.out.println("Exit AdvanceRequisition Create: " + new Date());
    }

    @Test(description = "AdvanceRequisition View", dataProvider = "advanceRequisitionViewData", groups = "advanceRequisition", dependsOnGroups = "contactType", priority = 3)
    public void testAdvanceRequisitionView(String[][] AdvanceRequisitionData) throws InterruptedException, IOException {
        System.out.println("Enter AdvanceRequisition View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : AdvanceRequisitionData) {
            int i = 2;
            int j = 3;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();
                    waitForLoader();
                    sleep(2000);
                    j = 3;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("AdvanceRequisition_View");

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[2]/div/table/tbody/tr/td[1]/div")).click();
        waitForLoader();
        sleep(2000);

        System.out.println("Exit AdvanceRequisition View: " + new Date());
    }

    @Test(description = "AdvanceRequisition Quick View", dataProvider = "advanceRequisitionQuickViewData", groups = "advanceRequisition", dependsOnGroups = "contactType", priority = 4)
    public void testAdvanceRequisitionQuickView(String[][] AdvanceRequisitionData) throws InterruptedException, IOException {
        System.out.println("Enter AdvanceRequisition Quick View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : AdvanceRequisitionData) {
            int i = 2;
            int j = 3;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    WebElement quickView = driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[1]/img"));
                    Actions action = new Actions(driver);
                    action.moveToElement(quickView).perform();
                    waitForLoader();
                    sleep(2000);
                    takeScreenshot("AdvanceRequisition_QuickView");

                    j = 3;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[2]/div/table/tbody/tr/td[1]/div")).click();
        waitForLoader();
        sleep(2000);

        System.out.println("Exit AdvanceRequisition Quick View: " + new Date());
    }

    @Test(description = "AdvanceRequisition Update", dataProvider = "advanceRequisitionUpdateData", groups = "advanceRequisition", dependsOnGroups = "contactType", priority = 5)
    public void testUpdateAdvanceRequisition(String[][] AdvanceRequisitionData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter AdvanceRequisition Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : AdvanceRequisitionData) {
            int i = 2;
            int j = 3;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[3]/img")).click();
                    waitForLoader();
                    sleep(3000);

                    driver.findElement(By.id("gwt-debug-AdvanceRequisition_purpose_TB")).clear();
                    driver.findElement(By.id("gwt-debug-AdvanceRequisition_amount_TB")).clear();
                    driver.findElement(By.id("gwt-debug-AdvanceRequisition_neededBy_TB")).clear();

                    driver.findElement(By.id("gwt-debug-AdvanceRequisition_purpose_TB")).sendKeys(e[0]);
                    driver.findElement(By.id("gwt-debug-AdvanceRequisition_amount_TB")).sendKeys(e[1]);
                    driver.findElement(By.id("gwt-debug-AdvanceRequisition_neededBy_TB")).sendKeys(e[2]);
                    WebElement element = driver.findElement(By.id("gwt-debug-AdvanceRequisition_status_LB"));
                    Select status = new Select(element);
                    status.selectByVisibleText("Pending");

                    driver.findElement(By.xpath("//div[2]/button")).click();
                    waitForLoader();
                    sleep(3000);

                    j = 3;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("AdvanceRequisition_Update");
        System.out.println("Exit AdvanceRequisition Update: " + new Date());
    }

    @Test(description = "AdvanceRequisitionDelete", dataProvider = "advanceRequisitionDeleteData", groups = "advanceRequisition", dependsOnGroups = "contactType", priority = 6)
    public void testAdvanceRequisitionDelete(String[][] AdvanceRequisitionData) throws InterruptedException, IOException {
        System.out.println("Enter AdvanceRequisition Delete: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : AdvanceRequisitionData) {
            int i = 2;
            int j = 3;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[4]/img")).click();
                    Alert alt = driver.switchTo().alert();
                    alt.accept();

                    waitForLoader();
                    sleep(2000);
                    takeScreenshot("AdvanceRequisition_Delete");
                    j = 3;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        System.out.println("Exit AdvanceRequisition Delete: " + new Date());
    }

    @DataProvider(name = "advanceRequisitionCreateData")
    private Object[][] advanceRequisitionCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateAdvanceRequisition");
    }

    @DataProvider(name = "advanceRequisitionViewData")
    private Object[][] advanceRequisitionViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewAdvanceRequisition");
    }

    @DataProvider(name = "advanceRequisitionQuickViewData")
    private Object[][] advanceRequisitionQuickViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("QuickViewAdvanceRequisition");
    }

    @DataProvider(name = "advanceRequisitionUpdateData")
    private Object[][] advanceRequisitionUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateAdvanceRequisition");
    }

    @DataProvider(name = "advanceRequisitionDeleteData")
    private Object[][] advanceRequisitionDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeleteAdvanceRequisition");
    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Expense_AdvanceRequisition.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();
        String[][] AdvanceRequisitionData = new String[rowcount + 1][13];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);
            AdvanceRequisitionData[i][0] = row.getCell(0).getStringCellValue();
            AdvanceRequisitionData[i][1] = row.getCell(1).getStringCellValue();
            AdvanceRequisitionData[i][2] = row.getCell(2).getStringCellValue();
            AdvanceRequisitionData[i][3] = row.getCell(3).getStringCellValue();
            AdvanceRequisitionData[i][4] = row.getCell(4).getStringCellValue();
            AdvanceRequisitionData[i][5] = row.getCell(5).getStringCellValue();
            AdvanceRequisitionData[i][6] = row.getCell(6).getStringCellValue();
            AdvanceRequisitionData[i][7] = row.getCell(7).getStringCellValue();
            AdvanceRequisitionData[i][8] = row.getCell(8).getStringCellValue();
            AdvanceRequisitionData[i][9] = row.getCell(9).getStringCellValue();
            AdvanceRequisitionData[i][10] = row.getCell(10).getStringCellValue();
            AdvanceRequisitionData[i][11] = row.getCell(11).getStringCellValue();
            AdvanceRequisitionData[i][12] = row.getCell(12).getStringCellValue();
        }

        return new Object[][]{{AdvanceRequisitionData}};
    }
}
