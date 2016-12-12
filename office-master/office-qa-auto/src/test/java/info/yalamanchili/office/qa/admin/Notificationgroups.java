/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa.admin;

import info.yalamanchili.office.qa.AbstractOfficeTest;
import static info.yalamanchili.office.qa.AbstractOfficeTest.driver;
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
 * @author Joel.Kolli
 */
public class Notificationgroups extends AbstractOfficeTest {

    @Test(description = "testNotificationgroupsSection", groups = "notificationgroups", dependsOnGroups = "subcontractors", priority = 1)
    public void testNotificationgroupsSection() throws InterruptedException, IOException {
        System.out.println("Enter Notificationgroups Section: " + new Date());

        driver.findElement(By.xpath("//div[9]/div/div")).click();
        waitForTime(10);
        driver.findElement(By.id("Notification Groups")).click();

        waitForLoader();
        takeScreenshot("Notificationgroups_Section");
        System.out.println("Exit Notificationgroups Section: " + new Date());

    }

    @Test(description = "testNotificationgroupsCreate", dataProvider = "notificationgroupsCreateData", groups = "notificationgroups", dependsOnGroups = "subcontractors", priority = 2)
    public void testNotificationgroupsCreate(String[][] NotificationgroupsData) throws InterruptedException, IOException {
        System.out.println("Enter Notificationgroups Create: " + new Date());

        for (String[] e : NotificationgroupsData) {

            driver.findElement(By.xpath("//div[10]/div/div[4]/div/div/div/div/fieldset/div/button")).click();
            waitForTime(10);

            driver.findElement(By.id("gwt-debug-NotificationGroup_name_TB")).sendKeys(e[0]);
            WebElement element = driver.findElement(By.xpath("//tr[2]/td/select"));
            Select category = new Select(element);
            category.selectByValue(e[1]);

            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-multipleSelectWidget-selectButton")).click();
            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
            waitForTime(10);
        }

        waitForLoader();
        takeScreenshot("Notificationgroups_Create");

        System.out.println("Exit Notificationgroups Create: " + new Date());
    }

    @Test(dataProvider = "notificationgroupsUpdateData", description = "testNotificationgroupsUpdate", groups = "notificationgroups", dependsOnGroups = "subcontractors", priority = 3)
    public void testNotificationgroupsUpdate(String[][] NotificationgroupsData) throws InterruptedException, IOException {
        System.out.println("Enter Notificationgroups Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[10]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : NotificationgroupsData) {

            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();
                    
                    driver.findElement(By.id("gwt-debug-NotificationGroup_name_TB")).clear();
                    WebElement element = driver.findElement(By.xpath("//table[2]/tbody/tr[2]/td/select"));
                    Select removeuser = new Select(element);
                    removeuser.selectByValue(e[1]);
                    driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-multipleSelectWidget-unselectButton")).click();
                    
                    driver.findElement(By.id("gwt-debug-NotificationGroup_name_TB")).sendKeys(e[0]);
                    element = driver.findElement(By.xpath("//tr[2]/td/select"));
                    Select adduser = new Select(element);
                    adduser.selectByValue(e[2]);
                    driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-multipleSelectWidget-selectButton")).click();
                    driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-updateB")).click();
                    waitForTime(10);

                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        waitForLoader();
        takeScreenshot("Notificationgroups_Update");
        System.out.println("Exit Notificationgroups Update: " + new Date());
    }

    @Test(description = "testNotificationgroupsView", dataProvider = "notificationgroupsViewData", groups = "notificationgroups", dependsOnGroups = "subcontractors", priority = 4)
    public void testNotificationgroupsView(String[][] NotificationgroupsData) throws InterruptedException, IOException {
        System.out.println("Enter Notificationgroups View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[10]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : NotificationgroupsData) {

            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[1]/img")).click();
                    waitForTime(10);
                    j = 2;
                    matchFound = true;

                } else {
                    i++;

                }
            }
        }

        takeScreenshot("Notificationgroups_View");
        driver.findElement(By.id("Notification Groups")).click();
        System.out.println("Exit Notificationgroups View: " + new Date());
    }
    
    @Test(description = "testNotificationgroupsDelete", dataProvider = "notificationgroupsDeleteData", groups = "notificationgroups", dependsOnGroups = "subcontractors", priority = 5)
    public void testNotificationgroupsDelete(String[][] NotificationgroupsData) throws InterruptedException, IOException {
        System.out.println("Enter Notificationgroups Delete: " + new Date());
        
        driver.findElement(By.id("Notification Groups")).click();
        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[10]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : NotificationgroupsData) {

            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[3]/img")).click();

                    Alert alt = driver.switchTo().alert();
                    alt.accept();

                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        waitForLoader();
        takeScreenshot("Notificationgroups_Delete");
        System.out.println("Exit Notificationgroups Delete: " + new Date());
    }

    @DataProvider(name = "notificationgroupsCreateData")
    private Object[][] notificationgroupsCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateNotificationgroups");

    }

    @DataProvider(name = "notificationgroupsUpdateData")
    private Object[][] notificationgroupsUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateNotificationgroups");

    }
    
    @DataProvider(name = "notificationgroupsViewData")
    private Object[][] notificationgroupsViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewNotificationgroups");
    }

    @DataProvider(name = "notificationgroupsDeleteData")
    private Object[][] notificationgroupsDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeleteNotificationgroups");

    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Admin_Notificationgroups.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();

        String[][] NotificationgroupsData = new String[rowcount + 1][3];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);

            NotificationgroupsData[i][0] = row.getCell(0).getStringCellValue();
            NotificationgroupsData[i][1] = row.getCell(1).getStringCellValue();
            NotificationgroupsData[i][2] = row.getCell(2).getStringCellValue();

        }

        return new Object[][]{{NotificationgroupsData}};
    }
}