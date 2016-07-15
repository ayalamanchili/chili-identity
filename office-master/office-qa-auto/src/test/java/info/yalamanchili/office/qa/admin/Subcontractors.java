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
public class Subcontractors extends AbstractOfficeTest {

    @Test(description = "testSubcontractorsSection", groups = "subcontractors", dependsOnGroups = "vendors", priority = 1)
    public void testSubcontractorsSection() throws InterruptedException, IOException {
        System.out.println("Enter Subcontractors Section: " + new Date());

        driver.findElement(By.xpath("//div[9]/div/div")).click();
        waitForTime(10);
        driver.findElement(By.id("Subcontractors")).click();

        waitForLoader();
        Thread.sleep(3000);
        takeScreenshot("Subcontractors_Section");
        System.out.println("Exit Subcontractors Section: " + new Date());

    }

    @Test(description = "testSubcontractorsCreate", dataProvider = "subcontractorsCreateData", groups = "subcontractors", dependsOnGroups = "vendors", priority = 2)
    public void testSubcontractorsCreate(String[][] SubcontractorsData) throws InterruptedException, IOException {
        System.out.println("Enter Subcontractors Create: " + new Date());

        for (String[] e : SubcontractorsData) {
            
            driver.findElement(By.xpath("//div[10]/div/div[4]/div/div/div/div/fieldset/div/button")).click();
            waitForTime(10);

            driver.findElement(By.xpath("//fieldset/div/div/div/table/tbody/tr/td/input")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-Subcontractor_description_TB")).sendKeys(e[1]);
            driver.findElement(By.id("gwt-debug-Subcontractor_website_TB")).sendKeys(e[2]);
            driver.findElement(By.id("gwt-debug-Subcontractor_coiEndDate_TB")).sendKeys(e[3]);
            
            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
            WebElement element = driver.findElement(By.id("Subcontractors"));
            waitForStaleness(element);
            driver.findElement(By.id("Subcontractors")).click();
            
            waitForLoader();
        }
        
        takeScreenshot("Subcontractors_Create");
        System.out.println("Exit Subcontractors Create: " + new Date());
    }

    @Test(dataProvider = "subcontractorsUpdateData", description = "testSubcontractorsUpdate", groups = "subcontractors", dependsOnGroups = "vendors", priority = 3)
    public void testSubcontractorsUpdate(String[][] SubcontractorsData) throws InterruptedException, IOException {
        System.out.println("Enter Subcontractors Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[10]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : SubcontractorsData) {

            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();
                    
                    driver.findElement(By.xpath("//fieldset/div/div/div/table/tbody/tr/td/input")).clear();
                    driver.findElement(By.id("gwt-debug-Subcontractor_description_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Subcontractor_website_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Subcontractor_coiEndDate_TB")).clear();
                    
                    
                    driver.findElement(By.xpath("//fieldset/div/div/div/table/tbody/tr/td/input")).sendKeys(e[0]);
                    driver.findElement(By.id("gwt-debug-Subcontractor_description_TB")).sendKeys(e[1]);
                    driver.findElement(By.id("gwt-debug-Subcontractor_website_TB")).sendKeys(e[2]);
                    driver.findElement(By.id("gwt-debug-Subcontractor_coiEndDate_TB")).sendKeys(e[3]);
                   
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
        takeScreenshot("Subcontractors_Update");
        System.out.println("Exit Subcontractors Update: " + new Date());
    }

    @Test(description = "testSubcontractorsOtherUpdate", dataProvider = "subcontractorsOtherData", groups = "subcontractors", dependsOnGroups = "vendors", priority = 4)
    public void testSubcontractorsOtherUpdate(String[][] SubcontractorsOtherData) throws InterruptedException, IOException {    
        System.out.println("Enter Subcontractors Other Update: " + new Date());
        
        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[10]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : SubcontractorsOtherData) {

            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();
                    
                    driver.findElement(By.xpath("//div/div[3]/div/div/div/div/div/div[2]/div/div/div/div")).click();
                    driver.findElement(By.xpath("//div[10]/div/div[4]/div/div/div/div/fieldset/div/button")).click();
                    driver.findElement(By.id("gwt-debug-Address_street1_TB")).sendKeys(e[1]);
                    driver.findElement(By.id("gwt-debug-Address_street2_TB")).sendKeys(e[2]);
                    driver.findElement(By.id("gwt-debug-Address_city_TB")).sendKeys(e[3]);
                    WebElement element = driver.findElement(By.id("gwt-debug-Address_country_LB"));
                    Select country = new Select(element);
                    country.selectByValue(e[4]);
                    element = driver.findElement(By.id("gwt-debug-Address_state_LB"));
                    Select state = new Select(element);
                    state.selectByValue(e[5]);
                    driver.findElement(By.id("gwt-debug-Address_zip_TB")).sendKeys(e[6]);
                    
                    driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
                    waitForLoader();
                    Thread.sleep(3000);
                    takeScreenshot("Subcontractors_LocationUpdate");
                    
                    driver.findElement(By.xpath("//div/div[3]/div/div/div/div/div/div[2]/div/div[2]/div/div")).click();
                    driver.findElement(By.xpath("//div[10]/div/div[4]/div/div/div/div/fieldset/div/button")).click();
                    driver.findElement(By.id("gwt-debug-Contact_firstName_TB")).sendKeys(e[7]);
                    driver.findElement(By.id("gwt-debug-Contact_middleInitial_TB")).sendKeys(e[8]);
                    driver.findElement(By.id("gwt-debug-Contact_lastName_TB")).sendKeys(e[9]);
                    element = driver.findElement(By.id("gwt-debug-Contact_sex_LB"));
                    Select sexRecruiter = new Select(element);
                    sexRecruiter.selectByValue(e[10]);
                    driver.findElement(By.id("gwt-debug-Contact_email_TB")).sendKeys(e[11]);
                    driver.findElement(By.id("gwt-debug-Phone_countryCode_TB")).sendKeys(e[12]);
                    driver.findElement(By.id("gwt-debug-Phone_phoneNumber_TB")).sendKeys(e[13]);
                    driver.findElement(By.id("gwt-debug-Phone_extension_TB")).sendKeys(e[14]);
                    element = driver.findElement(By.id("gwt-debug-PhoneType_phoneType_LB"));
                    Select phoneRecruiter = new Select(element);
                    phoneRecruiter.selectByValue(e[15]);
                    
                    driver.findElement(By.xpath("//div/div/div/div/fieldset/div/div[2]/button")).click();
                    waitForLoader();
                    Thread.sleep(3000);
                    takeScreenshot("Subcontractors_ContactUpdate");
                    
                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
                driver.findElement(By.id("Subcontractors")).click();
            }
        }
        
        System.out.println("Exit Subcontractors Other Update: " + new Date());
        
    }

