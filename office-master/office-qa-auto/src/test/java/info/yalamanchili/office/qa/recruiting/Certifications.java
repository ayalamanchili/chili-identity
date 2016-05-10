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
public class Certifications extends AbstractOfficeTest {

    @Test(description = "testCertificationsSection", groups = "certifications", dependsOnGroups = "skills", priority = 1)
    public void testCertificationsSection() throws InterruptedException, IOException {
        System.out.println("Enter Certifications Section: " + new Date());

        driver.findElement(By.id("Certifications")).click();
        
        waitForElementXpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[2]/td[1]");
        takeScreenshot("Certifications_Section");        
        System.out.println("Exit Certifications Section: " + new Date());

    }
    
    @Test(dataProvider = "certificationsCreateData", description = "testCertificationsCreate", groups = "certifications", dependsOnGroups = "skills", priority = 2)
    public void testCertificationsCreate(String[][] CertificationsData) throws InterruptedException, IOException {
        System.out.println("Enter Certifications Create: " + new Date());

        for (String[] e : CertificationsData) {

            driver.findElement(By.xpath("//div[12]/div/div[4]/div/div/div/div/fieldset/div/button")).click();
            waitForTime(10);

            driver.findElement(By.xpath("//fieldset/div/div/div/table/tbody/tr/td/input")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-Certification_description_TB")).sendKeys(e[1]);
            driver.findElement(By.id("gwt-debug-Certification_certificationVendor_TB")).sendKeys(e[2]);
            driver.findElement(By.id("gwt-debug-Certification_certificationCode_TB")).sendKeys(e[3]);

            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
            waitForTime(10);
        }
        
        waitForElementXpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[2]/td[1]");
        takeScreenshot("Certifications_Create");

        System.out.println("Exit Certifications Create: " + new Date());
    }

    @Test(description = "testCertificationsSearch", groups = "certifications", dependsOnGroups = "skills", priority = 3)
    public void testCertificationsSearch() throws InterruptedException, IOException {
        System.out.println("Enter Certifications Search: " + new Date());

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[3]/div/div/fieldset/div/input")).sendKeys("Testing");
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[3]/div/div/fieldset/div/button")).click();
        
        waitForElementXpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[2]/td[1]");
        takeScreenshot("Certifications_Search");
        
        System.out.println("Exit Certifications Search: " + new Date());

    }

    @Test(dataProvider = "certificationsUpdateData", description = "testCertificationsUpdate", groups = "certifications", dependsOnGroups = "skills", priority = 4)
    public void testCertificationsUpdate(String[][] CertificationsData) throws InterruptedException, IOException {
        System.out.println("Enter Certifications Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : CertificationsData) {

            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();

                    driver.findElement(By.xpath("//fieldset/div/div/div/table/tbody/tr/td/input")).clear();
                    driver.findElement(By.id("gwt-debug-Certification_description_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Certification_certificationVendor_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Certification_certificationCode_TB")).clear();
                    
                    
                    driver.findElement(By.xpath("//fieldset/div/div/div/table/tbody/tr/td/input")).sendKeys(e[0]);
                    driver.findElement(By.id("gwt-debug-Certification_description_TB")).sendKeys(e[1]);
                    driver.findElement(By.id("gwt-debug-Certification_certificationVendor_TB")).sendKeys(e[2]);
                    driver.findElement(By.id("gwt-debug-Certification_certificationCode_TB")).sendKeys(e[3]);

                    driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-updateB")).click();

                    waitForTime(10);

                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        waitForElementXpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[2]/td[1]");
        takeScreenshot("Certifications_Update");
        System.out.println("Exit Certifications Update: " + new Date());
    }
    
    
    @Test(dataProvider = "certificationsViewData", description = "testCertificationsView", groups = "certifications", dependsOnGroups = "skills", priority = 5)
    public void testCertificationsView(String[][] CertificationsData) throws InterruptedException, IOException {
        System.out.println("Enter Certifications View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : CertificationsData) {

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
        
        waitForElementXpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[2]/td[1]");
        takeScreenshot("Certifications_View");
        System.out.println("Exit Certifications View: " + new Date());
    }

    @Test(dataProvider = "certificationsDeleteData", description = "testCertificationsDelete", groups = "certifications", dependsOnGroups = "skills", priority = 6)
    public void testCertificationsDelete(String[][] CertificationsData) throws InterruptedException, IOException {
        System.out.println("Enter Certifications Delete: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : CertificationsData) {

            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                waitForStaleness(driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[1]/td[1]")));
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
       
        waitForElementXpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[12]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[2]/td[1]");
        takeScreenshot("Certifications_Delete");
        System.out.println("Exit Certifications Delete: " + new Date());
    }
    
    @DataProvider(name = "certificationsCreateData")
    private Object[][] certificationsCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateCertifications");

    }

    @DataProvider(name = "certificationsUpdateData")
    private Object[][] certificationsUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateCertifications");

    }
    
    @DataProvider(name = "certificationsViewData")
    private Object[][] certificationsViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewCertifications");

    }
    
    @DataProvider(name = "certificationsDeleteData")
    private Object[][] certificationsDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeleteCertifications");

    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Recruitment_Certifications.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();

        String[][] CertificationsData = new String[rowcount + 1][4];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);

            CertificationsData[i][0] = row.getCell(0).getStringCellValue();
            CertificationsData[i][1] = row.getCell(1).getStringCellValue();
            CertificationsData[i][2] = row.getCell(2).getStringCellValue();
            CertificationsData[i][3] = row.getCell(3).getStringCellValue();
            
        }

        return new Object[][]{{CertificationsData}};
    }
}
