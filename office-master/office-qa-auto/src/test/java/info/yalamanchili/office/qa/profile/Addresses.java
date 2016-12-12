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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author joel kolli
 */
public class Addresses extends AbstractOfficeTest {

    @Test(description = "Addresses view", groups = "addresses", dependsOnGroups = "profile", priority = 1)
    public void testViewAddresses() throws InterruptedException, IOException, AWTException {
        System.out.println("Enter Addresses Section: " + new Date());

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        waitForTime(10);

        driver.findElement(By.xpath("//div/div/table[2]/tbody/tr/td/a/table/tbody/tr/td[2]")).click();
        waitForTime(10);
        driver.findElement(By.xpath("html/body/div[4]/div/div/fieldset/div/span/input")).click();
        waitForTime(10);

        robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        waitForTime(10);

        takeScreenshot("Addresses_Section");
        System.out.println("Exit Addresses Section: " + new Date());
    }

    @Test(description = "Addresses Create", dataProvider = "addressesCreateData", groups = "addresses", dependsOnGroups = "profile", priority = 2)
    public void testCreateAddresses(String[][] AddressesData) throws InterruptedException, IOException, AWTException {
        System.out.println("Enter Addresses Create: " + new Date());

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

        for (String[] e : AddressesData) {

            driver.findElement(By.xpath("//td/div/div/fieldset/div/button")).click();
            driver.findElement(By.id("gwt-debug-Address_street1_TB")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-Address_street2_TB")).sendKeys(e[1]);

            driver.findElement(By.id("gwt-debug-Address_zip_TB")).sendKeys(e[2]);

            robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return d.findElement(By.id("gwt-debug-Address_city_TB")).getAttribute("value").length() != 0;
                }
            });

