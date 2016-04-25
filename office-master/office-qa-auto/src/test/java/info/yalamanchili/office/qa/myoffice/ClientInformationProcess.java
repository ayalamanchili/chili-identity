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
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;  
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 *
 * @author Uday.Yadalla
 */
public class ClientInformationProcess extends AbstractOfficeTest {

   @Test(description="test employee search",groups="citest", dependsOnGroups = "login")
    public void testSearchEmployee() throws InterruptedException {
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[2]/div/div[2]/div/div"));
        WebElement searchTextBox = driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[3]/div/div[1]/div/div/fieldset/div/input"));
        searchTextBox.sendKeys("pavan");
        searchTextBox.sendKeys(Keys.RETURN);
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[2]/td[1]/table/tbody/tr/td[2]/img")).click();
        waitForTime(20);
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[3]/div/div[1]/div/div/div/div[2]/div/div[4]/div/div")).click();

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/button")).click();

        driver.findElement(By.id("gwt-debug-ClientInfo_consultantJobTitle_TB")).clear();

        driver.findElement(By.id("gwt-debug-ClientInfo_consultantJobTitle_TB")).sendKeys("java Developer");

        WebElement company = driver.findElement(By.id("gwt-debug-ClientInfo_company_LB"));

        Select companyName = new Select(company);

        companyName.selectByValue("Techpillars");

        WebElement client = driver.findElement(By.id("gwt-debug-Client_client_LB"));

        Select clientName = new Select(client);

        clientName.selectByValue("1");

        WebElement clientLocation = driver.findElement(By.id("gwt-debug-ClientLocation_clientLocation_LB"));

        Select clName = new Select(clientLocation);

        clName.selectByValue("7");
        
        WebElement vendor = driver.findElement(By.id("gwt-debug-Vendor_vendor_LB"));

        Select vName = new Select(vendor);

        vName.selectByValue("1");
        
        WebElement vendorLocation = driver.findElement(By.id("gwt-debug-VendorLocation_vendorLocation_LB"));

        Select vLocation = new Select(vendorLocation);

        vLocation.selectByValue("6");

        driver.findElement(By.id("gwt-debug-ClientInfo_startDate_TB")).sendKeys("01/01/2016");

        driver.findElement(By.id("gwt-debug-ClientInfo_endDate_TB")).sendKeys("01/30/2016");

        driver.findElement(By.id("gwt-debug-ClientInfo_billingRate_TB")).sendKeys("1234");

        WebElement invoiceFreq = driver.findElement(By.id("gwt-debug-ClientInfo_invoiceFrequency_LB"));

        Select ifName = new Select(invoiceFreq);

        ifName.selectByValue("MONTHLY");

        WebElement practice = driver.findElement(By.id("gwt-debug-Practice_practice_LB"));

        Select practiceValue = new Select(practice);

        practiceValue.selectByValue("1");

        WebElement sBus = driver.findElement(By.id("gwt-debug-ClientInfo_sectorsAndBUs_LB"));

        Select sBusValue = new Select(sBus);

        sBusValue.selectByValue("NA");

        //WebElement submitForApproval = driver.findElement(By.id("gwt-debug-ClientInfo_Submit For Approval_CB"));
        //submitForApproval.click();

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div[2]/button")).click();

        System.out.println("Client information Submitted and Status is: Pending Billing Invoicing approval");

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[2]/div/div[1]/div/div")).click();

        Thread.sleep(7000);// Wait 
        
        driver.findElement(By.id("gwt-debug-My TasksCL")).click();

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[2]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[2]/td[1]/table/tbody/tr/td[2]/img")).click();
        
        Thread.sleep(5000);
        
        driver.findElement(By.xpath("//div[6]/fieldset")).click();
        
        WebElement status = driver.findElement(By.id("gwt-debug-Fill_the_form_and_complete_the_task_status_LB"));
        
        Select value = new Select(status);
        
        value.selectByValue("approved");

        driver.findElement(By.id("gwt-debug-Fill_the_form_and_complete_the_task_itemNumber_TB")).sendKeys("1234");

        driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();

        System.out.println("Client information First level Billing task is completed");

        /*driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[2]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[2]/td[1]/table/tbody/tr/td[2]/img")).click();
        
        Thread.sleep(5000);
        
        driver.findElement(By.xpath("//div[6]/fieldset")).click();

        WebElement status1 = driver.findElement(By.id("gwt-debug-Fill_the_form_and_complete_the_task_status_LB"));
        
        Select value1 = new Select(status1);
        
        value1.selectByValue("approved");
        
        driver.findElement(By.id("gwt-debug-Fill_the_form_and_complete_the_task_joiningReport_TB")).sendKeys("he is joined earlier");

        driver.findElement(By.id("gwt-debug-Fill_the_form_and_complete_the_task_hrOrientation_CB-input")).click();

        driver.findElement(By.id("gwt-debug-Fill_the_form_and_complete_the_task_logisticsPreparation_CB")).click();

        driver.findElement(By.id("gwt-debug-Fill_the_form_and_complete_the_task_notes_TB")).sendKeys("need to submit documents");

        driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[2]/div/div[2]/div/div")).click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath(".//*[@id='Employees']")).click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[2]/td[1]/table/tbody/tr/td[2]/img")).click();

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[3]/div/div[1]/div/div/div/div[2]/div/div[4]/div/div")).click();*/

    }
}
