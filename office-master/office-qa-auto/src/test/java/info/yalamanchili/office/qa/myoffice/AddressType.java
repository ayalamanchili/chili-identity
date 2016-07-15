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
public class AddressType extends AbstractOfficeTest {

    @Test(description = "AddressType Section", groups = "addressType", dependsOnGroups = "phoneType", priority = 1)
    public void testViewAddressType() throws IOException {
        System.out.println("Enter AddressType Section: " + new Date());

        driver.findElement(By.id("AddressType")).click();
        waitForLoader();

        takeScreenshot("AddressType_Section");
        System.out.println("Exit AddressType Section: " + new Date());
    }

    @Test(description = "AddressType Create", dataProvider = "addressTypeCreateData", groups = "addressType", dependsOnGroups = "phoneType", priority = 2)
    public void testCreateAddressType(String[][] AddressTypeData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter AddressType Create: " + new Date());

        for (String[] e : AddressTypeData) {

            driver.findElement(By.cssSelector("button.gwt-Button")).click();
            driver.findElement(By.id("gwt-debug-AddressType_addressType_TB")).sendKeys(e[0]);

            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
            waitForLoader();
            sleep(2000);
        }

        takeScreenshot("AddressType_Create");
        System.out.println("Exit AddressType Create: " + new Date());
    }

    @Test(description = "AddressType View", dataProvider = "addressTypeViewData", groups = "addressType", dependsOnGroups = "phoneType", priority = 3)
    public void testAddressTypeView(String[][] AddressTypeData) throws InterruptedException, IOException {
        System.out.println("Enter AddressType View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : AddressTypeData) {
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

        takeScreenshot("AddressType_View");

        System.out.println("Exit AddressType View: " + new Date());
    }

    @Test(description = "AddressType Update", dataProvider = "addressTypeUpdateData", groups = "addressType", dependsOnGroups = "phoneType", priority = 4)
    public void testUpdateAddressType(String[][] AddressTypeData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter AddressType Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : AddressTypeData) {
            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();
                    waitForLoader();

                    driver.findElement(By.id("gwt-debug-AddressType_addressType_TB")).clear();
                    driver.findElement(By.id("gwt-debug-AddressType_addressType_TB")).sendKeys(e[0] + "updated");

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

        takeScreenshot("AddressType_Update");
        System.out.println("Exit AddressType Update: " + new Date());
    }

    @Test(description = "AddressTypeDelete", dataProvider = "addressTypeDeleteData", groups = "addressType", dependsOnGroups = "phoneType", priority = 5)
    public void testAddressTypeDelete(String[][] AddressTypeData) throws InterruptedException, IOException {
        System.out.println("Enter AddressType Delete: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : AddressTypeData) {
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
                    takeScreenshot("AddressType_Delete");
                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        System.out.println("Exit AddressType Delete: " + new Date());
    }

    @DataProvider(name = "addressTypeCreateData")
    private Object[][] addressTypeCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateAddressType");
    }

    @DataProvider(name = "addressTypeViewData")
    private Object[][] addressTypeViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewAddressType");
    }

    @DataProvider(name = "addressTypeUpdateData")
    private Object[][] addressTypeUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateAddressType");
    }
    
    @DataProvider(name = "addressTypeDeleteData")
    private Object[][] addressTypeDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeleteAddressType");
    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\MyOffice_AddressType.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();
        String[][] AddressTypeData = new String[rowcount + 1][1];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);
            AddressTypeData[i][0] = row.getCell(0).getStringCellValue();
        }

        return new Object[][]{{AddressTypeData}};
    }
}