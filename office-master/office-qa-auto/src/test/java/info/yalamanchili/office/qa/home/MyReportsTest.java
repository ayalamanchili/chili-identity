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
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 *
 * @author Sadipan.B
 */
public class MyReportsTest extends AbstractOfficeTest {

    @Test(description = "test status reort task", groups = "empstatusreport", dependsOnGroups = "empstatusreport")
    public void testStatusRportTask() throws InterruptedException {

        System.out.println("Enter Status Report: " + new Date());
        waitForTime(1000);

        WebElement TabLayoutPanel = driver.findElement(By.cssSelector("div.gwt-TabLayoutPanelTabInner > div.gwt-Label"));
        TabLayoutPanel.click();

        WebElement tabpamel = driver.findElement(By.cssSelector("div.gwt-TabLayoutPanelTabInner > div.gwt-Label"));
        tabpamel.click();
        driver.findElement(By.xpath("//tr[5]/td/div")).click();
        driver.findElement(By.id("gwt-debug-Status ReportsCL")).click();
        driver.findElement(By.cssSelector("div.GI3B043CCJ > div > fieldset.readAllCompositeCaptionPanel > div.y-gwt-ReadAllPanel > button.gwt-Button")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_projectDescription_TB")).clear();
        driver.findElement(By.id("gwt-debug-StatusReport_projectDescription_TB")).sendKeys("Enter project name");
        driver.findElement(By.id("gwt-debug-StatusReport_reportStartDate_TB")).click();
        driver.findElement(By.xpath("//td/table/tbody/tr[3]/td[3]")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_reportEndDate_TB")).click();
        driver.findElement(By.xpath("//td/table/tbody/tr[5]/td[3]")).click();
        new Select(driver.findElement(By.id("gwt-debug-StatusReport_status_LB"))).selectByVisibleText("OnSchedule");
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1Name_TB")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1Name_TB")).clear();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1Name_TB")).sendKeys("phase1");
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1Deliverable_TB")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1Deliverable_TB")).clear();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1Deliverable_TB")).sendKeys("working");
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1EndDate_TB")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1EndDate_TB")).clear();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1EndDate_TB")).sendKeys("05/2/2015");
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1Status_TB")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1Status_TB")).clear();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase1Status_TB")).sendKeys("80%");
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2Name_TB")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2Name_TB")).clear();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2Name_TB")).sendKeys("completed");
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2Deliverable_TB")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2Deliverable_TB")).clear();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2Deliverable_TB")).sendKeys("worked");
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2EndDate_TB")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2EndDate_TB")).clear();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2EndDate_TB")).sendKeys("03/7/2015");
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2Status_TB")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2Status_TB")).clear();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase2Status_TB")).sendKeys("70%");
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3Name_TB")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3Name_TB")).clear();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3Name_TB")).sendKeys("testing");
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3Deliverable_TB")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3Deliverable_TB")).clear();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3Deliverable_TB")).sendKeys("completed");
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3EndDate_TB")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3EndDate_TB")).clear();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3EndDate_TB")).sendKeys("04/7/2015");
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3Status_TB")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3Status_TB")).clear();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase3Status_TB")).sendKeys("60");
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4Name_TB")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4Name_TB")).clear();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4Name_TB")).sendKeys("ust");
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4Deliverable_TB")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4Deliverable_TB")).clear();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4Deliverable_TB")).sendKeys("finished");
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4EndDate_TB")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4EndDate_TB")).clear();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4EndDate_TB")).sendKeys("03/7/2015");
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4Status_TB")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4Status_TB")).clear();
        driver.findElement(By.id("gwt-debug-StatusReport_projectPhase4Status_TB")).sendKeys("90");
        driver.findElement(By.id("gwt-debug-StatusReport_statusDescription_TB")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_statusDescription_TB")).clear();
        driver.findElement(By.id("gwt-debug-StatusReport_statusDescription_TB")).sendKeys("worked");
        driver.findElement(By.id("gwt-debug-StatusReport_accomplishments_TB")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_accomplishments_TB")).clear();
        driver.findElement(By.id("gwt-debug-StatusReport_accomplishments_TB")).sendKeys("worked");
        driver.findElement(By.id("gwt-debug-StatusReport_scheduledActivities_TB")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_scheduledActivities_TB")).clear();
        driver.findElement(By.id("gwt-debug-StatusReport_scheduledActivities_TB")).sendKeys("worked");
        driver.findElement(By.id("gwt-debug-StatusReport_approvedBy_TB")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_preparedBy_TB")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_preparedBy_TB")).clear();
        driver.findElement(By.id("gwt-debug-StatusReport_preparedBy_TB")).sendKeys("pponnaganti");
        driver.findElement(By.id("gwt-debug-StatusReport_approvedBy_TB")).clear();
        driver.findElement(By.id("gwt-debug-StatusReport_approvedBy_TB")).sendKeys("pponnaganti");
        driver.findElement(By.id("gwt-debug-StatusReport_submittedDate_TB")).click();
        driver.findElement(By.xpath("//td/table/tbody/tr[2]/td[3]")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_preview_CB-input")).click();
        driver.findElement(By.id("gwt-debug-StatusReport_submitForApproval_CB-input")).click();

        WebElement createB = driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB"));
        createB.click();

        System.out.println("Exit Status Report: " + new Date());
    }

    @Test(description = "test status report task", groups = "empstatusreport", dependsOnGroups = "empstatusreport")
    public void testStatusReportTask() throws InterruptedException {

        System.out.println("Approved for task: " + new Date());
        waitForTime(1000);

        WebElement TabLayoutPanel = driver.findElement(By.cssSelector("div.gwt-TabLayoutPanelTabInner > div.gwt-Label"));
        TabLayoutPanel.click();

        WebElement view = driver.findElement(By.xpath("//img[@title='view']"));
        view.click();

        new Select(driver.findElement(By.id("gwt-debug-Fill_the_form_and_complete_the_task_status_LB"))).selectByVisibleText("approved");
        driver.findElement(By.id("gwt-debug-Fill_the_form_and_complete_the_task_notes_TB")).clear();
        driver.findElement(By.id("gwt-debug-Fill_the_form_and_complete_the_task_notes_TB")).sendKeys("tested");
        driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
        driver.findElement(By.xpath("//img[@title='view']")).click();
        driver.findElement(By.id("gwt-debug-Fill_the_form_and_complete_the_task_notes_TB")).clear();
        driver.findElement(By.id("gwt-debug-Fill_the_form_and_complete_the_task_notes_TB")).sendKeys("approved");

        WebElement createB = driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB"));
        createB.click();

        System.out.println("Exit task: " + new Date());
    }
}
