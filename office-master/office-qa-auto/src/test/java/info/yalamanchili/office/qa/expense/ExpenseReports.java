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
public class ExpenseReports extends AbstractOfficeTest {

    @Test(description = "ExpenseReports Section", groups = "expenseReports", dependsOnGroups = "checkRequisition", priority = 1)
    public void testViewExpenseReports() throws IOException, InterruptedException {
        System.out.println("Enter ExpenseReports Section: " + new Date());

        driver.findElement(By.xpath("//div[5]/div/div[2]/div/table/tbody/tr/td[4]/div")).click();
        waitForLoader();
        sleep(2000);

        driver.findElement(By.xpath("html/body/div[4]/div/div/fieldset/div/span/input")).click();

        takeScreenshot("ExpenseReports_Section");
        System.out.println("Exit ExpenseReports Section: " + new Date());
    }

    @Test(description = "ExpenseReports Create", dataProvider = "expenseReportsCreateData", groups = "expenseReports", dependsOnGroups = "checkRequisition", priority = 2)
    public void testCreateExpenseReports(String[][] ExpenseReportsData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter ExpenseReports Create: " + new Date());

        for (String[] e : ExpenseReportsData) {

            driver.findElement(By.xpath("//div[5]/div/div[4]/div/div/div/div/fieldset/div/button")).click();

            WebElement element = driver.findElement(By.id("gwt-debug-ExpenseReport_expenseFormType_LB"));
            Select company = new Select(element);
            company.selectByValue(e[0]);
            driver.findElement(By.id("gwt-debug-ExpenseReport_location_TB")).sendKeys(e[1]);
            driver.findElement(By.id("gwt-debug-ExpenseReport_startDate_TB")).sendKeys(e[2]);
            driver.findElement(By.id("gwt-debug-ExpenseReport_endDate_TB")).sendKeys(e[3]);

            if (e[0].equalsIgnoreCase("GENERAL_EXPENSE")) {
                driver.findElement(By.id("gwt-debug-ApprovalManager_approvalManager_TB")).sendKeys("admin admin");
            } else {
                driver.findElement(By.id("gwt-debug-ExpenseReport_projectName_TB")).sendKeys(e[4]);
                driver.findElement(By.id("gwt-debug-ExpenseReport_projectNumber_TB")).sendKeys(e[5]);
            }

            driver.findElement(By.id("gwt-debug-ExpenseItem_expenseDate_TB")).sendKeys(e[6]);
            driver.findElement(By.id("gwt-debug-ExpenseItem_purpose_TB")).sendKeys(e[7]);
            element = driver.findElement(By.id("gwt-debug-ExpenseCategory_expenseCategory_LB"));
            Select category = new Select(element);
            category.selectByVisibleText(e[8]);
            element = driver.findElement(By.id("gwt-debug-ExpenseItem_expensePaymentMode_LB"));
            Select paymentMode = new Select(element);
            paymentMode.selectByVisibleText(e[9]);
            driver.findElement(By.id("gwt-debug-ExpenseItem_amount_TB")).sendKeys(e[10]);

            driver.findElement(By.xpath("//div/div/div/div/fieldset/div/div[2]/button")).click();
            Alert alt = driver.switchTo().alert();
            alt.accept();

            waitForLoader();
            sleep(5000);
        }

        takeScreenshot("ExpenseReports_Create");
        System.out.println("Exit ExpenseReports Create: " + new Date());
    }

