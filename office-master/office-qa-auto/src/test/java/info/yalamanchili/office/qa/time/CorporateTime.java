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
public class CorporateTime {
    
     @Test(description = "test corporate", groups = "leave", dependsOnGroups = "myreports")
    public void corporateTime() throws InterruptedException {

        driver.findElement(By.id("Corporate Time")).click();
        WebElement searchTextBox = driver.findElement(By.id("gwt-debug-Employee_employee_TB"));
        searchTextBox.sendKeys("admin admin");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        searchTextBox.sendKeys(Keys.ENTER);
        WebElement category = driver.findElement(By.id("gwt-debug-CorpEmpLeaveRequest_category_LB"));
        Select sBusValue = new Select(category);
        sBusValue.selectByValue("Unpaid");
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[4]/div/div[3]/div/div[1]/div/div/fieldset[1]/div/button")).click();
        
    }
    
}
