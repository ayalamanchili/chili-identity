/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa.myoffice;

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author joel kolli
 */
public class EmailType extends AbstractOfficeTest {

    @Test(description = "EmailType Section", groups = "emailType", dependsOnGroups = "addressType", priority = 1)
    public void testViewEmailType() throws IOException {
        System.out.println("Enter EmailType Section: " + new Date());

        driver.findElement(By.id("EmailType")).click();
        waitForLoader();

        takeScreenshot("EmailType_Section");
        System.out.println("Exit EmailType Section: " + new Date());
    }

    @Test(description = "EmailType Create", dataProvider = "emailTypeCreateData", groups = "emailType", dependsOnGroups = "addressType", priority = 2)
    public void testCreateEmailType(String[][] EmailTypeData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter EmailType Create: " + new Date());

        for (String[] e : EmailTypeData) {

            driver.findElement(By.cssSelector("button.gwt-Button")).click();
            driver.findElement(By.id("gwt-debug-EmailType_emailType_TB")).sendKeys(e[0]);

            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
            waitForLoader();
            sleep(2000);
        }

        takeScreenshot("EmailType_Create");
        System.out.println("Exit EmailType Create: " + new Date());
    }

    @Test(description = "EmailType View", dataProvider = "emailTypeViewData", groups = "emailType", dependsOnGroups = "addressType", priority = 3)
    public void testEmailTypeView(String[][] EmailTypeData) throws InterruptedException, IOException {
        System.out.println("Enter EmailType View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : EmailTypeData) {
            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[1]/img")).click();
                    waitForLoader();

                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("EmailType_View");

        System.out.println("Exit EmailType View: " + new Date());
    }

    @Test(description = "EmailType Update", dataProvider = "emailTypeUpdateData", groups = "emailType", dependsOnGroups = "addressType", priority = 4)
    public void testUpdateEmailType(String[][] EmailTypeData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter EmailType Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : EmailTypeData) {
            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();
                    waitForLoader();

                    driver.findElement(By.id("gwt-debug-EmailType_emailType_TB")).clear();
                    driver.findElement(By.id("gwt-debug-EmailType_emailType_TB")).sendKeys(e[0] + "updated");

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

        takeScreenshot("EmailType_Update");
        System.out.println("Exit EmailType Update: " + new Date());
    }

    @Test(description = "EmailTypeDelete", dataProvider = "emailTypeDeleteData", groups = "emailType", dependsOnGroups = "addressType", priority = 5)
    public void testEmailTypeDelete(String[][] EmailTypeData) throws InterruptedException, IOException {
        System.out.println("Enter EmailType Delete: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : EmailTypeData) {
            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[3]/img")).click();
                    Alert alt = driver.switchTo().alert();
                    alt.accept();

                    waitForLoader();
                    Thread.sleep(3000);
                    takeScreenshot("EmailType_Delete");
                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        System.out.println("Exit EmailType Delete: " + new Date());
    }

    @DataProvider(name = "emailTypeCreateData")
    private Object[][] emailTypeCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateEmailType");
    }

    @DataProvider(name = "emailTypeViewData")
    private Object[][] emailTypeViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewEmailType");
    }

    @DataProvider(name = "emailTypeUpdateData")
    private Object[][] emailTypeUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateEmailType");
    }
    
    @DataProvider(name = "emailTypeDeleteData")
    private Object[][] emailTypeDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeleteEmailType");
    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\MyOffice_EmailType.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();
        String[][] EmailTypeData = new String[rowcount + 1][1];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);
            EmailTypeData[i][0] = row.getCell(0).getStringCellValue();
        }

        return new Object[][]{{EmailTypeData}};
    }
}