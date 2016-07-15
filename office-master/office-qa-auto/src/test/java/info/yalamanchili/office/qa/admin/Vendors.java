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
public class Vendors extends AbstractOfficeTest {

    @Test(description = "testVendorsSection", groups = "vendors", dependsOnGroups = "clients", priority = 1)
    public void testVendorsSection() throws InterruptedException, IOException {
        System.out.println("Enter Vendors Section: " + new Date());

        driver.findElement(By.xpath("//div[9]/div/div")).click();
        waitForTime(10);
        driver.findElement(By.id("Vendors")).click();

        waitForLoader();
        Thread.sleep(3000);
        takeScreenshot("Vendors_Section");
        System.out.println("Exit Vendors Section: " + new Date());

    }

    @Test(description = "testVendorsCreate", dataProvider = "vendorsCreateData", groups = "vendors", dependsOnGroups = "clients", priority = 2)
    public void testVendorsCreate(String[][] VendorsData) throws InterruptedException, IOException {
        System.out.println("Enter Vendors Create: " + new Date());

        for (String[] e : VendorsData) {

            driver.findElement(By.xpath("//div[10]/div/div[4]/div/div/div/div/fieldset/div/button")).click();
            waitForTime(10);

            driver.findElement(By.id("gwt-debug-Vendors_name_TB")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-Vendors_description_TB")).sendKeys(e[1]);
            WebElement element = driver.findElement(By.xpath("//td[2]/table/tbody/tr/td/select"));
            Select vendorType = new Select(element);
            vendorType.selectByValue(e[2]);
            driver.findElement(By.id("gwt-debug-Vendors_vendorFees_TB")).sendKeys(e[3]);
            driver.findElement(By.id("gwt-debug-Vendors_website_TB")).sendKeys(e[4]);
            driver.findElement(By.id("gwt-debug-Vendors_paymentTerms_TB")).sendKeys(e[5]);
            element = driver.findElement(By.id("gwt-debug-Vendors_vendorinvFrequency_LB"));
            Select frequency = new Select(element);
            frequency.selectByValue(e[6]);

            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
            waitForTime(10);
        }

        waitForLoader();
        Thread.sleep(3000);
        takeScreenshot("Vendors_Create");

        System.out.println("Exit Vendors Create: " + new Date());
    }

    @Test(dataProvider = "vendorsUpdateData", description = "testVendorsUpdate", groups = "vendors", dependsOnGroups = "clients", priority = 3)
    public void testVendorsUpdate(String[][] VendorsData) throws InterruptedException, IOException {
        System.out.println("Enter Vendors Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[10]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : VendorsData) {

            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();

                    driver.findElement(By.id("gwt-debug-Vendors_name_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Vendors_description_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Vendors_vendorFees_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Vendors_website_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Vendors_paymentTerms_TB")).clear();

                    driver.findElement(By.id("gwt-debug-Vendors_name_TB")).sendKeys(e[0]);
                    driver.findElement(By.id("gwt-debug-Vendors_description_TB")).sendKeys(e[1]);
                    WebElement element = driver.findElement(By.xpath("//td[2]/table/tbody/tr/td/select"));
                    Select vendorType = new Select(element);
                    vendorType.selectByValue(e[2]);
                    driver.findElement(By.id("gwt-debug-Vendors_vendorFees_TB")).sendKeys(e[3]);
                    driver.findElement(By.id("gwt-debug-Vendors_website_TB")).sendKeys(e[4]);
                    driver.findElement(By.id("gwt-debug-Vendors_paymentTerms_TB")).sendKeys(e[5]);
                    element = driver.findElement(By.id("gwt-debug-Vendors_vendorinvFrequency_LB"));
                    Select frequency = new Select(element);
                    frequency.selectByValue(e[6]);

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
        Thread.sleep(3000);
        takeScreenshot("Vendors_Update");
        System.out.println("Exit Vendors Update: " + new Date());
    }

    @Test(description = "testVendorsOtherUpdate", dataProvider = "vendorsOtherData", groups = "vendors", dependsOnGroups = "clients", priority = 4)
    public void testVendorsOtherUpdate(String[][] VendorsOtherData) throws InterruptedException, IOException {
        System.out.println("Enter Vendors Other Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[10]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : VendorsOtherData) {

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
                    takeScreenshot("Vendors_LocationUpdate");

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
                    takeScreenshot("Vendors_RecruiterUpdate");

                    driver.findElement(By.xpath("//div/div[3]/div/div/div/div/div/div[2]/div/div[3]/div/div")).click();
                    driver.findElement(By.xpath("//div[10]/div/div[4]/div/div/div/div/fieldset/div/button")).click();
                    driver.findElement(By.id("gwt-debug-Contact_firstName_TB")).sendKeys(e[16]);
                    driver.findElement(By.id("gwt-debug-Contact_middleInitial_TB")).sendKeys(e[17]);
                    driver.findElement(By.id("gwt-debug-Contact_lastName_TB")).sendKeys(e[18]);
                    element = driver.findElement(By.id("gwt-debug-Contact_sex_LB"));
                    Select sexAcctPay = new Select(element);
                    sexAcctPay.selectByValue(e[19]);
                    driver.findElement(By.id("gwt-debug-Contact_email_TB")).sendKeys(e[20]);
                    driver.findElement(By.id("gwt-debug-Phone_countryCode_TB")).sendKeys(e[21]);
                    driver.findElement(By.id("gwt-debug-Phone_phoneNumber_TB")).sendKeys(e[22]);
                    driver.findElement(By.id("gwt-debug-Phone_extension_TB")).sendKeys(e[23]);
                    element = driver.findElement(By.id("gwt-debug-PhoneType_phoneType_LB"));
                    Select phoneAcctPay = new Select(element);
                    phoneAcctPay.selectByValue(e[24]);

                    driver.findElement(By.xpath("//div/div/div/div/fieldset/div/div[2]/button")).click();
                    waitForLoader();
                    Thread.sleep(3000);
                    takeScreenshot("Vendors_AcctPayUpdate");

                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
                driver.findElement(By.id("Vendors")).click();
            }
        }

        System.out.println("Exit Vendors Other Update: " + new Date());

    }

    @Test(description = "testVendorsView", dataProvider = "vendorsViewData", groups = "vendors", dependsOnGroups = "clients", priority = 5)
    public void testVendorsView(String[][] VendorsData) throws InterruptedException, IOException {
        System.out.println("Enter Vendors View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[10]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : VendorsData) {

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

        takeScreenshot("Vendors_View");
        driver.findElement(By.id("Vendors")).click();
        System.out.println("Exit Vendors View: " + new Date());
    }

    @Test(description = "testVendorsSearch", groups = "vendors", dependsOnGroups = "clients", priority = 6)
    public void testVendorsSearch() throws InterruptedException, IOException {
        System.out.println("Enter Vendors Search: " + new Date());

        driver.findElement(By.xpath("//div[10]/div/div[3]/div/div/div/div/fieldset/div/input")).sendKeys("private");
        driver.findElement(By.xpath("//div[10]/div/div[3]/div/div/div/div/fieldset/div/button")).click();

        waitForLoader();
        takeScreenshot("Vendors_Search");
        driver.findElement(By.id("Vendors")).click();
        waitForLoader();

        driver.findElement(By.xpath("//div[10]/div/div[3]/div/div/div/div/fieldset/div/table/tbody/tr/td/a/table/tbody/tr/td[2]")).click();
        driver.findElement(By.id("gwt-debug-Vendors_vendorName_TB")).sendKeys("company");
        WebElement element = driver.findElement(By.id("gwt-debug-Vendors_vendorType_LB"));
        Select vendorType = new Select(element);
        vendorType.selectByValue("THIRD_PARTY");
        driver.findElement(By.id("gwt-debug-Vendors_city_TB")).sendKeys("Tampa");
        element = driver.findElement(By.id("gwt-debug-Vendors_state_LB"));
        Select state = new Select(element);
        state.selectByValue("FL");
        driver.findElement(By.xpath("//div[10]/div/div[3]/div/div/div/div/fieldset/div/button")).click();

        waitForLoader();
        takeScreenshot("Vendors_AdvancedSearch");

        System.out.println("Exit Vendors Search: " + new Date());
    }

    @Test(description = "testVendorsDelete", dataProvider = "vendorsDeleteData", groups = "vendors", dependsOnGroups = "clients", priority = 7)
    public void testVendorsDelete(String[][] VendorsData) throws InterruptedException, IOException {
        System.out.println("Enter Vendors Delete: " + new Date());

        driver.findElement(By.id("Vendors")).click();
        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[10]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : VendorsData) {

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
        takeScreenshot("Vendors_Delete");
        System.out.println("Exit Vendors Delete: " + new Date());
    }

    @DataProvider(name = "vendorsCreateData")
    private Object[][] vendorsCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateVendors");

    }

    @DataProvider(name = "vendorsUpdateData")
    private Object[][] vendorsUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateVendors");

    }

