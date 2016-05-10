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
public class Company extends AbstractOfficeTest {

    @Test(description = "testCompanySection", groups = "company", dependsOnGroups = "externalrefs", priority = 1)
    public void testCompanySection() throws InterruptedException, IOException {
        System.out.println("Enter Company Section: " + new Date());

        driver.findElement(By.xpath("//div[9]/div/div")).click();
        waitForTime(10);
        driver.findElement(By.id("Company")).click();

        waitForLoader();
        takeScreenshot("Company_Section");
        System.out.println("Exit Company Section: " + new Date());
    }

    @Test(description = "testCompanyCreate", dataProvider = "companyCreateData", groups = "company", dependsOnGroups = "externalrefs", priority = 2)
    public void testCompanyCreate(String[][] CompanyData) throws InterruptedException, IOException {
        System.out.println("Enter Company Create: " + new Date());

        for (String[] e : CompanyData) {

            driver.findElement(By.xpath("//div[10]/div/div[4]/div/div/div/div/fieldset/div/button")).click();
            waitForTime(10);

            driver.findElement(By.id("gwt-debug-Company_name_TB")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-Company_establishedDate_TB")).sendKeys(e[1]);
            driver.findElement(By.id("gwt-debug-Company_abbreviation_TB")).sendKeys(e[2]);

            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
            waitForLoader();
        }

        takeScreenshot("Company_Create");
        System.out.println("Exit Company Create: " + new Date());
    }

    @Test(dataProvider = "companyUpdateData", description = "testCompanyUpdate", groups = "company", dependsOnGroups = "externalrefs", priority = 3)
    public void testCompanyUpdate(String[][] CompanyData) throws InterruptedException, IOException {
        System.out.println("Enter Company Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[10]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : CompanyData) {

            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();
                    
                    driver.findElement(By.id("gwt-debug-Company_name_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Company_establishedDate_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Company_abbreviation_TB")).clear();
                    
                    driver.findElement(By.id("gwt-debug-Company_name_TB")).sendKeys(e[0]);
                    driver.findElement(By.id("gwt-debug-Company_establishedDate_TB")).sendKeys(e[1]);
                    driver.findElement(By.id("gwt-debug-Company_abbreviation_TB")).sendKeys(e[2]);
                    
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
        takeScreenshot("Company_Update");
        System.out.println("Exit Company Update: " + new Date());
    }

    @Test(description = "testCompanyView", dataProvider = "companyViewData", groups = "company", dependsOnGroups = "externalrefs", priority = 4)
    public void testCompanyView(String[][] CompanyData) throws InterruptedException, IOException {
        System.out.println("Enter Company View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[10]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : CompanyData) {

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

        takeScreenshot("Company_View");
        driver.findElement(By.id("Company")).click();
        System.out.println("Exit Company View: " + new Date());
    }
    
    @Test(description = "testCompanyDelete", dataProvider = "companyDeleteData", groups = "company", dependsOnGroups = "externalrefs", priority = 6)
    public void testCompanyDelete(String[][] CompanyData) throws InterruptedException, IOException {
        System.out.println("Enter Company Delete: " + new Date());
        
        driver.findElement(By.id("Company")).click();
        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[10]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : CompanyData) {

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
        takeScreenshot("Company_Delete");
        System.out.println("Exit Company Delete: " + new Date());
    }

    @DataProvider(name = "companyCreateData")
    private Object[][] companyCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateCompany");

    }

    @DataProvider(name = "companyUpdateData")
    private Object[][] companyUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateCompany");

    }
    
    @DataProvider(name = "companyViewData")
    private Object[][] companyViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewCompany");
    }

    @DataProvider(name = "companyDeleteData")
    private Object[][] companyDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeleteCompany");

    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Admin_Company.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();

        String[][] CompanyData = new String[rowcount + 1][3];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);

            CompanyData[i][0] = row.getCell(0).getStringCellValue();
            CompanyData[i][1] = row.getCell(1).getStringCellValue();
            CompanyData[i][2] = row.getCell(2).getStringCellValue();
        }

        return new Object[][]{{CompanyData}};
    }
}