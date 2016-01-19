/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa.myoffice.onboarding;

import info.yalamanchili.office.qa.AbstractOfficeTest;
import static info.yalamanchili.office.qa.AbstractOfficeTest.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 *
 * @author Uday.Yadalla
 */
public class OnBoarding extends AbstractOfficeTest {

    @Test(description = "test onboarding search", groups = "onboarding", dependsOnGroups = "login")

    public void OnBoarding() throws InterruptedException {

        driver.findElement(By.id("OnBoarding")).click();

        driver.findElement(By.xpath(".//*[@id='gwt-debug-Employee OnboardingCL']")).click();

        driver.findElement(By.id("gwt-debug-InitiateOnBoarding_email_TB")).clear();
        driver.findElement(By.id("gwt-debug-InitiateOnBoarding_email_TB")).sendKeys("udaykumar3631@gmail.com");

        WebElement from = driver.findElement(By.xpath(".//*[@id='gwt-debug-EmployeeType_employeeType_LB']"));
        Select empTypeValue = new Select(from);
        empTypeValue.selectByValue("2");

        WebElement company = driver.findElement(By.xpath(".//*[@id='gwt-debug-Company_company_LB']"));
        Select companyType = new Select(company);
        companyType.selectByValue("1");

        driver.findElement(By.xpath(".//*[@id='gwt-debug-InitiateOnBoarding_startDate_TB']")).click();
        driver.findElement(By.xpath(".//*[@id='gwt-debug-InitiateOnBoarding_startDate_TB']")).sendKeys("11/11/2015");

        WebElement branch = driver.findElement(By.xpath(".//*[@id='gwt-debug-InitiateOnBoarding_branch_LB']"));
        Select branchType = new Select(branch);
        branchType.selectByValue("Hyderabad");

        WebElement workStatus = driver.findElement(By.xpath(".//*[@id='gwt-debug-InitiateOnBoarding_workStatus_LB']"));
        Select workStatusType = new Select(workStatus);
        workStatusType.selectByValue("H1B");

        WebElement submit = driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[3]/div/div[4]/div/div/div/div/fieldset/div/div[2]/button"));
        submit.click();

        System.out.println("Invitation sent sucessfully");

        driver.findElement(By.xpath(".//*[@id='gwt-debug-Employee_firstName_TB']")).clear();
        driver.findElement(By.xpath(".//*[@id='gwt-debug-Employee_firstName_TB']")).sendKeys("uday");

        driver.findElement(By.xpath(".//*[@id='gwt-debug-Employee_lastName_TB']")).click();
        driver.findElement(By.xpath(".//*[@id='gwt-debug-Employee_lastName_TB']")).sendKeys("kumar");

        driver.findElement(By.xpath(".//*[@id='gwt-debug-Employee_dateOfBirth_TB']")).click();
        driver.findElement(By.xpath(".//*[@id='gwt-debug-Employee_dateOfBirth_TB']")).sendKeys("08/06/1994");

        WebElement gender = driver.findElement(By.xpath(".//*[@id='gwt-debug-Employee_sex_LB']"));
        Select genderType = new Select(gender);
        genderType.selectByValue("MALE");

        driver.findElement(By.id("gwt-debug-Employee_street1_TB")).click();
        driver.findElement(By.id("gwt-debug-Employee_street1_TB")).sendKeys("ashok nagar");

        driver.findElement(By.id("gwt-debug-Employee_city_TB")).click();
        driver.findElement(By.id("gwt-debug-Employee_city_TB")).sendKeys("HYDERABAD");

        driver.findElement(By.id("gwt-debug-Employee_country_LB")).click();
        driver.findElement(By.id("gwt-debug-Employee_country_LB")).sendKeys("INDIA");

        driver.findElement(By.id("gwt-debug-Employee_state_LB")).click();
        driver.findElement(By.id("gwt-debug-Employee_state_LB")).sendKeys("AL");

        driver.findElement(By.xpath(".//*[@id='gwt-debug-Employee_accountFirstName_TB']")).click();
        driver.findElement(By.xpath(".//*[@id='gwt-debug-Employee_accountFirstName_TB']")).sendKeys("UKGUPTHA");

        driver.findElement(By.xpath(".//*[@id='gwt-debug-Employee_bankName_TB']")).click();
        driver.findElement(By.xpath(".//*[@id='gwt-debug-Employee_bankName_TB']")).sendKeys("HDFC");

        driver.findElement(By.xpath(".//*[@id='gwt-debug-Employee_bankRoutingNumber_TB']")).click();
        driver.findElement(By.xpath(".//*[@id='gwt-debug-Employee_bankRoutingNumber_TB']")).sendKeys("10841084");

        driver.findElement(By.xpath(".//*[@id='gwt-debug-Employee_bankAccountNumber_TB']")).click();
        driver.findElement(By.xpath(".//*[@id='gwt-debug-Employee_bankAccountNumber_TB']")).sendKeys("366783993226");

        driver.findElement(By.xpath(".//*[@id='gwt-debug-Employee_accountType_LB']")).click();
        driver.findElement(By.xpath(".//*[@id='gwt-debug-Employee_accountType_LB']")).sendKeys("SAVINGS");

        driver.findElement(By.xpath(".//*[@id='gwt-debug-Employee_maritalStatus_LB']")).click();
        driver.findElement(By.xpath(".//*[@id='gwt-debug-Employee_maritalStatus_LB']")).sendKeys("Unmarried");

        driver.findElement(By.id("gwt-debug-Add DependentsCL")).click();

        driver.findElement(By.xpath(".//*[@id='gwt-debug-Dependent_dfirstName_TB']")).click();
        driver.findElement(By.xpath(".//*[@id='gwt-debug-Dependent_dfirstName_TB']")).sendKeys("guptha");

        driver.findElement(By.xpath(".//*[@id='gwt-debug-Dependent_ddateOfBirth_TB']")).click();
        driver.findElement(By.xpath(".//*[@id='gwt-debug-Dependent_ddateOfBirth_TB']")).sendKeys("08/06/1994");

        driver.findElement(By.xpath(".//*[@id='gwt-debug-Dependent_relationship_LB']")).click();
        driver.findElement(By.xpath(".//*[@id='gwt-debug-Dependent_relationship_LB']")).sendKeys("Nephew");

        driver.findElement(By.id("gwt-debug-Add Emergency ContactsCL")).click();

        driver.findElement(By.xpath(".//*[@id='gwt-debug-EmergencyContact_firstName_TB']")).click();
        driver.findElement(By.xpath(".//*[@id='gwt-debug-EmergencyContact_firstName_TB']")).sendKeys("venkat");

        driver.findElement(By.xpath(".//*[@id='gwt-debug-EmergencyContact_lastName_TB']")).click();
        driver.findElement(By.xpath(".//*[@id='gwt-debug-EmergencyContact_lastName_TB']")).sendKeys("test");

        driver.findElement(By.xpath(".//*[@id='gwt-debug-EmergencyContact_relation_TB']")).click();
        driver.findElement(By.xpath(".//*[@id='gwt-debug-EmergencyContact_relation_TB']")).sendKeys("Nephew");

        driver.findElement(By.xpath(".//*[@id='gwt-debug-EmergencyContact_phoneNumber_TB']")).click();
        driver.findElement(By.xpath(".//*[@id='gwt-debug-EmergencyContact_phoneNumber_TB']")).sendKeys("8523824382");

        driver.findElement(By.cssSelector("fieldset.crudCompositeCaptionPanel.y-gwt-UpdateEntityCaptionPanel > div > div.y-gwt-entityActionsPanel > button.gwt-Button")).click();

        System.out.println("Sucessfully created Employee");
        driver.close();

    }
}
