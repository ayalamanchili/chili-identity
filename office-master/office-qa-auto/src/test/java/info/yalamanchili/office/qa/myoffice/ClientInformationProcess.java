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

    @Test(description="test employee search",groups="empsearch",dependsOnGroups = "expense")
    public void testSearchEmployee() throws InterruptedException {
        System.out.println("Enter Employee Search: " + new Date());

        //wait for search box to appear
//        WebElement searchTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='gwt-SuggestBox searchComposite']")));

        //wait for remaining screen loading to complete
        WebElement rowElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='y-gwt-ReadAllComposite-Row y-gwt-ReadAllComposite-OddRow']")));

        //enter search string
//        searchTextBox.clear();
//        searchTextBox.sendKeys("First1");
//        searchTextBox.sendKeys(Keys.RETURN);

        //wait for rowElement to disappear because there are now rowelements in positive search results
        waitForStaleness(rowElement);

        System.out.println("Exit Employee Search: " + new Date());
    }

    @Test(description="client information",groups="citest",dependsOnGroups="empsearch")
    public void clientInformationTest() throws InterruptedException {

        driver.findElement(By.xpath("(//img[@title='View'])[11]")).click();

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[3]/div/div[1]/div/div/div/div[2]/div/div[4]/div/div")).click();

        driver.findElement(By.id("gwt-debug-Add Client InformationCL")).click();

        driver.findElement(By.id("gwt-debug-ClientInfo_consultantJobTitle_TB")).clear();

        driver.findElement(By.id("gwt-debug-ClientInfo_consultantJobTitle_TB")).sendKeys("java Developer");

        WebElement company = driver.findElement(By.id("gwt-debug-ClientInfo_company_LB"));

        Select companyName = new Select(company);

        companyName.selectByValue("Techpillars");

        WebElement client = driver.findElement(By.id("gwt-debug-Client_client_LB"));

        Select clientName = new Select(client);

        clientName.selectByValue("1297");

        WebElement clientLocation = driver.findElement(By.id("gwt-debug-ClientLocation_clientLocation_LB"));

        Select clName = new Select(clientLocation);

        clName.selectByValue("2418");

        driver.findElement(By.id("gwt-debug-ClientInfo_startDate_TB")).sendKeys("01/01/2016");

        driver.findElement(By.id("gwt-debug-ClientInfo_endDate_TB")).sendKeys("01/30/2016");

        driver.findElement(By.id("gwt-debug-ClientInfo_billingRate_TB")).sendKeys("1234");

        driver.findElement(By.id("gwt-debug-ClientInfo_billingRate_TB")).sendKeys("1234");

        WebElement invoiceFreq = driver.findElement(By.id("gwt-debug-ClientInfo_invoiceFrequency_LB"));

        Select ifName = new Select(invoiceFreq);

        ifName.selectByValue("MONTHLY");

        WebElement practice = driver.findElement(By.id("gwt-debug-Practice_practice_LB"));

        Select practiceValue = new Select(practice);

        practiceValue.selectByValue("11");

        WebElement sBus = driver.findElement(By.id("gwt-debug-ClientInfo_sectorsAndBUs_LB"));

        Select sBusValue = new Select(sBus);

        sBusValue.selectByValue("4320-BANKING SECTOR");

        WebElement submitForApproval = driver.findElement(By.id("gwt-debug-ClientInfo_Submit For Approval_CB"));
        submitForApproval.click();

        driver.findElement(By.cssSelector("button.gwt-Button")).click();

        System.out.println("Client information Saved and Status is: Pending Contracts Submit");

        driver.findElement(By.xpath(".//*[@id='gwt-uid-21']/div")).click();

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[2]/td[1]/table/tbody/tr/td[3]/img")).click();
        WebElement clientLocation1 = driver.findElement(By.id("gwt-debug-ClientLocation_clientLocation_LB"));

        Select clName1 = new Select(clientLocation1);

        clName1.selectByValue("7");

        driver.findElement(By.id("gwt-debug-ClientInfo_visaStatus_TB")).sendKeys("approved");

        driver.findElement(By.xpath("//button[@type='button']")).click();

        System.out.println("Client information Submitted and Status is: Pending Billing Invoicing approval");

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div/table/tbody/tr[2]/td[1]/table/tbody/tr/td[3]/img")).click();

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div[1]/table[19]/tbody/tr/td[2]/table/tbody/tr/td[5]/img")).click();

        driver.findElement(By.id("gwt-debug-UpdateBillingRate_effectiveDate_TB")).sendKeys("01/06/2016");

        driver.findElement(By.id("gwt-debug-UpdateBillingRate_billingRate_TB")).sendKeys("5555");

        driver.findElement(By.id("gwt-debug-UpdateBillingRate_overTimeBillingRate_TB")).sendKeys("6666");

        new Select(driver.findElement(By.id("gwt-debug-UpdateBillingRate_billingInvoiceFrequency_LB"))).selectByValue("BI_WEEKLY");

        driver.findElement(By.xpath("html/body/div[4]/div/div/div/fieldset/div/div[2]/button")).click();

        Thread.sleep(3000);

        System.out.println("billing rate updated successfully");

        driver.findElement(By.xpath("//a/table/tbody/tr/td[2]")).click();

        Thread.sleep(7000);// Wait 

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[2]/div/div[1]/div/div")).click();

        driver.findElement(By.xpath("//img[@title='View']")).click();

        new Select(driver.findElement(By.id("gwt-debug-Fill_the_form_and_complete_the_task_status_LB"))).selectByValue("approved");

        driver.findElement(By.id("gwt-debug-Fill_the_form_and_complete_the_task_itemNumber_TB")).sendKeys("1234");

        driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();

        System.out.println("Client information First level Billing task is completed");

        driver.findElement(By.xpath("//img[@title='View']")).click();

        new Select(driver.findElement(By.id("gwt-debug-Fill_the_form_and_complete_the_task_status_LB"))).selectByValue("approved");
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

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[3]/div/div[1]/div/div/div/div[2]/div/div[4]/div/div")).click();

    }
}
