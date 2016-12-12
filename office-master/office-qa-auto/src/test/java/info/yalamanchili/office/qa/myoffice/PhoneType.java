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
public class PhoneType extends AbstractOfficeTest {

    @Test(description = "PhoneType Section", groups = "phoneType", dependsOnGroups = "prospects", priority = 1)
    public void testViewPhoneType() throws IOException {
        System.out.println("Enter PhoneType Section: " + new Date());

        driver.findElement(By.id("PhoneType")).click();
        waitForLoader();

        takeScreenshot("PhoneType_Section");
        System.out.println("Exit PhoneType Section: " + new Date());
    }

    @Test(description = "PhoneType Create", dataProvider = "phoneTypeCreateData", groups = "phoneType", dependsOnGroups = "prospects", priority = 2)
    public void testCreatePhoneType(String[][] PhoneTypeData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter PhoneType Create: " + new Date());

        for (String[] e : PhoneTypeData) {

            driver.findElement(By.cssSelector("button.gwt-Button")).click();
            driver.findElement(By.id("gwt-debug-PhoneType_phoneType_TB")).sendKeys(e[0]);

            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
            waitForLoader();
            sleep(2000);
        }

        takeScreenshot("PhoneType_Create");
        System.out.println("Exit PhoneType Create: " + new Date());
    }

    @Test(description = "PhoneType View", dataProvider = "phoneTypeViewData", groups = "phoneType", dependsOnGroups = "prospects", priority = 3)
    public void testPhoneTypeView(String[][] PhoneTypeData) throws InterruptedException, IOException {
        System.out.println("Enter PhoneType View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : PhoneTypeData) {
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

        takeScreenshot("PhoneType_View");

        System.out.println("Exit PhoneType View: " + new Date());
    }

    @Test(description = "PhoneType Update", dataProvider = "phoneTypeUpdateData", groups = "phoneType", dependsOnGroups = "prospects", priority = 4)
    public void testUpdatePhoneType(String[][] PhoneTypeData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter PhoneType Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : PhoneTypeData) {
            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();
                    waitForLoader();

                    driver.findElement(By.id("gwt-debug-PhoneType_phoneType_TB")).clear();
                    driver.findElement(By.id("gwt-debug-PhoneType_phoneType_TB")).sendKeys(e[0] + "updated");

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

        takeScreenshot("PhoneType_Update");
        System.out.println("Exit PhoneType Update: " + new Date());
    }

    @Test(description = "PhoneTypeDelete", dataProvider = "phoneTypeDeleteData", groups = "phoneType", dependsOnGroups = "prospects", priority = 5)
    public void testPhoneTypeDelete(String[][] PhoneTypeData) throws InterruptedException, IOException {
        System.out.println("Enter PhoneType Delete: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : PhoneTypeData) {
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
                    Thread.sleep(5000);
                    takeScreenshot("PhoneType_Delete");
                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        System.out.println("Exit PhoneType Delete: " + new Date());
    }

    @DataProvider(name = "phoneTypeCreateData")
    private Object[][] phoneTypeCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreatePhoneType");
    }

    @DataProvider(name = "phoneTypeViewData")
    private Object[][] phoneTypeViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewPhoneType");
    }

    @DataProvider(name = "phoneTypeUpdateData")
    private Object[][] phoneTypeUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdatePhoneType");
    }
    
    @DataProvider(name = "phoneTypeDeleteData")
    private Object[][] phoneTypeDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeletePhoneType");
    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\MyOffice_PhoneType.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();
        String[][] PhoneTypeData = new String[rowcount + 1][1];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);
            PhoneTypeData[i][0] = row.getCell(0).getStringCellValue();
        }

        return new Object[][]{{PhoneTypeData}};
    }
}