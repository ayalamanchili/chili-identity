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
import org.testng.annotations.Test;

/**
 *
 * @author Ramana.Lukalapu
 */
public class Attendance {
    
    @Test(description = "test Attendance", groups = "leave", dependsOnGroups = "myreports")
    public void employeeTime() throws InterruptedException {
        driver.findElement(By.id("Attendance")).click();
        driver.findElement(By.id("gwt-debug-CorporateTimeSheet_startDate_TB")).sendKeys("03/21/2016");
        driver.findElement(By.id("gwt-debug-CorporateTimeSheet_endDate_TB")).sendKeys("03/30/2016");
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[4]/div/div[3]/div/div[1]/div/div/button")).click();
    }
    
}
