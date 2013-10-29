/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.integration.profile;

import info.yalamanchili.office.integration.AbstractOfficeTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author ayalamanchili
 */
public class EmployeeSearchTest extends AbstractOfficeTest {

    @BeforeClass
    public static void init() {
        driver = new FirefoxDriver();
    }

    @Test
    public void testAdminEmpSearch() throws InterruptedException {
        login(ADMIN, ADMIN);
        WebElement searchTextBox = driver.findElement(By.xpath("//*[@class='gwt-SuggestBox searchComposite']"));
        searchTextBox.sendKeys("admin");
        searchTextBox.sendKeys(Keys.RETURN);
        waitFor(10);
        WebElement resultsTable = driver.findElement(By.xpath("//*[@class='y-gwt-Table']"));
       for(WebElement row:resultsTable.findElements(By.xpath("//*[@class='y-gwt-ReadAllComposite-Row y-gwt-ReadAllComposite-OddRow']"))){
           System.out.println("dddd"+row);
       }
//        int results = resultsTable.findElements(By.xpath("//*[@class='y-gwt-ReadAllComposite-Row y-gwt-ReadAllComposite-OddRow']")).size();
//        System.out.println("dddddddd"+results);
    }
    
    @AfterClass
    public static void destroy() {
        driver.close();
    }
}
