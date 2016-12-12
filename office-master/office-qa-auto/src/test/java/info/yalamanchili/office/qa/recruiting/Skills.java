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
public class Skills extends AbstractOfficeTest {

    @Test(description = "testSkillsSection", groups = "skills", dependsOnGroups = "login", priority = 1)
    public void testSkillsSection() throws InterruptedException, IOException {
        System.out.println("Enter Skills Section: " + new Date());

        driver.findElement(By.xpath("//div[11]/div/div")).click();

        waitForElementXpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[1]/td[1]");
        takeScreenshot("Skills_Section");        
        System.out.println("Exit Skills Section: " + new Date());

    }
    
    @Test(dataProvider = "skillsCreateData", description = "testSkillsCreate", groups = "skills", dependsOnGroups = "login", priority = 2)
    public void testSkillsCreate(String[][] SkillsData) throws InterruptedException, IOException {
        System.out.println("Enter Skills Create: " + new Date());

        for (String[] e : SkillsData) {

            driver.findElement(By.xpath("//div[12]/div/div[4]/div/div/div/div/fieldset/div/button")).click();
            waitForTime(10);

            driver.findElement(By.xpath("//fieldset/div/div/div/table/tbody/tr/td/input")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-Skill_description_TB")).sendKeys(e[1]);

            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
            waitForTime(10);
        }

        waitForElementXpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[1]/td[1]");
        takeScreenshot("Skills_Create");

        System.out.println("Exit Skills Create: " + new Date());
    }

    @Test(description = "testSkillsSearch", groups = "skills", dependsOnGroups = "login", priority = 3)
    public void testSkillsSearch() throws InterruptedException, IOException {
        System.out.println("Enter Skills Search: " + new Date());

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[3]/div/div[1]/div/div/fieldset/div/input")).sendKeys("program");
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[3]/div/div[1]/div/div/fieldset/div/button")).click();
        
        waitForElementXpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[1]/td[1]");
        takeScreenshot("Skills_Search");
        
        System.out.println("Exit Skills Search: " + new Date());

    }

    @Test(dataProvider = "skillsUpdateData", description = "testSkillsUpdate", groups = "skills", dependsOnGroups = "login", priority = 4)
    public void testSkillsUpdate(String[][] SkillsData) throws InterruptedException, IOException {
        System.out.println("Enter Skills Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : SkillsData) {

            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();

                    driver.findElement(By.xpath("//fieldset/div/div/div/table/tbody/tr/td/input")).clear();
                    driver.findElement(By.id("gwt-debug-Skill_description_TB")).clear();
                    
                    driver.findElement(By.xpath("//fieldset/div/div/div/table/tbody/tr/td/input")).sendKeys(e[0]);
                    driver.findElement(By.id("gwt-debug-Skill_description_TB")).sendKeys(e[1]);

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
        takeScreenshot("Skills_Update");
        System.out.println("Exit Skills Update: " + new Date());
    }
    
    
    @Test(dataProvider = "skillsViewData", description = "testSkillsView", groups = "skills", dependsOnGroups = "login", priority = 5)
    public void testSkillsView(String[][] SkillsData) throws InterruptedException, IOException {
        System.out.println("Enter Skills View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : SkillsData) {

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
        takeScreenshot("Skills_View");
        System.out.println("Exit Skills View: " + new Date());
    }

    @Test(dataProvider = "skillsDeleteData", description = "testSkillsDelete", groups = "skills", dependsOnGroups = "login", priority = 6)
    public void testSkillsDelete(String[][] SkillsData) throws InterruptedException, IOException {
        System.out.println("Enter Skills Delete: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : SkillsData) {

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
        takeScreenshot("Skills_Delete");
        System.out.println("Exit Skills Delete: " + new Date());
    }
    
    @DataProvider(name = "skillsCreateData")
    private Object[][] skillsCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("createSkills");

    }

    @DataProvider(name = "skillsUpdateData")
    private Object[][] skillsUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateSkills");

    }
    
    @DataProvider(name = "skillsViewData")
    private Object[][] skillsViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewSkills");

    }
    
    @DataProvider(name = "skillsDeleteData")
    private Object[][] skillsDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeleteSkills");

    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Recruitment_Skills.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();

        String[][] SkillsData = new String[rowcount + 1][2];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);

            SkillsData[i][0] = row.getCell(0).getStringCellValue();
            SkillsData[i][1] = row.getCell(1).getStringCellValue();
        }

        return new Object[][]{{SkillsData}};
    }
}
