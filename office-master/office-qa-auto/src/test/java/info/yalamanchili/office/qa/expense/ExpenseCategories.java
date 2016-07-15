/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa.expense;

import info.yalamanchili.office.qa.AbstractOfficeTest;
import static info.yalamanchili.office.qa.AbstractOfficeTest.driver;
import java.awt.AWTException;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author joel kolli
 */
public class ExpenseCategories extends AbstractOfficeTest {

    @Test(description = "ExpenseCategories Section", groups = "expenseCategories", dependsOnGroups = "advanceRequisition", priority = 1)
    public void testViewExpenseCategories() throws IOException {
        System.out.println("Enter ExpenseCategories Section: " + new Date());

        driver.findElement(By.xpath("//div[5]/div/div[2]/div/table/tbody/tr/td[2]/div")).click();
        waitForLoader();

        takeScreenshot("ExpenseCategories_Section");
        System.out.println("Exit ExpenseCategories Section: " + new Date());
    }

    @Test(description = "ExpenseCategories Create", dataProvider = "expenseCategoriesCreateData", groups = "expenseCategories", dependsOnGroups = "advanceRequisition", priority = 2)
    public void testCreateExpenseCategories(String[][] ExpenseCategoriesData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter ExpenseCategories Create: " + new Date());

        for (String[] e : ExpenseCategoriesData) {

            driver.findElement(By.xpath("//div[5]/div/div[4]/div/div/div/div/fieldset/div/button")).click();
            driver.findElement(By.id("gwt-debug-ExpenseCategory_name_TB")).sendKeys(e[0]);
            driver.findElement(By.id("gwt-debug-ExpenseCategory_description_TB")).sendKeys(e[1]);

            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
            waitForLoader();
            sleep(2000);
        }

        takeScreenshot("ExpenseCategories_Create");
        System.out.println("Exit ExpenseCategories Create: " + new Date());
    }

    @Test(description = "ExpenseCategories View", dataProvider = "expenseCategoriesViewData", groups = "expenseCategories", dependsOnGroups = "advanceRequisition", priority = 3)
    public void testExpenseCategoriesView(String[][] ExpenseCategoriesData) throws InterruptedException, IOException {
        System.out.println("Enter ExpenseCategories View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : ExpenseCategoriesData) {
            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[1]/img")).click();
                    waitForLoader();
                    sleep(2000);
                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("ExpenseCategories_View");

        driver.findElement(By.xpath("//div[5]/div/div[2]/div/table/tbody/tr/td[2]/div")).click();
        waitForLoader();
        sleep(2000);

        System.out.println("Exit ExpenseCategories View: " + new Date());
    }

    @Test(description = "ExpenseCategories Update", dataProvider = "expenseCategoriesUpdateData", groups = "expenseCategories", dependsOnGroups = "advanceRequisition", priority = 4)
    public void testUpdateExpenseCategories(String[][] ExpenseCategoriesData) throws IOException, InterruptedException, AWTException {
        System.out.println("Enter ExpenseCategories Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : ExpenseCategoriesData) {
            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();
                    waitForLoader();

                    driver.findElement(By.id("gwt-debug-ExpenseCategory_name_TB")).clear();
                    driver.findElement(By.id("gwt-debug-ExpenseCategory_description_TB")).clear();

                    driver.findElement(By.id("gwt-debug-ExpenseCategory_name_TB")).sendKeys(e[0]);
                    driver.findElement(By.id("gwt-debug-ExpenseCategory_description_TB")).sendKeys(e[1]);

                    driver.findElement(By.xpath("//div[2]/button")).click();
                    waitForLoader();
                    sleep(2000);

                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        takeScreenshot("ExpenseCategories_Update");
        System.out.println("Exit ExpenseCategories Update: " + new Date());
    }

    @Test(description = "ExpenseCategoriesDelete", dataProvider = "expenseCategoriesDeleteData", groups = "expenseCategories", dependsOnGroups = "advanceRequisition", priority = 5)
    public void testExpenseCategoriesDelete(String[][] ExpenseCategoriesData) throws InterruptedException, IOException {
        System.out.println("Enter ExpenseCategories Delete: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : ExpenseCategoriesData) {
            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[3]/img")).click();
                    Alert alt = driver.switchTo().alert();
                    alt.accept();

                    waitForLoader();
                    sleep(2000);
                    takeScreenshot("ExpenseCategories_Delete");
                    j = 2;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        System.out.println("Exit ExpenseCategories Delete: " + new Date());
    }

    @DataProvider(name = "expenseCategoriesCreateData")
    private Object[][] expenseCategoriesCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateExpenseCategories");
    }

    @DataProvider(name = "expenseCategoriesViewData")
    private Object[][] expenseCategoriesViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewExpenseCategories");
    }

    @DataProvider(name = "expenseCategoriesUpdateData")
    private Object[][] expenseCategoriesUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateExpenseCategories");
    }

    @DataProvider(name = "expenseCategoriesDeleteData")
    private Object[][] expenseCategoriesDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeleteExpenseCategories");
    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Expense_ExpenseCategories.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();
        String[][] ExpenseCategoriesData = new String[rowcount + 1][2];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);
            ExpenseCategoriesData[i][0] = row.getCell(0).getStringCellValue();
            ExpenseCategoriesData[i][1] = row.getCell(1).getStringCellValue();
           
        }

        return new Object[][]{{ExpenseCategoriesData}};
    }
}