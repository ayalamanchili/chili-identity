/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.integration.profile;

import info.yalamanchili.office.integration.AbstractOfficeTest;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author ayalamanchili
 */
public class CreateEmployeeTest extends AbstractOfficeTest {

    @BeforeClass
    public static void init() {
        driver = new FirefoxDriver();
    }

    @Test
    public void testCreateEmployee() throws InterruptedException {
        login(ADMIN, ADMIN);
        //click link
        WebElement createEmployeeL = driver.findElement(By.id("gwt-debug-Create EmployeeCL"));
        createEmployeeL.click();
        System.out.println("ddddd" + new Date());
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
        System.out.println("fggfff" + new Date());
//        WebDriverWait wait = new WebDriverWait(driver, 2);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gwt-debug-Employee_firstName_TB")));
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("gwt-debug-Employee_firstName_TB")));
        ///populate data
//        WebElement employeeTypeDD = driver.findElement(By.id("gwt-debug-EmployeeType_employeeType_LB"));

        WebElement employeefirstNameF = driver.findElement(By.id("gwt-debug-Employee_firstName_TB"));
        System.out.println("ddddd" + employeefirstNameF.toString());
        System.out.println("ddddd" + employeefirstNameF.isDisplayed());
        System.out.println("ddddd" + employeefirstNameF.isEnabled());
        System.out.println("d" + driver.getPageSource());
        employeefirstNameF.click();
        employeefirstNameF.sendKeys("testemp");

        WebElement createB = driver.findElement(By.linkText("create"));
        createB.click();
    }

    @AfterClass
    public static void destroy() {
        driver.close();
    }
}
