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
public class Clients extends AbstractOfficeTest {

    @Test(description = "testClientsSection", groups = "clients", dependsOnGroups = "skillSetTags", priority = 1)
    public void testClientsSection() throws InterruptedException, IOException {
        System.out.println("Enter Clients Section: " + new Date());

        driver.findElement(By.xpath("//div[9]/div/div")).click();
        waitForTime(10);
        driver.findElement(By.id("Clients")).click();

        Thread.sleep(3000);
        takeScreenshot("Clients_Section");
        System.out.println("Exit Clients Section: " + new Date());

    }

    @Test(description = "testClientsCreate", dataProvider = "clientsCreateData", groups = "clients", dependsOnGroups = "skillSetTags", priority = 2)
    public void testClientsCreate(String[][] ClientsData) throws InterruptedException, IOException {
        System.out.println("Enter Clients Create: " + new Date());

        for (String[] e : ClientsData) {

            driver.findElement(By.xpath("//div[10]/div/div[4]/div/div/div/div/fieldset/div/button")).click();
            waitForTime(10);

            driver.findElement(By.xpath("//td[2]/table/tbody/tr/td/input")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-Client_description_TB")).sendKeys(e[1]);
            driver.findElement(By.id("gwt-debug-Client_website_TB")).sendKeys(e[2]);
            driver.findElement(By.id("gwt-debug-Client_paymentTerms_TB")).sendKeys(e[3]);

            WebElement element = driver.findElement(By.xpath("//td[2]/table/tbody/tr/td/select"));
            Select invoiceFrequency = new Select(element);
            invoiceFrequency.selectByValue(e[4]);

            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
            waitForTime(10);
        }

        Thread.sleep(3000);
        takeScreenshot("Clients_Create");

        System.out.println("Exit Clients Create: " + new Date());
    }

    @Test(dataProvider = "clientsUpdateData", description = "testClientsUpdate", groups = "clients", dependsOnGroups = "skillSetTags", priority = 3)
    public void testClientsUpdate(String[][] ClientsData) throws InterruptedException, IOException {
        System.out.println("Enter Clients Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[10]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : ClientsData) {

            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();

                    driver.findElement(By.xpath("//td[2]/table/tbody/tr/td/input")).clear();
                    driver.findElement(By.id("gwt-debug-Client_description_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Client_website_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Client_paymentTerms_TB")).clear();

                    driver.findElement(By.xpath("//td[2]/table/tbody/tr/td/input")).sendKeys(e[0]);
                    driver.findElement(By.id("gwt-debug-Client_description_TB")).sendKeys(e[1]);
                    driver.findElement(By.id("gwt-debug-Client_website_TB")).sendKeys(e[2]);
                    driver.findElement(By.id("gwt-debug-Client_paymentTerms_TB")).sendKeys(e[3]);

                    WebElement element = driver.findElement(By.xpath("//td[2]/table/tbody/tr/td/select"));
                    Select invoiceFrequency = new Select(element);
                    invoiceFrequency.selectByValue(e[4]);

                    driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-updateB")).click();
                    waitForTime(10);

                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        Thread.sleep(3000);
        takeScreenshot("Clients_Update");
        System.out.println("Exit Clients Update: " + new Date());
    }

    @Test(description = "testClientsOtherUpdate", dataProvider = "clientsOtherData", groups = "clients", dependsOnGroups = "skillSetTags", priority = 4)
    public void testClientsOtherUpdate(String[][] ClientsOtherData) throws InterruptedException, IOException {    
        System.out.println("Enter Clients Other Update: " + new Date());
        
        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[10]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : ClientsOtherData) {

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
                    takeScreenshot("Clients_LocationUpdate");
                    
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
                    Thread.sleep(3000);
                    takeScreenshot("Clients_RecruiterUpdate");
                    
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
                    Thread.sleep(3000);
                    takeScreenshot("Clients_AcctPayUpdate");
                    
                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
                driver.findElement(By.id("Clients")).click();
            }
        }
        
        System.out.println("Exit Clients Other Update: " + new Date());
        
    }