    @DataProvider(name = "vendorsOtherData")
    private Object[][] vendorsOtherData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchOtherData("UpdateVendorsOther");
    }

    @DataProvider(name = "vendorsViewData")
    private Object[][] vendorsViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewVendors");

    }

    @DataProvider(name = "vendorsDeleteData")
    private Object[][] vendorsDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeleteVendors");

    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Admin_Vendors.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();

        String[][] VendorsData = new String[rowcount + 1][7];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);

            VendorsData[i][0] = row.getCell(0).getStringCellValue();
            VendorsData[i][1] = row.getCell(1).getStringCellValue();
            VendorsData[i][2] = row.getCell(2).getStringCellValue();
            VendorsData[i][3] = row.getCell(3).getStringCellValue();
            VendorsData[i][4] = row.getCell(4).getStringCellValue();
            VendorsData[i][5] = row.getCell(5).getStringCellValue();
            VendorsData[i][6] = row.getCell(6).getStringCellValue();

        }

        return new Object[][]{{VendorsData}};
    }

    private Object[][] fetchOtherData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Admin_Vendors.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();

        String[][] VendorsOtherData = new String[rowcount + 1][25];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);

            VendorsOtherData[i][0] = row.getCell(0).getStringCellValue();
            VendorsOtherData[i][1] = row.getCell(1).getStringCellValue();
            VendorsOtherData[i][2] = row.getCell(2).getStringCellValue();
            VendorsOtherData[i][3] = row.getCell(3).getStringCellValue();
            VendorsOtherData[i][4] = row.getCell(4).getStringCellValue();
            VendorsOtherData[i][5] = row.getCell(5).getStringCellValue();
            VendorsOtherData[i][6] = row.getCell(6).getStringCellValue();
            VendorsOtherData[i][7] = row.getCell(7).getStringCellValue();
            VendorsOtherData[i][8] = row.getCell(8).getStringCellValue();
            VendorsOtherData[i][9] = row.getCell(9).getStringCellValue();
            VendorsOtherData[i][10] = row.getCell(10).getStringCellValue();
            VendorsOtherData[i][11] = row.getCell(11).getStringCellValue();
            VendorsOtherData[i][12] = row.getCell(12).getStringCellValue();
            VendorsOtherData[i][13] = row.getCell(13).getStringCellValue();
            VendorsOtherData[i][14] = row.getCell(14).getStringCellValue();
            VendorsOtherData[i][15] = row.getCell(15).getStringCellValue();
            VendorsOtherData[i][16] = row.getCell(16).getStringCellValue();
            VendorsOtherData[i][17] = row.getCell(17).getStringCellValue();
            VendorsOtherData[i][18] = row.getCell(18).getStringCellValue();
            VendorsOtherData[i][19] = row.getCell(19).getStringCellValue();
            VendorsOtherData[i][20] = row.getCell(20).getStringCellValue();
            VendorsOtherData[i][21] = row.getCell(21).getStringCellValue();
            VendorsOtherData[i][22] = row.getCell(22).getStringCellValue();
            VendorsOtherData[i][23] = row.getCell(23).getStringCellValue();
            VendorsOtherData[i][24] = row.getCell(24).getStringCellValue();
        }
        return new Object[][]{{VendorsOtherData}};
    }
}
