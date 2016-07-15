/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa.expense;

import com.sun.glass.events.KeyEvent;
import info.yalamanchili.office.qa.AbstractOfficeTest;
import static info.yalamanchili.office.qa.AbstractOfficeTest.driver;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.Thread.sleep;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author joel kolli
 */
public class TravelAuthorization extends AbstractOfficeTest {

    @Test(description = "TravelAuthorization Section", groups = "travelAuthorization", dependsOnGroups = "expenseReports", priority = 1)
    public void testViewTravelAuthorization() throws IOException, InterruptedException {
        System.out.println("Enter TravelAuthorization Section: " + new Date());

        driver.findElement(By.xpath("//div[5]/div/div[2]/div/table/tbody/tr/td[5]/div")).click();
        waitForLoader();
        sleep(2000);

        driver.findElement(By.xpath("html/body/div[4]/div/div/fieldset/div/span/input")).click();

        takeScreenshot("TravelAuthorization_Section");
        System.out.println("Exit TravelAuthorization Section: " + new Date());
    }

    @Test(description = "TravelAuthorization Create", dataProvider = "travelAuthorizationCreateData", groups = "travelAuthorization", dependsOnGroups = "expenseReports", priority = 2)
    public void testCreateTravelAuthorization(String[][] TravelAuthorizationData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter TravelAuthorization Create: " + new Date());

        for (String[] e : TravelAuthorizationData) {

            driver.findElement(By.xpath("//div[5]/div/div[4]/div/div/div/div/fieldset/div/button")).click();

            WebElement element = driver.findElement(By.id("gwt-debug-TravelAuthorization_travelType_LB"));
            Select company = new Select(element);
            company.selectByVisibleText(e[0]);
            driver.findElement(By.id("gwt-debug-TravelAuthorization_departureDate_TB")).sendKeys(e[1]);
            driver.findElement(By.id("gwt-debug-TravelAuthorization_returnDate_TB")).sendKeys(e[2]);
            driver.findElement(By.id("gwt-debug-TravelAuthorization_travelOrigin_TB")).sendKeys(e[3]);
            driver.findElement(By.id("gwt-debug-TravelAuthorization_travelDestination_TB")).sendKeys(e[4]);
            driver.findElement(By.id("gwt-debug-TravelAuthorization_reasonForTravel_TB")).sendKeys(e[5]);
            driver.findElement(By.id("gwt-debug-TravelAuthorization_additionalComments_TB")).sendKeys(e[6]);
            element = driver.findElement(By.id("gwt-debug-TravelAuthorization_travelTransportationType_LB"));
            Select transportationType = new Select(element);
            transportationType.selectByVisibleText(e[7]);

            driver.findElement(By.id("gwt-debug-TravelAuthorization_totalTransportationCost_TB")).sendKeys(e[8]);
            element = driver.findElement(By.id("gwt-debug-TravelAuthorization_expensePaymentType_LB"));
            Select paymentType = new Select(element);
            paymentType.selectByVisibleText(e[9]);
            driver.findElement(By.id("gwt-debug-TravelAuthorization_numberOfLodgingNights_TB")).sendKeys(e[10]);
            driver.findElement(By.id("gwt-debug-TravelAuthorization_lodgingCostPerNight_TB")).sendKeys(e[11]);
            element = driver.findElement(By.id("gwt-debug-TravelAuthorization_expenseAccommodationPaymentType_LB"));
            Select accopaymentType = new Select(element);
            accopaymentType.selectByVisibleText(e[12]);
            driver.findElement(By.id("gwt-debug-TravelAuthorization_totalCostOfFood_TB")).sendKeys(e[13]);
            element = driver.findElement(By.id("gwt-debug-TravelAuthorization_foodExpensePaymentMode_LB"));
            Select foodpaymentMode = new Select(element);
            foodpaymentMode.selectByVisibleText(e[14]);
            driver.findElement(By.id("gwt-debug-TravelAuthorization_conferenceFee_TB")).sendKeys(e[15]);
            element = driver.findElement(By.id("gwt-debug-TravelAuthorization_conferenceExpensePaymentMode_LB"));
            Select confpaymentMode = new Select(element);
            confpaymentMode.selectByVisibleText(e[16]);
            driver.findElement(By.id("gwt-debug-TravelAuthorization_totalCostOfBanquet_TB")).sendKeys(e[17]);
            element = driver.findElement(By.id("gwt-debug-TravelAuthorization_banquetExpensePaymentMode_LB"));
            Select banqpaymentMode = new Select(element);
            banqpaymentMode.selectByVisibleText(e[18]);
            driver.findElement(By.id("gwt-debug-TravelAuthorization_otherExpences_TB")).sendKeys(e[19]);
            element = driver.findElement(By.id("gwt-debug-TravelAuthorization_otherExpensePaymentMode_LB"));
            Select otherExpenses = new Select(element);
            otherExpenses.selectByVisibleText(e[20]);

            driver.findElement(By.xpath("//div[2]/button")).click();
            waitForLoader();
            sleep(5000);
        }

        takeScreenshot("TravelAuthorization_Create");
        System.out.println("Exit TravelAuthorization Create: " + new Date());
    }

