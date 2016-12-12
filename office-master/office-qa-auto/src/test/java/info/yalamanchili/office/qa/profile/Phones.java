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
public class Phones extends AbstractOfficeTest {

    @Test(description = "PhonesSection", groups = "phones", dependsOnGroups = "addresses", priority = 1)
    public void testPhonesSection() throws InterruptedException, IOException, AWTException {
        System.out.println("Enter Phones Section: " + new Date());

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        waitForTime(10);

        driver.findElement(By.xpath("//table[3]/tbody/tr/td/a/table/tbody/tr/td[2]")).click();
        waitForLoader();

        robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        waitForTime(10);

        takeScreenshot("Phones_Section");
        System.out.println("Exit Phones Section: " + new Date());
    }

    @Test(description = "Phones Create", dataProvider = "phonesCreateData", groups = "phones", dependsOnGroups = "addresses", priority = 2)
    public void testCreatePhones(String[][] PhonesData) throws InterruptedException, IOException {
        System.out.println("Enter Phones Create: " + new Date());

        for (String[] e : PhonesData) {

            driver.findElement(By.xpath("//table[3]/tbody/tr[2]/td/div/div/fieldset/div/button")).click();

            driver.findElement(By.id("gwt-debug-Phone_countryCode_TB")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-Phone_phoneNumber_TB")).sendKeys(e[1]);
            driver.findElement(By.id("gwt-debug-Phone_extension_TB")).sendKeys(e[2]);
            WebElement element = driver.findElement(By.id("gwt-debug-PhoneType_phoneType_LB"));
            Select phoneType = new Select(element);
            phoneType.selectByValue(e[3]);

            driver.findElement(By.xpath("//div[2]/button")).click();
            waitForLoader();
            Thread.sleep(3000);
        }

        takeScreenshot("PhonesTest_Create");
        System.out.println("Exit Phones Create: " + new Date());
    }

    @Test(description = "Phones Update", dataProvider = "phonesUpdateData", groups = "phones", dependsOnGroups = "addresses", priority = 3)
    public void testUpdatePhones(String[][] PhonesData) throws InterruptedException, IOException {
        System.out.println("Enter Phones Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[9]/div/div[4]/div/div/div/div/table[3]/tbody/tr[2]/td/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";
        StringBuilder phonenumber = new StringBuilder();

        for (String[] e : PhonesData) {
            int i = 2;
            int j = 3;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                phonenumber.setLength(0);
                phonenumber = phonenumber.append(driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().substring(0, 3)).append(driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().substring(4, 7)).append(driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().substring(8));

                if (e[1].equals(phonenumber.toString())) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();

                    driver.findElement(By.id("gwt-debug-Phone_countryCode_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Phone_phoneNumber_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Phone_extension_TB")).clear();

                    driver.findElement(By.id("gwt-debug-Phone_countryCode_TB")).sendKeys(e[0]);
                    driver.findElement(By.id("gwt-debug-Phone_phoneNumber_TB")).sendKeys(e[1]);
                    driver.findElement(By.id("gwt-debug-Phone_extension_TB")).sendKeys(e[2]);
                    WebElement element = driver.findElement(By.id("gwt-debug-PhoneType_phoneType_LB"));
                    Select phoneType = new Select(element);
                    phoneType.selectByValue(e[3]);

                    driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-updateB")).click();
                    j = 3;
                    matchFound = true;
                    waitForLoader();
                    Thread.sleep(3000);
                } else {

                    i++;
                }
            }
        }

        takeScreenshot("Phones_Update");
        System.out.println("Exit Phones Update: " + new Date());
    }

    @Test(dataProvider = "phonesDeleteData", description = "testPhonesDelete", groups = "phones", dependsOnGroups = "addresses", priority = 4)
    public void testPhonesDelete(String[][] PhonesData) throws InterruptedException, IOException {
        System.out.println("Enter Phones Delete: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[9]/div/div[4]/div/div/div/div/table[3]/tbody/tr[2]/td/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";
        StringBuilder phonenumber = new StringBuilder();

        for (String[] e : PhonesData) {
            int i = 2;
            int j = 3;
            boolean matchFound = false;
            waitForStaleness(driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)));

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                phonenumber.setLength(0);
                phonenumber = phonenumber.append(driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().substring(0, 3)).append(driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().substring(4, 7)).append(driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().substring(8));

                if (e[1].equals(phonenumber.toString())) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[3]/img")).click();
                    Alert alt = driver.switchTo().alert();
                    alt.accept();

                    j = 3;
                    matchFound = true;
                    waitForLoader();
                    Thread.sleep(3000);
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("Phones_Delete");
        System.out.println("Exit Phones Delete: " + new Date());
    }

    @DataProvider(name = "phonesCreateData")
    private Object[][] phonesCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreatePhones");
    }

    @DataProvider(name = "phonesUpdateData")
    private Object[][] phonesUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdatePhones");
    }

    @DataProvider(name = "phonesDeleteData")
    private Object[][] phonesDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeletePhones");
    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Profile_Phones.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();

        String[][] PhonesData = new String[rowcount + 1][4];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);

            PhonesData[i][0] = row.getCell(0).getStringCellValue();
            PhonesData[i][1] = row.getCell(1).getStringCellValue();
            PhonesData[i][2] = row.getCell(2).getStringCellValue();
            PhonesData[i][3] = row.getCell(3).getStringCellValue();
        }
        return new Object[][]{{PhonesData}};
    }
}