    @Test(description = "ExpenseReports QuickView", dataProvider = "expenseReportsQuickViewData", groups = "expenseReports", dependsOnGroups = "checkRequisition", priority = 3)
    public void testExpenseReportsQuickView(String[][] ExpenseReportsData) throws InterruptedException, IOException, AWTException {
        System.out.println("Enter ExpenseReports QuickView: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : ExpenseReportsData) {
            int i = 2;
            int j = 4;
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

                    driver.findElement(By.xpath("//div[2]/div/fieldset/div/button")).click();
                    driver.findElement(By.id("gwt-debug-Comment_comment_TB")).sendKeys("Test Comments");
                    driver.findElement(By.id("gwt-debug-Employee_search_TB")).sendKeys("admin admin");
                    driver.findElement(By.xpath("//div[2]/button")).click();
                    waitForLoader();
                    sleep(2000);

                    j = 4;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("ExpenseReports_QuickView");

        driver.findElement(By.xpath("//div/div/div[2]/div/div[4]/div/div")).click();
        waitForLoader();
        sleep(2000);

        System.out.println("Exit ExpenseReports QuickView: " + new Date());
    }

    @Test(description = "ExpenseReportsView", dataProvider = "expenseReportsViewData", groups = "expenseReports", dependsOnGroups = "checkRequisition", priority = 4)
    public void testExpenseReportsView(String[][] ExpenseReportsData) throws InterruptedException, IOException {
        System.out.println("Enter ExpenseReports View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : ExpenseReportsData) {
            int i = 2;
            int j = 4;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();
                    waitForLoader();
                    sleep(2000);

                    j = 4;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("ExpenseReports_View");

        driver.findElement(By.xpath("//div[5]/div/div[2]/div/table/tbody/tr/td[4]/div")).click();
        waitForLoader();
        sleep(2000);

        System.out.println("Exit ExpenseReports View: " + new Date());
    }

    @Test(description = "ExpenseReports Update", dataProvider = "expenseReportsUpdateData", groups = "expenseReports", dependsOnGroups = "checkRequisition", priority = 5)
    public void testUpdateExpenseReports(String[][] ExpenseReportsData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter ExpenseReports Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : ExpenseReportsData) {
            int i = 2;
            int j = 4;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[3]/img")).click();
                    waitForLoader();
                    sleep(2000);

                    driver.findElement(By.id("gwt-debug-ExpenseReport_location_TB")).clear();
                    driver.findElement(By.id("gwt-debug-ExpenseReport_startDate_TB")).clear();
                    driver.findElement(By.id("gwt-debug-ExpenseReport_endDate_TB")).clear();

                    if (e[0].equalsIgnoreCase("GENERAL_EXPENSE")) {
                        driver.findElement(By.id("gwt-debug-ExpenseItem_description_TB")).clear();
                    } else {
                        driver.findElement(By.id("gwt-debug-ExpenseReport_projectName_TB")).clear();
                        driver.findElement(By.id("gwt-debug-ExpenseReport_projectNumber_TB")).clear();
                    }

                    driver.findElement(By.id("gwt-debug-ExpenseItem_expenseDate_TB")).clear();
                    driver.findElement(By.id("gwt-debug-ExpenseItem_purpose_TB")).clear();
                    driver.findElement(By.id("gwt-debug-ExpenseItem_amount_TB")).clear();

                    driver.findElement(By.id("gwt-debug-ExpenseReport_location_TB")).sendKeys(e[1]);
                    driver.findElement(By.id("gwt-debug-ExpenseReport_startDate_TB")).sendKeys(e[2]);
                    driver.findElement(By.id("gwt-debug-ExpenseReport_endDate_TB")).sendKeys(e[3]);

                    if (e[0].equalsIgnoreCase("GENERAL_EXPENSE")) {
                        driver.findElement(By.id("gwt-debug-ExpenseItem_description_TB")).sendKeys(e[7]);
                    } else {
                        driver.findElement(By.id("gwt-debug-ExpenseReport_projectName_TB")).sendKeys(e[4]);
                        driver.findElement(By.id("gwt-debug-ExpenseReport_projectNumber_TB")).sendKeys(e[5]);
                    }

                    driver.findElement(By.id("gwt-debug-ExpenseItem_expenseDate_TB")).sendKeys(e[6]);
                    driver.findElement(By.id("gwt-debug-ExpenseItem_purpose_TB")).sendKeys(e[7]);
                    WebElement element = driver.findElement(By.id("gwt-debug-ExpenseCategory_expenseCategory_LB"));
                    Select category = new Select(element);
                    category.selectByVisibleText(e[8]);
                    element = driver.findElement(By.id("gwt-debug-ExpenseItem_expensePaymentMode_LB"));
                    Select paymentMode = new Select(element);
                    paymentMode.selectByVisibleText(e[9]);
                    driver.findElement(By.id("gwt-debug-ExpenseItem_amount_TB")).sendKeys(e[10]);

                    driver.findElement(By.xpath("//div/div/div/div/fieldset/div/div[2]/button")).click();
                    waitForLoader();
                    sleep(2000);

                    j = 4;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("ExpenseReports_Update");
        System.out.println("Exit ExpenseReports Update: " + new Date());
    }

    @Test(description = "ExpenseReports Copy", dataProvider = "expenseReportsCopyData", groups = "expenseReports", dependsOnGroups = "checkRequisition", priority = 6, enabled = false)
    public void testCopyExpenseReports(String[][] ExpenseReportsData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter ExpenseReports Copy: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : ExpenseReportsData) {
            int i = 2;
            int j = 4;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[6]/img")).click();
                    waitForLoader();
                    sleep(2000);

                    driver.findElement(By.id("gwt-debug-ExpenseReport_location_TB")).clear();
                    driver.findElement(By.id("gwt-debug-ExpenseReport_startDate_TB")).clear();
                    driver.findElement(By.id("gwt-debug-ExpenseReport_endDate_TB")).clear();
                    driver.findElement(By.id("gwt-debug-ExpenseReport_projectName_TB")).clear();
                    driver.findElement(By.id("gwt-debug-ExpenseReport_projectNumber_TB")).clear();
                    driver.findElement(By.id("gwt-debug-ExpenseItem_expenseDate_TB")).clear();
                    driver.findElement(By.id("gwt-debug-ExpenseItem_purpose_TB")).clear();
                    driver.findElement(By.id("gwt-debug-ExpenseItem_expenseMiles_TB")).clear();

                    driver.findElement(By.id("gwt-debug-ExpenseReport_location_TB")).sendKeys(e[1]);
                    driver.findElement(By.id("gwt-debug-ExpenseReport_startDate_TB")).sendKeys(e[2]);
                    driver.findElement(By.id("gwt-debug-ExpenseReport_endDate_TB")).sendKeys(e[3]);
                    driver.findElement(By.id("gwt-debug-ExpenseReport_projectName_TB")).sendKeys(e[4]);
                    driver.findElement(By.id("gwt-debug-ExpenseReport_projectNumber_TB")).sendKeys(e[5]);
                    driver.findElement(By.id("gwt-debug-ExpenseItem_expenseDate_TB")).sendKeys(e[6]);
                    driver.findElement(By.id("gwt-debug-ExpenseItem_purpose_TB")).sendKeys(e[7]);
                    WebElement element = driver.findElement(By.id("gwt-debug-ExpenseCategory_expenseCategory_LB"));
                    Select category = new Select(element);
                    category.selectByVisibleText(e[8]);
                    driver.findElement(By.id("gwt-debug-ExpenseItem_expenseMiles_TB")).sendKeys(e[9]);
                    element = driver.findElement(By.id("gwt-debug-ExpenseItem_expensePaymentMode_LB"));
                    Select paymentMode = new Select(element);
                    paymentMode.selectByVisibleText(e[10]);

                    driver.findElement(By.xpath("//div/div/div/div/fieldset/div/div[2]/button")).click();
                    waitForLoader();
                    sleep(2000);

                    j = 4;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("ExpenseReports_Copy");
        System.out.println("Exit ExpenseReports Copy: " + new Date());
    }

    @Test(description = "ExpenseReportsAdvancedSearch", groups = "expenseReports", dependsOnGroups = "checkRequisition", priority = 7)
    public void testAdvancedSearchExpenseReports() throws InterruptedException, IOException {
        System.out.println("Enter ExpenseReports Adv Search: " + new Date());

        driver.findElement(By.id("gwt-debug-ExpenseReports_employeeFirstName_TB")).sendKeys("admin");
        driver.findElement(By.id("gwt-debug-ExpenseReports_employeeLastName_TB")).sendKeys("admin");
        WebElement element = driver.findElement(By.id("gwt-debug-ExpenseReports_status_LB"));
        Select label = new Select(element);
        label.selectByIndex(1);

        driver.findElement(By.xpath("//div[5]/div/div[3]/div/div/div/div/fieldset/div/button")).click();
        waitForLoader();
        sleep(2000);

        takeScreenshot("ExpenseReports_AdvancedSearch");
        System.out.println("Exit  ExpenseReports Adv Search: " + new Date());
    }

    @Test(description = "ExpenseReportsDelete", dataProvider = "expenseReportsDeleteData", groups = "expenseReports", dependsOnGroups = "checkRequisition", priority = 8)
    public void testDeleteExpenseReports(String[][] ExpenseReportsData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter ExpenseReports Delete: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : ExpenseReportsData) {
            int i = 2;
            int j = 4;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[4]/img")).click();
                    Alert alt = driver.switchTo().alert();
                    alt.accept();

                    waitForLoader();
                    sleep(2000);

                    j = 4;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("ExpenseReports_Delete");
        System.out.println("Exit ExpenseReports Delete: " + new Date());
    }

    @DataProvider(name = "expenseReportsCreateData")
    private Object[][] expenseReportsCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateExpenseReports");
    }

    @DataProvider(name = "expenseReportsViewData")
    private Object[][] expenseReportsViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewExpenseReports");
    }

