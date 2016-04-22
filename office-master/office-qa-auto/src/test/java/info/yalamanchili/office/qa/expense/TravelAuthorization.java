/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa.expense;

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
public class TravelAuthorization {

    @Test(description = "test TravelAuthrization", groups = "expense", dependsOnGroups = "login")
    public void travelAuthorize() throws InterruptedException {
        driver.findElement(By.id("Travel Authorization")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("html/body/div[4]/div/div/fieldset/div/span/input")).click();
        driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[4]/div/div/div[3]/div/div[5]/div/div[4]/div/div/div/div/fieldset/div/button")).click();
        WebElement travelType = driver.findElement(By.id("gwt-debug-TravelAuthorization_travelType_LB"));
        Select travelName = new Select(travelType);
        travelName.selectByValue("OUT_OF_STATE");
        driver.findElement(By.id("gwt-debug-TravelAuthorization_departureDate_TB")).sendKeys("03/24/2016");
        driver.findElement(By.id("gwt-debug-TravelAuthorization_returnDate_TB")).sendKeys("03/29/2016");
        driver.findElement(By.id("gwt-debug-TravelAuthorization_travelOrigin_TB")).sendKeys("Mumbai");
        driver.findElement(By.id("gwt-debug-TravelAuthorization_travelDestination_TB")).sendKeys("Tampa");
        driver.findElement(By.id("gwt-debug-TravelAuthorization_reasonForTravel_TB")).sendKeys("for office");
        WebElement transportType = driver.findElement(By.id("gwt-debug-TravelAuthorization_travelTransportationType_LB"));
        Select transportName = new Select(transportType);
        transportName.selectByValue("COMPANY_VEHICLE");
        driver.findElement(By.id("gwt-debug-TravelAuthorization_totalTransportationCost_TB")).sendKeys("15250");
        WebElement paymentTransport = driver.findElement(By.id("gwt-debug-TravelAuthorization_expensePaymentType_LB"));
        Select modeName = new Select(paymentTransport);
        modeName.selectByValue("PURCHASING_CARD");
        driver.findElement(By.id("gwt-debug-TravelAuthorization_numberOfLodgingNights_TB")).sendKeys("3");
        driver.findElement(By.id("gwt-debug-TravelAuthorization_totalLodgingCost_TB")).sendKeys("50000");
        WebElement paymentLodging = driver.findElement(By.id("gwt-debug-TravelAuthorization_expenseAccommodationPaymentType_LB"));
        Select lodgeName = new Select(paymentLodging);
        lodgeName.selectByValue("EMPLOYEE_EXPENSE");
        driver.findElement(By.id("gwt-debug-TravelAuthorization_totalCostOfFood_TB")).sendKeys("45000");
        WebElement paymentFood = driver.findElement(By.id("gwt-debug-TravelAuthorization_expenseAccommodationPaymentType_LB"));
        Select modeFoodName = new Select(paymentFood);
        modeFoodName.selectByValue("PURCHASING_CARD");
        driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB")).click();
    }

}
