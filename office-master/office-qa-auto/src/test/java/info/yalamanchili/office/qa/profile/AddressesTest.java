/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.qa.profile;

import info.yalamanchili.office.qa.AbstractOfficeTest;
import static info.yalamanchili.office.qa.AbstractOfficeTest.driver;
import static info.yalamanchili.office.qa.AbstractOfficeTest.wait;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 *
 * @author Sadipan.B
 */
public class AddressesTest extends AbstractOfficeTest {

    @Test(description = "test employee search", groups = "empsearch", dependsOnGroups = "login")
    public void testSearchEmployee() throws InterruptedException {
        System.out.println("Enter Employee Search: " + new Date());

        //wait for search box to appear
        WebElement searchTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='gwt-SuggestBox searchComposite']")));

        //wait for remaining screen loading to complete
        WebElement rowElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='y-gwt-ReadAllComposite-Row y-gwt-ReadAllComposite-OddRow']")));

        //enter search string
        searchTextBox.clear();
        searchTextBox.sendKeys("admin");
        searchTextBox.sendKeys(Keys.RETURN);

        //wait for rowElement to disappear because there are now rowelements in positive search results
        waitForStaleness(rowElement);


        System.out.println("Exit Employee Search: " + new Date());
    }

    public void testAdvanceSearchEmployee() throws InterruptedException {
    }

    @Test(description = "test create home address", groups = "empaddress", dependsOnGroups = "empsearch")
    public void testCreateAddress() throws InterruptedException {

        System.out.println("Enter Address: " + new Date());
        waitForTime(1000);

        //click link
        WebElement createAddressL = driver.findElement(By.id("gwt-debug-CL"));
        createAddressL.click();

        //populate data        
        WebElement streetone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='gwt-debug-Address_street1_TB' and @class='gwt-TextBox']")));
        streetone.clear();
        streetone.sendKeys("Address1");

        WebElement streettwo = driver.findElement(By.xpath("//input[@id='gwt-debug-Address_street2_TB' and @class='gwt-TextBox']"));
        streettwo.clear();
        streettwo.sendKeys("Address2");

        WebElement city = driver.findElement(By.xpath("//input[@id='gwt-debug-Address_city_TB' and @class='gwt-TextBox']"));
        city.clear();
        city.sendKeys("City");

        Select stateDD = new Select(driver.findElement(By.id("gwt-debug-Address_state_LB")));
        stateDD.selectByVisibleText("FL");

        Select countryDD = new Select(driver.findElement(By.id("gwt-debug-Address_country_LB")));
        countryDD.selectByVisibleText("USA");

        WebElement zipcode = driver.findElement(By.xpath("//input[@id='gwt-debug-Address_zip_TB' and @class='gwt-TextBox']"));
        zipcode.clear();
        zipcode.sendKeys("1234567");

        WebElement notifyChange = driver.findElement(By.id("gwt-debug-Address_notifyChange_CB-input"));
        notifyChange.click();

        WebElement notifyHealthInsurance = driver.findElement(By.id("gwt-debug-Address_notifyHealthInsurance_CB-input"));
        notifyHealthInsurance.click();

        WebElement changeNotes = driver.findElement(By.id("gwt-debug-Address_changeNotes_TB"));
        changeNotes.clear();
        changeNotes.sendKeys("teest");


        WebElement createB = driver.findElement(By.xpath("//button[@class='gwt-Button y-gwt-createB']"));
        createB.click();
        waitForTime(2000);

        waitForStaleness(createB);

        System.out.println("Exit Address: " + new Date());
    }

    @Test(description = "test home address task", groups = "empaddress", dependsOnGroups = "empaddress")
    public void testHomeAddressTask() throws InterruptedException {

        System.out.println("Approved for task: " + new Date());
        waitForTime(1000);

        WebElement TabLayoutPanel = driver.findElement(By.cssSelector("div.gwt-TabLayoutPanelTabInner > div.gwt-Label"));
        TabLayoutPanel.click();

        WebElement view = driver.findElement(By.xpath("//img[@title='view']"));
        view.click();

        WebElement payrollDeptNotes = driver.findElement(By.id("gwt-debug-Fill_the_form_and_complete_the_task_payrollDeptNotes_TB"));
        payrollDeptNotes.clear();
        payrollDeptNotes.sendKeys("tested");

        WebElement createb = driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB"));
        createb.click();

        WebElement viewb = driver.findElement(By.xpath("//img[@title='view']"));
        viewb.click();

        WebElement hrAdminDeptNotes = driver.findElement(By.id("gwt-debug-Fill_the_form_and_complete_the_task_hrAdminDeptNotes_TB"));
        hrAdminDeptNotes.clear();
        hrAdminDeptNotes.sendKeys("approved");

        WebElement createB = driver.findElement(By.cssSelector("button.gwt-Button.y-gwt-createB"));
        createB.click();

        System.out.println("Exit task: " + new Date());
    }

    @Test(description = "test other address task", groups = "addresstask", dependsOnGroups = "empsearch")
    public void testOtherAddressTask() throws InterruptedException {

        System.out.println("Approved for task: " + new Date());
        waitForTime(1000);

        //click link
        WebElement createAddressL = driver.findElement(By.id("gwt-debug-CL"));
        createAddressL.click();

        //populate data        
        WebElement streetone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='gwt-debug-Address_street1_TB' and @class='gwt-TextBox']")));
        streetone.clear();
        streetone.sendKeys("Address1");

        WebElement streettwo = driver.findElement(By.xpath("//input[@id='gwt-debug-Address_street2_TB' and @class='gwt-TextBox']"));
        streettwo.clear();
        streettwo.sendKeys("Address2");

        WebElement city = driver.findElement(By.xpath("//input[@id='gwt-debug-Address_city_TB' and @class='gwt-TextBox']"));
        city.clear();
        city.sendKeys("City");

        Select stateDD = new Select(driver.findElement(By.id("gwt-debug-Address_state_LB")));
        stateDD.selectByVisibleText("FL");

        Select countryDD = new Select(driver.findElement(By.id("gwt-debug-Address_country_LB")));
        countryDD.selectByVisibleText("USA");

        WebElement zipcode = driver.findElement(By.xpath("//input[@id='gwt-debug-Address_zip_TB' and @class='gwt-TextBox']"));
        zipcode.clear();
        zipcode.sendKeys("1234567");

        Select addressType = new Select(driver.findElement(By.id("gwt-debug-AddressType_addressType_LB")));
        addressType.selectByVisibleText("Other");

        WebElement createB = driver.findElement(By.xpath("//button[@class='gwt-Button y-gwt-createB']"));
        createB.click();
        waitForTime(2000);

        waitForStaleness(createB);

        System.out.println("Exit task: " + new Date());
    }
}
