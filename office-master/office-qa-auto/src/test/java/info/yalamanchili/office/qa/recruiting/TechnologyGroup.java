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
public class TechnologyGroup extends AbstractOfficeTest {

    @Test(description = "testTechnologyGroupSection", groups = "technologyGroup", dependsOnGroups = "practice", priority = 1)
    public void testTechnologyGroupSection() throws InterruptedException, IOException {
        System.out.println("Enter TechnologyGroup Section: " + new Date());

        driver.findElement(By.id("TechnologyGroup")).click();

        waitForElementXpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[1]/td[1]");
        takeScreenshot("TechnologyGroup_Section");        
        System.out.println("Exit TechnologyGroup Section: " + new Date());

    }
    
    @Test(dataProvider = "technologyGroupCreateData", description = "testTechnologyGroupCreate", groups = "technologyGroup", dependsOnGroups = "practice", priority = 2)
    public void testTechnologyGroupCreate(String[][] TechnologyGroupData) throws InterruptedException, IOException {
        System.out.println("Enter TechnologyGroup Create: " + new Date());

        for (String[] e : TechnologyGroupData) {

            driver.findElement(By.xpath("//div[12]/div/div[4]/div/div/div/div/fieldset/div/button")).click();
            waitForTime(10);

            driver.findElement(By.xpath("//fieldset/div/div/div/table/tbody/tr/td/input")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-TechnologyGroup_description_TB")).sendKeys(e[1]);

            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
            waitForTime(10);
        }

        waitForElementXpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[1]/td[1]");
        takeScreenshot("TechnologyGroup_Create");

        System.out.println("Exit TechnologyGroup Create: " + new Date());
    }

    @Test(description = "testTechnologyGroupSearch", groups = "technologyGroup", dependsOnGroups = "practice", priority = 3, enabled=false)
    public void testTechnologyGroupSearch() throws InterruptedException, IOException {
        System.out.println("Enter TechnologyGroup Search: " + new Date());

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[3]/div/div[1]/div/div/fieldset/div/input")).sendKeys("program");
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[3]/div/div[1]/div/div/fieldset/div/button")).click();
        
        waitForElementXpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[1]/td[1]");
        takeScreenshot("TechnologyGroup_Search");
        
        System.out.println("Exit TechnologyGroup Search: " + new Date());

    }

    @Test(dataProvider = "technologyGroupUpdateData", description = "testTechnologyGroupUpdate", groups = "technologyGroup", dependsOnGroups = "practice", priority = 4)
    public void testTechnologyGroupUpdate(String[][] TechnologyGroupData) throws InterruptedException, IOException {
        System.out.println("Enter TechnologyGroup Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : TechnologyGroupData) {

            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();

                    driver.findElement(By.xpath("//fieldset/div/div/div/table/tbody/tr/td/input")).clear();
                    driver.findElement(By.id("gwt-debug-TechnologyGroup_description_TB")).clear();
                    
                    driver.findElement(By.xpath("//fieldset/div/div/div/table/tbody/tr/td/input")).sendKeys(e[0]);
                    driver.findElement(By.id("gwt-debug-TechnologyGroup_description_TB")).sendKeys(e[1]);

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
        takeScreenshot("TechnologyGroup_Update");
        System.out.println("Exit TechnologyGroup Update: " + new Date());
    }
    
    
    @Test(dataProvider = "technologyGroupViewData", description = "testTechnologyGroupView", groups = "technologyGroup", dependsOnGroups = "practice", priority = 5)
    public void testTechnologyGroupView(String[][] TechnologyGroupData) throws InterruptedException, IOException {
        System.out.println("Enter TechnologyGroup View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : TechnologyGroupData) {

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
        takeScreenshot("TechnologyGroup_View");
        System.out.println("Exit TechnologyGroup View: " + new Date());
    }

    @Test(dataProvider = "technologyGroupDeleteData", description = "testTechnologyGroupDelete", groups = "technologyGroup", dependsOnGroups = "practice", priority = 6)
    public void testTechnologyGroupDelete(String[][] TechnologyGroupData) throws InterruptedException, IOException {
        System.out.println("Enter TechnologyGroup Delete: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : TechnologyGroupData) {

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
        takeScreenshot("TechnologyGroup_Delete");
        System.out.println("Exit TechnologyGroup Delete: " + new Date());
    }
    
    @DataProvider(name = "technologyGroupCreateData")
    private Object[][] technologyGroupCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("createTechnologyGroup");

    }

    @DataProvider(name = "technologyGroupUpdateData")
    private Object[][] technologyGroupUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateTechnologyGroup");

    }
    
    @DataProvider(name = "technologyGroupViewData")
    private Object[][] technologyGroupViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewTechnologyGroup");

    }
    
    @DataProvider(name = "technologyGroupDeleteData")
    private Object[][] technologyGroupDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeleteTechnologyGroup");

    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Recruitment_TechnologyGroup.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();

        String[][] TechnologyGroupData = new String[rowcount + 1][2];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);

            TechnologyGroupData[i][0] = row.getCell(0).getStringCellValue();
            TechnologyGroupData[i][1] = row.getCell(1).getStringCellValue();
        }

        return new Object[][]{{TechnologyGroupData}};
    }
}