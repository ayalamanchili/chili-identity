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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Joel.Kolli
 */
public class Externalrefs extends AbstractOfficeTest {

    @Test(description = "testExternalrefsSection", groups = "externalrefs", dependsOnGroups = "question", priority = 1)
    public void testExternalrefsSection() throws InterruptedException, IOException {
        System.out.println("Enter Externalrefs Section: " + new Date());

        driver.findElement(By.xpath("//div[9]/div/div")).click();
        waitForTime(10);
        driver.findElement(By.id("External Refs")).click();

        waitForLoader();
        takeScreenshot("Externalrefs_Section");
        System.out.println("Exit Externalrefs Section: " + new Date());
    }

    @Test(description = "testExternalrefsCreate", dataProvider = "externalrefsCreateData", groups = "externalrefs", dependsOnGroups = "question", priority = 2)
    public void testExternalrefsCreate(String[][] ExternalrefsData) throws InterruptedException, IOException {
        System.out.println("Enter Externalrefs Create: " + new Date());

        for (String[] e : ExternalrefsData) {

            driver.findElement(By.xpath("//div[10]/div/div[4]/div/div/div/div/fieldset/div/button")).click();
            waitForTime(10);

            driver.findElement(By.id("gwt-debug-ExternalReferences_source_TB")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-ExternalReferences_externalId_TB")).sendKeys(e[1]);
            driver.findElement(By.id("gwt-debug-ExternalReferences_targetEntityName_TB")).sendKeys(e[2]);
            driver.findElement(By.id("gwt-debug-ExternalReferences_targetEntityId_TB")).sendKeys(e[3]);

            driver.findElement(By.xpath("//div[2]/button")).click();
            waitForLoader();
        }

        takeScreenshot("Externalrefs_Create");
        System.out.println("Exit Externalrefs Create: " + new Date());
    }

    @Test(dataProvider = "externalrefsUpdateData", description = "testExternalrefsUpdate", groups = "externalrefs", dependsOnGroups = "question", priority = 3)
    public void testExternalrefsUpdate(String[][] ExternalrefsData) throws InterruptedException, IOException {
        System.out.println("Enter Externalrefs Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[10]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : ExternalrefsData) {

            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();
                    
                    driver.findElement(By.id("gwt-debug-ExternalReferences_source_TB")).clear();
                    driver.findElement(By.id("gwt-debug-ExternalReferences_externalId_TB")).clear();
                    driver.findElement(By.id("gwt-debug-ExternalReferences_targetEntityName_TB")).clear();
                    driver.findElement(By.id("gwt-debug-ExternalReferences_targetEntityId_TB")).clear();
                    
                    driver.findElement(By.id("gwt-debug-ExternalReferences_source_TB")).sendKeys(e[0]);
                    driver.findElement(By.id("gwt-debug-ExternalReferences_externalId_TB")).sendKeys(e[1]);
                    driver.findElement(By.id("gwt-debug-ExternalReferences_targetEntityName_TB")).sendKeys(e[2]);
                    driver.findElement(By.id("gwt-debug-ExternalReferences_targetEntityId_TB")).sendKeys(e[3]);
                    
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
        takeScreenshot("Externalrefs_Update");
        System.out.println("Exit Externalrefs Update: " + new Date());
    }

    @Test(description = "testExternalrefsView", dataProvider = "externalrefsViewData", groups = "externalrefs", dependsOnGroups = "question", priority = 4)
    public void testExternalrefsView(String[][] ExternalrefsData) throws InterruptedException, IOException {
        System.out.println("Enter Externalrefs View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[10]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : ExternalrefsData) {

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

        takeScreenshot("Externalrefs_View");
        driver.findElement(By.id("External Refs")).click();
        System.out.println("Exit Externalrefs View: " + new Date());
    }
    
    @Test(description = "testExternalrefsSearch", dataProvider = "externalrefsViewData", groups = "externalrefs", dependsOnGroups = "question", priority = 5)
    public void testExternalrefsSearch(String[][] ExternalrefsData) throws InterruptedException, IOException {
        System.out.println("Enter Externalrefs Search: " + new Date());

        for (String[] e : ExternalrefsData) {
            driver.findElement(By.xpath("//div[10]/div/div[3]/div/div/div/div/fieldset/div/table/tbody/tr/td/a/table/tbody/tr/td[2]")).click();
            
            driver.findElement(By.id("gwt-debug-ExternalRef_source_TB")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-ExternalRef_externalId_TB")).sendKeys(e[1]);
            driver.findElement(By.id("gwt-debug-ExternalRef_targetEntityName_TB")).sendKeys(e[2]);
            driver.findElement(By.id("gwt-debug-ExternalRef_targetEntityId_TB")).sendKeys(e[3]);
            
            driver.findElement(By.xpath("//div[10]/div/div[3]/div/div/div/div/fieldset/div/button")).click();
            waitForLoader();
            takeScreenshot("Externalrefs_Search");
            }
        
        driver.findElement(By.id("External Refs")).click();
        System.out.println("Exit Externalrefs Search: " + new Date());
    }
    
    @Test(description = "testExternalrefsDelete", dataProvider = "externalrefsDeleteData", groups = "externalrefs", dependsOnGroups = "question", priority = 6)
    public void testExternalrefsDelete(String[][] ExternalrefsData) throws InterruptedException, IOException {
        System.out.println("Enter Externalrefs Delete: " + new Date());
        
        driver.findElement(By.id("External Refs")).click();
        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[10]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : ExternalrefsData) {

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
        takeScreenshot("Externalrefs_Delete");
        System.out.println("Exit Externalrefs Delete: " + new Date());
    }

    @DataProvider(name = "externalrefsCreateData")
    private Object[][] externalrefsCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateExternalrefs");

    }

    @DataProvider(name = "externalrefsUpdateData")
    private Object[][] externalrefsUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateExternalrefs");

    }
    
    @DataProvider(name = "externalrefsViewData")
    private Object[][] externalrefsViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewExternalrefs");
    }

    @DataProvider(name = "externalrefsDeleteData")
    private Object[][] externalrefsDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeleteExternalrefs");

    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Admin_Externalrefs.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();

        String[][] ExternalrefsData = new String[rowcount + 1][4];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);

            ExternalrefsData[i][0] = row.getCell(0).getStringCellValue();
            ExternalrefsData[i][1] = row.getCell(1).getStringCellValue();
            ExternalrefsData[i][2] = row.getCell(2).getStringCellValue();
            ExternalrefsData[i][3] = row.getCell(3).getStringCellValue();

        }

        return new Object[][]{{ExternalrefsData}};
    }
}