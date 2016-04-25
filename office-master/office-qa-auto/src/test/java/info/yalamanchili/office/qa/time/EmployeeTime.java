/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa.time;

import static info.yalamanchili.office.qa.AbstractOfficeTest.driver;
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
public class EmployeeTime {
    
    @Test(description = "test employeetime", groups = "leave", dependsOnGroups = "myreports")
    public void employeeTime() throws InterruptedException {

        driver.findElement(By.id("Employee Time")).click();
        WebElement searchTextBox = driver.findElement(By.id("gwt-debug-Employee_employee_TB"));
        searchTextBox.sendKeys("Pavan Kumar Adapala ");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        searchTextBox.sendKeys(Keys.ENTER);
        driver.findElement(By.linkText("Summary Report")).click();
    }
}
