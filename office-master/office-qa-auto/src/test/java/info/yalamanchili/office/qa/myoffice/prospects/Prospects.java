/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa.myoffice.prospects;

import info.yalamanchili.office.qa.AbstractOfficeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 *
 * @author Uday.Yadalla
 */
public class Prospects extends AbstractOfficeTest {

    @Test(description = "test prospects search", groups = "prospects", dependsOnGroups = "login")

    public void prospects() throws InterruptedException {

        driver.findElement(By.xpath(".//*[@id='Prospects']")).click();

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/button")).click();

        driver.findElement(By.xpath("(//input[@id='gwt-debug-Prospect_firstName_TB'])[2]")).clear();
        driver.findElement(By.xpath("(//input[@id='gwt-debug-Prospect_firstName_TB'])[2]")).sendKeys("uday");

        driver.findElement(By.xpath("(//input[@id='gwt-debug-Prospect_lastName_TB'])[2]")).clear();
        driver.findElement(By.xpath("(//input[@id='gwt-debug-Prospect_lastName_TB'])[2]")).sendKeys("kumar");

        driver.findElement(By.xpath("(//input[@id='gwt-debug-Prospect_referredBy_TB'])[2]")).clear();
        driver.findElement(By.xpath("(//input[@id='gwt-debug-Prospect_referredBy_TB'])[2]")).sendKeys("guptha");

        driver.findElement(By.id("gwt-debug-Prospect_email_TB")).clear();
        driver.findElement(By.id("gwt-debug-Prospect_email_TB")).sendKeys("udaykumar331166@gmail.com");

        driver.findElement(By.id("gwt-debug-Prospect_countryCode_TB")).click();
        driver.findElement(By.id("gwt-debug-Prospect_countryCode_TB")).sendKeys("91");

        driver.findElement(By.id("gwt-debug-Prospect_phoneNumber_TB")).clear();
        driver.findElement(By.id("gwt-debug-Prospect_phoneNumber_TB")).sendKeys("9492873631");

        driver.findElement(By.xpath(".//*[@id='gwt-debug-Prospect_dateOfBirth_TB'] ")).click();
        driver.findElement(By.xpath(".//*[@id='gwt-debug-Prospect_dateOfBirth_TB'] ")).sendKeys("08/06/1994");

        driver.findElement(By.id("gwt-debug-Prospect_street1_TB")).click();
        driver.findElement(By.id("gwt-debug-Prospect_street1_TB")).sendKeys("ashok nagar");

        driver.findElement(By.id("gwt-debug-Prospect_street2_TB")).click();
        driver.findElement(By.id("gwt-debug-Prospect_street2_TB")).sendKeys("ASHOK NAGAR");

        driver.findElement(By.id("gwt-debug-Prospect_city_TB")).click();
        driver.findElement(By.id("gwt-debug-Prospect_city_TB")).sendKeys("HYDERABAD");

        driver.findElement(By.id("gwt-debug-Prospect_country_LB")).click();
        driver.findElement(By.id("gwt-debug-Prospect_country_LB")).sendKeys("INDIA");

        driver.findElement(By.id("gwt-debug-Prospect_state_LB")).click();
        driver.findElement(By.id("gwt-debug-Prospect_state_LB")).sendKeys("AL");

        driver.findElement(By.id("gwt-debug-Prospect_zip_TB")).click();
        driver.findElement(By.id("gwt-debug-Prospect_zip_TB")).sendKeys("36311");

        driver.findElement(By.id("gwt-debug-Prospect_screenedBy_TB")).click();
        driver.findElement(By.id("gwt-debug-Prospect_screenedBy_TB")).sendKeys("AL");

        driver.findElement(By.xpath("(//input[@id='gwt-debug-Prospect_processDocSentDate_TB'])[2]")).click();
        driver.findElement(By.xpath("(//input[@id='gwt-debug-Prospect_processDocSentDate_TB'])[2]")).sendKeys("08/06/2015");

        driver.findElement(By.id("gwt-debug-Prospect_comment_TB")).click();
        driver.findElement(By.id("gwt-debug-Prospect_comment_TB")).sendKeys("every thing is working fine");

        WebElement submit = driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div[2]/button"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        submit.click();
        
        System.out.println("Prospect created sucessfully");

        new Select(driver.findElement(By.xpath("(//select[@id='gwt-debug-Prospect_status_LB'])[3]"))).selectByVisibleText("Closed Won");
        driver.findElement(By.xpath("(//option[@value='CLOSED_WON'])[3]")).click();

        driver.findElement(By.cssSelector("div.y-gwt-entityActionsPanel > button.gwt-Button")).click();
        System.out.println("Prospect updated sucessfully");

        driver.findElement(By.id("Prospects")).click();

        driver.findElement(By.id("gwt-debug-OnBoarding invitecodeCL")).click();

        WebElement empType = driver.findElement(By.xpath(".//*[@id='gwt-debug-EmployeeType_employeeType_LB']"));
        Select empTypeType = new Select(empType);
        empTypeType.selectByValue("2");

        WebElement company = driver.findElement(By.xpath(".//*[@id='gwt-debug-Company_company_LB']"));
        Select companyType = new Select(company);
        companyType.selectByValue("1");

        driver.findElement(By.xpath(".//*[@id='gwt-debug-InitiateOnBoarding_startDate_TB']")).click();
        driver.findElement(By.xpath(".//*[@id='gwt-debug-InitiateOnBoarding_startDate_TB']")).sendKeys("08/06/2015");

        driver.findElement(By.id("gwt-debug-InitiateOnBoarding_branch_LB")).click();
        driver.findElement(By.id("gwt-debug-InitiateOnBoarding_branch_LB")).sendKeys("Hyderabad");

        driver.findElement(By.id("gwt-debug-InitiateOnBoarding_workStatus_LB")).click();
        driver.findElement(By.id("gwt-debug-InitiateOnBoarding_workStatus_LB")).sendKeys("H1B");

        WebElement create = driver.findElement(By.xpath("html/body/div[4]/div/div/div/fieldset/div/div[2]/button"));
        create.click();
        
        System.out.println("Invitation sent sucessfully");

    }
}