    @Test(description = "testSubcontractorsView", dataProvider = "subcontractorsViewData", groups = "subcontractors", dependsOnGroups = "vendors", priority = 5)
    public void testSubcontractorsView(String[][] SubcontractorsData) throws InterruptedException, IOException {
        System.out.println("Enter Subcontractors View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[10]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : SubcontractorsData) {

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

        takeScreenshot("Subcontractors_View");
        driver.findElement(By.id("Subcontractors")).click();
        System.out.println("Exit Subcontractors View: " + new Date());
    }

    @Test(description = "testSubcontractorsSearch", groups = "subcontractors", dependsOnGroups = "vendors", priority = 6)
    public void testSubcontractorsSearch() throws InterruptedException, IOException {
        System.out.println("Enter Subcontractors Search: " + new Date());    
        
        driver.findElement(By.xpath("//div[10]/div/div[3]/div/div/div/div/fieldset/div/input")).sendKeys("private");
        driver.findElement(By.xpath("//div[10]/div/div[3]/div/div/div/div/fieldset/div/button")).click();
                                  
        waitForLoader();
        takeScreenshot("Subcontractors_Search");
        driver.findElement(By.id("Subcontractors")).click();
        waitForLoader();
        
        driver.findElement(By.xpath("//div[10]/div/div[3]/div/div/div/div/fieldset/div/table/tbody/tr/td/a/table/tbody/tr/td[2]")).click();
        driver.findElement(By.id("gwt-debug-Subcontractor_name_TB")).sendKeys("private");
        driver.findElement(By.xpath("//div[10]/div/div[3]/div/div/div/div/fieldset/div/button")).click();
        
        waitForLoader();
        takeScreenshot("Subcontractors_AdvancedSearch");
     
        System.out.println("Exit Subcontractors Search: " + new Date());    
    }
    
    @Test(description = "testSubcontractorsDelete", dataProvider = "subcontractorsDeleteData", groups = "subcontractors", dependsOnGroups = "vendors", priority = 7)
    public void testSubcontractorsDelete(String[][] SubcontractorsData) throws InterruptedException, IOException {
        System.out.println("Enter Subcontractors Delete: " + new Date());
        
        driver.findElement(By.id("Subcontractors")).click();
        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[10]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : SubcontractorsData) {

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
        takeScreenshot("Subcontractors_Delete");
        System.out.println("Exit Subcontractors Delete: " + new Date());
    }

    @DataProvider(name = "subcontractorsCreateData")
    private Object[][] subcontractorsCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateSubcontractors");

    }

