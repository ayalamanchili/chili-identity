/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa.myoffice;

import info.yalamanchili.office.qa.AbstractOfficeTest;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 *
 * @author Sadipan.B
 */
public class EmployeesTest extends AbstractOfficeTest {

    @Test(description="test employee search",groups="empsearch",dependsOnGroups="login")
    public void testSearchEmployee() throws InterruptedException {
        System.out.println("Enter Employee Search: " + new Date());                
        
        //wait for search box to appear
        WebElement searchTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='gwt-SuggestBox searchComposite']")));
        
        //wait for remaining screen loading to complete
        WebElement rowElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='y-gwt-ReadAllComposite-Row y-gwt-ReadAllComposite-OddRow']")));
        
        //enter search string
        searchTextBox.clear();
        searchTextBox.sendKeys("admin");
        searchTextBox.sendKeys(Keys.RETURN);
        
        //wait for rowElement to disappear because there are now rowelements in positive search results
        waitForStaleness(rowElement);
        
                                  
        System.out.println("Exit Employee Search: " + new Date());
    }
    
//    @Test(description="test employee search",groups="empsearch",dependsOnGroups="login")
    public void testAdvanceSearchEmployee() throws InterruptedException {
        
    }
    
    @Test(description="test create employee",groups="empcreate",dependsOnGroups="empsearch")
    public void testCreateEmployee() throws InterruptedException {
        
        System.out.println("Enter Employee Create: " + new Date());
        waitForTime(1000);
        
        //click link
        WebElement createEmployeeL = driver.findElement(By.id("gwt-debug-Create EmployeeCL"));
        createEmployeeL.click();
        
        //populate data        
        Select employeeTypeDD = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gwt-debug-EmployeeType_employeeType_LB"))));
        employeeTypeDD.selectByVisibleText("Employee");

        WebElement employeeFirstNameF = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='gwt-debug-Employee_firstName_TB' and @class='gwt-TextBox']")));        
        employeeFirstNameF.clear();
        employeeFirstNameF.sendKeys("TestFirstName");
        
        WebElement employeeMiddleInitialF = driver.findElement(By.xpath("//input[@id='gwt-debug-Employee_middleInitial_TB' and @class='gwt-TextBox']"));
        employeeMiddleInitialF.clear();
        employeeMiddleInitialF.sendKeys("TestMiddleName");        
        
        WebElement employeeLastNameF = driver.findElement(By.xpath("//input[@id='gwt-debug-Employee_lastName_TB' and @class='gwt-TextBox']"));
        employeeLastNameF.clear();
        employeeLastNameF.sendKeys("TestLastName");
        
        WebElement employeeEmailF = driver.findElement(By.xpath("//input[@id='gwt-debug-Employee_email_TB']"));
        employeeEmailF.clear();
        employeeEmailF.sendKeys("tfn.tln@gmail.com");
        
        WebElement employeeDateOfBirthF = driver.findElement(By.xpath("//input[@id='gwt-debug-Employee_dateOfBirth_TB']"));
        employeeDateOfBirthF.clear();
        employeeDateOfBirthF.sendKeys("01/01/1991");
        
        Select employeeGenderDD = new Select(driver.findElement(By.id("gwt-debug-Employee_sex_LB")));
        employeeGenderDD.selectByVisibleText("Male");
        
        WebElement employeeStartDateF = driver.findElement(By.xpath("//input[@id='gwt-debug-Employee_startDate_TB']"));
        employeeStartDateF.clear();
        employeeStartDateF.sendKeys("01/01/2015");
        
        WebElement employeePasswordF = driver.findElement(By.xpath("//input[@id='gwt-debug-Employee_passwordHash_PTB']"));
        employeePasswordF.clear();
        employeePasswordF.sendKeys("Pwd123$");
        
        WebElement employeeJobTitleF = driver.findElement(By.xpath("//input[@id='gwt-debug-Employee_jobTitle_TB']"));
        employeeJobTitleF.clear();
        employeeJobTitleF.sendKeys("Manager");
                
        //following code is commented because there are two branch fields in DOM and selenium got confused
//        Select employeeBranchDD = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gwt-debug-Employee_branch_LB"))));
//        employeeBranchDD.selectByVisibleText("Tampa");
        
        Select employeeWorkStatusDD = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gwt-debug-Employee_workStatus_LB"))));
        employeeWorkStatusDD.selectByVisibleText("Citizen");

        Select employeeCompanyDD = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gwt-debug-Company_company_LB"))));
        employeeCompanyDD.selectByVisibleText("CGS");

        WebElement employeeSSNF = driver.findElement(By.xpath("//input[@id='gwt-debug-Employee_ssn_TB']"));
        employeeSSNF.clear();
        employeeSSNF.sendKeys("111111111");
                        
        WebElement createB = driver.findElement(By.xpath("//button[@class='gwt-Button y-gwt-createB']"));
        createB.click();
        waitForTime(2000);

        waitForStaleness(createB);

        System.out.println("Exit Employee Create: " + new Date());
    }    
    
}