            (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return d.findElement(By.id("gwt-debug-Address_country_LB")).getAttribute("value").length() != 0;
                }
            });

            (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return d.findElement(By.id("gwt-debug-Address_state_LB")).getAttribute("value").length() != 0;
                }
            });

            WebElement element = driver.findElement(By.xpath("//fieldset/div/div/div/table/tbody/tr/td/select"));
            Select addressType = new Select(element);
            addressType.selectByVisibleText(e[6]);

            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
            waitForLoader();
            Thread.sleep(3000);
        }

        takeScreenshot("AddressesTest_Create");
        System.out.println("Exit Addresses Create: " + new Date());
    }

    @Test(description = "Home Addresses Create", dataProvider = "HomeAddressesCreateData", groups = "addresses", dependsOnGroups = "profile", priority = 3)
    public void testCreateHomeAddresses(String[][] AddressesData) throws InterruptedException, IOException, AWTException {
        System.out.println("Enter Home Addresses Create: " + new Date());

        for (String[] e : AddressesData) {

            driver.findElement(By.id("gwt-debug-CL")).click();
            driver.findElement(By.id("gwt-debug-Address_street1_TB")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-Address_street2_TB")).sendKeys(e[1]);
            driver.findElement(By.id("gwt-debug-Address_zip_TB")).sendKeys(e[2]);

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return d.findElement(By.id("gwt-debug-Address_city_TB")).getAttribute("value").length() != 0;
                }
            });

            (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return d.findElement(By.id("gwt-debug-Address_country_LB")).getAttribute("value").length() != 0;
                }
            });

            (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return d.findElement(By.id("gwt-debug-Address_state_LB")).getAttribute("value").length() != 0;
                }
            });

            driver.findElement(By.id("gwt-debug-Address_notifyHealthInsurance_CB-input")).click();
            driver.findElement(By.id("gwt-debug-Address_changeNotes_TB")).sendKeys(e[6]);

            driver.findElement(By.xpath("//div[2]/button")).click();
            waitForLoader();
            Thread.sleep(3000);
        }

        takeScreenshot("AddressesHome_Create");
        System.out.println("Exit Home Addresses Create: " + new Date());
    }

    @Test(description = "Addresses Update", dataProvider = "addressesUpdateData", groups = "addresses", dependsOnGroups = "profile", priority = 4)
    public void testUpdateAddresses(String[][] AddressesData) throws InterruptedException, IOException, AWTException {
        System.out.println("Enter Addresses Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[9]/div/div[4]/div/div/div/div/table[2]/tbody/tr[2]/td/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : AddressesData) {

            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[6])) {
                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();

                    driver.findElement(By.id("gwt-debug-Address_street1_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Address_street2_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Address_zip_TB")).clear();

                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);

                    (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver d) {
                            return d.findElement(By.id("gwt-debug-Address_city_TB")).getAttribute("value").length() == 0;
                        }
                    });

                    (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver d) {
                            return d.findElement(By.id("gwt-debug-Address_country_LB")).getAttribute("value").length() == 6;
                        }
                    });

                    (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver d) {
                            return d.findElement(By.id("gwt-debug-Address_state_LB")).getAttribute("value").length() == 6;
                        }
                    });

                    driver.findElement(By.id("gwt-debug-Address_street1_TB")).sendKeys(e[0]);
                    driver.findElement(By.id("gwt-debug-Address_street2_TB")).sendKeys(e[1]);

                    driver.findElement(By.id("gwt-debug-Address_zip_TB")).sendKeys(e[2]);

                    robot = new Robot();
                    robot.keyPress(KeyEvent.VK_TAB);
                    robot.keyRelease(KeyEvent.VK_TAB);

                    (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver d) {
                            return d.findElement(By.id("gwt-debug-Address_city_TB")).getAttribute("value").length() != 0;
                        }
                    });

                    (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver d) {
                            return d.findElement(By.id("gwt-debug-Address_country_LB")).getAttribute("value").length() != 0;
                        }
                    });

                    (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver d) {
                            return d.findElement(By.id("gwt-debug-Address_state_LB")).getAttribute("value").length() != 0;
                        }
                    });

                    WebElement element = driver.findElement(By.xpath("//fieldset/div/div/div/table/tbody/tr/td/select"));
                    Select addressType = new Select(element);
                    addressType.selectByVisibleText(e[6]);

                    driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-updateB")).click();
                    j = 2;
                    matchFound = true;
                    waitForLoader();
                    Thread.sleep(3000);
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("Addresses_Update");
        System.out.println("Exit Addresses Update: " + new Date());
    }

    @Test(dataProvider = "addressesViewData", description = "testAddressesView", groups = "addresses", dependsOnGroups = "profile", priority = 5)
    public void testAddressesView(String[][] AddressesData) throws InterruptedException, IOException {
        System.out.println("Enter Addresses View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[9]/div/div[4]/div/div/div/div/table[2]/tbody/tr[2]/td/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : AddressesData) {
            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[6])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[1]/img")).click();

                    j = 2;
                    matchFound = true;
                    waitForLoader();
                    Thread.sleep(3000);
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("Addresses_View");
        System.out.println("Exit Addresses View: " + new Date());
    }

    @Test(dataProvider = "addressesDeleteData", description = "testAddressesDelete", groups = "addresses", dependsOnGroups = "profile", priority = 6)
    public void testAddressesDelete(String[][] AddressesData) throws InterruptedException, IOException {
        System.out.println("Enter Addresses Delete: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[9]/div/div[4]/div/div/div/div/table[2]/tbody/tr[2]/td/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : AddressesData) {
            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[6])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[3]/img")).click();
                    Alert alt = driver.switchTo().alert();
                    alt.accept();

                    j = 2;
                    matchFound = true;
                    waitForLoader();
                    Thread.sleep(3000);
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("Addresses_Delete");
        System.out.println("Exit Addresses Delete: " + new Date());
    }

    @DataProvider(name = "addressesCreateData")
    private Object[][] addressesCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateAddresses");
    }

    @DataProvider(name = "HomeAddressesCreateData")
    private Object[][] HomeAddressesCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateHomeAddresses");
    }

    @DataProvider(name = "addressesUpdateData")
    private Object[][] addressesUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateAddresses");
    }

    @DataProvider(name = "addressesViewData")
    private Object[][] addressesViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewAddresses");
    }

    @DataProvider(name = "addressesDeleteData")
    private Object[][] addressesDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeleteAddresses");
    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Profile_Addresses.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();

        String[][] AddressesData = new String[rowcount + 1][7];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);

            AddressesData[i][0] = row.getCell(0).getStringCellValue();
            AddressesData[i][1] = row.getCell(1).getStringCellValue();
            AddressesData[i][2] = row.getCell(2).getStringCellValue();
            AddressesData[i][3] = row.getCell(3).getStringCellValue();
            AddressesData[i][4] = row.getCell(4).getStringCellValue();
            AddressesData[i][5] = row.getCell(5).getStringCellValue();
            AddressesData[i][6] = row.getCell(6).getStringCellValue();
        }
        return new Object[][]{{AddressesData}};
    }
}
