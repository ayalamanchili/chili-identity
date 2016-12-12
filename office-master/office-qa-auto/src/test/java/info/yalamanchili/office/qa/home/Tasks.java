/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa.home;

import info.yalamanchili.office.qa.AbstractOfficeTest;
import static info.yalamanchili.office.qa.AbstractOfficeTest.driver;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 *
 * @author Sadipan.B
 */
public class Tasks extends AbstractOfficeTest {

    @Test(description = "testMyTasks", groups = "tasks", dependsOnGroups = "myReports", priority = 1)
    public void testMyTasks() throws InterruptedException, IOException {

        System.out.println("Enter Tasks_MyTasks: " + new Date());
        
        driver.navigate().refresh();
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("div.gwt-TabLayoutPanelTabInner > div.gwt-Label")).click();
        waitForLoader();
        Thread.sleep(2000);

        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[2]/div/div[3]/div/div[1]/div/table/tbody/tr[1]/td/div")).click();
        driver.findElement(By.id("gwt-debug-My TasksCL")).click();
        waitForLoader();
        Thread.sleep(2000);

        takeScreenshot("Tasks_MyTasks");
        System.out.println("Exit Tasks_MyTasks: " + new Date());
    }

    @Test(description = "testCompleteMyTasks", groups = "tasks", dependsOnGroups = "myReports", priority = 2)
    public void testCompleteMyTasks() throws InterruptedException, IOException {

        System.out.println("Enter Tasks_ComppleteMyTasks: " + new Date());

        driver.findElement(By.xpath("//td/table/tbody/tr/td[2]/img")).click();
        waitForLoader();
        Thread.sleep(2000);
        
        WebElement element = driver.findElement(By.id("gwt-debug-Fill_the_form_and_complete_the_task_status_LB"));
        Select status = new Select(element);
        status.selectByVisibleText("approved");
        driver.findElement(By.id("gwt-debug-Fill_the_form_and_complete_the_task_notes_TB")).sendKeys("Approved");

        driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
        waitForLoader();
        Thread.sleep(2000);

        takeScreenshot("Tasks_CompleteMyTasks");
        System.out.println("Exit Tasks_CompleteMyTasks: " + new Date());
    }

    @Test(description = "testCompletedTasks", groups = "tasks", dependsOnGroups = "myReports", priority = 3)
    public void testViewStatusReport() throws InterruptedException, IOException {

        System.out.println("Enter Tasks_CompletedTasks: " + new Date());

        driver.findElement(By.id("gwt-debug-Completed TasksCL")).click();
        waitForLoader();
        Thread.sleep(2000);

        takeScreenshot("Tasks__CompletedTasks");
        System.out.println("Exit Tasks_CompletedTasks: " + new Date());
    }

    @Test(description = "testAllTasks", groups = "tasks", dependsOnGroups = "myReports", priority = 4)
    public void testAllTasks() throws InterruptedException, IOException {

        System.out.println("Enter Tasks_AllTasks: " + new Date());

        driver.findElement(By.id("gwt-debug-All TasksCL")).click();
        waitForLoader();
        Thread.sleep(2000);

        takeScreenshot("Tasks_AllTasks_");
        System.out.println("Exit Tasks_AllTasks: " + new Date());
    }

    @Test(description = "testSearchTasks", groups = "tasks", dependsOnGroups = "myReports", priority = 5)
    public void testSearchTasks() throws InterruptedException, IOException {

        System.out.println("Enter Tasks_SearchTasks: " + new Date());

        driver.findElement(By.id("gwt-debug-Task_taskOwner_TB")).sendKeys("admin admin");
        driver.findElement(By.cssSelector("button.gwt-Button")).click();
        waitForLoader();
        Thread.sleep(2000);

        takeScreenshot("Tasks_SearchTasks");
        System.out.println("Exit Tasks_SearchTasks: " + new Date());
    }

}