    @DataProvider(name = "expenseReportsQuickViewData")
    private Object[][] expenseReportsQuickViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("QuickViewExpenseReports");
    }

    @DataProvider(name = "expenseReportsUpdateData")
    private Object[][] expenseReportsUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateExpenseReports");
    }

    @DataProvider(name = "expenseReportsCopyData")
    private Object[][] expenseReportsCopyData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CopyExpenseReports");
    }

    @DataProvider(name = "expenseReportsDeleteData")
    private Object[][] expenseReportsDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeleteExpenseReports");
    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Expense_ExpenseReports.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();
        String[][] ExpenseReportsData = new String[rowcount + 1][11];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);
            ExpenseReportsData[i][0] = row.getCell(0).getStringCellValue();
            ExpenseReportsData[i][1] = row.getCell(1).getStringCellValue();
            ExpenseReportsData[i][2] = row.getCell(2).getStringCellValue();
            ExpenseReportsData[i][3] = row.getCell(3).getStringCellValue();
            ExpenseReportsData[i][4] = row.getCell(4).getStringCellValue();
            ExpenseReportsData[i][5] = row.getCell(5).getStringCellValue();
            ExpenseReportsData[i][6] = row.getCell(6).getStringCellValue();
            ExpenseReportsData[i][7] = row.getCell(7).getStringCellValue();
            ExpenseReportsData[i][8] = row.getCell(8).getStringCellValue();
            ExpenseReportsData[i][9] = row.getCell(9).getStringCellValue();
            ExpenseReportsData[i][10] = row.getCell(10).getStringCellValue();

        }

        return new Object[][]{{ExpenseReportsData}};
    }
}