    @DataProvider(name = "subcontractorsUpdateData")
    private Object[][] subcontractorsUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateSubcontractors");

    }
    
    @DataProvider(name="subcontractorsOtherData")
    private Object[][] subcontractorsOtherData () throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {
        
        return fetchOtherData("UpdateSubcontractorsOther");
    }

    @DataProvider(name = "subcontractorsViewData")
    private Object[][] subcontractorsViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewSubcontractors");

    }

    @DataProvider(name = "subcontractorsDeleteData")
    private Object[][] subcontractorsDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeleteSubcontractors");

    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Admin_Subcontractors.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();

        String[][] SubcontractorsData = new String[rowcount + 1][4];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);

            SubcontractorsData[i][0] = row.getCell(0).getStringCellValue();
            SubcontractorsData[i][1] = row.getCell(1).getStringCellValue();
            SubcontractorsData[i][2] = row.getCell(2).getStringCellValue();
            SubcontractorsData[i][3] = row.getCell(3).getStringCellValue();
        }

        return new Object[][]{{SubcontractorsData}};
    }

    private Object[][] fetchOtherData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Admin_Subcontractors.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();

        String[][] SubcontractorsOtherData = new String[rowcount + 1][16];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);

            SubcontractorsOtherData[i][0] = row.getCell(0).getStringCellValue();
            SubcontractorsOtherData[i][1] = row.getCell(1).getStringCellValue();
            SubcontractorsOtherData[i][2] = row.getCell(2).getStringCellValue();
            SubcontractorsOtherData[i][3] = row.getCell(3).getStringCellValue();
            SubcontractorsOtherData[i][4] = row.getCell(4).getStringCellValue();
            SubcontractorsOtherData[i][5] = row.getCell(5).getStringCellValue();
            SubcontractorsOtherData[i][6] = row.getCell(6).getStringCellValue();
            SubcontractorsOtherData[i][7] = row.getCell(7).getStringCellValue();
            SubcontractorsOtherData[i][8] = row.getCell(8).getStringCellValue();
            SubcontractorsOtherData[i][9] = row.getCell(9).getStringCellValue();
            SubcontractorsOtherData[i][10] = row.getCell(10).getStringCellValue();
            SubcontractorsOtherData[i][11] = row.getCell(11).getStringCellValue();
            SubcontractorsOtherData[i][12] = row.getCell(12).getStringCellValue();
            SubcontractorsOtherData[i][13] = row.getCell(13).getStringCellValue();
            SubcontractorsOtherData[i][14] = row.getCell(14).getStringCellValue();
            SubcontractorsOtherData[i][15] = row.getCell(15).getStringCellValue();
            
        }
        return new Object[][]{{SubcontractorsOtherData}};
    }
}