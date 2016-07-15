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
public class Dependents extends AbstractOfficeTest {

    @Test(description = "Dependents view", groups = "dependents", dependsOnGroups = "emergencyContacts", priority = 1)
    public void testViewDependents() throws InterruptedException, IOException, AWTException {
        System.out.println("Enter Dependents Section: " + new Date());

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

        driver.findElement(By.xpath("//table[7]/tbody/tr/td/a/table/tbody/tr/td[2]")).click();
        waitForLoader();

        robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

        takeScreenshot("Dependents_Section");
        System.out.println("Exit Dependents Section: " + new Date());
    }

    @Test(description = "Dependents Create", dataProvider = "dependentsCreateData", groups = "dependents", dependsOnGroups = "emergencyContacts", priority = 2)
    public void testCreateDependents(String[][] DependentsData) throws InterruptedException, IOException, AWTException {
        System.out.println("Enter Dependents Create: " + new Date());

        for (String[] e : DependentsData) {

            driver.findElement(By.xpath("//table[7]/tbody/tr[2]/td/div/div/fieldset/div/button")).click();
            driver.findElement(By.id("gwt-debug-Dependent_dfirstName_TB")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-Dependent_dlastName_TB")).sendKeys(e[1]);
            driver.findElement(By.id("gwt-debug-Dependent_ddateOfBirth_TB")).sendKeys(e[2]);
            WebElement element = driver.findElement(By.id("gwt-debug-Dependent_relationship_LB"));
            Select relationship = new Select(element);
            relationship.selectByValue(e[3]);

            driver.findElement(By.xpath("//div[2]/button")).click();
            waitForLoader();
            Thread.sleep(3000);
        }

        takeScreenshot("DependentsTest_Create");
        System.out.println("Exit Dependents Create: " + new Date());
    }

    @Test(description = "Dependents Update", dataProvider = "dependentsUpdateData", groups = "dependents", dependsOnGroups = "emergencyContacts", priority = 3)
    public void testUpdateDependents(String[][] DependentsData) throws InterruptedException, IOException {
        System.out.println("Enter Dependents Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[9]/div/div[4]/div/div/div/div/table[7]/tbody/tr[2]/td/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : DependentsData) {

            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();

                    driver.findElement(By.id("gwt-debug-Dependent_dfirstName_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Dependent_dlastName_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Dependent_ddateOfBirth_TB")).clear();

                    driver.findElement(By.id("gwt-debug-Dependent_dfirstName_TB")).sendKeys(e[0]);
                    driver.findElement(By.id("gwt-debug-Dependent_dlastName_TB")).sendKeys(e[1]);
                    driver.findElement(By.id("gwt-debug-Dependent_ddateOfBirth_TB")).sendKeys(e[2]);
                    WebElement element = driver.findElement(By.id("gwt-debug-Dependent_relationship_LB"));
                    Select relationship = new Select(element);
                    relationship.selectByValue(e[3]);

                    driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-updateB")).click();
                    j = 2;
                    matchFound = true;
                    waitForLoader();
                    fluentWaitForElementXpath("//table[7]/tbody/tr[2]/td/div/div/fieldset/div/button");
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("Dependents_Update");
        System.out.println("Exit Dependents Update: " + new Date());
    }

    @Test(dataProvider = "dependentsViewData", description = "testDependentsView", groups = "dependents", dependsOnGroups = "emergencyContacts", priority = 4)
    public void testDependentsView(String[][] DependentsData) throws InterruptedException, IOException {
        System.out.println("Enter Dependents View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[9]/div/div[4]/div/div/div/div/table[7]/tbody/tr[2]/td/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : DependentsData) {
            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[1]/img")).click();

                    j = 2;
                    matchFound = true;
                    waitForLoader();
                    fluentWaitForElementXpath("//table[7]/tbody/tr[2]/td/div/div/fieldset/div/button");
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("Dependents_View");
        System.out.println("Exit Dependents View: " + new Date());
    }

    @Test(dataProvider = "dependentsDeleteData", description = "testDependentsDelete", groups = "dependents", dependsOnGroups = "emergencyContacts", priority = 5)
    public void testDependentsDelete(String[][] DependentsData) throws InterruptedException, IOException {
        System.out.println("Enter Dependents Delete: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[9]/div/div[4]/div/div/div/div/table[7]/tbody/tr[2]/td/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : DependentsData) {
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
                    waitForLoader();
                    fluentWaitForElementXpath("//table[7]/tbody/tr[2]/td/div/div/fieldset/div/button");
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("Dependents_Delete");
        System.out.println("Exit Dependents Delete: " + new Date());
    }

    @DataProvider(name = "dependentsCreateData")
    private Object[][] dependentsCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateDependents");
    }

    @DataProvider(name = "dependentsUpdateData")
    private Object[][] dependentsUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateDependents");
    }

    @DataProvider(name = "dependentsViewData")
    private Object[][] dependentsViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewDependents");
    }

    @DataProvider(name = "dependentsDeleteData")
    private Object[][] dependentsDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeleteDependents");
    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Profile_Dependents.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();

        String[][] DependentsData = new String[rowcount + 1][4];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);

            DependentsData[i][0] = row.getCell(0).getStringCellValue();
            DependentsData[i][1] = row.getCell(1).getStringCellValue();
            DependentsData[i][2] = row.getCell(2).getStringCellValue();
            DependentsData[i][3] = row.getCell(3).getStringCellValue();

        }
        return new Object[][]{{DependentsData}};
    }
}
