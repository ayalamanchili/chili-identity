/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa.profile;

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
public class BankAccount extends AbstractOfficeTest {

    @Test(description = "BankAccount view", groups = "bankAccount", dependsOnGroups = "dependents", priority = 1)
    public void testViewBankAccount() throws InterruptedException, IOException, AWTException {
        System.out.println("Enter BankAccount Section: " + new Date());

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

        driver.findElement(By.xpath("//table[8]/tbody/tr/td/a/table/tbody/tr/td[2]")).click();
        waitForLoader();

        robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

        takeScreenshot("BankAccount_Section");
        System.out.println("Exit BankAccount Section: " + new Date());
    }

    @Test(description = "BankAccount Create", dataProvider = "bankAccountCreateData", groups = "bankAccount", dependsOnGroups = "dependents", priority = 2)
    public void testCreateBankAccount(String[][] BankAccountData) throws InterruptedException, IOException, AWTException {
        System.out.println("Enter BankAccount Create: " + new Date());

        for (String[] e : BankAccountData) {

            driver.findElement(By.xpath("//table[8]/tbody/tr[2]/td/div/div/fieldset/div/button")).click();
            driver.findElement(By.id("gwt-debug-BankAccount_accountFirstName_TB")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-BankAccount_accountLastName_TB")).sendKeys(e[1]);
            driver.findElement(By.id("gwt-debug-BankAccount_bankName_TB")).sendKeys(e[2]);
            driver.findElement(By.id("gwt-debug-BankAccount_bankRoutingNumber_TB")).sendKeys(e[3]);
            driver.findElement(By.id("gwt-debug-BankAccount_bankAccountNumber_TB")).sendKeys(e[4]);
            driver.findElement(By.id("gwt-debug-BankAccount_bankAddress1_TB")).sendKeys(e[5]);
            driver.findElement(By.id("gwt-debug-BankAccount_bankAddress2_TB")).sendKeys(e[6]);
            WebElement element = driver.findElement(By.id("gwt-debug-BankAccount_accountType_LB"));
            Select acctType = new Select(element);
            acctType.selectByValue(e[7]);
            driver.findElement(By.id("gwt-debug-BankAccount_achBlocked_CB-input")).click();

            driver.findElement(By.xpath("//div[2]/button")).click();
            waitForLoader();
        }

        takeScreenshot("BankAccountTest_Create");
        System.out.println("Exit BankAccount Create: " + new Date());
    }

    @Test(description = "BankAccount Update", dataProvider = "bankAccountUpdateData", groups = "bankAccount", dependsOnGroups = "dependents", priority = 3)
    public void testUpdateBankAccount(String[][] BankAccountData) throws InterruptedException, IOException {
        System.out.println("Enter BankAccount Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[9]/div/div[4]/div/div/div/div/table[8]/tbody/tr[2]/td/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : BankAccountData) {

            int i = 2;
            int j = 2;
            boolean matchFound = false;
            String fullName = e[0] + " " + e[1];

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(fullName)) {
                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[1]/img")).click();

                    driver.findElement(By.id("gwt-debug-BankAccount_accountFirstName_TB")).clear();
                    driver.findElement(By.id("gwt-debug-BankAccount_accountLastName_TB")).clear();
                    driver.findElement(By.id("gwt-debug-BankAccount_bankName_TB")).clear();
                    driver.findElement(By.id("gwt-debug-BankAccount_bankRoutingNumber_TB")).clear();
                    driver.findElement(By.id("gwt-debug-BankAccount_bankAccountNumber_TB")).clear();
                    driver.findElement(By.id("gwt-debug-BankAccount_bankAddress1_TB")).clear();
                    driver.findElement(By.id("gwt-debug-BankAccount_bankAddress2_TB")).clear();

                    driver.findElement(By.id("gwt-debug-BankAccount_accountFirstName_TB")).sendKeys(e[0]);
                    driver.findElement(By.id("gwt-debug-BankAccount_accountLastName_TB")).sendKeys(e[1]);
                    driver.findElement(By.id("gwt-debug-BankAccount_bankName_TB")).sendKeys(e[2]);
                    driver.findElement(By.id("gwt-debug-BankAccount_bankRoutingNumber_TB")).sendKeys(e[3]);
                    driver.findElement(By.id("gwt-debug-BankAccount_bankAccountNumber_TB")).sendKeys(e[4]);
                    driver.findElement(By.id("gwt-debug-BankAccount_bankAddress1_TB")).sendKeys(e[5]);
                    driver.findElement(By.id("gwt-debug-BankAccount_bankAddress2_TB")).sendKeys(e[6]);
                    WebElement element = driver.findElement(By.id("gwt-debug-BankAccount_accountType_LB"));
                    Select acctType = new Select(element);
                    acctType.selectByValue(e[7]);

                    driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-updateB")).click();
                    j = 2;
                    matchFound = true;
                    waitForLoader();
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("BankAccount_Update");
        System.out.println("Exit BankAccount Update: " + new Date());
    }

    @Test(dataProvider = "bankAccountDeleteData", description = "testBankAccountDelete", groups = "bankAccount", dependsOnGroups = "dependents", priority = 4)
    public void testBankAccountDelete(String[][] BankAccountData) throws InterruptedException, IOException {
        System.out.println("Enter BankAccount Delete: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[9]/div/div[4]/div/div/div/div/table[8]/tbody/tr[2]/td/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : BankAccountData) {
            int i = 2;
            int j = 2;
            boolean matchFound = false;
            String fullName = e[0] + " " + e[1];

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(fullName)) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();
                    Alert alt = driver.switchTo().alert();
                    alt.accept();

                    j = 2;
                    matchFound = true;
                    waitForLoader();
                } else {
                    i++;
                }
            }
        }

        waitForLoader();
        Thread.sleep(3000);
        takeScreenshot("BankAccount_Delete");
        System.out.println("Exit BankAccount Delete: " + new Date());
    }

    @DataProvider(name = "bankAccountCreateData")
    private Object[][] bankAccountCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateBankAccount");
    }

    @DataProvider(name = "bankAccountUpdateData")
    private Object[][] bankAccountUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateBankAccount");
    }

    @DataProvider(name = "bankAccountDeleteData")
    private Object[][] bankAccountDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeleteBankAccount");
    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Profile_BankAccount.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();

        String[][] BankAccountData = new String[rowcount + 1][8];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);

            BankAccountData[i][0] = row.getCell(0).getStringCellValue();
            BankAccountData[i][1] = row.getCell(1).getStringCellValue();
            BankAccountData[i][2] = row.getCell(2).getStringCellValue();
            BankAccountData[i][3] = row.getCell(3).getStringCellValue();
            BankAccountData[i][4] = row.getCell(4).getStringCellValue();
            BankAccountData[i][5] = row.getCell(5).getStringCellValue();
            BankAccountData[i][6] = row.getCell(6).getStringCellValue();
            BankAccountData[i][7] = row.getCell(7).getStringCellValue();
        }
        return new Object[][]{{BankAccountData}};
    }
}
