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
public class Emails extends AbstractOfficeTest {

    @Test(description = "Emails Section", groups = "emails", dependsOnGroups = "phones", priority = 1)
    public void testViewEmails() throws InterruptedException, IOException, AWTException {
        System.out.println("Enter Emails Section: " + new Date());

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

        driver.findElement(By.xpath("//table[4]/tbody/tr/td/a/table/tbody/tr/td[2]")).click();
        waitForLoader();

        robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

        takeScreenshot("Emails_Section");
        System.out.println("Exit Emails Section: " + new Date());
    }

    @Test(description = "Emails Create", dataProvider = "emailsCreateData", groups = "emails", dependsOnGroups = "phones", priority = 2)
    public void testCreateEmails(String[][] EmailsData) throws InterruptedException, IOException, AWTException {
        System.out.println("Enter Emails Create: " + new Date());

        for (String[] e : EmailsData) {

            driver.findElement(By.xpath("//table[4]/tbody/tr[2]/td/div/div/fieldset/div/button")).click();
            driver.findElement(By.id("gwt-debug-Email_email_TB")).sendKeys(e[0]);
            if (e[1].equalsIgnoreCase("Primary")) {
                driver.findElement(By.id("gwt-debug-Email_primaryEmail_CB-input")).click();
            }
            WebElement element = driver.findElement(By.id("gwt-debug-EmailType_emailType_LB"));
            Select emailType = new Select(element);
            emailType.selectByValue(e[2]);

            driver.findElement(By.xpath("//div[2]/button")).click();
            waitForLoader();
            Thread.sleep(3000);
        }
        takeScreenshot("EmailsTest_Create");
        System.out.println("Exit Emails Create: " + new Date());
    }

    @Test(description = "Emails Update", dataProvider = "emailsUpdateData", groups = "emails", dependsOnGroups = "phones", priority = 3)
    public void testUpdateEmails(String[][] EmailsData) throws InterruptedException, IOException {
        System.out.println("Enter Emails Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[9]/div/div[4]/div/div/div/div/table[4]/tbody/tr[2]/td/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : EmailsData) {

            int i = 2;
            int j = 4;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();

                    driver.findElement(By.id("gwt-debug-Email_email_TB")).clear();

                    driver.findElement(By.id("gwt-debug-Email_email_TB")).sendKeys(e[0]);
                    if (e[1].equalsIgnoreCase("Primary")) {
                        driver.findElement(By.id("gwt-debug-Email_primaryEmail_CB-input")).click();
                    }
                    WebElement element = driver.findElement(By.id("gwt-debug-EmailType_emailType_LB"));
                    Select emailType = new Select(element);
                    emailType.selectByValue(e[2]);

                    driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-updateB")).click();
                    j = 4;
                    matchFound = true;
                    waitForLoader();
                    fluentWaitForElementXpath("//table[4]/tbody/tr[2]/td/div/div/fieldset/div/button");
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("Emails_Update");
        System.out.println("Exit Emails Update: " + new Date());
    }

    @Test(dataProvider = "emailsDeleteData", description = "testEmailsDelete", groups = "emails", dependsOnGroups = "phones", priority = 4)
    public void testEmailsDelete(String[][] EmailsData) throws InterruptedException, IOException {
        System.out.println("Enter Emails Delete: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[9]/div/div[4]/div/div/div/div/table[4]/tbody/tr[2]/td/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : EmailsData) {
            int i = 2;
            int j = 4;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[3]/img")).click();
                    Alert alt = driver.switchTo().alert();
                    alt.accept();

                    j = 4;
                    matchFound = true;
                    waitForLoader();
                    fluentWaitForElementXpath("//table[4]/tbody/tr[2]/td/div/div/fieldset/div/button");
                } else {
                    i++;
                }
            }
        }

        waitForLoader();
        takeScreenshot("Emails_Delete");
        System.out.println("Exit Emails Delete: " + new Date());
    }

    @DataProvider(name = "emailsCreateData")
    private Object[][] emailsCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateEmails");
    }

    @DataProvider(name = "emailsUpdateData")
    private Object[][] emailsUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateEmails");
    }

    @DataProvider(name = "emailsDeleteData")
    private Object[][] emailsDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeleteEmails");
    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Profile_Emails.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();

        String[][] EmailsData = new String[rowcount + 1][3];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);

            EmailsData[i][0] = row.getCell(0).getStringCellValue();
            EmailsData[i][1] = row.getCell(1).getStringCellValue();
            EmailsData[i][2] = row.getCell(2).getStringCellValue();
        }
        return new Object[][]{{EmailsData}};
    }
}
