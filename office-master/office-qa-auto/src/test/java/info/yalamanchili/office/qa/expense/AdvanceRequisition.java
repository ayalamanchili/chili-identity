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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 *
 * @author Ramana.Lukalapu
 */
public class AdvanceRequisition extends AbstractOfficeTest {

    @Test(description = "test AdvanceRequisition search", groups = "expense", dependsOnGroups = "login")
    public void advanceRequisition() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);// Wait 

        driver.manage().window().maximize();

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[2]/div/div[4]/div/div")).click();

        driver.findElement(By.id("Advance Requisition")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("html/body/div[4]/div/div/fieldset/div/span/input")).click();
        WebElement create = driver.findElement(By.xpath("(//button[@type='button'])[5]"));
        create.click();
        driver.findElement(By.id("gwt-debug-AdvanceRequisition_purpose_TB")).sendKeys("For learning");
        driver.findElement(By.id("gwt-debug-AdvanceRequisition_amount_TB")).sendKeys("15000");
        driver.findElement(By.id("gwt-debug-AdvanceRequisition_neededBy_TB")).sendKeys("03/25/2016");
        driver.findElement(By.id("gwt-debug-AdvanceRequisition_repaymentMonths_TB")).sendKeys("3");
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div[1]/span[3]/input")).click();
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/div[2]/button")).click();
    }
}
