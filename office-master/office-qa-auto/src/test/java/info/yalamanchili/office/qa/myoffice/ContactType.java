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
public class ContactType extends AbstractOfficeTest {

    @Test(description = "ContactType Section", groups = "contactType", dependsOnGroups = "emailType", priority = 1)
    public void testViewContactType() throws IOException {
        System.out.println("Enter ContactType Section: " + new Date());

        driver.findElement(By.id("ContactType")).click();
        waitForLoader();

        takeScreenshot("ContactType_Section");
        System.out.println("Exit ContactType Section: " + new Date());
    }

    @Test(description = "ContactType Create", dataProvider = "contactTypeCreateData", groups = "contactType", dependsOnGroups = "emailType", priority = 2)
    public void testCreateContactType(String[][] ContactTypeData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter ContactType Create: " + new Date());

        for (String[] e : ContactTypeData) {

            driver.findElement(By.cssSelector("button.gwt-Button")).click();
            driver.findElement(By.id("gwt-debug-CompanyContactType_name_TB")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-CompanyContactType_description_TB")).sendKeys(e[1]);

            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
            waitForLoader();
            sleep(2000);
        }

        takeScreenshot("ContactType_Create");
        System.out.println("Exit ContactType Create: " + new Date());
    }

    @Test(description = "ContactType View", dataProvider = "contactTypeViewData", groups = "contactType", dependsOnGroups = "emailType", priority = 3)
    public void testContactTypeView(String[][] ContactTypeData) throws InterruptedException, IOException {
        System.out.println("Enter ContactType View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : ContactTypeData) {
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

        takeScreenshot("ContactType_View");

        System.out.println("Exit ContactType View: " + new Date());
    }

    @Test(description = "ContactType Update", dataProvider = "contactTypeUpdateData", groups = "contactType", dependsOnGroups = "emailType", priority = 4)
    public void testUpdateContactType(String[][] ContactTypeData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter ContactType Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : ContactTypeData) {
            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();
                    waitForLoader();

                    driver.findElement(By.id("gwt-debug-CompanyContactType_name_TB")).clear();
                    driver.findElement(By.id("gwt-debug-CompanyContactType_description_TB")).clear();
                    driver.findElement(By.id("gwt-debug-CompanyContactType_name_TB")).sendKeys(e[0]);
                    driver.findElement(By.id("gwt-debug-CompanyContactType_description_TB")).sendKeys(e[1]);

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

        takeScreenshot("ContactType_Update");
        System.out.println("Exit ContactType Update: " + new Date());
    }

    @Test(description = "ContactTypeDelete", dataProvider = "contactTypeDeleteData", groups = "contactType", dependsOnGroups = "emailType", priority = 5)
    public void testContactTypeDelete(String[][] ContactTypeData) throws InterruptedException, IOException {
        System.out.println("Enter ContactType Delete: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : ContactTypeData) {
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
                    takeScreenshot("ContactType_Delete");
                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        System.out.println("Exit ContactType Delete: " + new Date());
    }

    @DataProvider(name = "contactTypeCreateData")
    private Object[][] contactTypeCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateContactType");
    }

    @DataProvider(name = "contactTypeViewData")
    private Object[][] contactTypeViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewContactType");
    }

    @DataProvider(name = "contactTypeUpdateData")
    private Object[][] contactTypeUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateContactType");
    }

    @DataProvider(name = "contactTypeDeleteData")
    private Object[][] contactTypeDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeleteContactType");
    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\MyOffice_ContactType.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();
        String[][] ContactTypeData = new String[rowcount + 1][2];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);
            ContactTypeData[i][0] = row.getCell(0).getStringCellValue();
            ContactTypeData[i][1] = row.getCell(1).getStringCellValue();
        }

        return new Object[][]{{ContactTypeData}};
    }
}