    @Test(description = "TravelAuthorization QuickView", dataProvider = "travelAuthorizationQuickViewData", groups = "travelAuthorization", dependsOnGroups = "expenseReports", priority = 3)
    public void testTravelAuthorizationQuickView(String[][] TravelAuthorizationData) throws InterruptedException, IOException, AWTException {
        System.out.println("Enter TravelAuthorization QuickView: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : TravelAuthorizationData) {
            int i = 2;
            int j = 3;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    WebElement quickView = driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[1]/img"));
                    Actions action = new Actions(driver);
                    action.moveToElement(quickView).perform();
                    waitForLoader();

                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_PAGE_DOWN);
                    robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
                    sleep(2000);

                    driver.findElement(By.xpath("//div[10]/fieldset/div/button")).click();
                    driver.findElement(By.id("gwt-debug-Comment_comment_TB")).sendKeys("Test Comments");
                    driver.findElement(By.id("gwt-debug-Employee_search_TB")).sendKeys("admin admin");
                    driver.findElement(By.xpath("//div[2]/button")).click();
                    waitForLoader();
                    sleep(2000);

                    j = 3;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("TravelAuthorization_QuickView");

        driver.findElement(By.xpath("//div/div/div[2]/div/div[4]/div/div")).click();
        waitForLoader();
        sleep(2000);

        System.out.println("Exit TravelAuthorization QuickView: " + new Date());
    }

