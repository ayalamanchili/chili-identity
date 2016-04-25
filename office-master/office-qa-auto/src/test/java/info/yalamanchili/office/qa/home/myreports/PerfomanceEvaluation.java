/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa.home.myreports;

import info.yalamanchili.office.qa.AbstractOfficeTest;
import static info.yalamanchili.office.qa.AbstractOfficeTest.driver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 *
 * @author Ramana.Lukalapu
 */
public class PerfomanceEvaluation extends AbstractOfficeTest{
    
    @Test(description = "test PerfomanceEvaluation", groups = "myreports", dependsOnGroups = "expense1")
    public void performance() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[2]/div/div[1]/div/div")).click();
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[2]/div/div[3]/div/div[1]/div/table/tbody/tr[5]/td/div")).click();
        driver.findElement(By.id("gwt-debug-Performance EvaluationsCL")).click();
        driver.findElement(By.xpath("html/body/div[4]/div/div/fieldset/div/span/input")).click();
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[2]/div/div[4]/div/div/div/div/fieldset/div/button")).click();
        WebElement year = driver.findElement(By.id("gwt-debug-Year_year_LB"));
        Select yearNumber = new Select(year);
        yearNumber.selectByValue("2014");
        waitForTime(20);
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[2]/div/div[4]/div/div/div/fieldset/div/fieldset/div/fieldset[1]/div/div[3]/table/tbody/tr/td[1]/textarea")).sendKeys("hello");
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[2]/div/div[4]/div/div/div/fieldset/div/fieldset/div/fieldset[2]/div/div[3]/table/tbody/tr/td[1]/textarea")).sendKeys("hello");
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[2]/div/div[4]/div/div/div/fieldset/div/fieldset/div/fieldset[3]/div/div[3]/table/tbody/tr/td[1]/textarea")).sendKeys("hello");
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[2]/div/div[4]/div/div/div/fieldset/div/fieldset/div/fieldset[4]/div/div[3]/table/tbody/tr/td[1]/textarea")).sendKeys("hello");
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[2]/div/div[4]/div/div/div/fieldset/div/button")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    
}
