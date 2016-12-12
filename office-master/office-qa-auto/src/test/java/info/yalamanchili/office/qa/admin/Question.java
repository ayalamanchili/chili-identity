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
public class Question extends AbstractOfficeTest {

    @Test(description = "testQuestionSection", groups = "question", dependsOnGroups = "notificationgroups", priority = 1)
    public void testQuestionSection() throws InterruptedException, IOException {
        System.out.println("Enter Question Section: " + new Date());

        driver.findElement(By.xpath("//div[9]/div/div")).click();
        waitForTime(10);
        driver.findElement(By.id("Question")).click();

        waitForLoader();
        Thread.sleep(3000);
        takeScreenshot("Question_Section");
        System.out.println("Exit Question Section: " + new Date());

    }

    @Test(description = "testQuestionCreate", dataProvider = "questionCreateData", groups = "question", dependsOnGroups = "notificationgroups", priority = 2)
    public void testQuestionCreate(String[][] QuestionData) throws InterruptedException, IOException {
        System.out.println("Enter Question Create: " + new Date());

        for (String[] e : QuestionData) {

            driver.findElement(By.xpath("//div[10]/div/div[4]/div/div/div/div/fieldset/div/button")).click();
            waitForTime(10);

            driver.findElement(By.id("gwt-debug-Question_questionKey_TB")).sendKeys(e[0]);
            WebElement element = driver.findElement(By.id("gwt-debug-Question_category_LB"));
            Select category = new Select(element);
            category.selectByValue(e[1]);
            
            element = driver.findElement(By.id("gwt-debug-Question_context_LB"));
            Select context = new Select(element);
            context.selectByValue(e[2]);
            
            driver.findElement(By.id("gwt-debug-Question_sortOrder_TB")).sendKeys(e[3]);
            driver.findElement(By.id("gwt-debug-Question_questionCommentRequired_CB-input")).click();
            driver.findElement(By.id("gwt-debug-Question_questionRatingRequired_CB-input")).click();

            driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
            waitForTime(10);
        }

        waitForLoader();
        takeScreenshot("Question_Create");

        System.out.println("Exit Question Create: " + new Date());
    }

    @Test(dataProvider = "questionUpdateData", description = "testQuestionUpdate", groups = "question", dependsOnGroups = "notificationgroups", priority = 3)
    public void testQuestionUpdate(String[][] QuestionData) throws InterruptedException, IOException {
        System.out.println("Enter Question Update: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[10]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : QuestionData) {

            int i = 2;
            int j = 2;
            boolean matchFound = false;

            while (!driver.findElements(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).isEmpty() && (!matchFound)) {

                if (driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend)).getText().equals(e[0])) {

                    j = 1;
                    driver.findElement(By.xpath(xpathstart + i + xpathbetween + j + xpathend + "/table/tbody/tr/td[2]/img")).click();
                    
                    driver.findElement(By.id("gwt-debug-Question_questionKey_TB")).clear();
                    driver.findElement(By.id("gwt-debug-Question_sortOrder_TB")).clear();
                    
                    driver.findElement(By.id("gwt-debug-Question_questionKey_TB")).sendKeys(e[0]);
                    WebElement element = driver.findElement(By.id("gwt-debug-Question_category_LB"));
                    Select category = new Select(element);
                    category.selectByValue(e[1]);
            
                    element = driver.findElement(By.id("gwt-debug-Question_context_LB"));
                    Select context = new Select(element);
                    context.selectByValue(e[2]);
            
                    driver.findElement(By.id("gwt-debug-Question_sortOrder_TB")).sendKeys(e[3]);
                    driver.findElement(By.id("gwt-debug-Question_questionCommentRequired_CB-input")).click();
                    driver.findElement(By.id("gwt-debug-Question_questionRatingRequired_CB-input")).click();
                    
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
        takeScreenshot("Question_Update");
        System.out.println("Exit Question Update: " + new Date());
    }

    @Test(description = "testQuestionView", dataProvider = "questionViewData", groups = "question", dependsOnGroups = "notificationgroups", priority = 4)
    public void testQuestionView(String[][] QuestionData) throws InterruptedException, IOException {
        System.out.println("Enter Question View: " + new Date());

        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[10]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : QuestionData) {

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

        takeScreenshot("Question_View");
        driver.findElement(By.id("Question")).click();
        System.out.println("Exit Question View: " + new Date());
    }
    
    @Test(description = "testQuestionDelete", dataProvider = "questionDeleteData", groups = "question", dependsOnGroups = "notificationgroups", priority = 5)
    public void testQuestionDelete(String[][] QuestionData) throws InterruptedException, IOException {
        System.out.println("Enter Question Delete: " + new Date());
        
        driver.findElement(By.id("Question")).click();
        String xpathstart = "html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[10]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[";
        String xpathbetween = "]/td[";
        String xpathend = "]";

        for (String[] e : QuestionData) {

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
        takeScreenshot("Question_Delete");
        System.out.println("Exit Question Delete: " + new Date());
    }

    @DataProvider(name = "questionCreateData")
    private Object[][] questionCreateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("CreateQuestion");

    }

    @DataProvider(name = "questionUpdateData")
    private Object[][] questionUpdateData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("UpdateQuestion");

    }
    
    @DataProvider(name = "questionViewData")
    private Object[][] questionViewData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("ViewQuestion");
    }

    @DataProvider(name = "questionDeleteData")
    private Object[][] questionDeleteData() throws EncryptedDocumentException, IOException, FileNotFoundException, InvalidFormatException {

        return fetchData("DeleteQuestion");

    }

    private Object[][] fetchData(String exceltab) throws EncryptedDocumentException, FileNotFoundException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        InputStream inputstream = new FileInputStream("C:\\codebase\\Dataprovider\\Admin_Question.xlsx");

        Workbook workbook = WorkbookFactory.create(inputstream);
        Sheet sheet = workbook.getSheet(exceltab);
        int rowcount = sheet.getLastRowNum();

        String[][] QuestionData = new String[rowcount + 1][4];

        for (int i = 0; i < rowcount + 1; i++) {

            Row row = sheet.getRow(i);

            QuestionData[i][0] = row.getCell(0).getStringCellValue();
            QuestionData[i][1] = row.getCell(1).getStringCellValue();
            QuestionData[i][2] = row.getCell(2).getStringCellValue();
            QuestionData[i][3] = row.getCell(3).getStringCellValue();

        }

        return new Object[][]{{QuestionData}};
    }
}