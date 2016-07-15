/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa.profile;

import com.sun.glass.events.KeyEvent;
import info.yalamanchili.office.qa.AbstractOfficeTest;
import static info.yalamanchili.office.qa.AbstractOfficeTest.driver;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 *
 * @author joel kolli
 */
public class Profile extends AbstractOfficeTest {

    @Test(description = "Profile view", groups = "profile", dependsOnGroups = "company", priority = 1)
    public void testViewProfile() throws InterruptedException, IOException {
        System.out.println("Enter Profile view: " + new Date());

        driver.findElement(By.xpath("//div[8]/div/div")).click();
        takeScreenshot("profileTest_View");
        System.out.println("Exit Profile view: " + new Date());
    }

    @Test(description = "Profile update", groups = "profile", dependsOnGroups = "company", priority = 2)
    public void testUpdateProfile() throws InterruptedException, IOException, AWTException {
        System.out.println("Enter Profile Update: " + new Date());

        driver.findElement(By.linkText("Update Profile")).click();
        waitForTime(10);

        driver.findElement(By.xpath("//table[7]/tbody/tr/td[2]/table/tbody/tr/td/input")).clear();
        driver.findElement(By.xpath("//table[7]/tbody/tr/td[2]/table/tbody/tr/td/input")).sendKeys("Consultant");

        driver.findElement(By.xpath("//table[10]/tbody/tr/td[2]/table/tbody/tr/td/input")).clear();
        driver.findElement(By.xpath("//table[10]/tbody/tr/td[2]/table/tbody/tr/td/input")).sendKeys("123456789");

        driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-updateB")).click();
        waitForTime(10);
        Thread.sleep(3000);

        System.out.println("Exit Profile Update: " + new Date());
        
    }

    @Test(description = "Password change", groups = "profile", dependsOnGroups = "company", priority = 3, enabled=false)
    public void testPasswordChange() throws InterruptedException, IOException {
        System.out.println("Enter Password Change: " + new Date());

        driver.findElement(By.linkText("Change Password")).click();
        waitForTime(10);

        driver.findElement(By.id("gwt-debug-ChangePassword_oldPassword_PTB")).sendKeys("adminadmin");
        driver.findElement(By.id("gwt-debug-ChangePassword_newPassword_PTB")).sendKeys("adminjoel");
        driver.findElement(By.id("gwt-debug-ChangePassword_confirmPassword_PTB")).sendKeys("adminjoel");

        driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
        waitForTime(10);

        System.out.println("Exit Password Change: " + new Date());
    }
}