    @Test(description = "TravelAuthorizationView", dataProvider = "travelAuthorizationViewData", groups = "travelAuthorization", dependsOnGroups = "expenseReports", priority = 4)
    public void testTravelAuthorizationView(String[][] TravelAuthorizationData) throws InterruptedException, IOException {
        System.out.println("Enter TravelAuthorization View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : TravelAuthorizationData) {
            int i = 2;
            int j = 3;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();
                    waitForLoader();
                    sleep(2000);

                    j = 3;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("TravelAuthorization_View");

        driver.findElement(By.xpath("//div[5]/div/div[2]/div/table/tbody/tr/td[5]/div")).click();
        waitForLoader();
        sleep(2000);

        System.out.println("Exit TravelAuthorization View: " + new Date());
    }

    @Test(description = "TravelAuthorization Update", dataProvider = "travelAuthorizationUpdateData", groups = "travelAuthorization", dependsOnGroups = "expenseReports", priority = 5)
    public void testUpdateTravelAuthorization(String[][] TravelAuthorizationData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter TravelAuthorization Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : TravelAuthorizationData) {
            int i = 2;
            int j = 3;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[3]/img")).click();
                    waitForLoader();
                    sleep(2000);

                    driver.findElement(By.id("gwt-debug-TravelAuthorization_departureDate_TB")).clear();
                    driver.findElement(By.id("gwt-debug-TravelAuthorization_returnDate_TB")).clear();
                    driver.findElement(By.id("gwt-debug-TravelAuthorization_travelOrigin_TB")).clear();
                    driver.findElement(By.id("gwt-debug-TravelAuthorization_travelDestination_TB")).clear();
                    driver.findElement(By.id("gwt-debug-TravelAuthorization_reasonForTravel_TB")).clear();
                    driver.findElement(By.id("gwt-debug-TravelAuthorization_totalTransportationCost_TB")).clear();
                    driver.findElement(By.id("gwt-debug-TravelAuthorization_numberOfLodgingNights_TB")).clear();
                    driver.findElement(By.id("gwt-debug-TravelAuthorization_lodgingCostPerNight_TB")).clear();
                    driver.findElement(By.id("gwt-debug-TravelAuthorization_totalCostOfFood_TB")).clear();
                    driver.findElement(By.id("gwt-debug-TravelAuthorization_conferenceFee_TB")).clear();
                    driver.findElement(By.id("gwt-debug-TravelAuthorization_totalCostOfBanquet_TB")).clear();
                    driver.findElement(By.id("gwt-debug-TravelAuthorization_otherExpences_TB")).clear();

                    WebElement element = driver.findElement(By.id("gwt-debug-TravelAuthorization_travelType_LB"));
                    Select travelType = new Select(element);
                    travelType.selectByVisibleText(e[0]);
                    driver.findElement(By.id("gwt-debug-TravelAuthorization_departureDate_TB")).sendKeys(e[1]);
                    driver.findElement(By.id("gwt-debug-TravelAuthorization_returnDate_TB")).sendKeys(e[2]);
                    driver.findElement(By.id("gwt-debug-TravelAuthorization_travelOrigin_TB")).sendKeys(e[3]);
                    driver.findElement(By.id("gwt-debug-TravelAuthorization_travelDestination_TB")).sendKeys(e[4]);
                    driver.findElement(By.id("gwt-debug-TravelAuthorization_reasonForTravel_TB")).sendKeys(e[5]);
                    element = driver.findElement(By.id("gwt-debug-TravelAuthorization_travelTransportationType_LB"));
                    Select travelTransportationType = new Select(element);
                    travelTransportationType.selectByVisibleText(e[7]);
                    driver.findElement(By.id("gwt-debug-TravelAuthorization_totalTransportationCost_TB")).sendKeys(e[8]);
                    element = driver.findElement(By.id("gwt-debug-TravelAuthorization_expensePaymentType_LB"));
                    Select expensePaymentType = new Select(element);
                    expensePaymentType.selectByVisibleText(e[9]);
                    driver.findElement(By.id("gwt-debug-TravelAuthorization_numberOfLodgingNights_TB")).sendKeys(e[10]);
                    driver.findElement(By.id("gwt-debug-TravelAuthorization_lodgingCostPerNight_TB")).sendKeys(e[11]);
                    element = driver.findElement(By.id("gwt-debug-TravelAuthorization_expenseAccommodationPaymentType_LB"));
                    Select expenseAccommodationType = new Select(element);
                    expenseAccommodationType.selectByVisibleText(e[12]);
                    driver.findElement(By.id("gwt-debug-TravelAuthorization_totalCostOfFood_TB")).sendKeys(e[13]);
                    element = driver.findElement(By.id("gwt-debug-TravelAuthorization_foodExpensePaymentMode_LB"));
                    Select foodexpensePaymentType = new Select(element);
                    foodexpensePaymentType.selectByVisibleText(e[14]);
                    driver.findElement(By.id("gwt-debug-TravelAuthorization_conferenceFee_TB")).sendKeys(e[15]);
                    element = driver.findElement(By.id("gwt-debug-TravelAuthorization_conferenceExpensePaymentMode_LB"));
                    Select conferenceexpensePaymentType = new Select(element);
                    conferenceexpensePaymentType.selectByVisibleText(e[16]);
                    driver.findElement(By.id("gwt-debug-TravelAuthorization_totalCostOfBanquet_TB")).sendKeys(e[17]);
                    element = driver.findElement(By.id("gwt-debug-TravelAuthorization_banquetExpensePaymentMode_LB"));
                    Select banquetExpensePaymentType = new Select(element);
                    banquetExpensePaymentType.selectByVisibleText(e[18]);
                    driver.findElement(By.id("gwt-debug-TravelAuthorization_otherExpences_TB")).sendKeys(e[19]);
                    element = driver.findElement(By.id("gwt-debug-TravelAuthorization_otherExpensePaymentMode_LB"));
                    Select otherExpensePaymentType = new Select(element);
                    otherExpensePaymentType.selectByVisibleText(e[20]);

                    driver.findElement(By.xpath("//div/div/div/div/fieldset/div/div[2]/button")).click();
                    waitForLoader();
                    sleep(2000);

                    j = 3;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("TravelAuthorization_Update");
        System.out.println("Exit TravelAuthorization Update: " + new Date());
    }

    @Test(description = "TravelAuthorizationDelete", dataProvider = "travelAuthorizationDeleteData", groups = "travelAuthorization", dependsOnGroups = "expenseReports", priority = 6)
    public void testDeleteTravelAuthorization(String[][] TravelAuthorizationData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter TravelAuthorization Delete: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : TravelAuthorizationData) {
            int i = 2;
            int j = 3;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[4]/img")).click();
                    Alert alt = driver.switchTo().alert();
                    alt.accept();

                    waitForLoader();
                    sleep(2000);

                    j = 3;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("TravelAuthorization_Delete");
        System.out.println("Exit TravelAuthorization Delete: " + new Date());
    }

    @Test(description = "TravelAuthorizationAdvancedSearch", groups = "travelAuthorization", dependsOnGroups = "expenseReports", priority = 7)
    public void testAdvancedSearchTravelAuthorization() throws InterruptedException, IOException {
        System.out.println("Enter TravelAuthorization Adv Search: " + new Date());

        driver.findElement(By.id("gwt-debug-TravelAuthorization_employee_TB")).sendKeys("admin");
        WebElement element = driver.findElement(By.id("gwt-debug-TravelAuthorization_status_LB"));
        Select label = new Select(element);
        label.selectByIndex(1);

        driver.findElement(By.xpath("//div[5]/div/div[3]/div/div/div/div/fieldset/div/button")).click();
        waitForLoader();
        sleep(2000);

        takeScreenshot("TravelAuthorization_AdvancedSearch");
        System.out.println("Exit  TravelAuthorization Adv Search: " + new Date());
    }

    @DataProvider(name = "travelAuthorizationCreateData")
    private Object[][] travelAuthorizationCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateTravelAuthorization");
    }

