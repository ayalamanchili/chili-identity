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
public class EmergencyContacts extends AbstractOfficeTest {

    @Test(description = "EmergencyContacts view", groups = "emergencyContacts", dependsOnGroups = "emails", priority = 1)
    public void testViewEmergencyContacts() throws InterruptedException, IOException, AWTException {
        System.out.println("Enter EmergencyContacts Section: " + new Date());

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

        driver.findElement(By.xpath("//table[6]/tbody/tr/td/a/table/tbody/tr/td[2]")).click();
        waitForLoader();

        robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

        takeScreenshot("EmergencyContacts_Section");
        System.out.println("Exit EmergencyContacts Section: " + new Date());
    }

    @Test(description = "EmergencyContacts Create", dataProvider = "emergencyContactsCreateData", groups = "emergencyContacts", dependsOnGroups = "emails", priority = 2)
    public void testCreateEmergencyContacts(String[][] EmergencyContactsData) throws InterruptedException, IOException, AWTException {
        System.out.println("Enter EmergencyContacts Create: " + new Date());

        for (String[] e : EmergencyContactsData) {

            driver.findElement(By.xpath("//table[6]/tbody/tr[2]/td/div/div/fieldset/div/button")).click();
            driver.findElement(By.id("gwt-debug-EmergencyContact_firstName_TB")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-EmergencyContact_middleInitial_TB")).sendKeys(e[1]);
            driver.findElement(By.id("gwt-debug-EmergencyContact_lastName_TB")).sendKeys(e[2]);
            WebElement element = driver.findElement(By.id("gwt-debug-EmergencyContact_sex_LB"));
            Select sexLabel = new Select(element);
            sexLabel.selectByValue(e[3]);
            driver.findElement(By.id("gwt-debug-EmergencyContact_relation_TB")).sendKeys(e[4]);

            if (e[5].equalsIgnoreCase("Yes")) {
                driver.findElement(By.id("gwt-debug-EmergencyContact_ecPrimary_CB-input")).click();
            }
            driver.findElement(By.id("gwt-debug-EmergencyContact_ecPrimary_CB-input")).sendKeys(e[5]);
            driver.findElement(By.id("gwt-debug-EmergencyContact_email_TB")).sendKeys(e[6]);
            driver.findElement(By.id("gwt-debug-EmergencyContact_countryCode_TB")).sendKeys(e[7]);
            driver.findElement(By.id("gwt-debug-EmergencyContact_phoneNumber_TB")).sendKeys(e[8]);
            driver.findElement(By.id("gwt-debug-EmergencyContact_extension_TB")).sendKeys(e[9]);

            driver.findElement(By.xpath("//div[2]/button")).click();
            waitForLoader();
            Thread.sleep(3000);
        }

        takeScreenshot("EmergencyContactsTest_Create");
        System.out.println("Exit EmergencyContacts Create: " + new Date());
    }

    @Test(description = "EmergencyContacts Update", dataProvider = "emergencyContactsUpdateData", groups = "emergencyContacts", dependsOnGroups = "emails", priority = 3)
    public void testUpdateEmergencyContacts(String[][] EmergencyContactsData) throws InterruptedException, IOException {
        System.out.println("Enter EmergencyContacts Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[9]/div/div[4]/div/div/div/div/table[6]/tbody/tr[2]/td/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : EmergencyContactsData) {

            int i = 2;
            int j = 3;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();

                    driver.findElement(By.id("gwt-debug-EmergencyContact_firstName_TB")).clear();
                    driver.findElement(By.id("gwt-debug-EmergencyContact_middleInitial_TB")).clear();
                    driver.findElement(By.id("gwt-debug-EmergencyContact_lastName_TB")).clear();
                    driver.findElement(By.id("gwt-debug-EmergencyContact_relation_TB")).clear();
                    //driver.findElement(By.id("gwt-debug-EmergencyContact_ecPrimary_CB-input")).clear();
                    driver.findElement(By.id("gwt-debug-EmergencyContact_email_TB")).clear();
                    driver.findElement(By.id("gwt-debug-EmergencyContact_countryCode_TB")).clear();
                    driver.findElement(By.id("gwt-debug-EmergencyContact_phoneNumber_TB")).clear();
                    driver.findElement(By.id("gwt-debug-EmergencyContact_extension_TB")).clear();

                    driver.findElement(By.id("gwt-debug-EmergencyContact_firstName_TB")).sendKeys(e[0]);
                    driver.findElement(By.id("gwt-debug-EmergencyContact_middleInitial_TB")).sendKeys(e[1]);
                    driver.findElement(By.id("gwt-debug-EmergencyContact_lastName_TB")).sendKeys(e[2]);
                    WebElement element = driver.findElement(By.id("gwt-debug-EmergencyContact_sex_LB"));
                    Select sexLabel = new Select(element);
                    sexLabel.selectByValue(e[3]);
                    driver.findElement(By.id("gwt-debug-EmergencyContact_relation_TB")).sendKeys(e[4]);
                    //if (e[5].equalsIgnoreCase("Yes")) {
                    //    driver.findElement(By.id("gwt-debug-EmergencyContact_ecPrimary_CB-input")).click();
                    //}
                    driver.findElement(By.id("gwt-debug-EmergencyContact_email_TB")).sendKeys(e[6]);
                    driver.findElement(By.id("gwt-debug-EmergencyContact_countryCode_TB")).sendKeys(e[7]);
                    driver.findElement(By.id("gwt-debug-EmergencyContact_phoneNumber_TB")).sendKeys(e[8]);
                    driver.findElement(By.id("gwt-debug-EmergencyContact_extension_TB")).sendKeys(e[9]);

                    driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-updateB")).click();
                    j = 3;
                    matchFound = true;
                    waitForLoader();
                    fluentWaitForElementXpath("//table[6]/tbody/tr[2]/td/div/div/fieldset/div/button");
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("EmergencyContacts_Update");
        System.out.println("Exit EmergencyContacts Update: " + new Date());
    }

    @Test(dataProvider = "emergencyContactsViewData", description = "testEmergencyContactsView", groups = "emergencyContacts", dependsOnGroups = "emails", priority = 4)
    public void testEmergencyContactsView(String[][] EmergencyContactsData) throws InterruptedException, IOException {
        System.out.println("Enter EmergencyContacts View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[9]/div/div[4]/div/div/div/div/table[6]/tbody/tr[2]/td/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : EmergencyContactsData) {
            int i = 2;
            int j = 3;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[1]/img")).click();

                    j = 3;
                    matchFound = true;
                    waitForLoader();
                    fluentWaitForElementXpath("//table[6]/tbody/tr[2]/td/div/div/fieldset/div/button");
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("EmergencyContacts_View");
        System.out.println("Exit EmergencyContacts View: " + new Date());
    }

    @Test(dataProvider = "emergencyContactsDeleteData", description = "testEmergencyContactsDelete", groups = "emergencyContacts", dependsOnGroups = "emails", priority = 5)
    public void testEmergencyContactsDelete(String[][] EmergencyContactsData) throws InterruptedException, IOException {
        System.out.println("Enter EmergencyContacts Delete: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[9]/div/div[4]/div/div/div/div/table[6]/tbody/tr[2]/td/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : EmergencyContactsData) {
            int i = 2;
            int j = 3;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[3]/img")).click();
                    Alert alt = driver.switchTo().alert();
                    alt.accept();

                    j = 3;
                    matchFound = true;
                    waitForLoader();
                    fluentWaitForElementXpath("//table[6]/tbody/tr[2]/td/div/div/fieldset/div/button");
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("EmergencyContacts_Delete");
        System.out.println("Exit EmergencyContacts Delete: " + new Date());
    }

    @DataProvider(name = "emergencyContactsCreateData")
    private Object[][] emergencyContactsCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateEmergencyContacts");
    }

    @DataProvider(name = "emergencyContactsUpdateData")
    private Object[][] emergencyContactsUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateEmergencyContacts");
    }

    @DataProvider(name = "emergencyContactsViewData")
    private Object[][] emergencyContactsViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewEmergencyContacts");
    }

    @DataProvider(name = "emergencyContactsDeleteData")
    private Object[][] emergencyContactsDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeleteEmergencyContacts");
    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Profile_EmergencyContacts.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();

        String[][] EmergencyContactsData = new String[rowcount + 1][10];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);

            EmergencyContactsData[i][0] = row.getCell(0).getStringCellValue();
            EmergencyContactsData[i][1] = row.getCell(1).getStringCellValue();
            EmergencyContactsData[i][2] = row.getCell(2).getStringCellValue();
            EmergencyContactsData[i][3] = row.getCell(3).getStringCellValue();
            EmergencyContactsData[i][4] = row.getCell(4).getStringCellValue();
            EmergencyContactsData[i][5] = row.getCell(5).getStringCellValue();
            EmergencyContactsData[i][6] = row.getCell(6).getStringCellValue();
            EmergencyContactsData[i][7] = row.getCell(7).getStringCellValue();
            EmergencyContactsData[i][8] = row.getCell(8).getStringCellValue();
            EmergencyContactsData[i][9] = row.getCell(9).getStringCellValue();
        }
        return new Object[][]{{EmergencyContactsData}};
    }
}