    @Test(description = "testClientsView", dataProvider = "clientsViewData", groups = "clients", dependsOnGroups = "skillSetTags", priority = 5)
    public void testClientsView(String[][] ClientsData) throws InterruptedException, IOException {
        System.out.println("Enter Clients View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[10]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : ClientsData) {

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

        takeScreenshot("Clients_View");
        driver.findElement(By.id("Clients")).click();
        System.out.println("Exit Clients View: " + new Date());
    }

    @Test(description = "testClientsSearch", groups = "clients", dependsOnGroups = "skillSetTags", priority = 6)
    public void testClientsSearch() throws InterruptedException, IOException {
        System.out.println("Enter Clients Search: " + new Date());    
        
        driver.findElement(By.xpath("//div[10]/div/div[3]/div/div/div/div/fieldset/div/input")).sendKeys("INC");
        driver.findElement(By.xpath("//div[10]/div/div[3]/div/div/div/div/fieldset/div/button")).click();
                                  
   
        waitForLoader();
        takeScreenshot("Clients_Search");
        
        driver.findElement(By.xpath("//div[10]/div/div[3]/div/div/div/div/fieldset/div/table/tbody/tr/td/a/table/tbody/tr/td[2]")).click();
        driver.findElement(By.id("gwt-debug-Client_name_TB")).sendKeys("INC");
        WebElement element = driver.findElement(By.id("gwt-debug-Client_clientinvFrequency_LB"));
        Select invoice = new Select(element);
        invoice.selectByValue("WEEKLY");
        driver.findElement(By.id("gwt-debug-Client_city_TB")).sendKeys("Tampa");
        element = driver.findElement(By.id("gwt-debug-Client_state_LB"));
        Select state = new Select(element);
        state.selectByValue("FL");
        driver.findElement(By.xpath("//div[10]/div/div[3]/div/div/div/div/fieldset/div/button")).click();
        
        waitForLoader();
        takeScreenshot("Clients_AdvancedSearch");
     
        System.out.println("Exit Clients Search: " + new Date());    
    }
    
    @Test(description = "testClientsDelete", dataProvider = "clientsDeleteData", groups = "clients", dependsOnGroups = "skillSetTags", priority = 7)
    public void testClientsDelete(String[][] ClientsData) throws InterruptedException, IOException {
        System.out.println("Enter Clients Delete: " + new Date());
        
        driver.findElement(By.id("Clients")).click();
        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[10]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : ClientsData) {

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

        Thread.sleep(3000);
        takeScreenshot("Clients_Delete");
        System.out.println("Exit Clients Delete: " + new Date());
    }

    @DataProvider(name = "clientsCreateData")
    private Object[][] clientsCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateClients");

    }

    @DataProvider(name = "clientsUpdateData")
    private Object[][] clientsUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateClients");

    }
    
    @DataProvider(name="clientsOtherData")
    private Object[][] clientsOtherData () throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {
        
        return fetchOtherData("UpdateClientsOther");
    }

    @DataProvider(name = "clientsViewData")
    private Object[][] clientsViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewClients");

    }

    @DataProvider(name = "clientsDeleteData")
    private Object[][] clientsDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeleteClients");

    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Admin_Clients.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();

        String[][] ClientsData = new String[rowcount + 1][5];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);

            ClientsData[i][0] = row.getCell(0).getStringCellValue();
            ClientsData[i][1] = row.getCell(1).getStringCellValue();
            ClientsData[i][2] = row.getCell(2).getStringCellValue();
            ClientsData[i][3] = row.getCell(3).getStringCellValue();
            ClientsData[i][4] = row.getCell(4).getStringCellValue();

        }

        return new Object[][]{{ClientsData}};
    }

    private Object[][] fetchOtherData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Admin_Clients.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();

        String[][] ClientsOtherData = new String[rowcount + 1][25];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);

            ClientsOtherData[i][0] = row.getCell(0).getStringCellValue();
            ClientsOtherData[i][1] = row.getCell(1).getStringCellValue();
            ClientsOtherData[i][2] = row.getCell(2).getStringCellValue();
            ClientsOtherData[i][3] = row.getCell(3).getStringCellValue();
            ClientsOtherData[i][4] = row.getCell(4).getStringCellValue();
            ClientsOtherData[i][5] = row.getCell(5).getStringCellValue();
            ClientsOtherData[i][6] = row.getCell(6).getStringCellValue();
            ClientsOtherData[i][7] = row.getCell(7).getStringCellValue();
            ClientsOtherData[i][8] = row.getCell(8).getStringCellValue();
            ClientsOtherData[i][9] = row.getCell(9).getStringCellValue();
            ClientsOtherData[i][10] = row.getCell(10).getStringCellValue();
            ClientsOtherData[i][11] = row.getCell(11).getStringCellValue();
            ClientsOtherData[i][12] = row.getCell(12).getStringCellValue();
            ClientsOtherData[i][13] = row.getCell(13).getStringCellValue();
            ClientsOtherData[i][14] = row.getCell(14).getStringCellValue();
            ClientsOtherData[i][15] = row.getCell(15).getStringCellValue();
            ClientsOtherData[i][16] = row.getCell(16).getStringCellValue();
            ClientsOtherData[i][17] = row.getCell(17).getStringCellValue();
            ClientsOtherData[i][18] = row.getCell(18).getStringCellValue();
            ClientsOtherData[i][19] = row.getCell(19).getStringCellValue();
            ClientsOtherData[i][20] = row.getCell(20).getStringCellValue();
            ClientsOtherData[i][21] = row.getCell(21).getStringCellValue();
            ClientsOtherData[i][22] = row.getCell(22).getStringCellValue();
            ClientsOtherData[i][23] = row.getCell(23).getStringCellValue();
            ClientsOtherData[i][24] = row.getCell(24).getStringCellValue();    
        }
        return new Object[][]{{ClientsOtherData}};
    }
}
