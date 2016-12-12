/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa.myoffice;

import info.yalamanchili.office.qa.AbstractOfficeTest;
import static info.yalamanchili.office.qa.AbstractOfficeTest.driver;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author joel kolli
 */
public class OnBoarding extends AbstractOfficeTest {

    @Test(description = "OnBoarding Section", groups = "onBoarding", dependsOnGroups = "employees", priority = 1)
    public void testViewOnBoarding() throws IOException {
        System.out.println("Enter OnBoarding Section: " + new Date());

        driver.findElement(By.id("OnBoarding")).click();
        waitForLoader();

        takeScreenshot("OnBoarding_Section");
        System.out.println("Exit OnBoarding Section: " + new Date());
    }

    @Test(description = "OnBoarding Create", dataProvider = "onBoardingCreateData", groups = "onBoarding", dependsOnGroups = "employees", priority = 2)
    public void testCreateOnBoarding(String[][] OnBoardingData) throws IOException, InterruptedException {
        System.out.println("Enter OnBoarding Create: " + new Date());

        for (String[] e : OnBoardingData) {

            driver.findElement(By.cssSelector("button.gwt-Button")).click();
            fluentWaitForElementId("gwt-debug-EmployeeType_employeeType_LB");

            driver.findElement(By.id("gwt-debug-InitiateOnBoarding_email_TB")).sendKeys(e[0]);
            WebElement element = driver.findElement(By.id("gwt-debug-EmployeeType_employeeType_LB"));
            Select employeeType = new Select(element);
            employeeType.selectByVisibleText(e[1]);
            element = driver.findElement(By.id("gwt-debug-Company_company_LB"));
            Select company = new Select(element);
            company.selectByVisibleText(e[2]);
            driver.findElement(By.id("gwt-debug-InitiateOnBoarding_startDate_TB")).sendKeys(e[3]);
            fluentWaitForElementId("gwt-debug-InitiateOnBoarding_branch_LB");
            element = driver.findElement(By.id("gwt-debug-InitiateOnBoarding_branch_LB"));
            Select branch = new Select(element);
            branch.selectByValue(e[4]);
            element = driver.findElement(By.id("gwt-debug-InitiateOnBoarding_workStatus_LB"));
            Select workStatus = new Select(element);
            workStatus.selectByValue(e[5]);

            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
            waitForLoader();
            sleep(10000);
        }
        
        takeScreenshot("OnBoarding_Create");
        System.out.println("Exit OnBoarding Create: " + new Date());
    }

    @Test(description = "OnBoarding View", dataProvider = "onBoardingViewData", groups = "onBoarding", dependsOnGroups = "employees", priority = 3)
    public void testOnBoardingView(String[][] OnBoardingData) throws InterruptedException, IOException {
        System.out.println("Enter OnBoarding View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : OnBoardingData) {
            int i = 2;
            int j = 6;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {
                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[1]/img")).click();
                    waitForLoader();
                    sleep(5000);

                    driver.findElement(By.xpath("//button")).click();
                    driver.findElement(By.id("gwt-debug-Comment_comment_TB")).sendKeys("Test Comments");
                    driver.findElement(By.id("gwt-debug-Employee_search_TB")).sendKeys("admin admin");
                    driver.findElement(By.linkText("Add"));
                    driver.findElement(By.xpath("//div[2]/button")).click();

                    j = 6;
                    matchFound = true;
                } else {
                    i++;
                }
            }
        }

        waitForLoader();
        Thread.sleep(5000);
        takeScreenshot("OnBoarding_View");
        System.out.println("Exit OnBoarding View: " + new Date());
    }

    @Test(description = "CommentUpdate", groups = "onBoarding", dependsOnGroups = "employees", priority = 4)
    public void testCommentUpdate() throws InterruptedException, IOException {
        System.out.println("Enter Onboarding Comment Update: " + new Date());

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div[1]/div/fieldset/div/div/table/tbody/tr[2]/td[1]/table/tbody/tr/td[1]/img")).click();

        /*
         Code To be added for Comment Update
         */
        waitForLoader();
        Thread.sleep(5000);
        takeScreenshot("OnboardingComment_Update");
        System.out.println("Exit Onboarding Comment Update: " + new Date());
    }

    @Test(description = "CommentDelete", groups = "onBoarding", dependsOnGroups = "employees", priority = 5)
    public void testCommentDelete() throws InterruptedException, IOException {
        System.out.println("Enter Onboarding Comment Delete: " + new Date());

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div[1]/div/fieldset/div/div/table/tbody/tr[2]/td[1]/table/tbody/tr/td[2]/img")).click();
        Alert alt = driver.switchTo().alert();
        alt.accept();

        waitForLoader();
        Thread.sleep(5000);
        takeScreenshot("OnboardingComment_Delete");
        System.out.println("Exit Onboarding Comment Delete: " + new Date());
    }

    @DataProvider(name = "onBoardingCreateData")
    private Object[][] onBoardingCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateOnBoarding");
    }

    @DataProvider(name = "onBoardingViewData")
    private Object[][] onBoardingViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewOnBoarding");
    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\MyOffice_OnBoarding.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();

        String[][] OnBoardingData = new String[rowcount + 1][6];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);

            OnBoardingData[i][0] = row.getCell(0).getStringCellValue();
            OnBoardingData[i][1] = row.getCell(1).getStringCellValue();
            OnBoardingData[i][2] = row.getCell(2).getStringCellValue();
            OnBoardingData[i][3] = row.getCell(3).getStringCellValue();
            OnBoardingData[i][4] = row.getCell(4).getStringCellValue();
            OnBoardingData[i][5] = row.getCell(5).getStringCellValue();

        }

        return new Object[][]{{OnBoardingData}};
    }
}