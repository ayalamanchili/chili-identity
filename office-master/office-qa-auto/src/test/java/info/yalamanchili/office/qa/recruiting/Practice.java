/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa.recruiting;

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
public class Practice extends AbstractOfficeTest {

    @Test(description = "testPracticeSection", groups = "practice", dependsOnGroups = "certifications", priority = 1)
    public void testPracticeSection() throws InterruptedException, IOException {
        System.out.println("Enter Practice Section: " + new Date());

        driver.findElement(By.id("Practice")).click();

        waitForElementXpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[1]/td[1]");
        takeScreenshot("Practice_Section");        
        System.out.println("Exit Practice Section: " + new Date());

    }
    
    @Test(dataProvider = "practiceCreateData", description = "testPracticeCreate", groups = "practice", dependsOnGroups = "certifications", priority = 2)
    public void testPracticeCreate(String[][] PracticeData) throws InterruptedException, IOException {
        System.out.println("Enter Practice Create: " + new Date());

        for (String[] e : PracticeData) {

            driver.findElement(By.xpath("//div[12]/div/div[4]/div/div/div/div/fieldset/div/button")).click();
            waitForTime(10);

            driver.findElement(By.xpath("//fieldset/div/div/div/table/tbody/tr/td/input")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-Practice_description_TB")).sendKeys(e[1]);

            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
            waitForTime(10);
        }

        waitForElementXpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[1]/td[1]");
        takeScreenshot("Practice_Create");

        System.out.println("Exit Practice Create: " + new Date());
    }

    @Test(description = "testPracticeSearch", groups = "practice", dependsOnGroups = "certifications", priority = 3, enabled=false)
    public void testPracticeSearch() throws InterruptedException, IOException {
        System.out.println("Enter Practice Search: " + new Date());

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[3]/div/div[1]/div/div/fieldset/div/input")).sendKeys("program");
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[3]/div/div[1]/div/div/fieldset/div/button")).click();
        
        waitForElementXpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[1]/td[1]");
        takeScreenshot("Practice_Search");
        
        System.out.println("Exit Practice Search: " + new Date());

    }

    @Test(dataProvider = "practiceUpdateData", description = "testPracticeUpdate", groups = "practice", dependsOnGroups = "certifications", priority = 4)
    public void testPracticeUpdate(String[][] PracticeData) throws InterruptedException, IOException {
        System.out.println("Enter Practice Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : PracticeData) {

            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();

                    driver.findElement(By.xpath("//fieldset/div/div/div/table/tbody/tr/td/input")).clear();
                    driver.findElement(By.id("gwt-debug-Practice_description_TB")).clear();
                    
                    driver.findElement(By.xpath("//fieldset/div/div/div/table/tbody/tr/td/input")).sendKeys(e[0]);
                    driver.findElement(By.id("gwt-debug-Practice_description_TB")).sendKeys(e[1]);

                    driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-updateB")).click();

                    waitForTime(10);

                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        waitForElementXpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[1]/td[1]");
        takeScreenshot("Practice_Update");
        System.out.println("Exit Practice Update: " + new Date());
    }
    
    
    @Test(dataProvider = "practiceViewData", description = "testPracticeView", groups = "practice", dependsOnGroups = "certifications", priority = 5)
    public void testPracticeView(String[][] PracticeData) throws InterruptedException, IOException {
        System.out.println("Enter Practice View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : PracticeData) {

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
        
        waitForElementXpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[1]/td[1]");
        takeScreenshot("Practice_View");
        System.out.println("Exit Practice View: " + new Date());
    }

    @Test(dataProvider = "practiceDeleteData", description = "testPracticeDelete", groups = "practice", dependsOnGroups = "certifications", priority = 6)
    public void testPracticeDelete(String[][] PracticeData) throws InterruptedException, IOException {
        System.out.println("Enter Practice Delete: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : PracticeData) {

            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[3]/img")).click();

                    Alert alt = driver.switchTo().alert();
                    alt.accept();

                    waitForStaleness(driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[1]/td[1]")));
             
                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }
        
        waitForElementXpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[1]/td[1]");
        takeScreenshot("Practice_Delete");
        System.out.println("Exit Practice Delete: " + new Date());
    }
    
    @DataProvider(name = "practiceCreateData")
    private Object[][] practiceCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("createPractice");

    }

    @DataProvider(name = "practiceUpdateData")
    private Object[][] practiceUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdatePractice");

    }
    
    @DataProvider(name = "practiceViewData")
    private Object[][] practiceViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewPractice");

    }
    
    @DataProvider(name = "practiceDeleteData")
    private Object[][] practiceDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeletePractice");

    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Recruitment_Practice.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();

        String[][] PracticeData = new String[rowcount + 1][2];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);

            PracticeData[i][0] = row.getCell(0).getStringCellValue();
            PracticeData[i][1] = row.getCell(1).getStringCellValue();
        }

        return new Object[][]{{PracticeData}};
    }
}