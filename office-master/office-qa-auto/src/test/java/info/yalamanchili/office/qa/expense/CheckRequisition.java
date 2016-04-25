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
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 *
 * @author Ramana.Lukalapu
 */
public class CheckRequisition extends AbstractOfficeTest {

    @Test(description = "test CheckRequisition", groups = "expense", dependsOnGroups = "citest")
    public void checkRequisition() throws InterruptedException {
        driver.findElement(By.id("Check Requisition")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/button")).click();
        WebElement searchTextBox = driver.findElement(By.id("gwt-debug-Employee_employee_TB"));
        searchTextBox.sendKeys("Abhinav Kota");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        searchTextBox.sendKeys(Keys.ENTER);
        driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_attorneyName_TB")).sendKeys("Ramana");
        driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_mailingAddress_TB")).sendKeys("abhi@yopmail.com");
        driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_neededByDate_TB")).sendKeys("03/21/2016");
        WebElement caseType = driver.findElement(By.id("gwt-debug-ImmigrationCheckRequisition_caseType_LB"));
        Select caseName = new Select(caseType);
        caseName.selectByValue("TRANSFER_H1B");
        driver.findElement(By.id("gwt-debug-Add Check ItemCL")).click();
        driver.findElement(By.id("gwt-debug-CheckRequisitionItem_itemName_TB")).sendKeys("Books");
        driver.findElement(By.id("gwt-debug-CheckRequisitionItem_itemDesc_TB")).sendKeys("corejava");
        driver.findElement(By.id("gwt-debug-CheckRequisitionItem_amount_TB")).sendKeys("15000");
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div[2]/button")).click();
        System.out.println("Successfully submitted");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}
