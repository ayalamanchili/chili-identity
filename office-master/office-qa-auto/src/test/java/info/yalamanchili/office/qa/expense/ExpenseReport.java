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
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

/**
 *
 * @author Ramana.Lukalapu
 */
public class ExpenseReport extends AbstractOfficeTest {
     private boolean acceptNextAlert = true;

    @Test(description = "test ExpenseReport", groups = "expense", dependsOnGroups = "citest")
    public void expenseReport() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[2]/div/table/tbody/tr/td[4]/div")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("html/body/div[4]/div/div/fieldset/div/span/input")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
        WebElement formType = driver.findElement(By.id("gwt-debug-ExpenseReport_expenseFormType_LB"));
        Select formName = new Select(formType);
        formName.selectByValue("TRAVEL_EXPENSE");
        driver.findElement(By.id("gwt-debug-ExpenseReport_location_TB")).sendKeys("Tampa");
        driver.findElement(By.id("gwt-debug-ExpenseReport_startDate_TB")).sendKeys("03/21/2016");
        driver.findElement(By.id("gwt-debug-ExpenseReport_endDate_TB")).sendKeys("03/28/2016");
        driver.findElement(By.id("gwt-debug-ExpenseReport_projectName_TB")).sendKeys("Portal");
        driver.findElement(By.id("gwt-debug-ExpenseReport_projectNumber_TB")).sendKeys("SST1234");
        //WebElement element = driver.findElement(By.className("gwt-FileUpload"));
        //element.click();
        //uploadFile("F:\\PaySlips\\IMG.jpg");
        //Thread.sleep(2000);
        driver.findElement(By.id("gwt-debug-ExpenseItem_expenseDate_TB")).sendKeys("03/25/2016");
        driver.findElement(By.id("gwt-debug-ExpenseItem_purpose_TB")).sendKeys("hai");
        WebElement expenseCategory = driver.findElement(By.id("gwt-debug-ExpenseCategory_expenseCategory_LB"));
        Select catName = new Select(expenseCategory);
        catName.selectByValue("7");
        WebElement expensePayMode = driver.findElement(By.id("gwt-debug-ExpenseItem_expensePaymentMode_LB"));
        Select modeName = new Select(expensePayMode);
        modeName.selectByValue("PERSONAL_CARD");
        driver.findElement(By.id("gwt-debug-ExpenseItem_amount_TB")).sendKeys("18000");
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div[2]/button")).click();
        assertTrue(closeAlertAndGetItsText().matches("^You expense report does not have any receipts attached so will not be processed\\. Are you sure you still want to submit[\\s\\S]$"));
        waitForTime(20);
    }

    /*public static void setClipboardData(String string) {

        //StringSelection is a class that can be used for copy and paste operations.
        StringSelection stringSelection = new StringSelection(string);

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

    }

    public static void uploadFile(String fileLocation) {

        try {

            //Setting clipboard with file location
            setClipboardData(fileLocation);

            //native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_CONTROL);

            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.keyPress(KeyEvent.VK_ENTER);

            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (Exception exp) {

            exp.printStackTrace();

        }

    }*/
    

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }

}