    @DataProvider(name = "travelAuthorizationViewData")
    private Object[][] travelAuthorizationViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewTravelAuthorization");
    }

    @DataProvider(name = "travelAuthorizationQuickViewData")
    private Object[][] travelAuthorizationQuickViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("QuickViewTravelAuthorization");
    }

    @DataProvider(name = "travelAuthorizationUpdateData")
    private Object[][] travelAuthorizationUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateTravelAuthorization");
    }

    @DataProvider(name = "travelAuthorizationDeleteData")
    private Object[][] travelAuthorizationDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeleteTravelAuthorization");
    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Expense_TravelAuthorization.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();
        String[][] TravelAuthorizationData = new String[rowcount + 1][21];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);
            TravelAuthorizationData[i][0] = row.getCell(0).getStringCellValue();
            TravelAuthorizationData[i][1] = row.getCell(1).getStringCellValue();
            TravelAuthorizationData[i][2] = row.getCell(2).getStringCellValue();
            TravelAuthorizationData[i][3] = row.getCell(3).getStringCellValue();
            TravelAuthorizationData[i][4] = row.getCell(4).getStringCellValue();
            TravelAuthorizationData[i][5] = row.getCell(5).getStringCellValue();
            TravelAuthorizationData[i][6] = row.getCell(6).getStringCellValue();
            TravelAuthorizationData[i][7] = row.getCell(7).getStringCellValue();
            TravelAuthorizationData[i][8] = row.getCell(8).getStringCellValue();
            TravelAuthorizationData[i][9] = row.getCell(9).getStringCellValue();
            TravelAuthorizationData[i][10] = row.getCell(10).getStringCellValue();
            TravelAuthorizationData[i][11] = row.getCell(11).getStringCellValue();
            TravelAuthorizationData[i][12] = row.getCell(12).getStringCellValue();
            TravelAuthorizationData[i][13] = row.getCell(13).getStringCellValue();
            TravelAuthorizationData[i][14] = row.getCell(14).getStringCellValue();
            TravelAuthorizationData[i][15] = row.getCell(15).getStringCellValue();
            TravelAuthorizationData[i][16] = row.getCell(16).getStringCellValue();
            TravelAuthorizationData[i][17] = row.getCell(17).getStringCellValue();
            TravelAuthorizationData[i][18] = row.getCell(18).getStringCellValue();
            TravelAuthorizationData[i][19] = row.getCell(19).getStringCellValue();
            TravelAuthorizationData[i][20] = row.getCell(20).getStringCellValue();

        }

        return new Object[][]{{TravelAuthorizationData}};
    }
}
