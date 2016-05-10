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
public class SkillSetTags extends AbstractOfficeTest {

    @Test(description = "testSkillSetTagsSection", groups = "skillSetTags", dependsOnGroups = "technologyGroup", priority = 1)
    public void testSkillSetTagsSection() throws InterruptedException, IOException {
        System.out.println("Enter SkillSetTags Section: " + new Date());

        driver.findElement(By.id("SkillSet Tags")).click();

        waitForElementXpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[1]/td[1]");
        takeScreenshot("SkillSetTags_Section");        
        System.out.println("Exit SkillSetTags Section: " + new Date());

    }
    
    @Test(dataProvider = "skillSetTagsCreateData", description = "testSkillSetTagsCreate", groups = "skillSetTags", dependsOnGroups = "technologyGroup", priority = 2)
    public void testSkillSetTagsCreate(String[][] SkillSetTagsData) throws InterruptedException, IOException {
        System.out.println("Enter SkillSetTags Create: " + new Date());

        for (String[] e : SkillSetTagsData) {

            driver.findElement(By.xpath("//div[12]/div/div[4]/div/div/div/div/fieldset/div/button")).click();
            waitForTime(10);

            driver.findElement(By.xpath("//fieldset/div/div/div/table/tbody/tr/td/input")).sendKeys(e[0]);

            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
            waitForTime(10);
        }

        waitForElementXpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[1]/td[1]");
        takeScreenshot("SkillSetTags_Create");

        System.out.println("Exit SkillSetTags Create: " + new Date());
    }

    @Test(description = "testSkillSetTagsSearch", groups = "skillSetTags", dependsOnGroups = "technologyGroup", priority = 3, enabled=false)
    public void testSkillSetTagsSearch() throws InterruptedException, IOException {
        System.out.println("Enter SkillSetTags Search: " + new Date());

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[3]/div/div[1]/div/div/fieldset/div/input")).sendKeys("program");
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[3]/div/div[1]/div/div/fieldset/div/button")).click();
        
        waitForElementXpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[1]/td[1]");
        takeScreenshot("SkillSetTags_Search");
        
        System.out.println("Exit SkillSetTags Search: " + new Date());

    }

    @Test(dataProvider = "skillSetTagsUpdateData", description = "testSkillSetTagsUpdate", groups = "skillSetTags", dependsOnGroups = "technologyGroup", priority = 4)
    public void testSkillSetTagsUpdate(String[][] SkillSetTagsData) throws InterruptedException, IOException {
        System.out.println("Enter SkillSetTags Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : SkillSetTagsData) {

            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[1]/img")).click();

                    driver.findElement(By.xpath("//fieldset/div/div/div/table/tbody/tr/td/input")).clear();
                    
                    driver.findElement(By.xpath("//fieldset/div/div/div/table/tbody/tr/td/input")).sendKeys(e[1]);
                    
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
        takeScreenshot("SkillSetTags_Update");
        System.out.println("Exit SkillSetTags Update: " + new Date());
    }
    
    
    @Test(dataProvider = "skillSetTagsViewData", description = "testSkillSetTagsView", groups = "skillSetTags", dependsOnGroups = "technologyGroup", priority = 5, enabled=false)
    public void testSkillSetTagsView(String[][] SkillSetTagsData) throws InterruptedException, IOException {
        System.out.println("Enter SkillSetTags View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : SkillSetTagsData) {

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
        takeScreenshot("SkillSetTags_View");
        System.out.println("Exit SkillSetTags View: " + new Date());
    }

    @Test(dataProvider = "skillSetTagsDeleteData", description = "testSkillSetTagsDelete", groups = "skillSetTags", dependsOnGroups = "technologyGroup", priority = 6)
    public void testSkillSetTagsDelete(String[][] SkillSetTagsData) throws InterruptedException, IOException {
        System.out.println("Enter SkillSetTags Delete: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : SkillSetTagsData) {

            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();

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
        takeScreenshot("SkillSetTags_Delete");
        System.out.println("Exit SkillSetTags Delete: " + new Date());
    }
    
    @DataProvider(name = "skillSetTagsCreateData")
    private Object[][] skillSetTagsCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("createSkillSetTags");

    }

    @DataProvider(name = "skillSetTagsUpdateData")
    private Object[][] skillSetTagsUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateSkillSetTags");

    }
    
    @DataProvider(name = "skillSetTagsViewData")
    private Object[][] skillSetTagsViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewSkillSetTags");

    }
    
    @DataProvider(name = "skillSetTagsDeleteData")
    private Object[][] skillSetTagsDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeleteSkillSetTags");

    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Recruitment_SkillSetTags.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();

        String[][] SkillSetTagsData = new String[rowcount + 1][2];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);

            SkillSetTagsData[i][0] = row.getCell(0).getStringCellValue();
            SkillSetTagsData[i][1] = row.getCell(1).getStringCellValue();
        }

        return new Object[][]{{SkillSetTagsData}};
    }
}